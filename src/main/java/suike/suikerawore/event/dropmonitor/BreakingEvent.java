package suike.suikerawore.event.dropmonitor;

import java.io.File;
import java.util.Set;
import java.util.HashSet;
import java.util.regex.Pattern;

import suike.suikerawore.SuiKe;
import suike.suikerawore.item.ItemBase;
import suike.suikerawore.item.BlockBase;
import suike.suikerawore.config.ConfigValue;
import suike.suikerawore.expand.Examine;
import suike.suikerawore.expand.mekanism.MekanismExpand;
import suike.suikerawore.event.dropmonitor.drop.Drop;

import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.enchantment.EnchantmentHelper;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.ExplosionEvent;

@Mod.EventBusSubscriber
public class BreakingEvent {

    public static ItemStack lastDrop = ItemStack.EMPTY;
    public static IBlockState lastBlock = BlockBase.RAW_BLOCK_GOLD.getDefaultState();
    public static BlockEvent.HarvestDropsEvent Event;

    // 被爆破的方块位置信息
    private static final Set<BlockPos> explosionAffectedBlocks = new HashSet<>();

    public static String way = "isEntity"; // 破坏方式
    public static int fortuneLevel = 0; // 时运等级
    public static int refiningLevel = 0; // 炽心附魔等级
    public static boolean smelt = false; // 自动熔炼
    public static boolean dense = false; // 致密矿石挖掘

    private static void resetVariables(String blockOreDict) {
        way = "isEntity";
        fortuneLevel = 0;
        refiningLevel = 0;
        smelt = false;
        dense = blockOreDict.endsWith("Dense"); // 矿词是否以 Dense 结尾
    }

    @SubscribeEvent
    public static void onExplosionDetonate(ExplosionEvent.Detonate event) {
        // 清空爆炸列表
        explosionAffectedBlocks.clear();
        // 获取被爆炸影响的所有方块
        explosionAffectedBlocks.addAll(event.getAffectedBlocks());
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onHarvestDrops(BlockEvent.HarvestDropsEvent event) {
        // 获取被破坏方块的信息
        IBlockState blockState = event.getState();

        // blockState 为空
        if (blockState == null)  return;

        // 获取挖掘的方块
        Block block = blockState.getBlock();

        // 获取方块栈堆
        ItemStack blockStack = new ItemStack(block, 1, block.getMetaFromState(blockState));

        // 获取方块矿词
        String blockOreDict = ItemBase.getItemOreDict(blockStack, "ore");

        // 无矿词 || 矿词不以 ore 开头 || 是煤矿
        if (blockOreDict == null || blockOreDict.endsWith("Coal")) return; 

        // 获取破坏者
        Entity harvester = event.getHarvester();

        // 重置变量
        resetVariables(blockOreDict);

        // 破坏者不为空
        if (harvester != null) {
            if (Examine.MekanismID && harvester.getClass().getSimpleName().equals("MekFakePlayer")){
                // 是实体 MekFakePlayer 破坏
                if (MekanismExpand.isMek(event)) return; // 精准采集
            }
            else if (harvester instanceof EntityPlayer) {
                EntityPlayer player = (EntityPlayer) harvester;
                // 检查是否拥有精准采集
                if (EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, player.getHeldItemMainhand()) > 0) return;

                // 检查挖掘工具
                HandHold.itemExamine(player.getHeldItemMainhand());
                if (way.equals("hasEnderpickupEnch")) return; // 有存入升级附魔
            }
        }
        else if (explosionAffectedBlocks.contains(event.getPos())) {
            way = "isExplosion"; // 爆炸破坏: 方式字段设为爆炸
        }
        else if (Examine.hammertimeID && harvester == null) {
            if (!(HandHold.isHoldingHammertime(event.getPos(), event.getWorld()))) return; // 检查是否是 Hammer Time 模组的锤子
        }
        else {return;} // 非已知破坏方式

        if (blockState == lastBlock && ItemBase.isValidItemStack(lastDrop)) {
            // 使用上一次的掉落物
            dropStack(event);
            return;
        }

        // 获取掉落物矿词
        String dropRawOreDict = blockOreDict.replace("ore", "raw");
        // 获取掉落物
        ItemStack dropStack = ItemBase.oreStack(dropRawOreDict);

        if (ItemBase.isValidItemStack(dropStack)) {
            dropStack(event, dropStack);
            return;
        }

        // 再次尝试获取掉落物
        dropStack = againGetDropStack(dropRawOreDict, blockStack, blockOreDict);
        if (dropStack != null) {
            dropStack(event, dropStack);
        }
    }

    private static void dropStack(BlockEvent.HarvestDropsEvent event, ItemStack dropStack) {
        // 设置掉落物和最后处理的方块
        BreakingEvent.lastDrop = dropStack;
        BreakingEvent.lastBlock = event.getState();

        dropStack(event);
    }

    private static void dropStack(BlockEvent.HarvestDropsEvent event) {
        // 获取掉落物
        ItemStack dropStack = BreakingEvent.lastDrop;

        // 获取掉落事件
        BreakingEvent.Event = event;

        // 执行掉落方法
        Drop.drop(dropStack, way);

        if (way.equals("isExplosion") && explosionAffectedBlocks.contains(event.getPos())) {
            // 移除列表中已经处理过的方块
            explosionAffectedBlocks.remove(event.getPos());
        }
    }

    private static ItemStack againGetDropStack(String dropRawOreDict, ItemStack blockStack, String lastOreDict) {
        for (OreDictProcessingStrategy strategy : strategies) {
            ItemStack dropStack = strategy.process(dropRawOreDict, blockStack, lastOreDict);
            if (ItemBase.isValidItemStack(dropStack)) {
                return dropStack; // 获取到有效的 ItemStack, 返回
            }
        }

        return null; // 没有获取到有效的 ItemStack, 返回
    }

// 再次获取掉落物策略
    private static final OreDictProcessingStrategy[] strategies = {
        new DenseOreStrategy(),
        new GregtechOreStrategy(),
        new MultiOreDictStrategy()
    };

    // 策略接口
    private interface OreDictProcessingStrategy {
        ItemStack process(String dropRawOreDict, ItemStack blockStack, String lastOreDict);
    }

    // 处理 Dense 矿石的策略
    private static class DenseOreStrategy implements OreDictProcessingStrategy {
        @Override
        public ItemStack process(String dropRawOreDict, ItemStack blockStack, String lastOreDict) {
            // 移除 Dense 后缀
            return ItemBase.oreStack(dropRawOreDict.replace("Dense", ""));
        }
    }

    // 处理 Gregtech 矿石的策略
    private static class GregtechOreStrategy implements OreDictProcessingStrategy {
        private static final Pattern PATTERN = Pattern.compile("Netherrack|Endstone");

        @Override
        public ItemStack process(String dropRawOreDict, ItemStack blockStack, String lastOreDict) {
            return ItemBase.oreStack(PATTERN.matcher(dropRawOreDict).replaceAll(""));
        }
    }

    // 处理多矿词情况的策略
    private static class MultiOreDictStrategy implements OreDictProcessingStrategy {
        @Override
        public ItemStack process(String dropRawOreDict, ItemStack blockStack, String lastOreDict) {
            String currentLastOreDict = lastOreDict;
            for (int i = 0; i < 10; i++) { // 最多获取10次
                // 获取下一个矿词
                String blockOreDict = ItemBase.getItemOreDict(blockStack, "ore", true, currentLastOreDict);
                if (blockOreDict != null) {
                    ItemStack result = ItemBase.oreStack(blockOreDict.replace("ore", "raw"));
                    if (ItemBase.isValidItemStack(result)) {
                        return result;
                    }
                    currentLastOreDict = blockOreDict; // 更新lastOreDict
                } else {
                    break; // 没有更多矿词, 终止循环
                }
            }

            return ItemStack.EMPTY;
        }
    }
}
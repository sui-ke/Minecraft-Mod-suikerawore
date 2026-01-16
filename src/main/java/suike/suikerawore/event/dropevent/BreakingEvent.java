package suike.suikerawore.event.dropevent;

import java.util.*;
import java.util.regex.Pattern;

import suike.suikerawore.item.*;
import suike.suikerawore.expand.Expand;
import suike.suikerawore.expand.ModEnchantmentHelper;
import suike.suikerawore.expand.mekanism.MekanismExpand;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.enchantment.EnchantmentHelper;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.ExplosionEvent;

@Mod.EventBusSubscriber
public class BreakingEvent {

    private static volatile IBlockState lastBlock;
    private static volatile ItemStack lastDrop = ItemStack.EMPTY;

    // 被爆破的方块位置信息
    private static final Set<BlockPos> explosionAffectedBlocks = new HashSet<>();

    private static volatile boolean isEntity = true;  // 破坏方式
    private static volatile int fortuneLevel = 0;     // 时运等级
    // private static volatile int refiningLevel = 0;    // 炽心附魔等级
    private static volatile boolean hasSmelt = false; // 自动熔炼
    private static volatile boolean isDense = false;  // 富集矿石挖掘

    private static void resetVariables(String blockOreDict) {
        isEntity = true;
        fortuneLevel = 0;
        // refiningLevel = 0;
        hasSmelt = false;
        isDense = blockOreDict.endsWith("Dense"); // 矿词是否以 Dense 结尾
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
        // 获取挖掘方块的状态
        IBlockState blockState = event.getState();
        if (blockState == null) return;

        // 获取挖掘的方块物品
        ItemStack blockItem = getBlcokItem(blockState);

        // 获取方块物品的矿词
        String blockOreDict = ItemBase.getItemOreDict(blockItem, "ore");
        if (blockOreDict.isEmpty()) return; // 无矿词 矿词不以 ore 开头

        // 获取触发破坏的实体
        Entity harvester = event.getHarvester();

        // 重置变量
        resetVariables(blockOreDict);

        // 玩家破坏
        if (harvester instanceof EntityPlayer) {
            if (Expand.mekanismID && "[Mekanism]".equals(harvester.getName())){
                // 是实体 Mekanism 破坏
                if (MekanismExpand.isMek(harvester)) return; // 精准采集
            } else {
                ItemStack heldStack = ((EntityPlayer) harvester).getHeldItemMainhand();

                // 检查是否拥有精准采集
                if (ModEnchantmentHelper.hasEnch(heldStack, "silkTouch")) {
                    return;
                }

                fortuneLevel = event.getFortuneLevel();
                if (fortuneLevel == 0) {
                    fortuneLevel = ModEnchantmentHelper.getLevel(heldStack, "fortune");
                }
                hasSmelt = ModEnchantmentHelper.hasEnch(heldStack, "smelt");
                // refiningLevel = ModEnchantmentHelper.getLevel(heldStack, "refining");
            }
        }
        else if (explosionAffectedBlocks.contains(event.getPos())) {
            isEntity = false;
        }
        else {return;} // 非已知破坏方式

        // 检查挖掘方块是否与上一次相同
        if (blockState == lastBlock) {
            // 使用上一次的掉落物
            dropItme(event.getDrops(), blockItem, event.getPos());
            return;
        }

        // 获取掉落物矿词
        String dropRawOreDict = blockOreDict.replace("ore", "raw").replace("Dense", "");
        // 获取掉落物
        ItemStack dropStack = ItemBase.oreStack(dropRawOreDict);

        if (ItemBase.isValidItemStack(dropStack)) {
            dropItme(event.getDrops(), blockItem, dropStack, blockState, event.getPos());
        } else {
            // 再次尝试获取掉落物
            dropStack = againGetDropStack(dropRawOreDict, blockItem, blockOreDict);
            if (!dropStack.isEmpty()) {
                dropItme(event.getDrops(), blockItem, dropStack, blockState, event.getPos());
            }
        }
    }

    private static void dropItme(List<ItemStack> drops, ItemStack originDrop, ItemStack newDrop, IBlockState state, BlockPos pos) {
        // 设置掉落物和最后处理的方块
        lastDrop = newDrop;
        lastBlock = state;

        dropItme(drops, originDrop, pos);
    }

    private static void dropItme(List<ItemStack> drops, ItemStack originDrop, BlockPos pos) {
        // 尝试删除原掉落物
        ItemStack newDrop = DropHelper.instance.initialDrop(isEntity, lastDrop, fortuneLevel, isDense, hasSmelt);
        /*System.out.println("时运等级: " + fortuneLevel);
        System.out.println("自动熔炼: " + hasSmelt);
        System.out.println("掉落物列表: " + drops);
        System.out.println("方块物品: " + originDrop);
        System.out.println("新掉落物: " + newDrop);//*/
        if (removeOriginDrop(drops, originDrop, newDrop)) {
            drops.add(newDrop); // 添加新的掉落物
            // System.out.println("成功删除, 修改后的掉落物列表: " + drops);
        }
        // else System.out.println("未找到匹配的掉落物");
        if (!isEntity && explosionAffectedBlocks.contains(pos)) {
            explosionAffectedBlocks.remove(pos);
        }
    }

    // 移除列表需要更改的掉落物
    private static boolean removeOriginDrop(List<ItemStack> drops, ItemStack originDrop, ItemStack newDrop) {
        boolean success = false;
        Iterator<ItemStack> iterator = drops.iterator();
        while (iterator.hasNext()) {
            ItemStack drop = iterator.next();
            // System.out.println("是方块默认掉落物: " + ItemBase.itemsEqual(originDrop, drop));
            // System.out.println("能否替换: " + canReplace(newDrop, drop));
            if (ItemBase.itemsEqual(originDrop, drop) || canReplace(newDrop, drop)) {
                iterator.remove();
                success = true;
            }
        }
        return success;
    }

    // 检查是否据有特定矿词
    private static boolean canReplace(ItemStack newDrop, ItemStack originDrop) {
        if (newDrop.getItem() instanceof ItemBase) {
            ItemBase item = (ItemBase) newDrop.getItem();
            return containOre(item, originDrop, "ore") || containOre(item, originDrop, "ingot");
        }
        return ItemBase.itemsEqual(newDrop, originDrop);
    }
    private static boolean containOre(ItemBase item, ItemStack originDrop, String itemType) {
        String ore = itemType + item.getElementType();
        for (int id : OreDictionary.getOreIDs(originDrop)) {
            if (ore.equals(OreDictionary.getOreName(id))) {
                return true;
            }
        }
        return false;
    }

// 再次获取掉落物
    private static ItemStack againGetDropStack(String dropRawOreDict, ItemStack blockItem, String lastOreDict) {
        for (OreDictProcessingStrategy strategy : strategies) {
            ItemStack dropStack = strategy.process(dropRawOreDict, blockItem, lastOreDict);
            if (ItemBase.isValidItemStack(dropStack)) {
                return dropStack; // 获取到有效的 ItemStack, 返回
            }
        }

        return ItemStack.EMPTY; // 没有获取到有效的 ItemStack, 返回
    }

// 再次获取掉落物策略
    private static final OreDictProcessingStrategy[] strategies = {
        new GregtechOreStrategy(),
        new MultiOreDictStrategy()
    };

    // 策略接口
    private interface OreDictProcessingStrategy {
        ItemStack process(String dropRawOreDict, ItemStack blockItem, String lastOreDict);
    }

    // 处理 Gregtech 矿石的策略
    private static class GregtechOreStrategy implements OreDictProcessingStrategy {
        private static final Pattern PATTERN = Pattern.compile("Netherrack|Endstone");

        @Override
        public ItemStack process(String dropRawOreDict, ItemStack blockItem, String lastOreDict) {
            return ItemBase.oreStack(PATTERN.matcher(dropRawOreDict).replaceAll(""));
        }
    }

    // 处理多矿词情况的策略
    private static class MultiOreDictStrategy implements OreDictProcessingStrategy {
        @Override
        public ItemStack process(String dropRawOreDict, ItemStack blockItem, String lastOreDict) {
            String currentLastOreDict = lastOreDict;
            for (int i = 0; i < 10; i++) { // 最多获取10次
                // 获取下一个矿词
                String blockOreDict = ItemBase.getItemOreDict(blockItem, "ore", true, currentLastOreDict);
                if (!blockOreDict.isEmpty()) {
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

// 外部获取掉落物方法
    public static NonNullList<ItemStack> getDrops(NonNullList<ItemStack> drops) {
        NonNullList<ItemStack> newDrops = NonNullList.create();
        for (ItemStack originDrop : drops) {
            ItemStack drop = getDrop(originDrop);
            if (!drop.isEmpty()) {
                originDrop = drop; // 替换掉落物
            }
            newDrops.add(originDrop);
        }
        return newDrops;
    }

    public static ItemStack getDrop(ItemStack oreStack) {
        if (oreStack.isEmpty() || oreStack.getItem() instanceof ItemBase) {
            return ItemStack.EMPTY;
        }

        // 获取矿石的矿词 (以 "ore" 开头)
        String blockOreDict = ItemBase.getItemOreDict(oreStack, "ore");
        if (blockOreDict.isEmpty()) {
            return ItemStack.EMPTY; // 未获取到合适矿词 或 煤矿
        }

        // 尝试直接获取掉落物 (ore -> raw)
        String dropRawOreDict = blockOreDict.replace("ore", "raw").replace("Dense", "");
        ItemStack dropStack = ItemBase.oreStack(dropRawOreDict);
        if (ItemBase.isValidItemStack(dropStack)) {
            return dropStack;
        }

        // 尝试再次获取掉落物
        return againGetDropStack(dropRawOreDict, oreStack, blockOreDict);
    }

// 获取
    private static ItemStack getBlcokItem(IBlockState state) {
        Block block = state.getBlock();
        return new ItemStack(Item.getItemFromBlock(block), 1, block.damageDropped(state));
    }
}
package suike.suikerawore.monitor.dropmonitor;

import java.util.Set;
import java.util.HashSet;

import suike.suikerawore.SuiKe;
import suike.suikerawore.config.ConfigValue;
import suike.suikerawore.oredictionary.OreDictList;
import suike.suikerawore.expand.densemetals.DenseOreOD;

import suike.suikerawore.monitor.dropmonitor.examine.*;

import mekanism.common.tile.TileEntityDigitalMiner;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Enchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.tileentity.TileEntity;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Optional;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.ExplosionEvent;

@Mod.EventBusSubscriber(modid = SuiKe.MODID)
public class BreakingMonitor {

    public static IBlockState blockID;
    public static BlockEvent.HarvestDropsEvent Event;

    //爆炸方块的信息
    public static final Set<BlockPos> explosionAffectedBlocks = new HashSet<>();

    public static int fortuneLevel = 0;//时运等级
    public static String way = "entity";//破坏方式
    public static boolean smelt = false;//自动熔炼
    public static boolean dense = false;//致密矿石挖掘

    //获取被爆炸影响的所有方块
    @SubscribeEvent
    public static void onExplosionDetonate(ExplosionEvent.Detonate event) {
        explosionAffectedBlocks.clear();//清空爆炸列表
        explosionAffectedBlocks.addAll(event.getAffectedBlocks());
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onHarvestDrops(BlockEvent.HarvestDropsEvent event) {
        try {
            onHarvestDrops(event, 1);
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    public static void onHarvestDrops(BlockEvent.HarvestDropsEvent event, int a) {
        /*获取挖掘方块的信息*/blockID = event.getState();

        if (!ConfigValue.rawOreDrop ||//粗矿掉落关闭
            blockID == null ||//blockID为空
            !OreDictList.oreStone.contains(blockID)//不在总列表内
        ) {return;}

        /*重置方式字段设为实体*/way = "entity";

        if (event.getHarvester() instanceof Entity) {
            //实体破坏

            if (event.getHarvester().getClass().getSimpleName().equals("MekFakePlayer")){
                //是实体MekFakePlayer破坏
                if (isMek(event)) {
                    // 精准采集
                    return;
                }
            } else {
                //检查是否拥有精准采集
                boolean hasSilkTouch = EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, event.getHarvester().getHeldItemMainhand()) > 0;
                if (hasSilkTouch) {
                    return;
                }

                /*检查挖掘工具*/HandHold.examine(event);
            }
        } else if (explosionAffectedBlocks.contains(event.getPos())) {
            //爆炸破坏
            /*方式字段设为爆炸*/way = "explosion";

        } else if (event.getHarvester() == null) {
            //破坏者为空
            if (!(HandHold.isHoldingHammertime(event.getPos(), event.getWorld()))) {
            //检查是否是Hammer Time模组的锤子
                return;
            }
        }

        /*重置致密矿石挖掘*/dense = false;
        /*获取掉落事件*/BreakingMonitor.Event = event;

//检查类别, 并修改掉落物
        if (OreDictList.oreStoneA.contains(blockID) || OreDictList.oreStoneB.contains(blockID) || OreDictList.oreStoneC.contains(blockID)) {
        //普通粗矿
            MetalOre.checkBlock(blockID, way);

        } else if (ConfigValue.MoreRawOreDrop && OreDictList.oreMore.contains(blockID)) {
        //更多粗矿
            MoreOre.checkBlock(blockID, way);

        } else if (ConfigValue.DenseRawOreDrop && DenseOreOD.denseOreStone.contains(blockID)){
        //致密矿石
            dense = true;
            DenseOre.checkBlock(blockID, way);
        }

        if (way.equals("explosion") && explosionAffectedBlocks.contains(event.getPos())) {
            //移除列表中已经处理过的方块
            explosionAffectedBlocks.remove(event.getPos());
            //输出移除后的数量
        }
    }

//检查数字采矿机精准采集
    @Optional.Method(modid = "mekanism")
    public static boolean isMek(BlockEvent.HarvestDropsEvent event) {
        boolean isSilkTouch = false;

        BlockPos pos = new BlockPos(event.getHarvester().posX, event.getHarvester().posY, event.getHarvester().posZ);
        if (event.getHarvester().world.isBlockLoaded(pos)) {
            TileEntity tile = event.getHarvester().world.getTileEntity(pos);

            if (tile.getClass().toString().contains("tile.TileEntityDigitalMiner")) {
                TileEntityDigitalMiner digitalMiner = (TileEntityDigitalMiner) tile;

                isSilkTouch = digitalMiner.silkTouch;
            }
        }

        return isSilkTouch;
    }
}
package com.suike.suikerawore.monitor.dropmonitor;

import java.util.Set;
import java.util.HashSet;

import com.suike.suikerawore.SuiKe;
import com.suike.suikerawore.config.ConfigValue;
import com.suike.suikerawore.oredictionary.RawOD;
import com.suike.suikerawore.expand.densemetals.DenseOreOD;

import com.suike.suikerawore.monitor.dropmonitor.EntityMonitor;
import com.suike.suikerawore.monitor.dropmonitor.examine.MetalOre;//金属粗矿
import com.suike.suikerawore.monitor.dropmonitor.examine.MoreOre;//更多粗矿
import com.suike.suikerawore.monitor.dropmonitor.examine.DenseOre;//致密矿石

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.state.IBlockState;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.world.ExplosionEvent;
import net.minecraftforge.event.world.BlockEvent;

@Mod.EventBusSubscriber(modid = SuiKe.MODID)
public class ExplosionMonitor {

    public static BlockEvent.HarvestDropsEvent Event;

    //爆炸方块的信息
    private static final Set<BlockPos> explosionAffectedBlocks = new HashSet<>();

    //获取被爆炸影响的所有方块
    @SubscribeEvent
    public static void onExplosionDetonate(ExplosionEvent.Detonate event) {
        explosionAffectedBlocks.clear();
        explosionAffectedBlocks.addAll(event.getAffectedBlocks());

        World world = event.getWorld();

        for (BlockPos pos : event.getAffectedBlocks()) {

            IBlockState state = world.getBlockState(pos);
        }
    }

    @SubscribeEvent
    public static void onHarvestDrops(BlockEvent.HarvestDropsEvent event) {
        //获取挖掘方块的信息
        IBlockState blockID = event.getState();
        //粗矿掉落关闭; blockID为空; 不在总列表内 ;不是爆炸破坏
        if (!ConfigValue.rawOreDrop || blockID == null || !RawOD.oreStone.contains(blockID) || !explosionAffectedBlocks.contains(event.getPos())) 
        {return;}

        BlockPos pos = event.getPos();

        //检查方块是否在爆炸影响的方块集合中
        if (explosionAffectedBlocks.contains(pos)) {
            Event = event;

            //重置致密矿石挖掘
            EntityMonitor.dense = false;

            if (RawOD.oreStoneA.contains(blockID) || RawOD.oreStoneB.contains(blockID) || RawOD.oreStoneC.contains(blockID)) {
                //普通粗矿
                MetalOre.checkBlock(blockID, "explosion");

            } else if (ConfigValue.MoreRawOreDrop && RawOD.oreMore.contains(blockID)) {
                //更多粗矿
                MoreOre.checkBlock(blockID, "explosion");

            } else if (ConfigValue.DenseRawOreDrop && DenseOreOD.denseOreStone.contains(blockID)) {
                //致密矿石
                EntityMonitor.dense = true;
                DenseOre.checkBlock(blockID, "explosion");
            }

            //移除已经处理过的方块
            explosionAffectedBlocks.remove(pos);
        }
    }
}
package com.suike.suikerawore.monitor.dropmonitor;

import com.suike.suikerawore.SuiKe;
import com.suike.suikerawore.config.ConfigValue;
import com.suike.suikerawore.oredictionary.RawOD;
import com.suike.suikerawore.expand.densemetals.DenseOreOD;

import com.suike.suikerawore.monitor.dropmonitor.examine.MetalOre;//金属粗矿
import com.suike.suikerawore.monitor.dropmonitor.examine.MoreOre;//更多粗矿
import com.suike.suikerawore.monitor.dropmonitor.examine.DenseOre;//致密矿石
import com.suike.suikerawore.monitor.dropmonitor.examine.HandHold;//手持物品检查

import net.minecraft.entity.Entity;
import net.minecraft.block.state.IBlockState;
//附魔属性
import net.minecraft.init.Enchantments;
import net.minecraft.enchantment.EnchantmentHelper;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.event.world.BlockEvent;

@Mod.EventBusSubscriber(modid = SuiKe.MODID)
public class EntityMonitor {

    public static BlockEvent.HarvestDropsEvent Event;
    public static IBlockState blockID;

    public static String way = "entity";//挖掘方式
    public static String tool = "tool";//挖掘工具
    public static boolean smelt = false;//自动熔炼
    public static boolean dense = false;//致密矿石挖掘
    
    public static int fortuneLevel = 0;//时运等级

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onHarvestDrops(BlockEvent.HarvestDropsEvent event) {
        //获取挖掘方块的信息
        blockID = event.getState();

        //粗矿掉落关闭; blockID为空; 不在总列表内; 不是实体破坏; 是实体MekFakePlayer破坏
        if (!ConfigValue.rawOreDrop || blockID == null || !RawOD.oreStone.contains(blockID) || !(event.getHarvester() instanceof Entity)  || event.getHarvester().getClass().getSimpleName().equals("MekFakePlayer")) {return;}

        //检查是否拥有精准采集
        boolean hasSilkTouch = EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, event.getHarvester().getHeldItemMainhand()) > 0;
        if (hasSilkTouch) {return;}

        /*重置挖掘工具*/tool = "tool";
        /*重置致密矿石挖掘*/dense = false;

        //挖掘工具检查
        HandHold.examine(event);

        if (RawOD.oreStoneA.contains(blockID) || RawOD.oreStoneB.contains(blockID) || RawOD.oreStoneC.contains(blockID)) {
            //普通粗矿
            Event = event;
            MetalOre.checkBlock(blockID, way);

        } else if (ConfigValue.MoreRawOreDrop && RawOD.oreMore.contains(blockID)) {
            //更多粗矿
            Event = event;
            MoreOre.checkBlock(blockID, way);

        } else if (ConfigValue.DenseRawOreDrop && DenseOreOD.denseOreStone.contains(blockID)){
            //致密矿石
            Event = event;
            dense = true;
            DenseOre.checkBlock(blockID, way);
        }
    }
}
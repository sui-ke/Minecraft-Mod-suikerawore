package com.suike.suikerawore.monitor.dropmonitor.examine;

import com.suike.suikerawore.item.ItemBase;
import com.suike.suikerawore.config.ConfigValue;
import com.suike.suikerawore.oredictionary.RawOD;
import com.suike.suikerawore.monitor.dropmonitor.drop.Drop;

import net.minecraft.item.ItemStack;
import net.minecraft.block.state.IBlockState;

//更多粗矿检测
public class MoreOre {
    public static void checkBlock(IBlockState blockID, String way) {
        if (RawOD.oreArdite.contains(blockID)){
            //阿迪特
            itemDrop(new ItemStack(ItemBase.RAW_ARDITE), way);

        } else if (RawOD.oreCerulean.contains(blockID)){
            //晶蓝
            itemDrop(new ItemStack(ItemBase.RAW_CERULEAN), way);

        } else if (RawOD.oreMoonstone.contains(blockID)) {
            //皎月石
            itemDrop(new ItemStack(ItemBase.RAW_MOONSTONE), way);

        } else if (RawOD.oreOctine.contains(blockID)) {
            //炽炎铁
            itemDrop(new ItemStack(ItemBase.RAW_OCTINE), way);

        } else if (RawOD.oreSyrmorite.contains(blockID)) {
            //赛摩铜
            itemDrop(new ItemStack(ItemBase.RAW_SYRMORITE), way);
        }
    }

    //矿石掉落
    public static void itemDrop(ItemStack item, String way) {
        Drop.select(item, way);
    }
}
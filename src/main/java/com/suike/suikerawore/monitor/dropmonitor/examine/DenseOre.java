package com.suike.suikerawore.monitor.dropmonitor.examine;

import com.suike.suikerawore.item.ItemBase;
import com.suike.suikerawore.monitor.dropmonitor.drop.Drop;
//联动
import com.suike.suikerawore.expand.densemetals.DenseOreOD;

import net.minecraft.item.ItemStack;
import net.minecraft.block.state.IBlockState;

//致密矿石粗矿掉落
public class DenseOre {
    public static void checkBlock(IBlockState blockID, String way) {
        if (DenseOreOD.denseOreGold.contains(blockID)) {
            //致密金矿石
            itemDrop(new ItemStack(ItemBase.RAW_GOLD), way);

        } else if (DenseOreOD.denseOreIron.contains(blockID)) {
            //致密铁矿石
            itemDrop(new ItemStack(ItemBase.RAW_IRON), way);

        } else if (DenseOreOD.denseOreCopper.contains(blockID)) {
            //致密铜矿石
            itemDrop(new ItemStack(ItemBase.RAW_COPPER), way);

        } else if (DenseOreOD.denseOreTin.contains(blockID)) {
            //致密锡矿石
            itemDrop(new ItemStack(ItemBase.RAW_TIN), way);

        }else if (DenseOreOD.denseOreZinc.contains(blockID)) {
            //致密锌矿石
            itemDrop(new ItemStack(ItemBase.RAW_ZINC), way);

        } else if (DenseOreOD.denseOreLead.contains(blockID)) {
            //致密铅矿石
            itemDrop(new ItemStack(ItemBase.RAW_LEAD), way);

        } else if (DenseOreOD.denseOreSilver.contains(blockID)) {
            //致密银矿石
            itemDrop(new ItemStack(ItemBase.RAW_SILVER), way);

        } else if (DenseOreOD.denseOreOsmium.contains(blockID)) {
            //致密锇矿石
            itemDrop(new ItemStack(ItemBase.RAW_OSMIUM), way);

        } else if (DenseOreOD.denseOreNickel.contains(blockID)) {
            //致密镍矿石
            itemDrop(new ItemStack(ItemBase.RAW_NICKEL), way);

        } else if (DenseOreOD.denseOreIridium.contains(blockID)) {
            //致密依矿石
            itemDrop(new ItemStack(ItemBase.RAW_IRIDIUM), way);

        } else if (DenseOreOD.denseOreUranium.contains(blockID)) {
            //致密铀矿石
            itemDrop(new ItemStack(ItemBase.RAW_URANIUM), way);

        } else if (DenseOreOD.denseOrePlatinum.contains(blockID)) {
            //致密铂矿石
            itemDrop(new ItemStack(ItemBase.RAW_PLATINUM), way);

        } else if (DenseOreOD.denseOreTungsten.contains(blockID)) {
            //致密钨矿石
            itemDrop(new ItemStack(ItemBase.RAW_TUNGSTEN), way);

        } else if (DenseOreOD.denseOreAluminium.contains(blockID)) {
            //致密铝矿石
            itemDrop(new ItemStack(ItemBase.RAW_ALUMINIUM), way);

        } else if (DenseOreOD.denseOreMagnesium.contains(blockID)) {
            //镁矿石
            itemDrop(new ItemStack(ItemBase.RAW_MAGNESIUM), way);
        }
    }

    //矿石掉落
    public static void itemDrop(ItemStack item, String way) {
        Drop.select(item, way);
    }
}
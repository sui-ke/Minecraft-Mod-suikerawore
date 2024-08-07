package com.suike.suikerawore.monitor.dropmonitor.examine;

import com.suike.suikerawore.item.ItemBase;
import com.suike.suikerawore.oredictionary.RawOD;
import com.suike.suikerawore.monitor.dropmonitor.drop.Drop;

import net.minecraft.item.ItemStack;
import net.minecraft.block.state.IBlockState;

//金属粗矿检测
public class MetalOre {
    public static void checkBlock(IBlockState blockID, String way) {
        if (RawOD.oreStoneA.contains(blockID)) {
            if (RawOD.oreGold.contains(blockID)) {
                //金矿石
                itemDrop(new ItemStack(ItemBase.RAW_GOLD), way);

            } else if (RawOD.oreIron.contains(blockID)) {
                //铁矿石
                itemDrop(new ItemStack(ItemBase.RAW_IRON), way);

            } else if (RawOD.oreCopper.contains(blockID)) {
                //铜矿石
                itemDrop(new ItemStack(ItemBase.RAW_COPPER), way);

            } else if (RawOD.oreTin.contains(blockID)) {
                //锡矿石
                itemDrop(new ItemStack(ItemBase.RAW_TIN), way);

            } else if (RawOD.oreZinc.contains(blockID)) {
                //锌矿石
                itemDrop(new ItemStack(ItemBase.RAW_ZINC), way);

            } else if (RawOD.oreLead.contains(blockID)) {
                //铅矿石
                itemDrop(new ItemStack(ItemBase.RAW_LEAD), way);

            } else if (RawOD.oreSilver.contains(blockID)) {
                //银矿石
                itemDrop(new ItemStack(ItemBase.RAW_SILVER), way);

            } else if (RawOD.oreCobalt.contains(blockID)) {
                //钴矿石
                itemDrop(new ItemStack(ItemBase.RAW_COBALT), way);

            } else if (RawOD.oreOsmium.contains(blockID)) {
                //锇矿石
                itemDrop(new ItemStack(ItemBase.RAW_OSMIUM), way);
            }
        } else if (RawOD.oreStoneB.contains(blockID)) {
            if (RawOD.oreNickel.contains(blockID)) {
                //镍矿石
                itemDrop(new ItemStack(ItemBase.RAW_NICKEL), way);

            } else if (RawOD.oreIridium.contains(blockID)) {
                //铱矿石
                itemDrop(new ItemStack(ItemBase.RAW_IRIDIUM), way);

            } else if (RawOD.oreUranium.contains(blockID)) {
                //铀矿石
                itemDrop(new ItemStack(ItemBase.RAW_URANIUM), way);

            } else if (RawOD.oreGallium.contains(blockID)) {
                //镓矿石
                itemDrop(new ItemStack(ItemBase.RAW_GALLIUM), way);

            } else if (RawOD.oreTitanium.contains(blockID)) {
                //钛矿石
                itemDrop(new ItemStack(ItemBase.RAW_TITANIUM), way);

            } else if (RawOD.orePlatinum.contains(blockID)) {
                //铂矿石
                itemDrop(new ItemStack(ItemBase.RAW_PLATINUM), way);

            } else if (RawOD.oreTungsten.contains(blockID)) {
                //钨矿石
                itemDrop(new ItemStack(ItemBase.RAW_TUNGSTEN), way);

            } else if (RawOD.oreAluminium.contains(blockID)) {
                //铝矿石
                itemDrop(new ItemStack(ItemBase.RAW_ALUMINIUM), way);

            } else if (RawOD.oreMagnesium.contains(blockID)) {
                //镁矿石
                itemDrop(new ItemStack(ItemBase.RAW_MAGNESIUM), way);
            }
        } else if (RawOD.oreStoneC.contains(blockID)) {
            if (RawOD.oreLithium.contains(blockID)) {
                //锂矿石
                itemDrop(new ItemStack(ItemBase.RAW_LITHIUM), way);

            } else if (RawOD.oreThorium.contains(blockID)) {
                //钍矿石
                itemDrop(new ItemStack(ItemBase.RAW_THORIUM), way);

            } else if (RawOD.oreBoron.contains(blockID)) {
                //硼矿石
                itemDrop(new ItemStack(ItemBase.RAW_BORON), way);
            }
        }
    }

    //矿石掉落
    public static void itemDrop(ItemStack item, String way) {
        Drop.select(item, way);
    }
}
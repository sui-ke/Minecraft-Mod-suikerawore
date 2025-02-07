package suike.suikerawore.monitor.dropmonitor.examine;

import suike.suikerawore.item.ItemBase;
import suike.suikerawore.oredictionary.OreDictList;
import suike.suikerawore.monitor.dropmonitor.drop.Drop;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.block.state.IBlockState;

//金属粗矿检测
public class MetalOre {
    public static void checkBlock(IBlockState blockID, String way) {
        if (OreDictList.oreStoneA.contains(blockID)) {
            if (OreDictList.oreGold.contains(blockID)) {
                //金矿石
                itemDrop(ItemBase.RAW_GOLD, way);

            } else if (OreDictList.oreIron.contains(blockID)) {
                //铁矿石
                itemDrop(ItemBase.RAW_IRON, way);

            } else if (OreDictList.oreCopper.contains(blockID)) {
                //铜矿石
                itemDrop(ItemBase.RAW_COPPER, way);

            } else if (OreDictList.oreTin.contains(blockID)) {
                //锡矿石
                itemDrop(ItemBase.RAW_TIN, way);

            } else if (OreDictList.oreZinc.contains(blockID)) {
                //锌矿石
                itemDrop(ItemBase.RAW_ZINC, way);

            } else if (OreDictList.oreLead.contains(blockID)) {
                //铅矿石
                itemDrop(ItemBase.RAW_LEAD, way);

            } else if (OreDictList.oreSilver.contains(blockID)) {
                //银矿石
                itemDrop(ItemBase.RAW_SILVER, way);

            } else if (OreDictList.oreCobalt.contains(blockID)) {
                //钴矿石
                itemDrop(ItemBase.RAW_COBALT, way);

            } else if (OreDictList.oreOsmium.contains(blockID)) {
                //锇矿石
                itemDrop(ItemBase.RAW_OSMIUM, way);
            }
        } else if (OreDictList.oreStoneB.contains(blockID)) {
            if (OreDictList.oreNickel.contains(blockID)) {
                //镍矿石
                itemDrop(ItemBase.RAW_NICKEL, way);

            } else if (OreDictList.oreIridium.contains(blockID)) {
                //铱矿石
                itemDrop(ItemBase.RAW_IRIDIUM, way);

            } else if (OreDictList.oreUranium.contains(blockID)) {
                //铀矿石
                itemDrop(ItemBase.RAW_URANIUM, way);

            } else if (OreDictList.oreGallium.contains(blockID)) {
                //镓矿石
                itemDrop(ItemBase.RAW_GALLIUM, way);

            } else if (OreDictList.oreTitanium.contains(blockID)) {
                //钛矿石
                itemDrop(ItemBase.RAW_TITANIUM, way);

            } else if (OreDictList.orePlatinum.contains(blockID)) {
                //铂矿石
                itemDrop(ItemBase.RAW_PLATINUM, way);

            } else if (OreDictList.oreTungsten.contains(blockID)) {
                //钨矿石
                itemDrop(ItemBase.RAW_TUNGSTEN, way);

            } else if (OreDictList.oreAluminium.contains(blockID)) {
                //铝矿石
                itemDrop(ItemBase.RAW_ALUMINIUM, way);

            } else if (OreDictList.oreMagnesium.contains(blockID)) {
                //镁矿石
                itemDrop(ItemBase.RAW_MAGNESIUM, way);
            }
        } else if (OreDictList.oreStoneC.contains(blockID)) {
            if (OreDictList.oreLithium.contains(blockID)) {
                //锂矿石
                itemDrop(ItemBase.RAW_LITHIUM, way);

            } else if (OreDictList.oreThorium.contains(blockID)) {
                //钍矿石
                itemDrop(ItemBase.RAW_THORIUM, way);

            } else if (OreDictList.oreBoron.contains(blockID)) {
                //硼矿石
                itemDrop(ItemBase.RAW_BORON, way);

            } else if (OreDictList.oreVanadium.contains(blockID)) {
                //钒矿石
                itemDrop(ItemBase.RAW_VANADIUM, way);

            } else if (OreDictList.oreCadmium.contains(blockID)) {
                //镉矿石
                itemDrop(ItemBase.RAW_CADMIUM, way);

            } else if (OreDictList.oreManganese.contains(blockID)) {
                //锰矿石
                itemDrop(ItemBase.RAW_MANGANESE, way);

            } else if (OreDictList.oreGermanium.contains(blockID)) {
                //锗矿石
                itemDrop(ItemBase.RAW_GERMANIUM, way);

            } else if (OreDictList.oreChromium.contains(blockID)) {
                //铬矿石
                itemDrop(ItemBase.RAW_CHROMIUM, way);

            } else if (OreDictList.oreArsenic.contains(blockID)) {
                //砷矿石
                itemDrop(ItemBase.RAW_ARSENIC, way);
            }
        }
    }

    //矿石掉落
    public static void itemDrop(Item item, String way) {
        Drop.select(new ItemStack(item), way);
    }
}
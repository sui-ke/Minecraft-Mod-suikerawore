package suike.suikerawore.monitor.dropmonitor.examine;

import suike.suikerawore.item.ItemBase;
import suike.suikerawore.config.ConfigValue;
import suike.suikerawore.oredictionary.OreDictList;
import suike.suikerawore.monitor.dropmonitor.drop.Drop;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.block.state.IBlockState;

//更多粗矿检测
public class MoreOre {
    public static void checkBlock(IBlockState blockID, String way) {
        if (OreDictList.oreArdite.contains(blockID)){
            //阿迪特
            itemDrop(ItemBase.RAW_ARDITE, way);

        } else if (OreDictList.oreCerulean.contains(blockID)){
            //晶蓝
            itemDrop(ItemBase.RAW_CERULEAN, way);

        } else if (OreDictList.oreMoonstone.contains(blockID)) {
            //皎月石
            itemDrop(ItemBase.RAW_MOONSTONE, way);

        } else if (OreDictList.oreOctine.contains(blockID)) {
            //炽炎铁
            itemDrop(ItemBase.RAW_OCTINE, way);

        } else if (OreDictList.oreSyrmorite.contains(blockID)) {
            //赛摩铜
            itemDrop(ItemBase.RAW_SYRMORITE, way);

        } else if (OreDictList.oreCinnabar.contains(blockID)) {
            //朱砂矿石
            itemDrop(ItemBase.RAW_CINNABAR, way);

        } else if (OreDictList.oreVulcanite.contains(blockID)) {
            //软碲铜矿石
            itemDrop(ItemBase.RAW_VULCANITE, way);

        } else if (OreDictList.oreChasmium.contains(blockID)) {
            //裂金矿石
            itemDrop(ItemBase.RAW_CHASMIUM, way);

        } else if (OreDictList.oreRoseGold.contains(blockID)) {
            //玫瑰金矿石
            itemDrop(ItemBase.RAW_ROSEGOLD, way);
        }
    }

    //矿石掉落
    public static void itemDrop(Item item, String way) {
        Drop.select(new ItemStack(item), way);
    }
}
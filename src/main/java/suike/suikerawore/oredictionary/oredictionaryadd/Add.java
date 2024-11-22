package suike.suikerawore.oredictionary.oredictionaryadd;

import suike.suikerawore.item.ItemBase;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import net.minecraftforge.oredict.OreDictionary;

//添加矿词统合类
public class Add{
    public static void oreDictAdd(){
        /*块矿词*/AddBlock.oreDictAdd();
        /*锭矿词*/AddIngot.oreDictAdd();

        /*各粗矿矿词*/AddRawOre.oreDictAdd();
        /*各粗块矿词*/AddRawBlock.oreDictAdd();

        /*其他模组矿词*/AddExpandOreDict.oreDictAdd();

        String[][] types = {{"Aluminum", "Aluminium"}, {"Chrome", "Chromium"}};
        String[] itemTypes = {"ingot", "nugget"};

        for (String[] type : types) {
            for (String  itemType : itemTypes) {
                NonNullList<ItemStack> oreList = OreDictionary.getOres(itemType + type[0]);
                for (ItemStack oreItem : oreList) {
                    OreDictionary.registerOre(itemType + type[1], oreItem);
                }
            }
        }
    }
}
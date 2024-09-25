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
        /*粒矿词*/AddNugget.oreDictAdd();

        /*各粗矿矿词*/AddRawOre.oreDictAdd();
        /*各粗块矿词*/AddRawBlock.oreDictAdd();

        /*其他模组矿词*/AddExpandOreDict.oreDictAdd();

        String[][] types = {{"Aluminum", "Aluminium"}, {"Chrome", "Chromium"}};

        for (String[] type : types) {
            NonNullList<ItemStack> oreList = OreDictionary.getOres("ingot" + type[0]);
            for (ItemStack ore : oreList) {
                OreDictionary.registerOre("ingot" + type[1], ore);
            }
        }

    }
}
package suike.suikerawore.oredict.oredictadd;

import suike.suikerawore.item.ItemBase;

import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import net.minecraftforge.oredict.OreDictionary;

//添加矿词统合类
public class Add{
    public static void rawOreDictAdd(){
        /*块矿词*/AddBlock.oreDictAdd();
        /*锭矿词*/AddIngot.oreDictAdd();

        /*各粗矿矿词*/AddRawOre.oreDictAdd();
        /*各粗块矿词*/AddRawBlock.oreDictAdd();
    }

    public static void oreDictAdd(){
        /*其他模组矿词*/AddExpandOreDict.oreDictAdd();

        new Thread(() -> {
            multiOreDictionProcessing();
        }).start();
    }

    // 多矿词处理方法
    public static void multiOreDictionProcessing() {
        String[][] types = {{"Aluminum", "Aluminium"}, {"Chrome", "Chromium"}, {"Mythril", "Mithril"}};
        String[] itemTypes = {"ore", "ingot", "block", "nugget", "dust"};

        for (String[] type : types) {
            for (String  itemType : itemTypes) {
                NonNullList<ItemStack> oreStackList = OreDictionary.getOres(itemType + type[0]);
                for (ItemStack itemStack : oreStackList) {
                    if (ItemBase.isValidItemStack(itemStack)) {
                        OreDictionary.registerOre(itemType + type[1], itemStack);
                    }
                }
            }
        }

        NonNullList<ItemStack> oreStackList = OreDictionary.getOres("nuggetRareEarth");
        for (ItemStack itemStack : oreStackList) {
            if (ItemBase.isValidItemStack(itemStack)) {
                OreDictionary.registerOre("dustRareEarth", itemStack);
            }
        }
    }
}
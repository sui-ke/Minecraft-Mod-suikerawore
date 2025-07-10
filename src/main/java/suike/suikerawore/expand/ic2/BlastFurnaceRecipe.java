package suike.suikerawore.expand.ic2;

import suike.suikerawore.item.ItemBase;

import ic2.api.recipe.Recipes;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraftforge.oredict.OreDictionary;

//高炉配方
public class BlastFurnaceRecipe {
    public static void register() {
        /*钢锭*/register(ItemBase.RAW_IRON, "ingotSteel", "itemSlag");
    }

//配方注册
    public static void register(Item input, String outputOreDict, String secondaryOutputOreDict) {
        /*输入物*/ItemStack inputStack = new ItemStack(input);
        /*输出物*/ItemStack outputStack = ItemBase.oreStack(outputOreDict);
        /*副产物*/ItemStack secondaryOutputStack = ItemBase.oreStack(secondaryOutputOreDict);

        if (ItemBase.isValidItemStack(inputStack, outputStack, secondaryOutputStack)) {
            //注册打粉机配方
            Recipes.blastfurnace.addRecipe(
                Recipes.inputFactory.forStack(inputStack),
                null, false,
                outputStack, secondaryOutputStack
            );
        }
    }
}
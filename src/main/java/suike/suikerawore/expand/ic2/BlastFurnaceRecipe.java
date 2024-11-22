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
    public static void register(Item input, String outputOD, String outputOD2) {
        /*输入物*/ItemStack inputStack = new ItemStack(input);
        /*输出物*/ItemStack outputStack = ItemBase.oreStack(outputOD);
        /*副产物*/ItemStack outputStack2 = ItemBase.oreStack(outputOD2);

        if (ItemBase.isValidItemStack(inputStack) && !outputStack.isEmpty() && !outputStack2.isEmpty()) {
            //注册打粉机配方
            Recipes.blastfurnace.addRecipe(
                Recipes.inputFactory.forStack(inputStack),
                null, false,
                outputStack, outputStack2
            );
        }
    }
}
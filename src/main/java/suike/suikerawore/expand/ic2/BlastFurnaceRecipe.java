package suike.suikerawore.expand.ic2;

import suike.suikerawore.item.ItemBase;

import ic2.api.recipe.Recipes;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

// 高炉配方
public class BlastFurnaceRecipe {
    public static void register() {
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setInteger("fluid", 1);       // 1mB/ticks
        nbt.setInteger("duration", 6000); // 6000 ticks

        /*钢锭*/register(ItemBase.RAW_IRON, "ingotSteel", "itemSlag", nbt);
    }

// 配方注册
    public static void register(Item input, String outputOreDict, String secondaryOutputOreDict, NBTTagCompound nbt) {
        /*输入物*/ItemStack inputStack = new ItemStack(input);
        /*输出物*/ItemStack outputStack = ItemBase.oreStack(outputOreDict);
        /*副产物*/ItemStack secondaryOutputStack = ItemBase.oreStack(secondaryOutputOreDict);

        if (ItemBase.isValidItemStack(inputStack, outputStack, secondaryOutputStack)) {
            // 注册高炉配方
            Recipes.blastfurnace.addRecipe(
                Recipes.inputFactory.forStack(inputStack),
                nbt, false,
                outputStack, secondaryOutputStack
            );
        }
    }
}
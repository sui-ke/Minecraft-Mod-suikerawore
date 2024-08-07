package com.suike.suikerawore.expand.galacticraft;

import com.suike.suikerawore.item.ItemBase;

import micdoodle8.mods.galacticraft.core.recipe.RecipeManagerGC;
import micdoodle8.mods.galacticraft.api.recipe.CompressorRecipes;

import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.init.Items;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import net.minecraftforge.oredict.OreDictionary;

//压缩机配方
public class CompressorRecipe {
    public static void register() {
        /*金*/register(Items.GOLD_INGOT, "Gold");
        /*铁*/register(Items.IRON_INGOT, "Iron");
        /*铜板*/register(ItemBase.INGOT_COPPER, "Copper");
        /*锡板*/register(ItemBase.INGOT_TIN, "Tin");
        /*锌板*/register(ItemBase.INGOT_ZINC, "Zinc");
        /*铅板*/register(ItemBase.INGOT_LEAD, "Lead");
        /*银板*/register(ItemBase.INGOT_SILVER, "Silver");
        /*钴板*/register(ItemBase.INGOT_COBALT, "Cobalt");
        /*锇板*/register(ItemBase.INGOT_OSMIUM, "Osmium");
        /*镍板*/register(ItemBase.INGOT_NICKEL, "Nickel");
        /*铱板*/register(ItemBase.INGOT_IRIDIUM, "Iridium");
        /*铀板*/register(ItemBase.INGOT_URANIUM, "Uranium");
        /*镓板*/register(ItemBase.INGOT_GALLIUM, "Gallium");
        /*钛板*/register(ItemBase.INGOT_TITANIUM, "Titanium");
        /*铂板*/register(ItemBase.INGOT_PLATINUM, "Platinum");
        /*钨板*/register(ItemBase.INGOT_TUNGSTEN, "Tungsten");
        /*铝板*/register(ItemBase.INGOT_ALUMINIUM, "Aluminum");
        /*铝板*/register(ItemBase.INGOT_ALUMINIUM, "Aluminium");
        /*镁板*/register(ItemBase.INGOT_MAGNESIUM, "Magnesium");
        /*锂板*/register(ItemBase.INGOT_LITHIUM, "Lithium");
        /*钍板*/register(ItemBase.INGOT_THORIUM, "Thorium");
        /*硼板*/register(ItemBase.INGOT_BORON, "Boron");
    }

    //注册压缩机配方
    public static void register(Item input, String outputOD) {
        //定义矿词前缀
        String[] prefixes = {"compressed", "plate"};

        //遍历每个前缀
        for (String prefix : prefixes) {
            String structure = "XX";//摆放结构

            if (prefix.equals("plate")) {
                structure = "X";
            }

            NonNullList<ItemStack> outputList = OreDictionary.getOres(prefix + outputOD);

            ItemStack inputStack = new ItemStack(input, 1);
            ItemStack outputStack = createStack(outputList);

            if (!outputStack.isEmpty()) {
                CompressorRecipes.addRecipe(outputStack, structure, 'X', inputStack);
            }
        }
    }

    //获取对应的 ItemStack 方法
    public static ItemStack createStack(NonNullList<ItemStack> outputList) {
        //获取对应的 ItemStack

        if (!outputList.isEmpty()) {
            ItemStack outputStack = outputList.get(0).copy();
            outputStack.setCount(1);//设置数量

            return outputStack;
        }

        return ItemStack.EMPTY;//返回空的ItemStack
    }
}
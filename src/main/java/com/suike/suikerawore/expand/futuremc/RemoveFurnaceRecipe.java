package com.suike.suikerawore.expand.futuremc;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.lang.reflect.Field;

import thedarkcolour.futuremc.recipe.SimpleRecipe;
import thedarkcolour.futuremc.recipe.furnace.BlastFurnaceRecipes;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

import net.minecraftforge.oredict.OreDictionary;

//删除高炉配方
public class RemoveFurnaceRecipe {
    public static void remove() {
        //要排除的模组ID
        String modIdToExclude = "suikerawore";

        //获取所有矿词为铁锭的物品，并合并到一个列表中
        List<ItemStack> oreItems = new ArrayList<>();
        oreItems.addAll(OreDictionary.getOres("ingotCopper"));//铜
        oreItems.addAll(OreDictionary.getOres("ingotTin"));//锡
        oreItems.addAll(OreDictionary.getOres("ingotZinc"));//锌
        oreItems.addAll(OreDictionary.getOres("ingotLead"));//铅
        oreItems.addAll(OreDictionary.getOres("ingotSilver"));//银
        oreItems.addAll(OreDictionary.getOres("ingotCobalt"));//钴
        oreItems.addAll(OreDictionary.getOres("ingotOsmium"));//锇
        oreItems.addAll(OreDictionary.getOres("ingotNickel"));//镍
        oreItems.addAll(OreDictionary.getOres("ingotIridium"));//铱
        oreItems.addAll(OreDictionary.getOres("ingotUranium"));//铀
        oreItems.addAll(OreDictionary.getOres("ingotGallium"));//镓
        oreItems.addAll(OreDictionary.getOres("ingotTitanium"));//钛
        oreItems.addAll(OreDictionary.getOres("ingotPlatinum"));//铂
        oreItems.addAll(OreDictionary.getOres("ingotTungsten"));//钨
        oreItems.addAll(OreDictionary.getOres("ingotAluminum"));//铝
        oreItems.addAll(OreDictionary.getOres("ingotAluminium"));//铝
        oreItems.addAll(OreDictionary.getOres("ingotMagnesium"));//镁
        oreItems.addAll(OreDictionary.getOres("oreLithium"));//锂
        oreItems.addAll(OreDictionary.getOres("oreThorium"));//钍
        oreItems.addAll(OreDictionary.getOres("oreBoron"));//硼

        try {
            //访问BlastFurnaceRecipes类的recipes(配方)
            Field recipesField = BlastFurnaceRecipes.class.getDeclaredField("recipes");
            recipesField.setAccessible(true);//设置私有字段可访问
            ArrayList<SimpleRecipe> recipes = (ArrayList<SimpleRecipe>) recipesField.get(BlastFurnaceRecipes.INSTANCE);

            //访问SimpleRecipe类的output(输出物)
            Field outputField = SimpleRecipe.class.getDeclaredField("output");
            outputField.setAccessible(true);//设置私有字段可访问

            //收集要移除的配方
            List<SimpleRecipe> recipesToRemove = new ArrayList<>();

            //遍历并标记包含矿词物品的配方
            for (SimpleRecipe recipe : recipes) {
                ItemStack output = (ItemStack) outputField.get(recipe);
                ResourceLocation registryName = output.getItem().getRegistryName();
                if (registryName.getResourceDomain().equals(modIdToExclude)) {
                    continue;
                }
                for (ItemStack oreItem : oreItems) {
                    if (ItemStack.areItemsEqual(output, oreItem)) {
                        recipesToRemove.add(recipe);
                        break;
                    }
                }
            }

            //移除标记的配方
            recipes.removeAll(recipesToRemove);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
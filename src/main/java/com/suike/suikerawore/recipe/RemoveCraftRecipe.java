package com.suike.suikerawore.recipe;

import java.util.List;
import java.util.ArrayList;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistryModifiable;

//删除工作台配方
public class RemoveCraftRecipe {
    public static void remove() {
        //获取当前注册的配方注册表
        IForgeRegistryModifiable<IRecipe> modRegistry = (IForgeRegistryModifiable<IRecipe>) GameRegistry.findRegistry(IRecipe.class);
        
        //收集要移除的配方
        List<ResourceLocation> recipesToRemove = new ArrayList<>();

        //要排除的模组ID
        String modIdToExclude = "suikerawore";

        //获取所有矿词对应的物品，并合并到一个列表中
        List<ItemStack> oreItems = new ArrayList<>();
        oreItems.addAll(OreDictionary.getOres("blockCopper"));//铜
        oreItems.addAll(OreDictionary.getOres("blockTin"));//锡
        oreItems.addAll(OreDictionary.getOres("blockZinc"));//锌
        oreItems.addAll(OreDictionary.getOres("blockLead"));//铅
        oreItems.addAll(OreDictionary.getOres("blockSilver"));//银
        oreItems.addAll(OreDictionary.getOres("blockCobalt"));//钴
        oreItems.addAll(OreDictionary.getOres("blockOsmium"));//锇
        oreItems.addAll(OreDictionary.getOres("blockNickel"));//镍
        oreItems.addAll(OreDictionary.getOres("blockIridium"));//铱
        oreItems.addAll(OreDictionary.getOres("blockUranium"));//铀
        oreItems.addAll(OreDictionary.getOres("blockGallium"));//镓
        oreItems.addAll(OreDictionary.getOres("blockTitanium"));//钛
        oreItems.addAll(OreDictionary.getOres("blockPlatinum"));//铂
        oreItems.addAll(OreDictionary.getOres("blockTungsten"));//钨
        oreItems.addAll(OreDictionary.getOres("blockAluminum"));//铝
        oreItems.addAll(OreDictionary.getOres("blockAluminium"));//铝
        oreItems.addAll(OreDictionary.getOres("blockMagnesium"));//镁
        oreItems.addAll(OreDictionary.getOres("blockLithium"));//锂
        oreItems.addAll(OreDictionary.getOres("blockThorium"));//钍
        oreItems.addAll(OreDictionary.getOres("blockBoron"));//硼

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
        oreItems.addAll(OreDictionary.getOres("ingotLithium"));//锂
        oreItems.addAll(OreDictionary.getOres("ingotThorium"));//钍
        oreItems.addAll(OreDictionary.getOres("ingotBoron"));//硼

        //遍历并标记包含矿词物品的配方
        for (IRecipe recipe : modRegistry) {
            ItemStack output = recipe.getRecipeOutput();
            ResourceLocation registryName = output.getItem().getRegistryName();
            if (registryName != null && registryName.getResourceDomain().equals(modIdToExclude)) {
                continue;
            }
            for (ItemStack oreItem : oreItems) {
                if (ItemStack.areItemsEqual(output, oreItem)) {
                    recipesToRemove.add(recipe.getRegistryName());
                    break;
                }
            }
        }

        //移除标记的配方
        for (ResourceLocation recipeName : recipesToRemove) {
            modRegistry.remove(recipeName);
        }
    }
}
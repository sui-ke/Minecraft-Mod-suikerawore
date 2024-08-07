package com.suike.suikerawore.recipe;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.ResourceLocation;

import net.minecraftforge.oredict.OreDictionary;

//删除熔炉配方
public class RemoveFurnaceRecipe {
    public static void remove() {
        
        //获取当前熔炉配方
        Map<ItemStack, ItemStack> smeltingList = FurnaceRecipes.instance().getSmeltingList();

        //收集要移除的配方
        List<ItemStack> recipesToRemove = new ArrayList<>();

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

        //遍历并标记包含矿词物品的配方
        for (Map.Entry<ItemStack, ItemStack> entry : smeltingList.entrySet()) {
            ItemStack output = entry.getValue();
            ResourceLocation registryName = output.getItem().getRegistryName();
            if (registryName.getResourceDomain().equals(modIdToExclude)) {
                continue;
            }
            for (ItemStack oreItem : oreItems) {
                if (ItemStack.areItemsEqual(output, oreItem)) {
                    recipesToRemove.add(entry.getKey());
                    break;
                }
            }
        }

        //移除标记的配方
        for (ItemStack input : recipesToRemove) {
            smeltingList.remove(input);
        }
    }
}
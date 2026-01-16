package suike.suikerawore.expand.thermalexpansion;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import suike.suikerawore.item.*;
import suike.suikerawore.data.ByProductData;

import cofh.thermalexpansion.util.managers.machine.SmelterManager;

import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import net.minecraftforge.oredict.OreDictionary;

import com.google.common.collect.Lists;

// 感应炉-粗矿>锭
public class InductionSmelterRecipe {
    public static void register(ModItemRawOre rawOre) {
        register(rawOre, rawOre.getRefinedItemStack());
    }

// 配方注册
    private static void register(ModItemRawOre rawOre, ItemStack outputStack) {
        ItemStack inputStack = new ItemStack(rawOre);

        /*主输出物数量*/int[] outputAmounts = {2, 3, 3};
        /*副输入物*/String[] byProducInputs = {"sand", "itemSlagRich", "itemCinnabar"};

        /*默认副输出物*/String[] byProductOres = {"itemSlagRich", "itemSlag", "itemSlagRich"};
        /*副输出物概率*/int[] byProducChances = {20, 75, 75};

        // 遍历注册每个副输出物
        for (int i = 0 ; i < outputAmounts.length; i++) {
            // 设置主输出物数量
            outputStack.setCount(outputAmounts[i]);

            // 获取副输入物列表
            NonNullList<ItemStack> byProducInputList = OreDictionary.getOres(byProducInputs[i]);
            if (!byProducInputList.isEmpty()) {
                for (ItemStack byProducInput : byProducInputList) {
                    ItemStack byProduct = i < 2 ? ItemBase.oreStack(byProductOres[i]) : getByProduct(rawOre);
                    int byProductChance = i < 2 ? byProducChances[i]                  : getByProductChance(rawOre, byProducChances[i]);
                    if (byProduct.isEmpty()) {
                        byProduct = ItemBase.oreStack(byProductOres[i]);
                        byProductChance = byProducChances[i];
                    }

                    if (ItemBase.isValidItemStack(inputStack, outputStack)) {
                        /*注册配方*/SmelterManager.addRecipe(4000, inputStack, byProducInput, outputStack, byProduct, byProductChance);
                    }
                }
            }
        }
    }

    private static int getByProductChance(ModItemRawOre rawOre, int chance) {
        return !getByProductOre(rawOre).isEmpty() ? 100 : chance;
    }

    private static ItemStack getByProduct(ModItemRawOre rawOre) {
        ModItemRawOre dustRawOre = ItemBase.getRawOre(getByProductOre(rawOre).replace("dust", ""));
        if (dustRawOre != null) {
            return dustRawOre.getRefinedItemStack();
        } else {
            return ItemStack.EMPTY;
        }
    }

    private static String getByProductOre(ModItemRawOre rawOre) {
        String[] products = rawOre.getByProductData().getProducts();
        for (int i = 1 ; i < products.length; i++) {
            if (products[i].startsWith("dust")) {
                return products[i];
            }
        }
        return "";
    }
}
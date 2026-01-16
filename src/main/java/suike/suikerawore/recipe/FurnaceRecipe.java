package suike.suikerawore.recipe;

import java.util.*;

import suike.suikerawore.item.*;
import suike.suikerawore.config.ConfigValue;

import thedarkcolour.futuremc.recipe.furnace.BlastFurnaceRecipes;
import cofh.thermalexpansion.util.managers.machine.FurnaceManager;

import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.item.crafting.Ingredient;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;

// 熔炉配方
public class FurnaceRecipe {

    private final boolean FuturemcID;
    private final boolean thermalexpansionID;
    private final String[] prefixes;

    public FurnaceRecipe() {
        this.FuturemcID = Loader.isModLoaded("futuremc");
        this.thermalexpansionID = Loader.isModLoaded("thermalexpansion");
        this.prefixes = new String[]{"raw", "ore", "dust", "shard", "crushed", "crushedPurified", "purifiedcrushed", "cluster"};
    }

    public void registryRecipe(ModItemRawOre rawOre) {
        this.registerIngotRecipe(rawOre.getRefinedItemStack(), rawOre.getElementType());
        if (ConfigValue.rawBlockSmelt) {
            this.registryRecipe(new ItemStack(rawOre.getCompressBlock()), rawOre.getCompressBlock().getRefinedItemStack());
        }
    }

// 锭输出
    private void registerIngotRecipe(ItemStack outputStack, String elementType) {
        // 遍历每个前缀
        for (String prefix : prefixes) {
            // 获取所有与矿词匹配的物品
            NonNullList<ItemStack> inputList = OreDictionary.getOres(prefix + elementType);
            if (inputList == null || inputList.isEmpty()) continue;

            for (ItemStack input : inputList) {
                outputStack.setCount(prefix.equals("cluster") ? (ConfigValue.FurnaceOutputAmount * 2) : ConfigValue.FurnaceOutputAmount);
                /*注册配方*/this.registryRecipe(input, outputStack.copy());
            }
        }
    }

// 注册配方
    private void registryRecipe(ItemStack inputStack, ItemStack outputStack) {
        if (ItemBase.isValidItemStack(inputStack, outputStack)) {

            /*熔炉-配方注册*/GameRegistry.addSmelting(inputStack, outputStack, 1f);

            if (this.FuturemcID) {
                /*高炉输入物*/Ingredient ingrInput = Ingredient.fromStacks(inputStack);
                /*未来MC-高炉-配方注册*/BlastFurnaceRecipes.INSTANCE.addRecipe(ingrInput, outputStack);
            }

            if (this.thermalexpansionID) {
                /*热力膨胀5-红石炉-配方注册*/FurnaceManager.addRecipe(2000, inputStack, outputStack);
            }
        }
    }
}
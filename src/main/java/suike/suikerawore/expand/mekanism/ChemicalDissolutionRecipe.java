package suike.suikerawore.expand.mekanism;

import suike.suikerawore.item.*;
import suike.suikerawore.config.ConfigValue;

import mekanism.api.gas.Gas;
import mekanism.api.gas.GasStack;
import mekanism.api.gas.GasRegistry;
import mekanism.common.recipe.RecipeHandler;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

// 化学溶解室-粗矿>浆液
public class ChemicalDissolutionRecipe {
    public static void registerRecipe() {
        /*金浆液*/register(ItemBase.RAW_GOLD  , "gold");
        /*铁浆液*/register(ItemBase.RAW_IRON  , "iron");
        /*铜浆液*/register(ItemBase.RAW_COPPER, "copper");
        /*锡浆液*/register(ItemBase.RAW_TIN   , "tin");
        /*铅浆液*/register(ItemBase.RAW_LEAD  , "lead");
        /*银浆液*/register(ItemBase.RAW_SILVER, "silver");
        /*锇浆液*/register(ItemBase.RAW_OSMIUM, "osmium");
    }

// 配方注册
    private static void register(ModItemRawOre rawOre, String gasName) {
        if (!rawOre.isValid()) return;

        ItemStack inputStack = new ItemStack(rawOre);
        Gas gasType = GasRegistry.getGas(gasName);
        GasStack gasStack = new GasStack(gasType, ConfigValue.ChemicalDissolutionChamberMultiple * 1000);

        if (ItemBase.isValidItemStack(inputStack)) {
            RecipeHandler.addChemicalDissolutionChamberRecipe(inputStack, gasStack);
        }
    }
}
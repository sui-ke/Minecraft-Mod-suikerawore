package suike.suikerawore.expand.mekanism;

import suike.suikerawore.item.ItemBase;
import suike.suikerawore.config.ConfigValue;

import mekanism.api.gas.Gas;
import mekanism.api.gas.GasStack;
import mekanism.api.gas.GasRegistry;
import mekanism.common.recipe.RecipeHandler;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

//化学溶解室配方-粗矿>浆液
public class ChemicalDissolutionChamberRecipe {
    public static void register() {
        /*金浆液*/register(ItemBase.RAW_GOLD, "gold");
        /*铁浆液*/register(ItemBase.RAW_IRON, "iron");
        /*铜浆液*/register(ItemBase.RAW_COPPER, "copper");
        /*锡浆液*/register(ItemBase.RAW_TIN, "tin");
        /*铅浆液*/register(ItemBase.RAW_LEAD, "lead");
        /*银浆液*/register(ItemBase.RAW_SILVER, "silver");
        /*锇浆液*/register(ItemBase.RAW_OSMIUM, "osmium");
    }

//配方注册
    public static void register(Item input, String gasName) {
        ItemStack inputStack = new ItemStack(input);
        Gas gasType = GasRegistry.getGas(gasName);
        GasStack gasStack = new GasStack(gasType, ConfigValue.ChemicalDissolutionChamberMultiple * 500);

        RecipeHandler.addChemicalDissolutionChamberRecipe(inputStack, gasStack);
    }
}
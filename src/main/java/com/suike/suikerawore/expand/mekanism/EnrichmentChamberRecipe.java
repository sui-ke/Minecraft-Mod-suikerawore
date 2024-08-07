package com.suike.suikerawore.expand.mekanism;

import com.suike.suikerawore.item.ItemBase;
import com.suike.suikerawore.config.ConfigValue;

import mekanism.common.recipe.RecipeHandler;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import net.minecraftforge.oredict.OreDictionary;

//富集仓-粗矿>粉
public class EnrichmentChamberRecipe {
    public static void register() {
        /*金粉*/register(ItemBase.RAW_GOLD, "dustGold");
        /*铁粉*/register(ItemBase.RAW_IRON, "dustIron");
        /*铜粉*/register(ItemBase.RAW_COPPER, "dustCopper");
        /*锡粉*/register(ItemBase.RAW_TIN, "dustTin");
        /*锌粉*/register(ItemBase.RAW_ZINC, "dustZinc");
        /*铅粉*/register(ItemBase.RAW_LEAD, "dustLead");
        /*银粉*/register(ItemBase.RAW_SILVER, "dustSilver");
        /*钴粉*/register(ItemBase.RAW_COBALT, "dustCobalt");
        /*锇粉*/register(ItemBase.RAW_OSMIUM, "dustOsmium");
        /*镍粉*/register(ItemBase.RAW_NICKEL, "dustNickel");
        /*铱粉*/register(ItemBase.RAW_IRIDIUM, "dustIridium");
        /*铀粉*/register(ItemBase.RAW_URANIUM, "dustUranium");
        /*镓粉*/register(ItemBase.RAW_GALLIUM, "dustGallium");
        /*钛粉*/register(ItemBase.RAW_TITANIUM, "dustTitanium");
        /*铂粉*/register(ItemBase.RAW_PLATINUM, "dustPlatinum");
        /*钨粉*/register(ItemBase.RAW_TUNGSTEN, "dustTungsten");
        /*铝粉*/register(ItemBase.RAW_ALUMINIUM, "dustAluminium");
        /*镁粉*/register(ItemBase.RAW_MAGNESIUM, "dustMagnesium");
        /*锂粉*/register(ItemBase.RAW_LITHIUM, "dustLithium");
        /*钍粉*/register(ItemBase.RAW_THORIUM, "dustThorium");
        /*硼粉*/register(ItemBase.RAW_BORON, "dustBoron");
    }

    public static void register(Item input, String outputOD) {
        NonNullList<ItemStack> outputList = OreDictionary.getOres(outputOD);

        if (!outputList.isEmpty()) {
            ItemStack inputStack = new ItemStack(input);
            ItemStack outputStack = outputList.get(0).copy();
            outputStack.setCount(ConfigValue.EnrichmentOutputAmount);//设置数量

            RecipeHandler.addEnrichmentChamberRecipe(inputStack, outputStack);
        }
    }
}
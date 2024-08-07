package com.suike.suikerawore.expand.ic;

import com.suike.suikerawore.item.ItemBase;
import com.suike.suikerawore.config.ConfigValue;

import ic2.api.recipe.Recipes;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import net.minecraftforge.oredict.OreDictionary;

//打粉机配方
public class MaceratorRecipe {
    public static void register() {
    //粗矿>碎块
        /*金碎块*/register(ItemBase.RAW_GOLD, "crushedGold");
        /*铁碎块*/register(ItemBase.RAW_IRON, "crushedIron");
        /*铜碎块*/register(ItemBase.RAW_COPPER, "crushedCopper");
        /*锡碎块*/register(ItemBase.RAW_TIN, "crushedTin");
        /*锌碎块*/register(ItemBase.RAW_ZINC, "crushedZinc");
        /*铅碎块*/register(ItemBase.RAW_LEAD, "crushedLead");
        /*银碎块*/register(ItemBase.RAW_SILVER, "crushedSilver");
        /*钴碎块*/register(ItemBase.RAW_COBALT, "crushedCobalt");
        /*锇碎块*/register(ItemBase.RAW_OSMIUM, "crushedOsmium");
        /*镍碎块*/register(ItemBase.RAW_NICKEL, "crushedNickel");
        /*铱碎块*/register(ItemBase.RAW_IRIDIUM, "crushedIridium");
        /*铀碎块*/register(ItemBase.RAW_URANIUM, "crushedUranium");
        /*镓碎块*/register(ItemBase.RAW_GALLIUM, "crushedGallium");
        /*钛碎块*/register(ItemBase.RAW_TITANIUM, "crushedTitanium");
        /*铂碎块*/register(ItemBase.RAW_PLATINUM, "crushedPlatinum");
        /*钨碎块*/register(ItemBase.RAW_TUNGSTEN, "crushedTungsten");
        /*铝碎块*/register(ItemBase.RAW_ALUMINIUM, "crushedAluminium");
        /*镁碎块*/register(ItemBase.RAW_MAGNESIUM, "crushedMagnesium");
        /*锂碎块*/register(ItemBase.RAW_LITHIUM, "crushedLithium");
        /*钍碎块*/register(ItemBase.RAW_THORIUM, "crushedThorium");
        /*硼碎块*/register(ItemBase.RAW_BORON, "crushedBoron");

    //锭>粉
        /*铜粉*/register(ItemBase.INGOT_COPPER, "dustCopper");
        /*锡粉*/register(ItemBase.INGOT_TIN, "dustTin");
        /*锌粉*/register(ItemBase.INGOT_ZINC, "dustZinc");
        /*铅粉*/register(ItemBase.INGOT_LEAD, "dustLead");
        /*银粉*/register(ItemBase.INGOT_SILVER, "dustSilver");
        /*钴粉*/register(ItemBase.INGOT_COBALT, "dustCobalt");
        /*锇粉*/register(ItemBase.INGOT_OSMIUM, "dustOsmium");
        /*镍粉*/register(ItemBase.INGOT_NICKEL, "dustNickel");
        /*铱粉*/register(ItemBase.INGOT_IRIDIUM, "dustIridium");
        /*铀粉*/register(ItemBase.INGOT_URANIUM, "dustUranium");
        /*镓粉*/register(ItemBase.INGOT_GALLIUM, "dustGallium");
        /*钛粉*/register(ItemBase.INGOT_TITANIUM, "dustTitanium");
        /*铂粉*/register(ItemBase.INGOT_PLATINUM, "dustPlatinum");
        /*钨粉*/register(ItemBase.INGOT_TUNGSTEN, "dustTungsten");
        /*铝粉*/register(ItemBase.INGOT_ALUMINIUM, "dustAluminium");
        /*镁粉*/register(ItemBase.INGOT_MAGNESIUM, "dustMagnesium");
        /*锂粉*/register(ItemBase.INGOT_LITHIUM, "dustLithium");
        /*钍粉*/register(ItemBase.INGOT_THORIUM, "dustThorium");
        /*硼粉*/register(ItemBase.INGOT_BORON, "dustBoron");
    }

    public static void register(Item input, String outputOD) {
        NonNullList<ItemStack> outputList = OreDictionary.getOres(outputOD);

        if (!outputList.isEmpty()) {
            ItemStack inputStack = new ItemStack(input);
            ItemStack outputStack = outputList.get(0).copy();
            outputStack.setCount(ConfigValue.maceratorOutputAmount);//设置数量

            Recipes.macerator.addRecipe(Recipes.inputFactory.forStack(inputStack), null, false, outputStack);
        }
    }
}
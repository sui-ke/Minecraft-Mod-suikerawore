package suike.suikerawore.expand.mekanism;

import suike.suikerawore.item.ItemBase;
import suike.suikerawore.config.ConfigValue;

import mekanism.common.recipe.RecipeHandler;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import net.minecraftforge.oredict.OreDictionary;

//粉碎机配方-锭>粉
public class CrusherRecipe {
    public static void register() {
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
        /*钒粉*/register(ItemBase.INGOT_VANADIUM, "dustVanadium");
        /*镉粉*/register(ItemBase.INGOT_CADMIUM, "dustCadmium");
        /*锰粉*/register(ItemBase.INGOT_MANGANESE, "dustManganese");
        /*锗粉*/register(ItemBase.INGOT_GERMANIUM, "dustGermanium");
        /*钒粉*/register(ItemBase.INGOT_VANADIUM, "dustVanadium");
        /*镉粉*/register(ItemBase.INGOT_CADMIUM, "dustCadmium");
        /*锰粉*/register(ItemBase.INGOT_MANGANESE, "dustManganese");
        /*锗粉*/register(ItemBase.INGOT_GERMANIUM, "dustGermanium");
        /*铬粉*/register(ItemBase.INGOT_CHROMIUM, "dustChromium");
        /*砷粉*/register(ItemBase.INGOT_ARSENIC, "dustArsenic");
    }

//配方注册
    public static void register(Item input, String outputOD) {
        ItemStack inputStack = new ItemStack(input);
        NonNullList<ItemStack> outputList = OreDictionary.getOres(outputOD);

        if (ItemBase.isValidItemStack(inputStack) && !outputList.isEmpty()) {
            ItemStack outputStack = outputList.get(0).copy();
            outputStack.setCount(ConfigValue.CrusherOutputAmount);//设置数量

            RecipeHandler.addCrusherRecipe(inputStack, outputStack);
        }
    }
}
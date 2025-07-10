package suike.suikerawore.expand.mekanism;

import suike.suikerawore.item.ItemBase;
import suike.suikerawore.config.ConfigValue;

import mekanism.common.recipe.RecipeHandler;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

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
        /*钒粉*/register(ItemBase.RAW_VANADIUM, "dustVanadium");
        /*镉粉*/register(ItemBase.RAW_CADMIUM, "dustCadmium");
        /*锰粉*/register(ItemBase.RAW_MANGANESE, "dustManganese");
        /*锗粉*/register(ItemBase.RAW_GERMANIUM, "dustGermanium");
        /*铬粉*/register(ItemBase.RAW_CHROMIUM, "dustChromium");
        /*砷粉*/register(ItemBase.RAW_ARSENIC, "dustArsenic");
        /*铍粉*/register(ItemBase.RAW_BERYLLIUM, "dustBeryllium");
        /*镭粉*/register(ItemBase.RAW_IRRADIUM, "dustIrradium");
        /*钯粉*/register(ItemBase.RAW_PALLADIUM, "dustPalladium");
        /*钚粉*/register(ItemBase.RAW_PLUTONIUM, "dustPlutonium");
        /*铌粉*/register(ItemBase.RAW_NIOBIUM, "dustNiobium");
        /*秘银粉*/register(ItemBase.RAW_MITHRIL, "dustMithril");
        /*金红石粉*/register(ItemBase.RAW_RUTILE, "dustRutile");

        /*阿迪特粉*/register(ItemBase.RAW_BORON, "dustArdite");
    }

//配方注册
    public static void register(Item input, String outputOreDict) {
        ItemStack inputStack = new ItemStack(input);
        ItemStack outputStack = ItemBase.oreStack(outputOreDict);

        if (ItemBase.isValidItemStack(inputStack, outputStack)) {
            /*设置数量*/outputStack.setCount(ConfigValue.EnrichmentOutputAmount);
            /*配方注册*/RecipeHandler.addEnrichmentChamberRecipe(inputStack, outputStack);
        }
    }
}
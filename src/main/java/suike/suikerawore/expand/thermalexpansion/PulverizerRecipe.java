package suike.suikerawore.expand.thermalexpansion;

import suike.suikerawore.item.ItemBase;
import suike.suikerawore.config.ConfigValue;

import cofh.thermalexpansion.util.managers.machine.PulverizerManager;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraftforge.oredict.OreDictionary;

//磨粉机配方
public class PulverizerRecipe {
    public static void register() {
        /*金粉*/register(ItemBase.RAW_GOLD, "dustGold", "itemCinnabar");
        /*铁粉*/register(ItemBase.RAW_IRON, "dustIron", "dustNickel");
        /*铜粉*/register(ItemBase.RAW_COPPER, "dustCopper", "dustGold");
        /*锡粉*/register(ItemBase.RAW_TIN, "dustTin", "dustIron");
        /*锌粉*/register(ItemBase.RAW_ZINC, "dustZinc", "dustCadmium");
        /*铅粉*/register(ItemBase.RAW_LEAD, "dustLead", "dustSilver");
        /*银粉*/register(ItemBase.RAW_SILVER, "dustSilver", "dustLead");
        /*钴粉*/register(ItemBase.RAW_COBALT, "dustCobalt", "dustNickel");
        /*锇粉*/register(ItemBase.RAW_OSMIUM, "dustOsmium", "dustIridium");
        /*镍粉*/register(ItemBase.RAW_NICKEL, "dustNickel", "dustPlatinum");
        /*铱粉*/register(ItemBase.RAW_IRIDIUM, "dustIridium", "dustPlatinum");
        /*铀粉*/register(ItemBase.RAW_URANIUM, "dustUranium", "dustThorium");
        /*镓粉*/register(ItemBase.RAW_GALLIUM, "dustGallium", "dustAluminium");
        /*钛粉*/register(ItemBase.RAW_TITANIUM, "dustTitanium", "dustVanadium");
        /*铂粉*/register(ItemBase.RAW_PLATINUM, "dustPlatinum", "dustIridium");
        /*钨粉*/register(ItemBase.RAW_TUNGSTEN, "dustTungsten", "dustTin");
        /*铝粉*/register(ItemBase.RAW_ALUMINIUM, "dustAluminium", "dustIron");
        /*镁粉*/register(ItemBase.RAW_MAGNESIUM, "dustMagnesium", "dustCalcium");
        /*锂粉*/register(ItemBase.RAW_LITHIUM, "dustLithium", "dustAluminium");
        /*钍粉*/register(ItemBase.RAW_THORIUM, "dustThorium", "dustRareEarth");
        /*硼粉*/register(ItemBase.RAW_BORON, "dustBoron", "dustSodium");
        /*钒粉*/register(ItemBase.RAW_VANADIUM, "dustVanadium", "dustTitanium");
        /*镉粉*/register(ItemBase.RAW_CADMIUM, "dustCadmium", "dustZinc");
        /*锰粉*/register(ItemBase.RAW_MANGANESE, "dustManganese", "dustIron");
        /*锗粉*/register(ItemBase.RAW_GERMANIUM, "dustGermanium", "dustLead");
        /*铬粉*/register(ItemBase.RAW_CHROMIUM, "dustChromium", "dustIron");
        /*砷粉*/register(ItemBase.RAW_ARSENIC, "dustArsenic", "dustSulfur");
        /*铍粉*/register(ItemBase.RAW_BERYLLIUM, "dustBeryllium", "dustAluminium");
        /*镭粉*/register(ItemBase.RAW_IRRADIUM, "dustIrradium", "dustIrradium");
        /*钯粉*/register(ItemBase.RAW_PALLADIUM, "dustPalladium", "dustNickel");
        /*钚粉*/register(ItemBase.RAW_PLUTONIUM, "dustPlutonium", "dustPlutonium");
        /*铌粉*/register(ItemBase.RAW_NIOBIUM, "dustNiobium", "dustNiobium");
        /*秘银粉*/register(ItemBase.RAW_MITHRIL, "dustMithril", "dustSilver");
        /*金红石粉*/register(ItemBase.RAW_RUTILE, "dustRutile", "dustIron");

        /*阿迪特*/register(ItemBase.RAW_BORON, "dustArdite");
        /*玫瑰金*/register(ItemBase.RAW_ROSEGOLD, "dustRosegold");
        /* 朱砂 */register(ItemBase.RAW_CINNABAR, "quicksilver", "itemCinnabar");

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
        /*铬粉*/register(ItemBase.INGOT_CHROMIUM, "dustChromium");
        /*砷粉*/register(ItemBase.INGOT_ARSENIC, "dustArsenic");
    }

//转译变量
    public static void register(Item input, String outputOreDict) {
        register(input, outputOreDict, "suikerawore", 100);
    }
    public static void register(Item input, String outputOreDict, String secondaryOutputOreDict) {
        register(input, outputOreDict, secondaryOutputOreDict, 10);
    }

//配方注册
    public static void register(Item input, String outputOreDict, String secondaryOutputOreDict, int secondaryOutputChance) {
        int outputAmount = 1;
        if (((ItemBase) input).isRaw()) {
            outputAmount = ConfigValue.PulverizerOutputAmount;
        }

        /*主输入物*/ItemStack inputStack = new ItemStack(input);
        /*主输出物*/ItemStack outputStack = ItemBase.oreStack(outputOreDict, outputAmount);
        /*副输出物*/ItemStack secondaryOutputStack = ItemBase.oreStack(secondaryOutputOreDict);

        if (ItemBase.isValidItemStack(inputStack, outputStack)) {
            /*注册配方*/PulverizerManager.addRecipe(4000, inputStack, outputStack, secondaryOutputStack, secondaryOutputChance);
        }
    }
}
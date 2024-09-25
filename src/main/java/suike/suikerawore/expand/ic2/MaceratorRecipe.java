package suike.suikerawore.expand.ic2;

import suike.suikerawore.item.ItemBase;
import suike.suikerawore.config.ConfigValue;
import suike.suikerawore.expand.Examine;

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
        /*钨碎块*/register(ItemBase.RAW_TUNGSTEN, "crushedTungsten");
        /*铝碎块*/register(ItemBase.RAW_ALUMINIUM, "crushedAluminium");
        /*镁碎块*/register(ItemBase.RAW_MAGNESIUM, "crushedMagnesium");
        /*锂碎块*/register(ItemBase.RAW_LITHIUM, "crushedLithium");
        /*钍碎块*/register(ItemBase.RAW_THORIUM, "crushedThorium");
        /*硼碎块*/register(ItemBase.RAW_BORON, "crushedBoron");
        /*钒碎块*/register(ItemBase.RAW_VANADIUM, "crushedVanadium");
        /*镉碎块*/register(ItemBase.RAW_CADMIUM, "crushedCadmium");
        /*锰碎块*/register(ItemBase.RAW_MANGANESE, "crushedManganese");
        /*锗碎块*/register(ItemBase.RAW_GERMANIUM, "crushedGermanium");
        /*铬碎块*/register(ItemBase.RAW_CHROMIUM, "crushedChromium");
        /*砷碎块*/register(ItemBase.RAW_ARSENIC, "crushedArsenic");

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
        /*钒粉*/register(ItemBase.INGOT_VANADIUM, "dustVanadium");
        /*镉粉*/register(ItemBase.INGOT_CADMIUM, "dustCadmium");
        /*锰粉*/register(ItemBase.INGOT_MANGANESE, "dustManganese");
        /*锗粉*/register(ItemBase.INGOT_GERMANIUM, "dustGermanium");
        /*铬粉*/register(ItemBase.INGOT_CHROMIUM, "dustChromium");
        /*砷粉*/register(ItemBase.INGOT_ARSENIC, "dustArsenic");

        if (Examine.iridiumsourceID) {
            /*铂颗粒*/register(ItemBase.RAW_PLATINUM, "prillPlatinum");
            /*铂碎块*/register(Item.getByNameOrId("iridiumsource:prill_platina"), "crushedPlatinum");
        } else {
            /*铂碎块*/register(ItemBase.RAW_PLATINUM, "crushedPlatinum");
        }
    }

//配方注册
    public static void register(Item input, String outputOD) {
        /*输入物*/ItemStack inputStack = new ItemStack(input);
        /*输出物*/ItemStack outputStack = ItemBase.oreStack(outputOD, ConfigValue.maceratorOutputAmount);

        if (!outputStack.isEmpty()) {
            /*注册打粉机配方*/Recipes.macerator.addRecipe(Recipes.inputFactory.forStack(inputStack), null, false, outputStack);
        }
    }
}
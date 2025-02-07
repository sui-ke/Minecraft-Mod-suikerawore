package suike.suikerawore.expand.ic2;

import suike.suikerawore.item.ItemBase;
import suike.suikerawore.config.ConfigValue;
import suike.suikerawore.expand.Examine;

import ic2.api.recipe.Recipes;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraftforge.oredict.OreDictionary;

//打粉机配方
public class MaceratorRecipe {
    public static void register() {
    //粗矿>碎块
        /*金碎块*/register(ItemBase.RAW_GOLD,"Gold");
        /*铁碎块*/register(ItemBase.RAW_IRON,"Iron");
        /*铜碎块*/register(ItemBase.RAW_COPPER,"Copper");
        /*锡碎块*/register(ItemBase.RAW_TIN,"Tin");
        /*锌碎块*/register(ItemBase.RAW_ZINC,"Zinc");
        /*铅碎块*/register(ItemBase.RAW_LEAD,"Lead");
        /*银碎块*/register(ItemBase.RAW_SILVER,"Silver");
        /*钴碎块*/register(ItemBase.RAW_COBALT,"Cobalt");
        /*锇碎块*/register(ItemBase.RAW_OSMIUM,"Osmium");
        /*镍碎块*/register(ItemBase.RAW_NICKEL,"Nickel");
        /*铱碎块*/register(ItemBase.RAW_IRIDIUM,"Iridium");
        /*铀碎块*/register(ItemBase.RAW_URANIUM,"Uranium");
        /*镓碎块*/register(ItemBase.RAW_GALLIUM,"Gallium");
        /*钛碎块*/register(ItemBase.RAW_TITANIUM,"Titanium");
        /*钨碎块*/register(ItemBase.RAW_TUNGSTEN,"Tungsten");
        /*铝碎块*/register(ItemBase.RAW_ALUMINIUM,"Aluminium");
        /*镁碎块*/register(ItemBase.RAW_MAGNESIUM,"Magnesium");
        /*锂碎块*/register(ItemBase.RAW_LITHIUM,"Lithium");
        /*钍碎块*/register(ItemBase.RAW_THORIUM,"Thorium");
        /*硼碎块*/register(ItemBase.RAW_BORON,"Boron");
        /*钒碎块*/register(ItemBase.RAW_VANADIUM,"Vanadium");
        /*镉碎块*/register(ItemBase.RAW_CADMIUM,"Cadmium");
        /*锰碎块*/register(ItemBase.RAW_MANGANESE,"Manganese");
        /*锗碎块*/register(ItemBase.RAW_GERMANIUM,"Germanium");
        /*铬碎块*/register(ItemBase.RAW_CHROMIUM,"Chromium");
        /*砷碎块*/register(ItemBase.RAW_ARSENIC,"Arsenic");

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
            /*铂碎块*/register(Item.getByNameOrId("iridiumsource:prill_platina"),"Platinum");
        } else {
            /*铂碎块*/register(ItemBase.RAW_PLATINUM,"Platinum");
        }
    }

//配方注册
    public static void register(Item input, String outputOD) {
        /*输入物*/ItemStack inputStack = new ItemStack(input);

        int amount = 1;
        if (!outputOD.contains("prillPlatinum")) {//非铂颗粒进入
            String inputStackName = inputStack.toString();

            if (inputStackName.contains("raw") || inputStackName.contains("prill_platina")) {
                String type = "crushed";
                if (Examine.IC2ClassicSpmodID) {
                    //经典版无碎块
                    type = "dust";
                }

                outputOD = type + outputOD;
                amount = ConfigValue.maceratorRawOutputAmount;
            } else if (inputStackName.contains("ingot")) {
                amount = ConfigValue.maceratorIngotOutputAmount;
            }
        }

        /*输出物*/ItemStack outputStack = ItemBase.oreStack(outputOD, amount);

        if (ItemBase.isValidItemStack(inputStack) && !outputStack.isEmpty()) {
            /*注册打粉机配方*/Recipes.macerator.addRecipe(Recipes.inputFactory.forStack(inputStack), null, false, outputStack);
        }
    }
}
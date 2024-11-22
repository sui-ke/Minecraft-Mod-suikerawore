package suike.suikerawore.expand.ic2;

import suike.suikerawore.item.ItemBase;
import suike.suikerawore.config.ConfigValue;
import suike.suikerawore.expand.Examine;

import ic2.api.recipe.Recipes;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraftforge.oredict.OreDictionary;

//打粉机配方
public class MaceratorRecipeClassic {
    public static void register() {
    //粗矿>粉
        /*金粉*/registerMac(ItemBase.RAW_GOLD, "dustGold");
        /*铁粉*/registerMac(ItemBase.RAW_IRON, "dustIron");
        /*铜粉*/registerMac(ItemBase.RAW_COPPER, "dustCopper");
        /*锡粉*/registerMac(ItemBase.RAW_TIN, "dustTin");
        /*锌粉*/registerMac(ItemBase.RAW_ZINC, "dustZinc");
        /*铅粉*/registerMac(ItemBase.RAW_LEAD, "dustLead");
        /*银粉*/registerMac(ItemBase.RAW_SILVER, "dustSilver");
        /*钴粉*/registerMac(ItemBase.RAW_COBALT, "dustCobalt");
        /*锇粉*/registerMac(ItemBase.RAW_OSMIUM, "dustOsmium");
        /*镍粉*/registerMac(ItemBase.RAW_NICKEL, "dustNickel");
        /*铱粉*/registerMac(ItemBase.RAW_IRIDIUM, "dustIridium");
        /*铀粉*/registerMac(ItemBase.RAW_URANIUM, "dropUranium");
        /*镓粉*/registerMac(ItemBase.RAW_GALLIUM, "dustGallium");
        /*钛粉*/registerMac(ItemBase.RAW_TITANIUM, "dustTitanium");
        /*钨粉*/registerMac(ItemBase.RAW_TUNGSTEN, "dustTungsten");
        /*铝粉*/registerMac(ItemBase.RAW_ALUMINIUM, "dustAluminium");
        /*镁粉*/registerMac(ItemBase.RAW_MAGNESIUM, "dustMagnesium");
        /*锂粉*/registerMac(ItemBase.RAW_LITHIUM, "dustLithium");
        /*钍粉*/registerMac(ItemBase.RAW_THORIUM, "dustThorium");
        /*硼粉*/registerMac(ItemBase.RAW_BORON, "dustBoron");
        /*钒粉*/registerMac(ItemBase.RAW_VANADIUM, "dustVanadium");
        /*镉粉*/registerMac(ItemBase.RAW_CADMIUM, "dustCadmium");
        /*锰粉*/registerMac(ItemBase.RAW_MANGANESE, "dustManganese");
        /*锗粉*/registerMac(ItemBase.RAW_GERMANIUM, "dustGermanium");
        /*铬粉*/registerMac(ItemBase.RAW_CHROMIUM, "dustChromium");
        /*砷粉*/registerMac(ItemBase.RAW_ARSENIC, "dustArsenic");

    //锭>粉
        /*铜粉*/registerMac(ItemBase.INGOT_COPPER, "dustCopper");
        /*锡粉*/registerMac(ItemBase.INGOT_TIN, "dustTin");
        /*锌粉*/registerMac(ItemBase.INGOT_ZINC, "dustZinc");
        /*铅粉*/registerMac(ItemBase.INGOT_LEAD, "dustLead");
        /*银粉*/registerMac(ItemBase.INGOT_SILVER, "dustSilver");
        /*钴粉*/registerMac(ItemBase.INGOT_COBALT, "dustCobalt");
        /*锇粉*/registerMac(ItemBase.INGOT_OSMIUM, "dustOsmium");
        /*镍粉*/registerMac(ItemBase.INGOT_NICKEL, "dustNickel");
        /*铱粉*/registerMac(ItemBase.INGOT_IRIDIUM, "dustIridium");
        /*铀粉*/registerMac(ItemBase.INGOT_URANIUM, "dustUranium");
        /*镓粉*/registerMac(ItemBase.INGOT_GALLIUM, "dustGallium");
        /*钛粉*/registerMac(ItemBase.INGOT_TITANIUM, "dustTitanium");
        /*铂粉*/registerMac(ItemBase.INGOT_PLATINUM, "dustPlatinum");
        /*钨粉*/registerMac(ItemBase.INGOT_TUNGSTEN, "dustTungsten");
        /*铝粉*/registerMac(ItemBase.INGOT_ALUMINIUM, "dustAluminium");
        /*镁粉*/registerMac(ItemBase.INGOT_MAGNESIUM, "dustMagnesium");
        /*锂粉*/registerMac(ItemBase.INGOT_LITHIUM, "dustLithium");
        /*钍粉*/registerMac(ItemBase.INGOT_THORIUM, "dustThorium");
        /*硼粉*/registerMac(ItemBase.INGOT_BORON, "dustBoron");
        /*钒粉*/registerMac(ItemBase.INGOT_VANADIUM, "dustVanadium");
        /*镉粉*/registerMac(ItemBase.INGOT_CADMIUM, "dustCadmium");
        /*锰粉*/registerMac(ItemBase.INGOT_MANGANESE, "dustManganese");
        /*锗粉*/registerMac(ItemBase.INGOT_GERMANIUM, "dustGermanium");
        /*铬粉*/registerMac(ItemBase.INGOT_CHROMIUM, "dustChromium");
        /*砷粉*/registerMac(ItemBase.INGOT_ARSENIC, "dustArsenic");

        if (Examine.iridiumsourceID) {
            /*铂颗粒*/registerMac(ItemBase.RAW_PLATINUM, "prillPlatinum");
            /*铂粉*/registerMac(Item.getByNameOrId("iridiumsource:prill_platina"), "dustPlatinum");
        } else {
            /*铂粉*/registerMac(ItemBase.RAW_PLATINUM, "dustPlatinum");
        }

        /*压缩铜板*/registerCom(ItemBase.INGOT_COPPER, "ic2:itemmisc", 259);
    }

//打粉机配方注册
    public static void registerMac(Item inputItem, String outputOD) {
        /*输入物*/ItemStack inputStack = new ItemStack(inputItem);

        if (ItemBase.isValidItemStack(inputStack)) {

            String itemName = inputStack.getItem().getRegistryName().toString();

            int amount = 1;
            if (itemName.toLowerCase().contains("raw")) {
                amount = ConfigValue.IC2ClassicMaceratorRawOreOutputAmount;
            } else if (itemName.toLowerCase().contains("ingot")) {
                amount = ConfigValue.IC2ClassicMaceratorIngotOutputAmount;
            }

            /*输出物*/ItemStack outputStack = ItemBase.oreStack(outputOD, amount);

            if (!outputStack.isEmpty()) {
                /*注册打粉机配方*/Recipes.macerator.addRecipe(Recipes.inputFactory.forStack(inputStack), null, false, outputStack);
            }
        }
    }

//压缩机配方注册
    public static void registerCom(Item inputItem, String outputName, int mate) {
        /*输入物*/ItemStack inputStack = new ItemStack(inputItem, 8);
        /*输出物*/ItemStack outputStack = new ItemStack(Item.getByNameOrId(outputName), 1, mate);

        if (ItemBase.isValidItemStack(inputStack, outputStack)) {
            /*注册压缩机配方*/Recipes.compressor.addRecipe(Recipes.inputFactory.forStack(inputStack), null, false, outputStack);
        }
    }
}
package suike.suikerawore.expand.mekanism;

import suike.suikerawore.item.ItemBase;
import suike.suikerawore.config.ConfigValue;

import mekanism.api.gas.Gas;
import mekanism.api.gas.GasRegistry;
import mekanism.common.recipe.RecipeHandler;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraftforge.oredict.OreDictionary;

//化学压射室配方-粗矿>碎片
public class ChemicalInjectionChamberRecipe {
    public static void register() {
        /*金碎片*/register(ItemBase.RAW_GOLD, "shardGold");
        /*铁碎片*/register(ItemBase.RAW_IRON, "shardIron");
        /*铜碎片*/register(ItemBase.RAW_COPPER, "shardCopper");
        /*锡碎片*/register(ItemBase.RAW_TIN, "shardTin");
        /*锌碎片*/register(ItemBase.RAW_ZINC, "shardZinc");
        /*铅碎片*/register(ItemBase.RAW_LEAD, "shardLead");
        /*银碎片*/register(ItemBase.RAW_SILVER, "shardSilver");
        /*钴碎片*/register(ItemBase.RAW_COBALT, "shardCobalt");
        /*锇碎片*/register(ItemBase.RAW_OSMIUM, "shardOsmium");
        /*镍碎片*/register(ItemBase.RAW_NICKEL, "shardNickel");
        /*铱碎片*/register(ItemBase.RAW_IRIDIUM, "shardIridium");
        /*铀碎片*/register(ItemBase.RAW_URANIUM, "shardUranium");
        /*镓碎片*/register(ItemBase.RAW_GALLIUM, "shardGallium");
        /*钛碎片*/register(ItemBase.RAW_TITANIUM, "shardTitanium");
        /*铂碎片*/register(ItemBase.RAW_PLATINUM, "shardPlatinum");
        /*钨碎片*/register(ItemBase.RAW_TUNGSTEN, "shardTungsten");
        /*铝碎片*/register(ItemBase.RAW_ALUMINIUM, "shardAluminium");
        /*镁碎片*/register(ItemBase.RAW_MAGNESIUM, "shardMagnesium");
        /*锂碎片*/register(ItemBase.RAW_LITHIUM, "shardLithium");
        /*钍碎片*/register(ItemBase.RAW_THORIUM, "shardThorium");
        /*硼碎片*/register(ItemBase.RAW_BORON, "shardBoron");
        /*钒碎片*/register(ItemBase.RAW_VANADIUM, "shardVanadium");
        /*镉碎片*/register(ItemBase.RAW_CADMIUM, "shardCadmium");
        /*锰碎片*/register(ItemBase.RAW_MANGANESE, "shardManganese");
        /*锗碎片*/register(ItemBase.RAW_GERMANIUM, "shardGermanium");
        /*铬碎片*/register(ItemBase.RAW_CHROMIUM, "shardChromium");
        /*砷碎片*/register(ItemBase.RAW_ARSENIC, "shardArsenic");
        /*铍碎片*/register(ItemBase.RAW_BERYLLIUM, "shardBeryllium");
        /*镭碎片*/register(ItemBase.RAW_IRRADIUM, "shardIrradium");
        /*钯碎片*/register(ItemBase.RAW_PALLADIUM, "shardPalladium");
        /*钚碎片*/register(ItemBase.RAW_PLUTONIUM, "shardPlutonium");
        /*秘银碎片*/register(ItemBase.RAW_MITHRIL, "shardMithril");
        /*金红石碎片*/register(ItemBase.RAW_RUTILE, "shardRutile");
    }

//配方注册
    public static Gas gas = GasRegistry.getGas("hydrogenchloride");
    public static void register(Item input, String outputOreDict) {
        ItemStack inputStack = new ItemStack(input);
        ItemStack outputStack = ItemBase.oreStack(outputOreDict);

        if (ItemBase.isValidItemStack(inputStack, outputStack)) {
            /*设置数量*/outputStack.setCount(ConfigValue.ChemicalInjectionChamberOutputAmount);
            /*配方注册*/RecipeHandler.addChemicalInjectionChamberRecipe(inputStack, gas, outputStack);
        }
    }
}
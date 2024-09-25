package suike.suikerawore.expand.mekanism;

import suike.suikerawore.item.ItemBase;
import suike.suikerawore.config.ConfigValue;

import mekanism.common.recipe.RecipeHandler;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import net.minecraftforge.oredict.OreDictionary;

//净化仓-粗矿>碎块
public class PurificationChamberRecipe {
    public static void register() {
        /*金碎块*/register(ItemBase.RAW_GOLD, "clumpGold");
        /*铁碎块*/register(ItemBase.RAW_IRON, "clumpIron");
        /*铜碎块*/register(ItemBase.RAW_COPPER, "clumpCopper");
        /*锡碎块*/register(ItemBase.RAW_TIN, "clumpTin");
        /*锌碎块*/register(ItemBase.RAW_ZINC, "clumpZinc");
        /*铅碎块*/register(ItemBase.RAW_LEAD, "clumpLead");
        /*银碎块*/register(ItemBase.RAW_SILVER, "clumpSilver");
        /*钴碎块*/register(ItemBase.RAW_COBALT, "clumpCobalt");
        /*锇碎块*/register(ItemBase.RAW_OSMIUM, "clumpOsmium");
        /*镍碎块*/register(ItemBase.RAW_NICKEL, "clumpNickel");
        /*铱碎块*/register(ItemBase.RAW_IRIDIUM, "clumpIridium");
        /*铀碎块*/register(ItemBase.RAW_URANIUM, "clumpUranium");
        /*镓碎块*/register(ItemBase.RAW_GALLIUM, "clumpGallium");
        /*钛碎块*/register(ItemBase.RAW_TITANIUM, "clumpTitanium");
        /*铂碎块*/register(ItemBase.RAW_PLATINUM, "clumpPlatinum");
        /*钨碎块*/register(ItemBase.RAW_TUNGSTEN, "clumpTungsten");
        /*铝碎块*/register(ItemBase.RAW_ALUMINIUM, "clumpAluminium");
        /*镁碎块*/register(ItemBase.RAW_MAGNESIUM, "clumpMagnesium");
        /*锂碎块*/register(ItemBase.RAW_LITHIUM, "clumpLithium");
        /*钍碎块*/register(ItemBase.RAW_THORIUM, "clumpThorium");
        /*硼碎块*/register(ItemBase.RAW_BORON, "clumpBoron");
        /*钒碎块*/register(ItemBase.RAW_VANADIUM, "clumpVanadium");
        /*镉碎块*/register(ItemBase.RAW_CADMIUM, "clumpCadmium");
        /*锰碎块*/register(ItemBase.RAW_MANGANESE, "clumpManganese");
        /*锗碎块*/register(ItemBase.RAW_GERMANIUM, "clumpGermanium");
        /*铬碎块*/register(ItemBase.RAW_CHROMIUM, "clumpChromium");
        /*砷碎块*/register(ItemBase.RAW_ARSENIC, "clumpArsenic");
    }

//配方注册
    public static void register(Item input, String outputOD) {
        NonNullList<ItemStack> outputList = OreDictionary.getOres(outputOD);

        if (!outputList.isEmpty()) {
            ItemStack inputStack = new ItemStack(input);
            ItemStack outputStack = outputList.get(0).copy();
            outputStack.setCount(ConfigValue.PurificationOutputAmount);//设置数量

            RecipeHandler.addPurificationChamberRecipe(inputStack, outputStack);
        }
    }
}
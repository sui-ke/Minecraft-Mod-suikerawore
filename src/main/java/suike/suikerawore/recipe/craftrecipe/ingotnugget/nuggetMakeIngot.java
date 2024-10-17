package suike.suikerawore.recipe.craftrecipe.ingotnugget;

import suike.suikerawore.SuiKe;
import suike.suikerawore.item.ItemBase;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import net.minecraftforge.oredict.OreIngredient;
import net.minecraftforge.fml.common.registry.GameRegistry;

//粒->锭
public class nuggetMakeIngot {
    public static void register() {
        /*铜锭*/register("nuggetCopper", ItemBase.INGOT_COPPER);
        /*锡锭*/register("nuggetTin", ItemBase.INGOT_TIN);
        /*锌锭*/register("nuggetZinc", ItemBase.INGOT_ZINC);
        /*铅锭*/register("nuggetLead", ItemBase.INGOT_LEAD);
        /*银锭*/register("nuggetSilver", ItemBase.INGOT_SILVER);
        /*钴锭*/register("nuggetCobalt", ItemBase.INGOT_COBALT);
        /*锇锭*/register("nuggetOsmium", ItemBase.INGOT_OSMIUM);
        /*镍锭*/register("nuggetNickel", ItemBase.INGOT_NICKEL);
        /*铱锭*/register("nuggetIridium", ItemBase.INGOT_IRIDIUM);
        /*铀锭*/register("nuggetUranium", ItemBase.INGOT_URANIUM);
        /*镓锭*/register("nuggetGallium", ItemBase.INGOT_GALLIUM);
        /*钛锭*/register("nuggetTitanium", ItemBase.INGOT_TITANIUM);
        /*铂锭*/register("nuggetPlatinum", ItemBase.INGOT_PLATINUM);
        /*钨锭*/register("nuggetTungsten", ItemBase.INGOT_TUNGSTEN);
        /*铝锭*/register("nuggetAluminum", ItemBase.INGOT_ALUMINIUM);
        /*铝锭*/register("nuggetAluminium", ItemBase.INGOT_ALUMINIUM);
        /*镁锭*/register("nuggetMagnesium", ItemBase.INGOT_MAGNESIUM);
        /*锂锭*/register("nuggetLithium", ItemBase.INGOT_LITHIUM);
        /*钍锭*/register("nuggetThorium", ItemBase.INGOT_THORIUM);
        /*硼锭*/register("nuggetBoron", ItemBase.INGOT_BORON);
        /*钒锭*/register("nuggetVanadium", ItemBase.INGOT_VANADIUM);
        /*镉锭*/register("nuggetCadmium", ItemBase.INGOT_CADMIUM);
        /*锰锭*/register("nuggetManganese", ItemBase.INGOT_MANGANESE);
        /*锗锭*/register("nuggetGermanium", ItemBase.INGOT_GERMANIUM);
        /*铬锭*/register("nuggetChromium", ItemBase.INGOT_CHROMIUM);
        /*砷锭*/register("nuggetArsenic", ItemBase.INGOT_ARSENIC);
    }

//配方注册
    public static void register(String inputOD, Item output) {
        OreIngredient inputStack = new OreIngredient(inputOD);
        ItemStack outputStack = new ItemStack(output).copy();

        GameRegistry.addShapedRecipe(
            new ResourceLocation(SuiKe.MODID, inputOD + ">ingot"),//配方标识符
            new ResourceLocation(SuiKe.MODID),//分组名
            outputStack,
            "AAA",
            "AAA",
            "AAA",
            'A', inputStack
        );
    }
}
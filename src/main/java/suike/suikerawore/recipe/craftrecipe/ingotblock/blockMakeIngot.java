package suike.suikerawore.recipe.craftrecipe.ingotblock;

import suike.suikerawore.SuiKe;
import suike.suikerawore.item.ItemBase;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import net.minecraftforge.oredict.OreIngredient;
import net.minecraftforge.fml.common.registry.GameRegistry;

//块->锭
public class blockMakeIngot {
    public static void register() {
        /*铜锭*/register("blockCopper", ItemBase.INGOT_COPPER);
        /*锡锭*/register("blockTin", ItemBase.INGOT_TIN);
        /*锌锭*/register("blockZinc", ItemBase.INGOT_ZINC);
        /*铅锭*/register("blockLead", ItemBase.INGOT_LEAD);
        /*银锭*/register("blockSilver", ItemBase.INGOT_SILVER);
        /*钴锭*/register("blockCobalt", ItemBase.INGOT_COBALT);
        /*锇锭*/register("blockOsmium", ItemBase.INGOT_OSMIUM);
        /*镍锭*/register("blockNickel", ItemBase.INGOT_NICKEL);
        /*铱锭*/register("blockIridium", ItemBase.INGOT_IRIDIUM);
        /*铀锭*/register("blockUranium", ItemBase.INGOT_URANIUM);
        /*镓锭*/register("blockGallium", ItemBase.INGOT_GALLIUM);
        /*钛锭*/register("blockTitanium", ItemBase.INGOT_TITANIUM);
        /*铂锭*/register("blockPlatinum", ItemBase.INGOT_PLATINUM);
        /*钨锭*/register("blockTungsten", ItemBase.INGOT_TUNGSTEN);
        /*铝锭*/register("blockAluminum", ItemBase.INGOT_ALUMINIUM);
        /*铝锭*/register("blockAluminium", ItemBase.INGOT_ALUMINIUM);
        /*镁锭*/register("blockMagnesium", ItemBase.INGOT_MAGNESIUM);
        /*锂锭*/register("blockLithium", ItemBase.INGOT_LITHIUM);
        /*钍锭*/register("blockThorium", ItemBase.INGOT_THORIUM);
        /*硼锭*/register("blockBoron", ItemBase.INGOT_BORON);
        /*钒锭*/register("blockVanadium", ItemBase.INGOT_VANADIUM);
        /*镉锭*/register("blockCadmium", ItemBase.INGOT_CADMIUM);
        /*锰锭*/register("blockManganese", ItemBase.INGOT_MANGANESE);
        /*锗锭*/register("blockGermanium", ItemBase.INGOT_GERMANIUM);
        /*铬锭*/register("blockChromium", ItemBase.INGOT_CHROMIUM);
        /*砷锭*/register("blockArsenic", ItemBase.INGOT_ARSENIC);
    }

//配方注册
    public static void register(String inputOD, Item output) {
        OreIngredient inputStack = new OreIngredient(inputOD);
        ItemStack outputStack = new ItemStack(output).copy();
        outputStack.setCount(9);//设置数量

        GameRegistry.addShapedRecipe(
            new ResourceLocation(SuiKe.MODID, inputOD + ">ingot"),//配方标识符
            new ResourceLocation(SuiKe.MODID),//分组名
            outputStack,
            "A",
            'A', inputStack
        );
    }
}
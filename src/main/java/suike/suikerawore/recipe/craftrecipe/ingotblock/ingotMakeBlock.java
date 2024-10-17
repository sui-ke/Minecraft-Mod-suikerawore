package suike.suikerawore.recipe.craftrecipe.ingotblock;

import suike.suikerawore.SuiKe;
import suike.suikerawore.item.BlockBase;
import suike.suikerawore.expand.Examine;

import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import net.minecraftforge.oredict.OreIngredient;
import net.minecraftforge.fml.common.registry.GameRegistry;

//锭->块
public class ingotMakeBlock {
    public static void register() {
        /*锡块*/register("ingotTin", BlockBase.BLOCK_TIN);
        /*锌块*/register("ingotZinc", BlockBase.BLOCK_ZINC);
        /*铅块*/register("ingotLead", BlockBase.BLOCK_LEAD);
        /*银块*/register("ingotSilver", BlockBase.BLOCK_SILVER);
        /*钴块*/register("ingotCobalt", BlockBase.BLOCK_COBALT);
        /*锇块*/register("ingotOsmium", BlockBase.BLOCK_OSMIUM);
        /*镍块*/register("ingotNickel", BlockBase.BLOCK_NICKEL);
        /*铱块*/register("ingotIridium", BlockBase.BLOCK_IRIDIUM);
        /*铀块*/register("ingotUranium", BlockBase.BLOCK_URANIUM);
        /*镓块*/register("ingotGallium", BlockBase.BLOCK_GALLIUM);
        /*钛块*/register("ingotTitanium", BlockBase.BLOCK_TITANIUM);
        /*铂块*/register("ingotPlatinum", BlockBase.BLOCK_PLATINUM);
        /*钨块*/register("ingotTungsten", BlockBase.BLOCK_TUNGSTEN);
        /*铝块*/register("ingotAluminum", BlockBase.BLOCK_ALUMINIUM);
        /*铝块*/register("ingotAluminium", BlockBase.BLOCK_ALUMINIUM);
        /*镁块*/register("ingotMagnesium", BlockBase.BLOCK_MAGNESIUM);
        /*锂块*/register("ingotLithium", BlockBase.BLOCK_LITHIUM);
        /*钍块*/register("ingotThorium", BlockBase.BLOCK_THORIUM);
        /*硼块*/register("ingotBoron", BlockBase.BLOCK_BORON);
        /*钒块*/register("ingotVanadium", BlockBase.BLOCK_VANADIUM);
        /*镉块*/register("ingotCadmium", BlockBase.BLOCK_CADMIUM);
        /*锰块*/register("ingotManganese", BlockBase.BLOCK_MANGANESE);
        /*锗块*/register("ingotGermanium", BlockBase.BLOCK_GERMANIUM);
        /*铬块*/register("ingotChromium", BlockBase.BLOCK_CHROMIUM);
        /*砷块*/register("ingotArsenic", BlockBase.BLOCK_ARSENIC);

        if (Examine.deeperdepthsID) {
            /*铜块*/register("ingotCopper", Block.getBlockFromItem(Item.getByNameOrId("deeperdepths:copper_block")));
        } else {
            /*铜块*/register("ingotCopper", BlockBase.BLOCK_COPPER);
        }
    }

//配方注册
    public static void register(String inputOD, Block output) {
        //获取物品注册名
        String outputName = output.getRegistryName().toString().replaceAll(".*:", "").trim();

        OreIngredient inputStack = new OreIngredient(inputOD);
        ItemStack outputStack = new ItemStack(output);

        GameRegistry.addShapedRecipe(
            new ResourceLocation(SuiKe.MODID, inputOD + ">" + outputName),//配方标识符
            new ResourceLocation(SuiKe.MODID),//分组名
            outputStack,
            "AAA",
            "AAA",
            "AAA",
            'A', inputStack
        );
    }
}
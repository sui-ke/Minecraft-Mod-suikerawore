package suike.suikerawore.recipe.craftrecipe.ingotblock;

import suike.suikerawore.SuiKe;
import suike.suikerawore.item.ItemBase;
import suike.suikerawore.item.BlockBase;
import suike.suikerawore.expand.Examine;

import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import net.minecraftforge.oredict.OreIngredient;
import net.minecraftforge.fml.common.registry.GameRegistry;

//锭->块
public class IngotMakeBlock {
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

        ItemStack item = new ItemStack(Item.getByNameOrId("libvulpes:metal0"), 1, 7);
        if (ItemBase.isValidItemStack(item)) {
            /*钛块*/register("ingotTitanium", item);
        } else {
            /*钛块*/register("ingotTitanium", BlockBase.BLOCK_TITANIUM);
        }
    }

//配方注册
    public static void register(String inputOreDict, Block output) {
        ItemStack outputStack = new ItemStack(output);
        register(inputOreDict, outputStack);
    }
    public static void register(String inputOreDict, ItemStack outputStack) {
        if (outputStack.getItem() instanceof ItemBase) {
            if (!ItemBase.ITEMS.contains(outputStack.getItem())) return;
        }

        if (ItemBase.isValidItemStack(outputStack)) {
            OreIngredient inputStack = new OreIngredient(inputOreDict);
            //获取物品注册名
            String outputName = outputStack.getItem().getRegistryName().toString().replaceAll(".*:", "").trim();

            GameRegistry.addShapedRecipe(
                new ResourceLocation(SuiKe.MODID, inputOreDict + ">" + outputName),//配方标识符
                new ResourceLocation(SuiKe.MODID),//分组名
                outputStack,
                "AAA",
                "AAA",
                "AAA",
                'A', inputStack
            );
        }
    }
}
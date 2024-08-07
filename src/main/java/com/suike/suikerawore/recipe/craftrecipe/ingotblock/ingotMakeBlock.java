package com.suike.suikerawore.recipe.craftrecipe.ingotblock;

import com.suike.suikerawore.SuiKe;
import com.suike.suikerawore.item.BlockBase;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import net.minecraftforge.oredict.OreIngredient;
import net.minecraftforge.fml.common.registry.GameRegistry;

//锭->块
public class ingotMakeBlock {
    public static void register() {
        /*铜锭*/register("ingotCopper", BlockBase.BLOCK_COPPER);
        /*锡锭*/register("ingotTin", BlockBase.BLOCK_TIN);
        /*锌锭*/register("ingotZinc", BlockBase.BLOCK_ZINC);
        /*铅锭*/register("ingotLead", BlockBase.BLOCK_LEAD);
        /*银锭*/register("ingotSilver", BlockBase.BLOCK_SILVER);
        /*钴锭*/register("ingotCobalt", BlockBase.BLOCK_COBALT);
        /*锇锭*/register("ingotOsmium", BlockBase.BLOCK_OSMIUM);
        /*镍锭*/register("ingotNickel", BlockBase.BLOCK_NICKEL);
        /*铱锭*/register("ingotIridium", BlockBase.BLOCK_IRIDIUM);
        /*铀锭*/register("ingotUranium", BlockBase.BLOCK_URANIUM);
        /*镓锭*/register("ingotGallium", BlockBase.BLOCK_GALLIUM);
        /*钛锭*/register("ingotTitanium", BlockBase.BLOCK_TITANIUM);
        /*铂锭*/register("ingotPlatinum", BlockBase.BLOCK_PLATINUM);
        /*钨锭*/register("ingotTungsten", BlockBase.BLOCK_TUNGSTEN);
        /*铝锭*/register("ingotAluminum", BlockBase.BLOCK_ALUMINIUM);
        /*铝锭*/register("ingotAluminium", BlockBase.BLOCK_ALUMINIUM);
        /*镁锭*/register("ingotMagnesium", BlockBase.BLOCK_MAGNESIUM);
        /*锂锭*/register("ingotLithium", BlockBase.BLOCK_LITHIUM);
        /*钍锭*/register("ingotThorium", BlockBase.BLOCK_THORIUM);
        /*硼锭*/register("ingotBoron", BlockBase.BLOCK_BORON);
    }

    public static void register(String inputOD, Block output) {
        //获取物品注册名
        String outputName = output.getRegistryName().toString().replaceAll(".*:", "").trim();

        OreIngredient newInput = new OreIngredient(inputOD);
        ItemStack newOutput = new ItemStack(output);

        GameRegistry.addShapedRecipe(
            new ResourceLocation(SuiKe.MODID, inputOD + ">" + outputName),//配方标识符
            new ResourceLocation(SuiKe.MODID),//分组名
            newOutput,
            "AAA",
            "AAA",
            "AAA",
            'A', newInput
        );
    }
}
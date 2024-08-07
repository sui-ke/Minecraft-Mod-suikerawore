package com.suike.suikerawore.recipe.craftrecipe.rawblock;

import com.suike.suikerawore.SuiKe;
import com.suike.suikerawore.item.ItemBase;
import com.suike.suikerawore.item.BlockBase;

import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import net.minecraftforge.fml.common.registry.GameRegistry;

//粗矿->块
public class rawMakeBlock {
    public static void register() {
        /*粗金块*/register(ItemBase.RAW_GOLD, BlockBase.RAW_BLOCK_GOLD);
        /*粗铁块*/register(ItemBase.RAW_IRON, BlockBase.RAW_BLOCK_IRON);
        /*粗铜块*/register(ItemBase.RAW_COPPER, BlockBase.RAW_BLOCK_COPPER);
        /*粗锡块*/register(ItemBase.RAW_TIN, BlockBase.RAW_BLOCK_TIN);
        /*粗锌块*/register(ItemBase.RAW_ZINC, BlockBase.RAW_BLOCK_ZINC);
        /*粗铅块*/register(ItemBase.RAW_LEAD, BlockBase.RAW_BLOCK_LEAD);
        /*粗银块*/register(ItemBase.RAW_SILVER, BlockBase.RAW_BLOCK_SILVER);
        /*粗钴块*/register(ItemBase.RAW_COBALT, BlockBase.RAW_BLOCK_COBALT);
        /*粗锇块*/register(ItemBase.RAW_OSMIUM, BlockBase.RAW_BLOCK_OSMIUM);
        /*粗镍块*/register(ItemBase.RAW_NICKEL, BlockBase.RAW_BLOCK_NICKEL);
        /*粗铱块*/register(ItemBase.RAW_IRIDIUM, BlockBase.RAW_BLOCK_IRIDIUM);
        /*粗铀块*/register(ItemBase.RAW_URANIUM, BlockBase.RAW_BLOCK_URANIUM);
        /*粗镓块*/register(ItemBase.RAW_GALLIUM, BlockBase.RAW_BLOCK_GALLIUM);
        /*粗钛块*/register(ItemBase.RAW_TITANIUM, BlockBase.RAW_BLOCK_TITANIUM);
        /*粗铂块*/register(ItemBase.RAW_PLATINUM, BlockBase.RAW_BLOCK_PLATINUM);
        /*粗钨块*/register(ItemBase.RAW_TUNGSTEN, BlockBase.RAW_BLOCK_TUNGSTEN);
        /*粗铝块*/register(ItemBase.RAW_ALUMINIUM, BlockBase.RAW_BLOCK_ALUMINIUM);
        /*粗镁块*/register(ItemBase.RAW_MAGNESIUM, BlockBase.RAW_BLOCK_MAGNESIUM);
        /*粗锂块*/register(ItemBase.RAW_LITHIUM, BlockBase.RAW_BLOCK_LITHIUM);
        /*粗钍块*/register(ItemBase.RAW_THORIUM, BlockBase.RAW_BLOCK_THORIUM);
        /*粗硼块*/register(ItemBase.RAW_BORON, BlockBase.RAW_BLOCK_BORON);

        /*粗阿迪特块*/register(ItemBase.RAW_ARDITE, BlockBase.RAW_BLOCK_ARDITE);

        /*粗晶蓝块*/register(ItemBase.RAW_CERULEAN, BlockBase.RAW_BLOCK_CERULEAN);
        /*粗皎月石块*/register(ItemBase.RAW_MOONSTONE, BlockBase.RAW_BLOCK_MOONSTONE);

        /*粗炽炎铁块*/register(ItemBase.RAW_OCTINE, BlockBase.RAW_BLOCK_OCTINE);
        /*粗赛摩铜块*/register(ItemBase.RAW_SYRMORITE, BlockBase.RAW_BLOCK_SYRMORITE);
    }

    public static void register(Item input, Block output) {
        if (!ItemBase.ITEMS.contains(input)) {return;}
        if (!BlockBase.BLOCKS.contains(output)) {return;}

        //获取物品注册名
        String inputName = input.getRegistryName().toString().replaceAll(".*:", "").trim();
        String outputName = output.getRegistryName().toString().replaceAll(".*:", "").trim();

        ItemStack newInput = new ItemStack(input);
        ItemStack newOutput = new ItemStack(output);

        GameRegistry.addShapedRecipe(
            new ResourceLocation(SuiKe.MODID, inputName + ">" + outputName),//配方标识符
            new ResourceLocation(SuiKe.MODID),//分组名
            newOutput,
            "AAA",
            "AAA",
            "AAA",
            'A', newInput
        );
    }
}
package suike.suikerawore.recipe.craftrecipe;

import suike.suikerawore.SuiKe;
import suike.suikerawore.item.ItemBase;
import suike.suikerawore.item.BlockBase;

import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class rawRecipe {
    public static void addRecipe() {
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
        /*粗钒块*/register(ItemBase.RAW_VANADIUM, BlockBase.RAW_BLOCK_VANADIUM);
        /*粗镉块*/register(ItemBase.RAW_CADMIUM, BlockBase.RAW_BLOCK_CADMIUM);
        /*粗锰块*/register(ItemBase.RAW_MANGANESE, BlockBase.RAW_BLOCK_MANGANESE);
        /*粗锗块*/register(ItemBase.RAW_GERMANIUM, BlockBase.RAW_BLOCK_GERMANIUM);
        /*粗铬块*/register(ItemBase.RAW_CHROMIUM, BlockBase.RAW_BLOCK_CHROMIUM);
        /*粗砷块*/register(ItemBase.RAW_ARSENIC, BlockBase.RAW_BLOCK_ARSENIC);
        /*粗铍块*/register(ItemBase.RAW_BERYLLIUM, BlockBase.RAW_BLOCK_BERYLLIUM);
        /*粗镭块*/register(ItemBase.RAW_IRRADIUM, BlockBase.RAW_BLOCK_IRRADIUM);
        /*粗钯块*/register(ItemBase.RAW_PALLADIUM, BlockBase.RAW_BLOCK_PALLADIUM);
        /*粗钚块*/register(ItemBase.RAW_PLUTONIUM, BlockBase.RAW_BLOCK_PLUTONIUM);
        /*粗铌块*/register(ItemBase.RAW_NIOBIUM, BlockBase.RAW_BLOCK_NIOBIUM);
        /*粗秘银块*/register(ItemBase.RAW_MITHRIL, BlockBase.RAW_BLOCK_MITHRIL);
        /*粗金红石块*/register(ItemBase.RAW_RUTILE, BlockBase.RAW_BLOCK_RUTILE);

        /*粗阿迪特块*/register(ItemBase.RAW_ARDITE, BlockBase.RAW_BLOCK_ARDITE);
        /*粗晶蓝块*/register(ItemBase.RAW_CERULEAN, BlockBase.RAW_BLOCK_CERULEAN);
        /*粗皎月石块*/register(ItemBase.RAW_MOONSTONE, BlockBase.RAW_BLOCK_MOONSTONE);
        /*粗炽炎铁块*/register(ItemBase.RAW_OCTINE, BlockBase.RAW_BLOCK_OCTINE);
        /*粗赛摩铜块*/register(ItemBase.RAW_SYRMORITE, BlockBase.RAW_BLOCK_SYRMORITE);
        /*粗朱砂块*/register(ItemBase.RAW_CINNABAR, BlockBase.RAW_BLOCK_CINNABAR);
        /*粗软碲铜块*/register(ItemBase.RAW_VULCANITE, BlockBase.RAW_BLOCK_VULCANITE);
        /*粗裂金块*/register(ItemBase.RAW_CHASMIUM, BlockBase.RAW_BLOCK_CHASMIUM);
        /*玫瑰金*/register(ItemBase.RAW_ROSEGOLD, BlockBase.RAW_BLOCK_ROSEGOLD);
    }

//配方注册
    public static void register(Item input, Block output) {
        if (input instanceof ItemBase) {
            if (!ItemBase.ITEMS.contains(input)) return;
        }

        ItemStack rawStack = new ItemStack(input);
        ItemStack blockStack = new ItemStack(output).copy();

        if (ItemBase.isValidItemStack(rawStack, blockStack)) {
            String inputName = input.getRegistryName().toString().replaceAll(".*:", "").trim();
            String outputName = output.getRegistryName().toString().replaceAll(".*:", "").trim();

            // 粗矿 > 块
            GameRegistry.addShapedRecipe(
                new ResourceLocation(SuiKe.MODID, outputName + ">" + inputName),
                new ResourceLocation(SuiKe.MODID),
                blockStack,
                "AAA",
                "AAA",
                "AAA",
                'A', rawStack
            );

            // 设置数量
            rawStack.setCount(9);
            // 块 > 粗矿
            GameRegistry.addShapedRecipe(
                new ResourceLocation(SuiKe.MODID, inputName + ">" + outputName),
                new ResourceLocation(SuiKe.MODID),
                rawStack,
                "A",
                'A', blockStack
            );
        }
    }
}
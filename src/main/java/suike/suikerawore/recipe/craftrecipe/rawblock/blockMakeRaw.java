package suike.suikerawore.recipe.craftrecipe.rawblock;

import suike.suikerawore.SuiKe;
import suike.suikerawore.item.ItemBase;
import suike.suikerawore.item.BlockBase;

import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import net.minecraftforge.fml.common.registry.GameRegistry;

//块->粗矿
public class blockMakeRaw {
    public static void register() {
        /*粗金*/register(BlockBase.RAW_BLOCK_GOLD, ItemBase.RAW_GOLD);
        /*粗铁*/register(BlockBase.RAW_BLOCK_IRON, ItemBase.RAW_IRON);
        /*粗铜*/register(BlockBase.RAW_BLOCK_COPPER, ItemBase.RAW_COPPER);
        /*粗锡*/register(BlockBase.RAW_BLOCK_TIN, ItemBase.RAW_TIN);
        /*粗锌*/register(BlockBase.RAW_BLOCK_ZINC, ItemBase.RAW_ZINC);
        /*粗铅*/register(BlockBase.RAW_BLOCK_LEAD, ItemBase.RAW_LEAD);
        /*粗银*/register(BlockBase.RAW_BLOCK_SILVER, ItemBase.RAW_SILVER);
        /*粗钴*/register(BlockBase.RAW_BLOCK_COBALT, ItemBase.RAW_COBALT);
        /*粗锇*/register(BlockBase.RAW_BLOCK_OSMIUM, ItemBase.RAW_OSMIUM);
        /*粗镍*/register(BlockBase.RAW_BLOCK_NICKEL, ItemBase.RAW_NICKEL);
        /*粗铱*/register(BlockBase.RAW_BLOCK_IRIDIUM, ItemBase.RAW_IRIDIUM);
        /*粗铀*/register(BlockBase.RAW_BLOCK_URANIUM, ItemBase.RAW_URANIUM);
        /*粗镓*/register(BlockBase.RAW_BLOCK_GALLIUM, ItemBase.RAW_GALLIUM);
        /*粗钛*/register(BlockBase.RAW_BLOCK_TITANIUM, ItemBase.RAW_TITANIUM);
        /*粗铂*/register(BlockBase.RAW_BLOCK_PLATINUM, ItemBase.RAW_PLATINUM);
        /*粗钨*/register(BlockBase.RAW_BLOCK_TUNGSTEN, ItemBase.RAW_TUNGSTEN);
        /*粗铝*/register(BlockBase.RAW_BLOCK_ALUMINIUM, ItemBase.RAW_ALUMINIUM);
        /*粗镁*/register(BlockBase.RAW_BLOCK_MAGNESIUM, ItemBase.RAW_MAGNESIUM);
        /*粗锂*/register(BlockBase.RAW_BLOCK_LITHIUM, ItemBase.RAW_LITHIUM);
        /*粗钍*/register(BlockBase.RAW_BLOCK_THORIUM, ItemBase.RAW_THORIUM);
        /*粗硼*/register(BlockBase.RAW_BLOCK_BORON, ItemBase.RAW_BORON);
        /*粗钒*/register(BlockBase.RAW_BLOCK_VANADIUM, ItemBase.RAW_VANADIUM);
        /*粗镉*/register(BlockBase.RAW_BLOCK_CADMIUM, ItemBase.RAW_CADMIUM);
        /*粗锰*/register(BlockBase.RAW_BLOCK_MANGANESE, ItemBase.RAW_MANGANESE);
        /*粗锗*/register(BlockBase.RAW_BLOCK_GERMANIUM, ItemBase.RAW_GERMANIUM);
        /*粗铬*/register(BlockBase.RAW_BLOCK_CHROMIUM, ItemBase.RAW_CHROMIUM);
        /*粗砷*/register(BlockBase.RAW_BLOCK_ARSENIC, ItemBase.RAW_ARSENIC);

        /*粗阿迪特*/register(BlockBase.RAW_BLOCK_ARDITE, ItemBase.RAW_ARDITE);
        /*粗晶蓝*/register(BlockBase.RAW_BLOCK_CERULEAN, ItemBase.RAW_CERULEAN);
        /*粗皎月石*/register(BlockBase.RAW_BLOCK_MOONSTONE, ItemBase.RAW_MOONSTONE);
        /*粗炽炎铁*/register(BlockBase.RAW_BLOCK_OCTINE, ItemBase.RAW_OCTINE);
        /*粗赛摩铜*/register(BlockBase.RAW_BLOCK_SYRMORITE, ItemBase.RAW_SYRMORITE);
        /*粗朱砂*/register(BlockBase.RAW_BLOCK_CINNABAR, ItemBase.RAW_CINNABAR);
        /*软碲铜*/register(BlockBase.RAW_BLOCK_VULCANITE, ItemBase.RAW_VULCANITE);
        /* 裂金 */register(BlockBase.RAW_BLOCK_CHASMIUM, ItemBase.RAW_CHASMIUM);
        /*玫瑰金*/register(BlockBase.RAW_BLOCK_ROSEGOLD, ItemBase.RAW_ROSEGOLD);
    }

//配方注册
    public static void register(Block input, Item output) {
        ItemStack inputStack = new ItemStack(input);
        ItemStack outputStack = new ItemStack(output).copy();
        outputStack.setCount(9);//设置数量

        if (ItemBase.isValidItemStack(inputStack)) {
            String inputName = input.getRegistryName().toString().replaceAll(".*:", "").trim();
            String outputName = output.getRegistryName().toString().replaceAll(".*:", "").trim();

            GameRegistry.addShapedRecipe(
                new ResourceLocation(SuiKe.MODID, inputName + ">" + outputName),//配方标识符
                new ResourceLocation(SuiKe.MODID),//分组名
                outputStack,
                "A",
                'A', inputStack
            );
        }
    }
}
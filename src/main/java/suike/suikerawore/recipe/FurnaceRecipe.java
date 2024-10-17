package suike.suikerawore.recipe;

import java.util.List;

import suike.suikerawore.item.ItemBase;
import suike.suikerawore.item.BlockBase;
import suike.suikerawore.expand.Examine;
import suike.suikerawore.config.ConfigValue;

import thedarkcolour.futuremc.recipe.furnace.BlastFurnaceRecipes;
import cofh.thermalexpansion.util.managers.machine.FurnaceManager;

import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.item.crafting.Ingredient;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.fml.common.registry.GameRegistry;

//熔炉配方
public class FurnaceRecipe {
//配方定义
    public static void register() {
        /*金*/register("Gold", Items.GOLD_INGOT, Blocks.GOLD_BLOCK);
        /*铁*/register("Iron", Items.IRON_INGOT, Blocks.IRON_BLOCK);
        /*铜*/register("Copper", ItemBase.INGOT_COPPER, BlockBase.BLOCK_COPPER);
        /*锡*/register("Tin", ItemBase.INGOT_TIN, BlockBase.BLOCK_TIN);
        /*锌*/register("Zinc", ItemBase.INGOT_ZINC, BlockBase.BLOCK_ZINC);
        /*铅*/register("Lead", ItemBase.INGOT_LEAD, BlockBase.BLOCK_LEAD);
        /*银*/register("Silver", ItemBase.INGOT_SILVER, BlockBase.BLOCK_SILVER);
        /*钴*/register("Cobalt", ItemBase.INGOT_COBALT, BlockBase.BLOCK_COBALT);
        /*锇*/register("Osmium", ItemBase.INGOT_OSMIUM, BlockBase.BLOCK_OSMIUM);
        /*镍*/register("Nickel", ItemBase.INGOT_NICKEL, BlockBase.BLOCK_NICKEL);
        /*铱*/register("Iridium", ItemBase.INGOT_IRIDIUM, BlockBase.BLOCK_IRIDIUM);
        /*铀*/register("Uranium", ItemBase.INGOT_URANIUM, BlockBase.BLOCK_URANIUM);
        /*镓*/register("Gallium", ItemBase.INGOT_GALLIUM, BlockBase.BLOCK_GALLIUM);
        /*钛*/register("Titanium", ItemBase.INGOT_TITANIUM, BlockBase.BLOCK_TITANIUM);
        /*铂*/register("Platinum", ItemBase.INGOT_PLATINUM, BlockBase.BLOCK_PLATINUM);
        /*钨*/register("Tungsten", ItemBase.INGOT_TUNGSTEN, BlockBase.BLOCK_TUNGSTEN);
        /*铝*/register("Aluminum", ItemBase.INGOT_ALUMINIUM, BlockBase.BLOCK_ALUMINIUM);
        /*铝*/register("Aluminium", ItemBase.INGOT_ALUMINIUM, BlockBase.BLOCK_ALUMINIUM);
        /*镁*/register("Magnesium", ItemBase.INGOT_MAGNESIUM, BlockBase.BLOCK_MAGNESIUM);
        /*锂*/register("Lithium", ItemBase.INGOT_LITHIUM, BlockBase.BLOCK_LITHIUM);
        /*钍*/register("Thorium", ItemBase.INGOT_THORIUM, BlockBase.BLOCK_THORIUM);
        /*硼*/register("Boron", ItemBase.INGOT_BORON, BlockBase.BLOCK_BORON);
        /*钒*/register("Vanadium", ItemBase.INGOT_VANADIUM, BlockBase.BLOCK_VANADIUM);
        /*镉*/register("Cadmium", ItemBase.INGOT_CADMIUM, BlockBase.BLOCK_CADMIUM);
        /*锰*/register("Manganese", ItemBase.INGOT_MANGANESE, BlockBase.BLOCK_MANGANESE);
        /*锗*/register("Germanium", ItemBase.INGOT_GERMANIUM, BlockBase.BLOCK_GERMANIUM);
        /*铬*/register("Chromium", ItemBase.INGOT_CHROMIUM, BlockBase.BLOCK_CHROMIUM);
        /*砷*/register("Arsenic", ItemBase.INGOT_ARSENIC, BlockBase.BLOCK_ARSENIC);

        /*阿迪特*/register(ItemBase.RAW_ARDITE, BlockBase.RAW_BLOCK_ARDITE, "Ardite");
        /* 晶蓝 */register(ItemBase.RAW_CERULEAN, BlockBase.RAW_BLOCK_CERULEAN, "Cerulean");
        /*皎月石*/register(ItemBase.RAW_MOONSTONE, BlockBase.RAW_BLOCK_MOONSTONE, "Moonstone");
        /*炽炎铁*/register(ItemBase.RAW_OCTINE, BlockBase.RAW_BLOCK_OCTINE, "Octine");
        /*赛摩铜*/register(ItemBase.RAW_SYRMORITE, BlockBase.RAW_BLOCK_SYRMORITE, "Syrmorite");
        /* 朱砂 */register(ItemBase.RAW_CINNABAR, BlockBase.RAW_BLOCK_CINNABAR, "lver");
        /*软碲铜*/register(ItemBase.RAW_VULCANITE, BlockBase.RAW_BLOCK_VULCANITE, "Vulcanite");
        /* 裂金 */register(ItemBase.RAW_CHASMIUM, BlockBase.RAW_BLOCK_CHASMIUM, "Chasmium");
        /*玫瑰金*/register(ItemBase.RAW_ROSEGOLD, BlockBase.RAW_BLOCK_ROSEGOLD, "Rosegold");
    }

//item输出
    public static void register(String inputOD, Item outputItem, Block outputBlock) {
        //定义矿词前缀
        String[] prefixes = {"raw", "rawBlock", "ore", "dust", "shard", "crushed", "crushedPurified", "purifiedcrushed", "cluster"};

        //遍历每个前缀
        for (String prefix : prefixes) {
            if (prefix.equals("rawBlock") && !ConfigValue.rawBlockSmelt) {
            //检查是否打开粗块熔炼
                continue;
            }

            //获取所有与矿词匹配的物品
            NonNullList<ItemStack> inputList = OreDictionary.getOres(prefix + inputOD);

            for (ItemStack input : inputList) {
                //选择输出物
                ItemStack outputStack = prefix.equals("rawBlock") ? new ItemStack(outputBlock) : new ItemStack(outputItem).copy();

                outputStack.setCount(ConfigValue.FurnaceOutputAmount);
                if (prefix.equals("cluster")) {
                    int amount = ConfigValue.FurnaceOutputAmount * 2;
                    outputStack.setCount(amount);
                }

                /*注册配方*/register(input, outputStack, prefix);
            }
        }
    }

//item输入
    public static void register(Item inputItem, Block blockInput, String outputOD) {
        //定义矿词前缀
        String[] prefixes = {"ingot", "block", "quicksi"};

        //遍历每个前缀
        for (String prefix : prefixes) {
            if (prefix.equals("block") && !ConfigValue.rawBlockSmelt) {
            //检查是否打开粗块熔炼
                continue;
            }

            //选择输入物
            ItemStack inputStack = prefix.equals("block") ? new ItemStack(blockInput) : new ItemStack(inputItem);

            ItemStack outputStack = ItemBase.oreStack(prefix + outputOD, ConfigValue.FurnaceOutputAmount);

            if (ItemBase.isValidItemStack(inputStack)  && ItemBase.isValidItemStack(outputStack)) {
                /*注册配方*/register(inputStack, outputStack, prefix);
            }
        }
    }

//注册配方
    public static void register(ItemStack inputStack, ItemStack outputStack, String prefix) {
        /*熔炉-配方注册*/GameRegistry.addSmelting(inputStack, outputStack, 1f);

        if (Examine.FuturemcID) {
            /*局部输入物*/Ingredient ingrInput = Ingredient.fromStacks(inputStack);
            /*未来MC-高炉-配方注册*/BlastFurnaceRecipes.INSTANCE.addRecipe(ingrInput, outputStack);
        }

        if (Examine.thermalexpansionID) {
            /*热力膨胀5-红石炉-配方注册*/FurnaceManager.addRecipe(2000, inputStack, outputStack);
        }
    }
}
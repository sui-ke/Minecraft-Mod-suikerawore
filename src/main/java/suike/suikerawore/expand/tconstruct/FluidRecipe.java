package suike.suikerawore.expand.tconstruct;

import suike.suikerawore.item.ItemBase;
import suike.suikerawore.item.BlockBase;
import suike.suikerawore.expand.Examine;
import suike.suikerawore.config.ConfigValue;

import slimeknights.tconstruct.library.TinkerRegistry;

import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

//熔液配方
public class FluidRecipe {
    public static void register() {
        /*金熔液*/register(ItemBase.RAW_GOLD, "gold");
        /*金熔液*/register(BlockBase.RAW_BLOCK_GOLD, "gold");
        /*铁熔液*/register(ItemBase.RAW_IRON, "iron");
        /*铁熔液*/register(BlockBase.RAW_BLOCK_IRON, "iron");
        /*铜熔液*/register(ItemBase.RAW_COPPER, "copper");
        /*铜熔液*/register(BlockBase.RAW_BLOCK_COPPER, "copper");
        /*锡熔液*/register(ItemBase.RAW_TIN, "tin");
        /*锡熔液*/register(BlockBase.RAW_BLOCK_TIN, "tin");
        /*锌熔液*/register(ItemBase.RAW_ZINC, "zinc");
        /*锌熔液*/register(BlockBase.RAW_BLOCK_ZINC, "zinc");
        /*铅熔液*/register(ItemBase.RAW_LEAD, "lead");
        /*铅熔液*/register(BlockBase.RAW_BLOCK_LEAD, "lead");
        /*银熔液*/register(ItemBase.RAW_SILVER, "silver");
        /*银熔液*/register(BlockBase.RAW_BLOCK_SILVER, "silver");
        /*钴熔液*/register(ItemBase.RAW_COBALT, "cobalt");
        /*钴熔液*/register(BlockBase.RAW_BLOCK_COBALT, "cobalt");
        /*镍熔液*/register(ItemBase.RAW_NICKEL, "nickel");
        /*镍熔液*/register(BlockBase.RAW_BLOCK_NICKEL, "nickel");
        /*镓熔液*/register(ItemBase.RAW_GALLIUM, "liquidgallium");
        /*镓熔液*/register(BlockBase.RAW_BLOCK_GALLIUM, "liquidgallium");
        /*铝熔液*/register(ItemBase.RAW_ALUMINIUM, "aluminum");
        /*铝熔液*/register(BlockBase.RAW_BLOCK_ALUMINIUM, "aluminum");

        /*阿迪特熔液*/register(ItemBase.RAW_ARDITE, "ardite");
        /*阿迪特熔液*/register(BlockBase.RAW_BLOCK_ARDITE, "ardite");

        /* 晶蓝 */register(ItemBase.RAW_CERULEAN, "tamoltencerulean");
        /* 晶蓝 */register(BlockBase.RAW_BLOCK_CERULEAN, "tamoltencerulean");
        /*皎月石*/register(ItemBase.RAW_MOONSTONE, "tamoltenmoonstone");
        /*皎月石*/register(BlockBase.RAW_BLOCK_MOONSTONE, "tamoltenmoonstone");

        /*炽炎铁*/register(ItemBase.RAW_OCTINE, "liquidoctine");
        /*炽炎铁*/register(BlockBase.RAW_BLOCK_OCTINE, "liquidoctine");
        /*赛摩铜*/register(ItemBase.RAW_SYRMORITE, "liquidsyrmorite");
        /*赛摩铜*/register(BlockBase.RAW_BLOCK_SYRMORITE, "liquidsyrmorite");
    }

//变量转译, 获取输出量
    public static void register(Item item, String fluidName) {
        ItemStack inputStack = new ItemStack(item);
        int amount = (int) (ConfigValue.FluidMultiple * 144);

        register(inputStack, fluidName, amount);
    }

    public static void register(Block block, String fluidName) {
        ItemStack inputStack = new ItemStack(block);
        int amount = (int) (ConfigValue.FluidMultiple * 1296);

        register(inputStack, fluidName, amount);
    }

//配方注册
    public static void register(ItemStack inputStack, String fluidName, int amount) {
        Fluid fluid = FluidRegistry.getFluid(fluidName);

        if (ItemBase.isValidItemStack(inputStack) && fluid != null) {
            /*冶炼炉配方*/TinkerRegistry.registerMelting(inputStack, fluid, amount);

            if (Examine.tcomplementID) {
                /*匠魂补充-高炉配方*/SMeltingRecipe.register(inputStack, fluid, amount);
            }
        }
    }
}
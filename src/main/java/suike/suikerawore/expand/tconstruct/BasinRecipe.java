package suike.suikerawore.expand.tconstruct;

import suike.suikerawore.item.ItemBase;
import suike.suikerawore.item.BlockBase;

import slimeknights.tconstruct.library.TinkerRegistry;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

//铸造盆配方
public class BasinRecipe {
    public static void register() {
        /*铜*/register("copper", BlockBase.BLOCK_COPPER);
        /*锡*/register("tin", BlockBase.BLOCK_TIN);
        /*锌*/register("zinc", BlockBase.BLOCK_ZINC);
        /*铅*/register("lead", BlockBase.BLOCK_LEAD);
        /*银*/register("silver", BlockBase.BLOCK_SILVER);
        /*钴*/register("cobalt", BlockBase.BLOCK_COBALT);
        /*镍*/register("nickel", BlockBase.BLOCK_NICKEL);
        /*镓*/register("liquidgallium", BlockBase.BLOCK_GALLIUM);
        /*铝*/register("aluminum", BlockBase.BLOCK_ALUMINIUM);
    }

//配方注册
    public static void register(String fluidName, Block block) {
        ItemStack blockStack = new ItemStack(block);
        Fluid fluid = FluidRegistry.getFluid(fluidName);

        if (ItemBase.isValidItemStack(blockStack) && fluid != null) {
            TinkerRegistry.registerBasinCasting(blockStack, ItemStack.EMPTY, fluid, 1296);
        }
    }
}
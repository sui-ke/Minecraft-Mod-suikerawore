package com.suike.suikerawore.expand.tconstruct;

import com.suike.suikerawore.item.BlockBase;

import slimeknights.tconstruct.library.TinkerRegistry;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

//铸造盆配方
public class BasinRecipe {
    public static void register() {
        register("copper", BlockBase.BLOCK_COPPER);//铜
        register("tin", BlockBase.BLOCK_TIN);//锡
        register("zinc", BlockBase.BLOCK_ZINC);//锌
        register("lead", BlockBase.BLOCK_LEAD);//铅
        register("silver", BlockBase.BLOCK_SILVER);//银
        register("cobalt", BlockBase.BLOCK_COBALT);//钴
        register("nickel", BlockBase.BLOCK_NICKEL);//镍
        register("liquidgallium", BlockBase.BLOCK_GALLIUM);//镓
        register("aluminum", BlockBase.BLOCK_ALUMINIUM);//铝
    }

    public static void register(String fluidName, Block block) {
        if (block != null) {
            ItemStack blockStack = new ItemStack(block);
            Fluid fluid = FluidRegistry.getFluid(fluidName);

            if (fluid != null) {
                TinkerRegistry.registerBasinCasting(blockStack, ItemStack.EMPTY, fluid, 1296);
            }
        }
    }
}
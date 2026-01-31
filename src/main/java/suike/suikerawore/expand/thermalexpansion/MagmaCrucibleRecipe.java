package suike.suikerawore.expand.thermalexpansion;

import suike.suikerawore.item.*;
import suike.suikerawore.config.ConfigValue;

import cofh.thermalexpansion.util.managers.machine.CrucibleManager;

import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidRegistry;

// 熔岩炉配方-粗矿>液体
public class MagmaCrucibleRecipe {
    public static void register(ModItemRawOre rawOre) {
        Fluid fluid = FluidRegistry.getFluid(rawOre.getFluid());
        if (fluid != null) {
            register(rawOre, fluid);
            register(rawOre.getCompressBlock(), fluid);
        }
    }

// 配方注册
    private static void register(Item item, Fluid fluid) {
        ItemStack inputStack = new ItemStack(item);
        int amount = (int) (ConfigValue.MagmaCrucibleOutputMultiple * 288);
        register(inputStack, fluid, amount);
    }

    private static void register(Block block, Fluid fluid) {
        ItemStack inputStack = new ItemStack(block);
        int amount = (int) (ConfigValue.MagmaCrucibleOutputMultiple * 2592);
        register(inputStack, fluid, amount);
    }

    private static void register(ItemStack inputStack, Fluid fluid, int amount) {
        if (ItemBase.isValidItemStack(inputStack)) {
            CrucibleManager.addRecipe(16000, inputStack, new FluidStack(fluid, amount));
        }
    }
}
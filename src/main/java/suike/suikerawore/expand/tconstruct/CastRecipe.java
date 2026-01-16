package suike.suikerawore.expand.tconstruct;

import suike.suikerawore.item.*;

import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;

import net.minecraft.item.ItemStack;

import net.minecraftforge.fluids.Fluid;

// 铸造盆 & 浇筑台配方
public class CastRecipe {
    public static void registerRecipe(ModItemRawOre rawOre, Fluid fluid) {
        registerItem(fluid, rawOre.getRefinedItemStack());
        registerBlock(fluid, rawOre.getCompressBlock().getRefinedItemStack());
    }

// 配方注册
    private static void registerItem(Fluid fluid, ItemStack stack) {
        if (ItemBase.isValidItemStack(stack)) {
            TinkerRegistry.registerTableCasting(stack, TinkerSmeltery.castIngot, fluid, 144);
        }
    }

    private static void registerBlock(Fluid fluid, ItemStack stack) {
        if (ItemBase.isValidItemStack(stack)) {
            TinkerRegistry.registerBasinCasting(stack, ItemStack.EMPTY, fluid, 1296);
        }
    }
}
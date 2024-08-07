package com.suike.suikerawore.expand.tconstruct;

import com.suike.suikerawore.item.ItemBase;
import com.suike.suikerawore.item.BlockBase;
import com.suike.suikerawore.expand.Examine;
import com.suike.suikerawore.config.ConfigValue;

import slimeknights.tconstruct.library.TinkerRegistry;

import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

//熔液配方
public class FluidRecipe {
    public static void register() {
        register(ItemBase.RAW_GOLD, "gold");//金熔液
        register(BlockBase.RAW_BLOCK_GOLD, "gold");//金熔液
        register(ItemBase.RAW_IRON, "iron");//铁熔液
        register(BlockBase.RAW_BLOCK_IRON, "iron");//铁熔液
        register(ItemBase.RAW_COPPER, "copper");//铜熔液
        register(BlockBase.RAW_BLOCK_COPPER, "copper");//铜熔液
        register(ItemBase.RAW_TIN, "tin");//锡熔液
        register(BlockBase.RAW_BLOCK_TIN, "tin");//锡熔液
        register(ItemBase.RAW_ZINC, "zinc");//锌熔液
        register(BlockBase.RAW_BLOCK_ZINC, "zinc");//锌熔液
        register(ItemBase.RAW_LEAD, "lead");//铅熔液
        register(BlockBase.RAW_BLOCK_LEAD, "lead");//铅熔液
        register(ItemBase.RAW_SILVER, "silver");//银熔液
        register(BlockBase.RAW_BLOCK_SILVER, "silver");//银熔液
        register(ItemBase.RAW_COBALT, "cobalt");//钴熔液
        register(BlockBase.RAW_BLOCK_COBALT, "cobalt");//钴熔液
        register(ItemBase.RAW_NICKEL, "nickel");//镍熔液
        register(BlockBase.RAW_BLOCK_NICKEL, "nickel");//镍熔液
        register(ItemBase.RAW_GALLIUM, "liquidgallium");//镓熔液
        register(BlockBase.RAW_BLOCK_GALLIUM, "liquidgallium");//镓熔液
        register(ItemBase.RAW_ALUMINIUM, "aluminum");//铝熔液
        register(BlockBase.RAW_BLOCK_ALUMINIUM, "aluminum");//铝熔液

        register(ItemBase.RAW_ARDITE, "ardite");//阿迪特熔液
        register(BlockBase.RAW_BLOCK_ARDITE, "ardite");//阿迪特熔液

        register(ItemBase.RAW_CERULEAN, "tamoltencerulean");//晶蓝
        register(BlockBase.RAW_BLOCK_CERULEAN, "tamoltencerulean");//晶蓝
        register(ItemBase.RAW_MOONSTONE, "tamoltenmoonstone");//皎月石
        register(BlockBase.RAW_BLOCK_MOONSTONE, "tamoltenmoonstone");//皎月石

        register(ItemBase.RAW_OCTINE, "liquidoctine");//炽炎铁
        register(BlockBase.RAW_BLOCK_OCTINE, "liquidoctine");//炽炎铁
        register(ItemBase.RAW_SYRMORITE, "liquidsyrmorite");//赛摩铜
        register(BlockBase.RAW_BLOCK_SYRMORITE, "liquidsyrmorite");//赛摩铜
    }

    public static void register(Item item, String fluidName) {
        if (item != null) {
            ItemStack itemStack = new ItemStack(item);
            Fluid fluid = FluidRegistry.getFluid(fluidName);
            int amount = 144 * ConfigValue.FluidMultiple;

            if (fluid != null) {
                TinkerRegistry.registerMelting(itemStack, fluid, amount);
            }
        }
    }

    public static void register(Block block, String fluidName) {
        if (block != null) {
            ItemStack blockStack = new ItemStack(block);
            Fluid fluid = FluidRegistry.getFluid(fluidName);
            int amount = 1296 * ConfigValue.FluidMultiple;

            if (fluid != null) {
                TinkerRegistry.registerMelting(blockStack, fluid, amount);
            }
        }
    }
}
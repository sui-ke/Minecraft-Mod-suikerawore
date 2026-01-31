package suike.suikerawore.expand.tconstruct;

import java.lang.reflect.Field;

import suike.suikerawore.item.*;
import suike.suikerawore.config.ConfigValue;

import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.smeltery.MeltingRecipe;
import knightminer.tcomplement.library.TCompRegistry;

import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Loader;

// 熔液配方
public class FluidRecipe {
    private int rawAmount;
    private int rawBlockAmount;
    private boolean tcomplementID;

    public FluidRecipe() {
        this.rawAmount = (int) ConfigValue.FluidMultiple * 288;
        this.rawBlockAmount = (int) ConfigValue.FluidMultiple * 2592;
        this.tcomplementID = Loader.isModLoaded("tcomplement");
    }

    public void registerRecipe(ModItemRawOre rawOre, Fluid fluid) {
        this.register(new ItemStack(rawOre), fluid, this.rawAmount);
        this.register(new ItemStack(rawOre.getCompressBlock()), fluid, this.rawBlockAmount);

        this.register(rawOre.getRefinedItemStack(), fluid, 144);
        this.register(rawOre.getCompressBlock().getRefinedItemStack(), fluid, 1296);
    }

// 熔液配方
    private void register(ItemStack inputStack, Fluid fluid, int amount) {
        if (ItemBase.isValidItemStack(inputStack)) {
            /*冶炼炉配方*/TinkerRegistry.registerMelting(inputStack, fluid, amount);
            if (this.tcomplementID) {
                /*匠魂补充-高炉配方*/new Recipe(inputStack, fluid, amount).registerRecipe();
            }
        }
    }

    private class Recipe extends MeltingRecipe {
        private Recipe(ItemStack inputStack, Fluid fluid, int amount) {
            super(RecipeMatch.of(inputStack), new FluidStack(fluid, amount * 2), fluid.getTemperature());

            try {
                /*获取output字段*/Field output = MeltingRecipe.class.getDeclaredField("output");
                /*设置可访问性*/output.setAccessible(true);
                /*修改output字段*/output.set(this, new FluidStack(fluid, amount * 2));
            } catch (NoSuchFieldException | IllegalAccessException e) {}
        }

        private void registerRecipe() {
            TCompRegistry.registerHighOvenOverride(this);
        }
    }
}
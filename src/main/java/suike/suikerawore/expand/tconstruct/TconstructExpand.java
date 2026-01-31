package suike.suikerawore.expand.tconstruct;

import suike.suikerawore.item.*;
import suike.suikerawore.expand.ExpandMod;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

// 匠魂
public class TconstructExpand extends ExpandMod {

    private FluidRecipe fluidRecipe;

    @Override
    protected void init() {
        this.fluidRecipe = new FluidRecipe();
    }

    @Override
    protected String value() {
        return "tconstruct";
    }

    @Override
    protected void expand(ModItemRawOre rawOre) {
        Fluid fluid = FluidRegistry.getFluid(rawOre.getFluid());
        if (fluid == null) {
            fluid = this.createFluid(rawOre);
        }
        if (fluid != null) {
            /*浇筑配方*/CastRecipe.registerRecipe(rawOre, fluid);
            /*熔液配方*/this.fluidRecipe.registerRecipe(rawOre, fluid);
        }
    }
}
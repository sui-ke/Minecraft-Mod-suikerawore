package suike.suikerawore.fluid;

import java.util.*;

import suike.suikerawore.SuiKe;
import suike.suikerawore.item.ModItemRawOre;

import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class FluidBase {

    private static final ResourceLocation STILL = new ResourceLocation("tconstruct", "blocks/fluids/molten_metal");
    private static final ResourceLocation FLOW = new ResourceLocation("tconstruct", "blocks/fluids/molten_metal_flow");

    public static Fluid createFluid(ModItemRawOre rawOre) {
        Fluid fluid = new Fluid(rawOre.getFluid(), STILL, FLOW) {
            @Override
            public String getUnlocalizedName() {
                return this.unlocalizedName;
            }
            @Override
            public Fluid setBlock(Block block) {
                return this;
            }
        };

        fluid.setLuminosity(15).setDensity(2000).setViscosity(6000).setTemperature(1000).setUnlocalizedName(rawOre.getElementType());
        if (!SuiKe.isServer) {
            fluid.setColor(getColorFromRawOre(rawOre));
        }

        FluidRegistry.registerFluid(fluid);
        return fluid;
    }

    private static  int getColorFromRawOre(ModItemRawOre rawOre) {
        return FluidColor.getColorFromTexture(rawOre.getRegistryName().toString().replace("suikerawore:", ""));
    }
}
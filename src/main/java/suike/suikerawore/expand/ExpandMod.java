package suike.suikerawore.expand;

import java.util.*;

import suike.suikerawore.item.*;
import suike.suikerawore.fluid.FluidBase;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.Loader;

public abstract class ExpandMod {

    private boolean expandOnce = false;

    private final boolean isValid() {
        return Loader.isModLoaded(this.value());
    }

    protected void init() {}
    protected abstract String value();

    public final void expandMod(ModItemRawOre rawOre) {
        if (!this.expandOnce) {
            this.expandOnce();
            this.expandOnce = true;
        }
        this.expand(rawOre);
    }

    protected final Fluid createFluid(ModItemRawOre rawOre) {
        if (!rawOre.canCreateFluid() || !Loader.isModLoaded("tconstruct")) return null;
        return FluidBase.createFluid(rawOre);
    }

    protected void expandOnce() {}
    protected void expand(ModItemRawOre rawOre) {}

    public static List<ExpandMod> initAll() {
        List<ExpandMod> expands = new ArrayList<>();

        toList(expands, new suike.suikerawore.expand.ic2.IC2Expand());
        toList(expands, new suike.suikerawore.expand.jer.JERExpand());
        toList(expands, new suike.suikerawore.expand.sakura.SakuraExpand());
        toList(expands, new suike.suikerawore.expand.enderio.EnderioExpand());
        toList(expands, new suike.suikerawore.expand.croparia.CropariaExpand());
        toList(expands, new suike.suikerawore.expand.mekanism.MekanismExpand());
        toList(expands, new suike.suikerawore.expand.gregtech.GregtechExpand());
        toList(expands, new suike.suikerawore.expand.techguns.TechgunsExpand());
        toList(expands, new suike.suikerawore.expand.libvulpes.LibvulpesExpand());
        toList(expands, new suike.suikerawore.expand.tconstruct.TconstructExpand());
        toList(expands, new suike.suikerawore.expand.thaumcraft.ThaumcraftExpand());
        toList(expands, new suike.suikerawore.expand.metallurgy.MetallurgyExpand());
        toList(expands, new suike.suikerawore.expand.galacticraft.GalacticraftExpand());
        toList(expands, new suike.suikerawore.expand.myagriculture.MyAgricultureExpand());
        toList(expands, new suike.suikerawore.expand.thermalexpansion.ThermalExpansionExpand());

        return expands;
    }

    private static void toList(List<ExpandMod> expands, ExpandMod expand) {
        if (expand.isValid()){
            expand.init();
            expands.add(expand);
        }
    }
}
package suike.suikerawore.expand.thermalexpansion;

import suike.suikerawore.item.*;
import suike.suikerawore.expand.ExpandMod;

// 热力膨胀5
public class ThermalExpansionExpand extends ExpandMod{

    @Override
    protected String value() {
        return "thermalexpansion";
    }

    @Override
    protected void expand(ModItemRawOre rawOre) {
        /*磨粉机配方*/PulverizerRecipe.register(rawOre);
        /*熔岩炉配方*/MagmaCrucibleRecipe.register(rawOre);
        /*感应炉配方*/InductionSmelterRecipe.register(rawOre);
    }
}
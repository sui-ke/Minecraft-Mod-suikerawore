package suike.suikerawore.expand.ic2;

import suike.suikerawore.item.*;
import suike.suikerawore.expand.ExpandMod;

// 工业2
public class IC2Expand extends ExpandMod {

    private MaceratorRecipe maceratorRecipe;

    @Override
    protected String value() {
        return "ic2";
    }

    @Override
    protected void init() {
        this.maceratorRecipe = new MaceratorRecipe();
    }

    @Override
    protected void expandOnce() {
        /*高炉配方*/BlastFurnaceRecipe.register();
        /*打粉机配方*/this.maceratorRecipe.registerRecipeOnce();
    }

    @Override
    protected void expand(ModItemRawOre rawOre) {
        /*打粉机配方*/this.maceratorRecipe.registerRecipe(rawOre);
    }
}
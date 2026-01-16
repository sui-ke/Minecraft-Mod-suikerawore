package suike.suikerawore.expand.metallurgy;

import suike.suikerawore.item.*;
import suike.suikerawore.expand.ExpandMod;

import it.hurts.metallurgy_reforged.recipe.CrusherRecipes;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

// 冶金4
public class MetallurgyExpand extends ExpandMod {

    @Override
    protected String value() {
        return "metallurgy";
    }

    @Override
    protected void expand(ModItemRawOre rawOre) {
        this.registerCrushingRecipe(rawOre);
    }

    private void registerCrushingRecipe(ModItemRawOre rawOre) {
        ItemStack input = new ItemStack(rawOre);
        ItemStack output = ItemBase.oreStack("dust" + rawOre.getElementType(), 2);
        if (ItemBase.isValidItemStack(input, output)) {
            CrusherRecipes.getInstance().addCrushingRecipe(input, output, 1.0f);
        }
    }
}
package suike.suikerawore.expand.techguns;

import suike.suikerawore.item.ItemBase;
import suike.suikerawore.expand.ExpandMod;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraftforge.fluids.FluidStack;

import techguns.TGItems;
import techguns.TGFluids;
import techguns.util.ItemStackOreDict;
import techguns.tileentities.operation.ChemLabRecipes;
import techguns.tileentities.operation.ReactionChamberRecipe;

// 科技枪
public class TechgunsExpand extends ExpandMod {

    @Override
    protected String value() {
        return "techguns";
    }

    @Override
    protected void expandOnce() {
        this.chemLabRecipes();
        this.reactionChamberRecipe();
    }

    // 化学实验设备配方
    private void chemLabRecipes() {
        ItemStack itemStack = new ItemStack(ItemBase.RAW_URANIUM);
        if (ItemBase.isValidItemStack(itemStack)) {
            ChemLabRecipes.addRecipe(itemStack, 1, ItemStack.EMPTY, 0, ItemStack.EMPTY, 0, new FluidStack(TGFluids.ACID, 250), (FluidStack)null, TGItems.newStack(TGItems.YELLOWCAKE, 3), false, 20);
        }
    }

    // 反应室配方
    private void reactionChamberRecipe() {
        ItemStack itemStack = new ItemStack(ItemBase.RAW_TITANIUM);
        if (ItemBase.isValidItemStack(itemStack)) {
            ReactionChamberRecipe.addRecipe("RC_TITANIUM_RAW", new ItemStackOreDict(itemStack), TGItems.RC_HEAT_RAY, TGFluids.ACID, (ItemStack[])(new ItemStack[]{TGItems.newStack(TGItems.ORE_TITANIUM, 2), new ItemStack(ItemBase.RAW_IRON, 1)}), 2, 1, 5, 0, 3, 100, 0.0F, ReactionChamberRecipe.RiskType.BREAK_ITEM, 25000);
        }
    }
}
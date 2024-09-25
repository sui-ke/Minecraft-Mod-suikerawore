package suike.suikerawore.expand.enderio;

import crazypants.enderio.base.recipe.RecipeInput;

import net.minecraft.item.ItemStack;

public class SRecipeInput extends RecipeInput {
//获取RecipeInput
    public SRecipeInput(ItemStack input, float multiplier, int slot) {
        super(input, true, multiplier, slot);
    }

//设置槽位编号并返回
    public SRecipeInput setSlot(int slot) {
        return new SRecipeInput(getInput(), getMulitplier(), slot);
    }
}
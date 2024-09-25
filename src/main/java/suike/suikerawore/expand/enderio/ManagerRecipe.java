package suike.suikerawore.expand.enderio;

import suike.suikerawore.config.ConfigValue;

import com.enderio.core.common.util.NNList;
import crazypants.enderio.base.recipe.RecipeLevel;
import crazypants.enderio.base.recipe.RecipeInput;
import crazypants.enderio.base.recipe.IRecipeInput;
import crazypants.enderio.base.recipe.alloysmelter.AlloyRecipeManager;

import net.minecraft.item.ItemStack;

public class ManagerRecipe {
//末影接口-合金炉-配方注册
    public static void register(ItemStack inputStack, ItemStack outputStack) {
        SRecipeInput recipeInput = new SRecipeInput(inputStack, 1.0f, 0);
        RecipeLevel[] recipeLevels = {RecipeLevel.SIMPLE, RecipeLevel.NORMAL, RecipeLevel.ADVANCED};

        for (RecipeLevel recipeLevel : recipeLevels)  {
            /*输入物列表*/NNList<IRecipeInput> inputs = new NNList<>();
            /*添加到输入列表*/inputs.add(recipeInput);
            /*输出倍数*/int outputMultiple = 1;
            /*能量*/int energy = 2000;

            if (recipeLevel == RecipeLevel.NORMAL) {
            //等级2: 添加额外的输入
                inputs.add(recipeInput.setSlot(1));
                outputMultiple = 2;
                energy = 3500;
            } else if (recipeLevel == RecipeLevel.ADVANCED) {
            //等级3: 添加额外的输入
                inputs.add(recipeInput.setSlot(1));
                inputs.add(recipeInput.setSlot(2));
                outputMultiple = 3;
                energy = 5000;
            }

            /*局部输出物*/ItemStack outputStackPart = outputStack.copy();
            /*设置局部输出物数量*/outputStackPart.setCount(ConfigValue.FurnaceOutputAmount * outputMultiple);

            /*配方注册*/AlloyRecipeManager.getInstance().addRecipe(false, inputs, outputStackPart, energy, 1.0f, recipeLevel);
        }
    }
}
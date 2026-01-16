package suike.suikerawore.expand.enderio;

import java.util.List;

import crazypants.enderio.base.recipe.Recipe;
import crazypants.enderio.base.recipe.RecipeLevel;
import crazypants.enderio.base.recipe.RecipeInput;
import crazypants.enderio.base.recipe.RecipeOutput;
import crazypants.enderio.base.recipe.RecipeBonusType;
import crazypants.enderio.base.recipe.sagmill.SagMillRecipeManager;

import net.minecraft.item.ItemStack;

public class SagMillRecipeRegister {
    public static void register(ItemStack inputStack, List<RecipeOutput> outputList) {
        /*
        SagMillRecipeManager.getInstance().addRecipe(
            new Recipe(
                new RecipeInput(inputStack),            //输入物品
                2000,                                   //需要的能量
                RecipeBonusType.MULTIPLY_OUTPUT,        //奖励类型
                RecipeLevel.IGNORE,                     //配方等级
                outputList.toArray(new RecipeOutput[0]) //输出物品数组
            )
        );
        */
    }
}
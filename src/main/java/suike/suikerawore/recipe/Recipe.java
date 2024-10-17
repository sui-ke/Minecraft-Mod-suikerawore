package suike.suikerawore.recipe;

import suike.suikerawore.recipe.craftrecipe.CraftRecipe;

public class Recipe {
    public static void register() {
        /*删除工作台&熔炉&高炉配方配方*/RemoveRecipe.remove();

        //工作台配方
        CraftRecipe.register();

        //熔炉配方
        FurnaceRecipe.register();
    }
}
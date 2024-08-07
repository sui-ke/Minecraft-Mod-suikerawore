package com.suike.suikerawore.recipe;

import com.suike.suikerawore.recipe.craftrecipe.CraftRecipe;//工作台配方

public class Recipe {
    public static void register() {
        /*删除工作台配方*/RemoveCraftRecipe.remove();

        //工作台配方
        CraftRecipe.register();

        /*删除熔炉配方*/RemoveFurnaceRecipe.remove();

        //熔炉配方
        FurnaceRecipe.register();
    }
}
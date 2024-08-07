package com.suike.suikerawore.recipe.craftrecipe;

import com.suike.suikerawore.recipe.craftrecipe.rawblock.rawMakeBlock;
import com.suike.suikerawore.recipe.craftrecipe.rawblock.blockMakeRaw;

import com.suike.suikerawore.recipe.craftrecipe.ingotblock.ingotMakeBlock;
import com.suike.suikerawore.recipe.craftrecipe.ingotblock.blockMakeIngot;

import com.suike.suikerawore.recipe.craftrecipe.ingotnugget.ingotMakeNugget;
import com.suike.suikerawore.recipe.craftrecipe.ingotnugget.nuggetMakeIngot;

//注册工作台配方
public class CraftRecipe {
    public static void register() {
        /*粗矿>块*/rawMakeBlock.register();
        /*块>粗矿*/blockMakeRaw.register();

        /*锭>块*/ingotMakeBlock.register();
        /*块>锭*/blockMakeIngot.register();

        /*锭>粒*/ingotMakeNugget.register();
        /*粒>锭*/nuggetMakeIngot.register();
    }
}
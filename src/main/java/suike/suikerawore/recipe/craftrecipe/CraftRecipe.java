package suike.suikerawore.recipe.craftrecipe;

import suike.suikerawore.recipe.craftrecipe.ingotblock.IngotMakeBlock;
import suike.suikerawore.recipe.craftrecipe.ingotblock.BlockMakeIngot;
import suike.suikerawore.recipe.craftrecipe.ingotnugget.ingotMakeNugget;
import suike.suikerawore.recipe.craftrecipe.ingotnugget.nuggetMakeIngot;

//注册工作台配方
public class CraftRecipe {
    public static void register() {
        rawRecipe.addRecipe();

        /*锭>块*/IngotMakeBlock.register();
        /*块>锭*/BlockMakeIngot.register();

        /*锭>粒*/ingotMakeNugget.register();
        /*粒>锭*/nuggetMakeIngot.register();
    }
}
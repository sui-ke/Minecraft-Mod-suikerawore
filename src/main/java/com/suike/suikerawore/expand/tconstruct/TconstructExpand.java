package com.suike.suikerawore.expand.tconstruct;

//注册所有'Tconstruct'相关配方
public class TconstructExpand {
    public static void expand() {

        //熔液配方
        FluidRecipe.register();

        //浇筑台配方
        TableRecipe.register();

        //铸造盆配方
        BasinRecipe.register();
    }
}
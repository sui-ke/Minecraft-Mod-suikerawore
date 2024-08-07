package com.suike.suikerawore.expand.galaxyspace;

//注册所有'GalaxySpace'相关配方
public class GalaxySpaceExpand {
    public static void expand() {
        //矿词
        AddOD.Add();

        //工作台配方
        CraftRecipe.register();
    }
}
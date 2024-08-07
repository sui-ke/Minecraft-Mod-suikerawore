package com.suike.suikerawore.expand.futuremc;

import java.lang.reflect.Method;

import com.suike.suikerawore.expand.futuremc.RemoveFurnaceRecipe;

//注册所有'FutureMC'相关配方
public class FutureMC {
    public static void expand() {
        //删除高炉配方
        RemoveFurnaceRecipe.remove();
    }
}
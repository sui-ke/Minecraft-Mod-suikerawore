package com.suike.suikerawore.expand.ic;

import com.suike.suikerawore.monitor.ChestMonitor;

//注册所有'IC2'相关配方
public class IC {
    public static void expand(){

        //打粉机配方
        MaceratorRecipe.register();

        //开启战利品箱替换
        ChestMonitor.registerMonitor();
    }
}
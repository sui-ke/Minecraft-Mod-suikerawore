package com.suike.suikerawore.expand.thaumcraft;

import com.suike.suikerawore.monitor.dropmonitor.drop.ThaumcraftDrop;//挖掘方式：thaumcraft模组镐子

//神秘时代联动类
public class ThaumcraftExpand {
    public static void expand() {
        //坩埚配方
        CrucibleRecipe.register();

        //添加掉落物列表
        ThaumcraftDrop.AddMaterialMap();
    }
}
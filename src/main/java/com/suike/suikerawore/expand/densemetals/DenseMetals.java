package com.suike.suikerawore.expand.densemetals;

import java.io.File;

import com.suike.suikerawore.expand.densemetals.oredictionaryadd.Add;
import com.suike.suikerawore.expand.densemetals.oredictionaryobtain.Obtain;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.config.Configuration;

//富集矿石联动类
public class DenseMetals {

    public static int denseOreValue = 2;

    public static void expand() {
        /*添加各富集矿石矿词*/Add.Add();
        /*获取各富集矿石矿词*/Obtain.Obtain();
    }
}
package com.suike.suikerawore.oredictionary.oredictionaryadd;

import com.suike.suikerawore.oredictionary.oredictionaryadd.AddBlock;
import com.suike.suikerawore.oredictionary.oredictionaryadd.AddIngot;
import com.suike.suikerawore.oredictionary.oredictionaryadd.AddNugget;
import com.suike.suikerawore.oredictionary.oredictionaryadd.AddRawOre;
import com.suike.suikerawore.oredictionary.oredictionaryadd.AddRawBlock;

//添加矿词统合类
public class Add{
    public static void Add(){
        /*块矿词*/AddBlock.Add();
        /*锭矿词*/AddIngot.Add();
        /*粒矿词*/AddNugget.Add();

        /*各粗矿矿词*/AddRawOre.Add();
        /*各粗块矿词*/AddRawBlock.Add();
    }
}
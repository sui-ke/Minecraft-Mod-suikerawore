package com.suike.suikerawore.oredictionary;

import com.suike.suikerawore.oredictionary.oredictionaryadd.Add;/*添加矿词*/
import com.suike.suikerawore.oredictionary.oredictionaryobtain.Obtain;/*获取矿词*/

public class Dictionary {
    public static void dictionary() {
        /*添加所有矿词*/Add.Add();
        /*获取所有矿石*/Obtain.Obtain();
    }
}
package suike.suikerawore.oredictionary;

import suike.suikerawore.oredictionary.oredictionaryadd.Add;/*添加矿词*/
import suike.suikerawore.oredictionary.oredictionaryobtain.Obtain;/*获取矿词*/

public class OreDict {
    public static void oreDict() {
        /*添加所有矿词*/Add.oreDictAdd();
        /*获取所有矿石*/Obtain.Obtain();
    }
}
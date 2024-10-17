package suike.suikerawore.oredictionary.oredictionaryobtain;

//获取矿词统合类
public class Obtain {
    public static void Obtain() {
        //获取所有矿石到列表
        ObtainOresA.Obtain();
        ObtainOresB.Obtain();
        ObtainOresC.Obtain();

        //获取更多矿石到列表
        ObtainOresMore.Obtain();
    }
}
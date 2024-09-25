package suike.suikerawore.expand.ic2;

import suike.suikerawore.monitor.ChestMonitor;

//工业2
public class IC2 {
    public static void expand() {
        //打粉机配方
        MaceratorRecipe.register();

        //开启战利品箱替换
        ChestMonitor.registerMonitor();
    }
}
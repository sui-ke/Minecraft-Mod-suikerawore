package suike.suikerawore.expand.ic2;

import suike.suikerawore.expand.Examine;
import suike.suikerawore.monitor.ChestMonitor;

//工业2
public class IC2 {
    public static void expand() {
        //打粉机配方
        /*工业2经典版*/if (Examine.IC2ClassicSpmodID) {
            MaceratorRecipeClassic.register();
        } else {
            MaceratorRecipe.register();
        }

        //高炉配方
        BlastFurnaceRecipe.register();

        //开启战利品箱替换
        ChestMonitor.registerMonitor();
    }
}
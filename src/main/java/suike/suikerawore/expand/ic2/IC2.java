package suike.suikerawore.expand.ic2;

//工业2
public class IC2 {
    public static void expand() {
        //打粉机配方
        MaceratorRecipe.register();

        //高炉配方
        BlastFurnaceRecipe.register();
    }
}
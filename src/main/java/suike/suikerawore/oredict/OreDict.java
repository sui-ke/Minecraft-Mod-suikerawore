package suike.suikerawore.oredict;

import java.util.Set;
import java.util.HashSet;
import java.lang.reflect.Field;

import suike.suikerawore.oredict.oredictadd.Add;

import net.minecraft.block.state.IBlockState;

public class OreDict {
    public static void rawOreDictAdd() {
        /*添加本模组物品矿词*/Add.rawOreDictAdd();
    }

    public static void oreDict() {
        /*添加其他矿词*/Add.oreDictAdd();
    }
}
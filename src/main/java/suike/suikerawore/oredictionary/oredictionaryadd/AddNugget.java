package suike.suikerawore.oredictionary.oredictionaryadd;

import suike.suikerawore.item.ItemBase;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraftforge.oredict.OreDictionary;

//添加粒矿词
public class AddNugget {
    public static void oreDictAdd() {
        /*铝*/oreDictAdd("Aluminum", ItemBase.NUGGET_ALUMINIUM);
        /*铝*/oreDictAdd("Aluminium", ItemBase.NUGGET_ALUMINIUM);
    }

//添加矿词方法
    public static void oreDictAdd(String type, Item item) {
        ItemStack itemStack = new ItemStack(item);
        if (ItemBase.isValidItemStack(itemStack)) {
            OreDictionary.registerOre("nugget" + type, itemStack);
        }
    }
}
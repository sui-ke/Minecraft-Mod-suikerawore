package suike.suikerawore.oredict;

import java.util.List;

import suike.suikerawore.item.ItemBase;
import suike.suikerawore.oredict.oredictadd.Add;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraftforge.oredict.OreDictionary;

public class OreDict {
    public static void rawOreDictAdd() {
        /*添加本模组物品矿词*/Add.rawOreDictAdd();
    }

    public static void oreDict() {
        /*添加其他矿词*/Add.oreDictAdd();

        oreDictRemove("libvulpes:ore0", 8, "oreRutile");
    }

    public static void oreDictRemove(String itemName, int mate, String oreDict) {
        Item item = Item.getByNameOrId(itemName);
        if (item == null) return;

        ItemStack stack = new ItemStack(item, 1 , mate);
        if (!ItemBase.isValidItemStack(stack)) return;

        List<ItemStack> ores = OreDictionary.getOres(oreDict);

        ores.removeIf(itemStack -> ItemStack.areItemStacksEqual(stack, itemStack));
    }
}
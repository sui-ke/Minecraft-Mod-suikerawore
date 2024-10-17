package suike.suikerawore.oredictionary.oredictionaryadd;

import suike.suikerawore.item.ItemBase;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraftforge.oredict.OreDictionary;

//添加锭矿词
public class AddIngot {
    public static void oreDictAdd() {
        /*铜*/oreDictAdd("Copper", ItemBase.INGOT_COPPER);
        /*锡*/oreDictAdd("Tin", ItemBase.INGOT_TIN);
        /*锌*/oreDictAdd("Zinc", ItemBase.INGOT_ZINC);
        /*铅*/oreDictAdd("Lead", ItemBase.INGOT_LEAD);
        /*银*/oreDictAdd("Silver", ItemBase.INGOT_SILVER);
        /*钴*/oreDictAdd("Cobalt", ItemBase.INGOT_COBALT);
        /*锇*/oreDictAdd("Osmium", ItemBase.INGOT_OSMIUM);
        /*镍*/oreDictAdd("Nickel", ItemBase.INGOT_NICKEL);
        /*铱*/oreDictAdd("Iridium", ItemBase.INGOT_IRIDIUM);
        /*铀*/oreDictAdd("Uranium", ItemBase.INGOT_URANIUM);
        /*镓*/oreDictAdd("Gallium", ItemBase.INGOT_GALLIUM);
        /*钛*/oreDictAdd("Titanium", ItemBase.INGOT_TITANIUM);
        /*铂*/oreDictAdd("Platinum", ItemBase.INGOT_PLATINUM);
        /*钨*/oreDictAdd("Tungsten", ItemBase.INGOT_TUNGSTEN);
        /*铝*/oreDictAdd("Aluminium", ItemBase.INGOT_ALUMINIUM);
        /*铝*/oreDictAdd("Aluminum", ItemBase.INGOT_ALUMINIUM);
        /*镁*/oreDictAdd("Magnesium", ItemBase.INGOT_MAGNESIUM);
        /*锂*/oreDictAdd("Lithium", ItemBase.INGOT_LITHIUM);
        /*钍*/oreDictAdd("Thorium", ItemBase.INGOT_THORIUM);
        /*硼*/oreDictAdd("Boron", ItemBase.INGOT_BORON);
        /*钒*/oreDictAdd("Vanadium", ItemBase.INGOT_VANADIUM);
        /*镉*/oreDictAdd("Cadmium", ItemBase.INGOT_CADMIUM);
        /*锰*/oreDictAdd("Manganese", ItemBase.INGOT_MANGANESE);
        /*锗*/oreDictAdd("Germanium", ItemBase.INGOT_GERMANIUM);
        /*铬*/oreDictAdd("Chrome", ItemBase.INGOT_CHROMIUM);
        /*铬*/oreDictAdd("Chromium", ItemBase.INGOT_CHROMIUM);
        /*砷*/oreDictAdd("Arsenic", ItemBase.INGOT_ARSENIC);
    }

//添加矿词方法
    public static void oreDictAdd(String type, Item item) {
        ItemStack itemStack = new ItemStack(item);
        if (ItemBase.isValidItemStack(itemStack)) {
            OreDictionary.registerOre("ingot" + type, itemStack);

            if (((ItemBase) item).oreDictRaw) {//确保只添加一次Raw
                OreDictionary.registerOre("ingot" + type + "Raw", itemStack);
                ((ItemBase) item).oreDictRaw = false;
            }
        }
    }
}
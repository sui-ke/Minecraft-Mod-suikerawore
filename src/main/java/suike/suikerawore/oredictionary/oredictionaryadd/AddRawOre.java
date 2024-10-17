package suike.suikerawore.oredictionary.oredictionaryadd;

import suike.suikerawore.item.ItemBase;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraftforge.oredict.OreDictionary;

//添加各粗矿矿词
public class AddRawOre {
    public static void oreDictAdd() {
        /*金*/oreDictAdd("Gold", ItemBase.RAW_GOLD);
        /*铁*/oreDictAdd("Iron", ItemBase.RAW_IRON);
        /*铜*/oreDictAdd("Copper", ItemBase.RAW_COPPER);
        /*锡*/oreDictAdd("Tin", ItemBase.RAW_TIN);
        /*锌*/oreDictAdd("Zinc", ItemBase.RAW_ZINC);
        /*铅*/oreDictAdd("Lead", ItemBase.RAW_LEAD);
        /*银*/oreDictAdd("Silver", ItemBase.RAW_SILVER);
        /*钴*/oreDictAdd("Cobalt", ItemBase.RAW_COBALT);
        /*锇*/oreDictAdd("Osmium", ItemBase.RAW_OSMIUM);
        /*镍*/oreDictAdd("Nickel", ItemBase.RAW_NICKEL);
        /*铱*/oreDictAdd("Iridium", ItemBase.RAW_IRIDIUM);
        /*铀*/oreDictAdd("Uranium", ItemBase.RAW_URANIUM);
        /*镓*/oreDictAdd("Gallium", ItemBase.RAW_GALLIUM);
        /*钛*/oreDictAdd("Titanium", ItemBase.RAW_TITANIUM);
        /*铂*/oreDictAdd("Platinum", ItemBase.RAW_PLATINUM);
        /*钨*/oreDictAdd("Tungsten", ItemBase.RAW_TUNGSTEN);
        /*铝*/oreDictAdd("Aluminium", ItemBase.RAW_ALUMINIUM);
        /*镁*/oreDictAdd("Magnesium", ItemBase.RAW_MAGNESIUM);
        /*锂*/oreDictAdd("Lithium", ItemBase.RAW_LITHIUM);
        /*钍*/oreDictAdd("Thorium", ItemBase.RAW_THORIUM);
        /*硼*/oreDictAdd("Boron", ItemBase.RAW_BORON);
        /*钒*/oreDictAdd("Vanadium", ItemBase.RAW_VANADIUM);
        /*镉*/oreDictAdd("Cadmium", ItemBase.RAW_CADMIUM);
        /*锰*/oreDictAdd("Manganese", ItemBase.RAW_MANGANESE);
        /*锗*/oreDictAdd("Germanium", ItemBase.RAW_GERMANIUM);
        /*铬*/oreDictAdd("Chromium", ItemBase.RAW_CHROMIUM);
        /*砷*/oreDictAdd("Arsenic", ItemBase.RAW_ARSENIC);

        /*阿迪特*/oreDictAdd("Ardite", ItemBase.RAW_ARDITE);
        /* 晶蓝 */oreDictAdd("Cerulean", ItemBase.RAW_CERULEAN);
        /*皎月石*/oreDictAdd("Moonstone", ItemBase.RAW_MOONSTONE);
        /*炽炎铁*/oreDictAdd("Octine", ItemBase.RAW_OCTINE);
        /*赛摩铜*/oreDictAdd("Syrmorite", ItemBase.RAW_SYRMORITE);
        /* 朱砂 */oreDictAdd("Cinnabar", ItemBase.RAW_CINNABAR);
        /*软碲铜*/oreDictAdd("Vulcanite", ItemBase.RAW_VULCANITE);
        /* 裂金 */oreDictAdd("Chasmium", ItemBase.RAW_CHASMIUM);
        /*玫瑰金*/oreDictAdd("Rosegold", ItemBase.RAW_ROSEGOLD);
    }

//注册矿词方法
    public static void oreDictAdd(String type, Item item) {
        ItemStack itemStack = new ItemStack(item);
        if (ItemBase.isValidItemStack(itemStack)) {
            OreDictionary.registerOre("raw" + type, itemStack);
            OreDictionary.registerOre("rawMaterials", itemStack);
        }
    }
}
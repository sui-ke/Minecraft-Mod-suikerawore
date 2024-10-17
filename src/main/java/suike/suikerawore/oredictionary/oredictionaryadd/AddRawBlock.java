package suike.suikerawore.oredictionary.oredictionaryadd;

import suike.suikerawore.item.ItemBase;
import suike.suikerawore.item.BlockBase;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import net.minecraftforge.oredict.OreDictionary;

//添加各粗块矿词
public class AddRawBlock {
    public static void oreDictAdd() {
        /*金*/oreDictAdd("Gold", BlockBase.RAW_BLOCK_GOLD);
        /*铁*/oreDictAdd("Iron", BlockBase.RAW_BLOCK_IRON);
        /*铜*/oreDictAdd("Copper", BlockBase.RAW_BLOCK_COPPER);
        /*锡*/oreDictAdd("Tin", BlockBase.RAW_BLOCK_TIN);
        /*锌*/oreDictAdd("Zinc", BlockBase.RAW_BLOCK_ZINC);
        /*铅*/oreDictAdd("Lead", BlockBase.RAW_BLOCK_LEAD);
        /*银*/oreDictAdd("Silver", BlockBase.RAW_BLOCK_SILVER);
        /*钴*/oreDictAdd("Cobalt", BlockBase.RAW_BLOCK_COBALT);
        /*锇*/oreDictAdd("Osmium", BlockBase.RAW_BLOCK_OSMIUM);
        /*镍*/oreDictAdd("Nickel", BlockBase.RAW_BLOCK_NICKEL);
        /*铱*/oreDictAdd("Iridium", BlockBase.RAW_BLOCK_IRIDIUM);
        /*铀*/oreDictAdd("Uranium", BlockBase.RAW_BLOCK_URANIUM);
        /*镓*/oreDictAdd("Gallium", BlockBase.RAW_BLOCK_GALLIUM);
        /*钛*/oreDictAdd("Titanium", BlockBase.RAW_BLOCK_TITANIUM);
        /*铂*/oreDictAdd("Platinum", BlockBase.RAW_BLOCK_PLATINUM);
        /*钨*/oreDictAdd("Tungsten", BlockBase.RAW_BLOCK_TUNGSTEN);
        /*铝*/oreDictAdd("Aluminium", BlockBase.RAW_BLOCK_ALUMINIUM);
        /*镁*/oreDictAdd("Magnesium", BlockBase.RAW_BLOCK_MAGNESIUM);
        /*锂*/oreDictAdd("Lithium", BlockBase.RAW_BLOCK_LITHIUM);
        /*钍*/oreDictAdd("Thorium", BlockBase.RAW_BLOCK_THORIUM);
        /*硼*/oreDictAdd("Boron", BlockBase.RAW_BLOCK_BORON);
        /*钒*/oreDictAdd("Vanadium", BlockBase.RAW_BLOCK_VANADIUM);
        /*镉*/oreDictAdd("Cadmium", BlockBase.RAW_BLOCK_CADMIUM);
        /*锰*/oreDictAdd("Manganese", BlockBase.RAW_BLOCK_MANGANESE);
        /*锗*/oreDictAdd("Germanium", BlockBase.RAW_BLOCK_GERMANIUM);
        /*铬*/oreDictAdd("Chromium", BlockBase.RAW_BLOCK_CHROMIUM);
        /*砷*/oreDictAdd("Arsenic", BlockBase.RAW_BLOCK_ARSENIC);

        /*阿迪特*/oreDictAdd("Ardite", BlockBase.RAW_BLOCK_ARDITE);
        /* 晶蓝 */oreDictAdd("Cerulean", BlockBase.RAW_BLOCK_CERULEAN);
        /*皎月石*/oreDictAdd("Moonstone", BlockBase.RAW_BLOCK_MOONSTONE);
        /*炽炎铁*/oreDictAdd("Octine", BlockBase.RAW_BLOCK_OCTINE);
        /*赛摩铜*/oreDictAdd("Syrmorite", BlockBase.RAW_BLOCK_SYRMORITE);
        /* 朱砂 */oreDictAdd("Cinnabar", BlockBase.RAW_BLOCK_CINNABAR);
        /*软碲铜*/oreDictAdd("Vulcanite", BlockBase.RAW_BLOCK_VULCANITE);
        /* 裂金 */oreDictAdd("Chasmium", BlockBase.RAW_BLOCK_CHASMIUM);
        /*玫瑰金*/oreDictAdd("Rosegold", BlockBase.RAW_BLOCK_ROSEGOLD);
    }

//注册矿词方法
    public static void oreDictAdd(String type, Block block) {
        ItemStack itemStack = new ItemStack(block);
        if (ItemBase.isValidItemStack(itemStack)) {
            OreDictionary.registerOre("rawBlock" + type, itemStack);
        }
    }
}
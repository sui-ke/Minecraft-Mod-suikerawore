package suike.suikerawore.oredictionary.oredictionaryadd;

import suike.suikerawore.item.ItemBase;
import suike.suikerawore.item.BlockBase;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import net.minecraftforge.oredict.OreDictionary;

//添加块矿词
public class AddBlock {
    public static void oreDictAdd() {
        /*铜*/oreDictAdd("Copper", BlockBase.BLOCK_COPPER);
        /*锡*/oreDictAdd("Tin", BlockBase.BLOCK_TIN);
        /*锌*/oreDictAdd("Zinc", BlockBase.BLOCK_ZINC);
        /*铅*/oreDictAdd("Lead", BlockBase.BLOCK_LEAD);
        /*银*/oreDictAdd("Silver", BlockBase.BLOCK_SILVER);
        /*钴*/oreDictAdd("Cobalt", BlockBase.BLOCK_COBALT);
        /*锇*/oreDictAdd("Osmium", BlockBase.BLOCK_OSMIUM);
        /*镍*/oreDictAdd("Nickel", BlockBase.BLOCK_NICKEL);
        /*铱*/oreDictAdd("Iridium", BlockBase.BLOCK_IRIDIUM);
        /*铀*/oreDictAdd("Uranium", BlockBase.BLOCK_URANIUM);
        /*镓*/oreDictAdd("Gallium", BlockBase.BLOCK_GALLIUM);
        /*钛*/oreDictAdd("Titanium", BlockBase.BLOCK_TITANIUM);
        /*铂*/oreDictAdd("Platinum", BlockBase.BLOCK_PLATINUM);
        /*钨*/oreDictAdd("Tungsten", BlockBase.BLOCK_TUNGSTEN);
        /*铝*/oreDictAdd("Aluminum", BlockBase.BLOCK_ALUMINIUM);
        /*铝*/oreDictAdd("Aluminium", BlockBase.BLOCK_ALUMINIUM);
        /*镁*/oreDictAdd("Magnesium", BlockBase.BLOCK_MAGNESIUM);
        /*锂*/oreDictAdd("Lithium", BlockBase.BLOCK_LITHIUM);
        /*钍*/oreDictAdd("Thorium", BlockBase.BLOCK_THORIUM);
        /*硼*/oreDictAdd("Boron", BlockBase.BLOCK_BORON);
        /*钒*/oreDictAdd("Vanadium", BlockBase.BLOCK_VANADIUM);
        /*镉*/oreDictAdd("Cadmium", BlockBase.BLOCK_CADMIUM);
        /*锰*/oreDictAdd("Manganese", BlockBase.BLOCK_MANGANESE);
        /*锗*/oreDictAdd("Germanium", BlockBase.BLOCK_GERMANIUM);
        /*铬*/oreDictAdd("Chrome", BlockBase.BLOCK_CHROMIUM);
        /*铬*/oreDictAdd("Chromium", BlockBase.BLOCK_CHROMIUM);
        /*砷*/oreDictAdd("Arsenic", BlockBase.BLOCK_ARSENIC);
    }

//添加矿词方法
    public static void oreDictAdd(String type, Block block) {
        ItemStack itemStack = new ItemStack(block);
        if (ItemBase.isValidItemStack(itemStack)) {
            OreDictionary.registerOre("block" + type, itemStack);

            if (((BlockBase) block).oreDictRaw) {//确保只添加一次Raw
                OreDictionary.registerOre("block" + type + "Raw", itemStack);
                ((BlockBase) block).oreDictRaw = false;
            }
        }
    }
}
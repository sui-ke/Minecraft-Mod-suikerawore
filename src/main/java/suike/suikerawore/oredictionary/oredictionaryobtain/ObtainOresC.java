package suike.suikerawore.oredictionary.oredictionaryobtain;

import java.util.Set;

import suike.suikerawore.oredictionary.OreDictList;

import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.block.state.IBlockState;

import net.minecraftforge.oredict.OreDictionary;

//获取各矿石矿词
public class ObtainOresC {
    public static void Obtain() {
        /*锂*/addList("Lithium", OreDictList.oreLithium);
        /*钍*/addList("Thorium", OreDictList.oreThorium);
        /*硼*/addList("Boron", OreDictList.oreBoron);
        /*钒*/addList("Vanadium", OreDictList.oreVanadium);
        /*镉*/addList("Cadmium", OreDictList.oreCadmium);
        /*锰*/addList("Manganese", OreDictList.oreManganese);
        /*锗*/addList("Germanium", OreDictList.oreGermanium);
        /*铬*/addList("Chrome", OreDictList.oreChromium);
        /*铬*/addList("Chromium", OreDictList.oreChromium);
        /*砷*/addList("Arsenic", OreDictList.oreArsenic);
    }

    public static void addList(String type, Set<IBlockState> oreList) {
        NonNullList<ItemStack> blockList = OreDictionary.getOres("ore" + type);

        if (blockList != null && !blockList.isEmpty()) {
            for (ItemStack blockStack : blockList) {
                Item item = blockStack.getItem();
                int meta = blockStack.getMetadata();
                IBlockState IBlock = Block.getBlockFromItem(item).getStateFromMeta(meta);

                /*单个矿石列表*/oreList.add(IBlock);
                /*本类矿石列表*/OreDictList.oreStoneC.add(IBlock);
                /*总矿石列表*/OreDictList.oreStone.add(IBlock);
            }
        }
    }
}
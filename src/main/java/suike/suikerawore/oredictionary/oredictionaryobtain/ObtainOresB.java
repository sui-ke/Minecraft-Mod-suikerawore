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
public class ObtainOresB {
    public static void Obtain() {
        /*镍*/addList("Nickel", OreDictList.oreNickel);
        /*铱*/addList("Iridium", OreDictList.oreIridium);
        /*铀*/addList("Uranium", OreDictList.oreUranium);
        /*镓*/addList("Gallium", OreDictList.oreGallium);
        /*钛*/addList("Titanium", OreDictList.oreTitanium);
        /*铂*/addList("Platinum", OreDictList.orePlatinum);
        /*钨*/addList("Tungsten", OreDictList.oreTungsten);
        /*镁*/addList("Magnesium", OreDictList.oreMagnesium);
        /*铝*/addList("Aluminum", OreDictList.oreAluminium);
        /*铝*/addList("Aluminium", OreDictList.oreAluminium);
    }

    public static void addList(String type, Set<IBlockState> oreList) {
        NonNullList<ItemStack> blockList = OreDictionary.getOres("ore" + type);

        if (blockList != null && !blockList.isEmpty()) {
            for (ItemStack blockStack : blockList) {
                Item item = blockStack.getItem();
                int meta = blockStack.getMetadata();
                IBlockState IBlock = Block.getBlockFromItem(item).getStateFromMeta(meta);

                /*单个矿石列表*/oreList.add(IBlock);
                /*本类矿石列表*/OreDictList.oreStoneB.add(IBlock);
                /*总矿石列表*/OreDictList.oreStone.add(IBlock);
            }
        }
    }
}
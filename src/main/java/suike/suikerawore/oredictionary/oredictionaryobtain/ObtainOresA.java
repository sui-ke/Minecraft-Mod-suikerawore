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
public class ObtainOresA {
    public static void Obtain() {
        /*金*/addList("Gold", OreDictList.oreGold);
        /*铁*/addList("Iron", OreDictList.oreIron);
        /*铜*/addList("Copper", OreDictList.oreCopper);
        /*锡*/addList("Tin", OreDictList.oreTin);
        /*锌*/addList("Zinc", OreDictList.oreZinc);
        /*铅*/addList("Lead", OreDictList.oreLead);
        /*银*/addList("Silver", OreDictList.oreSilver);
        /*钴*/addList("Cobalt", OreDictList.oreCobalt);
        /*锇*/addList("Osmium", OreDictList.oreOsmium);
    }

    public static void addList(String type, Set<IBlockState> oreList) {
        NonNullList<ItemStack> blockList = OreDictionary.getOres("ore" + type);

        if (blockList != null && !blockList.isEmpty()) {
            for (ItemStack blockStack : blockList) {
                Item item = blockStack.getItem();
                int meta = blockStack.getMetadata();
                IBlockState IBlock = Block.getBlockFromItem(item).getStateFromMeta(meta);

                /*单个矿石列表*/oreList.add(IBlock);
                /*本类矿石列表*/OreDictList.oreStoneA.add(IBlock);
                /*总矿石列表*/OreDictList.oreStone.add(IBlock);
            }
        }
    }
}
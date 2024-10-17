package suike.suikerawore.expand.densemetals;

import java.util.Set;

import suike.suikerawore.oredictionary.OreDictList;
import suike.suikerawore.expand.densemetals.DenseOreOD;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.block.state.IBlockState;

import net.minecraftforge.oredict.OreDictionary;

//富集矿石获取矿词类
public class DenseOresObtain {
    public static void Obtain() {
        addList("denseOreGold",  DenseOreOD.denseOreGold);//富集金矿石
        addList("denseOreIron",  DenseOreOD.denseOreIron);//富集铁矿石
        addList("denseOreCopper",  DenseOreOD.denseOreCopper);//富集铜矿石
        addList("denseOreTin",  DenseOreOD.denseOreTin);//富集锡矿石
        addList("denseOreZinc",  DenseOreOD.denseOreZinc);//富集锌矿石
        addList("denseOreLead",  DenseOreOD.denseOreLead);//富集铅矿石
        addList("denseOreSilver",  DenseOreOD.denseOreSilver);//富集银矿石
        addList("denseOreOsmium",  DenseOreOD.denseOreOsmium);//富集锇矿石
        addList("denseOreNickel",  DenseOreOD.denseOreNickel);//富集镍矿石
        addList("denseOreIridium",  DenseOreOD.denseOreIridium);//富集铱矿石
        addList("denseOreUranium",  DenseOreOD.denseOreUranium);//富集铀矿石
        addList("denseOrePlatinum",  DenseOreOD.denseOrePlatinum);//富集铂矿石
        addList("denseOreTungsten",  DenseOreOD.denseOreTungsten);//富集钨矿石
        addList("denseOreAluminium",  DenseOreOD.denseOreAluminium);//富集铝矿石
        addList("denseOreMagnesium",  DenseOreOD.denseOreMagnesium);//富集镁矿石
    }

    public static void addList(String oreName, Set<IBlockState> oreList) {
        NonNullList<ItemStack> blockList = OreDictionary.getOres(oreName);

        if (blockList != null && !blockList.isEmpty()) {
            for (ItemStack blockStack : blockList) {
                Block block = Block.getBlockFromItem(blockStack.getItem());
                int meta = blockStack.getMetadata();

                /*单个矿石列表*/oreList.add(block.getStateFromMeta(meta));
                /*本类矿石列表*/DenseOreOD.denseOreStone.add(block.getStateFromMeta(meta));
                /*总矿石列表*/OreDictList.oreStone.add(block.getStateFromMeta(meta));
            }
        }
    }
}
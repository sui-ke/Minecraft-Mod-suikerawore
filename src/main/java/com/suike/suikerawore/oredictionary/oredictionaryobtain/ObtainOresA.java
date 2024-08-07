package com.suike.suikerawore.oredictionary.oredictionaryobtain;

import java.util.Set;

import com.suike.suikerawore.oredictionary.RawOD;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.block.state.IBlockState;

import net.minecraftforge.oredict.OreDictionary;

//获取各矿石矿词
public class ObtainOresA {
    public static void Obtain() {
        addList("oreGold", RawOD.oreGold);
        addList("oreIron", RawOD.oreIron);
        addList("oreCopper", RawOD.oreCopper);
        addList("oreTin", RawOD.oreTin);
        addList("oreZinc", RawOD.oreZinc);
        addList("oreLead", RawOD.oreLead);
        addList("oreSilver", RawOD.oreSilver);
        addList("oreCobalt", RawOD.oreCobalt);
        addList("oreOsmium", RawOD.oreOsmium);
    }

    public static void addList(String oreName, Set<IBlockState> oreList) {
        NonNullList<ItemStack> blockList = OreDictionary.getOres(oreName);

        if (blockList != null && !blockList.isEmpty()) {
            for (ItemStack blockStack : blockList) {
                Block block = Block.getBlockFromItem(blockStack.getItem());
                int meta = blockStack.getMetadata();

                /*单个矿石列表*/oreList.add(block.getStateFromMeta(meta));
                /*本类矿石列表*/RawOD.oreStoneA.add(block.getStateFromMeta(meta));
                /*总矿石列表*/RawOD.oreStone.add(block.getStateFromMeta(meta));
            }
        }
    }
}
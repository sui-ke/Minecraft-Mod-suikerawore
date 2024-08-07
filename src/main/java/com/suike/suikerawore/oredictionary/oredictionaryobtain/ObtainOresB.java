package com.suike.suikerawore.oredictionary.oredictionaryobtain;

import java.util.Set;

import com.suike.suikerawore.oredictionary.RawOD;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.block.state.IBlockState;

import net.minecraftforge.oredict.OreDictionary;

//获取各矿石矿词
public class ObtainOresB {
    public static void Obtain() {
        addList("oreNickel", RawOD.oreNickel);
        addList("oreIridium", RawOD.oreIridium);
        addList("oreUranium", RawOD.oreUranium);
        addList("oreGallium", RawOD.oreGallium);
        addList("oreTitanium", RawOD.oreTitanium);
        addList("orePlatinum", RawOD.orePlatinum);
        addList("oreTungsten", RawOD.oreTungsten);
        addList("oreMagnesium", RawOD.oreMagnesium);
        addList("oreAluminum", RawOD.oreAluminium);
        addList("oreAluminium", RawOD.oreAluminium);
    }

    public static void addList(String oreName, Set<IBlockState> oreList) {
        NonNullList<ItemStack> blockList = OreDictionary.getOres(oreName);

        if (blockList != null && !blockList.isEmpty()) {
            for (ItemStack blockStack : blockList) {
                Block block = Block.getBlockFromItem(blockStack.getItem());
                int meta = blockStack.getMetadata();

                /*单个矿石列表*/oreList.add(block.getStateFromMeta(meta));
                /*本类矿石列表*/RawOD.oreStoneB.add(block.getStateFromMeta(meta));
                /*总矿石列表*/RawOD.oreStone.add(block.getStateFromMeta(meta));
            }
        }
    }
}
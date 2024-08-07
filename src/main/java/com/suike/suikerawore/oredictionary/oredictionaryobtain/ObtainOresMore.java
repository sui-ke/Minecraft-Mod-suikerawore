package com.suike.suikerawore.oredictionary.oredictionaryobtain;

import java.util.Set;

import com.suike.suikerawore.oredictionary.RawOD;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.block.state.IBlockState;

import net.minecraftforge.oredict.OreDictionary;

//获取各矿石矿词
public class ObtainOresMore {
    public static void Obtain() {
        addList("oreArdite", RawOD.oreArdite);
        addList("oreCerulean", RawOD.oreCerulean);
        addList("oreMoonstone", RawOD.oreMoonstone);
        addList("oreOctine", RawOD.oreOctine);
        addList("oreSyrmorite", RawOD.oreSyrmorite);
    }

    public static void addList(String oreName, Set<IBlockState> oreList) {
        NonNullList<ItemStack> blockList = OreDictionary.getOres(oreName);

        if (blockList != null && !blockList.isEmpty()) {
            ItemStack blockStack = blockList.get(0);
            Block block = Block.getBlockFromItem(blockStack.getItem());
            int meta = blockStack.getMetadata();

            /*单个矿石列表*/oreList.add(block.getStateFromMeta(meta));
            /*本类矿石列表*/RawOD.oreMore.add(block.getStateFromMeta(meta));
            /*总矿石列表*/RawOD.oreStone.add(block.getStateFromMeta(meta));
        }
    }
}
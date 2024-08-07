package com.suike.suikerawore.oredictionary.oredictionaryadd;

import com.suike.suikerawore.item.BlockBase;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import net.minecraftforge.oredict.OreDictionary;

//添加块矿词
public class AddBlock {
    public static void Add() {
        register("blockCopper", BlockBase.BLOCK_COPPER);//铜
        register("blockTin", BlockBase.BLOCK_TIN);//锡
        register("blockZinc", BlockBase.BLOCK_ZINC);//锌
        register("blockLead", BlockBase.BLOCK_LEAD);//铅
        register("blockSilver", BlockBase.BLOCK_SILVER);//银
        register("blockCobalt", BlockBase.BLOCK_COBALT);//钴
        register("blockOsmium", BlockBase.BLOCK_OSMIUM);//锇
        register("blockNickel", BlockBase.BLOCK_NICKEL);//镍
        register("blockIridium", BlockBase.BLOCK_IRIDIUM);//铱
        register("blockUranium", BlockBase.BLOCK_URANIUM);//铀
        register("blockGallium", BlockBase.BLOCK_GALLIUM);//镓
        register("blockTitanium", BlockBase.BLOCK_TITANIUM);//钛
        register("blockPlatinum", BlockBase.BLOCK_PLATINUM);//铂
        register("blockTungsten", BlockBase.BLOCK_TUNGSTEN);//钨
        register("blockAluminum", BlockBase.BLOCK_ALUMINIUM);//铝
        register("blockAluminium", BlockBase.BLOCK_ALUMINIUM);//铝
        register("blockMagnesium", BlockBase.BLOCK_MAGNESIUM);//镁
        register("blockLithium", BlockBase.BLOCK_LITHIUM);//锂
        register("blockThorium", BlockBase.BLOCK_THORIUM);//钍
        register("blockBoron", BlockBase.BLOCK_BORON);//硼
    }

    //注册矿词方法
    public static void register(String ore, Block block) {
        //为我的物品添加矿词
        ItemStack itemStack = new ItemStack(block);
        OreDictionary.registerOre(ore, itemStack);
    }
}
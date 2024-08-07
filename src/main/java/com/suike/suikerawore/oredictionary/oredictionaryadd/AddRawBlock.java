package com.suike.suikerawore.oredictionary.oredictionaryadd;

import com.suike.suikerawore.item.BlockBase;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

import net.minecraftforge.oredict.OreDictionary;

//添加各粗块矿词
public class AddRawBlock {
    public static void Add() {
        register("rawBlockGold", BlockBase.RAW_BLOCK_GOLD);//金
        register("rawBlockIron", BlockBase.RAW_BLOCK_IRON);//铁
        register("rawBlockCopper", BlockBase.RAW_BLOCK_COPPER);//铜
        register("rawBlockTin", BlockBase.RAW_BLOCK_TIN);//锡
        register("rawBlockZinc", BlockBase.RAW_BLOCK_ZINC);//锌
        register("rawBlockLead", BlockBase.RAW_BLOCK_LEAD);//铅
        register("rawBlockSilver", BlockBase.RAW_BLOCK_SILVER);//银
        register("rawBlockCobalt", BlockBase.RAW_BLOCK_COBALT);//钴
        register("rawBlockOsmium", BlockBase.RAW_BLOCK_OSMIUM);//锇

        register("rawBlockNickel", BlockBase.RAW_BLOCK_NICKEL);//镍
        register("rawBlockIridium", BlockBase.RAW_BLOCK_IRIDIUM);//铱
        register("rawBlockUranium", BlockBase.RAW_BLOCK_URANIUM);//铀
        register("rawBlockGallium", BlockBase.RAW_BLOCK_GALLIUM);//镓
        register("rawBlockTitanium", BlockBase.RAW_BLOCK_TITANIUM);//钛
        register("rawBlockPlatinum", BlockBase.RAW_BLOCK_PLATINUM);//铂
        register("rawBlockTungsten", BlockBase.RAW_BLOCK_TUNGSTEN);//钨
        register("rawBlockAluminium", BlockBase.RAW_BLOCK_ALUMINIUM);//铝
        register("rawBlockMagnesium", BlockBase.RAW_BLOCK_MAGNESIUM);//镁

        register("rawBlockLithium", BlockBase.RAW_BLOCK_LITHIUM);//锂
        register("rawBlockThorium", BlockBase.RAW_BLOCK_THORIUM);//钍
        register("rawBlockBoron", BlockBase.RAW_BLOCK_BORON);//硼

        register("rawBlockArdite", BlockBase.RAW_BLOCK_ARDITE);//阿迪特
        register("rawBlockCerulean", BlockBase.RAW_BLOCK_CERULEAN);//晶蓝
        register("rawBlockMoonstone", BlockBase.RAW_BLOCK_MOONSTONE);//皎月石
        register("rawBlockOctine", BlockBase.RAW_BLOCK_OCTINE);//炽炎铁
        register("rawBlockSyrmorite", BlockBase.RAW_BLOCK_SYRMORITE);//赛摩铜
    }

    //注册矿词方法
    public static void register(String ore, Block block) {
        if (block == null) {return;}

        ItemStack newblock = new ItemStack(block);
        OreDictionary.registerOre(ore, newblock);
    }
}
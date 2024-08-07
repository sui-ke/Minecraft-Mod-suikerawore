package com.suike.suikerawore.oredictionary.oredictionaryadd;

import com.suike.suikerawore.item.ItemBase;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraftforge.oredict.OreDictionary;

//添加各粗矿矿词
public class AddRawOre {
    public static void Add() {
        register("rawGold", ItemBase.RAW_GOLD);//金
        register("rawIron", ItemBase.RAW_IRON);//铁
        register("rawCopper", ItemBase.RAW_COPPER);//铜
        register("rawTin", ItemBase.RAW_TIN);//锡
        register("rawZinc", ItemBase.RAW_ZINC);//锌
        register("rawLead", ItemBase.RAW_LEAD);//铅
        register("rawSilver", ItemBase.RAW_SILVER);//银
        register("rawCobalt", ItemBase.RAW_COBALT);//钴
        register("rawOsmium", ItemBase.RAW_OSMIUM);//锇

        register("rawNickel", ItemBase.RAW_NICKEL);//镍
        register("rawIridium", ItemBase.RAW_IRIDIUM);//铱
        register("rawUranium", ItemBase.RAW_URANIUM);//铀
        register("rawGallium", ItemBase.RAW_GALLIUM);//镓
        register("rawTitanium", ItemBase.RAW_TITANIUM);//钛
        register("rawPlatinum", ItemBase.RAW_PLATINUM);//铂
        register("rawTungsten", ItemBase.RAW_TUNGSTEN);//钨
        register("rawAluminium", ItemBase.RAW_ALUMINIUM);//铝
        register("rawMagnesium", ItemBase.RAW_MAGNESIUM);//镁

        register("rawLithium", ItemBase.RAW_LITHIUM);//锂
        register("rawThorium", ItemBase.RAW_THORIUM);//钍
        register("rawBoron", ItemBase.RAW_BORON);//硼

        register("rawArdite", ItemBase.RAW_ARDITE);//阿迪特
        register("rawCerulean", ItemBase.RAW_CERULEAN);//晶蓝
        register("rawMoonstone", ItemBase.RAW_MOONSTONE);//皎月石
        register("rawOctine", ItemBase.RAW_OCTINE);//炽炎铁
        register("rawSyrmorite", ItemBase.RAW_SYRMORITE);//赛摩铜
    }

    //注册矿词方法
    public static void register(String ore, Item item) {
        if (item == null) {return;}

        ItemStack newitem = new ItemStack(item);
        OreDictionary.registerOre(ore, newitem);
    }
}
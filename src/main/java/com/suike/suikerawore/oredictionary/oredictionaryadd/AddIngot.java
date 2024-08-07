package com.suike.suikerawore.oredictionary.oredictionaryadd;

import com.suike.suikerawore.item.ItemBase;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraftforge.oredict.OreDictionary;

//添加锭矿词
public class AddIngot {
    public static void Add() {
        register("ingotCopper", ItemBase.INGOT_COPPER);//铜
        register("ingotTin", ItemBase.INGOT_TIN);//锡
        register("ingotZinc", ItemBase.INGOT_ZINC);//锌
        register("ingotLead", ItemBase.INGOT_LEAD);//铅
        register("ingotSilver", ItemBase.INGOT_SILVER);//银
        register("ingotCobalt", ItemBase.INGOT_COBALT);//钴
        register("ingotOsmium", ItemBase.INGOT_OSMIUM);//锇
        register("ingotNickel", ItemBase.INGOT_NICKEL);//镍
        register("ingotIridium", ItemBase.INGOT_IRIDIUM);//铱
        register("ingotUranium", ItemBase.INGOT_URANIUM);//铀
        register("ingotGallium", ItemBase.INGOT_GALLIUM);//镓
        register("ingotTitanium", ItemBase.INGOT_TITANIUM);//钛
        register("ingotPlatinum", ItemBase.INGOT_PLATINUM);//铂
        register("ingotTungsten", ItemBase.INGOT_TUNGSTEN);//钨
        register("ingotAluminum", ItemBase.INGOT_ALUMINIUM);//铝
        register("ingotAluminium", ItemBase.INGOT_ALUMINIUM);//铝
        register("ingotMagnesium", ItemBase.INGOT_MAGNESIUM);//镁
        register("ingotLithium", ItemBase.INGOT_LITHIUM);//锂
        register("ingotThorium", ItemBase.INGOT_THORIUM);//钍
        register("ingotBoron", ItemBase.INGOT_BORON);//硼
    }

    //注册矿词方法
    public static void register(String ore, Item item) {
        ItemStack newitem = new ItemStack(item);
        OreDictionary.registerOre(ore, newitem);
    }
}
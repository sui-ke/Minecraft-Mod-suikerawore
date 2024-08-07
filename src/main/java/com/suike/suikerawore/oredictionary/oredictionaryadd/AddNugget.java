package com.suike.suikerawore.oredictionary.oredictionaryadd;

import com.suike.suikerawore.item.ItemBase;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraftforge.oredict.OreDictionary;

//添加粒矿词
public class AddNugget {
    public static void Add() {
        register("nuggetAluminum", ItemBase.NUGGET_ALUMINIUM);//铝
        register("nuggetAluminium", ItemBase.NUGGET_ALUMINIUM);//铝
    }

    //注册矿词方法
    public static void register(String ore, Item item) {
        ItemStack newitem = new ItemStack(item);
        OreDictionary.registerOre(ore, newitem);
    }
}
package com.suike.suikerawore.expand.galaxyspace;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraftforge.oredict.OreDictionary;

public class AddOD {
    public static void Add() {
        //钴块
        ItemStack Items = new ItemStack(Item.getByNameOrId("galaxyspace:decoblocks"), 1, 8);;
        register("blockCobalt", Items);
        //镍块
        Items = new ItemStack(Item.getByNameOrId("galaxyspace:decoblocks"), 1, 9);;
        register("blockNickel", Items);
        //镁块
        Items = new ItemStack(Item.getByNameOrId("galaxyspace:decoblocks"), 1, 10);;
        register("blockMagnesium", Items);

        //钴粒
        Items = new ItemStack(Item.getByNameOrId("galaxyspace:nuggets"), 1, 0);;
        register("nuggetCobalt", Items);
        //镍粒
        Items = new ItemStack(Item.getByNameOrId("galaxyspace:nuggets"), 1, 2);;
        register("nuggetNickel", Items);
        //镁粒
        Items = new ItemStack(Item.getByNameOrId("galaxyspace:nuggets"), 1, 1);;
        register("nuggetMagnesium", Items);
    }

    //注册矿词方法
    public static void register(String ore, ItemStack item) {
        OreDictionary.registerOre(ore, item);
    }
}

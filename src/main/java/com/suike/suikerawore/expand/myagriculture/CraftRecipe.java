package com.suike.suikerawore.expand.myagriculture;

import com.suike.suikerawore.SuiKe;
import com.suike.suikerawore.item.ItemBase;

import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import net.minecraftforge.fml.common.registry.GameRegistry;

//注册工作台配方
public class CraftRecipe {
    public static void register() {
        /*铜*/addregister("mysticalagriculture:copper_essence", ItemBase.INGOT_COPPER);
        /*锡*/addregister("mysticalagriculture:tin_essence", ItemBase.INGOT_TIN);
        /*铅*/addregister("mysticalagriculture:lead_essence", ItemBase.INGOT_LEAD);
        /*银*/addregister("mysticalagriculture:silver_essence", ItemBase.INGOT_SILVER);
        /*钴*/addregister("mysticalagriculture:cobalt_essence", ItemBase.INGOT_COBALT);
        /*锇*/addregister("mysticalagriculture:osmium_essence", ItemBase.INGOT_OSMIUM);
        /*镍*/addregister("mysticalagriculture:nickel_essence", ItemBase.INGOT_NICKEL);
        /*铀*/addregister("mysticalagriculture:uranium_essence", ItemBase.INGOT_URANIUM);
        /*钛*/addregister("mysticalagriculture:titanium_essence", ItemBase.INGOT_TITANIUM);
        /*铝*/addregister("mysticalagriculture:aluminum_essence", ItemBase.INGOT_ALUMINIUM);
    }

    public static void addregister(String inputName, Item items) {
        //获取物品注册名
        String name = inputName.replaceAll(".*:", "").trim();

        ItemStack input = new ItemStack(Item.getByNameOrId(inputName));
        ItemStack output = new ItemStack(items).copy();
        output.setCount(4);//设置数量

        GameRegistry.addShapedRecipe(
            new ResourceLocation(SuiKe.MODID, name + ">ingot"),//配方标识符
            new ResourceLocation(SuiKe.MODID),//分组名
            output, 
            "AAA",
            "ABA",
            "AAA",
            'A', input,
            'B', ItemStack.EMPTY
        );
    }
}
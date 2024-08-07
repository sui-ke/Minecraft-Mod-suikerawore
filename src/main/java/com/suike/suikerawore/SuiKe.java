package com.suike.suikerawore;

import com.suike.suikerawore.recipe.Recipe;
import com.suike.suikerawore.config.Config;
import com.suike.suikerawore.proxy.CommonProxy;
import com.suike.suikerawore.oredictionary.Dictionary;
import com.suike.suikerawore.itemtabs.rawOreTabs;
import com.suike.suikerawore.expand.Expand;
import com.suike.suikerawore.expand.Examine;

import net.minecraft.client.Minecraft;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;

@Mod(modid = SuiKe.MODID, name = SuiKe.NAME, version = SuiKe.VERSION)
public class SuiKe {

    public static final String MODID = "suikerawore";
    public static final String NAME = "rawOre_on_1.12.2";
    public static final String VERSION = "1.4.20.1";
    public static final String ACCEPTED_VERSIONS = "[1.12.2]";

    @Mod.EventHandler
    public static void PreInit(FMLPreInitializationEvent event) {
        /*检查配置文件*/Config.config(event);

        /*检查是否拥有联动模组*/Examine.examine();
    }

    @EventHandler
    public static void PostInit(FMLPostInitializationEvent event) {
        /*矿词类*/Dictionary.dictionary();

        /*联动*/Expand.expand();

        /*配方*/Recipe.register();

        if (!server) {
            /*修改物品栏*/rawOreTabs.Inventory();
        }
    }
}
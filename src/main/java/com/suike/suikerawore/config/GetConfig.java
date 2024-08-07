package com.suike.suikerawore.config;

import java.io.File;

import com.suike.suikerawore.SuiKe;
import com.suike.suikerawore.config.Config;
import com.suike.suikerawore.config.ConfigValue;
//联动
import com.suike.suikerawore.expand.densemetals.DenseMetals;

import net.minecraft.client.Minecraft;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import net.minecraftforge.fml.common.Loader;

public class GetConfig {
    public static void config(FMLPreInitializationEvent event) {
        //获取配置文件值
        loadMainConfig();

        if (Loader.isModLoaded("densemetals")) {
            //读取致密矿石配置文件
            configDenseMetals(event);
        }
    }

    public static void loadMainConfig() {
        //获取配置文件位置
        Configuration config = new Configuration(Config.configFile);

        //读取配置项
        //总控制
        String a = "rawOre";
        String b = "rawOreDrop";//是否掉落粗矿
        ConfigValue.rawOreDrop = config.get(a, b, true).getBoolean();
        //粗矿掉落数量
        b = "rawOreDropAmount";
        ConfigValue.rawOreDropAmount = (int) config.get(a, b, 1).getDouble();
        //粗块熔炼
        b = "rawBlockSmelt";
        ConfigValue.rawBlockSmelt = config.get(a, b, false).getBoolean();

        //联动
        //IC2
        a = "CrossMod.IC2";
        //打粉机输出量
        b = "maceratorOutputAmount";
        int amount = (int) config.get(a, b, 1).getDouble();
        ConfigValue.maceratorOutputAmount = maximum(amount);

        //通用机械
        a = "CrossMod.Mekanism";
        //粉碎机输出量
        b = "CrusherOutputAmount";
        amount = (int) config.get(a, b, 1).getDouble();
        ConfigValue.CrusherOutputAmount = maximum(amount);
        //富集仓输出量
        b = "EnrichmentOutputAmount";
        amount = (int) config.get(a, b, 1).getDouble();
        ConfigValue.EnrichmentOutputAmount = maximum(amount);
        //净化仓输出量
        b = "PurificationOutputAmount";
        amount = (int) config.get(a, b, 2).getDouble();
        ConfigValue.PurificationOutputAmount = maximum(amount);
        //化学压射室输出量
        b = "ChemicalInjectionChamberOutputAmount";
        amount = (int) config.get(a, b, 2).getDouble();
        ConfigValue.ChemicalInjectionChamberOutputAmount = maximum(amount);
        //化学压射室输出量
        b = "ChemicalDissolutionChamberMultiple";
        amount = (int) config.get(a, b, 1).getDouble();
        ConfigValue.ChemicalDissolutionChamberMultiple = maximum(amount);

        //匠魂
        a = "CrossMod.Tconstruct";
        //溶液倍数
        b = "FluidMultiple";
        amount = (int) config.get(a, b, 1).getDouble();
        ConfigValue.FluidMultiple = maximum(amount);

        //致密矿石
        a = "CrossMod.DenseMetals";
        b = "DenseRawOreDrop";//是否掉落粗矿
        ConfigValue.DenseRawOreDrop = config.get(a, b, true).getBoolean();

        //更多粗矿
        a = "CrossMod.MoreRawOre";
        b = "MoreRawOreDrop";//是否掉落粗矿
        ConfigValue.DenseRawOreDrop = config.get(a, b, true).getBoolean();
    }

    public static int maximum(int value) {
        if (value > 64) {
            //设置新的值
            value = 64;
        }

        return value;
    }

    //致密矿石
    public static void configDenseMetals(FMLPreInitializationEvent event) {
        File directory;

        //获取 Minecraft config 目录
        if (SuiKe.server) {
            directory = new File(event.getModConfigurationDirectory(), "");
        } else {
            directory = new File(Minecraft.getMinecraft().mcDataDir, "config");
        }
        
        File configFile = new File(directory, "densemetals.cfg");

        //获取配置文件位置
        Configuration config = new Configuration(configFile);
        loadDenseMetalsConfig(config);
    }

    public static void loadDenseMetalsConfig(Configuration config) {
        //读取配置项
        DenseMetals.denseOreValue = (int) config.get("_general", "Dense Ore Value", 2).getInt();
    }
}
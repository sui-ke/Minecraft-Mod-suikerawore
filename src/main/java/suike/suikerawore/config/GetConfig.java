package suike.suikerawore.config;

import java.io.File;

import suike.suikerawore.SuiKe;
import suike.suikerawore.config.Config;
import suike.suikerawore.config.ConfigValue;
//联动
import suike.suikerawore.expand.densemetals.DenseMetals;

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
        //总控制
        ConfigValue.rawOreDrop = readConfig("rawOre", "rawOreDrop", true);
        ConfigValue.rawOreDropAmount = readConfig("rawOre", "rawOreDropAmount", 1);
        ConfigValue.FurnaceOutputAmount = readConfig("rawOre", "FurnaceOutputAmount", 1);
        ConfigValue.rawBlockSmelt = readConfig("rawOre", "rawBlockSmelt", false);
        ConfigValue.DenseRawOreDrop = readConfig("rawOre.MoreRawOre", "MoreRawOreDrop", true);

        //IC2
        ConfigValue.maceratorOutputAmount = readConfig("CrossMod.IC2", "maceratorOutputAmount", 1);

        //通用机械
        ConfigValue.CrusherOutputAmount = readConfig("CrossMod.Mekanism", "CrusherOutputAmount", 1);
        ConfigValue.EnrichmentOutputAmount = readConfig("CrossMod.Mekanism", "EnrichmentOutputAmount", 1);
        ConfigValue.PurificationOutputAmount = readConfig("CrossMod.Mekanism", "PurificationOutputAmount", 2);
        ConfigValue.ChemicalInjectionChamberOutputAmount = readConfig("CrossMod.Mekanism", "ChemicalInjectionChamberOutputAmount", 2);
        ConfigValue.ChemicalDissolutionChamberMultiple = readConfig("CrossMod.Mekanism", "ChemicalDissolutionChamberMultiple", 1);

        //热力膨胀5
        ConfigValue.PulverizerOutputAmount = readConfig("CrossMod.ThermalExpansion", "PulverizerOutputAmount", 1);
        ConfigValue.PulverizerSecondaryOutputAmount = readConfig("CrossMod.ThermalExpansion", "PulverizerSecondaryOutputAmount", 1);
        ConfigValue.MagmaCrucibleOutputMultiple = readConfig("CrossMod.ThermalExpansion", "MagmaCrucibleOutputMultiple", 1.0f);

        //匠魂2
        ConfigValue.FluidMultiple = readConfig("CrossMod.Tconstruct", "FluidMultiple", 1.0f);

        //致密矿石掉落
        ConfigValue.DenseRawOreDrop = readConfig("CrossMod.DenseMetals", "DenseRawOreDrop", true);
    }

    public static int readConfig(String category, String key, int defaultValue) {
        return (int) readConfig(category, key, defaultValue, true);
    }
    public static float readConfig(String category, String key, float defaultValue) {
        return 保留一位小数((float) readConfig(category, key, defaultValue, true));
    }
    public static boolean readConfig(String category, String key, boolean defaultValue) {
        return (boolean) readConfig(category, key, defaultValue, true);
    }

    public static Object readConfig(String category, String key, Object defaultValue, boolean a) {
        /*获取配置文件位置*/Configuration config = new Configuration(Config.configFile);

        if (defaultValue instanceof Integer) {
            return (int) maximum(config.get(category, key, (Integer) defaultValue).getDouble());
        } else if (defaultValue instanceof Float) {
            return (float) maximum(config.get(category, key, (Float) defaultValue).getDouble());
        } else if (defaultValue instanceof Boolean) {
            return (boolean) config.get(category, key, (Boolean) defaultValue).getBoolean();
        }

        return defaultValue;
    }

    public static float 保留一位小数(float floats) {
        return (float) (Math.floor( floats * 10) / 10);
    }
    public static double maximum(double value) {
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
            directory = new File(Minecraft.getMinecraft().gameDir, "config");
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
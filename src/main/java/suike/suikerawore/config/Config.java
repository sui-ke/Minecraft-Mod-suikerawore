package suike.suikerawore.config;

import java.io.File;

import suike.suikerawore.SuiKe;

import net.minecraft.client.Minecraft;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class Config {
    public static File config;
    public static File configFile;
    public static File configFileCopy;
    public static File oldConfigFile;
    //获取和读取配置文件
    public static void config(FMLPreInitializationEvent event) {
        //获取 Minecraft/config/suike 目录
        if (SuiKe.server) {
            config = new File(event.getModConfigurationDirectory(), "sui_ke");
        } else {
            config = new File(Minecraft.getMinecraft().mcDataDir, "config/sui_ke");
        }

        /*配置文件*/configFile = new File(config, "rawore/rawOre.cfg");
        /*旧配置文件*/configFileCopy = new File(config, "rawore/rawOreCopy.cfg");
        /*旧配置文件*/oldConfigFile = new File(config, "rawOre.cfg");

        //检查配置文件
        CreateConfigFile.config();
        //读取配置文件
        ConfigGet.config(event);

        //未打开精简模式
        if (!ConfigValue.LiteVersion) {
            //检查粗矿列表文件
            RawOreList.config();
            //读取粗矿列表文件
            RawOreListGet.config();
        } else {
            String types[] = {"gold", "iron", "copper"};
            for (String type : types) {
                ConfigValue.rawOreList.put(type, true);
            }
        }
    }
}
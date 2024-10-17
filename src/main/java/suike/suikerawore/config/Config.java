package suike.suikerawore.config;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import suike.suikerawore.SuiKe;

import java.io.File;

public class Config {
    public static File configFile;
    public static File configFileCopy;

    //获取和读取配置文件
    public static void config(FMLPreInitializationEvent event) {
        File config;
        //获取 Minecraft/config/suike 目录
        if (SuiKe.server) {
            config = new File(event.getModConfigurationDirectory(), "sui_ke");
        } else {
            config = new File(Minecraft.getMinecraft().gameDir, "config/sui_ke");
        }

        if (!config.exists()) {
            config.mkdirs();
        }
        configFile = new File(config, "rawOre.cfg");
        configFileCopy = new File(config, "rawOreCopy.cfg");

        //检查配置文件
        CreateConfigFile.config(event);
        //读取配置文件
        GetConfig.config(event);
    }
}
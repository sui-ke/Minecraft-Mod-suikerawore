package suike.suikerawore.config;

import java.io.File;
import java.io.InputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.charset.StandardCharsets;

import suike.suikerawore.SuiKe;
import suike.suikerawore.config.GetConfig;
import suike.suikerawore.config.ConfigValue;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CreateConfigFile {
    public static void config(FMLPreInitializationEvent event) {
        File configFile = Config.configFile;
        File configFileCopy = Config.configFileCopy;

        boolean haveConfig = configFile.exists();
        boolean needUpdate = false;

        Configuration config = new Configuration(configFile);

        if (haveConfig) {
            config.load();
            //获取配置文件版本
            int configVersion = (int) config.get("rawOre", "configVersion", 0).getDouble();

            if (configVersion != ConfigValue.modsConfigVersion) {
                config.save();//加载配置
                needUpdate = true;
                //备份旧配置文件
                try {
                    Files.copy(configFile.toPath(), configFileCopy.toPath(), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //删除旧配置文件
                if (haveConfig) {
                    configFile.delete();
                }
            }
        }

        if (!haveConfig || needUpdate) {
            //从资源路径中复制默认配置文件
            try (InputStream input = CreateConfigFile.class.getResourceAsStream("/assets/suikerawore/sui_ke.cfg")) {
                Files.copy(input, configFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (needUpdate) {

            //读取备份文件内容
            String backupConfigContent;
            try {
                backupConfigContent = new String(Files.readAllBytes(configFileCopy.toPath()), StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }

            //更新新配置文件中的值
            try {
                String newConfigContent = new String(Files.readAllBytes(configFile.toPath()), StandardCharsets.UTF_8);
            //总控制
                /*是否掉落粗矿*/newConfigContent = updateConfigValue(newConfigContent, backupConfigContent, "rawOreDrop");
                /*粗矿掉落数量*/newConfigContent = updateConfigValue(newConfigContent, backupConfigContent, "rawOreDropAmount");
                /*熔炉输出量*/newConfigContent = updateConfigValue(newConfigContent, backupConfigContent, "FurnaceOutputAmount");
                /*粗块熔炼*/newConfigContent = updateConfigValue(newConfigContent, backupConfigContent, "rawBlockSmelt");
                /*更多粗矿掉落*/newConfigContent = updateConfigValue(newConfigContent, backupConfigContent, "MoreRawOreDrop");

            //联动
                /*打粉机输出量*/newConfigContent = updateConfigValue(newConfigContent, backupConfigContent, "maceratorOutputAmount");

                /*粉碎机输出量*/newConfigContent = updateConfigValue(newConfigContent, backupConfigContent, "CrusherOutputAmount");
                /*富集仓输出量*/newConfigContent = updateConfigValue(newConfigContent, backupConfigContent, "EnrichmentOutputAmount");
                /*净化仓输出量*/newConfigContent = updateConfigValue(newConfigContent, backupConfigContent, "PurificationOutputAmount");
                /*化学压射室输出量*/newConfigContent = updateConfigValue(newConfigContent, backupConfigContent, "ChemicalInjectionChamberOutputAmount");
                /*化学溶解室倍数*/newConfigContent = updateConfigValue(newConfigContent, backupConfigContent, "ChemicalDissolutionChamberMultiple");

                /*磨粉机输出量*/newConfigContent = updateConfigValue(newConfigContent, backupConfigContent, "PulverizerOutputAmount");
                /*磨粉机副产物输出量*/newConfigContent = updateConfigValue(newConfigContent, backupConfigContent, "PulverizerSecondaryOutputAmount");
                /*熔岩炉溶液倍数*/newConfigContent = updateConfigValue(newConfigContent, backupConfigContent, "MagmaCrucibleOutputMultiple");

                /*溶液倍数*/newConfigContent = updateConfigValue(newConfigContent, backupConfigContent, "FluidMultiple");

                /*致密矿石掉落*/newConfigContent = updateConfigValue(newConfigContent, backupConfigContent, "DenseRawOreDrop");

                Files.write(configFile.toPath(), newConfigContent.getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                e.printStackTrace();
            }

            //删除备份的配置文件
            configFileCopy.delete();
        }
    }

    private static String updateConfigValue(String newConfigContent, String backupConfigContent, String key) {
        String backupValue = getValueFromBackup(backupConfigContent, key);
        if (backupValue.isEmpty()) {
            //保持设置默认值
            return newConfigContent;
        } else {
            //使用固定字符串替换
            String oldConfigLine = getConfigLine(newConfigContent, key);
            String newConfigLine = key + "=" + backupValue;
            return newConfigContent.replace(oldConfigLine, newConfigLine);
        }
    }

    private static String getValueFromBackup(String content, String key) {
        int startIndex = content.indexOf(key + "=");
        if (startIndex == -1) {
            return "";
        }
        startIndex += key.length() + 1;
        int endIndex = content.indexOf("\n", startIndex);
        if (endIndex == -1) endIndex = content.length();
        return content.substring(startIndex, endIndex).trim();
    }

    private static String getConfigLine(String content, String key) {
        int startIndex = content.indexOf(key + "=");
        if (startIndex == -1) return "";
        int endIndex = content.indexOf("\n", startIndex);
        if (endIndex == -1) endIndex = content.length();
        return content.substring(startIndex, endIndex).trim();
    }
}
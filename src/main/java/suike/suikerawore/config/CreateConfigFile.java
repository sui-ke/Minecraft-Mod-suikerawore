package suike.suikerawore.config;

import suike.suikerawore.SuiKe;

import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.InputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.nio.charset.StandardCharsets;

import net.minecraftforge.common.config.Configuration;

public class CreateConfigFile {
    public static void config() {
        if (Config.oldConfigFile.exists()) {
            try {
                Files.copy(Config.oldConfigFile.toPath(), Config.configFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }

            Config.oldConfigFile.delete();
        }

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
            // 配置文件名称
            String configName = "sui_ke_zh.cfg";
            if (!SuiKe.isZhCn) {
                configName = "sui_ke_en.cfg";
            }

            //从资源路径中复制默认配置文件
            try (InputStream input = CreateConfigFile.class.getResourceAsStream("/assets/suikerawore/" + configName)) {
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
                List<String> configKeys = getConfigKeys(newConfigContent);

                for (String key : configKeys) {
                    if (key.equals("D:configVersion")) {
                        continue;
                    }

                    newConfigContent = updateConfigValue(newConfigContent, backupConfigContent, key);
                }

                Files.write(configFile.toPath(), newConfigContent.getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                e.printStackTrace();
            }

            //删除备份的配置文件
            configFileCopy.delete();
        }
    }

    public static List<String> getConfigKeys(String configContent) {
        List<String> keys = new ArrayList<>();
        String[] lines = configContent.split("\n");
        for (String line : lines) {
            if (line.contains("=")) {
                String key = line.split("=")[0].trim();
                keys.add(key);
            }
        }
        return keys;
    }

    public static String updateConfigValue(String newConfigContent, String backupConfigContent, String key) {
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
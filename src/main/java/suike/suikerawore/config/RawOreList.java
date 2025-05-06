package suike.suikerawore.config;

import java.util.List;
import java.io.File;
import java.io.InputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.nio.charset.StandardCharsets;

import net.minecraftforge.common.config.Configuration;

public class RawOreList {
    public static void config() {
        File rawOreListFile = new File(Config.config, "rawore/rawOreList.cfg");
        File rawOreListFileCopy = new File(Config.config, "rawore/rawOreListCopy.cfg");

        boolean haveConfig = rawOreListFile.exists();
        boolean needUpdate = false;

        Configuration config = new Configuration(rawOreListFile);

        if (haveConfig) {
            config.load();
            //获取配置文件版本
            int configVersion = (int) config.get("rawOre", "configVersion", 0).getDouble();

            if (configVersion != ConfigValue.rawOreListVersion) {
                config.save();//加载配置
                needUpdate = true;
                //备份旧配置文件
                try {
                    Files.copy(rawOreListFile.toPath(), rawOreListFileCopy.toPath(), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //删除旧配置文件
                if (haveConfig) {
                    rawOreListFile.delete();
                }
            }
        }

        if (!haveConfig || needUpdate) {
            //从资源路径中复制默认配置文件
            try (InputStream input = CreateConfigFile.class.getResourceAsStream("/assets/suikerawore/rawOreList.cfg")) {
                Files.copy(input, rawOreListFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (needUpdate) {

            //读取备份文件内容
            String backupConfigContent;
            try {
                backupConfigContent = new String(Files.readAllBytes(rawOreListFileCopy.toPath()), StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }

            //更新新配置文件中的值
            try {
                String newConfigContent = new String(Files.readAllBytes(rawOreListFile.toPath()), StandardCharsets.UTF_8);
                List<String> configKeys = CreateConfigFile.getConfigKeys(newConfigContent);

                for (String key : configKeys) { 
                    if (key.equals("D:version")) {
                        continue;
                    }

                    newConfigContent = CreateConfigFile.updateConfigValue(newConfigContent, backupConfigContent, key);
                }

                Files.write(rawOreListFile.toPath(), newConfigContent.getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                e.printStackTrace();
            }

            //删除备份的配置文件
            rawOreListFileCopy.delete();
        }
    }
}
package suike.suikerawore.config;

import java.util.Map;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;

import suike.suikerawore.SuiKe;

import net.minecraftforge.common.config.Configuration;

public class RawOreListRead {
    public static void config() {
        File configFile = new File(Config.config, "rawore/rawOreList.cfg");

        try {
            String configContent = new String(Files.readAllBytes(configFile.toPath()), StandardCharsets.UTF_8);
            /*获取所有的键*/List<String> keys = CreateConfigFile.getConfigKeys(configContent);

            for (String key : keys) {
                if (key.equals("D:version")) {
                    continue;
                }

                key = key.substring(key.indexOf(':') + 1).trim();
                boolean value = readConfig(new Configuration(configFile), key);

                key = key.substring(key.indexOf('-') + 1).trim();
                ConfigValue.rawOreList.put(key.toLowerCase(), value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean readConfig(Configuration config, String key) {
        return config.get("rawOreList", key, (Boolean) false).getBoolean();
    }
}
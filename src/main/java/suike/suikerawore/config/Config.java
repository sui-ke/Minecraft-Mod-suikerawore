package suike.suikerawore.config;

import java.io.File;

import suike.suikerawore.SuiKe;

import net.minecraft.client.Minecraft;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class Config {
    // 获取和读取配置文件
    public static void config() {
        File mcFile = getMCFile();
        /*配置文件*/File configFile = new File(mcFile, "config/sui_ke/rawore/rawOre.cfg");
        /*旧配置文件*/File configFileCopy = new File(mcFile, "config/sui_ke/rawore/rawOreCopy.cfg");

        // 检查配置文件
        CreateConfigFile.config(configFile, configFileCopy);

        if (ConfigValue.oldConfigVersion > 0 && ConfigValue.oldConfigVersion < 24) {
            upConfigValueTo24(mcFile, configFile);
        }

        // 读取配置文件
        new ConfigRead(configFile).config();

        if (Loader.isModLoaded("unidict")) {
            ConfigValue.needIngot = false;
        }
    }

    public static void redRefinedItem() {
        File mcFile = getMCFile();
        /*配置文件*/File configFile = new File(mcFile, "config/sui_ke/rawore/rawOre.cfg");

        new ConfigRead(configFile).redRefinedItem();
    }

    // 富集矿石配置
    public static int getDenseMultiple() {
        try {
            return com.mcmoddev.densemetals.DenseMetalsConfig.denseOreValue;
        } catch (Throwable e) {
            return 2;
        }
    }

    private static void upConfigValueTo24(File mcFile, File configFile) {
        CreateConfigFile.upConfigValue(2, configFile, "D:maceratorRawOutputAmount", "2");

        CreateConfigFile.upConfigValue(2, configFile, "D:EnrichmentOutputAmount"              , "2");
        CreateConfigFile.upConfigValue(2, configFile, "D:PurificationOutputAmount"            , "3");
        CreateConfigFile.upConfigValue(2, configFile, "D:ChemicalInjectionChamberOutputAmount", "4");
        CreateConfigFile.upConfigValue(2, configFile, "D:ChemicalDissolutionChamberMultiple"  , "1");

        CreateConfigFile.upConfigValue(2, configFile, "D:PulverizerOutputAmount", "2");
        CreateConfigFile.upConfigValue(2, configFile, "D:MagmaCrucibleOutputMultiple", "1");

        CreateConfigFile.upConfigValue(2, configFile, "D:FluidMultiple", "1");

        File rawOreList = new File(mcFile, "config/sui_ke/rawore/rawOreList.cfg");
        if (rawOreList.exists()) {
            rawOreList.delete();
        }
    }

    private static File getMCFile() {
        return SuiKe.isServer
            ? FMLCommonHandler.instance().getMinecraftServerInstance().getDataDirectory()
            : Minecraft.getMinecraft().mcDataDir;
    }
}
package suike.suikerawore.config;

import java.io.File;
import java.util.Map;

import suike.suikerawore.SuiKe;
import suike.suikerawore.item.*;
import suike.suikerawore.config.Config;
import suike.suikerawore.config.ConfigValue;

import net.minecraft.util.math.MathHelper;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.common.config.Configuration;

public class ConfigRead {

    private final Configuration config;

    public ConfigRead(File configFile) {
        this.config = new Configuration(configFile);
    }

    // 获取配置文件值
    public void config() {
        // 总控制
        ConfigValue.needIngot           = this.readConfig("rawOre", "needIngot", true);
        ConfigValue.rawOreDropAmount    = this.readConfig("rawOre", "rawOreDropAmount", 1);
        ConfigValue.FurnaceOutputAmount = this.readConfig("rawOre", "FurnaceOutputAmount", 1);
        ConfigValue.rawBlockSmelt       = this.readConfig("rawOre", "rawBlockSmelt", false);

        // IC2
        ConfigValue.maceratorRawOutputAmount = this.readConfig("CrossMod.IC2", "maceratorRawOutputAmount", 1);

        // 通用机械
        ConfigValue.EnrichmentOutputAmount               = this.readConfig("CrossMod.Mekanism", "EnrichmentOutputAmount", 1);
        ConfigValue.PurificationOutputAmount             = this.readConfig("CrossMod.Mekanism", "PurificationOutputAmount", 2);
        ConfigValue.ChemicalInjectionChamberOutputAmount = this.readConfig("CrossMod.Mekanism", "ChemicalInjectionChamberOutputAmount", 2);
        ConfigValue.ChemicalDissolutionChamberMultiple   = this.readConfig("CrossMod.Mekanism", "ChemicalDissolutionChamberMultiple", 1);

        // 热力膨胀5
        ConfigValue.PulverizerOutputAmount          = this.readConfig("CrossMod.ThermalExpansion", "PulverizerOutputAmount", 1);
        ConfigValue.PulverizerSecondaryOutputAmount = this.readConfig("CrossMod.ThermalExpansion", "PulverizerSecondaryOutputAmount", 1);
        ConfigValue.MagmaCrucibleOutputMultiple     = this.readConfig("CrossMod.ThermalExpansion", "MagmaCrucibleOutputMultiple", 1.0f);

        // 匠魂2
        ConfigValue.FluidMultiple = this.readConfig("CrossMod.Tconstruct", "FluidMultiple", 1.0f);

        // 富集矿石掉落
        ConfigValue.DenseRawOreDrop = this.readConfig("CrossMod.DenseMetals", "DenseRawOreDrop", true);
    }

    public void redRefinedItem() {
        for (Map.Entry<String, ModItemRawOre> mapEntry : ModItemRawOre.TYPE_TO_RAW_ORE.entrySet()) {
            ModItemRawOre rawOre = mapEntry.getValue();
            String output = readConfig("rawOre", rawOre.getItemOreDict(), "").replace("\"", "");
            if (!output.isEmpty()) {
                rawOre.setRefinedItem(output);
            }
        }
    }

    private int readConfig(String category, String key, int defaultValue) {
        return (int) MathHelper.clamp(this.config.get(category, key, defaultValue).getDouble(), 1, 64);
    }
    private float readConfig(String category, String key, float defaultValue) {
        return roundToOneDecimal((float) MathHelper.clamp(this.config.get(category, key, defaultValue).getDouble(), 1, 64));
    }
    private boolean readConfig(String category, String key, boolean defaultValue) {
        return this.config.get(category, key, (Boolean) defaultValue).getBoolean();
    }
    private String readConfig(String category, String key, String defaultValue) {
        String value = this.config.get(category, key, (String) defaultValue).getString();
        return value != null ? value : "";
    }

    // 保留一位小数
    private static float roundToOneDecimal(float floats) {
        return (float) (Math.floor(floats * 10) / 10);
    }
}
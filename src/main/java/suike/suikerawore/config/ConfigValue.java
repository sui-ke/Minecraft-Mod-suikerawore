package suike.suikerawore.config;

public class ConfigValue {
    public static final int modsConfigVersion = 24;
    public static int oldConfigVersion = 0;

    // 总控制
    public static boolean needIngot = true;      // 需要锭
    public static int rawOreDropAmount = 1;      // 掉落数量
    public static int FurnaceOutputAmount = 1;   // 熔炉输出量
    public static boolean rawBlockSmelt = false; // 粗块熔炼

    // 联动
        // IC2
    public static int maceratorRawOutputAmount = 2; // 打粉机碎块输出量
        // 通用机械
    public static int EnrichmentOutputAmount = 2;               // 富集仓输出量
    public static int PurificationOutputAmount = 3;             // 净化仓输出量
    public static int ChemicalInjectionChamberOutputAmount = 4; // 化学压射室输出量
    public static int ChemicalDissolutionChamberMultiple = 1;   // 化学溶解室浆液倍数
        // 热力膨胀5
    public static int PulverizerOutputAmount = 2;          // 磨粉机输出量
    public static int PulverizerSecondaryOutputAmount = 1; // 磨粉机副产物输出量
    public static float MagmaCrucibleOutputMultiple = 1;   // 熔岩炉溶液倍数
        // 匠魂
    public static float FluidMultiple = 1; // 溶液倍数
        // 富集矿石掉落
    public static boolean DenseRawOreDrop = true;
}
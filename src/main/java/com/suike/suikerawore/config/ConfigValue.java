package com.suike.suikerawore.config;

public class ConfigValue {
    //配置文件版本
    public static int modsConfigVersion = 10;//配置文件版本

    //总控制
    public static boolean rawOreDrop = true;//是否掉落
    public static int rawOreDropAmount = 1;//掉落数量
    public static boolean rawBlockSmelt = false;//粗块熔炼

    //联动
        //IC2
    public static int maceratorOutputAmount = 1;//打粉机输出量
        //通用机械
    public static int CrusherOutputAmount = 1;//粉碎机输出量
    public static int EnrichmentOutputAmount = 1;//富集仓输出量
    public static int PurificationOutputAmount = 2;//净化仓输出量
    public static int ChemicalInjectionChamberOutputAmount = 2;//化学压射室输出量
    public static int ChemicalDissolutionChamberMultiple = 1;//化学溶解室溶液倍数
        //匠魂
    public static int FluidMultiple = 1;//溶液倍数
        //致密矿石
    public static boolean DenseRawOreDrop = true;
        //更多粗矿
    public static boolean MoreRawOreDrop = true;
}
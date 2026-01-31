package suike.suikerawore.expand;

import java.util.*;

import suike.suikerawore.SuiKe;
import suike.suikerawore.item.*;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Expand {

    public static final boolean mekanismID = Loader.isModLoaded("mekanism"); // 通用机械

    public static void expand() {
        List<ExpandMod> expandMods = ExpandMod.initAll();

        for (Map.Entry<String, ModItemRawOre> mapEntry : ModItemRawOre.TYPE_TO_RAW_ORE.entrySet()) {
            ModItemRawOre rawOre = mapEntry.getValue();
            if (rawOre.isValid()) {
                for (ExpandMod expand : expandMods) {
                    expand.expandMod(rawOre);
                }
                rawOre.clearByProductData();
            }
        }
    }
}

/*
    public static boolean TCID; // 匠魂
    public static boolean tcomplementID; // 匠魂扩充
    public static boolean cofhcoreID; // CoFH核心
    public static boolean endercoreID; // 末影核心
    public static boolean thaumcraftID; // 神秘时代6
    public static boolean GalaxySpaceID; // 星系
    public static boolean GalacticraftID; // 星系
    public static boolean IC2UpgradeID; // 工业升级
    public static boolean ic2c_extrasID; // 工业2经典版拓展
    public static boolean IC2ClassicSpmodID; // 工业2经典版
    public static boolean IC2ID = Loader.isModLoaded("ic2"); // 工业2
    public static boolean JEIID = Loader.isModLoaded("jei"); // jei
    public static boolean mcaID = Loader.isModLoaded("mca"); // 虚拟人生
    public static boolean tetraID = Loader.isModLoaded("tetra"); // tetra
    public static boolean MaelstromID = Loader.isModLoaded("mm"); // 冒险漩涡
    public static boolean VicSWarfareID = Loader.isModLoaded("mw"); // 维克的现代战争
    public static boolean enderioID = Loader.isModLoaded("enderio"); // 末影接口
    public static boolean FuturemcID = Loader.isModLoaded("futuremc"); // 未来MC
    public static boolean hammertimeID = Loader.isModLoaded("hammertime"); // 锤子
    public static boolean TheAurorianID = Loader.isModLoaded("theaurorian"); // 极光幽境
    public static boolean deeperdepthsID = Loader.isModLoaded("deeperdepths"); // 试炼更新
    public static boolean iridiumsourceID = Loader.isModLoaded("iridiumsource"); // 铱矿产
    public static boolean TheBetweenlandsID = Loader.isModLoaded("thebetweenlands"); // 交错次元
    public static boolean thermalexpansionID = Loader.isModLoaded("thermalexpansion"); // 热力膨胀5
*/
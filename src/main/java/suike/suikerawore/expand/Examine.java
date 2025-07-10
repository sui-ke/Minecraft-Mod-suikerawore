package suike.suikerawore.expand;

import java.util.List;
import java.util.ArrayList;

import suike.suikerawore.SuiKe;
import suike.suikerawore.config.ConfigValue;
import suike.suikerawore.expand.thaumcraft.ThaumcraftExpand; // 神秘时代

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

//检查是否拥有联动模组模组
public class Examine {
    public static boolean TCID = false; // 匠魂
    public static boolean tcomplementID = false; // 匠魂扩充
    public static boolean JEIID = false; // jei
    public static boolean IC2ID = false; // 工业2
    public static boolean IC2UpgradeID = false; // 工业升级
    public static boolean IC2ClassicSpmodID = false; // 工业2经典版
    public static boolean ic2c_extrasID = false; // 工业2经典版拓展
    public static boolean tetraID = false; // tetra
    public static boolean enderioID = false; // 末影接口
    public static boolean endercoreID = false; // 末影核心
    public static boolean cofhcoreID = false; // CoFH核心
    public static boolean FuturemcID = false; // 未来MC
    public static boolean MekanismID = false; // 通用机械
    public static boolean vulcaniteID = false; // 软碲铜
    public static boolean MaelstromID = false; // 冒险漩涡
    public static boolean thaumcraftID = false; // 神秘时代6
    public static boolean TheAurorianID = false; // 极光幽境
    public static boolean GalacticraftID = false; // 星系
    public static boolean GalaxySpaceID = false; // 星系
    public static boolean iridiumsourceID = false; // 铱矿产
    public static boolean TheBetweenlandsID = false; // 交错次元
    public static boolean thermalexpansionID = false; // 热力膨胀5
    public static boolean VicSWarfareID = false; // 维克的现代战争
    public static boolean mcaID = false; // 虚拟人生
    public static boolean deeperdepthsID = false; // 试炼更新
    public static boolean hammertimeID = false; // 试炼更新

    public static boolean smelt = false; // 自动熔炼

    //检查是否拥有模组
    public static void examine() {
        /*jei*/if (Loader.isModLoaded("jei")) {JEIID = true;}
        /*工业2*/if (Loader.isModLoaded("ic2")) {IC2ID = true;}
        /*虚拟人生*/if (Loader.isModLoaded("mca")) {mcaID = true;}
        /*tetra*/if (Loader.isModLoaded("tetra")) {tetraID = true;}
        /*冒险漩涡*/if (Loader.isModLoaded("mm")) {MaelstromID = true;}
        /*未来MC*/if (Loader.isModLoaded("futuremc")) {FuturemcID = true;}
        /*末影接口*/if (Loader.isModLoaded("enderio")) {enderioID = true;}
        /*通用机械*/if (Loader.isModLoaded("mekanism")) {MekanismID = true;}
        /*维克的现代战争*/if (Loader.isModLoaded("mw")) {VicSWarfareID = true;}
        /*神秘时代6*/if (Loader.isModLoaded("thaumcraft")) {thaumcraftID = true;ThaumcraftExpand.expand();}
        /*极光幽境*/if (Loader.isModLoaded("theaurorian")) {TheAurorianID = true;}
        /*铱矿产*/if (Loader.isModLoaded("iridiumsource")) {iridiumsourceID = true;}
        /*交错次元*/if (Loader.isModLoaded("thebetweenlands")) {TheBetweenlandsID = true;}
        /*热力膨胀5*/if (Loader.isModLoaded("thermalexpansion")) {thermalexpansionID = true;}
        /*试炼更新*/if (Loader.isModLoaded("deeperdepths")) {deeperdepthsID = true;}
        /*锤子*/if (Loader.isModLoaded("hammertime")) {hammertimeID = true;}

        /*暮色森林*/if (Loader.isModLoaded("twilightforest")) {smelt = true;}
        /*软碲铜*/if (Loader.isModLoaded("vulcanite")) {vulcaniteID = true;smelt = true;}
        /*CoFH核心*/if (Loader.isModLoaded("cofhcore")) {cofhcoreID = true;smelt = true;}
        /*末影核心*/if (Loader.isModLoaded("endercore")) {endercoreID = true;smelt = true;}

        //匠魂
        if (Loader.isModLoaded("tconstruct")) {
            TCID = true;
            smelt = true;
            //匠魂扩充
            if (Loader.isModLoaded("tcomplement")) {
                tcomplementID = true;
            }
        }

        //星系
        if (Loader.isModLoaded("galacticraftplanets")) {
            GalacticraftID = true;
            //星空
            if (Loader.isModLoaded("galaxyspace")) {
                GalaxySpaceID = true;
            }
        }

        //工业2经典版
        if (Loader.isModLoaded("ic2-classic-spmod")) {
            IC2ClassicSpmodID = true;
            //工业2经典版拓展
            if (Loader.isModLoaded("ic2c_extras")) {
                ic2c_extrasID = true;
            }
        }
    }
}
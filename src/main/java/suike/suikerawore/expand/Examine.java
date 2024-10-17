package suike.suikerawore.expand;

import java.util.List;
import java.util.ArrayList;

import suike.suikerawore.SuiKe;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

//检查是否拥有联动模组模组
public class Examine {

    public static Object suikerawore_conflict;//冲突监听器
    public static boolean TCID = false;//匠魂
    public static boolean tcomplementID = false;//匠魂扩充
    public static boolean JEIID = false;//jei
    public static boolean IC2ID = false;//工业
    public static boolean IC2UpgradeID = false;//工业升级
    public static boolean tetraID = false;//tetra
    public static boolean enderioID = false;//末影接口
    public static boolean endercoreID = false;//末影核心
    public static boolean cofhcoreID = false;//CoFH核心
    public static boolean FuturemcID = false;//未来MC
    public static boolean MekanismID = false;//通用机械
    public static boolean vulcaniteID = false;//软碲铜
    public static boolean MaelstromID = false;//冒险漩涡
    public static boolean thaumcraftID = false;//神秘时代
    public static boolean TheAurorianID = false;//极光幽境
    public static boolean GalacticraftID = false;//星系
    public static boolean GalaxySpaceID = false;//星系
    public static boolean iridiumsourceID = false;//铱矿产
    public static boolean TheBetweenlandsID = false;//交错次元
    public static boolean thermalexpansionID = false;//热力膨胀5
    public static boolean VicSWarfareID = false;//维克的现代战争
    public static boolean MACID = false;
    public static boolean deeperdepthsID = false;//试炼更新

    public static boolean smelt = false;//自动熔炼

    //检查是否拥有模组
    public static void examine() {
        /*jei*/
        JEIID = Loader.isModLoaded("jei");
        /*工业*/
        IC2ID = Loader.isModLoaded("ic2");
        /*工业升级*/
        IC2UpgradeID = Loader.isModLoaded("industrialupgrade");
        /*虚拟人生*/
        MACID = Loader.isModLoaded("mca");
        /*tetra*/
        tetraID = Loader.isModLoaded("tetra");
        /*冒险漩涡*/
        MaelstromID = Loader.isModLoaded("mm");
        /*未来MC*/
        FuturemcID = Loader.isModLoaded("futuremc");
        /*末影接口*/
        enderioID = Loader.isModLoaded("enderio");
        /*通用机械*/
        MekanismID = Loader.isModLoaded("mekanism");
        /*维克的现代战争*/
        VicSWarfareID = Loader.isModLoaded("mw");
        /*神秘时代*/
        thaumcraftID = Loader.isModLoaded("thaumcraft");
        /*极光幽境*/
        TheAurorianID = Loader.isModLoaded("theaurorian");
        /*铱矿产*/
        iridiumsourceID = Loader.isModLoaded("iridiumsource");
        /*交错次元*/
        TheBetweenlandsID = Loader.isModLoaded("thebetweenlands");
        /*热力膨胀5*/
        thermalexpansionID = Loader.isModLoaded("thermalexpansion");
        /*试炼更新*/
        deeperdepthsID = Loader.isModLoaded("deeperdepths");
        /*暮色森林*/
        smelt = Loader.isModLoaded("twilightforest") || Loader.isModLoaded("vulcanite")
                || Loader.isModLoaded("cofhcore") || Loader.isModLoaded("endercore")
                || Loader.isModLoaded("tconstruct");

        /*软碲铜*/
        vulcaniteID = Loader.isModLoaded("vulcanite");
        /*CoFH核心*/
        cofhcoreID = Loader.isModLoaded("cofhcore");
        /*末影核心*/
        endercoreID = Loader.isModLoaded("endercore");
        //匠魂
        TCID = Loader.isModLoaded("tconstruct");
        //匠魂扩充
        tcomplementID = Loader.isModLoaded("tcomplement");
        GalacticraftID = Loader.isModLoaded("galacticraftplanets");
        GalaxySpaceID = Loader.isModLoaded("galaxyspace");



        if (!SuiKe.server) {
            //将冲突的模组ID加入'modIdStacks'列表
            List<String> modIdStacks = new ArrayList<>();
            modIdStacks.add("raw_ores");

            int a = 0;
            for (String modId : modIdStacks) {
                if (Loader.isModLoaded(modId)) {
                    //检查到冲突的模组
                    ConflictScreen.conflictModID(modId);
                    if (a == 0) {
                        a = 1;
                        conflict();//注册监听器
                    }
                }
            }

            modIdStacks = null;
        }
    }

    public static void conflict() {
    //注册监听器
        suikerawore_conflict = new Conflict();
        FMLCommonHandler.instance().bus().register(suikerawore_conflict);
    }

    public static class Conflict {
    //事件监听器
        @SubscribeEvent
        public void onClientTick(TickEvent.ClientTickEvent event) {
            if (event.phase == TickEvent.Phase.START) {
                ConflictScreen.conflict();
            }
        }
    }
}
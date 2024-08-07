package com.suike.suikerawore.expand;

import java.util.List;
import java.util.ArrayList;

import com.suike.suikerawore.SuiKe;
import com.suike.suikerawore.config.ConfigValue;
import com.suike.suikerawore.expand.ConflictScreen;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

//检查是否拥有联动模组模组
public class Examine {

    public static Object suikerawore_conflict;//冲突监听器

    public static boolean TCID = false;//匠魂
    public static boolean IC2ID = false;//工业
    public static boolean tetraID = false;//tetra
    public static boolean FuturemcID = false;//未来MC
    public static boolean MekanismID = false;//通用机械
    public static boolean thaumcraftID = false;//神秘时代
    public static boolean TheAurorianID = false;//极光幽境
    public static boolean GalacticraftID = false;//星系
    public static boolean TheBetweenlandsID = false;//交错次元

    public static boolean smelt = false;//自动熔炼

    //检查是否拥有模组
    public static void examine() {
        /*工业*/if (Loader.isModLoaded("ic2")) {IC2ID = true;}
        /*tetra*/if (Loader.isModLoaded("tetra")) {tetraID = true;}
        /*未来MC*/if (Loader.isModLoaded("futuremc")) {FuturemcID = true;}
        /*通用机械*/if (Loader.isModLoaded("mekanism")) {MekanismID = true;}
        /*神秘时代*/if (Loader.isModLoaded("thaumcraft")) {thaumcraftID = true;}
        /*极光幽境*/if (Loader.isModLoaded("theaurorian")) {TheAurorianID = true;}
        /*星系*/if (Loader.isModLoaded("galacticraftplanets")) {GalacticraftID = true;}
        /*交错次元*/if (Loader.isModLoaded("thebetweenlands")) {TheBetweenlandsID = true;}
        /*CoFH核心*/if (Loader.isModLoaded("cofhcore")) {smelt = true;}

        //匠魂
        if (Loader.isModLoaded("tconstruct")) {
            TCID = true;
            smelt = true;
        }

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

    static class Conflict {
    //事件监听器
        @SubscribeEvent
        public void onClientTick(TickEvent.ClientTickEvent event) {
            if (event.phase == TickEvent.Phase.START) {
                ConflictScreen.conflict();
            }
        }
    }
}
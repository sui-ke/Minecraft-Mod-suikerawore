package suike.suikerawore.expand;

import suike.suikerawore.SuiKe;

//联动
import suike.suikerawore.expand.ic2.IC2;//工业2
//import suike.suikerawore.expand.ic2upgrade.ic2Upgrade;//工业升级
//import suike.suikerawore.expand.jer.JERExpand;//jer
import suike.suikerawore.expand.enderio.EnderioExpand;//末影接口
import suike.suikerawore.expand.mekanism.MekanismExpand;//通用机械
import suike.suikerawore.expand.densemetals.DenseMetals;//致密矿石
import suike.suikerawore.expand.tconstruct.TconstructExpand;//匠魂2
import suike.suikerawore.expand.thaumcraft.ThaumcraftExpand;//神秘时代
import suike.suikerawore.expand.vicswarfare.VicSWarfareExpand;//维克的现代战争
import suike.suikerawore.expand.galacticraft.GalacticraftExpand;//星系
import suike.suikerawore.expand.galaxyspace.GalaxySpaceExpand;//星空
import suike.suikerawore.expand.myagriculture.MyAgricultureExpand;//神秘农业
import suike.suikerawore.expand.thermalexpansion.ThermalExpansionExpand;//热力膨胀5

import suike.suikerawore.monitor.dropmonitor.drop.SmeltDrop;//自动熔炼

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ModContainer;

public class Expand {
    //执行联动
    public static void expand() {
        /*工业*/if (Loader.isModLoaded("ic2")) {IC2.expand();}
        //*工业升级*/if (Examine.IC2UpgradeID) {ic2Upgrade.expand();}
        /*末影接口*/if (Loader.isModLoaded("enderio")) {EnderioExpand.expand();}
        /*富集矿石*/if (Loader.isModLoaded("densemetals")) {DenseMetals.expand();}
        /*通用机械*/if (Loader.isModLoaded("mekanism")) {MekanismExpand.expand();}
        /*匠魂2*/if (Loader.isModLoaded("tconstruct")) {TconstructExpand.expand();}
        /*神秘时代*/if (Loader.isModLoaded("thaumcraft")) {ThaumcraftExpand.expand();}
        /*神秘农业*/if (Loader.isModLoaded("mysticalagriculture")) {MyAgricultureExpand.expand();}
        /*热力膨胀5*/if (Loader.isModLoaded("thermalexpansion")) {ThermalExpansionExpand.expand();}
        //*jer*/if (Loader.isModLoaded("jeresources")) {JERExpand.addDrop();}

        //星系
        if (Loader.isModLoaded("galacticraftplanets")) {
            GalacticraftExpand.expand();
            //星空
            if (Loader.isModLoaded("galaxyspace")) {
                GalaxySpaceExpand.expand();
            }
        }

        //维克的现代战争
        if (Loader.isModLoaded("mw")) {
            VicSWarfareExpand.expand();
        }

        /*自动熔炼*/if (Examine.smelt) {SmeltDrop.addSmelt();}
    }
}
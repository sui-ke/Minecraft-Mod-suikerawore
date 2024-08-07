package com.suike.suikerawore.expand;

import com.suike.suikerawore.SuiKe;

//联动
import com.suike.suikerawore.expand.ic.IC;//工业2
import com.suike.suikerawore.expand.futuremc.FutureMC;//未来MC
import com.suike.suikerawore.expand.enderio.EnderioExpand;//末影接口
import com.suike.suikerawore.expand.mekanism.MekanismExpand;//通用机械
import com.suike.suikerawore.expand.densemetals.DenseMetals;//致密矿石
import com.suike.suikerawore.expand.tconstruct.TconstructExpand;//匠魂2
import com.suike.suikerawore.expand.galacticraft.GalacticraftExpand;//星系
import com.suike.suikerawore.expand.galaxyspace.GalaxySpaceExpand;//星空
import com.suike.suikerawore.expand.myagriculture.MyAgricultureExpand;//神秘农业
import com.suike.suikerawore.expand.thaumcraft.ThaumcraftExpand;//神秘时代

import com.suike.suikerawore.monitor.dropmonitor.drop.SmeltDrop;//自动熔炼

import net.minecraftforge.fml.common.Loader;

public class Expand {
    //执行联动
    public static void expand() {
        //未来MC
        if (Loader.isModLoaded("futuremc")) {
            FutureMC.expand();
        }

        //工业
        if (Loader.isModLoaded("ic2")) {
            IC.expand();
        }

        //星系
        if (Loader.isModLoaded("galacticraftplanets")) {
            GalacticraftExpand.expand();
            //星空
            if (Loader.isModLoaded("galaxyspace")) {
                GalaxySpaceExpand.expand();
            }
        }

        //通用机械
        if (Loader.isModLoaded("mekanism")) {
            MekanismExpand.expand();
        }

        //末影接口
        if (Loader.isModLoaded("enderio")) {
            EnderioExpand.expand();
        }

        //匠魂
        if (Loader.isModLoaded("tconstruct")) {
            TconstructExpand.expand();
        }

        //神秘农业
        if (Loader.isModLoaded("mysticalagriculture")) {
            MyAgricultureExpand.expand();
        }

        //富集矿石
        if (Loader.isModLoaded("densemetals")) {
            DenseMetals.expand();
        }

        //神秘时代
        if (Loader.isModLoaded("thaumcraft")) {
            ThaumcraftExpand.expand();
        }

        //自动熔炼
        if (Examine.smelt) {
            SmeltDrop.addSmelt();
        }
    }
}
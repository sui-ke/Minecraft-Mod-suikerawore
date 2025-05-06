package suike.suikerawore.expand;

import suike.suikerawore.SuiKe;

//联动
import suike.suikerawore.expand.ic2.IC2; // 工业2
import suike.suikerawore.expand.jer.JERExpand; // jer
import suike.suikerawore.expand.sakura.SakuraExpand; // 樱
import suike.suikerawore.expand.enderio.EnderioExpand; // 末影接口
import suike.suikerawore.expand.techguns.TechgunsExpand; // 科技枪
import suike.suikerawore.expand.mekanism.MekanismExpand; // 通用机械
import suike.suikerawore.expand.tconstruct.TconstructExpand; // 匠魂2
import suike.suikerawore.expand.thaumcraft.ThaumcraftExpand; // 神秘时代
import suike.suikerawore.expand.vicswarfare.VicSWarfareExpand; // 维克的现代战争
import suike.suikerawore.expand.galacticraft.GalacticraftExpand; // 星系
import suike.suikerawore.expand.galaxyspace.GalaxySpaceExpand; // 星空
import suike.suikerawore.expand.myagriculture.MyAgricultureExpand; // 神秘农业
import suike.suikerawore.expand.thermalexpansion.ThermalExpansionExpand; // 热力膨胀5
import suike.suikerawore.expand.gregtech.GregtechExpand; // 格雷科技

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ModContainer;

public class Expand {
    //执行联动
    public static void expand() {
        /*工业2*/if (Loader.isModLoaded("ic2")) {IC2.expand();}
        /*樱*/if (Loader.isModLoaded("sakura")) {SakuraExpand.expand();}
        /*jer*/if (Loader.isModLoaded("jeresources")) {JERExpand.addDrop();}
        /*科技枪*/if (Loader.isModLoaded("techguns")) {TechgunsExpand.expand();}
        /*通用机械*/if (Loader.isModLoaded("mekanism")) {MekanismExpand.expand();}
        /*匠魂2*/if (Loader.isModLoaded("tconstruct")) {TconstructExpand.expand();}
        /*神秘农业*/if (Loader.isModLoaded("mysticalagriculture")) {MyAgricultureExpand.expand();}
        /*热力膨胀5*/if (Loader.isModLoaded("thermalexpansion")) {ThermalExpansionExpand.expand();}
        /*格雷科技*/if (Loader.isModLoaded("gregtech")) {GregtechExpand.expand();}
        /*维克的现代战争*/if (Loader.isModLoaded("mw")) {VicSWarfareExpand.expand();}

        //星系
        if (Loader.isModLoaded("galacticraftplanets")) {
            GalacticraftExpand.expand();
            //星空
            if (Loader.isModLoaded("galaxyspace")) {
                GalaxySpaceExpand.expand();
            }
        }

        //末影接口
        if (Loader.isModLoaded("enderio")) {
            ModContainer targetMod = Loader.instance().getModList().stream()
                .filter(mod -> mod.getModId().equals("enderio"))
                .findFirst().orElse(null);

            if (targetMod != null) {
                int version = Integer.parseInt(targetMod.getVersion().replaceAll("[^0-9]", ""));
                EnderioExpand.oldVersion = (version <= 5094);
                EnderioExpand.expand();
            }
        }
    }
}
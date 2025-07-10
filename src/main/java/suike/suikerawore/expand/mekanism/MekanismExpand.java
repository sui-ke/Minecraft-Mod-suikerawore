package suike.suikerawore.expand.mekanism;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;

import net.minecraftforge.fml.common.Optional;
import net.minecraftforge.event.world.BlockEvent;

//通用机械
public class MekanismExpand {
    // 用于存储版本类型: true=社区版, false=官方版, null=不支持
    private static Boolean isUnofficialVersion = null;

    public static void expand() {
        /*粉碎机配方*/CrusherRecipe.register();
        /*富集仓配方*/EnrichmentChamberRecipe.register();
        /*净化仓配方*/PurificationChamberRecipe.register();
        /*冶金灌注机配方*/MetallurgicInfuserRecipe.register();
        /*化学压射室配方*/ChemicalInjectionChamberRecipe.register();
        /*化学溶解室配方*/ChemicalDissolutionChamberRecipe.register();

        try {
            Class.forName("mekanism.common.tile.machine.TileEntityDigitalMiner");
            isUnofficialVersion = true; // 社区版路径存在
        } catch (ClassNotFoundException e1) {
            try {
                Class.forName("mekanism.common.tile.TileEntityDigitalMiner");
                isUnofficialVersion = false; // 官方版路径存在
            } catch (ClassNotFoundException e2) {
                isUnofficialVersion = null; // 两个路径都不存在
            }
        }
    }

    // 检查数字采矿机精准采集
    public static boolean isMek(BlockEvent.HarvestDropsEvent event) {
        if (isUnofficialVersion == null) return false;

        Entity harvester = event.getHarvester();
        BlockPos pos = new BlockPos(harvester.posX, harvester.posY, harvester.posZ);

        if (harvester.world.isBlockLoaded(pos)) {
            TileEntity tile = harvester.world.getTileEntity(pos);
            if (tile == null) return false;

            String classPackage = tile.getClass().toString();
            if (!classPackage.endsWith(".TileEntityDigitalMiner")) return false;

            if (isUnofficialVersion) {
                return isMekUnofficial(tile); // 社区版
            } else {
                return isMekOfficial(tile); // 官方版
            }
        }

        return false;
    }

    // 官方版
    private static boolean isMekOfficial(TileEntity tile) {
        mekanism.common.tile.TileEntityDigitalMiner digitalMiner = (mekanism.common.tile.TileEntityDigitalMiner) tile;
        return digitalMiner.silkTouch;
    }

    // 社区版
    private static boolean isMekUnofficial(TileEntity tile) {
        mekanism.common.tile.machine.TileEntityDigitalMiner digitalMiner = (mekanism.common.tile.machine.TileEntityDigitalMiner) tile;
        return digitalMiner.silkTouch;
    }
}
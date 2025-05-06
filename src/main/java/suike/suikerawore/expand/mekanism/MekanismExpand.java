package suike.suikerawore.expand.mekanism;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;

import mekanism.common.tile.TileEntityDigitalMiner;

import net.minecraftforge.fml.common.Optional;
import net.minecraftforge.event.world.BlockEvent;

//通用机械
public class MekanismExpand {
    public static void expand() {
        /*粉碎机配方*/CrusherRecipe.register();
        /*富集仓配方*/EnrichmentChamberRecipe.register();
        /*净化仓配方*/PurificationChamberRecipe.register();
        /*冶金灌注机配方*/MetallurgicInfuserRecipe.register();
        /*化学压射室配方*/ChemicalInjectionChamberRecipe.register();
        /*化学溶解室配方*/ChemicalDissolutionChamberRecipe.register();
    }

    // 检查数字采矿机精准采集
    @Optional.Method(modid = "mekanism")
    public static boolean isMek(BlockEvent.HarvestDropsEvent event) {
        boolean isSilkTouch = false;
        Entity harvester = event.getHarvester();

        BlockPos pos = new BlockPos(harvester.posX, harvester.posY, harvester.posZ);
        if (harvester.world.isBlockLoaded(pos)) {
            TileEntity tile = harvester.world.getTileEntity(pos);
            TileEntityDigitalMiner digitalMiner = (TileEntityDigitalMiner) tile;
            isSilkTouch = digitalMiner.silkTouch;
        }

        return isSilkTouch;
    }
}
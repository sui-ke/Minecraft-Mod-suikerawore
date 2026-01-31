package suike.suikerawore.expand.mekanism;

import suike.suikerawore.item.*;
import suike.suikerawore.expand.ExpandMod;
import suike.suikerawore.config.ConfigValue;

import mekanism.api.gas.GasRegistry;
import mekanism.common.recipe.RecipeHandler;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;

// 通用机械
public class MekanismExpand extends ExpandMod {

    @Override
    protected String value() {
        return "mekanism";
    }

    @Override
    protected void expandOnce() {
        /*冶金灌注机配方*/MetallurgicInfuserRecipe.registerRecipe();
        /*化学溶解室配方*/ChemicalDissolutionRecipe.registerRecipe();
    }

    @Override
    protected void expand(ModItemRawOre rawOre) {
        ItemStack rawOreStack = new ItemStack(rawOre);
        // 粗矿配方
        registerRecipe("Enrichment", rawOreStack.copy(), getCrusherRecipe("dust", rawOre, ConfigValue.EnrichmentOutputAmount));                       // 富集仓-粗矿>粉
        registerRecipe("Purification", rawOreStack.copy(), getCrusherRecipe("clump", rawOre, ConfigValue.PurificationOutputAmount));                  // 净化仓-粗矿>碎块
        registerRecipe("ChemicalInjection", rawOreStack.copy(), getCrusherRecipe("shard", rawOre, ConfigValue.ChemicalInjectionChamberOutputAmount)); // 化学压射室-粗矿>碎片

        // 锭配方
        ItemStack refined = rawOre.getRefinedItemStack();
        registerRecipe("Crusher", refined.copy(), getCrusherRecipe("dust", rawOre, 1)); // 粉碎机-锭>粉
    }

// 粉碎机配方注册
    private ItemStack getCrusherRecipe(String prefix, ModItemRawOre rawOre, int outputAmount) {
        ItemStack outputStack = ItemBase.oreStack(prefix + rawOre.getElementType());
        outputStack.setCount(outputAmount);
        return outputStack;
    }

// 配方注册
    private void registerRecipe(String machine, ItemStack inputStack, ItemStack outputStack) {
        if (ItemBase.isValidItemStack(inputStack, outputStack)) {
            switch (machine) {
                case "Crusher": // 粉碎机
                    RecipeHandler.addCrusherRecipe(inputStack, outputStack);
                    break;
                case "Enrichment": // 富集仓
                    RecipeHandler.addEnrichmentChamberRecipe(inputStack, outputStack);
                    break;
                case "Purification": // 净化仓
                    RecipeHandler.addPurificationChamberRecipe(inputStack, outputStack);
                    break;
                case "ChemicalInjection": // 化学压射室
                    RecipeHandler.addChemicalInjectionChamberRecipe(inputStack, GasRegistry.getGas("hydrogenchloride"), outputStack);
                    break;
            }
        }
    }

// 检查数字采矿机精准采集
    // 用于存储版本类型: true=社区版, false=官方版, null=不支持
    private static Boolean isOfficialVersion = isOfficialVersion();

    private static Boolean isOfficialVersion() {
        try {
            Class.forName("mekanism.common.tile.TileEntityDigitalMiner");
            return true; // 官方版路径存在
        } catch (ClassNotFoundException e1) {
            try {
                Class.forName("mekanism.common.tile.machine.TileEntityDigitalMiner");
                return false; // 社区版路径存在
            } catch (ClassNotFoundException e2) {
                return null; // 两个路径都不存在
            }
        }
    }

    public static boolean isMek(Entity harvester) {
        if (isOfficialVersion == null || harvester == null) return false;

        BlockPos pos = new BlockPos(harvester.posX, harvester.posY, harvester.posZ);
        if (harvester.world.isBlockLoaded(pos)) {
            TileEntity tile = harvester.world.getTileEntity(pos);
            if (tile != null) {
                if (isOfficialVersion) {
                    return isMekOfficial(tile);
                } else {
                    return isMekUnofficial(tile);
                }
            }
        }

        return false;
    }

    // 官方版
    private static boolean isMekOfficial(TileEntity tile) {
        return ((mekanism.common.tile.TileEntityDigitalMiner) tile).silkTouch;
    }

    // 社区版
    private static boolean isMekUnofficial(TileEntity tile) {
        return ((mekanism.common.tile.machine.TileEntityDigitalMiner) tile).silkTouch;
    }
}
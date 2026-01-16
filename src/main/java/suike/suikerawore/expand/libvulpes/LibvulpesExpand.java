package suike.suikerawore.expand.libvulpes;

import java.util.*;

import suike.suikerawore.SuiKe;
import suike.suikerawore.item.*;
import suike.suikerawore.expand.ExpandMod;

import zmaster587.libVulpes.recipe.RecipesMachine;
import zmaster587.advancedRocketry.block.BlockSmallPlatePress;
import zmaster587.advancedRocketry.tile.multiblock.machine.*;

import net.minecraft.item.ItemStack;

import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidRegistry;

// 高级火箭
public class LibvulpesExpand extends ExpandMod {

    private RecipesMachine machine;

    @Override
    protected String value() {
        return "advancedrocketry";
    }

    @Override
    protected void init() {
        this.machine = RecipesMachine.getInstance();
    }

    @Override
    protected void expandOnce() {
        // 注册电弧高炉配方
        ItemStack titanium = ItemBase.RAW_TITANIUM.getRefinedItemStack();
        this.machine.addRecipe(TileElectricArcFurnace.class, ItemBase.oreStack("ingotTitaniumIridium", 2), 3000, 20, titanium, ItemBase.RAW_IRIDIUM.getRefinedItemStack());
        this.machine.addRecipe(TileElectricArcFurnace.class, ItemBase.oreStack("ingotTitaniumAluminide", 3), 9000, 20, titanium, ItemBase.RAW_ALUMINIUM.getRefinedItemStack());
    }

    @Override
    protected void expand(ModItemRawOre rawOre) {
        this.registerRecipe(TileRollingMachine.class, rawOre.getRefinedItemStack(), "plate", rawOre.getElementType(), 1);
        this.registerRecipe(BlockSmallPlatePress.class, rawOre.getCompressBlock().getRefinedItemStack(), "plate", rawOre.getElementType(), 4);
        this.registerRecipe(TileLathe.class, rawOre.getRefinedItemStack(), "stick", rawOre.getElementType(), 2);
    }

// 注册 卷板机 & 机床 配方
    private void registerRecipe(Class clazz, ItemStack inputStack, String outputType, String elementType, int amount) {
        ItemStack outputStack = ItemBase.oreStack(outputType + elementType, amount);

        if (ItemBase.isValidItemStack(inputStack, outputStack)) {
            List<Object> inputs = new ArrayList<>();
            inputs.add(inputStack);
            if ("plate".equals(outputType)) {
                inputs.add(new FluidStack(FluidRegistry.WATER, 100));
            }
            this.machine.addRecipe(clazz, outputStack, 300, 20, inputs.toArray(new Object[0]));
        }
    }
}
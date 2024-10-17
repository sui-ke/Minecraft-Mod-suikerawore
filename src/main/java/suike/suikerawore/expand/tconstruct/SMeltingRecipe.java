package suike.suikerawore.expand.tconstruct;

import java.lang.reflect.Field;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.smeltery.MeltingRecipe;
import knightminer.tcomplement.library.TCompRegistry;

public class SMeltingRecipe extends MeltingRecipe {
    public SMeltingRecipe(ItemStack inputStack, Fluid fluid, int amount) {
        super(RecipeMatch.of(inputStack), new FluidStack(fluid, amount * 2), fluid.getTemperature());

        try {
            /*获取output字段*/Field output = MeltingRecipe.class.getDeclaredField("output");
            /*设置可访问性*/output.setAccessible(true);
            /*修改output字段*/output.set(this, new FluidStack(fluid, amount * 2));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void register(ItemStack inputStack, Fluid fluid, int amount) {
        /*匠魂补充-高炉配方*/TCompRegistry.registerHighOvenOverride(new SMeltingRecipe(inputStack, fluid, amount));
    }
}
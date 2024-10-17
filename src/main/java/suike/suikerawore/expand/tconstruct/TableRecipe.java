package suike.suikerawore.expand.tconstruct;

import suike.suikerawore.item.ItemBase;

import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

//浇筑台配方
public class TableRecipe {
    public static void register() {
        register("copper", ItemBase.INGOT_COPPER, false);//铜
        register("tin", ItemBase.INGOT_TIN, false);//锡
        register("zinc", ItemBase.INGOT_ZINC, false);//锌
        register("lead", ItemBase.INGOT_LEAD, false);//铅
        register("silver", ItemBase.INGOT_SILVER, false);//银
        register("cobalt", ItemBase.INGOT_COBALT, false);//钴
        register("nickel", ItemBase.INGOT_NICKEL, false);//镍
        register("liquidgallium", ItemBase.INGOT_GALLIUM, false);//镓
        register("aluminum", ItemBase.INGOT_ALUMINIUM, false);//铝
        register("aluminum", ItemBase.NUGGET_ALUMINIUM, true);//铝粒
    }

//配方注册
    public static void register(String string, Item item, boolean isNugget) {
        ItemStack itemStack = new ItemStack(item);
        ItemStack cast = TinkerSmeltery.castIngot;
        Fluid fluid = FluidRegistry.getFluid(string);
        int amount = 144;

        if (isNugget) {
            cast = TinkerSmeltery.castNugget;
            amount = 16;
        }

        if (fluid != null) {
            TinkerRegistry.registerTableCasting(itemStack, cast, fluid, amount);
        }
    }
}
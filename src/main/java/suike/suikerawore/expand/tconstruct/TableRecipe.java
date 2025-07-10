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
        register("copper", ItemBase.INGOT_COPPER);//铜
        register("tin", ItemBase.INGOT_TIN);//锡
        register("zinc", ItemBase.INGOT_ZINC);//锌
        register("lead", ItemBase.INGOT_LEAD);//铅
        register("silver", ItemBase.INGOT_SILVER);//银
        register("cobalt", ItemBase.INGOT_COBALT);//钴
        register("nickel", ItemBase.INGOT_NICKEL);//镍
        register("liquidgallium", ItemBase.INGOT_GALLIUM);//镓
        register("aluminum", ItemBase.INGOT_ALUMINIUM);//铝
    }

//配方注册
    public static void register(String string, Item item) {
        ItemStack itemStack = new ItemStack(item);
        ItemStack cast = TinkerSmeltery.castIngot;
        Fluid fluid = FluidRegistry.getFluid(string);

        if (ItemBase.isValidItemStack(itemStack, cast) && fluid != null) {
            TinkerRegistry.registerTableCasting(itemStack, cast, fluid, 144);
        }
    }
}
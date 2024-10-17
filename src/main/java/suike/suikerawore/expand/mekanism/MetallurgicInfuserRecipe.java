package suike.suikerawore.expand.mekanism;

import suike.suikerawore.item.ItemBase;

import mekanism.api.infuse.InfuseType;
import mekanism.api.infuse.InfuseRegistry;
import mekanism.common.recipe.RecipeHandler;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

//冶金灌注机配方
public class MetallurgicInfuserRecipe {
    public static void register() {
        InfuseType infuseType = InfuseRegistry.get("REDSTONE");
        register(//电路板
            new ItemStack(ItemBase.INGOT_OSMIUM),
            new ItemStack(Item.getByNameOrId("mekanism:controlcircuit"), 1, 0),
            infuseType,
            10
        );

        infuseType = InfuseRegistry.get("TIN");
        register(//青铜锭
            new ItemStack(ItemBase.INGOT_COPPER),
            new ItemStack(Item.getByNameOrId("mekanism:ingot"), 4, 2),
            infuseType,
            10
        );
    }

//配方注册
    public static void register(ItemStack input, ItemStack output, InfuseType infuse, int amount) {
        RecipeHandler.addMetallurgicInfuserRecipe(infuse, amount, input, output);
    }
}
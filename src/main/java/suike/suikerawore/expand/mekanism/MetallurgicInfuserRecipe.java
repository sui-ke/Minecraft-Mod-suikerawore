package suike.suikerawore.expand.mekanism;

import suike.suikerawore.item.ItemBase;

import mekanism.api.infuse.InfuseType;
import mekanism.api.infuse.InfuseRegistry;
import mekanism.common.recipe.RecipeHandler;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

// 冶金灌注机配方
public class MetallurgicInfuserRecipe {
    public static void registerRecipe() {
        InfuseType infuseType = InfuseRegistry.get("TIN");
        register(// 青铜锭
            ItemBase.RAW_GOLD.getRefinedItemStack(3),
            new ItemStack(Item.getByNameOrId("mekanism:ingot"), 4, 2),
            infuseType,
            10
        );

        infuseType = InfuseRegistry.get("REDSTONE");
        register(// 电路板
            ItemBase.RAW_OSMIUM.getRefinedItemStack(),
            new ItemStack(Item.getByNameOrId("mekanism:controlcircuit"), 1, 0),
            infuseType,
            10
        );
    }

//配方注册
    private static void register(ItemStack inputStack, ItemStack outputStack, InfuseType infuse, int amount) {
        if (ItemBase.isValidItemStack(inputStack, outputStack)) {
            RecipeHandler.addMetallurgicInfuserRecipe(infuse, amount, inputStack, outputStack);
        }
    }
}
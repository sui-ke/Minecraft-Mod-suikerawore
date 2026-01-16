package suike.suikerawore.expand.ic2;

import java.util.*;

import suike.suikerawore.item.*;
import suike.suikerawore.config.ConfigValue;

import ic2.api.recipe.Recipes;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraftforge.fml.common.Loader;

// 打粉机配方
public class MaceratorRecipe {

    private String prefix; // 矿词前缀
    private boolean iridiumsourceID; // 铱矿产

    public MaceratorRecipe() {
        this.iridiumsourceID = Loader.isModLoaded("iridiumsource");
        // 非经典版 或 有拓展
        boolean hasCrushed = !Loader.isModLoaded("ic2-classic-spmod") || Loader.isModLoaded("ic2c_extras");
        this.prefix = hasCrushed ? "crushed" : "dust";
    }

    public void registerRecipeOnce() {
        if (this.iridiumsourceID) {
            /*铂颗粒*/this.register(ItemBase.RAW_PLATINUM, "prillPlatinum");
            /*铂碎块*/this.register(Item.getByNameOrId("iridiumsource:prill_platina"), "Platinum");
        } else {
            /*铂碎块*/this.register(ItemBase.RAW_PLATINUM, "Platinum");
        }
    }

    public void registerRecipe(ModItemRawOre rawOre) {
        if (rawOre != ItemBase.RAW_PLATINUM) {
            this.register(rawOre, rawOre.getElementType());
        }
        this.register(rawOre.getRefinedItemStack(), "dust" + rawOre.getElementType());
    }

//配方注册
    private void register(Item input, String oreDict) {
        if (input == null) return;
        this.register(new ItemStack(input), oreDict);
    }
    private void register(ItemStack input, String oreDict) {
        if (Character.isUpperCase(oreDict.charAt(0))) {
            oreDict = this.prefix + oreDict;
        }

        int amount = 1;
        if (input.getItem() instanceof ModItemRawOre) {
            amount = ConfigValue.maceratorRawOutputAmount;
        }

        ItemStack output = ItemBase.oreStack(oreDict, amount);

        this.register(input, output);
    }

    private void register(ItemStack input, ItemStack output) {
        if (ItemBase.isValidItemStack(input, output)) {
            Recipes.macerator.addRecipe(Recipes.inputFactory.forStack(input), null, false, output);
        }
    }
}
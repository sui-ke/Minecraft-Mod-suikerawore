package suike.suikerawore.recipe;

import java.util.*;

import suike.suikerawore.item.*;
import suike.suikerawore.config.ConfigValue;

public class Recipe {
    public static void register() {
        // 删除工作台 & 熔炉 & 高炉配方配方
        new RemoveIngotRecipe().remove();

        FurnaceRecipe furnaceRecipe = new FurnaceRecipe();
        CompressResolveRecipe compressResolveRecipe = new CompressResolveRecipe();

        for (Map.Entry<String, ModItemRawOre> mapEntry : ModItemRawOre.TYPE_TO_RAW_ORE.entrySet()) {
            ModItemRawOre rawOre = mapEntry.getValue();
            if (rawOre.isValid()) {
                furnaceRecipe.registryRecipe(rawOre);
                compressResolveRecipe.registryRecipe(rawOre);
            }
        }
    }
}
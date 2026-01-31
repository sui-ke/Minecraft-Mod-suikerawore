package suike.suikerawore.expand.thermalexpansion;

import suike.suikerawore.item.*;
import suike.suikerawore.config.ConfigValue;

import cofh.thermalexpansion.util.managers.machine.PulverizerManager;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraftforge.oredict.OreDictionary;

// 磨粉机配方
public class PulverizerRecipe {
    public static void register(ModItemRawOre rawOre) {
        register(new ItemStack(rawOre), rawOre.getByProductData().getProducts(), ConfigValue.PulverizerOutputAmount);
        register(rawOre.getRefinedItemStack(), new String[]{"dust" + rawOre.getElementType()}, 1);
    }

// 配方注册
    private static void register(ItemStack input, String[] outputOreDict, int amount) {
        /*主输出物*/ItemStack outputStack = ItemBase.oreStack(outputOreDict[0], amount);
        /*副输出物*/ItemStack secondaryOutputStack = ItemBase.oreStack(outputOreDict.length < 2 ? outputOreDict[0] : outputOreDict[1], ConfigValue.PulverizerSecondaryOutputAmount);

        if (ItemBase.isValidItemStack(input, outputStack)) {
            /*注册配方*/PulverizerManager.addRecipe(4000, input, outputStack, secondaryOutputStack, 10);
        }
    }
}
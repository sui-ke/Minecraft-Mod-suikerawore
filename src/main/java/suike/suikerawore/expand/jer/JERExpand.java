package suike.suikerawore.expand.jer;

import suike.suikerawore.item.*;
import suike.suikerawore.expand.ExpandMod;
import suike.suikerawore.config.ConfigValue;

import jeresources.api.drop.LootDrop;
import jeresources.compatibility.JERAPI;

import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import net.minecraftforge.oredict.OreDictionary;

public class JERExpand extends ExpandMod {

    @Override
    protected String value() {
        return "jer";
    }

    @Override
    protected void expand(ModItemRawOre rawOre) {
        addDrop(OreDictionary.getOres("ore" + rawOre.getElementType()), new ItemStack(rawOre));
    }

    private void addDrop(NonNullList<ItemStack> ores, ItemStack dropStack) {
        if (!ores.isEmpty() && !dropStack.isEmpty()) {
            LootDrop drop = new LootDrop(dropStack, ConfigValue.rawOreDropAmount);
            for (ItemStack ore : ores) {
                if (ItemBase.isValidItemStack(ore)) {
                    JERAPI.getInstance().getWorldGenRegistry().registerDrops(ore, drop);
                }
            }
        }
    }
}
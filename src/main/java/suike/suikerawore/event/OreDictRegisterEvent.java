/*
package suike.suikerawore.event;

import suike.suikerawore.item.*;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;

@Mod.EventBusSubscriber
public class OreDictRegisterEvent {
    @SubscribeEvent
    public static void onOreDictRegisterEvent(OreDictionary.OreRegisterEvent event) {
        String oreDict = event.getName();
        ItemStack stack = event.getOre();
        if (oreDict.startsWith("ore") && ItemBase.isValidItemStack(stack) && stack.getItem() instanceof ItemBlock) {
            ModItemRawOre rawOre = ItemBase.getRawOre(oreDict.replace("ore", ""));

            if (rawOre != null && !rawOre.isValid()) {
                rawOre.setValid(true);
            }
        }
    }
}//*/
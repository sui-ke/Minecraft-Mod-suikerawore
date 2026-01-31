package suike.suikerawore.event;

import suike.suikerawore.item.*;
import suike.suikerawore.inter.IItemEntry;

import slimeknights.tconstruct.library.smeltery.CastingRecipe;
import slimeknights.tconstruct.library.smeltery.ICastingRecipe;
import slimeknights.tconstruct.library.events.TinkerRegisterEvent;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CastingRegisterEvent {

    @SubscribeEvent
    public static void onTableRegisterEvent(TinkerRegisterEvent.TableCastingRegisterEvent event) {
        ICastingRecipe recipe = event.getRecipe();
        if (recipe instanceof CastingRecipe && !canRegister((CastingRecipe) recipe, "ingot")) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onBasinRegisterEvent(TinkerRegisterEvent.BasinCastingRegisterEvent event) {
        ICastingRecipe recipe = event.getRecipe();
        if (recipe instanceof CastingRecipe && !canRegister((CastingRecipe) recipe, "block")) {
            event.setCanceled(true);
        }
    }

    private static boolean canRegister(CastingRecipe recipe, String with) {
        String oreDict = ItemBase.getItemOreDict(recipe.getResult(), with); // 按开头获取矿词
        if (!oreDict.isEmpty()) {
            ModItemRawOre rawOre = ItemBase.getRawOre(oreDict.replace(with, "")); // 使用元素类型获取粗矿
            if (rawOre != null) {
                return false;
            }
        }
        return true;
    }
}
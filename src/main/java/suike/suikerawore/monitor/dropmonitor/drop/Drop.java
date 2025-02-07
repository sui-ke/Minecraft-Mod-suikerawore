package suike.suikerawore.monitor.dropmonitor.drop;

import suike.suikerawore.item.ItemBase;
import suike.suikerawore.config.ConfigValue;
import suike.suikerawore.monitor.dropmonitor.BreakingMonitor;
import suike.suikerawore.monitor.dropmonitor.drop.MetalDrop;//通用的矿石掉落
import suike.suikerawore.monitor.dropmonitor.drop.DenseDrop;//致密矿石掉落

import net.minecraft.item.ItemStack;

public class Drop {
    public static void select(ItemStack itemStack, String way) {
        if (ItemBase.isValidItemStack(itemStack)) {
            if (BreakingMonitor.dense) {
            //挖掘致密矿石
                DenseDrop.itemDrop(itemStack, way);

            } else {
            //通用的矿石掉落
                MetalDrop.itemDrop(itemStack, ConfigValue.rawOreDropAmount, way);
            }
        }
    }
}
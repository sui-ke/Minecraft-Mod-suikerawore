package suike.suikerawore.monitor.dropmonitor.drop;

import suike.suikerawore.config.ConfigValue;
import suike.suikerawore.monitor.dropmonitor.BreakingMonitor;
import suike.suikerawore.monitor.dropmonitor.drop.MetalDrop;//通用的矿石掉落
import suike.suikerawore.monitor.dropmonitor.drop.DenseDrop;//致密矿石掉落

import net.minecraft.item.ItemStack;

public class Drop {
    public static void select(ItemStack item, String way) {
        if (BreakingMonitor.dense) {
        //挖掘致密矿石
            DenseDrop.itemDrop(item, way);

        } else {
        //通用的矿石掉落
            MetalDrop.itemDrop(item, ConfigValue.rawOreDropAmount, way);
        }
    }
}
package com.suike.suikerawore.monitor.dropmonitor.drop;

import com.suike.suikerawore.config.ConfigValue;
import com.suike.suikerawore.monitor.dropmonitor.EntityMonitor;
import com.suike.suikerawore.monitor.dropmonitor.drop.MetalDrop;//通用的矿石掉落
import com.suike.suikerawore.monitor.dropmonitor.drop.DenseDrop;//致密矿石掉落

import net.minecraft.item.ItemStack;

public class Drop {
    public static void select(ItemStack item, String way) {
        //从配置文件获取掉落数量
        int amount = ConfigValue.rawOreDropAmount;

        if (EntityMonitor.dense) {
        //挖掘致密矿石
            DenseDrop.itemDrop(item, way);

        } else {
        //通用的矿石掉落
            MetalDrop.itemDrop(item, amount, way);
        }
    }
}
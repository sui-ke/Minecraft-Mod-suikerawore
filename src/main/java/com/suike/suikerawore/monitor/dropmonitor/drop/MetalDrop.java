package com.suike.suikerawore.monitor.dropmonitor.drop;

import com.suike.suikerawore.monitor.dropmonitor.EntityMonitor;
import com.suike.suikerawore.monitor.dropmonitor.ExplosionMonitor;
import com.suike.suikerawore.monitor.dropmonitor.drop.SmeltDrop;//熔炼附魔矿石掉落
import com.suike.suikerawore.monitor.dropmonitor.drop.ThaumcraftDrop;//神秘模组掉落

import net.minecraft.item.ItemStack;

//通用的矿石掉落
public class MetalDrop {
    public static void itemDrop(ItemStack item, int amount, String way) {
        if (way.equals("entity")) {
        //实体挖掘
            //获取时运
            int fortuneLevel = EntityMonitor.fortuneLevel;
            if (fortuneLevel > 0) {
                amount += EntityMonitor.Event.getWorld().rand.nextInt(fortuneLevel + 1);
            }

            if (EntityMonitor.smelt){
            //熔炼附魔镐子
                SmeltDrop.itemDrop(item, amount);
                
            } else {
            //通用的矿石掉落
                //清除并添加新掉落物
                EntityMonitor.Event.getDrops().clear();
                EntityMonitor.Event.getDrops().add(new ItemStack(item.getItem(), amount));
            }

            if (EntityMonitor.tool.equals("thaumcraft")) {
                ThaumcraftDrop.itemDrop(item);
            }
        } else if (way.equals("explosion")) {
        //爆炸掉落
            //清除并添加新掉落物
            ExplosionMonitor.Event.getDrops().clear();
            ExplosionMonitor.Event.getDrops().add(new ItemStack(item.getItem(), amount));
        }
    }
}
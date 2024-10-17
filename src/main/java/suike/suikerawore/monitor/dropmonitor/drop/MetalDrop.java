package suike.suikerawore.monitor.dropmonitor.drop;

import suike.suikerawore.monitor.dropmonitor.BreakingMonitor;
import suike.suikerawore.monitor.dropmonitor.drop.SmeltDrop;//熔炼附魔矿石掉落
import suike.suikerawore.monitor.dropmonitor.drop.ThaumcraftDrop;//神秘模组掉落

import net.minecraft.item.ItemStack;

//通用的矿石掉落
public class MetalDrop {
    public static void itemDrop(ItemStack item, int amount, String way) {
        if (way.equals("entity")) {
        //实体挖掘
            //获取时运
            int fortuneLevel = BreakingMonitor.fortuneLevel;
            if (fortuneLevel > 0) {
                amount += BreakingMonitor.Event.getWorld().rand.nextInt(fortuneLevel + 1);
            }

            if (BreakingMonitor.smelt){
            //熔炼附魔镐子, 将掉落物修改为锭
                SmeltDrop.itemDrop(item, amount);
                
            } else {
            //通用的矿石掉落
                //清除并添加新掉落物
                BreakingMonitor.Event.getDrops().clear();
                BreakingMonitor.Event.getDrops().add(new ItemStack(item.getItem(), amount));
            }

            if (ThaumcraftDrop.refiningLevel > 0) {
            //炽心附魔, 额外掉落矿簇
                ThaumcraftDrop.itemDrop(item);
            }
        } else if (way.equals("explosion")) {
        //爆炸掉落
            //清除并添加新掉落物
            BreakingMonitor.Event.getDrops().clear();
            BreakingMonitor.Event.getDrops().add(new ItemStack(item.getItem(), amount));
        }
    }
}
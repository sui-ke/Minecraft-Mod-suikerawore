package suike.suikerawore.monitor.dropmonitor.drop;

import suike.suikerawore.monitor.dropmonitor.BreakingMonitor;
import suike.suikerawore.monitor.dropmonitor.drop.SmeltDrop;//熔炼附魔矿石掉落
import suike.suikerawore.monitor.dropmonitor.drop.ThaumcraftDrop;//神秘模组掉落

import suike.suikerawore.expand.densemetals.DenseMetals;//致密矿石值类

import net.minecraft.item.ItemStack;

//致密矿石掉落
public class DenseDrop {
    public static void itemDrop(ItemStack item, String way) {
        //从配置文件获取掉落数量
        int amount = DenseMetals.denseOreValue;

        if (way.equals("entity")) {
        //实体挖掘
            //获取时运
            int fortuneLevel = BreakingMonitor.fortuneLevel;
            if (fortuneLevel > 0){
                int newAmount = 0;
                //每个掉落数量分别时运
                for(int i = 1; i <= amount; i++) {
                    int drop = 1;

                    drop += BreakingMonitor.Event.getWorld().rand.nextInt(fortuneLevel);
                    drop += 1;

                    newAmount += drop;
                }

                amount = newAmount;
            }

            //挖掘方式
            if (BreakingMonitor.smelt){
            //熔炼附魔镐子
                SmeltDrop.itemDrop(item, amount);

            } else {
            //致密矿石掉落
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
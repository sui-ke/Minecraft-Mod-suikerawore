package suike.suikerawore.event.dropevent.drop;

import suike.suikerawore.item.ItemBase;
import suike.suikerawore.config.ConfigValue;
import suike.suikerawore.event.dropevent.BreakingEvent;

import net.minecraft.item.ItemStack;

import net.minecraftforge.fml.common.Optional;

public class Drop {
    public static final int rawOreDropAmount = ConfigValue.rawOreDropAmount;
    public static final int denseMultiple = ConfigValue.denseMultiple;

    public static void drop(ItemStack itemStack, String way) {
        if (way.equals("isEntity")) {
            handleEntityDrop(itemStack);
        } else if (way.equals("isExplosion")) {
            handleExplosionDrop(itemStack);
        }
    }

    public static void handleEntityDrop(ItemStack itemStack) {
        int dropAmount = BreakingEvent.dense ? denseMultiple : rawOreDropAmount;

        // 通过时运获取掉落数量
        int fortuneLevel = BreakingEvent.fortuneLevel;
        if (fortuneLevel > 0) {
            if (BreakingEvent.dense) {
                // 致密矿石时运
                int total = 0;
                for (int i = 0; i < denseMultiple; i++) {
                    total += rawOreDropAmount + BreakingEvent.dropsEvent.getWorld().rand.nextInt(fortuneLevel + 1);
                }
            } else {
                // 普通矿石时运
                dropAmount += BreakingEvent.dropsEvent.getWorld().rand.nextInt(fortuneLevel + 1);
            }
        }

        // 生成掉落物
        ItemStack dropStack = BreakingEvent.smelt ? GetSmeltDrop.getSmeltDrop(itemStack, dropAmount) // 掉落锭
                                                  : new ItemStack(itemStack.getItem(), dropAmount); // 掉落粗矿

        // 清除并添加新掉落物
        BreakingEvent.dropsEvent.getDrops().clear();
        BreakingEvent.dropsEvent.getDrops().add(dropStack);

        if (BreakingEvent.refiningLevel > 0) {
            // 炽心附魔, 额外掉落矿簇
            thaumcraftDrop(BreakingEvent.refiningLevel, itemStack);
        }
    }

    public static void handleExplosionDrop(ItemStack dropStack) {
        dropStack.copy().setCount(rawOreDropAmount);

        BreakingEvent.dropsEvent.getDrops().clear();
        BreakingEvent.dropsEvent.getDrops().add(dropStack);
    }

    @Optional.Method(modid = "thaumcraft")
    public static void thaumcraftDrop(int refiningLevel, ItemStack itemStack) {
        ThaumcraftDrop.thaumcraftDrop(BreakingEvent.refiningLevel, itemStack);
    }
}
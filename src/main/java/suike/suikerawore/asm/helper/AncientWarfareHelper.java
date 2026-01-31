package suike.suikerawore.asm.helper;

import java.util.Random;

import suike.suikerawore.item.ItemBase;
import suike.suikerawore.event.dropevent.BreakingEvent;

import net.shadowmage.ancientwarfare.automation.tile.worksite.WorkSiteQuarry;

import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class AncientWarfareHelper {
    private static final Random random = new Random();

    public static NonNullList<ItemStack> applyDrops(WorkSiteQuarry quarry, NonNullList<ItemStack> drops) {
        int fortune = quarry.getFortune();
        NonNullList<ItemStack> newDrops = NonNullList.create();

        for(ItemStack stack : drops) {
            if (stack.getItem() instanceof ItemBase) {
                stack.setCount(1);
                applyFortuneDrops(stack, fortune);
            } else {
                ItemStack newDrop = BreakingEvent.getDrop(stack);
                if (!newDrop.isEmpty()) {
                    stack = newDrop;
                    applyFortuneDrops(stack, fortune);
                }
            }
            newDrops.add(stack);
        }

        return newDrops;
    }

    private static void applyFortuneDrops(ItemStack stack, int fortune) {
        if (fortune > 0) {
            int bonus = random.nextInt(fortune + 1);
            if (bonus > 0) {
                stack.setCount(stack.getCount() + bonus);
            }
        }
    }
}
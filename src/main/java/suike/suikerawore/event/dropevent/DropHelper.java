package suike.suikerawore.event.dropevent;

import java.util.*;

import suike.suikerawore.item.*;
import suike.suikerawore.config.*;
import suike.suikerawore.event.dropevent.BreakingEvent;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Optional;

public class DropHelper {

    public static final DropHelper instance = new DropHelper();
    private static final Random rand = new Random();

    private final int rawOreDropAmount;
    private final int denseMultiple;

    private DropHelper() {
        this.rawOreDropAmount = ConfigValue.rawOreDropAmount;
        this.denseMultiple = Loader.isModLoaded("densemetals") ? Config.getDenseMultiple() : 2;
    }

    public ItemStack initialDrop(boolean isEntity, ItemStack itemStack, int fortuneLevel, boolean isDense, boolean hasSmelt) {
        itemStack = itemStack.copy();
        if (isEntity) {
            return handleEntityDrop(itemStack, fortuneLevel, isDense, hasSmelt);
        } else {
            if (isDense) {
                itemStack.setCount((this.rawOreDropAmount * this.denseMultiple));
            } else {
                itemStack.setCount(this.rawOreDropAmount);
            }
            return itemStack;
        }
    }

    private ItemStack handleEntityDrop(ItemStack itemStack, int fortuneLevel, boolean isDense, boolean hasSmelt) {
        int dropAmount = isDense ? this.denseMultiple : this.rawOreDropAmount;

        // 通过时运获取掉落数量
        if (fortuneLevel > 0) {
            if (isDense) {
                // 富集矿石时运
                for (int i = 0; i < this.denseMultiple; i++) {
                    dropAmount += this.rawOreDropAmount + rand.nextInt(fortuneLevel + 1);
                }
            } else {
                // 普通矿石时运
                dropAmount += rand.nextInt(fortuneLevel + 1);
            }
        }

        // 选择掉落物
        itemStack = hasSmelt ? this.getSmeltDrop(itemStack) : itemStack;
        itemStack.setCount(dropAmount);
        return itemStack;

        // 清除并添加新掉落物
        // BreakingEvent.dropsEvent.getDrops().clear();
        // BreakingEvent.dropsEvent.getDrops().add(itemStack);
        // 炽心附魔, 额外掉落矿簇
        // thaumcraftDrop(itemStack);
    }

    private ItemStack getSmeltDrop(ItemStack stack) {
        Item item = stack.getItem();
        if (item instanceof ModItemRawOre) {
            return ((ModItemRawOre) item).getRefinedItemStack();
        }
        return stack;
    }

    // @Optional.Method(modid = "thaumcraft")
    // private static void thaumcraftDrop(ItemStack itemStack) {
    //     ThaumcraftDrop.thaumcraftDrop(BreakingEvent.refiningLevel, itemStack);
    // }
}
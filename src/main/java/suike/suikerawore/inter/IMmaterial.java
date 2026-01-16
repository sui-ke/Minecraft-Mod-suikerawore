package suike.suikerawore.inter;

import java.util.*;

import suike.suikerawore.item.ItemBase;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import org.apache.commons.lang3.math.NumberUtils;

public interface IMmaterial {

    boolean isValid();

    ItemStack getMainRefined(int amount);
    boolean mainOutputIsValid();

    String getRefinedOreDict();

    String[] getOutputs();
    void setOutputs(String[] outputs);

// 设置注册名成品
    default void setRefinedItem(String refined) {
        this.upRefineds(refined);
    }
    default String upRefineds(String refined) {
        if (!this.isValid() || refined == null || refined.isEmpty()) return "";

        // 使用 | 分开物品和方块的成品
        String[] array = refined.split("\\|");

        List<String> list = new ArrayList<>(Arrays.asList(this.getOutputs()));
        list.add(0, array[0]); // 将新设置的物品放入列表最前面
        this.setOutputs(list.toArray(new String[0]));

        if (array.length == 2) {
            return array[1];
        }
        return "";
    }

// 通过注册名获取成品
    default ItemStack getRefinedFromName() {
        return this.getRefinedFromName(1);
    }
    default ItemStack getRefinedFromName(int amount) {
        for (String output : this.getOutputs()) {
            String[] array = output.split("@"); // 使用 @ 连接注册名和元数据
            Item item = Item.getByNameOrId(array[0]);
            if (item != null) {
                return new ItemStack(item, amount, array.length == 2 ? NumberUtils.toInt(array[1], 0) : 0);
            }
        }
        return ItemStack.EMPTY;
    }

// 成品物的栈堆
    default ItemStack getRefinedItemStack() {
        return this.getRefinedItemStack(1);
    }
    default ItemStack getRefinedItemStack(int amount) {
        if (this.isValid()) {
            // 先检查注册名
            ItemStack item = this.getRefinedFromName(amount);
            if (ItemBase.isValidItemStack(item)) {
                return item;
            }
            // 然后是默认输出物
            if (this.mainOutputIsValid()) {
                return this.getMainRefined(amount);
            }
            // 然后是矿词
            item = ItemBase.oreStack(this.getRefinedOreDict(), amount);
            if (ItemBase.isValidItemStack(item)) {
                return item;
            }
        }
        return ItemStack.EMPTY;
    }
}
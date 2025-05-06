package suike.suikerawore.event.dropmonitor.drop;

import suike.suikerawore.item.ItemBase;

import net.minecraft.item.ItemStack;

public class GetSmeltDrop {
    public static ItemStack getSmeltDrop(ItemStack stack, int amount) {
        // 获取粗矿矿词
        String rawOreDict = ItemBase.getItemOreDict(stack, "raw");
        if (rawOreDict == null) return stack;
        // 获取锭矿词
        String ingotOreDict = rawOreDict.replace("raw", "ingot");
        // 尝试获取带 Raw 后缀的锭物品
        ItemStack smeltDrop = ItemBase.oreStack(ingotOreDict + "Raw", amount);

        if (ItemBase.isValidItemStack(smeltDrop)) {
            return smeltDrop;
        }

        // 物品不存在, 获取无 Raw 后缀矿石
        smeltDrop = ItemBase.oreStack(ingotOreDict, amount);

        // 如果依然不存在返回原掉落物
        return ItemBase.isValidItemStack(smeltDrop) ? smeltDrop : stack;
    }
}
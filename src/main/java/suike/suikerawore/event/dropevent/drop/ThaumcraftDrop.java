package suike.suikerawore.event.dropevent.drop;

import java.util.Map;
import java.util.HashMap;

import suike.suikerawore.item.ItemBase;
import suike.suikerawore.event.dropevent.BreakingEvent;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraftforge.fml.common.Optional;

import com.google.common.collect.ImmutableMap;

// thaumcraft 模组附魔掉落
public class ThaumcraftDrop {
    public static final Item clusterItem = Item.getByNameOrId("thaumcraft:cluster"); // 新增的掉落物名

    private static final Map<Item, Integer> MATERIAL_MAP = ImmutableMap.<Item, Integer>builder()
        .put(ItemBase.RAW_IRON, 0)
        .put(ItemBase.RAW_GOLD, 1)
        .put(ItemBase.RAW_COPPER, 2)
        .put(ItemBase.RAW_TIN, 3)
        .put(ItemBase.RAW_SILVER, 4)
        .put(ItemBase.RAW_LEAD, 5)
        .put(ItemBase.RAW_CINNABAR, 6)
        .build();

    public static void thaumcraftDrop(int refiningLevel, ItemStack itemStack) {
        // 是否炽心
        if (calculateProbability(refiningLevel)) {
            if (MATERIAL_MAP.containsKey(itemStack)) {
                // 新增1~2随机数量
                int amount = BreakingEvent.fortuneLevel > 0 ? (int) (Math.random() * 2 + 1) : 1;
                // 获取矿簇掉落物
                ItemStack clusterStack = new ItemStack(clusterItem, amount, MATERIAL_MAP.get(itemStack.getItem()));
                // 添加新掉落物
                BreakingEvent.dropsEvent.getDrops().add(clusterStack);
            }
        }
    }

    // 炽心概率
    public static boolean calculateProbability(int level) {
        if (level < 1) {return false;}

        int a = (int) (Math.random() * 100);//生成0-99之间的随机数
        int probability = (int) (25 + (level - 1) * 12.5);//计算概率

        return a < probability;
    }
}
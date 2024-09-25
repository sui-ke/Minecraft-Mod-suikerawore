package suike.suikerawore.monitor.dropmonitor.drop;

import java.util.Map;
import java.util.HashMap;

import suike.suikerawore.monitor.dropmonitor.BreakingMonitor;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

//thaumcraft模组镐子掉落
public class ThaumcraftDrop {
    //"掉落物名"及"新增掉落物的元数据"列表
    public static Map<String, Integer> materialMap = new HashMap<>();
    //新增的掉落物名
    public static Item clusterItem = Item.getByNameOrId("thaumcraft:cluster");

    public static int refiningLevel = 0;

    public static void itemDrop(ItemStack item) {
        //检查炽心运是否大于0
        if (refiningLevel > 0) {
            //是否炽心
            if (calculateProbability(refiningLevel)) {
                //获取掉落物名
                String itemName = item.getItem().getRegistryName().toString().replaceAll(".*:", "").trim();

                if (materialMap.containsKey(itemName)) {
                    //新增1~2随机数量
                    int amount = BreakingMonitor.fortuneLevel > 0 ? (int) (Math.random() * 2 + 1) : 1;

                    ItemStack clusterStack = new ItemStack(clusterItem, amount, materialMap.get(itemName));

                    //添加新掉落物
                    BreakingMonitor.Event.getDrops().add(clusterStack);
                }
            }
        }
    }

    //炽心概率
    public static boolean calculateProbability(int level) {
        if (level < 1) {return false;}

        int a = (int) (Math.random() * 100);//生成0-99之间的随机数
        int probability = (int) (25 + (level - 1) * 12.5);//计算概率

        return a < probability;
    }

    //添加掉落物列表
    public static void AddMaterialMap() {
        materialMap.put("raw_gold", 1);
        materialMap.put("raw_iron", 0);
        materialMap.put("raw_copper", 2);
        materialMap.put("raw_tin", 3);
        materialMap.put("raw_lead", 5);
        materialMap.put("raw_silver", 4);
        materialMap.put("raw_cinnabar", 6);
    }
}
package suike.suikerawore.monitor.dropmonitor.drop;

import java.util.Map;
import java.util.HashMap;

import suike.suikerawore.item.ItemBase;
import suike.suikerawore.expand.Examine;
import suike.suikerawore.monitor.dropmonitor.BreakingMonitor;

import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

//熔炼附魔矿石掉落
public class SmeltDrop {
    //原掉落物及熔炼对象
    public static Map<String, ItemStack> AllSmelt = new HashMap<>();

    public static void itemDrop(ItemStack item, int amount) {
        //获取掉落物名
        String itemName = item.getItem().getRegistryName().toString().replaceAll(".*:", "").trim();

        if (AllSmelt.containsKey(itemName)) {

            //获取新的掉落物
            ItemStack newItem = AllSmelt.get(itemName).copy();
            newItem.setCount(amount);

            //清除并添加新掉落物
            BreakingMonitor.Event.getDrops().clear();
            BreakingMonitor.Event.getDrops().add(newItem);
        }
    }

    public static void addSmelt() {
        add("raw_gold", Items.GOLD_INGOT);//金
        add("raw_iron", Items.IRON_INGOT);//铁
        add("raw_copper", ItemBase.INGOT_COPPER);//铜
        add("raw_tin", ItemBase.INGOT_TIN);//锡
        add("raw_zinc", ItemBase.INGOT_ZINC);//锌
        add("raw_lead", ItemBase.INGOT_LEAD);//铅
        add("raw_silver", ItemBase.INGOT_SILVER);//银
        add("raw_cobalt", ItemBase.INGOT_COBALT);//钴
        add("raw_osmium", ItemBase.INGOT_OSMIUM);//锇
        add("raw_nickel", ItemBase.INGOT_NICKEL);//镍
        add("raw_iridium", ItemBase.INGOT_IRIDIUM);//铱
        add("raw_uranium", ItemBase.INGOT_URANIUM);//铀
        add("raw_gallium", ItemBase.INGOT_GALLIUM);//镓
        add("raw_titanium", ItemBase.INGOT_TITANIUM);//钛
        add("raw_platinum", ItemBase.INGOT_PLATINUM);//铂
        add("raw_tungsten", ItemBase.INGOT_TUNGSTEN);//钨
        add("raw_aluminium", ItemBase.INGOT_ALUMINIUM);//铝
        add("raw_magnesium", ItemBase.INGOT_MAGNESIUM);//镁
        add("raw_lithium", ItemBase.INGOT_LITHIUM);//锂
        add("raw_thorium", ItemBase.INGOT_THORIUM);//钍
        add("raw_boron", ItemBase.INGOT_BORON);//硼

        if (Examine.TCID) {//匠魂2
            add("raw_ardite", "tconstruct:ingots", 1);//阿迪特
        }

        if (Examine.TheAurorianID) {//极光幽境
            add("raw_cerulean", "theaurorian:ceruleaningot", 0);//晶蓝
            add("raw_moonstone", "theaurorian:moonstoneingot", 0);//皎月石
        }

        if (Examine.TheBetweenlandsID) {//交错次元
            add("raw_octine", "thebetweenlands:octine_ingot", 0);//炽炎铁
            add("raw_syrmorite", "thebetweenlands:items_misc", 11);//赛摩铜
        }

        if (Examine.TCID) {//神秘时代
            add("raw_cinnabar", "thaumcraft:quicksilver", 0);//朱砂
        }

        if (Examine.TCID) {//软碲铜
            add("raw_vulcanite", "vulcanite:vulcanite_ingot", 0);//软碲铜
        }

        if (Examine.TCID) {//冒险漩涡
            add("raw_chasmium", "mm:chasmium_ingot", 0);//裂金
        }
    }

//添加到列表
    public static void add(String input, Item output) {
        ItemStack outputStack = new ItemStack(output);

        AllSmelt.put(input, outputStack);
    }
    public static void add(String input, String output, int outputMeta) {
        ItemStack outputStack = new ItemStack(Item.getByNameOrId(output), 1, outputMeta);

        AllSmelt.put(input, outputStack);
    }
}
package suike.suikerawore.item;

import java.util.Map;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import suike.suikerawore.SuiKe;
import suike.suikerawore.proxy.*;
import suike.suikerawore.expand.Examine;
import suike.suikerawore.config.ConfigValue;

import mezz.jei.api.JEIPlugin;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;

import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.creativetab.CreativeTabs;

import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

@EventBusSubscriber
public class ItemBase extends Item {
//物品
    public static final List<Item> ITEMS = new ArrayList<>();

    /*金*/public static final ItemBase RAW_GOLD = new ItemBase("raw_gold", true);
    /*铁*/public static final ItemBase RAW_IRON = new ItemBase("raw_iron", true);
    /*铜*/public static final ItemBase RAW_COPPER = new ItemBase("raw_copper", true);
    /*锡*/public static final ItemBase RAW_TIN = new ItemBase("raw_tin", null);
    /*锌*/public static final ItemBase RAW_ZINC = new ItemBase("raw_zinc", null);
    /*铅*/public static final ItemBase RAW_LEAD = new ItemBase("raw_lead", null);
    /*银*/public static final ItemBase RAW_SILVER = new ItemBase("raw_silver", null);
    /*钴*/public static final ItemBase RAW_COBALT = new ItemBase("raw_cobalt", null);
    /*锇*/public static final ItemBase RAW_OSMIUM = new ItemBase("raw_osmium", null);
    /*镍*/public static final ItemBase RAW_NICKEL = new ItemBase("raw_nickel", null);
    /*铱*/public static final ItemBase RAW_IRIDIUM = new ItemBase("raw_iridium", null);
    /*铀*/public static final ItemBase RAW_URANIUM = new ItemBase("raw_uranium", null);
    /*镓*/public static final ItemBase RAW_GALLIUM = new ItemBase("raw_gallium", null);
    /*钛*/public static final ItemBase RAW_TITANIUM = new ItemBase("raw_titanium", null);
    /*铂*/public static final ItemBase RAW_PLATINUM = new ItemBase("raw_platinum", null);
    /*钨*/public static final ItemBase RAW_TUNGSTEN = new ItemBase("raw_tungsten", null);
    /*铝*/public static final ItemBase RAW_ALUMINIUM = new ItemBase("raw_aluminium", null);
    /*镁*/public static final ItemBase RAW_MAGNESIUM = new ItemBase("raw_magnesium", null);
    /*锂*/public static final ItemBase RAW_LITHIUM = new ItemBase("raw_lithium", null);
    /*钍*/public static final ItemBase RAW_THORIUM = new ItemBase("raw_thorium", null);
    /*硼*/public static final ItemBase RAW_BORON = new ItemBase("raw_boron", null);
    /*钒*/public static final ItemBase RAW_VANADIUM = new ItemBase("raw_vanadium", null);
    /*镉*/public static final ItemBase RAW_CADMIUM = new ItemBase("raw_cadmium", null);
    /*锰*/public static final ItemBase RAW_MANGANESE = new ItemBase("raw_manganese", null);
    /*锗*/public static final ItemBase RAW_GERMANIUM = new ItemBase("raw_germanium", null);
    /*铬*/public static final ItemBase RAW_CHROMIUM = new ItemBase("raw_chromium", null);
    /*砷*/public static final ItemBase RAW_ARSENIC = new ItemBase("raw_arsenic", null);

    /*更多粗矿*/
    /*阿迪特*/public static final ItemBase RAW_ARDITE = new ItemBase("raw_ardite", Examine.TCID);
    /* 晶蓝 */public static final ItemBase RAW_CERULEAN = new ItemBase("raw_cerulean", Examine.TheAurorianID);
    /*皎月石*/public static final ItemBase RAW_MOONSTONE = new ItemBase("raw_moonstone", Examine.TheAurorianID);
    /*炽炎铁*/public static final ItemBase RAW_OCTINE = new ItemBase("raw_octine", Examine.TheBetweenlandsID);
    /*赛摩铜*/public static final ItemBase RAW_SYRMORITE = new ItemBase("raw_syrmorite", Examine.TheBetweenlandsID);
    /* 朱砂 */public static final ItemBase RAW_CINNABAR = new ItemBase("raw_cinnabar", Examine.thaumcraftID);
    /*软碲铜*/public static final ItemBase RAW_VULCANITE = new ItemBase("raw_vulcanite", Examine.vulcaniteID);
    /* 裂金 */public static final ItemBase RAW_CHASMIUM = new ItemBase("raw_chasmium", Examine.MaelstromID);
    /*玫瑰金*/public static final ItemBase RAW_ROSEGOLD = new ItemBase("raw_rosegold", Examine.虚拟人生);

    /*锭*/
    /*铜*/public static final ItemBase INGOT_COPPER = new ItemBase("ingot_copper", true);
    /*锡*/public static final ItemBase INGOT_TIN = new ItemBase("ingot_tin", null);
    /*锌*/public static final ItemBase INGOT_ZINC = new ItemBase("ingot_zinc", null);
    /*铅*/public static final ItemBase INGOT_LEAD = new ItemBase("ingot_lead", null);
    /*银*/public static final ItemBase INGOT_SILVER = new ItemBase("ingot_silver", null);
    /*钴*/public static final ItemBase INGOT_COBALT = new ItemBase("ingot_cobalt", null);
    /*锇*/public static final ItemBase INGOT_OSMIUM = new ItemBase("ingot_osmium", null);
    /*镍*/public static final ItemBase INGOT_NICKEL = new ItemBase("ingot_nickel", null);
    /*铱*/public static final ItemBase INGOT_IRIDIUM = new ItemBase("ingot_iridium", null);
    /*铀*/public static final ItemBase INGOT_URANIUM = new ItemBase("ingot_uranium", null);
    /*镓*/public static final ItemBase INGOT_GALLIUM = new ItemBase("ingot_gallium", null);
    /*钛*/public static final ItemBase INGOT_TITANIUM = new ItemBase("ingot_titanium", null);
    /*铂*/public static final ItemBase INGOT_PLATINUM = new ItemBase("ingot_platinum", null);
    /*钨*/public static final ItemBase INGOT_TUNGSTEN = new ItemBase("ingot_tungsten", null);
    /*铝*/public static final ItemBase INGOT_ALUMINIUM = new ItemBase("ingot_aluminium", null);
    /*镁*/public static final ItemBase INGOT_MAGNESIUM = new ItemBase("ingot_magnesium", null);
    /*锂*/public static final ItemBase INGOT_LITHIUM = new ItemBase("ingot_lithium", null);
    /*钍*/public static final ItemBase INGOT_THORIUM = new ItemBase("ingot_thorium", null);
    /*硼*/public static final ItemBase INGOT_BORON = new ItemBase("ingot_boron", null);
    /*钒*/public static final ItemBase INGOT_VANADIUM = new ItemBase("ingot_vanadium", null);
    /*镉*/public static final ItemBase INGOT_CADMIUM = new ItemBase("ingot_cadmium", null);
    /*锰*/public static final ItemBase INGOT_MANGANESE = new ItemBase("ingot_manganese", null);
    /*锗*/public static final ItemBase INGOT_GERMANIUM = new ItemBase("ingot_germanium", null);
    /*铬*/public static final ItemBase INGOT_CHROMIUM = new ItemBase("ingot_chromium", null);
    /*砷*/public static final ItemBase INGOT_ARSENIC = new ItemBase("ingot_arsenic", null);

//构造函数
    public ItemBase(String name, Boolean a) {
        if (是否注册物品(name, a)) {
            /*设置物品名*/setRegistryName(name);
            /*设置物品名key*/setUnlocalizedName(name + "_" + SuiKe.MODID);
            if (ConfigValue.LiteVersion) {
                /*设置创造模式物品栏*/setCreativeTab(CreativeTabs.MATERIALS);
            }

            /*添加到ITEMS列表*/ITEMS.add(this);
        }
    }

//是否注册物品判断方法
    public static boolean 是否注册物品(String name, Boolean a) {
        if (a == null && !ConfigValue.LiteVersion) {
            //未打开精简模式
            for (Map.Entry<String, Boolean> entry : ConfigValue.rawOreList.entrySet()) {
                if (name.toLowerCase().contains(entry.getKey().toLowerCase())) {
                    return entry.getValue();
                }
            }
        }

        return (a != null) ? a : false;
    }

//物品状态
    public boolean oreDictRaw = true;//首次添加矿词Raw

//注册物品
    @SubscribeEvent
    public static void onRegisterItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(ITEMS.toArray(new Item[0]));

        for (Item item : ITEMS) {
            SuiKe.proxy.registerItemRenderer(item);
        }
    }

    /*
    public static void registerItem() {
        ForgeRegistries.ITEMS.registerAll(ITEMS.toArray(new Item[0]));

        for (Item item : ITEMS) {
            SuiKe.proxy.registerItemRenderer(item);
        }
    }
    */

//隐藏物品
    public static List<Item> itemsToRemove = new ArrayList<>();//物品移除列表
    public static void removeItem() {
        for (Item item : ITEMS) {
            /*获取物品名*/String itemName = item.getRegistryName().toString();
            /*用"_"分割物品名*/String[] parts = itemName.split("_");
            /*获取最后一部分*/itemName = parts[parts.length - 1].trim();
            /*通过物品名获取矿词后缀*/String type = itemName.substring(0, 1).toUpperCase() + itemName.substring(1);

            /*矿词前缀*/String[] prefixes = {"ore", "block", "ingot", "dust", "shard", "crushed", "crushedPurified", "cluster"};
            /*是否删除物品*/boolean removeItem = true;

            for (String prefix : prefixes) {
                /*矿词获取ItemStack*/ItemStack oreItemStack = oreStack(prefix + type);
                /*获取ItemStack物品名*/String oreItemStackName = oreItemStack.getItem().getRegistryName().toString();

                if (isValidItemStack(oreItemStack) && !oreItemStackName.startsWith("suikerawore")) {
                    //找到有效的ItemStack
                    removeItem = false;
                    break;
                }
            }

            if (removeItem) {
                /*添加到物品移除列表*/itemsToRemove.add(item);
            }
        }

        /*从物品列表移除物品*/ITEMS.removeAll(itemsToRemove);

        if (!Examine.JEIID) {
            itemsToRemove.clear();
        }
    }
    @JEIPlugin
    public static class rawOreJEIPlugin implements IModPlugin {
        @Override
        public void register(IModRegistry registry) {
            //保存JEI帮助器
            IJeiHelpers jeiHelpers = registry.getJeiHelpers();

            if (jeiHelpers != null) {
                for (Item item : itemsToRemove) {
                    ItemStack itemStack = new ItemStack(item);
                    /*添加到JEI黑名单*/jeiHelpers.getItemBlacklist().addItemToBlacklist(itemStack);
                }
            }

            itemsToRemove.clear();
        }
    }

//矿词获取ItemStack
    public static ItemStack oreStack(String outputOD) {
        return oreStack(outputOD, 1);
    }
    public static ItemStack oreStack(String outputOD, int amount) {
        return oreStack(outputOD, amount, 0);
    }
    public static ItemStack oreStack(String outputOD, int amount, int number) {
        //获取对应的矿词列表
        NonNullList<ItemStack> stackList = OreDictionary.getOres(outputOD);

        if (!stackList.isEmpty() && number < stackList.size()) {
            ItemStack outputStack = stackList.get(number).copy();
            outputStack.setCount(amount);//设置数量

            return outputStack;
        }

        return ItemStack.EMPTY;//返回空的ItemStack
    }

//检查ItemStack
    public static boolean isValidItemStack(ItemStack... itemStackList) {
        for (ItemStack itemStack : itemStackList) {
            String stackString = itemStack.toString().replaceAll("^\\d+x", "");
            if (stackString.matches("item.null@\\d+") ||
                stackString.matches("tile.air@\\d+") ||
                stackString.matches("item.@\\d+") ||
                stackString.matches("tile.@\\d+") ||
                stackString.equals("item.") ||
                stackString.equals("tile.")) 
            {
                return false;//有一个无效, 返回false
            }
        }
        return true;//全部有效, 返回true
    }
}
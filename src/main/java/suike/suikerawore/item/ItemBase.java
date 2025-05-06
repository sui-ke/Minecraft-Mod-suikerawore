package suike.suikerawore.item;

import java.util.Map;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import suike.suikerawore.SuiKe;
import suike.suikerawore.proxy.*;
import suike.suikerawore.expand.Examine;
import suike.suikerawore.config.ConfigValue;
import suike.suikerawore.oredict.OreDict;

import mezz.jei.api.JEIPlugin;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.creativetab.CreativeTabs;

import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class ItemBase extends Item {
//物品
    public static final List<Item> ITEMS = new ArrayList<>();

    /*金*/public static final ItemBase RAW_GOLD = new ItemBase("raw_gold", true);
    /*铁*/public static final ItemBase RAW_IRON = new ItemBase("raw_iron", true);
    /*铜*/public static final ItemBase RAW_COPPER = new ItemBase("raw_copper");
    /*锡*/public static final ItemBase RAW_TIN = new ItemBase("raw_tin");
    /*锌*/public static final ItemBase RAW_ZINC = new ItemBase("raw_zinc");
    /*铅*/public static final ItemBase RAW_LEAD = new ItemBase("raw_lead");
    /*银*/public static final ItemBase RAW_SILVER = new ItemBase("raw_silver");
    /*钴*/public static final ItemBase RAW_COBALT = new ItemBase("raw_cobalt");
    /*锇*/public static final ItemBase RAW_OSMIUM = new ItemBase("raw_osmium");
    /*镍*/public static final ItemBase RAW_NICKEL = new ItemBase("raw_nickel");
    /*铱*/public static final ItemBase RAW_IRIDIUM = new ItemBase("raw_iridium");
    /*铀*/public static final ItemBase RAW_URANIUM = new ItemBase("raw_uranium");
    /*镓*/public static final ItemBase RAW_GALLIUM = new ItemBase("raw_gallium");
    /*钛*/public static final ItemBase RAW_TITANIUM = new ItemBase("raw_titanium");
    /*铂*/public static final ItemBase RAW_PLATINUM = new ItemBase("raw_platinum");
    /*钨*/public static final ItemBase RAW_TUNGSTEN = new ItemBase("raw_tungsten");
    /*铝*/public static final ItemBase RAW_ALUMINIUM = new ItemBase("raw_aluminium");
    /*镁*/public static final ItemBase RAW_MAGNESIUM = new ItemBase("raw_magnesium");
    /*锂*/public static final ItemBase RAW_LITHIUM = new ItemBase("raw_lithium");
    /*钍*/public static final ItemBase RAW_THORIUM = new ItemBase("raw_thorium");
    /*硼*/public static final ItemBase RAW_BORON = new ItemBase("raw_boron");
    /*钒*/public static final ItemBase RAW_VANADIUM = new ItemBase("raw_vanadium");
    /*镉*/public static final ItemBase RAW_CADMIUM = new ItemBase("raw_cadmium");
    /*锰*/public static final ItemBase RAW_MANGANESE = new ItemBase("raw_manganese");
    /*锗*/public static final ItemBase RAW_GERMANIUM = new ItemBase("raw_germanium");
    /*铬*/public static final ItemBase RAW_CHROMIUM = new ItemBase("raw_chromium");
    /*砷*/public static final ItemBase RAW_ARSENIC = new ItemBase("raw_arsenic");
    /*铍*/public static final ItemBase RAW_BERYLLIUM = new ItemBase("raw_beryllium");
    /*镭*/public static final ItemBase RAW_IRRADIUM = new ItemBase("raw_irradium");
    /*钯*/public static final ItemBase RAW_PALLADIUM = new ItemBase("raw_palladium");
    /*钚*/public static final ItemBase RAW_PLUTONIUM = new ItemBase("raw_plutonium");
    /*秘银*/public static final ItemBase RAW_MITHRIL = new ItemBase("raw_mithril");
    /*金红石*/public static final ItemBase RAW_RUTILE = new ItemBase("raw_rutile");

    /*更多粗矿*/
    /*阿迪特*/public static final ItemBase RAW_ARDITE = new ItemBase("raw_ardite", Examine.TCID);
    /* 晶蓝 */public static final ItemBase RAW_CERULEAN = new ItemBase("raw_cerulean", Examine.TheAurorianID);
    /*皎月石*/public static final ItemBase RAW_MOONSTONE = new ItemBase("raw_moonstone", Examine.TheAurorianID);
    /*炽炎铁*/public static final ItemBase RAW_OCTINE = new ItemOctineRaw("raw_octine", Examine.TheBetweenlandsID);
    /*赛摩铜*/public static final ItemBase RAW_SYRMORITE = new ItemBase("raw_syrmorite", Examine.TheBetweenlandsID);
    /* 朱砂 */public static final ItemBase RAW_CINNABAR = new ItemBase("raw_cinnabar", Examine.thaumcraftID);
    /*软碲铜*/public static final ItemBase RAW_VULCANITE = new ItemBase("raw_vulcanite", Examine.vulcaniteID);
    /* 裂金 */public static final ItemBase RAW_CHASMIUM = new ItemBase("raw_chasmium", Examine.MaelstromID);
    /*玫瑰金*/public static final ItemBase RAW_ROSEGOLD = new ItemBase("raw_rosegold", Examine.mcaID);

    /*锭*/
    /*铜*/public static final ItemBase INGOT_COPPER = new ItemBase("ingot_copper");
    /*锡*/public static final ItemBase INGOT_TIN = new ItemBase("ingot_tin");
    /*锌*/public static final ItemBase INGOT_ZINC = new ItemBase("ingot_zinc");
    /*铅*/public static final ItemBase INGOT_LEAD = new ItemBase("ingot_lead");
    /*银*/public static final ItemBase INGOT_SILVER = new ItemBase("ingot_silver");
    /*钴*/public static final ItemBase INGOT_COBALT = new ItemBase("ingot_cobalt");
    /*锇*/public static final ItemBase INGOT_OSMIUM = new ItemBase("ingot_osmium");
    /*镍*/public static final ItemBase INGOT_NICKEL = new ItemBase("ingot_nickel");
    /*铱*/public static final ItemBase INGOT_IRIDIUM = new ItemBase("ingot_iridium");
    /*铀*/public static final ItemBase INGOT_URANIUM = new ItemBase("ingot_uranium");
    /*镓*/public static final ItemBase INGOT_GALLIUM = new ItemBase("ingot_gallium");
    /*钛*/public static final ItemBase INGOT_TITANIUM = new ItemBase("ingot_titanium");
    /*铂*/public static final ItemBase INGOT_PLATINUM = new ItemBase("ingot_platinum");
    /*钨*/public static final ItemBase INGOT_TUNGSTEN = new ItemBase("ingot_tungsten");
    /*铝*/public static final ItemBase INGOT_ALUMINIUM = new ItemBase("ingot_aluminium");
    /*镁*/public static final ItemBase INGOT_MAGNESIUM = new ItemBase("ingot_magnesium");
    /*锂*/public static final ItemBase INGOT_LITHIUM = new ItemBase("ingot_lithium");
    /*钍*/public static final ItemBase INGOT_THORIUM = new ItemBase("ingot_thorium");
    /*硼*/public static final ItemBase INGOT_BORON = new ItemBase("ingot_boron");
    /*钒*/public static final ItemBase INGOT_VANADIUM = new ItemBase("ingot_vanadium");
    /*镉*/public static final ItemBase INGOT_CADMIUM = new ItemBase("ingot_cadmium");
    /*锰*/public static final ItemBase INGOT_MANGANESE = new ItemBase("ingot_manganese");
    /*锗*/public static final ItemBase INGOT_GERMANIUM = new ItemBase("ingot_germanium");
    /*铬*/public static final ItemBase INGOT_CHROMIUM = new ItemBase("ingot_chromium");
    /*砷*/public static final ItemBase INGOT_ARSENIC = new ItemBase("ingot_arsenic");

//构造函数
    public ItemBase(String name) {
        this(name, null);
    }
    public ItemBase(String name, Boolean a) {
        if (canRegistryItem(name, a)) {
            /*设置物品名*/this.setRegistryName(name);
            /*设置物品名key*/this.setUnlocalizedName(name + "_" + SuiKe.MODID);
            if (name.startsWith("raw")) {
                this.isRaw = true;
            }

            /*添加到ITEMS列表*/ITEMS.add(this);
        }
    }

//物品状态
    public boolean oreDictRaw = true; // 首次添加矿词Raw

    private boolean isRaw = false;
    public boolean isRaw() {
        return this.isRaw;
    }

//注册物品
    @SubscribeEvent
    public static void onRegisterItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(ITEMS.toArray(new Item[0]));

        for (Item item : ITEMS) {
            SuiKe.proxy.registerItemRenderer(item);
        }

        OreDict.rawOreDictAdd();
    }

//是否注册物品判断方法
    public static boolean canRegistryItem(String name, Boolean a) {
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

//隐藏物品
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
                /*添加到物品移除列表*/rawOreJEIPlugin.itemsToRemove.add(item);
            }
        }

        /*从物品列表移除物品*/ITEMS.removeAll(rawOreJEIPlugin.itemsToRemove);

        if (!Examine.JEIID) {
            rawOreJEIPlugin.itemsToRemoveClear();
        }
    }

    @JEIPlugin
    public static class rawOreJEIPlugin implements IModPlugin {
        public static List<Item> itemsToRemove = new ArrayList<>(); // 物品移除列表
        @Override
        public void register(IModRegistry registry) {
            new Thread(() -> {
                int i = 0;
                while (itemsToRemove.isEmpty()) {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    i++;

                    if (i >= 36) {
                        break;
                    }
                }

                // 获取JEI帮助器
                IJeiHelpers jeiHelpers = registry.getJeiHelpers();

                if (jeiHelpers != null) {
                    for (Item item : itemsToRemove) {
                        ItemStack itemStack = new ItemStack(item);
                        // 将物品添加到JEI黑名单
                        jeiHelpers.getItemBlacklist().addItemToBlacklist(itemStack);
                    }
                }

                itemsToRemoveClear();

            }).start();
        }

        public static void itemsToRemoveClear() {
            itemsToRemove.clear();
            itemsToRemove = null;
        }
    }

//矿词获取ItemStack
    public static ItemStack oreStack(String itemOreDict) {
        return oreStack(itemOreDict, 1);
    }
    public static ItemStack oreStack(String itemOreDict, int amount) {
        return oreStack(itemOreDict, amount, 0);
    }
    public static ItemStack oreStack(String itemOreDict, int amount, int number) {
        // 获取对应的矿词列表
        NonNullList<ItemStack> stackList = OreDictionary.getOres(itemOreDict);

        if (stackList != null && !stackList.isEmpty() && number >= 0 && number < stackList.size()) {
            ItemStack outputStack = stackList.get(number).copy();
            outputStack.setCount(amount); // 设置数量

            return outputStack;
        }

        return ItemStack.EMPTY; // 返回空的ItemStack
    }

//通过 ItemStack 物品获取矿词
    public static String getItemOreDict(ItemStack stack) {
        return getItemOreDict(stack, null, true, null);
    }
    public static String getItemOreDict(ItemStack stack, String with) {
        return getItemOreDict(stack, with, true, null);
    }
    public static String getItemOreDict(ItemStack stack, String with, boolean checkStarts) {
        return getItemOreDict(stack, with, checkStarts, null);
    }
    public static String getItemOreDict(ItemStack stack, String prefixSuffix, boolean checkPrefix, String lastOreDict) {
        if (!isValidItemStack(stack)) {
            return null;
        }

        int[] oreIDs = OreDictionary.getOreIDs(stack); // 物品矿词列表

        if (oreIDs.length == 0) { // 矿词列表为空
            return null;
        }

        // 如果没有指定前缀/后缀要求，直接返回第一个矿词
        if (prefixSuffix == null) {
            return OreDictionary.getOreName(oreIDs[0]);
        }

        String lastProcessedOreDict = "";
        for (int id : oreIDs) {
            String blockOreDict = OreDictionary.getOreName(id); // 获取矿词

            if (continueGet(blockOreDict, lastOreDict, lastProcessedOreDict)) {
                lastProcessedOreDict = blockOreDict; // 更新上一个矿词
                continue;
            }

            if (checkPrefix) {
                if (blockOreDict.startsWith(prefixSuffix)) {
                    return blockOreDict; // 矿词以 prefixSuffix 开头
                }
            } else {
                if (blockOreDict.endsWith(prefixSuffix)) {
                    return blockOreDict; // 矿词以 prefixSuffix 结尾
                }
            }
        }

        return null; // 未找到匹配的矿词
    }

    public static boolean continueGet(String blockOreDict, String lastOreDict, String lastProcessedOreDict) {
        // if (blockOreDict.equals("rawMaterials")) return true;

        if (lastOreDict == null) {
            return false; // 不需要获取下一个矿词
        }

        if (lastProcessedOreDict.equals(lastOreDict)) {
            return false; // 已获取到下一个
        }

        return true; // 继续获取, 返回 true
    }

//检查ItemStack
    public static boolean isValidItemStack(ItemStack... itemStackList) {
        for (ItemStack itemStack : itemStackList) {
            if (itemStack == null || itemStack.isEmpty()) {
                return false;
            }

            String stackString = itemStack.toString().replaceAll("^\\d+x", "");
            if (
                stackString.startsWith("item.null") ||
                stackString.startsWith("tile.air") ||
                stackString.equals("item.") ||
                stackString.equals("tile.")
               ) 
            {
                return false;//有一个无效, 返回false
            }
        }
        return true;//全部有效, 返回true
    }

//是否启用单独物品栏
    public static void CreativeTabs() {
        if (ITEMS.size() == 4) {
            for (Item item : ItemBase.ITEMS) {
                if (item == ItemBase.RAW_GOLD || item == ItemBase.RAW_IRON) {
                    item.setCreativeTab(CreativeTabs.MATERIALS);
                }
            }
            for (BlockBase block : BlockBase.BLOCKS) {
                if (block == BlockBase.RAW_BLOCK_GOLD || block == BlockBase.RAW_BLOCK_IRON) {
                    block.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
                }
            }
        } else {
            /*创建物品栏*/rawOreTabs.Inventory();
        }
    }
}
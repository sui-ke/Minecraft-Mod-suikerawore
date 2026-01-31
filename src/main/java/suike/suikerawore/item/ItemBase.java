package suike.suikerawore.item;

import java.util.*;

import suike.suikerawore.SuiKe;
import suike.suikerawore.config.Config;
import suike.suikerawore.block.BlockBase;
import suike.suikerawore.inter.IItemEntry;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;
import net.minecraft.util.NonNullList;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.client.event.ModelRegistryEvent;

import org.apache.commons.lang3.StringUtils;

@Mod.EventBusSubscriber
public abstract class ItemBase<T extends ItemBase<T, V>, V extends BlockBase<V> & IItemEntry<V>> extends Item implements IItemEntry<T> {
    public static final List<ItemBase> ITEMS = new ArrayList<>();

    static { Config.config(); }

    /*锭*/
    /*铜*/public static final ModItemIngot INGOT_COPPER    = new ModItemIngot("ingot_copper"   , BlockBase.BLOCK_COPPER);
    /*锡*/public static final ModItemIngot INGOT_TIN       = new ModItemIngot("ingot_tin"      , BlockBase.BLOCK_TIN);
    /*锌*/public static final ModItemIngot INGOT_ZINC      = new ModItemIngot("ingot_zinc"     , BlockBase.BLOCK_ZINC);
    /*铅*/public static final ModItemIngot INGOT_LEAD      = new ModItemIngot("ingot_lead"     , BlockBase.BLOCK_LEAD);
    /*银*/public static final ModItemIngot INGOT_SILVER    = new ModItemIngot("ingot_silver"   , BlockBase.BLOCK_SILVER);
    /*钴*/public static final ModItemIngot INGOT_COBALT    = new ModItemIngot("ingot_cobalt"   , BlockBase.BLOCK_COBALT);
    /*锇*/public static final ModItemIngot INGOT_OSMIUM    = new ModItemIngot("ingot_osmium"   , BlockBase.BLOCK_OSMIUM);
    /*镍*/public static final ModItemIngot INGOT_NICKEL    = new ModItemIngot("ingot_nickel"   , BlockBase.BLOCK_NICKEL);
    /*铱*/public static final ModItemIngot INGOT_IRIDIUM   = new ModItemIngot("ingot_iridium"  , BlockBase.BLOCK_IRIDIUM);
    /*铀*/public static final ModItemIngot INGOT_URANIUM   = new ModItemIngot("ingot_uranium"  , BlockBase.BLOCK_URANIUM, () -> { return !Loader.isModLoaded("ic2-classic-spmod"); });
    /*镓*/public static final ModItemIngot INGOT_GALLIUM   = new ModItemIngot("ingot_gallium"  , BlockBase.BLOCK_GALLIUM);
    /*钛*/public static final ModItemIngot INGOT_TITANIUM  = new ModItemIngot("ingot_titanium" , BlockBase.BLOCK_TITANIUM);
    /*铂*/public static final ModItemIngot INGOT_PLATINUM  = new ModItemIngot("ingot_platinum" , BlockBase.BLOCK_PLATINUM);
    /*钨*/public static final ModItemIngot INGOT_TUNGSTEN  = new ModItemIngot("ingot_tungsten" , BlockBase.BLOCK_TUNGSTEN);
    /*铝*/public static final ModItemIngot INGOT_ALUMINIUM = new ModItemIngot("ingot_aluminium", BlockBase.BLOCK_ALUMINIUM);
    /*镁*/public static final ModItemIngot INGOT_MAGNESIUM = new ModItemIngot("ingot_magnesium", BlockBase.BLOCK_MAGNESIUM);
    /*锂*/public static final ModItemIngot INGOT_LITHIUM   = new ModItemIngot("ingot_lithium"  , BlockBase.BLOCK_LITHIUM);
    /*钍*/public static final ModItemIngot INGOT_THORIUM   = new ModItemIngot("ingot_thorium"  , BlockBase.BLOCK_THORIUM);
    /*硼*/public static final ModItemIngot INGOT_BORON     = new ModItemIngot("ingot_boron"    , BlockBase.BLOCK_BORON);
    /*钒*/public static final ModItemIngot INGOT_VANADIUM  = new ModItemIngot("ingot_vanadium" , BlockBase.BLOCK_VANADIUM);
    /*镉*/public static final ModItemIngot INGOT_CADMIUM   = new ModItemIngot("ingot_cadmium"  , BlockBase.BLOCK_CADMIUM);
    /*锰*/public static final ModItemIngot INGOT_MANGANESE = new ModItemIngot("ingot_manganese", BlockBase.BLOCK_MANGANESE);
    /*锗*/public static final ModItemIngot INGOT_GERMANIUM = new ModItemIngot("ingot_germanium", BlockBase.BLOCK_GERMANIUM);
    /*铬*/public static final ModItemIngot INGOT_CHROMIUM  = new ModItemIngot("ingot_chromium" , BlockBase.BLOCK_CHROMIUM);
    /*砷*/public static final ModItemIngot INGOT_ARSENIC   = new ModItemIngot("ingot_arsenic"  , BlockBase.BLOCK_ARSENIC);

    /*粗矿*/
    /*金*/public static final ModItemRawOre RAW_GOLD       = ModItemRawOre.create("raw_gold"     , BlockBase.RAW_BLOCK_GOLD     , Items.GOLD_INGOT, new Object[]{"dustGold"     , 2.0F, "itemCinnabar" , 0.2F , "dustCopper"    , 0.2F , "dustSilver" , 0.15F}).setMain();
    /*铁*/public static final ModItemRawOre RAW_IRON       = ModItemRawOre.create("raw_iron"     , BlockBase.RAW_BLOCK_IRON     , Items.IRON_INGOT, new Object[]{"dustIron"     , 2.0F, "dustNickel"   , 0.1F , "dustCobalt"    , 0.05F, "dustLithium", 0.03F}).setMain();
    /*铜*/public static final ModItemRawOre RAW_COPPER     = ModItemRawOre.create("raw_copper"   , BlockBase.RAW_BLOCK_COPPER   , INGOT_COPPER    , new Object[]{"dustCopper"   , 2.0F, "dustGold"     , 0.12F, "dustMolybdenum", 0.08F}, "item:deeperdepths:material", "item:mw:copperingot");
    /*锡*/public static final ModItemRawOre RAW_TIN        = ModItemRawOre.create("raw_tin"      , BlockBase.RAW_BLOCK_TIN      , INGOT_TIN       , new Object[]{"dustTin"      , 2.0F, "dustIron"     , 0.1F , "dustLithium"   , 0.05F});
    /*锌*/public static final ModItemRawOre RAW_ZINC       = ModItemRawOre.create("raw_zinc"     , BlockBase.RAW_BLOCK_ZINC     , INGOT_ZINC      , new Object[]{"dustZinc"     , 2.0F, "dustCadmium"  , 0.15F, "dustGallium"   , 0.1F });
    /*铅*/public static final ModItemRawOre RAW_LEAD       = ModItemRawOre.create("raw_lead"     , BlockBase.RAW_BLOCK_LEAD     , INGOT_LEAD      , new Object[]{"dustLead"     , 2.0F, "dustSilver"   , 0.1F , "dustBismuth"   , 0.07F});
    /*银*/public static final ModItemRawOre RAW_SILVER     = ModItemRawOre.create("raw_silver"   , BlockBase.RAW_BLOCK_SILVER   , INGOT_SILVER    , new Object[]{"dustSilver"   , 2.0F, "dustLead"     , 0.1F , "dustArsenic"   , 0.05F});
    /*钴*/public static final ModItemRawOre RAW_COBALT     = ModItemRawOre.create("raw_cobalt"   , BlockBase.RAW_BLOCK_COBALT   , INGOT_COBALT    , new Object[]{"dustCobalt"   , 2.0F, "dustNickel"   , 0.3F , "dustCopper"    , 0.2F, "dustIron"    , 0.15F});
    /*锇*/public static final ModItemRawOre RAW_OSMIUM     = ModItemRawOre.create("raw_osmium"   , BlockBase.RAW_BLOCK_OSMIUM   , INGOT_OSMIUM    , new Object[]{"dustOsmium"   , 2.0F, "dustIridium"  , 0.25F, "dustOsmium"    , 0.1F, "dustPlatinum", 0.1F});
    /*镍*/public static final ModItemRawOre RAW_NICKEL     = ModItemRawOre.create("raw_nickel"   , BlockBase.RAW_BLOCK_NICKEL   , INGOT_NICKEL    , new Object[]{"dustNickel"   , 2.0F, "dustPlatinum" , 0.2F , "dustCobalt"    , 0.2F });
    /*铱*/public static final ModItemRawOre RAW_IRIDIUM    = ModItemRawOre.create("raw_iridium"  , BlockBase.RAW_BLOCK_IRIDIUM  , INGOT_IRIDIUM   , new Object[]{"dustIridium"  , 2.0F, "dustPlatinum" , 0.2F , "dustOsmium"    , 0.2F, "dustRuthenium" , 0.15F});
    /*铀*/public static final ModItemRawOre RAW_URANIUM    = ModItemRawOre.create("raw_uranium"  , BlockBase.RAW_BLOCK_URANIUM  , INGOT_URANIUM   , new Object[]{"dustUranium"  , 2.0F, "dustThorium"  , 0.15F, "dustRareEarth" , 0.1F});
    /*镓*/public static final ModItemRawOre RAW_GALLIUM    = ModItemRawOre.create("raw_gallium"  , BlockBase.RAW_BLOCK_GALLIUM  , INGOT_GALLIUM   , new Object[]{"dustGallium"  , 2.0F, "dustAluminium", 0.3F , "dustZinc"      , 0.1F}, "fluid:liquidgallium");
    /*钛*/public static final ModItemRawOre RAW_TITANIUM   = ModItemRawOre.create("raw_titanium" , BlockBase.RAW_BLOCK_TITANIUM , INGOT_TITANIUM  , new Object[]{"dustTitanium" , 2.0F, "dustVanadium" , 0.15F, "dustIron"      , 0.1F});
    /*铂*/public static final ModItemRawOre RAW_PLATINUM   = ModItemRawOre.create("raw_platinum" , BlockBase.RAW_BLOCK_PLATINUM , INGOT_PLATINUM  , new Object[]{"dustPlatinum" , 2.0F, "dustIridium"  , 0.2F , "dustPalladium" , 0.2F });
    /*钨*/public static final ModItemRawOre RAW_TUNGSTEN   = ModItemRawOre.create("raw_tungsten" , BlockBase.RAW_BLOCK_TUNGSTEN , INGOT_TUNGSTEN  , new Object[]{"dustTungsten" , 2.0F, "dustTin"      , 0.1F , "dustMolybdenum", 0.1F});
    /*铝*/public static final ModItemRawOre RAW_ALUMINIUM  = ModItemRawOre.create("raw_aluminium", BlockBase.RAW_BLOCK_ALUMINIUM, INGOT_ALUMINIUM , new Object[]{"dustAluminium", 2.0F, "dustIron"     , 0.1F , "dustTitanium"  , 0.1F, "dustLithium", 0.03F}, "fluid:aluminum");
    /*镁*/public static final ModItemRawOre RAW_MAGNESIUM  = ModItemRawOre.create("raw_magnesium", BlockBase.RAW_BLOCK_MAGNESIUM, INGOT_MAGNESIUM , new Object[]{"dustMagnesium", 2.0F, "dustCalcium"  , 0.2F , "dustLithium"   , 0.05F});
    /*锂*/public static final ModItemRawOre RAW_LITHIUM    = ModItemRawOre.create("raw_lithium"  , BlockBase.RAW_BLOCK_LITHIUM  , INGOT_LITHIUM   , new Object[]{"dustLithium"  , 2.0F, "dustAluminium", 0.1F , "dustBoron"     , 0.05F});
    /*钍*/public static final ModItemRawOre RAW_THORIUM    = ModItemRawOre.create("raw_thorium"  , BlockBase.RAW_BLOCK_THORIUM  , INGOT_THORIUM   , new Object[]{"dustThorium"  , 2.0F, "dustRareEarth", 0.25F, "dustUranium"   , 0.15F}, "item:ic2c_extras:thorium232ingot");
    /*硼*/public static final ModItemRawOre RAW_BORON      = ModItemRawOre.create("raw_boron"    , BlockBase.RAW_BLOCK_BORON    , INGOT_BORON     , new Object[]{"dustBoron"    , 2.0F, "dustSodium"   , 0.2F , "dustCalcium"   , 0.2F});
    /*钒*/public static final ModItemRawOre RAW_VANADIUM   = ModItemRawOre.create("raw_vanadium" , BlockBase.RAW_BLOCK_VANADIUM , INGOT_VANADIUM  , new Object[]{"dustVanadium" , 2.0F, "dustTitanium" , 0.3F , "dustIron"      , 0.25F});
    /*镉*/public static final ModItemRawOre RAW_CADMIUM    = ModItemRawOre.create("raw_cadmium"  , BlockBase.RAW_BLOCK_CADMIUM  , INGOT_CADMIUM   , new Object[]{"dustCadmium"  , 2.0F, "dustZinc"     , 0.4F , "dustCopper"    , 0.1F});
    /*锰*/public static final ModItemRawOre RAW_MANGANESE  = ModItemRawOre.create("raw_manganese", BlockBase.RAW_BLOCK_MANGANESE, INGOT_MANGANESE , new Object[]{"dustManganese", 2.0F, "dustIron"     , 0.3F , "dustCobalt"    , 0.15F});
    /*锗*/public static final ModItemRawOre RAW_GERMANIUM  = ModItemRawOre.create("raw_germanium", BlockBase.RAW_BLOCK_GERMANIUM, INGOT_GERMANIUM , new Object[]{"dustGermanium", 2.0F, "dustLead"     , 0.2F , "dustZinc"      , 0.2F});
    /*铬*/public static final ModItemRawOre RAW_CHROMIUM   = ModItemRawOre.create("raw_chromium" , BlockBase.RAW_BLOCK_CHROMIUM , INGOT_CHROMIUM  , new Object[]{"dustChromium" , 2.0F, "dustIron"     , 0.3F , "dustNickel"    , 0.1F});
    /*砷*/public static final ModItemRawOre RAW_ARSENIC    = ModItemRawOre.create("raw_arsenic"  , BlockBase.RAW_BLOCK_ARSENIC  , INGOT_ARSENIC   , new Object[]{"dustArsenic"  , 2.0F, "dustSulfur"   , 0.4F , "dustAntimony"  , 0.15F});
    /*铍*/public static final ModItemRawOre RAW_BERYLLIUM  = ModItemRawOre.create("raw_beryllium", BlockBase.RAW_BLOCK_BERYLLIUM, new Object[]{"dustBeryllium" , 2.0F, "dustAluminium", 0.2F , "dustLithium"   , 0.1F});
    /*镭*/public static final ModItemRawOre RAW_IRRADIUM   = ModItemRawOre.create("raw_irradium" , BlockBase.RAW_BLOCK_IRRADIUM , new Object[]{"dustIrradium"  , 1.0F, "dustIrradium" , 0.03F}, "fluid:liquidirradium");
    /*钯*/public static final ModItemRawOre RAW_PALLADIUM  = ModItemRawOre.create("raw_palladium", BlockBase.RAW_BLOCK_PALLADIUM, new Object[]{"dustPalladium" , 2.0F, "dustNickel"   , 0.3F , "dustPlatinum"  , 0.1F}, "fluid:palladium_fluid");
    /*钚*/public static final ModItemRawOre RAW_PLUTONIUM  = ModItemRawOre.create("raw_plutonium", BlockBase.RAW_BLOCK_PLUTONIUM, new Object[]{"dustPlutonium" , 1.0F, "dustPlutonium", 0.03F, "dustUranium"   , 0.01F});
    /*铌*/public static final ModItemRawOre RAW_NIOBIUM    = ModItemRawOre.create("raw_niobium"  , BlockBase.RAW_BLOCK_NIOBIUM  , new Object[]{"dustNiobium"   , 2.0F, "dustNiobium"  , 0.03F, "dustNiobium"   , 0.01F});
    /*秘银*/public static final ModItemRawOre RAW_MITHRIL  = ModItemRawOre.create("raw_mithril"  , BlockBase.RAW_BLOCK_MITHRIL  , new Object[]{"dustMithril"   , 2.0F, "dustSilver"   , 0.15F, "dustPlatinum"  , 0.05F});
    /*金红石*/public static final ModItemRawOre RAW_RUTILE = ModItemRawOre.create("raw_rutile"   , BlockBase.RAW_BLOCK_RUTILE   , new Object[]{"dustRutile"    , 2.0F, "dustIron"     , 0.25F, "dustVanadium"  , 0.25F});
    /*阿迪特*/public static final ModItemRawOre RAW_ARDITE    = ModItemRawOre.create("raw_ardite"   , BlockBase.RAW_BLOCK_ARDITE, new Object[]{"dustCinnabar"  , 2.0F, "dustArsenic"  , 0.25F, "itemCinnabar"  , 0.1F, "dustGold", 0.05F});
    /* 晶蓝 */public static final ModItemRawOre RAW_CERULEAN  = ModItemRawOre.create("raw_cerulean" , BlockBase.RAW_BLOCK_CERULEAN , "fluid:tamoltencerulean");
    /*皎月石*/public static final ModItemRawOre RAW_MOONSTONE = ModItemRawOre.create("raw_moonstone", BlockBase.RAW_BLOCK_MOONSTONE, "fluid:tamoltenmoonstone");
    /*炽炎铁*/public static final ModItemRawOre RAW_OCTINE    = new ModItemRawOctine("raw_octine"   , BlockBase.RAW_BLOCK_OCTINE   , "fluid:liquidoctine");
    /*赛摩铜*/public static final ModItemRawOre RAW_SYRMORITE = ModItemRawOre.create("raw_syrmorite", BlockBase.RAW_BLOCK_SYRMORITE, "fluid:liquidsyrmorite");
    /* 朱砂 */public static final ModItemRawOre RAW_CINNABAR  = ModItemRawOre.create("raw_cinnabar" , BlockBase.RAW_BLOCK_CINNABAR , new Object[]{"quicksilver", 1.0F, "itemCinnabar", 0.25F}, "item:thaumcraft:quicksilver");
    /*软碲铜*/public static final ModItemRawOre RAW_VULCANITE = ModItemRawOre.create("raw_vulcanite", BlockBase.RAW_BLOCK_VULCANITE);
    /* 裂金 */public static final ModItemRawOre RAW_CHASMIUM  = ModItemRawOre.create("raw_chasmium" , BlockBase.RAW_BLOCK_CHASMIUM);
    /*玫瑰金*/public static final ModItemRawOre RAW_ROSEGOLD  = ModItemRawOre.create("raw_rosegold" , BlockBase.RAW_BLOCK_ROSEGOLD);

// 构造函数
    public ItemBase(String name, V compressBlock) {
        /*设置物品名*/this.setRegistryName(SuiKe.MODID, name);
        /*设置物品名key*/this.setUnlocalizedName(SuiKe.MODID + "." + name);

        this.compressBlock = compressBlock;
        this.elementType = StringUtils.capitalize(name.replace("raw_", "").replace("ingot_", ""));

        ITEMS.add(this);
    }

// 物品数据
    // 是否是必要
    private boolean isMain;
    @Override
    public boolean isMain() {
        return this.isMain;
    }
    protected T setMain() {
        this.isMain = true;
        return (T) this.setValid(true);
    }

    // 是否有效
    private boolean isValid;
    @Override
    public boolean isValid() {
        return this.isValid;
    }
    @Override
    public T setValid(boolean isValid) {
        this.isValid = isValid;
        return (T) this;
    }

    // 首字母大写的元素类型
    private final String elementType;
    @Override
    public String getElementType() {
        return this.elementType;
    }

    // 获取矿词
    @Override
    public String getItemOreDict() {
        return this.getItemType() + this.getElementType();
    }

    // 物品压缩后的 Block
    private final V compressBlock;
    public V getCompressBlock() {
        return this.compressBlock;
    }

// 注册物品事件
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        Config.redRefinedItem();
    }

// 后期注册物品
    public static void registerItems() {
        ModItemRawOre.upValid();
        for (ItemBase item : ITEMS) {
            if (IItemEntry.isValid(item)) {
                ForgeRegistries.ITEMS.register(item);
                SuiKe.proxy.registerItemRenderer(item);
            }
        }
        for (BlockBase block : BlockBase.BLOCKS) {
            if (IItemEntry.isValid(block)) {
                ForgeRegistries.BLOCKS.register(block);
                ForgeRegistries.ITEMS.register(block.getItem());
                // RAW_GOLD.registerItemBlock(block, block.getItem());
                SuiKe.proxy.registerItemRenderer(block.getItem());
            }
        }
    }

// 获取粗矿
    public static ModItemRawOre getRawOre(String elementType) {
        synchronized (ModItemRawOre.TYPE_TO_RAW_ORE) {
            return ModItemRawOre.TYPE_TO_RAW_ORE.get(elementType);
        }
    }

// 矿词获取 ItemStack
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

// 通过 ItemStack 物品获取矿词
    public static String getItemOreDict(ItemStack stack) {
        return getItemOreDict(stack, "", true, "");
    }
    public static String getItemOreDict(ItemStack stack, String with) {
        return getItemOreDict(stack, with, true, "");
    }
    public static String getItemOreDict(ItemStack stack, String prefixSuffix, boolean checkStarts) {
        return getItemOreDict(stack, prefixSuffix, checkStarts, "");
    }
    public static String getItemOreDict(ItemStack stack, String prefixSuffix, boolean checkPrefix, String lastOreDict) {
        if (!isValidItemStack(stack)) return "";

        String lastProcessedOreDict = "";
        for (int id : OreDictionary.getOreIDs(stack)) {
            String blockOreDict = OreDictionary.getOreName(id); // 获取矿词

            if (prefixSuffix.isEmpty()) {
                // 如果没有指定前缀/后缀要求，直接返回第一个矿词
                return blockOreDict;
            }

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

        return ""; // 未找到匹配的矿词
    }

    private static boolean continueGet(String blockOreDict, String lastOreDict, String lastProcessedOreDict) {
        if (lastOreDict.isEmpty()) {
            return false; // 不需要获取下一个矿词
        }
        if (lastProcessedOreDict.equals(lastOreDict)) {
            return false; // 已获取到下一个
        }
        return true; // 继续获取, 返回 true
    }

// 相同物品
    public static boolean itemsEqual(ItemStack item1, ItemStack item2) {
        return isValidItemStack(item1, item2)                // 有效物品
            && ItemStack.areItemsEqual(item1, item2)         // 相同 Item
            && ItemStack.areItemStackTagsEqual(item1, item2) // 相同 tag
            && item1.getMetadata() == item2.getMetadata();   // 相同 元数据
    }

// 检查 ItemStack
    public static boolean isValidItemStack(ItemStack... itemStackList) {
        for (ItemStack itemStack : itemStackList) {
            if (itemStack == null || itemStack.isEmpty() || itemStack.getItem() == null) {
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
                return false; // 有一个无效, 返回false
            }
        }
        return true; // 全部有效才返回true
    }
}
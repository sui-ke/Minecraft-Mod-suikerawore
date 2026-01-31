package suike.suikerawore.client;

import java.util.*;

import suike.suikerawore.item.*;
import suike.suikerawore.block.*;
import suike.suikerawore.inter.IItemEntry;
import suike.suikerawore.config.ConfigValue;
import suike.suikerawore.data.CustomNonNullList;

import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.NonNullList;

public class RawOreTabs extends CreativeTabs {

    private static RawOreTabs RAW_ORE;
    private RawOreTabs() {
        super("rawOreTabs");
    }

    private RawOreTabs initItems() {
        this.displayAllRelevantItems(NonNullList.create());
        return this;
    }

    @Override
    public ItemStack getTabIconItem() {
        //设置分类窗口的图标
        return new ItemStack(ItemBase.RAW_GOLD);
    }

    @Override
    public void displayAllRelevantItems(NonNullList<ItemStack> items) {
        super.displayAllRelevantItems(items);

        List<ItemStack> rawOre      = new ArrayList<>();
        List<ItemStack> rawOreBlock = new ArrayList<>();
        List<ItemStack> ingot       = new ArrayList<>();
        List<ItemStack> blockMetal  = new ArrayList<>();

        for (Item item : ItemBase.ITEMS) {
            if (item instanceof ModItemRawOre) {
                ModItemRawOre rawOreItem = (ModItemRawOre) item;
                if (rawOreItem.isValid()) {
                    rawOre     .add(new ItemStack(rawOreItem));
                    rawOreBlock.add(new ItemStack(rawOreItem.getCompressBlock()));
                    ingot      .add(rawOreItem.getRefinedItemStack());
                    blockMetal .add(rawOreItem.getCompressBlock().getRefinedItemStack());
                }
            }
        }

        CustomNonNullList<ItemStack> customItems = CustomNonNullList.create(items, null);

        customItems.addAll(rawOre);
        customItems.addAll(rawOreBlock);
        customItems.addAll(ingot);
        customItems.addAll(blockMetal);
    }

    public static void creativeTabs() {
        if (canCreativeTabs()) {
            RAW_ORE = new RawOreTabs().initItems();
        }
    }

// 是否启用单独物品栏
    private static boolean canCreativeTabs() {
        // 如果有 金, 铁, 铜 以外的元素则添加新的创造模式标签页
        for (Item item : ItemBase.ITEMS) {
            if (item instanceof ModItemRawOre) {
                IItemEntry entry = (IItemEntry) item;
                if (entry.isValid() && !isMain(entry)) {
                    return true;
                }
            }
        }

        // 设置到原版创造模式标签页
        for (ItemBase item : ItemBase.ITEMS) {
            if (item.isValid()) {
                item.setCreativeTab(CreativeTabs.MATERIALS);
            }
        }
        for (BlockBase block : BlockBase.BLOCKS) {
            if (block.isValid()) {
                block.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
            }
        }

        return false;
    }

    private static boolean isMain(IItemEntry entry) {
        return "Gold".equals(entry.getElementType())
            || "Iron".equals(entry.getElementType())
            || "Copper".equals(entry.getElementType());
    }
}
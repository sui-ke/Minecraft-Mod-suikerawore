package com.suike.suikerawore.itemtabs;

import java.util.List;
import java.util.ArrayList;

import com.suike.suikerawore.item.ItemBase;
import com.suike.suikerawore.item.BlockBase;

import com.suike.suikerawore.expand.Examine;

import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.creativetab.CreativeTabs;

//新建创造模式物品栏窗口
public class rawOreTabs extends CreativeTabs {

    private static final List<Item> ITEMS = new ArrayList<>();

    public static final rawOreTabs RAW_ORE = new rawOreTabs(/*分类名称*/"rawOreTabs");

    private rawOreTabs(String label) {
        super(label);
    }

    @Override
    public ItemStack getTabIconItem() {
        //设置分类窗口的图标
        return new ItemStack(ItemBase.RAW_GOLD);
    }

    public static void Inventory() {
        //物品顺序 粗矿 粗块 锭 块 

        //粗矿
        /*金*/ITEMS.add(ItemBase.RAW_GOLD);
        /*铁*/ITEMS.add(ItemBase.RAW_IRON);
        /*铜*/ITEMS.add(ItemBase.RAW_COPPER);
        /*锡*/ITEMS.add(ItemBase.RAW_TIN);
        /*锌*/ITEMS.add(ItemBase.RAW_ZINC);
        /*铅*/ITEMS.add(ItemBase.RAW_LEAD);
        /*银*/ITEMS.add(ItemBase.RAW_SILVER);
        /*钴*/ITEMS.add(ItemBase.RAW_COBALT);
        /*锇*/ITEMS.add(ItemBase.RAW_OSMIUM);
        /*镍*/ITEMS.add(ItemBase.RAW_NICKEL);
        /*铱*/ITEMS.add(ItemBase.RAW_IRIDIUM);
        /*铀*/ITEMS.add(ItemBase.RAW_URANIUM);
        /*镓*/ITEMS.add(ItemBase.RAW_GALLIUM);
        /*钛*/ITEMS.add(ItemBase.RAW_TITANIUM);
        /*铂*/ITEMS.add(ItemBase.RAW_PLATINUM);
        /*钨*/ITEMS.add(ItemBase.RAW_TUNGSTEN);
        /*铝*/ITEMS.add(ItemBase.RAW_ALUMINIUM);
        /*镁*/ITEMS.add(ItemBase.RAW_MAGNESIUM);
        /*锂*/ITEMS.add(ItemBase.RAW_LITHIUM);
        /*钍*/ITEMS.add(ItemBase.RAW_THORIUM);
        /*硼*/ITEMS.add(ItemBase.RAW_BORON);

        //粗块
        /*金*/ITEMS.add(Item.getItemFromBlock(BlockBase.RAW_BLOCK_GOLD));
        /*铁*/ITEMS.add(Item.getItemFromBlock(BlockBase.RAW_BLOCK_IRON));
        /*铜*/ITEMS.add(Item.getItemFromBlock(BlockBase.RAW_BLOCK_COPPER));
        /*锡*/ITEMS.add(Item.getItemFromBlock(BlockBase.RAW_BLOCK_TIN));
        /*锌*/ITEMS.add(Item.getItemFromBlock(BlockBase.RAW_BLOCK_ZINC));
        /*铅*/ITEMS.add(Item.getItemFromBlock(BlockBase.RAW_BLOCK_LEAD));
        /*银*/ITEMS.add(Item.getItemFromBlock(BlockBase.RAW_BLOCK_SILVER));
        /*钴*/ITEMS.add(Item.getItemFromBlock(BlockBase.RAW_BLOCK_COBALT));
        /*锇*/ITEMS.add(Item.getItemFromBlock(BlockBase.RAW_BLOCK_OSMIUM));
        /*镍*/ITEMS.add(Item.getItemFromBlock(BlockBase.RAW_BLOCK_NICKEL));
        /*铱*/ITEMS.add(Item.getItemFromBlock(BlockBase.RAW_BLOCK_IRIDIUM));
        /*铀*/ITEMS.add(Item.getItemFromBlock(BlockBase.RAW_BLOCK_URANIUM));
        /*镓*/ITEMS.add(Item.getItemFromBlock(BlockBase.RAW_BLOCK_GALLIUM));
        /*钛*/ITEMS.add(Item.getItemFromBlock(BlockBase.RAW_BLOCK_TITANIUM));
        /*铂*/ITEMS.add(Item.getItemFromBlock(BlockBase.RAW_BLOCK_PLATINUM));
        /*钨*/ITEMS.add(Item.getItemFromBlock(BlockBase.RAW_BLOCK_TUNGSTEN));
        /*铝*/ITEMS.add(Item.getItemFromBlock(BlockBase.RAW_BLOCK_ALUMINIUM));
        /*镁*/ITEMS.add(Item.getItemFromBlock(BlockBase.RAW_BLOCK_MAGNESIUM));
        /*锂*/ITEMS.add(Item.getItemFromBlock(BlockBase.RAW_BLOCK_LITHIUM));
        /*钍*/ITEMS.add(Item.getItemFromBlock(BlockBase.RAW_BLOCK_THORIUM));
        /*硼*/ITEMS.add(Item.getItemFromBlock(BlockBase.RAW_BLOCK_BORON));

        //锭
        /*金*/ITEMS.add(Items.GOLD_INGOT);
        /*铁*/ITEMS.add(Items.IRON_INGOT);
        /*铜*/ITEMS.add(ItemBase.INGOT_COPPER);
        /*锡*/ITEMS.add(ItemBase.INGOT_TIN);
        /*锌*/ITEMS.add(ItemBase.INGOT_ZINC);
        /*铅*/ITEMS.add(ItemBase.INGOT_LEAD);
        /*银*/ITEMS.add(ItemBase.INGOT_SILVER);
        /*钴*/ITEMS.add(ItemBase.INGOT_COBALT);
        /*锇*/ITEMS.add(ItemBase.INGOT_OSMIUM);
        /*镍*/ITEMS.add(ItemBase.INGOT_NICKEL);
        /*铱*/ITEMS.add(ItemBase.INGOT_IRIDIUM);
        /*铀*/ITEMS.add(ItemBase.INGOT_URANIUM);
        /*镓*/ITEMS.add(ItemBase.INGOT_GALLIUM);
        /*钛*/ITEMS.add(ItemBase.INGOT_TITANIUM);
        /*铂*/ITEMS.add(ItemBase.INGOT_PLATINUM);
        /*钨*/ITEMS.add(ItemBase.INGOT_TUNGSTEN);
        /*铝*/ITEMS.add(ItemBase.INGOT_ALUMINIUM);
        /*镁*/ITEMS.add(ItemBase.INGOT_MAGNESIUM);
        /*锂*/ITEMS.add(ItemBase.INGOT_LITHIUM);
        /*钍*/ITEMS.add(ItemBase.INGOT_THORIUM);
        /*硼*/ITEMS.add(ItemBase.INGOT_BORON);

        //块
        /*金*/ITEMS.add(Item.getItemFromBlock(Blocks.GOLD_BLOCK));
        /*铁*/ITEMS.add(Item.getItemFromBlock(Blocks.IRON_BLOCK));
        /*铜*/ITEMS.add(Item.getItemFromBlock(BlockBase.BLOCK_COPPER));
        /*锡*/ITEMS.add(Item.getItemFromBlock(BlockBase.BLOCK_TIN));
        /*锌*/ITEMS.add(Item.getItemFromBlock(BlockBase.BLOCK_ZINC));
        /*铅*/ITEMS.add(Item.getItemFromBlock(BlockBase.BLOCK_LEAD));
        /*银*/ITEMS.add(Item.getItemFromBlock(BlockBase.BLOCK_SILVER));
        /*钴*/ITEMS.add(Item.getItemFromBlock(BlockBase.BLOCK_COBALT));
        /*锇*/ITEMS.add(Item.getItemFromBlock(BlockBase.BLOCK_OSMIUM));
        /*镍*/ITEMS.add(Item.getItemFromBlock(BlockBase.BLOCK_NICKEL));
        /*铱*/ITEMS.add(Item.getItemFromBlock(BlockBase.BLOCK_IRIDIUM));
        /*铀*/ITEMS.add(Item.getItemFromBlock(BlockBase.BLOCK_URANIUM));
        /*镓*/ITEMS.add(Item.getItemFromBlock(BlockBase.BLOCK_GALLIUM));
        /*钛*/ITEMS.add(Item.getItemFromBlock(BlockBase.BLOCK_TITANIUM));
        /*铂*/ITEMS.add(Item.getItemFromBlock(BlockBase.BLOCK_PLATINUM));
        /*钨*/ITEMS.add(Item.getItemFromBlock(BlockBase.BLOCK_TUNGSTEN));
        /*铝*/ITEMS.add(Item.getItemFromBlock(BlockBase.BLOCK_ALUMINIUM));
        /*镁*/ITEMS.add(Item.getItemFromBlock(BlockBase.BLOCK_MAGNESIUM));
        /*锂*/ITEMS.add(Item.getItemFromBlock(BlockBase.BLOCK_LITHIUM));
        /*钍*/ITEMS.add(Item.getItemFromBlock(BlockBase.BLOCK_THORIUM));
        /*硼*/ITEMS.add(Item.getItemFromBlock(BlockBase.BLOCK_BORON));

        //更多粗矿
        if (Examine.TCID) {
            /*阿迪特*/ITEMS.add(ItemBase.RAW_ARDITE);
        }
        if (Examine.TheAurorianID) {
            /*晶蓝*/ITEMS.add(ItemBase.RAW_CERULEAN);
            /*皎月石*/ITEMS.add(ItemBase.RAW_MOONSTONE);
        }
        if (Examine.TheBetweenlandsID) {
            /*炽炎铁*/ITEMS.add(ItemBase.RAW_OCTINE);
            /*赛摩铜*/ITEMS.add(ItemBase.RAW_SYRMORITE);
        }

        //更多粗块
        if (Examine.TCID) {
            /*阿迪特*/ITEMS.add(Item.getItemFromBlock(BlockBase.RAW_BLOCK_ARDITE));
        }
        if (Examine.TheAurorianID) {
            /*晶蓝*/ITEMS.add(Item.getItemFromBlock(BlockBase.RAW_BLOCK_CERULEAN));
            /*皎月石*/ITEMS.add(Item.getItemFromBlock(BlockBase.RAW_BLOCK_MOONSTONE));
        }
        if (Examine.TheBetweenlandsID) {
            /*炽炎铁*/ITEMS.add(Item.getItemFromBlock(BlockBase.RAW_BLOCK_OCTINE));
            /*赛摩铜*/ITEMS.add(Item.getItemFromBlock(BlockBase.RAW_BLOCK_SYRMORITE));
        }

        //修改物品栏
        RAW_ORE.displayAllRelevantItems(NonNullList.create());
    }

    @Override
    public void displayAllRelevantItems(NonNullList<ItemStack> items) {
        //修改物品栏
        super.displayAllRelevantItems(items);

        for (Item item : ITEMS) {
            items.add(new ItemStack(item));
        }
    }
}
package suike.suikerawore.item;

import java.util.List;
import java.util.ArrayList;

import suike.suikerawore.item.ItemBase;

import suike.suikerawore.expand.Examine;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.creativetab.CreativeTabs;

//新建创造模式物品栏窗口
public class rawOreTabs extends CreativeTabs {

    public static final List<Item> ITEMS = new ArrayList<>();

    public static final rawOreTabs RAW_ORE = new rawOreTabs(/*分类名称*/"rawOreTabs");

    private rawOreTabs(String label) {
        super(label);
    }

    @Override
    public ItemStack getTabIconItem() {
        //设置分类窗口的图标
        return new ItemStack(ItemBase.RAW_GOLD);
    }

    @Override
    public void displayAllRelevantItems(NonNullList<ItemStack> items) {
        //修改物品栏
        super.displayAllRelevantItems(items);

        for (Item item : ItemBase.ITEMS) {
            items.add(new ItemStack(item));
        }
    }

    public static void Inventory() {
        /*修改物品栏*/RAW_ORE.displayAllRelevantItems(NonNullList.create());
    }
}
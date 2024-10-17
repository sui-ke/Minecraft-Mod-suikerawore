package suike.suikerawore.expand.vicswarfare;

import suike.suikerawore.SuiKe;
import suike.suikerawore.item.ItemBase;

import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import net.minecraftforge.fml.common.registry.GameRegistry;

//维克的现代战争
public class VicSWarfareExpand {
    public static void expand() {
        /*铜*/register("mw:copperingot", ItemBase.INGOT_COPPER);
    }

//配方注册
    public static void register(String itemName, Item myItem) {
        //获取物品注册名
        String name = itemName.replaceAll(".*:", "").trim();

        ItemStack itemStack = new ItemStack(Item.getByNameOrId(itemName));
        ItemStack myItemStack = new ItemStack(myItem);

        if (ItemBase.isValidItemStack(itemStack)) {
            GameRegistry.addShapedRecipe(
                new ResourceLocation(SuiKe.MODID, name +"-1"),//配方标识符
                new ResourceLocation(SuiKe.MODID),//分组名
                myItemStack, 
                "A",
                'A', itemStack
            );

            GameRegistry.addShapedRecipe(
                new ResourceLocation(SuiKe.MODID, name +"-2"),//配方标识符
                new ResourceLocation(SuiKe.MODID),//分组名
                itemStack, 
                "A",
                'A', myItemStack
            );
        }
    }
}
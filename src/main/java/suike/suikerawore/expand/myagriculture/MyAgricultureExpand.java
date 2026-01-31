package suike.suikerawore.expand.myagriculture;

import java.util.*;

import suike.suikerawore.SuiKe;
import suike.suikerawore.item.*;
import suike.suikerawore.expand.ExpandMod;

import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import net.minecraftforge.fml.common.registry.GameRegistry;

// 神秘农业
public class MyAgricultureExpand extends ExpandMod {

    @Override
    protected String value() {
        return "mysticalagriculture";
    }

    @Override
    protected void expand(ModItemRawOre rawOre) {
        String elementType = rawOre.getElementType();
        this.register(this.getEssence(elementType), rawOre.getRefinedItemStack(), elementType);
    }

    private ItemStack getEssence(String elementType) {
        Item item = Item.getByNameOrId("mysticalagriculture:" + elementType + "_essence");
        if (item == null) {
            item = Item.getByNameOrId("mysticalagriculture:" + elementType.replace("inium", "inum") + "_essence");
        }
        if (item == null) {
            item = Item.getByNameOrId("mysticalagradditions:" + elementType + "_essence");
        }
        if (item == null) {
            item = Item.getByNameOrId("mysticalagradditions:" + elementType.replace("inium", "inum") + "_essence");
        }
        if (item != null) {
            return new ItemStack(item);
        }
        return ItemBase.oreStack("essence" + elementType);
    }

// 配方注册
    private void register(ItemStack input, ItemStack output, String elementType) {
        if (ItemBase.isValidItemStack(input, output)) {
            output.setCount(4); // 设置数量

            GameRegistry.addShapedRecipe(
                new ResourceLocation(SuiKe.MODID, elementType + "essence_make_ingot"),
                new ResourceLocation(SuiKe.MODID),
                output, 
                "AAA",
                "ABA",
                "AAA",
                'A', input,
                'B', ItemStack.EMPTY
            );
        }
    }
}
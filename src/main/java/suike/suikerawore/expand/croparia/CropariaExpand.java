package suike.suikerawore.expand.croparia;

import java.util.*;

import suike.suikerawore.SuiKe;
import suike.suikerawore.item.*;
import suike.suikerawore.expand.ExpandMod;

import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import net.minecraftforge.fml.common.registry.GameRegistry;

// 矿石作物
public class CropariaExpand extends ExpandMod {

    @Override
    protected String value() {
        return "croparia";
    }

    @Override
    protected void expand(ModItemRawOre rawOre) {
        String elementType = rawOre.getElementType();
        this.register(this.getEssence(elementType), rawOre.getRefinedItemStack(), elementType);
    }

    private ItemStack getEssence(String elementType) {
        Item item = Item.getByNameOrId("croparia:fruit_" + elementType);
        if (item == null) {
            item = Item.getByNameOrId("croparia:fruit_" + elementType.replace("inium", "inum"));
        }
        if (item == null) {
            item = Item.getByNameOrId("croparia:fruit_" + elementType.replace("ium", "e"));
        }
        if (item != null) {
            return new ItemStack(item);
        }
        return ItemBase.oreStack("fruit" + elementType);
    }

// 配方注册
    private void register(ItemStack input, ItemStack output, String elementType) {
        if (ItemBase.isValidItemStack(input, output)) {
            output.setCount(2); // 设置数量

            GameRegistry.addShapedRecipe(
                new ResourceLocation(SuiKe.MODID, elementType + "fruit_make_ingot"),
                new ResourceLocation(SuiKe.MODID),
                output, 
                "A",
                'A', input
            );
        }
    }
}
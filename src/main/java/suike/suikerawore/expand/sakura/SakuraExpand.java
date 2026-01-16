package suike.suikerawore.expand.sakura;

import suike.suikerawore.SuiKe;
import suike.suikerawore.item.ItemBase;
import suike.suikerawore.expand.ExpandMod;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SakuraExpand extends ExpandMod {

    @Override
    protected String value() {
        return "sakura";
    }

    @Override
    protected void expandOnce() {
        ItemStack outputStack = new ItemStack(Item.getByNameOrId("sakura:tatara"));
        ItemStack blockCharcoal = new ItemStack(Item.getByNameOrId("sakura:bamboo_charcoal_block"));
        NonNullList<ItemStack> stackList = OreDictionary.getOres("toolForginghammer");

        if (ItemBase.isValidItemStack(outputStack, blockCharcoal) && !stackList.isEmpty()) {
            for (ItemStack toolForg : stackList) {
                GameRegistry.addShapelessRecipe(
                    new ResourceLocation(SuiKe.MODID, toolForg.toString()),
                    new ResourceLocation(SuiKe.MODID),
                    outputStack,
                    Ingredient.fromItem(ItemBase.RAW_IRON),
                    Ingredient.fromItem(blockCharcoal.getItem()),
                    Ingredient.fromItem(toolForg.getItem())
                );

                GameRegistry.addShapelessRecipe(
                    new ResourceLocation(SuiKe.MODID, toolForg.toString()),
                    new ResourceLocation(SuiKe.MODID),
                    outputStack,
                    Ingredient.fromItem(ItemBase.RAW_IRON),
                    Ingredient.fromItem(Item.getByNameOrId("minecraft:coal_block")),
                    Ingredient.fromItem(toolForg.getItem())
                );
            }
        }
    }
}
package suike.suikerawore.recipe;

import java.util.*;
import java.lang.reflect.Field;

import suike.suikerawore.item.*;

import thedarkcolour.futuremc.recipe.SimpleRecipe;
import thedarkcolour.futuremc.recipe.furnace.BlastFurnaceRecipes;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.ResourceLocation;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistryModifiable;
import net.minecraftforge.oredict.OreDictionary;

// 删除工作台, 熔炉和高炉的锭配方
public class RemoveIngotRecipe {

    private final List<ItemStack> removeRecipeItems = new ArrayList<>();
    private final List<ItemStack> removeRecipeIngot = new ArrayList<>();

    public void remove() {
        for (Map.Entry<String, ModItemRawOre> mapEntry : ModItemRawOre.TYPE_TO_RAW_ORE.entrySet()) {
            ModItemRawOre rawOre = mapEntry.getValue();
            if (rawOre.isValid()) {
                this.collectRecipe(rawOre.getElementType());
            }
        }

        if(!this.removeRecipeItems.isEmpty()) {
            // 移除工作台配方
            this.removeCraftRecipe();
            // 移除熔炉配方
            this.removeSmeltingRecipes();
            if (Loader.isModLoaded("futuremc")) {
                this.removeBlastFurnaceRecipes();
            }
        }
    }

// 获取需要移除的物品
    private void collectRecipe(String type) {
        // 定义矿词前缀
        String[] prefixes = {"ingot", "nugget", "block"};

        // 遍历每个前缀
        for (String prefix : prefixes) {
            List<ItemStack> itemStackList = OreDictionary.getOres(prefix + type);
            // 遍历物品列表
            for (ItemStack itemStack : itemStackList) {
                // 检查itemStack是否有效
                if (ItemBase.isValidItemStack(itemStack)) {
                    this.removeRecipeItems.add(itemStack);
                    if ("ingot".equals(prefix)) {
                        this.removeRecipeIngot.add(itemStack);
                    }
                }
            }
        }
    }

// 移除工作台配方
    private void removeCraftRecipe() {
        // 获取当前注册的配方注册表
        IForgeRegistryModifiable<IRecipe> modRegistry = (IForgeRegistryModifiable<IRecipe>) GameRegistry.findRegistry(IRecipe.class);
        // 收集要移除的配方
        List<ResourceLocation> recipesToRemove = new ArrayList<>();

        // 遍历并标记包含矿词物品的配方
        for (IRecipe recipe : modRegistry) {
            for (ItemStack item : this.removeRecipeItems) {
                if (ItemStack.areItemsEqual(recipe.getRecipeOutput(), item)) {
                    recipesToRemove.add(recipe.getRegistryName());
                    break;
                }
            }
        }

        // 移除标记的配方
        for (ResourceLocation recipeName : recipesToRemove) {
            modRegistry.remove(recipeName);
        }
    }

// 移除熔炉配方
    private void removeSmeltingRecipes() {
        // 获取当前熔炉配方
        Map<ItemStack, ItemStack> smeltingList = FurnaceRecipes.instance().getSmeltingList();
        // 收集要移除的配方
        List<ItemStack> recipesToRemove = new ArrayList<>();

        // 遍历并标记包含矿词物品的配方
        for (Map.Entry<ItemStack, ItemStack> entry : smeltingList.entrySet()) {
            for (ItemStack item : this.removeRecipeIngot) {
                if (ItemStack.areItemsEqual(entry.getValue(), item)) {
                    recipesToRemove.add(entry.getKey());
                    break;
                }
            }
        }

        // 移除标记的配方
        for (ItemStack input : recipesToRemove) {
            smeltingList.remove(input);
        }
    }

// 移除高炉配方
    private void removeBlastFurnaceRecipes() {
        try {
            // 访问 BlastFurnaceRecipes 类的 recipes (配方)
            Field recipesField = BlastFurnaceRecipes.class.getDeclaredField("recipes");
            recipesField.setAccessible(true);
            ArrayList<SimpleRecipe> recipes = (ArrayList<SimpleRecipe>) recipesField.get(BlastFurnaceRecipes.INSTANCE);
            // 访问 SimpleRecipe 类的 output (输出物)
            Field outputField = SimpleRecipe.class.getDeclaredField("output");
            outputField.setAccessible(true);
            // 收集要移除的配方
            List<SimpleRecipe> recipesToRemove = new ArrayList<>();

            // 遍历并标记包含矿词物品的配方
            for (SimpleRecipe recipe : recipes) {
                for (ItemStack item : this.removeRecipeIngot) {
                    if (ItemStack.areItemsEqual((ItemStack) outputField.get(recipe), item)) {
                        recipesToRemove.add(recipe);
                        break;
                    }
                }
            }

            // 移除标记的配方
            recipes.removeAll(recipesToRemove);
        } catch (Throwable e) {}
    }
}
package suike.suikerawore.recipe;

import java.util.Set;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;
import java.util.ArrayList;
import java.lang.reflect.Field;

import suike.suikerawore.item.ItemBase;
import suike.suikerawore.expand.Examine;
import suike.suikerawore.config.ConfigValue;

import thedarkcolour.futuremc.recipe.SimpleRecipe;
import thedarkcolour.futuremc.recipe.furnace.BlastFurnaceRecipes;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.ResourceLocation;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistryModifiable;

//删除工作台, 熔炉和高炉配方
public class RemoveRecipe {

    public static Set<ItemStack> noRemove = new HashSet<>();
    public static List<ItemStack> itemList = new ArrayList<>();

    public static void remove() {
        /*添加物品到列表*/itemListAdd();

        /*移除熔炉配方*/removeSmeltingRecipes();
        if (Examine.FuturemcID) {
            /*移除高炉配方*/removeBlastFurnaceRecipes();
        }
        /*移除工作台配方*/removeCraftRecipe();

        itemList.clear();
    }

//添加物品的类型
    public static void itemListAdd() {
        //删除打开的类型的配方
        /*排除元素列表*/String[] types = {"gold", "iron", "beryllium", "irradium", "palladium", "plutonium", "mithril", "rutile"};

        //遍历 粗矿是否启用 列表
        for (Map.Entry<String, Boolean> entry : ConfigValue.rawOreList.entrySet()) {
            String typeKey = entry.getKey().toLowerCase();

            if (Arrays.asList(types).contains(typeKey)) {
                continue;
            }

            //如果类型为打开就添加到物品列表
            if (entry.getValue()) {
                itemListAdd(typeKey);
            }
        }

        //试炼更新
        if (Examine.deeperdepthsID) {
            Item item = Item.getByNameOrId("deeperdepths:copper_ingot");
            itemList.add(new ItemStack(item));
            item = Item.getByNameOrId("deeperdepths:copper_blcok");
            itemList.add(new ItemStack(item));
        }
    }

//添加物品到列表
    public static void itemListAdd(String type) {
        type = type.substring(0, 1).toUpperCase() + type.substring(1);

        //定义矿词前缀
        String[] prefixes = {"ingot", "block"};

        //遍历每个前缀
        for (String prefix : prefixes) {
            List<ItemStack> itemStackList = OreDictionary.getOres(prefix + type);
            //遍历物品列表
            for (ItemStack itemStack : itemStackList) {
                //检查itemStack是否有效
                if (ItemBase.isValidItemStack(itemStack)) {
                    if (noRemove.contains(itemStack))
                        /*在排除列表内*/continue;

                    ResourceLocation registryName = itemStack.getItem().getRegistryName();
                    //排除本模组物品
                    if (registryName != null && !(registryName.getResourceDomain().equals("suikerawore"))) {
                        itemList.add(itemStack);
                    }
                }
            }
        }
    }

//移除熔炉配方
    public static void removeSmeltingRecipes() {
        //获取当前熔炉配方
        Map<ItemStack, ItemStack> smeltingList = FurnaceRecipes.instance().getSmeltingList();

        //收集要移除的配方
        List<ItemStack> recipesToRemove = new ArrayList<>();

        //遍历并标记包含矿词物品的配方
        for (Map.Entry<ItemStack, ItemStack> entry : smeltingList.entrySet()) {
            ItemStack output = entry.getValue();
            for (ItemStack oreItem : itemList) {
                if (ItemStack.areItemsEqual(output, oreItem)) {
                    recipesToRemove.add(entry.getKey());
                    break;
                }
            }
        }

        //移除标记的配方
        for (ItemStack input : recipesToRemove) {
            smeltingList.remove(input);
        }
    }

//移除高炉配方
    public static void removeBlastFurnaceRecipes() {
        try {
            //访问 BlastFurnaceRecipes 类的 recipes(配方)
            Field recipesField = BlastFurnaceRecipes.class.getDeclaredField("recipes");
            recipesField.setAccessible(true);//设置私有字段可访问
            ArrayList<SimpleRecipe> recipes = (ArrayList<SimpleRecipe>) recipesField.get(BlastFurnaceRecipes.INSTANCE);

            //访问 SimpleRecipe 类的 output(输出物)
            Field outputField = SimpleRecipe.class.getDeclaredField("output");
            outputField.setAccessible(true);//设置私有字段可访问

            //收集要移除的配方
            List<SimpleRecipe> recipesToRemove = new ArrayList<>();

            //遍历并标记包含矿词物品的配方
            for (SimpleRecipe recipe : recipes) {
                ItemStack output = (ItemStack) outputField.get(recipe);
                for (ItemStack oreItem : itemList) {
                    if (ItemStack.areItemsEqual(output, oreItem)) {
                        recipesToRemove.add(recipe);
                        break;
                    }
                }
            }

            //移除标记的配方
            recipes.removeAll(recipesToRemove);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

//移除工作台配方
    public static void removeCraftRecipe() {
        //获取当前注册的配方注册表
        IForgeRegistryModifiable<IRecipe> modRegistry = (IForgeRegistryModifiable<IRecipe>) GameRegistry.findRegistry(IRecipe.class);

        //收集要移除的配方
        List<ResourceLocation> recipesToRemove = new ArrayList<>();

        //工作台单独需要删除的配方
        /*铝粒*/itemList.addAll(OreDictionary.getOres("nuggetAluminum"));

        //遍历并标记包含矿词物品的配方
        for (IRecipe recipe : modRegistry) {
            ItemStack output = recipe.getRecipeOutput();
            for (ItemStack oreItem : itemList) {
                if (ItemStack.areItemsEqual(output, oreItem)) {
                    recipesToRemove.add(recipe.getRegistryName());
                    break;
                }
            }
        }

        //移除标记的配方
        for (ResourceLocation recipeName : recipesToRemove) {
            modRegistry.remove(recipeName);
        }
    }
}
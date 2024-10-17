package suike.suikerawore.expand.thaumcraft;

import suike.suikerawore.item.ItemBase;

import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

//坩埚配方
public class CrucibleRecipe {
    public static void register() {
        /*金原矿簇*/register(ItemBase.RAW_GOLD, "thaumcraft:cluster", 1);
        /*铁原矿簇*/register(ItemBase.RAW_IRON, "thaumcraft:cluster", 0);
        /*铜原矿簇*/register(ItemBase.RAW_COPPER, "thaumcraft:cluster", 2);
        /*锡原矿簇*/register(ItemBase.RAW_TIN, "thaumcraft:cluster", 3);
        /*铅原矿簇*/register(ItemBase.RAW_LEAD, "thaumcraft:cluster", 5);
        /*银原矿簇*/register(ItemBase.RAW_SILVER, "thaumcraft:cluster", 4);
        /*朱砂矿簇*/register(ItemBase.RAW_CINNABAR, "thaumcraft:cluster", 6);
    }

    //注册坩埚配方配方-输出需要元数据
    public static void register(Item input, String outputName, int outputMeta) {
        //字符串转ItemStack
        ItemStack output = new ItemStack(Item.getByNameOrId(outputName), 1, outputMeta);

        //源质
        AspectList inputAspects = new AspectList().merge(Aspect.METAL, 5).merge(Aspect.ORDER, 5);

        //构造CrucibleRecipe对象
        thaumcraft.api.crafting.CrucibleRecipe recipe = new thaumcraft.api.crafting.CrucibleRecipe("METALPURIFICATION", output, new ItemStack(input), inputAspects);

        //配方名
        ResourceLocation recipeName = new ResourceLocation(input.getRegistryName().toString().replaceAll(".*:", "").trim() + ">clusters");

        //注册配方
        ThaumcraftApi.addCrucibleRecipe(recipeName, recipe);
    }
}
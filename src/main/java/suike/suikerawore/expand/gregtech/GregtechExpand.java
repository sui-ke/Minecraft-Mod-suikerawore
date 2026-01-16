package suike.suikerawore.expand.gregtech;

import java.util.*;

import suike.suikerawore.item.*;
import suike.suikerawore.expand.ExpandMod;
import suike.suikerawore.data.ByProductData;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.RecipeBuilder;

public class GregtechExpand extends ExpandMod {

    @Override
    protected String value() {
        return "gregtech";
    }

    @Override
    protected void expand(ModItemRawOre rawOre) {
        ByProductData data = rawOre.getByProductData();
        this.register(rawOre, data.getProducts(), data.getChances());
    }

    private void register(ModItemRawOre rawOre, String[] outputOreDicts, Float[] outputChances) {
        ItemStack inputStack = new ItemStack(rawOre);
        ItemStack outputStack = ItemBase.oreStack("crushed" + rawOre.getElementType(), outputChances[0].intValue());
        if (!ItemBase.isValidItemStack(inputStack, outputStack)) return;

        // 输出物列表
        List<OutputData> chancedOutputs = new ArrayList<>();

        // 遍历输出名称列表，创建对应的 ItemStack
        for (int i = 1; i < outputOreDicts.length; i++) {
            if (outputOreDicts[i].startsWith("dust")) {
                ItemStack byProductOutput = ItemBase.oreStack(outputOreDicts[i]);

                if (ItemBase.isValidItemStack(byProductOutput)) {
                    float chanceBoost = outputChances[i] < 0.1F ? 0.015F : 0.085F;
                    chancedOutputs.add(new OutputData(byProductOutput, outputChances[i], chanceBoost));
                }
            }
        }

        // 锻造机配方
        RecipeMaps.FORGE_HAMMER_RECIPES.recipeBuilder().inputs(inputStack).outputs(outputStack).duration(400).EUt(2).buildAndRegister();
        // 创建 RecipeBuilder
        RecipeBuilder<?> builder = RecipeMaps.MACERATOR_RECIPES.recipeBuilder().inputs(inputStack).outputs(outputStack).duration(400).EUt(2);

        // 添加概率输出
        for (OutputData output : chancedOutputs) {
            builder.chancedOutput(output.getItem(), output.getChance(), output.getBoost());
        }
        // 注册研磨机配方
        builder.buildAndRegister();
    }

    private class OutputData {
        private ItemStack item;
        private int chance;
        private int chanceBoost;

        public OutputData(ItemStack item, float chance, float chanceBoost) {
            this.item = item;
            this.chance = (int) (chance * 10000);
            this.chanceBoost = (int) (chanceBoost * 10000);
        }

        public ItemStack getItem() {
            return this.item;
        }

        public int getChance() {
            return this.chance;
        }

        public int getBoost() {
            return this.chanceBoost;
        }
    }
}
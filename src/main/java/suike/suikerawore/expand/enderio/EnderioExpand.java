package suike.suikerawore.expand.enderio;

import java.util.*;

import suike.suikerawore.item.*;
import suike.suikerawore.expand.ExpandMod;
import suike.suikerawore.data.ByProductData;

import crazypants.enderio.base.recipe.Recipe;
import crazypants.enderio.base.recipe.RecipeLevel;
import crazypants.enderio.base.recipe.RecipeInput;
import crazypants.enderio.base.recipe.RecipeOutput;
import crazypants.enderio.base.recipe.RecipeBonusType;
import crazypants.enderio.base.recipe.sagmill.SagMillRecipeManager;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

// 末影接口
public class EnderioExpand extends ExpandMod {

    private Boolean isNewVersion = null;

    @Override
    protected String value() {
        return "enderio";
    }

    @Override
    protected void expand(ModItemRawOre rawOre) {
        // SAG磨粉机配方
        ByProductData data = rawOre.getByProductData();
        this.register(new ItemStack(rawOre), data.getProducts(), data.getChances());
    }

    private void register(ItemStack input, String[] outputOreDicts, Float[] outputChances) {
        List<RecipeOutput> outputs = new ArrayList<>();
        // 先添加主输出物 (第一个概率为主输出物数量)
        outputs.add(new RecipeOutput(ItemBase.oreStack(outputOreDicts[0], outputChances[0].intValue()), 1.0F));

        // 添加副产物
        for (int i = 1; i < outputOreDicts.length; i++) {
            ItemStack output = ItemBase.oreStack(outputOreDicts[i]);
            if (ItemBase.isValidItemStack(output)) {
                outputs.add(new RecipeOutput(output, outputChances[i]));
            }
        }

        if (!outputs.isEmpty()) {
            if (this.isNewVersion == null) {
                this.tryRegister(input, outputs);
            } else if (this.isNewVersion) {
                SagMillRecipeRegister.register(input, outputs);
            } else {
                SagMillRecipeRegisterOld.register(input, outputs);
            }
        }
    }

    private void tryRegister(ItemStack input, List<RecipeOutput> outputs) {
        try {
            SagMillRecipeRegister.register(input, outputs);
            this.isNewVersion = true;
        } catch (Throwable e1) {
            try {
                SagMillRecipeRegisterOld.register(input, outputs);
                this.isNewVersion = false;
            } catch (Throwable e2) {
                throw new IllegalArgumentException("[RawOre]{SagMillRecipe} Incompatible Enderio Version");
            }
        }
    }
}
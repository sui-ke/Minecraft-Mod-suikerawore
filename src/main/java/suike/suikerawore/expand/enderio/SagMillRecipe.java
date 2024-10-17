package suike.suikerawore.expand.enderio;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import suike.suikerawore.item.ItemBase;

import crazypants.enderio.base.recipe.Recipe;
import crazypants.enderio.base.recipe.RecipeInput;
import crazypants.enderio.base.recipe.RecipeBonusType;
import crazypants.enderio.base.recipe.RecipeLevel;
import crazypants.enderio.base.recipe.RecipeOutput;
import crazypants.enderio.base.recipe.sagmill.SagMillRecipeManager;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

//SAG磨粉机
public class SagMillRecipe {
    public static void register() {
        //                 输入物;                            输出物列表;               输出物数量;            输出物概率
        /*金*/register(ItemBase.RAW_GOLD, Arrays.asList("dustGold", "dustCopper"), Arrays.asList(2, 1), Arrays.asList(1F, 0.2F));
        /*铁*/register(ItemBase.RAW_IRON, Arrays.asList("dustIron", "dustTin", "dustNickel"), Arrays.asList(2, 1, 1), Arrays.asList(1F, 0.05F, 0.1F));
        /*铜*/register(ItemBase.RAW_COPPER, Arrays.asList("dustCopper", "dustGold"), Arrays.asList(2, 1), Arrays.asList(1F, 0.12F));
        /*锡*/register(ItemBase.RAW_TIN, Arrays.asList("dustTin", "dustIron"), Arrays.asList(2, 1), Arrays.asList(1F, 0.1F));
        /*锌*/register(ItemBase.RAW_ZINC, Arrays.asList("dustZinc"), Arrays.asList(2), Arrays.asList(1F));
        /*铅*/register(ItemBase.RAW_LEAD, Arrays.asList("dustLead", "dustSilver"), Arrays.asList(2, 1), Arrays.asList(1F, 0.1F));
        /*银*/register(ItemBase.RAW_SILVER, Arrays.asList("dustSilver", "dustLead"), Arrays.asList(2, 1), Arrays.asList(1F, 0.1F));
        /*钴*/register(ItemBase.RAW_COBALT, Arrays.asList("dustCobalt"), Arrays.asList(2), Arrays.asList(1F));
        /*锇*/register(ItemBase.RAW_OSMIUM, Arrays.asList("dustOsmium", "dustOsmium"), Arrays.asList(2, 1), Arrays.asList(1F, 0.1F));
        /*镍*/register(ItemBase.RAW_NICKEL, Arrays.asList("dustNickel", "dustPlatinum"), Arrays.asList(2, 1), Arrays.asList(1F, 0.1F));
        /*铱*/register(ItemBase.RAW_IRIDIUM, Arrays.asList("dustIridium"), Arrays.asList(2), Arrays.asList(1F));
        /*铀*/register(ItemBase.RAW_URANIUM, Arrays.asList("dustUranium"), Arrays.asList(2), Arrays.asList(1F));
        /*镓*/register(ItemBase.RAW_GALLIUM, Arrays.asList("dustGallium"), Arrays.asList(2), Arrays.asList(1F));
        /*钛*/register(ItemBase.RAW_TITANIUM, Arrays.asList("dustTitanium"), Arrays.asList(2), Arrays.asList(1F));
        /*铂*/register(ItemBase.RAW_PLATINUM, Arrays.asList("dustPlatinum", "dustPlatinum"), Arrays.asList(2, 1), Arrays.asList(1F, 0.1F));
        /*钨*/register(ItemBase.RAW_TUNGSTEN, Arrays.asList("dustTungsten"), Arrays.asList(2), Arrays.asList(1F));
        /*铝*/register(ItemBase.RAW_ALUMINIUM, Arrays.asList("dustAluminium", "dustIron"), Arrays.asList(2, 1), Arrays.asList(1F, 0.1F));
        /*镁*/register(ItemBase.RAW_MAGNESIUM, Arrays.asList("dustMagnesium"), Arrays.asList(2), Arrays.asList(1F));
        /*锂*/register(ItemBase.RAW_LITHIUM, Arrays.asList("dustLithium"), Arrays.asList(2), Arrays.asList(1F));
        /*钍*/register(ItemBase.RAW_THORIUM, Arrays.asList("dustThorium"), Arrays.asList(2), Arrays.asList(1F));
        /*硼*/register(ItemBase.RAW_BORON, Arrays.asList("dustBoron"), Arrays.asList(2), Arrays.asList(1F));
        /*钒*/register(ItemBase.RAW_VANADIUM, Arrays.asList("dustVanadium"), Arrays.asList(2), Arrays.asList(1F));
        /*镉*/register(ItemBase.RAW_CADMIUM, Arrays.asList("dustCadmium"), Arrays.asList(2), Arrays.asList(1F));
        /*锰*/register(ItemBase.RAW_MANGANESE, Arrays.asList("dustManganese"), Arrays.asList(2), Arrays.asList(1F));
        /*锗*/register(ItemBase.RAW_GERMANIUM, Arrays.asList("dustGermanium"), Arrays.asList(2), Arrays.asList(1F));
        /*铬*/register(ItemBase.RAW_CHROMIUM, Arrays.asList("dustChromium"), Arrays.asList(2), Arrays.asList(1F));
        /*砷*/register(ItemBase.RAW_ARSENIC, Arrays.asList("dustArsenic"), Arrays.asList(2), Arrays.asList(1F));

        /*阿迪特*/register(ItemBase.RAW_ARDITE, Arrays.asList("dustArdite"), Arrays.asList(2), Arrays.asList(1F));
        /* 晶蓝 */register(ItemBase.RAW_CERULEAN, Arrays.asList("dustCerulean"), Arrays.asList(2), Arrays.asList(1F));
        /*皎月石*/register(ItemBase.RAW_MOONSTONE, Arrays.asList("dustMoonstone"), Arrays.asList(2), Arrays.asList(1F));
        /*炽炎铁*/register(ItemBase.RAW_OCTINE, Arrays.asList("dustOctine"), Arrays.asList(2), Arrays.asList(1F));
        /*赛摩铜*/register(ItemBase.RAW_SYRMORITE, Arrays.asList("dustSyrmorite"), Arrays.asList(2), Arrays.asList(1F));
        /* 朱砂 */register(ItemBase.RAW_CINNABAR, Arrays.asList("dustCinnabar"), Arrays.asList(2), Arrays.asList(1F));
        /*软碲铜*/register(ItemBase.RAW_VULCANITE, Arrays.asList("dustVulcanite"), Arrays.asList(2), Arrays.asList(1F));
        /* 裂金 */register(ItemBase.RAW_CHASMIUM, Arrays.asList("dustChasmium"), Arrays.asList(2), Arrays.asList(1F));
    }

    public static void register(Item inputItem, List<String> outputNameList, List<Integer> outputAmount, List<Float> outputChance) {
        /*输入物*/ItemStack inputStack = new ItemStack(inputItem);

        /*输出物列表*/List<RecipeOutput> outputList = new ArrayList<>();

        //遍历输出名称列表，创建对应的 ItemStack
        for (int i = 0; i < outputNameList.size(); i++) {
            /*获取输出名*/String outputName = outputNameList.get(i);
            /*获取输出量*/int amount = outputAmount.get(i);
            /*获取概率*/float chance = outputChance.get(i);

            /*获取输出物的ItemStack*/ItemStack outputStack = ItemBase.oreStack(outputName, amount);

            if (ItemBase.isValidItemStack(outputStack)) {//检查outputStack是否为空

                /*添加到输出物列表*/outputList.add(new RecipeOutput(outputStack, chance));
            }
        }

        if (ItemBase.isValidItemStack(inputStack) && (!outputList.isEmpty())) {
        //注册配方
            SagMillRecipeManager.getInstance().addRecipe(
                new Recipe(
                    new RecipeInput(inputStack),//输入物品
                    2000,//需要的能量
                    RecipeBonusType.MULTIPLY_OUTPUT,//奖励类型
                    RecipeLevel.IGNORE,//配方等级
                    outputList.toArray(new RecipeOutput[0])//输出物品数组
                )
            );
        }
    }
}
package suike.suikerawore.expand.enderio;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import suike.suikerawore.item.ItemBase;

import crazypants.enderio.base.recipe.Recipe;
import crazypants.enderio.base.recipe.RecipeLevel;
import crazypants.enderio.base.recipe.RecipeInput;
import crazypants.enderio.base.recipe.RecipeOutput;
import crazypants.enderio.base.recipe.RecipeBonusType;
import crazypants.enderio.base.recipe.sagmill.SagMillRecipeManager;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

//SAG磨粉机
public class SagMillRecipe {
    public static void register() {
        // 格式：register(输入物, 输出物列表, 输出数量, 输出概率);

        // 金 - 可能含铜, 银
        register(ItemBase.RAW_GOLD,
            Arrays.asList("dustGold", "dustCopper", "dustSilver"),
            Arrays.asList(2, 1, 1),
            Arrays.asList(1F, 0.2F, 0.15F));

        // 铁 - 可能含镍, 钴, 极低概率含锂
        register(ItemBase.RAW_IRON,
            Arrays.asList("dustIron", "dustNickel", "dustCobalt", "dustLithium"),
            Arrays.asList(2, 1, 1, 1),
            Arrays.asList(1F, 0.1F, 0.05F, 0.03F));

        // 铜 - 可能含金, 钼
        register(ItemBase.RAW_COPPER,
            Arrays.asList("dustCopper", "dustGold", "dustMolybdenum"),
            Arrays.asList(2, 1, 1),
            Arrays.asList(1F, 0.12F, 0.08F));

        // 锡 - 可能含铁, 锂
        register(ItemBase.RAW_TIN,
            Arrays.asList("dustTin", "dustIron", "dustLithium"),
            Arrays.asList(2, 1, 1),
            Arrays.asList(1F, 0.1F, 0.05F));

        // 锌 - 可能含镓, 镉
        register(ItemBase.RAW_ZINC,
            Arrays.asList("dustZinc", "dustGallium", "dustCadmium"), 
            Arrays.asList(2, 1, 1),
            Arrays.asList(1F, 0.1F, 0.15F));

        // 铅 - 可能含银, 铋
        register(ItemBase.RAW_LEAD,
            Arrays.asList("dustLead", "dustSilver", "dustBismuth"), 
            Arrays.asList(2, 1, 1),
            Arrays.asList(1F, 0.1F, 0.07F));

        // 银 - 可能含铅, 砷
        register(ItemBase.RAW_SILVER,
            Arrays.asList("dustSilver", "dustLead", "dustArsenic"), 
            Arrays.asList(2, 1, 1),
            Arrays.asList(1F, 0.1F, 0.05F));

        // 钴 - 镍钴矿常共生, 可能含铜, 铁
        register(ItemBase.RAW_COBALT,
            Arrays.asList("dustCobalt", "dustNickel", "dustCopper", "dustIron"),
            Arrays.asList(2, 1, 1, 1),
            Arrays.asList(1F, 0.3F, 0.2F, 0.15F));

        // 锇 - 铂族金属，常与铱共生
        register(ItemBase.RAW_OSMIUM,
            Arrays.asList("dustOsmium", "dustIridium", "dustPlatinum"),
            Arrays.asList(2, 1, 1),
            Arrays.asList(1F, 0.25F, 0.1F));

        // 镍 - 镍钴矿常共生, 低概率铂
        register(ItemBase.RAW_NICKEL,
            Arrays.asList("dustNickel", "dustCobalt", "dustPlatinum"), 
            Arrays.asList(2, 1, 1),
            Arrays.asList(1F, 0.2F, 0.1F));

        // 铱 - 可能含锇, 钌
        register(ItemBase.RAW_IRIDIUM,
            Arrays.asList("dustIridium", "dustOsmium", "dustRuthenium"),
            Arrays.asList(2, 1, 1),
            Arrays.asList(1F, 0.2F, 0.15F));

        // 铀 - 可能含钍, 稀土
        register(ItemBase.RAW_URANIUM,
            Arrays.asList("dustUranium", "dustThorium", "dustRareEarth"), 
            Arrays.asList(2, 1, 1),
            Arrays.asList(1F, 0.15F, 0.1F));

        // 镓 - 可能含铝, 锌
        register(ItemBase.RAW_GALLIUM,
            Arrays.asList("dustGallium", "dustAluminium", "dustZinc"),
            Arrays.asList(2, 1, 1),
            Arrays.asList(1F, 0.3F, 0.1F));

        // 钛 - 可能含含钒, 铁
        register(ItemBase.RAW_TITANIUM,
            Arrays.asList("dustTitanium", "dustVanadium", "dustIron"), 
            Arrays.asList(2, 1, 1),
            Arrays.asList(1F, 0.15F, 0.1F));

        // 铂 - 可能含钯, 铱
        register(ItemBase.RAW_PLATINUM,
            Arrays.asList("dustPlatinum", "dustPalladium", "dustIridium"), 
            Arrays.asList(2, 1, 1),
            Arrays.asList(1F, 0.2F, 0.1F));

        // 钨 - 可能含锡, 钼
        register(ItemBase.RAW_TUNGSTEN,
            Arrays.asList("dustTungsten", "dustTin", "dustMolybdenum"), 
            Arrays.asList(2, 1, 1),
            Arrays.asList(1F, 0.1F, 0.1F));

        // 铝 - 可能含铁, 钛, 极低概率含锂
        register(ItemBase.RAW_ALUMINIUM,
            Arrays.asList("dustAluminium", "dustIron", "dustTitanium", "dustLithium"), 
            Arrays.asList(2, 1, 1, 1),
            Arrays.asList(1F, 0.1F, 0.1F, 0.03F));

        // 镁 - 可能含钙, 锂
        register(ItemBase.RAW_MAGNESIUM,
            Arrays.asList("dustMagnesium", "dustCalcium", "dustLithium"),
            Arrays.asList(2, 1, 1),
            Arrays.asList(1F, 0.2F, 0.05F));

        // 锂 - 可能含铝, 硼
        register(ItemBase.RAW_LITHIUM,
            Arrays.asList("dustLithium", "dustAluminium", "dustBoron"), 
            Arrays.asList(2, 1, 1),
            Arrays.asList(1F, 0.1F, 0.05F));

        // 钍 - 可能含稀土, 铀
        register(ItemBase.RAW_THORIUM,
            Arrays.asList("dustThorium", "dustRareEarth", "dustUranium"),
            Arrays.asList(2, 1, 1),
            Arrays.asList(1F, 0.25F, 0.15F));

        // 硼 - 可能含钠, 钙
        register(ItemBase.RAW_BORON,
            Arrays.asList("dustBoron", "dustSodium", "dustCalcium"),
            Arrays.asList(2, 1, 1),
            Arrays.asList(1F, 0.2F, 0.2F));

        // 钒 - 可能含钛, 铁
        register(ItemBase.RAW_VANADIUM,
            Arrays.asList("dustVanadium", "dustTitanium", "dustIron"),
            Arrays.asList(2, 1, 1),
            Arrays.asList(1F, 0.3F, 0.25F));

        // 镉 - 可能含锌, 铜
        register(ItemBase.RAW_CADMIUM,
            Arrays.asList("dustCadmium", "dustZinc", "dustCopper"),
            Arrays.asList(2, 1, 1),
            Arrays.asList(1F, 0.4F, 0.1F));

        // 锰 - 可能含铁, 钴共生
        register(ItemBase.RAW_MANGANESE,
            Arrays.asList("dustManganese", "dustIron", "dustCobalt"),
            Arrays.asList(2, 1, 1),
            Arrays.asList(1F, 0.3F, 0.15F));

        // 锗 - 可能含铅, 锌
        register(ItemBase.RAW_GERMANIUM,
            Arrays.asList("dustGermanium", "dustLead", "dustZinc"),
            Arrays.asList(2, 1, 1),
            Arrays.asList(1F, 0.2F, 0.2F));

        // 铬 - 可能含铁, 镍
        register(ItemBase.RAW_CHROMIUM,
            Arrays.asList("dustChromium", "dustIron", "dustNickel"),
            Arrays.asList(2, 1, 1),
            Arrays.asList(1F, 0.3F, 0.1F));

        // 砷 - 可能含硫, 锑
        register(ItemBase.RAW_ARSENIC,
            Arrays.asList("dustArsenic", "dustSulfur", "dustAntimony"),
            Arrays.asList(2, 1, 1),
            Arrays.asList(1F, 0.4F, 0.15F));

        // 铍 - 可能含铝, 锂
        register(ItemBase.RAW_BERYLLIUM,
            Arrays.asList("dustBeryllium", "dustAluminium", "dustLithium"),
            Arrays.asList(2, 1, 1),
            Arrays.asList(1F, 0.2F, 0.1F));

        // 镭 - 过于稀有
        register(ItemBase.RAW_IRRADIUM,
            Arrays.asList("dustIrradium", "dustIrradium"),
            Arrays.asList(1, 1),
            Arrays.asList(1F, 0.03F));

        // 钯矿 - 铂族金属，常与镍共生
        register(ItemBase.RAW_PALLADIUM,
            Arrays.asList("dustPalladium", "dustNickel", "dustPlatinum"),
            Arrays.asList(2, 1, 1),
            Arrays.asList(1F, 0.3F, 0.1F));

        // 钚 - 过于稀有
        register(ItemBase.RAW_PLUTONIUM,
            Arrays.asList("dustPlutonium", "dustPlutonium", "dustUranium"),
            Arrays.asList(1, 1, 1),
            Arrays.asList(1F, 0.03F, 0.01F));

        // 秘银 - 添加少量银和铂作为彩蛋
        register(ItemBase.RAW_MITHRIL,
            Arrays.asList("dustMithril", "dustSilver", "dustPlatinum"),
            Arrays.asList(2, 1, 1),
            Arrays.asList(1F, 0.15F, 0.05F));

        // 金红石（主要成分为TiO2）- 常与钒、铁共生
        register(ItemBase.RAW_RUTILE,
            Arrays.asList("dustRutile", "dustVanadium", "dustIron"),
            Arrays.asList(2, 1, 1),
            Arrays.asList(1F, 0.25F, 0.2F));

        // 阿迪特
        register(ItemBase.RAW_ARDITE,
            Arrays.asList("dustArdite"),
            Arrays.asList(2),
            Arrays.asList(1F));

        // 晶蓝
        register(ItemBase.RAW_CERULEAN,
            Arrays.asList("dustCerulean"),
            Arrays.asList(2),
            Arrays.asList(1F));

        // 皎月石
        register(ItemBase.RAW_MOONSTONE,
            Arrays.asList("dustMoonstone"),
            Arrays.asList(2),
            Arrays.asList(1F));

        // 炽炎铁
        register(ItemBase.RAW_OCTINE,
            Arrays.asList("dustOctine"),
            Arrays.asList(2),
            Arrays.asList(1F));

        // 赛摩铜
        register(ItemBase.RAW_SYRMORITE,
            Arrays.asList("dustSyrmorite"),
            Arrays.asList(2),
            Arrays.asList(1F));

        // 朱砂矿（HgS） - 常与砷共生，可能含微量金
        register(ItemBase.RAW_CINNABAR,
            Arrays.asList("dustCinnabar", "dustArsenic", "itemCinnabar", "dustGold"),
            Arrays.asList(2, 1, 1, 1),
            Arrays.asList(1F, 0.25F, 0.1F, 0.05F));

        // 软碲铜
        register(ItemBase.RAW_VULCANITE,
            Arrays.asList("dustVulcanite"),
            Arrays.asList(2),
            Arrays.asList(1F));

        // 裂金
        register(ItemBase.RAW_CHASMIUM,
            Arrays.asList("dustChasmium"),
            Arrays.asList(2),
            Arrays.asList(1F));

        // 玫瑰金
        register(ItemBase.RAW_ROSEGOLD,
            Arrays.asList("dustRosegold"),
            Arrays.asList(2),
            Arrays.asList(1F));
    }

    public static void register(Item inputItem, List<String> outputOreDictList, List<Integer> outputAmount, List<Float> outputChance) {
        // 输入物
        ItemStack inputStack = new ItemStack(inputItem);
        // 主输出物
        ItemStack outputStack = ItemBase.oreStack(outputOreDictList.get(0));

        if (!ItemBase.isValidItemStack(inputStack, outputStack)) {
            return;
        }

        // 输出物列表
        List<RecipeOutput> outputList = new ArrayList<>();

        // 遍历输出名称列表，创建对应的 ItemStack
        for (int i = 0; i < outputOreDictList.size(); i++) {
            /*获取输出名*/String outputOreDict = outputOreDictList.get(i);
            /*获取输出量*/int amount = outputAmount.get(i);
            /*获取输出概率*/float chance = outputChance.get(i);

            // 通过矿词获取输出物的ItemStack
            outputStack = ItemBase.oreStack(outputOreDict, amount);

            if (!outputStack.isEmpty()) { // 检查 outputStack 是否为空
                //添加到输出物列表
                outputList.add(new RecipeOutput(outputStack, chance));
            }
        }

        if (!outputList.isEmpty()) {
            if (EnderioExpand.oldVersion) {
                SagMillRecipeRegisterOld.register(inputStack, outputList);
            } else {
                SagMillRecipeRegister.register(inputStack, outputList);
            }
        }
    }
}
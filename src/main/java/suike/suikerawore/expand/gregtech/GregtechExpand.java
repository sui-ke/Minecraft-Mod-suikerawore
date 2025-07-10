package suike.suikerawore.expand.gregtech;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import suike.suikerawore.item.ItemBase;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import gregtech.api.recipes.RecipeMaps;
import gregtech.api.recipes.RecipeBuilder;

public class GregtechExpand {
    private ItemStack item;
    private int chance;
    private int chanceBoost;

    public GregtechExpand(ItemStack item, float chance, float chanceBoost) {
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

    public static void expand() {
        // 格式：register(输入物, 输出物列表, 输出数量, 输出概率);

        // 金 - 可能含铜, 银
        register(ItemBase.RAW_GOLD,
            Arrays.asList("crushedGold", "dustCopper", "dustSilver"),
            Arrays.asList(1, 1, 1),
            Arrays.asList(1F, 0.2F, 0.15F));

        // 铁 - 可能含镍, 钴, 极低概率含锂
        register(ItemBase.RAW_IRON,
            Arrays.asList("crushedIron", "dustNickel", "dustCobalt", "dustLithium"),
            Arrays.asList(1, 1, 1, 1),
            Arrays.asList(1F, 0.1F, 0.05F, 0.03F));

        // 铜 - 可能含金, 钼
        register(ItemBase.RAW_COPPER,
            Arrays.asList("crushedCopper", "dustGold", "dustMolybdenum"),
            Arrays.asList(1, 1, 1),
            Arrays.asList(1F, 0.12F, 0.08F));

        // 锡 - 可能含铁, 锂
        register(ItemBase.RAW_TIN,
            Arrays.asList("crushedTin", "dustIron", "dustLithium"),
            Arrays.asList(1, 1, 1),
            Arrays.asList(1F, 0.1F, 0.05F));

        // 锌 - 可能含镓, 镉
        register(ItemBase.RAW_ZINC,
            Arrays.asList("crushedZinc", "dustGallium", "dustCadmium"), 
            Arrays.asList(1, 1, 1),
            Arrays.asList(1F, 0.1F, 0.15F));

        // 铅 - 可能含银, 铋
        register(ItemBase.RAW_LEAD,
            Arrays.asList("crushedLead", "dustSilver", "dustBismuth"), 
            Arrays.asList(1, 1, 1),
            Arrays.asList(1F, 0.1F, 0.07F));

        // 银 - 可能含铅, 砷
        register(ItemBase.RAW_SILVER,
            Arrays.asList("crushedSilver", "dustLead", "dustArsenic"), 
            Arrays.asList(1, 1, 1),
            Arrays.asList(1F, 0.1F, 0.05F));

        // 钴 - 镍钴矿常共生, 可能含铜, 铁
        register(ItemBase.RAW_COBALT,
            Arrays.asList("crushedCobalt", "dustNickel", "dustCopper", "dustIron"),
            Arrays.asList(1, 1, 1, 1),
            Arrays.asList(1F, 0.3F, 0.2F, 0.15F));

        // 锇 - 铂族金属，常与铱共生
        register(ItemBase.RAW_OSMIUM,
            Arrays.asList("crushedOsmium", "dustIridium", "dustPlatinum"),
            Arrays.asList(1, 1, 1),
            Arrays.asList(1F, 0.25F, 0.1F));

        // 镍 - 镍钴矿常共生, 低概率铂
        register(ItemBase.RAW_NICKEL,
            Arrays.asList("crushedNickel", "dustCobalt", "dustPlatinum"), 
            Arrays.asList(1, 1, 1),
            Arrays.asList(1F, 0.2F, 0.1F));

        // 铱 - 可能含锇, 钌
        register(ItemBase.RAW_IRIDIUM,
            Arrays.asList("crushedIridium", "dustOsmium", "dustRuthenium"),
            Arrays.asList(1, 1, 1),
            Arrays.asList(1F, 0.2F, 0.15F));

        // 铀 - 可能含钍, 稀土
        register(ItemBase.RAW_URANIUM,
            Arrays.asList("crushedUranium", "dustThorium", "dustRareEarth"), 
            Arrays.asList(1, 1, 1),
            Arrays.asList(1F, 0.15F, 0.1F));

        // 镓 - 可能含铝, 锌
        register(ItemBase.RAW_GALLIUM,
            Arrays.asList("crushedGallium", "dustAluminium", "dustZinc"),
            Arrays.asList(1, 1, 1),
            Arrays.asList(1F, 0.3F, 0.1F));

        // 钛 - 可能含含钒, 铁
        register(ItemBase.RAW_TITANIUM,
            Arrays.asList("crushedTitanium", "dustVanadium", "dustIron"), 
            Arrays.asList(1, 1, 1),
            Arrays.asList(1F, 0.15F, 0.1F));

        // 铂 - 可能含钯, 铱
        register(ItemBase.RAW_PLATINUM,
            Arrays.asList("crushedPlatinum", "dustPalladium", "dustIridium"), 
            Arrays.asList(1, 1, 1),
            Arrays.asList(1F, 0.2F, 0.1F));

        // 钨 - 可能含锡, 钼
        register(ItemBase.RAW_TUNGSTEN,
            Arrays.asList("crushedTungsten", "dustTin", "dustMolybdenum"), 
            Arrays.asList(1, 1, 1),
            Arrays.asList(1F, 0.1F, 0.1F));

        // 铝 - 可能含铁, 钛, 极低概率含锂
        register(ItemBase.RAW_ALUMINIUM,
            Arrays.asList("crushedAluminium", "dustIron", "dustTitanium", "dustLithium"), 
            Arrays.asList(1, 1, 1, 1),
            Arrays.asList(1F, 0.1F, 0.1F, 0.03F));

        // 镁 - 可能含钙, 锂
        register(ItemBase.RAW_MAGNESIUM,
            Arrays.asList("crushedMagnesium", "dustCalcium", "dustLithium"),
            Arrays.asList(1, 1, 1),
            Arrays.asList(1F, 0.2F, 0.05F));

        // 锂 - 可能含铝, 硼
        register(ItemBase.RAW_LITHIUM,
            Arrays.asList("crushedLithium", "dustAluminium", "dustBoron"), 
            Arrays.asList(1, 1, 1),
            Arrays.asList(1F, 0.1F, 0.05F));

        // 钍 - 可能含稀土, 铀
        register(ItemBase.RAW_THORIUM,
            Arrays.asList("crushedThorium", "dustRareEarth", "dustUranium"),
            Arrays.asList(1, 1, 1),
            Arrays.asList(1F, 0.25F, 0.15F));

        // 硼 - 可能含钠, 钙
        register(ItemBase.RAW_BORON,
            Arrays.asList("crushedBoron", "dustSodium", "dustCalcium"),
            Arrays.asList(1, 1, 1),
            Arrays.asList(1F, 0.2F, 0.2F));

        // 钒 - 可能含钛, 铁
        register(ItemBase.RAW_VANADIUM,
            Arrays.asList("crushedVanadium", "dustTitanium", "dustIron"),
            Arrays.asList(1, 1, 1),
            Arrays.asList(1F, 0.3F, 0.25F));

        // 镉 - 可能含锌, 铜
        register(ItemBase.RAW_CADMIUM,
            Arrays.asList("crushedCadmium", "dustZinc", "dustCopper"),
            Arrays.asList(1, 1, 1),
            Arrays.asList(1F, 0.4F, 0.1F));

        // 锰 - 可能含铁, 钴共生
        register(ItemBase.RAW_MANGANESE,
            Arrays.asList("crushedManganese", "dustIron", "dustCobalt"),
            Arrays.asList(1, 1, 1),
            Arrays.asList(1F, 0.3F, 0.15F));

        // 锗 - 可能含铅, 锌
        register(ItemBase.RAW_GERMANIUM,
            Arrays.asList("crushedGermanium", "dustLead", "dustZinc"),
            Arrays.asList(1, 1, 1),
            Arrays.asList(1F, 0.2F, 0.2F));

        // 铬 - 可能含铁, 镍
        register(ItemBase.RAW_CHROMIUM,
            Arrays.asList("crushedChromium", "dustIron", "dustNickel"),
            Arrays.asList(1, 1, 1),
            Arrays.asList(1F, 0.3F, 0.1F));

        // 砷 - 可能含硫, 锑
        register(ItemBase.RAW_ARSENIC,
            Arrays.asList("crushedArsenic", "dustSulfur", "dustAntimony"),
            Arrays.asList(1, 1, 1),
            Arrays.asList(1F, 0.4F, 0.15F));

        // 铍 - 可能含铝, 锂
        register(ItemBase.RAW_BERYLLIUM,
            Arrays.asList("crushedBeryllium", "dustAluminium", "dustLithium"),
            Arrays.asList(1, 1, 1),
            Arrays.asList(1F, 0.2F, 0.1F));

        // 镭
        register(ItemBase.RAW_IRRADIUM,
            Arrays.asList("crushedIrradium", "dustIrradium"),
            Arrays.asList(1, 1),
            Arrays.asList(1F, 0.03F));

        // 钯 - 铂族金属，常与镍共生
        register(ItemBase.RAW_PALLADIUM,
            Arrays.asList("crushedPalladium", "dustNickel", "dustPlatinum"),
            Arrays.asList(1, 1, 1),
            Arrays.asList(1F, 0.3F, 0.1F));

        // 钚
        register(ItemBase.RAW_PLUTONIUM,
            Arrays.asList("crushedPlutonium", "dustPlutonium", "dustUranium"),
            Arrays.asList(1, 1, 1),
            Arrays.asList(1F, 0.03F, 0.01F));

        // 铌
        register(ItemBase.RAW_NIOBIUM,
            Arrays.asList("dustNiobium", "dustNiobium", "dustNiobium"),
            Arrays.asList(1, 1, 1),
            Arrays.asList(1F, 0.03F, 0.01F));

        // 秘银 - 添加少量银和铂作为彩蛋
        register(ItemBase.RAW_MITHRIL,
            Arrays.asList("crushedMithril", "dustSilver", "dustPlatinum"),
            Arrays.asList(1, 1, 1),
            Arrays.asList(1F, 0.15F, 0.05F));

        // 金红石 (主要成分为TiO2) - 常与钒、铁共生
        register(ItemBase.RAW_RUTILE,
            Arrays.asList("crushedRutile", "dustVanadium", "dustIron"),
            Arrays.asList(1, 1, 1),
            Arrays.asList(1F, 0.25F, 0.2F));
    }

    public static void register(Item inputItem, List<String> outputOreDictList, List<Integer> outputAmount, List<Float> outputChance) {
        // 输入物
        ItemStack inputStack = new ItemStack(inputItem);

        // 主输出物
        ItemStack outputStack = ItemBase.oreStack(outputOreDictList.get(0), outputAmount.get(0));

        if (!ItemBase.isValidItemStack(inputStack, outputStack)) {
            return;
        }

        // 输出物列表
        List<GregtechExpand> chancedOutputs = new ArrayList<>();

        // 遍历输出名称列表，创建对应的 ItemStack
        for (int i = 1; i < outputOreDictList.size(); i++) {
            /*获取输出名*/String outputOreDict = outputOreDictList.get(i);
            /*获取输出量*/int amount = outputAmount.get(i);
            /*获取输出概率*/float chance = outputChance.get(i);

            // 通过矿词获取输出物的ItemStack
            ItemStack secondaryOutputStack = ItemBase.oreStack(outputOreDict, amount);

            if (ItemBase.isValidItemStack(secondaryOutputStack)) { // 检查 outputStack 是否为空
                // 添加到输出物列表
                float chanceBoost = 0.085F;
                if (chance < 0.1F) {
                    chanceBoost = 0.015F; // 稀有物品
                }
                chancedOutputs.add(new GregtechExpand(secondaryOutputStack, chance, chanceBoost));
            }
        }

        // 锻造机配方
        RecipeMaps.FORGE_HAMMER_RECIPES.recipeBuilder()
            .inputs(inputStack)
            .outputs(outputStack)
            .duration(400) // 处理时间 (ticks)
            .EUt(2) // 所需 EU/t
            .buildAndRegister();

        // 创建 RecipeBuilder
        RecipeBuilder<?> builder = RecipeMaps.MACERATOR_RECIPES.recipeBuilder()
            .inputs(inputStack)
            .outputs(outputStack)
            .duration(400) // 处理时间 (ticks)
            .EUt(2); // 所需 EU/t

        // 添加概率输出
        for (GregtechExpand output : chancedOutputs) {
            builder.chancedOutput(output.getItem(), output.getChance(), output.getBoost());
        }

        // 注册研磨机配方
        builder.buildAndRegister();
    }
}
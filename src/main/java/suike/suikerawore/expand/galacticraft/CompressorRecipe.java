package suike.suikerawore.expand.galacticraft;

import suike.suikerawore.item.ItemBase;

import micdoodle8.mods.galacticraft.core.recipe.RecipeManagerGC;
import micdoodle8.mods.galacticraft.api.recipe.CompressorRecipes;

import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.init.Items;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

//压缩机配方
public class CompressorRecipe {
    public static void register() {
        /*金板*/register(Items.GOLD_INGOT, "Gold");
        /*铁板*/register(Items.IRON_INGOT, "Iron");
        /*铜板*/register(ItemBase.INGOT_COPPER, "Copper");
        /*锡板*/register(ItemBase.INGOT_TIN, "Tin");
        /*锌板*/register(ItemBase.INGOT_ZINC, "Zinc");
        /*铅板*/register(ItemBase.INGOT_LEAD, "Lead");
        /*银板*/register(ItemBase.INGOT_SILVER, "Silver");
        /*钴板*/register(ItemBase.INGOT_COBALT, "Cobalt");
        /*锇板*/register(ItemBase.INGOT_OSMIUM, "Osmium");
        /*镍板*/register(ItemBase.INGOT_NICKEL, "Nickel");
        /*铱板*/register(ItemBase.INGOT_IRIDIUM, "Iridium");
        /*铀板*/register(ItemBase.INGOT_URANIUM, "Uranium");
        /*镓板*/register(ItemBase.INGOT_GALLIUM, "Gallium");
        /*钛板*/register(ItemBase.INGOT_TITANIUM, "Titanium");
        /*铂板*/register(ItemBase.INGOT_PLATINUM, "Platinum");
        /*钨板*/register(ItemBase.INGOT_TUNGSTEN, "Tungsten");
        /*铝板*/register(ItemBase.INGOT_ALUMINIUM, "Aluminum");
        /*铝板*/register(ItemBase.INGOT_ALUMINIUM, "Aluminium");
        /*镁板*/register(ItemBase.INGOT_MAGNESIUM, "Magnesium");
        /*锂板*/register(ItemBase.INGOT_LITHIUM, "Lithium");
        /*钍板*/register(ItemBase.INGOT_THORIUM, "Thorium");
        /*硼板*/register(ItemBase.INGOT_BORON, "Boron");
        /*钒板*/register(ItemBase.INGOT_VANADIUM, "Vanadium");
        /*镉板*/register(ItemBase.INGOT_CADMIUM, "Cadmium");
        /*锰板*/register(ItemBase.INGOT_MANGANESE, "Manganese");
        /*锗板*/register(ItemBase.INGOT_GERMANIUM, "Germanium");
        /*铬板*/register(ItemBase.INGOT_CHROMIUM, "Chromium");
        /*砷板*/register(ItemBase.INGOT_ARSENIC, "Arsenic");
    }

//注册压缩机配方
    public static void register(Item input, String outputOD) {
        //定义矿词前缀
        String[] prefixes = {"compressed", "plate"};

        //遍历每个前缀
        for (String prefix : prefixes) {
            String structure = "XX";//摆放结构

            if (prefix.equals("plate")) {
                structure = "X";
            }

            ItemStack inputStack = new ItemStack(input, 1);
            ItemStack outputStack = ItemBase.oreStack(prefix + outputOD);

            if (!outputStack.isEmpty()) {
                String modId = outputStack.getItem().getRegistryName().toString().split(":")[0];
                boolean register = true;

                if (structure.equals("X") & !modId.equals("ic2")) {
                    register = false;
                }

                if (register) {
                    /*注册压缩机配方*/CompressorRecipes.addRecipe(outputStack, structure, 'X', inputStack);
                }
            }
        }
    }
}
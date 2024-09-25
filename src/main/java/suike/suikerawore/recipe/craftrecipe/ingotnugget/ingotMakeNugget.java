package suike.suikerawore.recipe.craftrecipe.ingotnugget;

import suike.suikerawore.SuiKe;
import suike.suikerawore.item.ItemBase;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.OreIngredient;
import net.minecraftforge.fml.common.registry.GameRegistry;

//锭->粒
public class ingotMakeNugget {
    public static void register() {
        /*铜*/register(ItemBase.INGOT_COPPER, "nuggetCopper");
        /*锡*/register(ItemBase.INGOT_TIN, "nuggetTin");
        /*锌*/register(ItemBase.INGOT_ZINC, "nuggetZinc");
        /*铅*/register(ItemBase.INGOT_LEAD, "nuggetLead");
        /*银*/register(ItemBase.INGOT_SILVER, "nuggetSilver");
        /*钴*/register(ItemBase.INGOT_COBALT, "nuggetCobalt");
        /*锇*/register(ItemBase.INGOT_OSMIUM, "nuggetOsmium");
        /*镍*/register(ItemBase.INGOT_NICKEL, "nuggetNickel");
        /*铱*/register(ItemBase.INGOT_IRIDIUM, "nuggetIridium");
        /*铀*/register(ItemBase.INGOT_URANIUM, "nuggetUranium");
        /*镓*/register(ItemBase.INGOT_GALLIUM, "nuggetGallium");
        /*钛*/register(ItemBase.INGOT_TITANIUM, "nuggetTitanium");
        /*铂*/register(ItemBase.INGOT_PLATINUM, "nuggetPlatinum");
        /*钨*/register(ItemBase.INGOT_TUNGSTEN, "nuggetTungsten");
        /*镁*/register(ItemBase.INGOT_MAGNESIUM, "nuggetMagnesium");
        /*锂*/register(ItemBase.INGOT_LITHIUM, "nuggetLithium");
        /*钍*/register(ItemBase.INGOT_THORIUM, "nuggetThorium");
        /*硼*/register(ItemBase.INGOT_BORON, "nuggetBoron");
        /*钒*/register(ItemBase.INGOT_VANADIUM, "nuggetVanadium");
        /*镉*/register(ItemBase.INGOT_CADMIUM, "nuggetCadmium");
        /*锰*/register(ItemBase.INGOT_MANGANESE, "nuggetManganese");
        /*锗*/register(ItemBase.INGOT_GERMANIUM, "nuggetGermanium");
        /*铬*/register(ItemBase.INGOT_CHROMIUM, "nuggetChromium");
        /*砷*/register(ItemBase.INGOT_ARSENIC, "nuggetArsenic");
        /*硼*/register(ItemBase.INGOT_BORON, "nuggetBoron");

        /*铝*/register("ingotAluminum");
        /*铝*/register("ingotAluminium");
    }

//配方注册
    public static void register(Item input, String outputOD) {
        ItemStack inputStack = new ItemStack(input);
        NonNullList<ItemStack> outputList = OreDictionary.getOres(outputOD);

        if (!outputList.isEmpty()) {
            String inputName = input.getRegistryName().toString().replaceAll(".*:", "").trim();

            ItemStack outputStack = outputList.get(0).copy();
            outputStack.setCount(9);//设置数量

            GameRegistry.addShapedRecipe(
                new ResourceLocation(SuiKe.MODID, inputName + ">" + outputOD),//配方标识符
                new ResourceLocation(SuiKe.MODID),//分组名
                outputStack,
                "A",
                'A', inputStack
            );
        }
    }

    public static void register(String inputOD) {
        OreIngredient inputStack = new OreIngredient(inputOD);
        ItemStack output = new ItemStack(ItemBase.NUGGET_ALUMINIUM).copy();
        output.setCount(9);//设置数量

        GameRegistry.addShapedRecipe(
            new ResourceLocation(SuiKe.MODID, inputOD + ">nuggetAluminium"),//配方标识符
            new ResourceLocation(SuiKe.MODID),//分组名
            output,
            "A",
            'A', inputStack
        );
    }
}
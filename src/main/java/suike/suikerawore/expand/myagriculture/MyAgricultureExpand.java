package suike.suikerawore.expand.myagriculture;

import suike.suikerawore.SuiKe;
import suike.suikerawore.item.ItemBase;

import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import net.minecraftforge.fml.common.registry.GameRegistry;

//神秘农业
public class MyAgricultureExpand {
    public static void expand() {
        /*铜*/register("mysticalagriculture:copper_essence", ItemBase.INGOT_COPPER);
        /*锡*/register("mysticalagriculture:tin_essence", ItemBase.INGOT_TIN);
        /*铅*/register("mysticalagriculture:lead_essence", ItemBase.INGOT_LEAD);
        /*银*/register("mysticalagriculture:silver_essence", ItemBase.INGOT_SILVER);
        /*钴*/register("mysticalagriculture:cobalt_essence", ItemBase.INGOT_COBALT);
        /*锇*/register("mysticalagriculture:osmium_essence", ItemBase.INGOT_OSMIUM);
        /*镍*/register("mysticalagriculture:nickel_essence", ItemBase.INGOT_NICKEL);
        /*铀*/register("mysticalagriculture:uranium_essence", ItemBase.INGOT_URANIUM);
        /*钛*/register("mysticalagriculture:titanium_essence", ItemBase.INGOT_TITANIUM);
        /*铝*/register("mysticalagriculture:aluminum_essence", ItemBase.INGOT_ALUMINIUM);
    }

//配方注册
    public static void register(String inputName, Item items) {
        //获取物品注册名
        String name = inputName.replaceAll(".*:", "").trim();

        ItemStack input = new ItemStack(Item.getByNameOrId(inputName));
        ItemStack output = new ItemStack(items).copy();
        output.setCount(4);//设置数量

        GameRegistry.addShapedRecipe(
            new ResourceLocation(SuiKe.MODID, name + ">ingot"),//配方标识符
            new ResourceLocation(SuiKe.MODID),//分组名
            output, 
            "AAA",
            "ABA",
            "AAA",
            'A', input,
            'B', ItemStack.EMPTY
        );
    }
}
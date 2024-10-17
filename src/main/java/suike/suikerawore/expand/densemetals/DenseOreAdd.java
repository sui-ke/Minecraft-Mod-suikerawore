package suike.suikerawore.expand.densemetals;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

//富集矿石添加矿词类
public class DenseOreAdd {
    public static void Add() {
        register("denseOreGold", Item.getByNameOrId("densemetals:dense_gold_ore"));//金
        register("denseOreIron", Item.getByNameOrId("densemetals:dense_iron_ore"));//铁
        register("denseOreCopper", Item.getByNameOrId("densemetals:dense_copper_ore"));//铜
        register("denseOreTin", Item.getByNameOrId("densemetals:dense_tin_ore"));//锡
        register("denseOreZinc", Item.getByNameOrId("densemetals:dense_zinc_ore"));//锌
        register("denseOreLead", Item.getByNameOrId("densemetals:dense_lead_ore"));//铅
        register("denseOreSilver", Item.getByNameOrId("densemetals:dense_silver_ore"));//银
        register("denseOreOsmium", Item.getByNameOrId("densemetals:dense_osmium_ore"));//锇
        register("denseOreNickel", Item.getByNameOrId("densemetals:dense_nickel_ore"));//镍
        register("denseOreIridium", Item.getByNameOrId("densemetals:dense_iridium_ore"));//铱
        register("denseOreUranium", Item.getByNameOrId("densemetals:dense_uranium_ore"));//铀
        register("denseOrePlatinum", Item.getByNameOrId("densemetals:dense_platinum_ore"));//铂
        register("denseOreTungsten", Item.getByNameOrId("densemetals:dense_tungsten_ore"));//钨
        register("denseOreAluminium", Item.getByNameOrId("densemetals:dense_aluminum_ore"));//铝
        register("denseOreMagnesium", Item.getByNameOrId("densemetals:dense_magnesium_ore"));//镁
    }

    //注册矿词方法
    public static void register(String ore, Item item) {
        ItemStack itemStack = new ItemStack(item);
        OreDictionary.registerOre(ore, itemStack);
    }
}
package suike.suikerawore.expand.thermalexpansion;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import suike.suikerawore.item.ItemBase;

import cofh.thermalexpansion.util.managers.machine.SmelterManager;

import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import net.minecraftforge.oredict.OreDictionary;

//感应炉-粗矿>锭
public class InductionSmelterRecipe {
    public static void register() {
        /*金*/register(ItemBase.RAW_GOLD, Items.GOLD_INGOT, "ingotCopperRaw");
        /*铁*/register(ItemBase.RAW_IRON, Items.IRON_INGOT, "ingotNickelRaw");
        /*铜*/register(ItemBase.RAW_COPPER, ItemBase.INGOT_COPPER, "ingotGold");
        /*锡*/register(ItemBase.RAW_TIN, ItemBase.INGOT_TIN, "ingotIron");
        /*锌*/register(ItemBase.RAW_ZINC, ItemBase.INGOT_ZINC);
        /*铅*/register(ItemBase.RAW_LEAD, ItemBase.INGOT_LEAD, "ingotSilverRaw");
        /*银*/register(ItemBase.RAW_SILVER, ItemBase.INGOT_SILVER, "ingotLeadRaw");
        /*钴*/register(ItemBase.RAW_COBALT, ItemBase.INGOT_COBALT);
        /*锇*/register(ItemBase.RAW_OSMIUM, ItemBase.INGOT_OSMIUM);
        /*镍*/register(ItemBase.RAW_NICKEL, ItemBase.INGOT_NICKEL, "ingotPlatinumRaw");
        /*铱*/register(ItemBase.RAW_IRIDIUM, ItemBase.INGOT_IRIDIUM, "ingotPlatinumRaw");
        /*铀*/register(ItemBase.RAW_URANIUM, ItemBase.INGOT_URANIUM);
        /*镓*/register(ItemBase.RAW_GALLIUM, ItemBase.INGOT_GALLIUM);
        /*钛*/register(ItemBase.RAW_TITANIUM, ItemBase.INGOT_TITANIUM);
        /*铂*/register(ItemBase.RAW_PLATINUM, ItemBase.INGOT_PLATINUM, "ingotIridiumRaw");
        /*钨*/register(ItemBase.RAW_TUNGSTEN, ItemBase.INGOT_TUNGSTEN);
        /*铝*/register(ItemBase.RAW_ALUMINIUM, ItemBase.INGOT_ALUMINIUM, "ingotIron");
        /*镁*/register(ItemBase.RAW_MAGNESIUM, ItemBase.INGOT_MAGNESIUM);
        /*锂*/register(ItemBase.RAW_LITHIUM, ItemBase.INGOT_LITHIUM);
        /*钍*/register(ItemBase.RAW_THORIUM, ItemBase.INGOT_THORIUM);
        /*硼*/register(ItemBase.RAW_BORON, ItemBase.INGOT_BORON);
        /*钒*/register(ItemBase.RAW_VANADIUM, ItemBase.INGOT_VANADIUM);
        /*镉*/register(ItemBase.RAW_CADMIUM, ItemBase.INGOT_CADMIUM);
        /*锰*/register(ItemBase.RAW_MANGANESE, ItemBase.INGOT_MANGANESE);
        /*锗*/register(ItemBase.RAW_GERMANIUM, ItemBase.INGOT_GERMANIUM);
        /*铬*/register(ItemBase.RAW_CHROMIUM, ItemBase.INGOT_CHROMIUM);
        /*砷*/register(ItemBase.RAW_ARSENIC, ItemBase.INGOT_ARSENIC);

        /*阿迪特*/register(ItemBase.RAW_ARDITE, "tconstruct:ingots", 1);
        /* 晶蓝 */register(ItemBase.RAW_CERULEAN, "theaurorian:ceruleaningot", 0);
        /*皎月石*/register(ItemBase.RAW_MOONSTONE, "theaurorian:moonstoneingot", 0);
        /*炽炎铁*/register(ItemBase.RAW_OCTINE, "thebetweenlands:octine_ingot", 0);
        /*赛摩铜*/register(ItemBase.RAW_SYRMORITE, "thebetweenlands:syrmorite_ingot", 0);
        /* 朱砂 */register(ItemBase.RAW_CINNABAR, "thaumcraft:quicksilver", 0);
        /*软碲铜*/register(ItemBase.RAW_VULCANITE, "vulcanite:vulcanite_ingot", 0);
        /* 裂金 */register(ItemBase.RAW_CHASMIUM, "mm:chasmium_ingot", 0);
    }

//转译变量
    public static final List<String> defaultSecondaryOutputList = new ArrayList<>(Arrays.asList("itemSlagRich", "itemSlag", "itemSlagRich"));

    public static void register(Item inputItem, Item outputItem) {
        register(inputItem, outputItem, 0, new ArrayList<>(defaultSecondaryOutputList));
    }

    public static void register(Item inputItem, Item outputItem, String secondaryoutputName) {
        List<String> secondaryOutputList = new ArrayList<>(defaultSecondaryOutputList);
        secondaryOutputList.set(2, secondaryoutputName);

        register(inputItem, outputItem, 0, secondaryOutputList);
    }

    public static void register(Item inputItem, String outputName, int meta) {
        Item outputItem = Item.getByNameOrId(outputName);

        if (inputItem != null && outputItem != null) {//检查 输出物 是否为空
            register(inputItem, outputItem, meta, new ArrayList<>(defaultSecondaryOutputList));
        }
    }

//配方注册
    public static void register(Item inputItem, Item outputItem, int meta, List<String> secondaryOutputList) {
        /*主输入物*/ItemStack inputStack = new ItemStack(inputItem);
        /*主输出物数量*/int[] outputAmounts = {2, 3, 3};

        /*副输入物*/String[] secondaryInputs = {"sand", "itemSlagRich", "itemCinnabar"};

        /*副输出物概率*/int[] secondaryChances = {20, 75, 75};

        //遍历副输入物列表
        for (int i = 0 ; i < outputAmounts.length; i++) {
            /*主输入物*/ItemStack outputStack = new ItemStack(outputItem, outputAmounts[i], meta);

            /*获取副输入物列表*/NonNullList<ItemStack> secondaryInputList = OreDictionary.getOres(secondaryInputs[i]);
            for (ItemStack secondaryInputStack : secondaryInputList) {
                /*获取副输出物名*/String secondaryOutputName = secondaryOutputList.get(i);
                /*获取副输出物*/ItemStack secondaryOutputStack = ItemBase.oreStack(secondaryOutputName);

                /*获取副输出物概率*/int secondaryChance = secondaryChances[i];
                if (!(secondaryOutputName.equals("itemSlagRich")) && !(secondaryOutputName.equals("itemSlag"))) {
                    secondaryChance = 100;
                }

                if (ItemBase.isValidItemStack(inputStack) && ItemBase.isValidItemStack(outputStack)) {
                    /*注册配方*/SmelterManager.addRecipe(4000, inputStack, secondaryInputStack, outputStack, secondaryOutputStack, secondaryChance);
                }
            }
        }
    }
}
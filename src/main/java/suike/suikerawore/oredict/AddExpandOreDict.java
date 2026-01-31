package suike.suikerawore.oredict;

import suike.suikerawore.item.ItemBase;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import net.minecraftforge.oredict.OreDictionary;

public class AddExpandOreDict {
    public static void oreDictAdd() {
        // 矿石
        /*阿迪特*/oreDictAdd("oreArdite", "tconstruct:ore", 1);
        /* 晶蓝 */oreDictAdd("oreCerulean", "theaurorian:ceruleanore");
        /*皎月石*/oreDictAdd("oreMoonstone", "theaurorian:moonstoneore");
        /*炽炎铁*/oreDictAdd("oreOctine", "thebetweenlands:octine_ore");
        /*赛摩铜*/oreDictAdd("oreSyrmorite", "thebetweenlands:syrmorite_ore");
        /* 朱砂 */oreDictAdd("oreCinnabar", "thaumcraft:ore_cinnabar");
        /*软碲铜*/oreDictAdd("oreVulcanite", "vulcanite:vulcanite_ore");
        /*软碲铜*/oreDictAdd("oreVulcanite", "vulcanite:nether_vulcanite_ore");
        /* 裂金 */oreDictAdd("oreChasmium", "mm:chasmium_ore");
        /*玫瑰金*/oreDictAdd("oreRosegold", "mca:rose_gold_ore");

        // 锭
        /*阿迪特*/oreDictAdd("ingotArdite", "tconstruct:ingots", 1);
        /* 晶蓝 */oreDictAdd("ingotCerulean", "theaurorian:ceruleaningot");
        /*皎月石*/oreDictAdd("ingotMoonstone", "theaurorian:moonstoneingot");
        /*炽炎铁*/oreDictAdd("ingotOctine", "thebetweenlands:octine_ingot");
        /*赛摩铜*/oreDictAdd("ingotSyrmorite", "thebetweenlands:items_misc", 11);
        /* 朱砂 */oreDictAdd("ingotCinnabar", "thaumcraft:quicksilver");
        /*软碲铜*/oreDictAdd("ingotVulcanite", "vulcanite:vulcanite_ingot");
        /* 裂金 */oreDictAdd("ingotChasmium", "mm:chasmium_ingot");
        /*玫瑰金*/oreDictAdd("ingotRosegold", "mca:rose_gold_ingot");

        // 富集矿石
        /*金富集矿石*/oreDictAdd("oreGoldDense", "densemetals:dense_gold_ore");
        /*铁富集矿石*/oreDictAdd("oreIronDense", "densemetals:dense_iron_ore");
        /*铜富集矿石*/oreDictAdd("oreCopperDense", "densemetals:dense_copper_ore");
        /*锡富集矿石*/oreDictAdd("oreTinDense", "densemetals:dense_tin_ore");
        /*锌富集矿石*/oreDictAdd("oreZincDense", "densemetals:dense_zinc_ore");
        /*铅富集矿石*/oreDictAdd("oreLeadDense", "densemetals:dense_lead_ore");
        /*银富集矿石*/oreDictAdd("oreSilverDense", "densemetals:dense_silver_ore");
        /*锇富集矿石*/oreDictAdd("oreOsmiumDense", "densemetals:dense_osmium_ore");
        /*镍富集矿石*/oreDictAdd("oreNickelDense", "densemetals:dense_nickel_ore");
        /*铱富集矿石*/oreDictAdd("oreIridiumDense", "densemetals:dense_iridium_ore");
        /*铀富集矿石*/oreDictAdd("oreUraniumDense", "densemetals:dense_uranium_ore");
        /*铂富集矿石*/oreDictAdd("orePlatinumDense", "densemetals:dense_platinum_ore");
        /*钨富集矿石*/oreDictAdd("oreTungstenDense", "densemetals:dense_tungsten_ore");
        /*铝富集矿石*/oreDictAdd("oreAluminiumDense", "densemetals:dense_aluminum_ore");
        /*镁富集矿石*/oreDictAdd("oreMagnesiumDense", "densemetals:dense_magnesium_ore");

        // 工业2-经典版
        /*稀土*/oreDictAdd("dustRareEarth", "ic2:itemmisc", 14);

        // 工业升级
        //*锂矿石*/oreDictAdd("oreLithium", "industrialupgrade:baseore1");
        //*聚丙烯*/oreDictAdd("polyPropylene", "industrialupgrade:crafting_elements", 484);

        // 星系
        /*钛铁矿*/oreDictAdd("oreTitanium", "galacticraftplanets:asteroids_block", 4);

        // 星空
        /*钴块*/oreDictAdd("blockCobalt", "galaxyspace:blocksmetals");
        /*镍块*/oreDictAdd("blockNickel", "galaxyspace:blocksmetals", 1);
        /*镁块*/oreDictAdd("blockMagnesium", "galaxyspace:blocksmetals", 2);

        /*钴粒*/oreDictAdd("nuggetCobalt", "galaxyspace:nuggets");
        /*镍粒*/oreDictAdd("nuggetNickel", "galaxyspace:nuggets", 2);
        /*镁粒*/oreDictAdd("nuggetMagnesium", "galaxyspace:nuggets", 1);

        /*压缩钴板*/oreDictAdd("compressedCobalt", "galaxyspace:compressed_plates", 1);
        /*压缩镍板*/oreDictAdd("compressedNickel", "galaxyspace:compressed_plates", 3);
        /*压缩镁板*/oreDictAdd("compressedMagnesium", "galaxyspace:compressed_plates", 2);

        // 冒险漩涡
        /*金矿石*/oreDictAdd("oreGold", "mm:azure_gold_ore");
        /*铁矿石*/oreDictAdd("oreIron", "mm:azure_iron_ore");
        /*裂金矿石*/oreDictAdd("oreChasmium", "mm:chasmium_ore");
        /*裂金锭*/oreDictAdd("ingotChasmium", "mm:chasmium_ingot");

        // 铱矿产
        /*铂矿石*/oreDictAdd("orePlatinum", "iridiumsource:ore_overworld");
        /*下界铂矿石*/oreDictAdd("orePlatinum", "iridiumsource:ore_nether");
        /*末地铂矿石*/oreDictAdd("orePlatinum", "iridiumsource:ore_end");
        /*铂颗粒*/oreDictAdd("prillPlatinum", "iridiumsource:prill_platina");

        // 虚拟人生
        /*玫瑰金矿石*/oreDictAdd("oreRosegold", "mca:rose_gold_ore");
        /*玫瑰金锭*/oreDictAdd("ingotRosegold", "mca:rose_gold_ingot");

        // 维克的现代战争
        /* 铜锭 */oreDictAdd("ingotCopper" , "mw:copperingot");
        /*铜矿石*/oreDictAdd("oreCopper"   , "mw:copperore");
        /*锡矿石*/oreDictAdd("oreTin"      , "mw:tinore");
        /*铅矿石*/oreDictAdd("oreLead"     , "mw:leadore");
        /*钛矿石*/oreDictAdd("oreTitanium" , "mw:titaniumore");
        /*铝矿石*/oreDictAdd("oreAluminium", "mw:bauxiteore");
        /*钽矿石*/oreDictAdd("oreTantalum" , "mw:tantalumore");

        // 试炼更新
        /*铜矿石*/oreDictAdd("oreCopper", "deeperdepths:copper_ore");

        //
        //*矾土*/oreDictAdd("rawAluminium"  , "chinjufumod:item_bauxite");
        //*矾土矿*/oreDictAdd("rawAluminium", "chinjufumod:block_bauxite_ore");

        // 简单矿石
        /*秘银矿石*/oreDictAdd("oreMithril", "simpleores:mythril_ore");
        /*秘银锭*/oreDictAdd("ingotMithril", "simpleores:mythril_ingot");

        // 科技枪
        /*钛矿石*/oreDictAdd("oreTitanium", "techguns:basicore", 3);

        // 神秘时代6
        /*稀土*/oreDictAdd("dustRareEarth"      , "thaumcraft:nugget", 10);
        /*铁原矿簇*/oreDictAdd("clusterIron"    , "thaumcraft:cluster", 0);
        /*金原矿簇*/oreDictAdd("clusterGold"    , "thaumcraft:cluster", 1);
        /*铜原矿簇*/oreDictAdd("clusterCopper"  , "thaumcraft:cluster", 2);
        /*锡原矿簇*/oreDictAdd("clusterTin"     , "thaumcraft:cluster", 3);
        /*铅原矿簇*/oreDictAdd("clusterLead"    , "thaumcraft:cluster", 5);
        /*银原矿簇*/oreDictAdd("clusterSilver"  , "thaumcraft:cluster", 4);
        /*朱砂矿簇*/oreDictAdd("clusterCinnabar", "thaumcraft:cluster", 6);
        /*朱砂碎块*/oreDictAdd("crushedCinnabar", "emt:materials_crushedorecinnabar");

        multiOreDictionProcessing();
    }

// 注册矿词方法
    public static void oreDictAdd(String ore, String name) {
        oreDictAdd(ore, name, 0);
    }
    public static void oreDictAdd(String ore, String name, int mate) {
        Item item = Item.getByNameOrId(name);
        if (item != null && !ore.isEmpty()) {
            ItemStack itemStack = new ItemStack(item, 1, mate);
            if (ItemBase.isValidItemStack(itemStack)) {
                OreDictionary.registerOre(ore, itemStack);
            }
        }
    }

// 多矿词处理方法
    public static void multiOreDictionProcessing() {
        String[][] types = {{"Aluminum", "Aluminium"}, {"Chrome", "Chromium"}, {"Mythril", "Mithril"}, {"Thorium232", "Thorium"}};
        String[] itemTypes = {"ore", "ingot", "block", "nugget", "dust", "shard", "compressed", "plate", "stick"};

        for (String[] type : types) {
            for (String  itemType : itemTypes) {
                NonNullList<ItemStack> oreStackList = OreDictionary.getOres(itemType + type[0]);
                for (ItemStack itemStack : oreStackList) {
                    if (ItemBase.isValidItemStack(itemStack)) {
                        OreDictionary.registerOre(itemType + type[1], itemStack);
                    }
                }
            }
        }

        NonNullList<ItemStack> oreStackList = OreDictionary.getOres("nuggetRareEarth");
        for (ItemStack itemStack : oreStackList) {
            if (ItemBase.isValidItemStack(itemStack)) {
                OreDictionary.registerOre("dustRareEarth", itemStack);
            }
        }
    }
}
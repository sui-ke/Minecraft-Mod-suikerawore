package suike.suikerawore.oredict.oredictadd;

import suike.suikerawore.item.ItemBase;
import suike.suikerawore.expand.Examine;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraftforge.oredict.OreDictionary;

public class AddExpandOreDict {
    public static void oreDictAdd() {
        // 矿石
        /*阿迪特*/oreDictAdd("oreArdite", Item.getByNameOrId("tconstruct:ore"), 1);
        /* 晶蓝 */oreDictAdd("oreCerulean", Item.getByNameOrId("theaurorian:ceruleanore"));
        /*皎月石*/oreDictAdd("oreMoonstone", Item.getByNameOrId("theaurorian:moonstoneore"));
        /*炽炎铁*/oreDictAdd("oreOctine", Item.getByNameOrId("thebetweenlands:octine_ore"));
        /*赛摩铜*/oreDictAdd("oreSyrmorite", Item.getByNameOrId("thebetweenlands:syrmorite_ore"));
        /* 朱砂 */oreDictAdd("oreCinnabar", Item.getByNameOrId("thaumcraft:ore_cinnabar"));
        /*软碲铜*/oreDictAdd("oreVulcanite", Item.getByNameOrId("vulcanite:vulcanite_ore"));
        /*软碲铜*/oreDictAdd("oreVulcanite", Item.getByNameOrId("vulcanite:nether_vulcanite_ore"));
        /* 裂金 */oreDictAdd("oreChasmium", Item.getByNameOrId("mm:chasmium_ore"));
        /*玫瑰金*/oreDictAdd("oreRosegold", Item.getByNameOrId("mca:rose_gold_ore"));

        // 锭
        /*阿迪特*/oreDictAdd("ingotArdite", Item.getByNameOrId("tconstruct:ingots"), 1);
        /* 晶蓝 */oreDictAdd("ingotCerulean", Item.getByNameOrId("theaurorian:ceruleaningot"));
        /*皎月石*/oreDictAdd("ingotMoonstone", Item.getByNameOrId("theaurorian:moonstoneingot"));
        /*炽炎铁*/oreDictAdd("ingotOctine", Item.getByNameOrId("thebetweenlands:octine_ingot"));
        /*赛摩铜*/oreDictAdd("ingotSyrmorite", Item.getByNameOrId("thebetweenlands:items_misc"), 11);
        /* 朱砂 */oreDictAdd("ingotCinnabar", Item.getByNameOrId("thaumcraft:quicksilver"));
        /*软碲铜*/oreDictAdd("ingotVulcanite", Item.getByNameOrId("vulcanite:vulcanite_ingot"));
        /* 裂金 */oreDictAdd("ingotChasmium", Item.getByNameOrId("mm:chasmium_ingot"));
        /*玫瑰金*/oreDictAdd("ingotRosegold", Item.getByNameOrId("mca:rose_gold_ingot"));

        // 致密矿石
        /*金致密矿石*/oreDictAdd("oreGoldDense", Item.getByNameOrId("densemetals:dense_gold_ore"));
        /*铁致密矿石*/oreDictAdd("oreIronDense", Item.getByNameOrId("densemetals:dense_iron_ore"));
        /*铜致密矿石*/oreDictAdd("oreCopperDense", Item.getByNameOrId("densemetals:dense_copper_ore"));
        /*锡致密矿石*/oreDictAdd("oreTinDense", Item.getByNameOrId("densemetals:dense_tin_ore"));
        /*锌致密矿石*/oreDictAdd("oreZincDense", Item.getByNameOrId("densemetals:dense_zinc_ore"));
        /*铅致密矿石*/oreDictAdd("oreLeadDense", Item.getByNameOrId("densemetals:dense_lead_ore"));
        /*银致密矿石*/oreDictAdd("oreSilverDense", Item.getByNameOrId("densemetals:dense_silver_ore"));
        /*锇致密矿石*/oreDictAdd("oreOsmiumDense", Item.getByNameOrId("densemetals:dense_osmium_ore"));
        /*镍致密矿石*/oreDictAdd("oreNickelDense", Item.getByNameOrId("densemetals:dense_nickel_ore"));
        /*铱致密矿石*/oreDictAdd("oreIridiumDense", Item.getByNameOrId("densemetals:dense_iridium_ore"));
        /*铀致密矿石*/oreDictAdd("oreUraniumDense", Item.getByNameOrId("densemetals:dense_uranium_ore"));
        /*铂致密矿石*/oreDictAdd("orePlatinumDense", Item.getByNameOrId("densemetals:dense_platinum_ore"));
        /*钨致密矿石*/oreDictAdd("oreTungstenDense", Item.getByNameOrId("densemetals:dense_tungsten_ore"));
        /*铝致密矿石*/oreDictAdd("oreAluminiumDense", Item.getByNameOrId("densemetals:dense_aluminum_ore"));
        /*镁致密矿石*/oreDictAdd("oreMagnesiumDense", Item.getByNameOrId("densemetals:dense_magnesium_ore"));

        // 工业2-经典版
        /*稀土*/oreDictAdd("dustRareEarth", Item.getByNameOrId("ic2:itemmisc"), 14);

        // 工业升级
        //*锂矿石*/oreDictAdd("oreLithium", Item.getByNameOrId("industrialupgrade:baseore1"));
        //*聚丙烯*/oreDictAdd("polyPropylene", Item.getByNameOrId("industrialupgrade:crafting_elements"), 484);

        // 星系
        /*钛铁矿*/oreDictAdd("oreTitanium", Item.getByNameOrId("galacticraftplanets:asteroids_block"), 4);

        // 星空
        /*钴块*/oreDictAdd("blockCobalt", Item.getByNameOrId("galaxyspace:decoblocks"), 8);
        /*镍块*/oreDictAdd("blockNickel", Item.getByNameOrId("galaxyspace:decoblocks"), 9);
        /*镁块*/oreDictAdd("blockMagnesium", Item.getByNameOrId("galaxyspace:decoblocks"), 10);

        /*钴粒*/oreDictAdd("nuggetCobalt", Item.getByNameOrId("galaxyspace:nuggets"));
        /*镍粒*/oreDictAdd("nuggetNickel", Item.getByNameOrId("galaxyspace:nuggets"), 2);
        /*镁粒*/oreDictAdd("nuggetMagnesium", Item.getByNameOrId("galaxyspace:nuggets"), 1);

        /*压缩钴*/oreDictAdd("compressedCobalt", Item.getByNameOrId("galaxyspace:compressed_plates"), 1);
        /*压缩镍*/oreDictAdd("compressedNickel", Item.getByNameOrId("galaxyspace:compressed_plates"), 3);
        /*压缩镁*/oreDictAdd("compressedMagnesium", Item.getByNameOrId("galaxyspace:compressed_plates"), 2);

        // 冒险漩涡
        /*金矿石*/oreDictAdd("oreGold", Item.getByNameOrId("mm:azure_gold_ore"));
        /*铁矿石*/oreDictAdd("oreIron", Item.getByNameOrId("mm:azure_iron_ore"));
        /*裂金矿石*/oreDictAdd("oreChasmium", Item.getByNameOrId("mm:chasmium_ore"));
        /*裂金锭*/oreDictAdd("ingotChasmium", Item.getByNameOrId("mm:chasmium_ingot"));

        // 铱矿产
        /*铂矿石*/oreDictAdd("orePlatinum", Item.getByNameOrId("iridiumsource:ore_overworld"));
        /*下界铂矿石*/oreDictAdd("orePlatinum", Item.getByNameOrId("iridiumsource:ore_nether"));
        /*末地铂矿石*/oreDictAdd("orePlatinum", Item.getByNameOrId("iridiumsource:ore_end"));
        /*铂颗粒*/oreDictAdd("prillPlatinum", Item.getByNameOrId("iridiumsource:prill_platina"));

        // 虚拟人生
        /*玫瑰金矿石*/oreDictAdd("oreRosegold", Item.getByNameOrId("mca:rose_gold_ore"));
        /*玫瑰金锭*/oreDictAdd("ingotRosegold", Item.getByNameOrId("mca:rose_gold_ingot"));

        // 维克的现代战争
        /*铜矿石*/oreDictAdd("oreCopper", Item.getByNameOrId("mw:copperore"));
        /*锡矿石*/oreDictAdd("oreTin", Item.getByNameOrId("mw:tinore"));
        /*铅矿石*/oreDictAdd("oreLead", Item.getByNameOrId("mw:leadore"));
        /*钛矿石*/oreDictAdd("oreTitanium", Item.getByNameOrId("mw:titaniumore"));
        /*铝矿石*/oreDictAdd("oreAluminium", Item.getByNameOrId("mw:bauxiteore"));
        /*钽矿石*/oreDictAdd("oreTantalum", Item.getByNameOrId("mw:tantalumore"));

        // 试炼更新
        /*铜矿石*/oreDictAdd("oreCopper", Item.getByNameOrId("deeperdepths:copper_ore"));
        /* 铜块 */oreDictAdd("blockCopperRaw", Item.getByNameOrId("deeperdepths:copper_block"));

        //
        //*矾土*/oreDictAdd("rawAluminium", Item.getByNameOrId("chinjufumod:item_bauxite"));
        //*矾土矿*/oreDictAdd("rawAluminium", Item.getByNameOrId("chinjufumod:block_bauxite_ore"));

        // 简单矿石
        /*秘银矿石*/oreDictAdd("oreMithril", Item.getByNameOrId("simpleores:mythril_ore"));
        /*秘银锭*/oreDictAdd("ingotMithril", Item.getByNameOrId("simpleores:mythril_ingot"));

        // 科技枪
        /*钛矿石*/oreDictAdd("oreTitanium", Item.getByNameOrId("techguns:basicore"), 3);

        // 神秘时代6
        /*稀土*/oreDictAdd("dustRareEarth", Item.getByNameOrId("thaumcraft:nugget"), 10);
    }

//注册矿词方法
    public static void oreDictAdd(String ore, Item item) {
        oreDictAdd(ore, item, 0);
    }
    public static void oreDictAdd(String ore, Item item, int mate) {
        if (item != null) {
            ItemStack itemStack = new ItemStack(item, 1, mate);
            if (ItemBase.isValidItemStack(itemStack)) {
                OreDictionary.registerOre(ore, itemStack);
            }
        }
    }
}
package suike.suikerawore.oredictionary.oredictionaryadd;

import suike.suikerawore.item.ItemBase;
import suike.suikerawore.expand.Examine;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraftforge.oredict.OreDictionary;

public class AddExpandOreDict {
    public static void oreDictAdd() {
        //星空
        if (Examine.GalaxySpaceID) {
            /*钴块*/oreDictAdd("blockCobalt", Item.getByNameOrId("galaxyspace:decoblocks"), 8);
            /*镍块*/oreDictAdd("blockNickel", Item.getByNameOrId("galaxyspace:decoblocks"), 9);
            /*镁块*/oreDictAdd("blockMagnesium", Item.getByNameOrId("galaxyspace:decoblocks"), 10);

            /*钴粒*/oreDictAdd("nuggetCobalt", Item.getByNameOrId("galaxyspace:nuggets"), 0);
            /*镍粒*/oreDictAdd("nuggetNickel", Item.getByNameOrId("galaxyspace:nuggets"), 2);
            /*镁粒*/oreDictAdd("nuggetMagnesium", Item.getByNameOrId("galaxyspace:nuggets"), 1);

            /*压缩钴*/oreDictAdd("compressedCobalt", Item.getByNameOrId("galaxyspace:compressed_plates"), 1);
            /*压缩镍*/oreDictAdd("compressedNickel", Item.getByNameOrId("galaxyspace:compressed_plates"), 3);
            /*压缩镁*/oreDictAdd("compressedMagnesium", Item.getByNameOrId("galaxyspace:compressed_plates"), 2);
        }

        //冒险漩涡
        if (Examine.MaelstromID) {
            /*金矿石*/oreDictAdd("oreGold", Item.getByNameOrId("mm:azure_gold_ore"));
            /*铁矿石*/oreDictAdd("oreIron", Item.getByNameOrId("mm:azure_iron_ore"));
            /*裂金矿石*/oreDictAdd("oreChasmium", Item.getByNameOrId("mm:chasmium_ore"));
            /*裂金锭*/oreDictAdd("ingotChasmium", Item.getByNameOrId("mm:chasmium_ingot"));
        }

        //铱矿产
        if (Examine.iridiumsourceID) {
            /*铂矿石*/oreDictAdd("orePlatinum", Item.getByNameOrId("iridiumsource:ore_overworld"));
            /*下界铂矿石*/oreDictAdd("orePlatinum", Item.getByNameOrId("iridiumsource:ore_nether"));
            /*末地铂矿石*/oreDictAdd("orePlatinum", Item.getByNameOrId("iridiumsource:ore_end"));
            /*铂颗粒*/oreDictAdd("prillPlatinum", Item.getByNameOrId("iridiumsource:prill_platina"));
        }

        //虚拟人生
        if (Examine.虚拟人生) {
            /*玫瑰金锭*/oreDictAdd("ingotRosegold", Item.getByNameOrId("mca:rose_gold_ingot"));
        }

        //维克的现代战争
        if (Examine.VicSWarfareID) {
            /*铜矿石*/oreDictAdd("oreCopper", Item.getByNameOrId("mw:copperore"));
            /*锡矿石*/oreDictAdd("oreTin", Item.getByNameOrId("mw:tinore"));
            /*铅矿石*/oreDictAdd("oreLead", Item.getByNameOrId("mw:leadore"));
            /*钛矿石*/oreDictAdd("oreTitanium", Item.getByNameOrId("mw:titaniumore"));
            /*铝矿石*/oreDictAdd("oreAluminium", Item.getByNameOrId("mw:bauxiteore"));
            /*钽矿石*/oreDictAdd("oreTantalum", Item.getByNameOrId("mw:tantalumore"));
        }

        //工业升级
        if (Examine.IC2UpgradeID) {
            /*锂矿石*/oreDictAdd("oreLithium", Item.getByNameOrId("industrialupgrade:baseore1"), 0);
            /*聚丙烯*/oreDictAdd("polyPropylene", Item.getByNameOrId("industrialupgrade:crafting_elements"), 484);
        }

        //试炼更新
        if (Examine.deeperdepthsID) {
            /*铜矿石*/oreDictAdd("oreCopper", Item.getByNameOrId("deeperdepths:copper_ore"), 0);
            /* 铜块 */oreDictAdd("blockCopperRaw", Item.getByNameOrId("deeperdepths:copper_block"), 0);
        }

        /*矾土*/oreDictAdd("rawAluminium", Item.getByNameOrId("chinjufumod:item_bauxite"), 0);
        /*矾土矿*/oreDictAdd("rawAluminium", Item.getByNameOrId("chinjufumod:block_bauxite_ore"), 0);
    }

//注册矿词方法
    public static void oreDictAdd(String ore, Item item) {
        oreDictAdd(ore, item, 0);
    }
    public static void oreDictAdd(String ore, Item item, int mate) {
        ItemStack itemStack = new ItemStack(item, 1, mate);
        if (ItemBase.isValidItemStack(itemStack)) {
            OreDictionary.registerOre(ore, itemStack);
        }
    }
}
package suike.suikerawore.oredictionary.oredictionaryobtain;

import java.util.Set;

import suike.suikerawore.oredictionary.OreDictList;

import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.block.state.IBlockState;

//获取各矿石矿词
public class ObtainOresMore {
    public static void Obtain() {
        /*阿迪特*/addList("tconstruct:ore", 1, OreDictList.oreArdite);
        /* 晶蓝 */addList("theaurorian:ceruleanore", 0, OreDictList.oreCerulean);
        /*皎月石*/addList("theaurorian:moonstoneore", 0, OreDictList.oreMoonstone);
        /*炽炎铁*/addList("thebetweenlands:octine_ingot", 0, OreDictList.oreOctine);
        /*赛摩铜*/addList("thebetweenlands:syrmorite_ore", 0, OreDictList.oreSyrmorite);
        /* 朱砂 */addList("thaumcraft:ore_cinnabar", 0, OreDictList.oreCinnabar);
        /*软碲铜*/addList("vulcanite:vulcanite_ore", 0, OreDictList.oreVulcanite);
        /*软碲铜*/addList("vulcanite:nether_vulcanite_ore", 0, OreDictList.oreVulcanite);
        /* 裂金 */addList("mm:chasmium_ore", 0, OreDictList.oreChasmium);
        /*玫瑰金*/addList("mca:rose_gold_ore", 0, OreDictList.oreRoseGold);
    }

    public static void addList(String name, int meta, Set<IBlockState> oreList) {
        Block block = Block.getBlockFromItem(Item.getByNameOrId(name));

        if (block != null && !block.toString().equals("Block{minecraft:air}")) {
            /*单个矿石列表*/oreList.add(block.getStateFromMeta(meta));
            /*本类矿石列表*/OreDictList.oreMore.add(block.getStateFromMeta(meta));
            /*总矿石列表*/OreDictList.oreStone.add(block.getStateFromMeta(meta));
        }
    }
}
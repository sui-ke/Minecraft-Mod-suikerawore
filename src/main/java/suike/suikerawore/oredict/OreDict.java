package suike.suikerawore.oredict;

import java.util.Map;
import java.util.List;

import suike.suikerawore.item.*;
import suike.suikerawore.block.*;
import suike.suikerawore.inter.IItemEntry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;

import net.minecraftforge.oredict.OreDictionary;

public class OreDict {
// 添加联动矿词
    public static void oreDictExpand() {
        // 其他模组矿词
        AddExpandOreDict.oreDictAdd();
        // 删除矿词
        oreDictRemove();
    }

// 添加物品矿词
    public static void oreDictAdd() {
        for (Map.Entry<String, ModItemRawOre> mapEntry : ModItemRawOre.TYPE_TO_RAW_ORE.entrySet()) {
            ModItemRawOre rawOre = mapEntry.getValue();
            /*粗矿*/oreDictAdd(rawOre);
            /*粗块*/oreDictAdd(rawOre.getRefinedObject());
            /*金属锭*/oreDictAdd(rawOre.getCompressBlock());
            /*金属块*/oreDictAdd(rawOre.getCompressBlock().getRefinedObject());
        }
    }

    private static void oreDictAdd(Object object) {
        if (object instanceof IItemEntry) {
            IItemEntry entry = (IItemEntry) object;
            if (entry.isValid()) {
                if (entry instanceof ModItemRawOre) {
                    oreDictAdd(new ItemStack((ItemBase) entry), entry.getItemOreDict(), /*entry.getItemOreDict().replace("raw", "ore"),*/ "rawMaterials");
                }
                else if (entry instanceof ItemBase) {
                    oreDictAdd(new ItemStack((ItemBase) entry), entry.getItemOreDict());
                }
                else if (entry instanceof BlockBase) {
                    oreDictAdd(new ItemStack(((BlockBase) entry).getItem()), entry.getItemOreDict());
                }
            }
        }
    }

    private static void oreDictAdd(ItemStack item, String... oreDict) {
        if (oreDict.length > 0 && ItemBase.isValidItemStack(item)) {
            for (int i = 0; i < oreDict.length; i++) {
                if (!oreDict[i].isEmpty()) {
                    OreDictionary.registerOre(oreDict[i], item);
                }
            }
        }
    }

// 删除矿词方法
    private static void oreDictRemove() {
        oreDictRemove("libvulpes:ore0", 8, "oreRutile");
    }

    private static void oreDictRemove(String itemName, int mate, String oreDict) {
        Item item = Item.getByNameOrId(itemName);
        if (item == null) return;

        ItemStack stack = new ItemStack(item, 1 , mate);
        if (!ItemBase.isValidItemStack(stack)) return;

        List<ItemStack> ores = OreDictionary.getOres(oreDict);

        ores.removeIf(itemStack -> ItemStack.areItemStacksEqual(stack, itemStack));
    }
}
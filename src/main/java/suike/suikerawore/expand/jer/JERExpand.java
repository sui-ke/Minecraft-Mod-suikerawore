package suike.suikerawore.expand.jer;

import suike.suikerawore.item.ItemBase;
import suike.suikerawore.config.ConfigValue;

import jeresources.api.drop.LootDrop;
import jeresources.api.IWorldGenRegistry;
import jeresources.compatibility.JERAPI;

import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import net.minecraftforge.oredict.OreDictionary;

public class JERExpand {
    public static void addDrop() {
        worldGenRegistry = JERAPI.getInstance().getWorldGenRegistry();
        if (worldGenRegistry == null)
            return;

        /*金*/addDrop("Gold");
        /*铁*/addDrop("Iron");
        /*铜*/addDrop("Copper");
        /*锡*/addDrop("Tin");
        /*锌*/addDrop("Zinc");
        /*铅*/addDrop("Lead");
        /*银*/addDrop("Silver");
        /*钴*/addDrop("Cobalt");
        /*锇*/addDrop("Osmium");
        /*镍*/addDrop("Nickel");
        /*铱*/addDrop("Iridium");
        /*铀*/addDrop("Uranium");
        /*镓*/addDrop("Gallium");
        /*钛*/addDrop("Titanium");
        /*铂*/addDrop("Platinum");
        /*钨*/addDrop("Tungsten");
        /*铝*/addDrop("Aluminium");
        /*镁*/addDrop("Magnesium");
        /*锂*/addDrop("Lithium");
        /*钍*/addDrop("Thorium");
        /*硼*/addDrop("Boron");
        /*钒*/addDrop("Vanadium");
        /*镉*/addDrop("Cadmium");
        /*锰*/addDrop("Manganese");
        /*锗*/addDrop("Germanium");
        /*铬*/addDrop("Chromium");
        /*砷*/addDrop("Arsenic");
        /*铍*/addDrop("Beryllium");
        /*镭*/addDrop("Irradium");
        /*钯*/addDrop("Palladium");
        /*钚*/addDrop("Plutonium");
        /*秘银*/addDrop("Mithril");
        /*金红石*/addDrop("Rutile");

        /*阿迪特*/addDrop("Ardite");
        /* 晶蓝 */addDrop("Cerulean");
        /*皎月石*/addDrop("Moonstone");
        /*炽炎铁*/addDrop("Octine");
        /*赛摩铜*/addDrop("Syrmorite");
        /* 朱砂 */addDrop("Cinnabar");
        /*软碲铜*/addDrop("Vulcanite");
        /* 裂金 */addDrop("Chasmium");
        /*玫瑰金*/addDrop("Rosegold");
    }

    public static IWorldGenRegistry worldGenRegistry = null;
    public static void addDrop(String type) {
        addDrop(OreDictionary.getOres("ore" + type), ItemBase.oreStack("raw" + type));
    }
    public static void addDrop(NonNullList<ItemStack> ores, ItemStack dropStack) {
        if (!ores.isEmpty() && !dropStack.isEmpty()) {
            LootDrop drop = new LootDrop(dropStack, ConfigValue.rawOreDropAmount);
            for (ItemStack ore : ores) {
                if (ItemBase.isValidItemStack(ore)) {
                    worldGenRegistry.registerDrops(ore, drop);
                }
            }
        }
    }
}
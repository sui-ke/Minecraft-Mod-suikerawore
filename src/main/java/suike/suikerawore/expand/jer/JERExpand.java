// package suike.suikerawore.expand.jer;

// import suike.suikerawore.item.ItemBase;

// import jeresources.api.drop.LootDrop;
// import jeresources.api.conditionals.Conditional;
// import jeresources.registry.WorldGenRegistry;

// import net.minecraft.item.Item;
// import net.minecraft.item.ItemStack;
// import net.minecraft.util.NonNullList;

// import net.minecraftforge.oredict.OreDictionary;

// public class JERExpand {
//     public static void addDrop() {
//         /*金*/addDrop("Gold");
//         /*铁*/addDrop("Iron");
//         /*铜*/addDrop("Copper");
//         /*锡*/addDrop("Tin");
//         /*锌*/addDrop("Zinc");
//         /*铅*/addDrop("Lead");
//         /*银*/addDrop("Silver");
//         /*钴*/addDrop("Cobalt");
//         /*锇*/addDrop("Osmium");
//         /*镍*/addDrop("Nickel");
//         /*铱*/addDrop("Iridium");
//         /*铀*/addDrop("Uranium");
//         /*镓*/addDrop("Gallium");
//         /*钛*/addDrop("Titanium");
//         /*铂*/addDrop("Platinum");
//         /*钨*/addDrop("Tungsten");
//         /*铝*/addDrop("Aluminum", new ItemStack(ItemBase.RAW_ALUMINIUM));
//         /*铝*/addDrop("Aluminium");
//         /*镁*/addDrop("Magnesium");
//         /*锂*/addDrop("Lithium");
//         /*钍*/addDrop("Thorium");
//         /*硼*/addDrop("Boron");
//         /*钒*/addDrop("Vanadium");
//         /*镉*/addDrop("Cadmium");
//         /*锰*/addDrop("Manganese");
//         /*锗*/addDrop("Germanium");

//         /*阿迪特*/addDrop("Ardite");
//         /* 晶蓝 */addDrop("Cerulean");
//         /*皎月石*/addDrop("Moonstone");
//         /*炽炎铁*/addDrop("Octine");
//         /*赛摩铜*/addDrop("Syrmorite");
//         /* 朱砂 */addDrop("Cinnabar");
//         /*软碲铜*/addDrop("Vulcanite");
//         /* 裂金 */addDrop("Chasmium");
//     }

//     public static void addDrop(String type) {
//         addDrop(type, ItemBase.oreStack("raw" + type));
//     }
//     public static void addDrop(String type, ItemStack dropStack) {
//         NonNullList<ItemStack> ores = OreDictionary.getOres("ore" + type);
//         for (ItemStack ore : ores) {
//             if (ItemBase.isValidItemStack(ore)) {
//                 WorldGenRegistry.getInstance().addDrops(ore, new LootDrop(dropStack));
//             }
//         }
//     }
// }
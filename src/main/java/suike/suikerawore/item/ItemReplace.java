/*package suike.suikerawore.item;

import java.util.HashMap;
import java.util.Map;

import suike.suikerawore.item.ItemBase;

import com.google.common.collect.UnmodifiableIterator;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent.MissingMappings;

@Mod.EventBusSubscriber
public class ItemReplace {

    private static Map<String, String> OLD_TO_NEW_ITEMS = new HashMap();
    private static Map<String, String> OLD_TO_NEW_BLOCKS = new HashMap();

    static {
        /*铜//*|/OLD_TO_NEW_ITEMS.put("suikerawore:ingot_copper", "ingotCopper");
        /*锡//*|/OLD_TO_NEW_ITEMS.put("suikerawore:ingot_tin", "ingotTin");
        /*锌//*|/OLD_TO_NEW_ITEMS.put("suikerawore:ingot_zinc", "ingotZinc");
        /*铅//*|/OLD_TO_NEW_ITEMS.put("suikerawore:ingot_lead", "ingotLead");
        /*银//*|/OLD_TO_NEW_ITEMS.put("suikerawore:ingot_silver", "ingotSilver");
        /*钴//*|/OLD_TO_NEW_ITEMS.put("suikerawore:ingot_cobalt", "ingotCobalt");
        /*锇//*|/OLD_TO_NEW_ITEMS.put("suikerawore:ingot_osmium", "ingotOsmium");
        /*镍//*|/OLD_TO_NEW_ITEMS.put("suikerawore:ingot_nickel", "ingotNickel");
        /*铱//*|/OLD_TO_NEW_ITEMS.put("suikerawore:ingot_iridium", "ingotIridium");
        /*铀//*|/OLD_TO_NEW_ITEMS.put("suikerawore:ingot_uranium", "ingotUranium");
        /*镓//*|/OLD_TO_NEW_ITEMS.put("suikerawore:ingot_gallium", "ingotGallium");
        /*钛//*|/OLD_TO_NEW_ITEMS.put("suikerawore:ingot_titanium", "ingotTitanium");
        /*铂//*|/OLD_TO_NEW_ITEMS.put("suikerawore:ingot_platinum", "ingotPlatinum");
        /*钨//*|/OLD_TO_NEW_ITEMS.put("suikerawore:ingot_tungsten", "ingotTungsten");
        /*铝//*|/OLD_TO_NEW_ITEMS.put("suikerawore:ingot_aluminium", "ingotAluminium");
        /*镁//*|/OLD_TO_NEW_ITEMS.put("suikerawore:ingot_magnesium", "ingotMagnesium");
        /*锂//*|/OLD_TO_NEW_ITEMS.put("suikerawore:ingot_lithium", "ingotLithium");
        /*钍//*|/OLD_TO_NEW_ITEMS.put("suikerawore:ingot_thorium", "ingotThorium");
        /*硼//*|/OLD_TO_NEW_ITEMS.put("suikerawore:ingot_boron", "ingotBoron");
        /*钒//*|/OLD_TO_NEW_ITEMS.put("suikerawore:ingot_vanadium", "ingotVanadium");
        /*镉//*|/OLD_TO_NEW_ITEMS.put("suikerawore:ingot_cadmium", "ingotCadmium");
        /*锰//*|/OLD_TO_NEW_ITEMS.put("suikerawore:ingot_manganese", "ingotManganese");
        /*锗//*|/OLD_TO_NEW_ITEMS.put("suikerawore:ingot_germanium", "ingotGermanium");
        /*铬//*|/OLD_TO_NEW_ITEMS.put("suikerawore:ingot_chromium", "ingotChromium");
        /*砷//*|/OLD_TO_NEW_ITEMS.put("suikerawore:ingot_arsenic", "ingotArsenic");
    }

    static {
        /*铜//*|/OLD_TO_NEW_BLOCKS.put("suikerawore:block_copper", "blockCopper");
        /*锡//*|/OLD_TO_NEW_BLOCKS.put("suikerawore:block_tin", "blockTin");
        /*锌//*|/OLD_TO_NEW_BLOCKS.put("suikerawore:block_zinc", "blockZinc");
        /*铅//*|/OLD_TO_NEW_BLOCKS.put("suikerawore:block_lead", "blockLead");
        /*银//*|/OLD_TO_NEW_BLOCKS.put("suikerawore:block_silver", "blockSilver");
        /*钴//*|/OLD_TO_NEW_BLOCKS.put("suikerawore:block_cobalt", "blockCobalt");
        /*锇//*|/OLD_TO_NEW_BLOCKS.put("suikerawore:block_osmium", "blockOsmium");
        /*镍//*|/OLD_TO_NEW_BLOCKS.put("suikerawore:block_nickel", "blockNickel");
        /*铱//*|/OLD_TO_NEW_BLOCKS.put("suikerawore:block_iridium", "blockIridium");
        /*铀//*|/OLD_TO_NEW_BLOCKS.put("suikerawore:block_uranium", "blockUranium");
        /*镓//*|/OLD_TO_NEW_BLOCKS.put("suikerawore:block_gallium", "blockGallium");
        /*钛//*|/OLD_TO_NEW_BLOCKS.put("suikerawore:block_titanium", "blockTitanium");
        /*铂//*|/OLD_TO_NEW_BLOCKS.put("suikerawore:block_platinum", "blockPlatinum");
        /*钨//*|/OLD_TO_NEW_BLOCKS.put("suikerawore:block_tungsten", "blockTungsten");
        /*铝//*|/OLD_TO_NEW_BLOCKS.put("suikerawore:block_aluminium", "blockAluminium");
        /*镁//*|/OLD_TO_NEW_BLOCKS.put("suikerawore:block_magnesium", "blockMagnesium");
        /*锂//*|/OLD_TO_NEW_BLOCKS.put("suikerawore:block_lithium", "blockLithium");
        /*钍//*|/OLD_TO_NEW_BLOCKS.put("suikerawore:block_thorium", "blockThorium");
        /*硼//*|/OLD_TO_NEW_BLOCKS.put("suikerawore:block_boron", "blockBoron");
        /*钒//*|/OLD_TO_NEW_BLOCKS.put("suikerawore:block_vanadium", "blockVanadium");
        /*镉//*|/OLD_TO_NEW_BLOCKS.put("suikerawore:block_cadmium", "blockCadmium");
        /*锰//*|/OLD_TO_NEW_BLOCKS.put("suikerawore:block_manganese", "blockManganese");
        /*锗//*|/OLD_TO_NEW_BLOCKS.put("suikerawore:block_germanium", "blockGermanium");
        /*铬//*|/OLD_TO_NEW_BLOCKS.put("suikerawore:block_chromium", "blockChromium");
        /*砷//*|/OLD_TO_NEW_BLOCKS.put("suikerawore:block_arsenic", "blockArsenic");

        OLD_TO_NEW_ITEMS.putAll(OLD_TO_NEW_BLOCKS);
    }

    @SubscribeEvent
    public static void onMissingMappingsItems(MissingMappings<Item> event) {
        for (MissingMappings.Mapping<Item> mapping : event.getAllMappings()) {
            String oldItemKey = mapping.key.toString(); // 获取旧物品的 key

            if (OLD_TO_NEW_ITEMS.containsKey(oldItemKey)) {
                //通过矿词获取新物品
                ItemStack itemStack = ItemBase.oreStack(OLD_TO_NEW_ITEMS.get(oldItemKey));

                if (ItemBase.isValidItemStack(itemStack)) {
                    /*替换为新物品//*|/mapping.remap(itemStack.getItem());
                } else {
                    /*物品不存在//*|/mapping.remap(Items.AIR);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onMissingMappingsBlocks(MissingMappings<Block> event) {
        for (MissingMappings.Mapping<Block> mapping : event.getAllMappings()) {
            String oldBlockKey = mapping.key.toString(); // 获取旧方块的 key

            if (OLD_TO_NEW_BLOCKS.containsKey(oldBlockKey)) {
                //通过矿词获取新方块
                ItemStack itemStack = ItemBase.oreStack(OLD_TO_NEW_BLOCKS.get(oldBlockKey));

                if (ItemBase.isValidItemStack(itemStack)) {
                    Block newBlock = Block.getBlockFromItem(itemStack.getItem());
                    /*替换为新方块//*|/mapping.remap(newBlock);
                } else {
                    /*方块不存在//*|/mapping.remap(Blocks.AIR);
                }
            }
        }
    }
}*/
package com.suike.suikerawore.item;

import java.util.List;
import java.util.ArrayList;

import com.suike.suikerawore.SuiKe;
import com.suike.suikerawore.expand.Examine;

import net.minecraft.item.Item;

import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class ItemBase extends Item {

    public static final List<Item> ITEMS = new ArrayList<>();
    
    /*金*/public static final Item RAW_GOLD = new ItemBase("raw_gold", true);
    /*铁*/public static final Item RAW_IRON = new ItemBase("raw_iron", true);
    /*铜*/public static final Item RAW_COPPER = new ItemBase("raw_copper", true);
    /*锡*/public static final Item RAW_TIN = new ItemBase("raw_tin", true);
    /*锌*/public static final Item RAW_ZINC = new ItemBase("raw_zinc", true);
    /*铅*/public static final Item RAW_LEAD = new ItemBase("raw_lead", true);
    /*银*/public static final Item RAW_SILVER = new ItemBase("raw_silver", true);
    /*钴*/public static final Item RAW_COBALT = new ItemBase("raw_cobalt", true);
    /*锇*/public static final Item RAW_OSMIUM = new ItemBase("raw_osmium", true);
    /*镍*/public static final Item RAW_NICKEL = new ItemBase("raw_nickel", true);
    /*铱*/public static final Item RAW_IRIDIUM = new ItemBase("raw_iridium", true);
    /*铀*/public static final Item RAW_URANIUM = new ItemBase("raw_uranium", true);
    /*镓*/public static final Item RAW_GALLIUM = new ItemBase("raw_gallium", true);
    /*钛*/public static final Item RAW_TITANIUM = new ItemBase("raw_titanium", true);
    /*铂*/public static final Item RAW_PLATINUM = new ItemBase("raw_platinum", true);
    /*钨*/public static final Item RAW_TUNGSTEN = new ItemBase("raw_tungsten", true);
    /*铝*/public static final Item RAW_ALUMINIUM = new ItemBase("raw_aluminium", true);
    /*镁*/public static final Item RAW_MAGNESIUM = new ItemBase("raw_magnesium", true);
    /*锂*/public static final Item RAW_LITHIUM = new ItemBase("raw_lithium", true);
    /*钍*/public static final Item RAW_THORIUM = new ItemBase("raw_thorium", true);
    /*硼*/public static final Item RAW_BORON = new ItemBase("raw_boron", true);

    /*更多粗矿*/
    /*阿迪特*/public static final Item RAW_ARDITE = new ItemBase("raw_ardite", Examine.TCID);

    /*晶蓝*/public static final Item RAW_CERULEAN = new ItemBase("raw_cerulean", Examine.TheAurorianID);
    /*皎月石*/public static final Item RAW_MOONSTONE = new ItemBase("raw_moonstone", Examine.TheAurorianID);

    /*炽炎铁*/public static final Item RAW_OCTINE = new ItemBase("raw_octine", Examine.TheBetweenlandsID);
    /*赛摩铜*/public static final Item RAW_SYRMORITE = new ItemBase("raw_syrmorite", Examine.TheBetweenlandsID);

    /*锭*/
    /*铜*/public static final Item INGOT_COPPER = new ItemBase("ingot_copper", true);
    /*锡*/public static final Item INGOT_TIN = new ItemBase("ingot_tin", true);
    /*锌*/public static final Item INGOT_ZINC = new ItemBase("ingot_zinc", true);
    /*铅*/public static final Item INGOT_LEAD = new ItemBase("ingot_lead", true);
    /*银*/public static final Item INGOT_SILVER = new ItemBase("ingot_silver", true);
    /*钴*/public static final Item INGOT_COBALT = new ItemBase("ingot_cobalt", true);
    /*锇*/public static final Item INGOT_OSMIUM = new ItemBase("ingot_osmium", true);
    /*镍*/public static final Item INGOT_NICKEL = new ItemBase("ingot_nickel", true);
    /*铱*/public static final Item INGOT_IRIDIUM = new ItemBase("ingot_iridium", true);
    /*铀*/public static final Item INGOT_URANIUM = new ItemBase("ingot_uranium", true);
    /*镓*/public static final Item INGOT_GALLIUM = new ItemBase("ingot_gallium", true);
    /*钛*/public static final Item INGOT_TITANIUM = new ItemBase("ingot_titanium", true);
    /*铂*/public static final Item INGOT_PLATINUM = new ItemBase("ingot_platinum", true);
    /*钨*/public static final Item INGOT_TUNGSTEN = new ItemBase("ingot_tungsten", true);
    /*铝*/public static final Item INGOT_ALUMINIUM = new ItemBase("ingot_aluminium", true);
    /*镁*/public static final Item INGOT_MAGNESIUM = new ItemBase("ingot_magnesium", true);
    /*锂*/public static final Item INGOT_LITHIUM = new ItemBase("ingot_lithium", true);
    /*钍*/public static final Item INGOT_THORIUM = new ItemBase("ingot_thorium", true);
    /*硼*/public static final Item INGOT_BORON = new ItemBase("ingot_boron", true);

    /*铝粒*/public static final Item NUGGET_ALUMINIUM = new ItemBase("nugget_aluminium", true);

    public ItemBase(String name, boolean a) {
        if (a) {
            /*设置物品名*/setUnlocalizedName(name);
            /*设置物品名*/setRegistryName(name);

            /*添加到ITEMS列表*/ITEMS.add(this);
        }
    }

    //注册物品
    @SubscribeEvent
    public static void onRegisterItems(RegistryEvent.Register<Item> event) {

        IForgeRegistry<Item> registry = event.getRegistry();
        registry.registerAll(ITEMS.toArray(new Item[0]));
    }

    //注册渲染
    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event) {
        for (Item item : ITEMS) {
            if (item instanceof ItemBase) {
                ((ItemBase) item).registerModels();
            }
        }
    }

    //注册渲染
    public void registerModels() {

        SuiKe.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
package com.suike.suikerawore.item;

import java.util.List;
import java.util.ArrayList;

import com.suike.suikerawore.SuiKe;
import com.suike.suikerawore.item.ItemBase;
import com.suike.suikerawore.expand.Examine;

import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class BlockBase extends Block {

    public static final List<Block> BLOCKS = new ArrayList<>();

    /*金*/public static final Block RAW_BLOCK_GOLD = new BlockBase("raw_block_gold", Material.IRON, 2, 10.0F, 20.0F, true);
    /*铁*/public static final Block RAW_BLOCK_IRON = new BlockBase("raw_block_iron", Material.IRON, 2, 10.0F, 20.0F, true);
    /*铜*/public static final Block RAW_BLOCK_COPPER = new BlockBase("raw_block_copper", Material.IRON, 1, 10.0F, 20.0F, true);
    /*锡*/public static final Block RAW_BLOCK_TIN = new BlockBase("raw_block_tin", Material.IRON, 2, 10.0F, 20.0F, true);
    /*锌*/public static final Block RAW_BLOCK_ZINC = new BlockBase("raw_block_zinc", Material.IRON, 2, 10.0F, 20.0F, true);
    /*铅*/public static final Block RAW_BLOCK_LEAD = new BlockBase("raw_block_lead", Material.IRON, 2, 10.0F, 20.0F, true);
    /*银*/public static final Block RAW_BLOCK_SILVER = new BlockBase("raw_block_silver", Material.IRON, 2, 10.0F, 20.0F, true);
    /*钴*/public static final Block RAW_BLOCK_COBALT = new BlockBase("raw_block_cobalt", Material.IRON, 2, 10.0F, 20.0F, true);
    /*锇*/public static final Block RAW_BLOCK_OSMIUM = new BlockBase("raw_block_osmium", Material.IRON, 2, 10.0F, 20.0F, true);
    /*镍*/public static final Block RAW_BLOCK_NICKEL = new BlockBase("raw_block_nickel", Material.IRON, 2, 10.0F, 20.0F, true);
    /*铱*/public static final Block RAW_BLOCK_IRIDIUM = new BlockBase("raw_block_iridium", Material.IRON, 2, 10.0F, 20.0F, true);
    /*铀*/public static final Block RAW_BLOCK_URANIUM = new BlockBase("raw_block_uranium", Material.IRON, 2, 10.0F, 20.0F, true);
    /*镓*/public static final Block RAW_BLOCK_GALLIUM = new BlockBase("raw_block_gallium", Material.IRON, 2, 10.0F, 20.0F, true);
    /*钛*/public static final Block RAW_BLOCK_TITANIUM = new BlockBase("raw_block_titanium", Material.IRON, 2, 10.0F, 20.0F, true);
    /*铂*/public static final Block RAW_BLOCK_PLATINUM = new BlockBase("raw_block_platinum", Material.IRON, 2, 10.0F, 20.0F, true);
    /*钨*/public static final Block RAW_BLOCK_TUNGSTEN = new BlockBase("raw_block_tungsten", Material.IRON, 2, 10.0F, 20.0F, true);
    /*铝*/public static final Block RAW_BLOCK_ALUMINIUM = new BlockBase("raw_block_aluminium", Material.IRON, 2, 10.0F, 20.0F, true);
    /*镁*/public static final Block RAW_BLOCK_MAGNESIUM = new BlockBase("raw_block_magnesium", Material.IRON, 2, 10.0F, 20.0F, true);
    /*锂*/public static final Block RAW_BLOCK_LITHIUM = new BlockBase("raw_block_lithium", Material.IRON, 2, 10.0F, 20.0F, true);
    /*钍*/public static final Block RAW_BLOCK_THORIUM = new BlockBase("raw_block_thorium", Material.IRON, 2, 10.0F, 20.0F, true);
    /*硼*/public static final Block RAW_BLOCK_BORON = new BlockBase("raw_block_boron", Material.IRON, 2, 10.0F, 20.0F, true);

    /*更多粗块*/
    /*阿迪特*/public static final Block RAW_BLOCK_ARDITE = new BlockBase("raw_block_ardite", Material.IRON, 2, 10.0F, 20.0F, Examine.TCID);

    /*晶蓝*/public static final Block RAW_BLOCK_CERULEAN = new BlockBase("raw_block_cerulean", Material.IRON, 2, 10.0F, 20.0F, Examine.TheAurorianID);
    /*皎月石*/public static final Block RAW_BLOCK_MOONSTONE = new BlockBase("raw_block_moonstone", Material.IRON, 2, 10.0F, 20.0F, Examine.TheAurorianID).setLightLevel(7.0F);;

    /*炽炎铁*/public static final Block RAW_BLOCK_OCTINE = new BlockBase("raw_block_octine", Material.IRON, 2, 10.0F, 20.0F, Examine.TheBetweenlandsID).setLightLevel(7.0F);
    /*赛摩铜*/public static final Block RAW_BLOCK_SYRMORITE = new BlockBase("raw_block_syrmorite", Material.IRON, 2, 10.0F, 20.0F, Examine.TheBetweenlandsID);

    /*金属块*/
    /*铜*/public static final Block BLOCK_COPPER = new BlockBase("block_copper", Material.IRON, 1, 10.0F, 20.0F, true);
    /*锡*/public static final Block BLOCK_TIN = new BlockBase("block_tin", Material.IRON, 2, 10.0F, 20.0F, true);
    /*锌*/public static final Block BLOCK_ZINC = new BlockBase("block_zinc", Material.IRON, 2, 10.0F, 20.0F, true);
    /*铅*/public static final Block BLOCK_LEAD = new BlockBase("block_lead", Material.IRON, 2, 10.0F, 20.0F, true);
    /*银*/public static final Block BLOCK_SILVER = new BlockBase("block_silver", Material.IRON, 2, 10.0F, 20.0F, true).canBeBeacon(true);
    /*钴*/public static final Block BLOCK_COBALT = new BlockBase("block_cobalt", Material.IRON, 2, 10.0F, 20.0F, true).canBeBeacon(true);
    /*锇*/public static final Block BLOCK_OSMIUM = new BlockBase("block_osmium", Material.IRON, 2, 10.0F, 20.0F, true);
    /*镍*/public static final Block BLOCK_NICKEL = new BlockBase("block_nickel", Material.IRON, 2, 10.0F, 20.0F, true);
    /*铱*/public static final Block BLOCK_IRIDIUM = new BlockBase("block_iridium", Material.IRON, 2, 10.0F, 20.0F, true);
    /*铀*/public static final Block BLOCK_URANIUM = new BlockBase("block_uranium", Material.IRON, 2, 10.0F, 20.0F, true);
    /*镓*/public static final Block BLOCK_GALLIUM = new BlockBase("block_gallium", Material.IRON, 2, 10.0F, 20.0F, true);
    /*钛*/public static final Block BLOCK_TITANIUM = new BlockBase("block_titanium", Material.IRON, 2, 10.0F, 20.0F, true).canBeBeacon(true);
    /*铂*/public static final Block BLOCK_PLATINUM = new BlockBase("block_platinum", Material.IRON, 2, 10.0F, 20.0F, true).canBeBeacon(true);
    /*钨*/public static final Block BLOCK_TUNGSTEN = new BlockBase("block_tungsten", Material.IRON, 2, 10.0F, 20.0F, true);
    /*铝*/public static final Block BLOCK_ALUMINIUM = new BlockBase("block_aluminium", Material.IRON, 2, 10.0F, 20.0F, true);
    /*镁*/public static final Block BLOCK_MAGNESIUM = new BlockBase("block_magnesium", Material.IRON, 2, 10.0F, 20.0F, true);
    /*锂*/public static final Block BLOCK_LITHIUM = new BlockBase("block_lithium", Material.IRON, 2, 10.0F, 20.0F, true);
    /*钍*/public static final Block BLOCK_THORIUM = new BlockBase("block_thorium", Material.IRON, 2, 10.0F, 20.0F, true);
    /*硼*/public static final Block BLOCK_BORON = new BlockBase("block_boron", Material.IRON, 2, 10.0F, 20.0F, true);

    public BlockBase(String name, Material material, int harvestLevel, float hardness, float resistance, boolean a) {
        /*创建方块实例*/super(material);
        if (a) {
            /*设置物品名*/setUnlocalizedName(name);
            /*设置物品名*/setRegistryName(name);
            /*设置硬度*/setHardness(hardness);
            /*设置抗爆性*/setResistance(resistance);
            /*设置挖掘等级*/setHarvestLevel("pickaxe", harvestLevel);
            /*设置透明度*/setLightOpacity(255);

            /*添加到BLOCKS列表*/BLOCKS.add(this);
            /*添加到ITEMS列表*/ItemBase.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
        }
    }

    //注册物品
    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {

        event.getRegistry().registerAll(BlockBase.BLOCKS.toArray(new Block[0]));
    }

    //注册渲染
    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event) {

        for (Block block : BLOCKS) {
            if (block instanceof BlockBase) {
                ((BlockBase) block).registerModels();
            }
        }
    }

    //注册渲染
    public void registerModels() {
        
        SuiKe.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }

    //信标部分
    private boolean canBeBeacon = false;//是否可以作为信标基座

    public BlockBase canBeBeacon(boolean bool) {
        this.canBeBeacon = bool;//设置方块是否可以作为信标基座
        return this;
    }

    @Override
    public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon) {
        return canBeBeacon;//返回方块是否可以作为信标基座
    }
}
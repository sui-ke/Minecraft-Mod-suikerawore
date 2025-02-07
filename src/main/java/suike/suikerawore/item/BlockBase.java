package suike.suikerawore.item;

import java.util.List;
import java.util.ArrayList;

import suike.suikerawore.SuiKe;
import suike.suikerawore.expand.Examine;
import suike.suikerawore.config.ConfigValue;

import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.creativetab.CreativeTabs;

import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class BlockBase extends Block {
//物品
    public static final List<Block> BLOCKS = new ArrayList<>();

    /*金*/public static final Block RAW_BLOCK_GOLD = new BlockBase("raw_block_gold", 2, true);
    /*铁*/public static final Block RAW_BLOCK_IRON = new BlockBase("raw_block_iron", 2, true);
    /*铜*/public static final Block RAW_BLOCK_COPPER = new BlockBase("raw_block_copper", 1, true);
    /*锡*/public static final Block RAW_BLOCK_TIN = new BlockBase("raw_block_tin", 2, null);
    /*锌*/public static final Block RAW_BLOCK_ZINC = new BlockBase("raw_block_zinc", 2, null);
    /*铅*/public static final Block RAW_BLOCK_LEAD = new BlockBase("raw_block_lead", 2, null);
    /*银*/public static final Block RAW_BLOCK_SILVER = new BlockBase("raw_block_silver", 2, null);
    /*钴*/public static final Block RAW_BLOCK_COBALT = new BlockBase("raw_block_cobalt", 2, null);
    /*锇*/public static final Block RAW_BLOCK_OSMIUM = new BlockBase("raw_block_osmium", 2, null);
    /*镍*/public static final Block RAW_BLOCK_NICKEL = new BlockBase("raw_block_nickel", 2, null);
    /*铱*/public static final Block RAW_BLOCK_IRIDIUM = new BlockBase("raw_block_iridium", 2, null);
    /*铀*/public static final Block RAW_BLOCK_URANIUM = new BlockBase("raw_block_uranium", 2, null);
    /*镓*/public static final Block RAW_BLOCK_GALLIUM = new BlockBase("raw_block_gallium", 2, null);
    /*钛*/public static final Block RAW_BLOCK_TITANIUM = new BlockBase("raw_block_titanium", 2, null);
    /*铂*/public static final Block RAW_BLOCK_PLATINUM = new BlockBase("raw_block_platinum", 2, null);
    /*钨*/public static final Block RAW_BLOCK_TUNGSTEN = new BlockBase("raw_block_tungsten", 2, null);
    /*铝*/public static final Block RAW_BLOCK_ALUMINIUM = new BlockBase("raw_block_aluminium", 2, null);
    /*镁*/public static final Block RAW_BLOCK_MAGNESIUM = new BlockBase("raw_block_magnesium", 2, null);
    /*锂*/public static final Block RAW_BLOCK_LITHIUM = new BlockBase("raw_block_lithium", 2, null);
    /*钍*/public static final Block RAW_BLOCK_THORIUM = new BlockBase("raw_block_thorium", 2, null);
    /*硼*/public static final Block RAW_BLOCK_BORON = new BlockBase("raw_block_boron", 2, null);
    /*钒*/public static final Block RAW_BLOCK_VANADIUM = new BlockBase("raw_block_vanadium", 2, null);
    /*镉*/public static final Block RAW_BLOCK_CADMIUM = new BlockBase("raw_block_cadmium", 2, null);
    /*锰*/public static final Block RAW_BLOCK_MANGANESE = new BlockBase("raw_block_manganese", 2, null);
    /*锗*/public static final Block RAW_BLOCK_GERMANIUM = new BlockBase("raw_block_germanium", 2, null);
    /*铬*/public static final Block RAW_BLOCK_CHROMIUM = new BlockBase("raw_block_chromium", 2, null);
    /*砷*/public static final Block RAW_BLOCK_ARSENIC = new BlockBase("raw_block_arsenic", 2, null);

    /*更多粗块*/
    /*阿迪特*/public static final Block RAW_BLOCK_ARDITE = new BlockBase("raw_block_ardite", 2, Examine.TCID);
    /* 晶蓝 */public static final Block RAW_BLOCK_CERULEAN = new BlockBase("raw_block_cerulean", 2, Examine.TheAurorianID);
    /*皎月石*/public static final Block RAW_BLOCK_MOONSTONE = new BlockBase("raw_block_moonstone", 2, Examine.TheAurorianID).setLightLevel(10);
    /*炽炎铁*/public static final Block RAW_BLOCK_OCTINE = new BlockBase("raw_block_octine", 2, Examine.TheBetweenlandsID).setLightLevel(10);
    /*赛摩铜*/public static final Block RAW_BLOCK_SYRMORITE = new BlockBase("raw_block_syrmorite", 2, Examine.TheBetweenlandsID);
    /* 朱砂 */public static final Block RAW_BLOCK_CINNABAR = new BlockBase("raw_block_cinnabar", 2, Examine.thaumcraftID);
    /*软碲铜*/public static final Block RAW_BLOCK_VULCANITE = new BlockBase("raw_block_vulcanite", 2, Examine.vulcaniteID);
    /* 裂金 */public static final Block RAW_BLOCK_CHASMIUM = new BlockBase("raw_block_chasmium", 2, Examine.MaelstromID);
    /*玫瑰金*/public static final Block RAW_BLOCK_ROSEGOLD = new BlockBase("raw_block_rosegold", 2, Examine.虚拟人生);

    /*金属块*/
    /*铜*/public static final Block BLOCK_COPPER = new BlockBase("block_copper", 1, true);
    /*锡*/public static final Block BLOCK_TIN = new BlockBase("block_tin", 2, null);
    /*锌*/public static final Block BLOCK_ZINC = new BlockBase("block_zinc", 2, null);
    /*铅*/public static final Block BLOCK_LEAD = new BlockBase("block_lead", 2, null);
    /*银*/public static final Block BLOCK_SILVER = new BlockBase("block_silver", 2, null).canBeBeacon(true);
    /*钴*/public static final Block BLOCK_COBALT = new BlockBase("block_cobalt", 2, null).canBeBeacon(true);
    /*锇*/public static final Block BLOCK_OSMIUM = new BlockBase("block_osmium", 2, null);
    /*镍*/public static final Block BLOCK_NICKEL = new BlockBase("block_nickel", 2, null);
    /*铱*/public static final Block BLOCK_IRIDIUM = new BlockBase("block_iridium", 2, null).canBeBeacon(true);
    /*铀*/public static final Block BLOCK_URANIUM = new BlockBase("block_uranium", 2, null);
    /*镓*/public static final Block BLOCK_GALLIUM = new BlockBase("block_gallium", 2, null);
    /*钛*/public static final Block BLOCK_TITANIUM = new BlockBase("block_titanium", 2, null).canBeBeacon(true);
    /*铂*/public static final Block BLOCK_PLATINUM = new BlockBase("block_platinum", 2, null).canBeBeacon(true);
    /*钨*/public static final Block BLOCK_TUNGSTEN = new BlockBase("block_tungsten", 2, null);
    /*铝*/public static final Block BLOCK_ALUMINIUM = new BlockBase("block_aluminium", 2, null);
    /*镁*/public static final Block BLOCK_MAGNESIUM = new BlockBase("block_magnesium", 2, null).canBeBeacon(true);
    /*锂*/public static final Block BLOCK_LITHIUM = new BlockBase("block_lithium", 2, null).canBeBeacon(true);
    /*钍*/public static final Block BLOCK_THORIUM = new BlockBase("block_thorium", 2, null);
    /*硼*/public static final Block BLOCK_BORON = new BlockBase("block_boron", 2, null);
    /*钒*/public static final Block BLOCK_VANADIUM = new BlockBase("block_vanadium", 2, null);
    /*镉*/public static final Block BLOCK_CADMIUM = new BlockBase("block_cadmium", 2, null);
    /*锰*/public static final Block BLOCK_MANGANESE = new BlockBase("block_manganese", 2, null);
    /*锗*/public static final Block BLOCK_GERMANIUM = new BlockBase("block_germanium", 2, null);
    /*铬*/public static final Block BLOCK_CHROMIUM = new BlockBase("block_chromium", 2, null);
    /*砷*/public static final Block BLOCK_ARSENIC = new BlockBase("block_arsenic", 2, null);

//构造函数
    public BlockBase(String name, int harvestLevel, Boolean a) {
        /*创建方块实例*/super(Material.IRON);
        if (ItemBase.是否注册物品(name, a)) {
            /*设置物品名*/setRegistryName(name);
            /*设置物品名key*/setUnlocalizedName(name + "_" + SuiKe.MODID);
            /*设置硬度*/setHardness(10.0F);
            /*设置抗爆性*/setResistance(20.0F);
            /*设置挖掘等级*/setHarvestLevel("pickaxe", harvestLevel);
            /*设置透明度*/setLightOpacity(255);
            if (ConfigValue.LiteVersion) {
                /*设置创造模式物品栏*/setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
            }

            /*添加到BLOCKS列表*/BLOCKS.add(this);
            /*添加到ITEMS列表*/ItemBase.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
        }
    }

//物品状态
    public boolean oreDictRaw = true;//首次添加矿词Raw

//注册方块
    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(BlockBase.BLOCKS.toArray(new Block[0]));

        for (Block block : BLOCKS) {
            SuiKe.proxy.registerItemRenderer(Item.getItemFromBlock(block));
        }
    }

//信标部分
    public boolean canBeBeacon = false;//是否可以作为信标基座
    public BlockBase canBeBeacon(boolean bool) {
        this.canBeBeacon = bool;//设置方块是否可以作为信标基座
        return this;
    }
    @Override
    public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon) {
        return canBeBeacon;//返回方块是否可以作为信标基座
    }

//亮度
    public Block setLightLevel(int level) {
        this.lightValue = level;
        return this;
    }
}
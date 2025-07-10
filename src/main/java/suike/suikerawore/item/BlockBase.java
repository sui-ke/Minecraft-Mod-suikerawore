package suike.suikerawore.item;

import java.util.List;
import java.util.ArrayList;

import suike.suikerawore.SuiKe;
import suike.suikerawore.expand.Examine;
import suike.suikerawore.config.ConfigValue;

import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;

import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber
public class BlockBase extends Block {
    public static final List<BlockBase> BLOCKS = new ArrayList<>();

    /*金*/public static final BlockBase RAW_BLOCK_GOLD = new BlockBase("raw_block_gold", true);
    /*铁*/public static final BlockBase RAW_BLOCK_IRON = new BlockBase("raw_block_iron", true);
    /*铜*/public static final BlockBase RAW_BLOCK_COPPER = new BlockBase("raw_block_copper", 1);
    /*锡*/public static final BlockBase RAW_BLOCK_TIN = new BlockBase("raw_block_tin");
    /*锌*/public static final BlockBase RAW_BLOCK_ZINC = new BlockBase("raw_block_zinc");
    /*铅*/public static final BlockBase RAW_BLOCK_LEAD = new BlockBase("raw_block_lead");
    /*银*/public static final BlockBase RAW_BLOCK_SILVER = new BlockBase("raw_block_silver");
    /*钴*/public static final BlockBase RAW_BLOCK_COBALT = new BlockBase("raw_block_cobalt");
    /*锇*/public static final BlockBase RAW_BLOCK_OSMIUM = new BlockBase("raw_block_osmium");
    /*镍*/public static final BlockBase RAW_BLOCK_NICKEL = new BlockBase("raw_block_nickel");
    /*铱*/public static final BlockBase RAW_BLOCK_IRIDIUM = new BlockBase("raw_block_iridium");
    /*铀*/public static final BlockBase RAW_BLOCK_URANIUM = new BlockBase("raw_block_uranium");
    /*镓*/public static final BlockBase RAW_BLOCK_GALLIUM = new BlockBase("raw_block_gallium");
    /*钛*/public static final BlockBase RAW_BLOCK_TITANIUM = new BlockBase("raw_block_titanium");
    /*铂*/public static final BlockBase RAW_BLOCK_PLATINUM = new BlockBase("raw_block_platinum");
    /*钨*/public static final BlockBase RAW_BLOCK_TUNGSTEN = new BlockBase("raw_block_tungsten");
    /*铝*/public static final BlockBase RAW_BLOCK_ALUMINIUM = new BlockBase("raw_block_aluminium");
    /*镁*/public static final BlockBase RAW_BLOCK_MAGNESIUM = new BlockBase("raw_block_magnesium");
    /*锂*/public static final BlockBase RAW_BLOCK_LITHIUM = new BlockBase("raw_block_lithium");
    /*钍*/public static final BlockBase RAW_BLOCK_THORIUM = new BlockBase("raw_block_thorium");
    /*硼*/public static final BlockBase RAW_BLOCK_BORON = new BlockBase("raw_block_boron");
    /*钒*/public static final BlockBase RAW_BLOCK_VANADIUM = new BlockBase("raw_block_vanadium");
    /*镉*/public static final BlockBase RAW_BLOCK_CADMIUM = new BlockBase("raw_block_cadmium");
    /*锰*/public static final BlockBase RAW_BLOCK_MANGANESE = new BlockBase("raw_block_manganese");
    /*锗*/public static final BlockBase RAW_BLOCK_GERMANIUM = new BlockBase("raw_block_germanium");
    /*铬*/public static final BlockBase RAW_BLOCK_CHROMIUM = new BlockBase("raw_block_chromium");
    /*砷*/public static final BlockBase RAW_BLOCK_ARSENIC = new BlockBase("raw_block_arsenic");
    /*铍*/public static final BlockBase RAW_BLOCK_BERYLLIUM = new BlockBase("raw_block_beryllium");
    /*镭*/public static final BlockBase RAW_BLOCK_IRRADIUM = new BlockBase("raw_block_irradium");
    /*钯*/public static final BlockBase RAW_BLOCK_PALLADIUM = new BlockBase("raw_block_palladium");
    /*钚*/public static final BlockBase RAW_BLOCK_PLUTONIUM = new BlockBase("raw_block_plutonium");
    /*铌*/public static final BlockBase RAW_BLOCK_NIOBIUM = new BlockBase("raw_block_niobium", Loader.isModLoaded("gregtech") || Loader.isModLoaded("mist"));
    /*秘银*/public static final BlockBase RAW_BLOCK_MITHRIL = new BlockBase("raw_block_mithril");
    /*金红石*/public static final BlockBase RAW_BLOCK_RUTILE = new BlockBase("raw_block_rutile");

    /*更多粗块*/
    /*阿迪特*/public static final BlockBase RAW_BLOCK_ARDITE = new BlockBase("raw_block_ardite", Examine.TCID);
    /* 晶蓝 */public static final BlockBase RAW_BLOCK_CERULEAN = new BlockBase("raw_block_cerulean", Examine.TheAurorianID);
    /*皎月石*/public static final BlockBase RAW_BLOCK_MOONSTONE = new BlockBase("raw_block_moonstone", Examine.TheAurorianID).setLightLevel(10);
    /*炽炎铁*/public static final BlockBase RAW_BLOCK_OCTINE = new BlockOctineRaw("raw_block_octine", Examine.TheBetweenlandsID);
    /*赛摩铜*/public static final BlockBase RAW_BLOCK_SYRMORITE = new BlockBase("raw_block_syrmorite", Examine.TheBetweenlandsID);
    /* 朱砂 */public static final BlockBase RAW_BLOCK_CINNABAR = new BlockBase("raw_block_cinnabar", Examine.thaumcraftID);
    /*软碲铜*/public static final BlockBase RAW_BLOCK_VULCANITE = new BlockBase("raw_block_vulcanite", Examine.vulcaniteID);
    /* 裂金 */public static final BlockBase RAW_BLOCK_CHASMIUM = new BlockBase("raw_block_chasmium", Examine.MaelstromID);
    /*玫瑰金*/public static final BlockBase RAW_BLOCK_ROSEGOLD = new BlockBase("raw_block_rosegold", Examine.mcaID);

    /*金属块*/
    /*铜*/public static final BlockBase BLOCK_COPPER = new BlockBase("block_copper", 1);
    /*锡*/public static final BlockBase BLOCK_TIN = new BlockBase("block_tin");
    /*锌*/public static final BlockBase BLOCK_ZINC = new BlockBase("block_zinc");
    /*铅*/public static final BlockBase BLOCK_LEAD = new BlockBase("block_lead");
    /*银*/public static final BlockBase BLOCK_SILVER = new BlockBase("block_silver").canBeBeacon();
    /*钴*/public static final BlockBase BLOCK_COBALT = new BlockBase("block_cobalt").canBeBeacon();
    /*锇*/public static final BlockBase BLOCK_OSMIUM = new BlockBase("block_osmium");
    /*镍*/public static final BlockBase BLOCK_NICKEL = new BlockBase("block_nickel");
    /*铱*/public static final BlockBase BLOCK_IRIDIUM = new BlockBase("block_iridium").canBeBeacon();
    /*铀*/public static final BlockBase BLOCK_URANIUM = new BlockBase("block_uranium");
    /*镓*/public static final BlockBase BLOCK_GALLIUM = new BlockBase("block_gallium");
    /*钛*/public static final BlockBase BLOCK_TITANIUM = new BlockBase("block_titanium").canBeBeacon();
    /*铂*/public static final BlockBase BLOCK_PLATINUM = new BlockBase("block_platinum").canBeBeacon();
    /*钨*/public static final BlockBase BLOCK_TUNGSTEN = new BlockBase("block_tungsten");
    /*铝*/public static final BlockBase BLOCK_ALUMINIUM = new BlockBase("block_aluminium");
    /*镁*/public static final BlockBase BLOCK_MAGNESIUM = new BlockBase("block_magnesium").canBeBeacon();
    /*锂*/public static final BlockBase BLOCK_LITHIUM = new BlockBase("block_lithium").canBeBeacon();
    /*钍*/public static final BlockBase BLOCK_THORIUM = new BlockBase("block_thorium");
    /*硼*/public static final BlockBase BLOCK_BORON = new BlockBase("block_boron");
    /*钒*/public static final BlockBase BLOCK_VANADIUM = new BlockBase("block_vanadium");
    /*镉*/public static final BlockBase BLOCK_CADMIUM = new BlockBase("block_cadmium");
    /*锰*/public static final BlockBase BLOCK_MANGANESE = new BlockBase("block_manganese");
    /*锗*/public static final BlockBase BLOCK_GERMANIUM = new BlockBase("block_germanium");
    /*铬*/public static final BlockBase BLOCK_CHROMIUM = new BlockBase("block_chromium");
    /*砷*/public static final BlockBase BLOCK_ARSENIC = new BlockBase("block_arsenic");

// 构造函数
    public BlockBase(String name) {
        this(name, 2, null);
    }
    public BlockBase(String name, Boolean a) {
        this(name, 2, a);
    }
    public BlockBase(String name, int harvestLevel) {
        this(name, harvestLevel, null);
    }
    public BlockBase(String name, int harvestLevel, Boolean a) {
        super(Material.IRON);
        if (ItemBase.canRegistryItem(name, a)) {
            /*设置物品名*/this.setRegistryName(name);
            /*设置物品名key*/this.setUnlocalizedName(SuiKe.MODID + "." + name);
            /*设置硬度*/this.setHardness(10.0F);
            /*设置抗爆性*/this.setResistance(20.0F);
            /*设置不透明度*/this.setLightOpacity(255);
            /*设置挖掘等级*/this.setHarvestLevel("pickaxe", harvestLevel);

            /*添加到BLOCKS列表*/BLOCKS.add(this);
            /*添加到ITEMS列表*/ItemBase.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
        }
    }

// 物品状态
    public boolean oreDictRaw = true; // 首次添加矿词Raw

    private boolean canBeBeacon = false;
    private BlockBase canBeBeacon() {
        this.canBeBeacon = true;
        return this;
    }

// 注册方块
    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(BlockBase.BLOCKS.toArray(new Block[0]));
    }

// 注册模型
    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event) {
        for (Block block : BLOCKS) {
            SuiKe.proxy.registerItemRenderer(Item.getItemFromBlock(block));
        }
    }

// 信标部分
    @Override
    public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon) {
        return canBeBeacon; // 返回方块是否可以作为信标基座
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        if (canBeBeacon) {
            tooltip.add(I18n.format("suikerawore.can.be.beacon"));
        }
    }

// 亮度
    public BlockBase setLightLevel(int level) {
        this.lightValue = level;
        return this;
    }
}
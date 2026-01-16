package suike.suikerawore.block;

import java.util.*;

import suike.suikerawore.SuiKe;
import suike.suikerawore.inter.IItemEntry;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.MathHelper;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.event.RegistryEvent;

import org.apache.commons.lang3.StringUtils;

@Mod.EventBusSubscriber
public abstract class BlockBase<T extends BlockBase<T>> extends Block implements IItemEntry<T> {
    public static final List<BlockBase> BLOCKS = new ArrayList<>();

    /*金属块*/
    /*铜*/public static final ModBlockMetal BLOCK_COPPER    = new ModBlockMetal("block_copper", 1);
    /*锡*/public static final ModBlockMetal BLOCK_TIN       = new ModBlockMetal("block_tin");
    /*锌*/public static final ModBlockMetal BLOCK_ZINC      = new ModBlockMetal("block_zinc");
    /*铅*/public static final ModBlockMetal BLOCK_LEAD      = new ModBlockMetal("block_lead");
    /*银*/public static final ModBlockMetal BLOCK_SILVER    = new ModBlockMetal("block_silver", true);
    /*钴*/public static final ModBlockMetal BLOCK_COBALT    = new ModBlockMetal("block_cobalt", true);
    /*锇*/public static final ModBlockMetal BLOCK_OSMIUM    = new ModBlockMetal("block_osmium");
    /*镍*/public static final ModBlockMetal BLOCK_NICKEL    = new ModBlockMetal("block_nickel");
    /*铱*/public static final ModBlockMetal BLOCK_IRIDIUM   = new ModBlockMetal("block_iridium", true);
    /*铀*/public static final ModBlockMetal BLOCK_URANIUM   = new ModBlockMetal("block_uranium");
    /*镓*/public static final ModBlockMetal BLOCK_GALLIUM   = new ModBlockMetal("block_gallium");
    /*钛*/public static final ModBlockMetal BLOCK_TITANIUM  = new ModBlockMetal("block_titanium", true);
    /*铂*/public static final ModBlockMetal BLOCK_PLATINUM  = new ModBlockMetal("block_platinum", true);
    /*钨*/public static final ModBlockMetal BLOCK_TUNGSTEN  = new ModBlockMetal("block_tungsten");
    /*铝*/public static final ModBlockMetal BLOCK_ALUMINIUM = new ModBlockMetal("block_aluminium");
    /*镁*/public static final ModBlockMetal BLOCK_MAGNESIUM = new ModBlockMetal("block_magnesium", true);
    /*锂*/public static final ModBlockMetal BLOCK_LITHIUM   = new ModBlockMetal("block_lithium", true);
    /*钍*/public static final ModBlockMetal BLOCK_THORIUM   = new ModBlockMetal("block_thorium");
    /*硼*/public static final ModBlockMetal BLOCK_BORON     = new ModBlockMetal("block_boron");
    /*钒*/public static final ModBlockMetal BLOCK_VANADIUM  = new ModBlockMetal("block_vanadium");
    /*镉*/public static final ModBlockMetal BLOCK_CADMIUM   = new ModBlockMetal("block_cadmium");
    /*锰*/public static final ModBlockMetal BLOCK_MANGANESE = new ModBlockMetal("block_manganese");
    /*锗*/public static final ModBlockMetal BLOCK_GERMANIUM = new ModBlockMetal("block_germanium");
    /*铬*/public static final ModBlockMetal BLOCK_CHROMIUM  = new ModBlockMetal("block_chromium");
    /*砷*/public static final ModBlockMetal BLOCK_ARSENIC   = new ModBlockMetal("block_arsenic");

    /*粗块*/
    /*金*/public static final ModBlockRawOre RAW_BLOCK_GOLD       = new ModBlockRawOre("raw_block_gold"     , Blocks.GOLD_BLOCK).setMain();
    /*铁*/public static final ModBlockRawOre RAW_BLOCK_IRON       = new ModBlockRawOre("raw_block_iron"     , Blocks.IRON_BLOCK).setMain();
    /*铜*/public static final ModBlockRawOre RAW_BLOCK_COPPER     = new ModBlockRawOre("raw_block_copper"   , BLOCK_COPPER, 1, "deeperdepths:copper_block");
    /*锡*/public static final ModBlockRawOre RAW_BLOCK_TIN        = new ModBlockRawOre("raw_block_tin"      , BLOCK_TIN);
    /*锌*/public static final ModBlockRawOre RAW_BLOCK_ZINC       = new ModBlockRawOre("raw_block_zinc"     , BLOCK_ZINC);
    /*铅*/public static final ModBlockRawOre RAW_BLOCK_LEAD       = new ModBlockRawOre("raw_block_lead"     , BLOCK_LEAD);
    /*银*/public static final ModBlockRawOre RAW_BLOCK_SILVER     = new ModBlockRawOre("raw_block_silver"   , BLOCK_SILVER);
    /*钴*/public static final ModBlockRawOre RAW_BLOCK_COBALT     = new ModBlockRawOre("raw_block_cobalt"   , BLOCK_COBALT);
    /*锇*/public static final ModBlockRawOre RAW_BLOCK_OSMIUM     = new ModBlockRawOre("raw_block_osmium"   , BLOCK_OSMIUM);
    /*镍*/public static final ModBlockRawOre RAW_BLOCK_NICKEL     = new ModBlockRawOre("raw_block_nickel"   , BLOCK_NICKEL);
    /*铱*/public static final ModBlockRawOre RAW_BLOCK_IRIDIUM    = new ModBlockRawOre("raw_block_iridium"  , BLOCK_IRIDIUM);
    /*铀*/public static final ModBlockRawOre RAW_BLOCK_URANIUM    = new ModBlockRawOre("raw_block_uranium"  , BLOCK_URANIUM);
    /*镓*/public static final ModBlockRawOre RAW_BLOCK_GALLIUM    = new ModBlockRawOre("raw_block_gallium"  , BLOCK_GALLIUM);
    /*钛*/public static final ModBlockRawOre RAW_BLOCK_TITANIUM   = new ModBlockRawOre("raw_block_titanium" , BLOCK_TITANIUM);
    /*铂*/public static final ModBlockRawOre RAW_BLOCK_PLATINUM   = new ModBlockRawOre("raw_block_platinum" , BLOCK_PLATINUM);
    /*钨*/public static final ModBlockRawOre RAW_BLOCK_TUNGSTEN   = new ModBlockRawOre("raw_block_tungsten" , BLOCK_TUNGSTEN);
    /*铝*/public static final ModBlockRawOre RAW_BLOCK_ALUMINIUM  = new ModBlockRawOre("raw_block_aluminium", BLOCK_ALUMINIUM);
    /*镁*/public static final ModBlockRawOre RAW_BLOCK_MAGNESIUM  = new ModBlockRawOre("raw_block_magnesium", BLOCK_MAGNESIUM);
    /*锂*/public static final ModBlockRawOre RAW_BLOCK_LITHIUM    = new ModBlockRawOre("raw_block_lithium"  , BLOCK_LITHIUM);
    /*钍*/public static final ModBlockRawOre RAW_BLOCK_THORIUM    = new ModBlockRawOre("raw_block_thorium"  , BLOCK_THORIUM);
    /*硼*/public static final ModBlockRawOre RAW_BLOCK_BORON      = new ModBlockRawOre("raw_block_boron"    , BLOCK_BORON);
    /*钒*/public static final ModBlockRawOre RAW_BLOCK_VANADIUM   = new ModBlockRawOre("raw_block_vanadium" , BLOCK_VANADIUM);
    /*镉*/public static final ModBlockRawOre RAW_BLOCK_CADMIUM    = new ModBlockRawOre("raw_block_cadmium"  , BLOCK_CADMIUM);
    /*锰*/public static final ModBlockRawOre RAW_BLOCK_MANGANESE  = new ModBlockRawOre("raw_block_manganese", BLOCK_MANGANESE);
    /*锗*/public static final ModBlockRawOre RAW_BLOCK_GERMANIUM  = new ModBlockRawOre("raw_block_germanium", BLOCK_GERMANIUM);
    /*铬*/public static final ModBlockRawOre RAW_BLOCK_CHROMIUM   = new ModBlockRawOre("raw_block_chromium" , BLOCK_CHROMIUM);
    /*砷*/public static final ModBlockRawOre RAW_BLOCK_ARSENIC    = new ModBlockRawOre("raw_block_arsenic"  , BLOCK_ARSENIC);
    /*铍*/public static final ModBlockRawOre RAW_BLOCK_BERYLLIUM  = new ModBlockRawOre("raw_block_beryllium");
    /*镭*/public static final ModBlockRawOre RAW_BLOCK_IRRADIUM   = new ModBlockRawOre("raw_block_irradium");
    /*钯*/public static final ModBlockRawOre RAW_BLOCK_PALLADIUM  = new ModBlockRawOre("raw_block_palladium");
    /*钚*/public static final ModBlockRawOre RAW_BLOCK_PLUTONIUM  = new ModBlockRawOre("raw_block_plutonium");
    /*铌*/public static final ModBlockRawOre RAW_BLOCK_NIOBIUM    = new ModBlockRawOre("raw_block_niobium");
    /*秘银*/public static final ModBlockRawOre RAW_BLOCK_MITHRIL  = new ModBlockRawOre("raw_block_mithril");
    /*金红石*/public static final ModBlockRawOre RAW_BLOCK_RUTILE = new ModBlockRawOre("raw_block_rutile");
    /*阿迪特*/public static final ModBlockRawOre RAW_BLOCK_ARDITE    = new ModBlockRawOre("raw_block_ardite");
    /* 晶蓝 */public static final ModBlockRawOre RAW_BLOCK_CERULEAN  = new ModBlockRawOre("raw_block_cerulean");
    /*皎月石*/public static final ModBlockRawOre RAW_BLOCK_MOONSTONE = new ModBlockRawOre("raw_block_moonstone").setLight(15);
    /*炽炎铁*/public static final ModBlockRawOre RAW_BLOCK_OCTINE    = new ModBlockRawOctine("raw_block_octine").setLight(15);
    /*赛摩铜*/public static final ModBlockRawOre RAW_BLOCK_SYRMORITE = new ModBlockRawOre("raw_block_syrmorite");
    /* 朱砂 */public static final ModBlockRawOre RAW_BLOCK_CINNABAR  = new ModBlockRawOre("raw_block_cinnabar");
    /*软碲铜*/public static final ModBlockRawOre RAW_BLOCK_VULCANITE = new ModBlockRawOre("raw_block_vulcanite");
    /* 裂金 */public static final ModBlockRawOre RAW_BLOCK_CHASMIUM  = new ModBlockRawOre("raw_block_chasmium");
    /*玫瑰金*/public static final ModBlockRawOre RAW_BLOCK_ROSEGOLD  = new ModBlockRawOre("raw_block_rosegold");

// 构造函数
    public BlockBase(String name) {
        this(name, 2);
    }
    public BlockBase(String name, int harvestLevel) {
        super(Material.IRON);
        /*设置物品名*/this.setRegistryName(SuiKe.MODID, name);
        /*设置物品名key*/this.setUnlocalizedName(SuiKe.MODID + "." + name);
        /*设置硬度*/this.setHardness(10.0F);
        /*设置抗爆性*/this.setResistance(20.0F);
        /*设置不透明度*/this.setLightOpacity(255);
        /*设置挖掘等级*/this.setHarvestLevel("pickaxe", harvestLevel);

        this.item = new ItemBlock(this).setRegistryName(this.getRegistryName());
        this.elementType = StringUtils.capitalize(name.replace("raw_block_", "").replace("block_", ""));

        /*添加到BLOCKS列表*/BLOCKS.add(this);
    }

// 方块数据
    // 是否是必要
    private boolean isMain;
    @Override
    public boolean isMain() {
        return this.isMain;
    }
    protected T setMain() {
        this.isMain = true;
        return (T) this.setValid(true);
    }

    // 是否有效
    private boolean isValid;
    @Override
    public boolean isValid() {
        return this.isValid;
    }
    @Override
    public T setValid(boolean isValid) {
        this.isValid = isValid;
        return (T) this;
    }

    // 首字母大写的元素类型
    private final String elementType;
    @Override
    public String getElementType() {
        return this.elementType;
    }

    // 获取矿词
    @Override
    public String getItemOreDict() {
        return this.getItemType() + this.getElementType();
    }

    // 设置亮度
    public T setLight(int value) {
        this.lightValue = MathHelper.clamp(value, 0, 15);
        return (T) this;
    }

// 获取物品
    private final Item item;
    public Item getItem() {
        return this.item;
    }

// 注册方块
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {}
}
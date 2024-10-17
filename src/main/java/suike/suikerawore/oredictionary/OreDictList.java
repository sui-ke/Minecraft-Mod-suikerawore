package suike.suikerawore.oredictionary;

import java.util.Set;
import java.util.HashSet;
import java.lang.reflect.Field;

import net.minecraft.item.Item;
import net.minecraft.block.state.IBlockState;

//矿石列表
public class OreDictList {
//所有矿石
    public static final Set<IBlockState> oreStone = new HashSet<>();
//矿石A组---------------------------------------------------------------------------------
    public static final Set<IBlockState> oreStoneA = new HashSet<>();

    /*金*/public static final Set<IBlockState> oreGold = new HashSet<>();
    /*铁*/public static final Set<IBlockState> oreIron = new HashSet<>();
    /*铜*/public static final Set<IBlockState> oreCopper = new HashSet<>();
    /*锡*/public static final Set<IBlockState> oreTin = new HashSet<>();
    /*锌*/public static final Set<IBlockState> oreZinc = new HashSet<>();
    /*铅*/public static final Set<IBlockState> oreLead = new HashSet<>();
    /*银*/public static final Set<IBlockState> oreSilver = new HashSet<>();
    /*钴*/public static final Set<IBlockState> oreCobalt = new HashSet<>();
    /*锇*/public static final Set<IBlockState> oreOsmium = new HashSet<>();
//矿石B组---------------------------------------------------------------------------------
    public static final Set<IBlockState> oreStoneB = new HashSet<>();

    /*镍*/public static final Set<IBlockState> oreNickel = new HashSet<>();
    /*铱*/public static final Set<IBlockState> oreIridium = new HashSet<>();
    /*铀*/public static final Set<IBlockState> oreUranium = new HashSet<>();
    /*镓*/public static final Set<IBlockState> oreGallium = new HashSet<>();
    /*钛*/public static final Set<IBlockState> oreTitanium = new HashSet<>();
    /*铂*/public static final Set<IBlockState> orePlatinum = new HashSet<>();
    /*钨*/public static final Set<IBlockState> oreTungsten = new HashSet<>();
    /*铝*/public static final Set<IBlockState> oreAluminium = new HashSet<>();
    /*镁*/public static final Set<IBlockState> oreMagnesium = new HashSet<>();
//矿石C组---------------------------------------------------------------------------------
    public static final Set<IBlockState> oreStoneC = new HashSet<>();

    /*锂*/public static final Set<IBlockState> oreLithium = new HashSet<>();
    /*钍*/public static final Set<IBlockState> oreThorium = new HashSet<>();
    /*硼*/public static final Set<IBlockState> oreBoron = new HashSet<>();
    /*钒*/public static final Set<IBlockState> oreVanadium = new HashSet<>();
    /*镉*/public static final Set<IBlockState> oreCadmium = new HashSet<>();
    /*锰*/public static final Set<IBlockState> oreManganese = new HashSet<>();
    /*锗*/public static final Set<IBlockState> oreGermanium = new HashSet<>();
    /*铬*/public static final Set<IBlockState> oreChromium = new HashSet<>();
    /*砷*/public static final Set<IBlockState> oreArsenic = new HashSet<>();
//----------------------------------------------------------------------------------------

//更多粗矿---------------------------------------------------------------------------------
    public static final Set<IBlockState> oreMore = new HashSet<>();
//匠魂
    public static final Set<IBlockState> oreArdite = new HashSet<>();//阿迪特
//极光幽境
    public static final Set<IBlockState> oreCerulean = new HashSet<>();//晶蓝
    public static final Set<IBlockState> oreMoonstone = new HashSet<>();//皎月石
//交错次元
    public static final Set<IBlockState> oreOctine = new HashSet<>();//炽炎铁
    public static final Set<IBlockState> oreSyrmorite = new HashSet<>();//赛摩铜
//神秘时代
    public static final Set<IBlockState> oreCinnabar = new HashSet<>();//朱砂
//软碲铜
    public static final Set<IBlockState> oreVulcanite = new HashSet<>();//软碲铜
//冒险漩涡
    public static final Set<IBlockState> oreChasmium = new HashSet<>();//裂金
//虚拟人生
    public static final Set<IBlockState> oreRoseGold = new HashSet<>();//玫瑰金
//----------------------------------------------------------------------------------------

//检查列表是否为空-------------------------------------------------------------------------
    public static boolean oreListIsEmpty(String oreName) {
        try {
            Field field = OreDictList.class.getField("ore" + oreName);
            Set<IBlockState> oreSet = (Set<IBlockState>) field.get(null);
            return oreSet.isEmpty();//返回集合是否为空
        } catch (NoSuchFieldException | IllegalAccessException e) {
            return true;//如果找不到字段，视为集合为空
        }
    }
}
package suike.suikerawore.expand.densemetals;

import java.util.Set;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

import net.minecraft.block.state.IBlockState;

public class DenseOreOD {
    //所有富集矿石矿词
    public static final Set<IBlockState> denseOreStone = ConcurrentHashMap.newKeySet();

    //各富集矿石矿词
    public static final Set<IBlockState> denseOreGold = new HashSet<>();//金
    public static final Set<IBlockState> denseOreIron = new HashSet<>();//铁
    public static final Set<IBlockState> denseOreCopper = new HashSet<>();//铜
    public static final Set<IBlockState> denseOreTin = new HashSet<>();//锡
    public static final Set<IBlockState> denseOreZinc = new HashSet<>();//锌
    public static final Set<IBlockState> denseOreLead = new HashSet<>();//铅
    public static final Set<IBlockState> denseOreSilver = new HashSet<>();//银
    public static final Set<IBlockState> denseOreOsmium = new HashSet<>();//锇
    public static final Set<IBlockState> denseOreNickel = new HashSet<>();//镍
    public static final Set<IBlockState> denseOreIridium = new HashSet<>();//铱
    public static final Set<IBlockState> denseOreUranium = new HashSet<>();//铀
    public static final Set<IBlockState> denseOrePlatinum = new HashSet<>();//铂
    public static final Set<IBlockState> denseOreTungsten = new HashSet<>();//钨
    public static final Set<IBlockState> denseOreAluminium = new HashSet<>();//铝
    public static final Set<IBlockState> denseOreMagnesium = new HashSet<>();//镁
}
package suike.suikerawore.item;

import java.util.*;

import suike.suikerawore.inter.*;
import suike.suikerawore.config.ConfigValue;
import suike.suikerawore.data.ByProductData;
import suike.suikerawore.block.ModBlockRawOre;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraftforge.fluids.FluidRegistry;

import org.apache.commons.lang3.math.NumberUtils;

public class ModItemRawOre extends ItemBase<ModItemRawOre, ModBlockRawOre> implements IMmaterial {
    public static final Map<String, ModItemRawOre> TYPE_TO_RAW_ORE = Collections.synchronizedMap(new HashMap<>());
    // for (Map.Entry<String, ModItemRawOre> mapEntry : ModItemRawOre.TYPE_TO_RAW_ORE.entrySet()) {ModItemRawOre rawOre = mapEntry.getValue();}

    public ModItemRawOre(String name, ModBlockRawOre compressBlock, String fluid) {
        this(name, compressBlock, null, null, fluid, null);
    }
    private ModItemRawOre(String name, ModBlockRawOre compressBlock, Item mainRefined, Object[] byProduct, String fluid, String[] outputs) {
        super(name, compressBlock);
        this.mainRefined = mainRefined;
        this.outputs = outputs;
        this.fluid = fluid;
        this.byProductData = this.initByProductData(byProduct);

        synchronized (TYPE_TO_RAW_ORE) {
            TYPE_TO_RAW_ORE.put(this.getElementType(), this);
        }
    }

    @Override
    public String getItemType() {
        return "raw";
    }

// 精炼后的成品
    private final Item mainRefined;
    @Override
    public ItemStack getMainRefined(int amount) {
        return new ItemStack(this.mainRefined, amount);
    }
    @Override
    public Object getRefinedObject() {
        return this.mainRefined;
    }
    @Override
    public boolean mainOutputIsValid() {
        return this.mainRefined instanceof IItemEntry
            ? ((IItemEntry) this.mainRefined).isValid()
            : this.mainRefined != null;
    }

// 成品物的注册名
    private volatile String[] outputs;
    @Override
    public String[] getOutputs() {
        return this.outputs;
    }
    @Override
    public void setOutputs(String[] outputs) {
        this.outputs = outputs;
    }
    @Override
    public void setRefinedItem(String refined) {
        refined = this.upRefineds(refined);
        if (!refined.isEmpty()) {
            this.getCompressBlock().setRefinedItem(refined); // 调用压缩方块的接口方法
        }
    }

// 成品物的矿词
    @Override
    public String getRefinedOreDict() {
        return "ingot" + this.getElementType();
    }

// 初始化副产物列表
    private ByProductData byProductData;
    public ByProductData getByProductData() {
        return this.byProductData != null ? this.byProductData : new ByProductData(this);
    }
    public void clearByProductData() {
        this.byProductData = null;
    }

    private ByProductData initByProductData(Object[] byProduct) {
        if (byProduct == null || byProduct.length < 2) {
            return new ByProductData(this);
        }

        List<String> products = new ArrayList<>();
        List<Float> chances = new ArrayList<>();

        for (int i = 0; i < byProduct.length; i += 2) {
            products.add((String) byProduct[i]);
        }
        for (int i = 1; i < byProduct.length; i += 2) {
            chances.add((Float) byProduct[i]);
        }

        return new ByProductData(products, chances);
    }

// 溶液
    private final String fluid;
    public String getFluid() {
        return this.fluid.isEmpty() ? this.getElementType2() : this.fluid;
    }

    public boolean canCreateFluid() {
        return this.fluid.isEmpty()
            && !this.radioactive()
            && !this.getRefinedItemStack().isEmpty()
            && FluidRegistry.getFluid(this.getFluid()) == null;
    }

// 放射性
    public boolean radioactive() {
        return this == ItemBase.RAW_URANIUM || this == ItemBase.RAW_IRRADIUM;
    }

// 设为有效
    @Override
    public ModItemRawOre setValid(boolean isValid) {
        IItemEntry.setValid(isValid, this.getCompressBlock());
        if (this.getRefinedFromName().isEmpty()) {
            IItemEntry.setValid(isValid, this.mainRefined);
        }
        return super.setValid(isValid);
    }

    public static void upValid() {
        synchronized (ModItemRawOre.TYPE_TO_RAW_ORE) {
            for (Map.Entry<String, ModItemRawOre> mapEntry : ModItemRawOre.TYPE_TO_RAW_ORE.entrySet()) {
                ModItemRawOre rawOre = mapEntry.getValue();
                if (!ItemBase.oreStack("ore" + rawOre.getElementType()).isEmpty() && !rawOre.isValid()) {
                    rawOre.setValid(true);
                }
            }
        }
    }

// 创建粗矿方法
    public static ModItemRawOre create(Object... objects) {
        if (objects == null || objects.length < 2) {
            throw new IllegalArgumentException("[RawOre]{ModItemRawOre} Create Raw Ore Parameter Is Wrong");
        }

        String name = (String) objects[0];
        ModBlockRawOre compressBlock = (ModBlockRawOre) objects[1];

        if (name == null || compressBlock == null) {
            throw new IllegalArgumentException("[RawOre]{ModItemRawOre} Required parameters are missing: Name and ModBlockRawOre");
        }

        Object[] byProduct = null;
        Item mainRefined = null;
        String fluid = "";
        List<String> outputs = new ArrayList<>();

        for (int i = 2; i < objects.length; i++) {
            if (objects[i] instanceof Item) {
                mainRefined = (Item) objects[i];
            }
            else if (objects[i] instanceof Object[]) {
                byProduct = (Object[]) objects[i];
            }
            else if (objects[i] instanceof String) {
                String str = (String) objects[i];
                if (str.startsWith("fluid:")) {
                    fluid = str.replace("fluid:", "");
                }
                else if (str.startsWith("item:")) {
                    outputs.add(str.replace("item:", ""));
                }
            }
        }

        return new ModItemRawOre(name, compressBlock, mainRefined, byProduct, fluid, outputs.toArray(new String[0]));
    }
}
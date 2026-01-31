package suike.suikerawore.block;

import java.util.*;

import suike.suikerawore.inter.*;
import suike.suikerawore.item.ItemBase;

import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;

public class ModBlockRawOre extends BlockBase<ModBlockRawOre> implements IMmaterial {

    public ModBlockRawOre(String name) {
        this(name, null, 2, new String[]{});
    }
    public ModBlockRawOre(String name, Block mainRefined) {
        this(name, mainRefined, 2, new String[]{});
    }
    public ModBlockRawOre(String name, Block mainRefined, String... outputs) {
        this(name, mainRefined, 2, outputs);
    }
    public ModBlockRawOre(String name, Block mainRefined, int harvestLevel, String... outputs) {
        super(name, harvestLevel);
        this.mainRefined = mainRefined;
        this.outputs = outputs;
    }

    @Override
    public String getItemType() {
        return "blockRaw";
    }

    @Override
    public String getItemOreDict() {
        return this.getItemType() + this.getElementType();
    }

// 精炼后的成品
    private final Block mainRefined;
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

// 成品物的矿词
    public String getRefinedOreDict() {
        return "block" + this.getElementType();
    }
}
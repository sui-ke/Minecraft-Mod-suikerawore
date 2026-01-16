package suike.suikerawore.item;

import java.util.function.Supplier;

import suike.suikerawore.inter.IItemEntry;
import suike.suikerawore.config.ConfigValue;
import suike.suikerawore.block.ModBlockMetal;

public class ModItemIngot extends ItemBase<ModItemIngot, ModBlockMetal> {

    private final Supplier<Boolean> canSetValid;

    public ModItemIngot(String name, ModBlockMetal compressBlock) {
        this(name, compressBlock, () -> true);
    }
    public ModItemIngot(String name, ModBlockMetal compressBlock, Supplier<Boolean> canSetValid)  {
        super(name, compressBlock);
        this.canSetValid = canSetValid;
    }

    @Override
    public ModItemIngot setValid(boolean isValid) {
        if (this.canSetValid.get() && ConfigValue.needIngot) {
            IItemEntry.setValid(isValid, this.getCompressBlock());
            return super.setValid(isValid);
        }
        return this;
    }

    @Override
    public String getItemType() {
        return "ingot";
    }
}
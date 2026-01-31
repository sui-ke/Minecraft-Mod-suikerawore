package suike.suikerawore.inter;

import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;
import net.minecraft.util.text.translation.I18n;

import org.apache.commons.lang3.StringUtils;

public interface IItemEntry<T extends IItemEntry<T>> {
    boolean isMain();

    boolean isValid();
    T setValid(boolean isValid);

    String getItemType();
    String getItemOreDict();
    String getElementType();
    default String getElementType2() {
        return StringUtils.uncapitalize(this.getElementType());
    }
    default Object getRefinedObject() {
        return null;
    }

    public static void setValid(boolean isValid, Object... objects) {
        for (Object object : objects) {
            IItemEntry entry = getIItemEntry(object);
            if (entry != null && !entry.isValid()) {
                entry.setValid(isValid);
            }
        }
    }

    public static boolean isValid(Object object) {
        IItemEntry entry = getIItemEntry(object);
        if (entry != null) {
            return entry.isValid();
        }
        return false;
    }

    public static IItemEntry getIItemEntry(Object object) {
        if (object instanceof ItemStack) {
            object = ((ItemStack) object).getItem();
        }

        if (object instanceof IItemEntry) {
            return (IItemEntry) object;
        }
        else if (object instanceof ItemBlock) {
            Block block = ((ItemBlock) object).getBlock();
            if (block instanceof IItemEntry) {
                return (IItemEntry) block;
            }
        }

        return null;
    }
}
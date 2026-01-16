package suike.suikerawore.data;

import java.util.*;

import suike.suikerawore.inter.IItemEntry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import org.apache.commons.lang3.Validate;

public class CustomNonNullList<E> extends NonNullList<E> {

    protected CustomNonNullList() {
        super();
    }

    protected CustomNonNullList(List<E> delegateIn, E listType) {
        super(delegateIn, listType);
    }

    public static <E> CustomNonNullList<E> create() {
        return new CustomNonNullList<E>();
    }

    public static <E> CustomNonNullList<E> create(List<E> delegateIn, E listType) {
        return new CustomNonNullList<E>(delegateIn, listType);
    }

    public static <E> CustomNonNullList<E> withSize(int size, E fill) {
        Validate.notNull(fill);
        Object[] aobject = new Object[size];
        Arrays.fill(aobject, fill);
        return new CustomNonNullList<E>(Arrays.asList((E[]) aobject), fill);
    }

    public static <E> CustomNonNullList<E> from(E defaultElementIn, E... elements) {
        return new CustomNonNullList<E>(Arrays.asList(elements), defaultElementIn);
    }

    public boolean addAll(List<E> c) {
        if (c == null) return false;
        boolean modified = false;
        for (E element : c) {
            if (this.isValid(element)) {
                this.add(element);
            }
        }
        return modified;
    }

    private boolean isValid(E element) {
        if (element instanceof ItemStack) {
            ItemStack item = (ItemStack) element;
            return !item.isEmpty() && item.getItem() != null;
        }
        return element != null;
    }
}
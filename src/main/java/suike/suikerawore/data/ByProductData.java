package suike.suikerawore.data;

import java.util.*;

import suike.suikerawore.item.ModItemRawOre;

public class ByProductData {
    private final String[] products;
    private final Float[] chances;

    public ByProductData(ModItemRawOre rawOre) {
        this(Arrays.asList(rawOre.getElementType()), Arrays.asList(1F));
    }
    public ByProductData(List<String> products, List<Float> chances) {
        this(products.toArray(new String[0]), chances.toArray(new Float[0]));
    }
    public ByProductData(String[] products, Float[] chances) {
        this.products = products;
        this.chances = chances;
    }

    public String[] getProducts() {
        return this.products;
    }

    public Float[] getChances() {
        return this.chances;
    }
}
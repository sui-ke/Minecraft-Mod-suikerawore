package suike.suikerawore.recipe;

import java.util.Map;

import suike.suikerawore.SuiKe;
import suike.suikerawore.item.*;
import suike.suikerawore.block.*;
import suike.suikerawore.inter.IItemEntry;
import suike.suikerawore.config.ConfigValue;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import net.minecraftforge.oredict.OreIngredient;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CompressResolveRecipe {

    private ModItemRawOre rawOre;
    private Boolean isRaw;
    private boolean recipeIsValid;
    private ItemStack resolveItemStack;
    private ItemStack resolveItemStack9;
    private ItemStack compressItemStack;
    private String resolveOreDict;
    private String compressOreDict;

    private final ResourceLocation res = new ResourceLocation(SuiKe.MODID);

    private void initStack(Boolean type, ItemStack resolve, ItemStack compress) {
        this.resolveItemStack = resolve;
        resolve = resolve.copy();
        resolve.setCount(9);
        this.resolveItemStack9 = resolve;
        this.compressItemStack = compress;
        this.recipeIsValid = ItemBase.isValidItemStack(this.resolveItemStack, this.resolveItemStack9, this.compressItemStack);
        if (!this.recipeIsValid) return;

        String elementType = this.rawOre.getElementType();

        // null: 金属粒压缩分解, false: 金属块压缩分解, true: 粗矿压缩分解
        this.isRaw = type != null && type;
        this.resolveOreDict  = (type == null)
            ? "nugget" + elementType
            : (!type
                ? "ingot"  + elementType
                : this.rawOre.getItemOreDict());
        this.compressOreDict = (type == null)
            ? "ingot" + elementType
            : (!type
                ? "block"  + elementType
                : this.rawOre.getCompressBlock().getItemOreDict());
    }

    public void registryRecipe(ModItemRawOre rawOre) {
        this.rawOre = rawOre;
        /*粗矿压缩分解*/this.register(true, new ItemStack(this.rawOre), new ItemStack(this.rawOre.getCompressBlock()));
        /*金属块压缩分解*/this.register(false, this.rawOre.getRefinedItemStack(), this.rawOre.getCompressBlock().getRefinedItemStack());
        /*金属粒压缩分解*/this.register(null, ItemBase.oreStack("nugget" + this.rawOre.getElementType()), this.rawOre.getRefinedItemStack());
    }

//配方注册
    private void register(Boolean type, ItemStack resolve, ItemStack compress) {
        /*初始化本次配方*/this.initStack(type, resolve, compress);
        if (this.recipeIsValid) {
            this.registerRecipe();
        }
    }

    private void registerRecipe() {
        // 压缩
        GameRegistry.addShapedRecipe(
            new ResourceLocation(SuiKe.MODID, resolveOreDict + ">" + compressOreDict),
            this.res,
            this.compressItemStack.copy(),
            "AAA",
            "AAA",
            "AAA",
            'A', (this.isRaw ? this.resolveItemStack.copy() : new OreIngredient(resolveOreDict))
        );
        // 分解
        GameRegistry.addShapedRecipe(
            new ResourceLocation(SuiKe.MODID, compressOreDict + ">" + resolveOreDict),
            this.res,
            this.resolveItemStack9.copy(),
            "A",
            'A', (this.isRaw ? this.compressItemStack.copy() : new OreIngredient(compressOreDict))
        );
    }
}
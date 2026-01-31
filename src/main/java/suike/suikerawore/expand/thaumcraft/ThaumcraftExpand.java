package suike.suikerawore.expand.thaumcraft;

import java.util.*;

import suike.suikerawore.SuiKe;
import suike.suikerawore.item.*;
import suike.suikerawore.block.*;
import suike.suikerawore.expand.ExpandMod;

import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.aspects.AspectHelper;
import thaumcraft.api.crafting.CrucibleRecipe;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

// 神秘时代
public class ThaumcraftExpand extends ExpandMod {

    @Override
    protected String value() {
        return "thaumcraft";
    }

    @Override
    protected void expand(ModItemRawOre rawOre) {
        this.addAspect(rawOre);
        this.registerCrucibleRecipe(rawOre);
    }

    // 添加源质
    private void addAspect(ModItemRawOre rawOre) {
        this.addAspect(rawOre.getItemOreDict(), this.getAspectList(rawOre.getRefinedItemStack()));
        this.addAspect(rawOre.getCompressBlock().getItemOreDict(), this.getAspectList(rawOre.getCompressBlock().getRefinedItemStack()));
    }
    private void addAspect(String oreDict, AspectList aspects) {
        if (aspects != null) {
            ThaumcraftApi.registerObjectTag(oreDict, aspects.copy());
        }
    }
    private AspectList getAspectList(ItemStack item) {
        if (ItemBase.isValidItemStack(item)) {
            return AspectHelper.getObjectAspects(item);
        }
        return null;
    }

    // 注册坩埚配方配方
    private void registerCrucibleRecipe(ModItemRawOre rawOre) {
        ItemStack outputStack = ItemBase.oreStack("cluster" + rawOre.getElementType());

        if (ItemBase.isValidItemStack(outputStack)) {
            ThaumcraftApi.addCrucibleRecipe(
                new ResourceLocation(SuiKe.MODID, rawOre.getItemOreDict() + "cluster"),
                new CrucibleRecipe("METALPURIFICATION", outputStack, rawOre.getItemOreDict(), new AspectList().merge(Aspect.METAL, 5).merge(Aspect.ORDER, 5))
            );
        }
    }
}
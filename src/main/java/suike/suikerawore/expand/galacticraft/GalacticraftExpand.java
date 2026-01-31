package suike.suikerawore.expand.galacticraft;

import java.util.*;

import suike.suikerawore.SuiKe;
import suike.suikerawore.item.*;
import suike.suikerawore.inter.IItemEntry;
import suike.suikerawore.expand.ExpandMod;

import micdoodle8.mods.galacticraft.api.recipe.CompressorRecipes;

import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.init.Items;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;


// 星系-压缩机配方
public class GalacticraftExpand extends ExpandMod {

    private final Map<String, String> prefixes = new HashMap<>();

    @Override
    protected String value() {
        return "galacticraftplanets";
    }

    @Override
    protected void init() {
        this.prefixes.put("compressed", "XX");
        if (Loader.isModLoaded("ic2")) {
            this.prefixes.put("plate", "X");
        }
    }

    @Override
    protected void expandOnce() {
        if (Loader.isModLoaded("galaxyspace")) {
            this.registerGalaxySpaceRecipe();
        }
    }

    @Override
    protected void expand(ModItemRawOre rawOre) {
        this.registerRecipe(rawOre.getRefinedItemStack(), rawOre.getElementType());
    }

// 注册压缩机配方
    private void registerRecipe(ItemStack inputStack, String elementType) {
        for (Map.Entry<String, String> mapEntry : this.prefixes.entrySet()) {
            ItemStack outputStack = ItemBase.oreStack(mapEntry.getKey() + elementType);
            if (ItemBase.isValidItemStack(inputStack, outputStack)) {
                String structure = mapEntry.getValue(); // 摆放结构
                if (structure.equals("XX") || (outputStack.getItem().getRegistryName().toString().split(":")[0]).equals("ic2")) {
                    CompressorRecipes.addRecipe(outputStack, structure, 'X', inputStack);
                }
            }
        }
    }

    private void registerGalaxySpaceRecipe() {
        // 现代储能方块
        ItemStack ingotMagnesium = new ItemStack(ItemBase.INGOT_MAGNESIUM);
        ItemStack machineTiered  = new ItemStack(Item.getByNameOrId("galacticraftcore:machine_tiered"), 1, 8);
        ItemStack gsBasic        = new ItemStack(Item.getByNameOrId("galaxyspace:gs_basic")           , 1, 5);
        ItemStack machineframes  = new ItemStack(Item.getByNameOrId("galaxyspace:machineframes")      , 1, 2);
        ItemStack output         = new ItemStack(Item.getByNameOrId("galaxyspace:modern_storage_module"), 1);

        if (ItemBase.isValidItemStack(ingotMagnesium, machineTiered, gsBasic, machineframes, output)) {
            GameRegistry.addShapedRecipe(
                new ResourceLocation(SuiKe.MODID, "modern_storage_module"),
                new ResourceLocation(SuiKe.MODID),
                output, 
                "ABA",
                "CDC",
                "ABA",
                'A', ingotMagnesium,
                'B', machineTiered,
                'C', gsBasic,
                'D', machineframes
            );
        }
    }
}
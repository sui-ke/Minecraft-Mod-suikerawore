package suike.suikerawore.expand.galaxyspace;

import suike.suikerawore.SuiKe;
import suike.suikerawore.item.ItemBase;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import net.minecraftforge.fml.common.registry.GameRegistry;

//星空工作台配方
public class GalaxySpaceExpand {
    public static void expand() {
        //现代储能方块
        ItemStack ingotMagnesium = new ItemStack(ItemBase.INGOT_MAGNESIUM);
        ItemStack machineTiered = new ItemStack(Item.getByNameOrId("galacticraftcore:machine_tiered"), 1, 8);
        ItemStack gsBasic = new ItemStack(Item.getByNameOrId("galaxyspace:gs_basic"), 1, 5);
        ItemStack machineframes = new ItemStack(Item.getByNameOrId("galaxyspace:machineframes"), 1, 2);

        GameRegistry.addShapedRecipe(
            new ResourceLocation(SuiKe.MODID, "modern_storage_module"),//配方标识符
            null,//分组名
            new ItemStack(Item.getByNameOrId("galaxyspace:modern_storage_module"), 1), 
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
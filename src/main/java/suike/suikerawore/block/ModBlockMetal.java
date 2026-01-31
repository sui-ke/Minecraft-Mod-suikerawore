package suike.suikerawore.block;

import java.util.List;

import suike.suikerawore.config.ConfigValue;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlockMetal extends BlockBase<ModBlockMetal> {

    public ModBlockMetal(String name) {
        this(name, 2, false);
    }
    public ModBlockMetal(String name, int harvestLevel) {
        this(name, harvestLevel, false);
    }
    public ModBlockMetal(String name, boolean isBeaconBase) {
        this(name, 2, isBeaconBase);
    }
    public ModBlockMetal(String name, int harvestLevel, boolean isBeaconBase) {
        super(name, harvestLevel);
        this.isBeaconBase = isBeaconBase;
    }

    @Override
    public String getItemType() {
        return "block";
    }

    @Override
    public String getItemOreDict() {
        return this.getItemType() + this.getElementType();
    }

    private final boolean isBeaconBase;

    @Override
    public boolean isBeaconBase(IBlockAccess world, BlockPos pos, BlockPos beacon) {
        return isBeaconBase;
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag flag) {
        if (this.isBeaconBase) {
            tooltip.add(I18n.format("suikerawore.can.be.beacon"));
        }
    }
}
package suike.suikerawore.item;

import java.util.List;

import suike.suikerawore.block.ModBlockRawOre;

import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItemRawOctine extends ModItemRawOre {

    public ModItemRawOctine(String name, ModBlockRawOre compressBlock, String fluid) {
        super(name, compressBlock, fluid);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos clickPos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (this.tryIgniteBlock(world, clickPos)) {
            return EnumActionResult.SUCCESS;
        }
        return EnumActionResult.FAIL;
    }

    private boolean tryIgniteBlock(World world, BlockPos pos) {
        String neighborBlockName = world.getBlockState(pos).getBlock().getRegistryName().toString();

        // 方块为苔藓, 荆棘
        if (neighborBlockName.contains("thebetweenlands") && (neighborBlockName.contains("moss") || neighborBlockName.contains("thorns") || neighborBlockName.contains("lichen"))) {
            world.setBlockState(pos, Blocks.FIRE.getDefaultState());
            world.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.PLAYERS, 1.0F, 1.0F);
            return true;
        }

        return false;
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        String tool = I18n.format("tooltip.bl.octine.fire");
        if (!"tooltip.bl.octine.fire".equals(tool)) {
            tooltip.add(tool);
        }
    }
}
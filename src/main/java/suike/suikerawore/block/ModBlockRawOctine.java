package suike.suikerawore.block;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;
import net.minecraft.block.BlockVine;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.World;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;

public class ModBlockRawOctine extends ModBlockRawOre {
    public ModBlockRawOctine(String name) {
        super(name);
        this.setTickRandomly(true);
    }

    @Override
    public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block, BlockPos fromPos) {
        this.tryIgniteNearbyBlock(world, pos);
    }

    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
        this.tryIgniteNearbyBlock(world, pos);
    }

    private void tryIgniteNearbyBlock(World world, BlockPos pos) {
        // 检查 6 个相邻方向
        for (EnumFacing facing : EnumFacing.VALUES) {
            BlockPos neighborPos = pos.offset(facing);
            IBlockState neighborState = world.getBlockState(neighborPos);
            Block neighborBlock = neighborState.getBlock();
            String neighborBlockName = neighborBlock.getRegistryName().toString();

            // 方块为苔藓, 荆棘
            if (neighborBlockName.contains("thebetweenlands") && (neighborBlockName.contains("moss") || neighborBlockName.contains("thorns") || neighborBlockName.contains("lichen"))) {
                if (neighborBlock instanceof BlockDirectional) {
                    EnumFacing mossFacing = neighborState.getValue(BlockDirectional.FACING); // 获取苔藓的朝向
                    if (facing == mossFacing.getOpposite()) {
                        continue; // 如果苔藓在方块对面, 则不燃烧
                    }
                }

                if (neighborBlock instanceof BlockVine) {
                    EnumFacing mossFacing = EnumFacing.DOWN;
                    if (((Boolean) neighborState.getValue(BlockVine.UP)).booleanValue()) {
                        mossFacing = EnumFacing.UP;
                    } else if (((Boolean) neighborState.getValue(BlockVine.SOUTH)).booleanValue()) {
                        mossFacing = EnumFacing.SOUTH;
                    } else if (((Boolean) neighborState.getValue(BlockVine.WEST)).booleanValue()) {
                        mossFacing = EnumFacing.WEST;
                    } else if (((Boolean) neighborState.getValue(BlockVine.NORTH)).booleanValue()) {
                        mossFacing = EnumFacing.NORTH;
                    } else if (((Boolean) neighborState.getValue(BlockVine.EAST)).booleanValue()) {
                        mossFacing = EnumFacing.EAST;
                    }

                    if (mossFacing != null && facing != mossFacing.getOpposite()) {
                        continue;  // 贴在方块上才会燃烧
                    }
                }

                world.setBlockState(neighborPos, Blocks.FIRE.getDefaultState());
                world.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.PLAYERS, 1.0F, 1.0F);
                return; // 每次只点燃一个方块
            }
        }
    }
}
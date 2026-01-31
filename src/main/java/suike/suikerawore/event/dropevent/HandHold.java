/*
package suike.suikerawore.event.dropevent;

import java.util.*;

import suike.suikerawore.expand.Examine;
import suike.suikerawore.event.dropevent.BreakingEvent;
import suike.suikerawore.event.dropevent.drop.ThaumcraftDrop;
import suike.suikerawore.expand.ModEnchantmentHelper;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.enchantment.EnchantmentHelper;

import net.minecraftforge.fml.common.Loader;

// 挖掘工具检查
public class HandHold {
// 检查手持物是否为锤
    public static boolean isHoldingHammertime(BlockPos pos, World world) {
        AxisAlignedBB boundingBox = new AxisAlignedBB(pos).grow(6);
        return world.getEntitiesWithinAABB(EntityPlayer.class, boundingBox)
            .stream().anyMatch(player -> {
                ItemStack heldItem = player.getHeldItemMainhand();
                if (heldItem != null && 
                    heldItem.getItem().getRegistryName().toString().startsWith("hammertime") &&
                    EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, heldItem) <= 0) {
                    itemExamine(heldItem);
                    return true;
                }
                return false;
            }
        );
    }
}//*/
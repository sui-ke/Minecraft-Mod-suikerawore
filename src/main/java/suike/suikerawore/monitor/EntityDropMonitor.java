package suike.suikerawore.monitor;

import suike.suikerawore.SuiKe;
import suike.suikerawore.item.ItemBase;

import net.minecraft.item.ItemStack;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.enchantment.EnchantmentHelper;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Optional;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

@Mod.EventBusSubscriber(modid = "oe")
public class EntityDropMonitor {

    public static boolean haveCopper;
    static {//检查是否有铜锭
        ItemStack stack = ItemBase.oreStack("ingotCopper", 1, 1);

        if (!stack.isEmpty()) {
            haveCopper = true;
        }
    }

    @Optional.Method(modid = "oe")
    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        if (!haveCopper)
            return;

        String entityName = event.getEntity().getClass().getSimpleName();

        //死亡生物为溺尸
        if (entityName.toLowerCase().contains("drowned")) {
            int lootingLevel = 0;//抢夺等级

            if (
                event.getSource().getTrueSource() != null &&
                event.getSource().getTrueSource() instanceof EntityPlayer
               )
            {
                EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();
                ItemStack heldItem = player.getHeldItemMainhand();
                lootingLevel = EnchantmentHelper.getEnchantmentLevel(Enchantments.LOOTING, heldItem);
            }

            if (chance(lootingLevel)) {
                BlockPos pos = new BlockPos(event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ);
                Block.spawnAsEntity(event.getEntity().getEntityWorld(), pos, new ItemStack(ItemBase.INGOT_COPPER));
            }
        }
    }

    public static boolean chance(int lootingLevel) {
        int chance = (int) (Math.random() * 100);
        return chance < (11 + (lootingLevel * 2));
    }
}
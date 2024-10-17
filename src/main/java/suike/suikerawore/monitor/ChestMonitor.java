package suike.suikerawore.monitor;

import suike.suikerawore.SuiKe;
import suike.suikerawore.item.ItemBase;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.block.BlockChest;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.entity.item.EntityMinecartChest;

import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

public class ChestMonitor {

    public static Object suikerawore_chestMonitor;

    public static void registerMonitor() {
        //注册物品替换
        suikerawore_chestMonitor = new ItemReplace();
        FMLCommonHandler.instance().bus().register(suikerawore_chestMonitor);
    }

    static class ItemReplace {
        //替换物品的注册名称
        private static final ResourceLocation IC_INGOT = new ResourceLocation("ic2", "ingot");
        private static final int IC_COPPER_META = 2;
        private static final int IC_TIN_META = 6;

        @SubscribeEvent
        public void onePlayerInteract(PlayerInteractEvent.RightClickBlock event) {
            //检查是否是箱子
            if (event.getWorld().getBlockState(event.getPos()).getBlock() instanceof BlockChest) {

                //替换箱子里的物品
                TileEntityChest chest = (TileEntityChest) event.getWorld().getTileEntity(event.getPos());

                if (chest != null) {

                    for (int i = 0; i < chest.getSizeInventory(); i++) {

                        ItemStack itemStack = chest.getStackInSlot(i);

                        //检查物品是否是目标物品
                        if (itemStack.getItem() == Item.getItemById(Item.getIdFromItem(Item.getByNameOrId(IC_INGOT.toString())))) {
                            //替换为新的物品
                            if (itemStack.getMetadata() == IC_COPPER_META){
                                chest.setInventorySlotContents(i, new ItemStack(ItemBase.INGOT_COPPER, itemStack.getCount()));

                            } else if (itemStack.getMetadata() == IC_TIN_META){
                                chest.setInventorySlotContents(i, new ItemStack(ItemBase.INGOT_TIN, itemStack.getCount()));
                            }
                        }
                    }
                }
            }
        }

        @SubscribeEvent
        public void onEntityJoinWorld(EntityJoinWorldEvent event) {
            //检查是否是箱子矿车
            if (event.getEntity() instanceof EntityMinecartChest) {

                EntityMinecartChest minecart = (EntityMinecartChest) event.getEntity();
                IInventory inventory = minecart;

                for (int i = 0; i < inventory.getSizeInventory(); i++) {
                    ItemStack itemStack = inventory.getStackInSlot(i);

                    //检查物品是否是目标物品
                    if (itemStack.getItem() == Item.getItemById(Item.getIdFromItem(Item.getByNameOrId(IC_INGOT.toString())))) {

                        //替换为新的物品
                        if (itemStack.getMetadata() == IC_COPPER_META){
                            inventory.setInventorySlotContents(i, new ItemStack(ItemBase.INGOT_COPPER, itemStack.getCount()));

                        } else if (itemStack.getMetadata() == IC_TIN_META){
                            inventory.setInventorySlotContents(i, new ItemStack(ItemBase.INGOT_TIN, itemStack.getCount()));
                        }
                    }
                }
            }
        }
    }
}
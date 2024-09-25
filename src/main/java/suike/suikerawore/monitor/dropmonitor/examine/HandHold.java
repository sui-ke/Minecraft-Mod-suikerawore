package suike.suikerawore.monitor.dropmonitor.examine;

import suike.suikerawore.item.ItemBase;
import suike.suikerawore.item.BlockBase;
import suike.suikerawore.expand.Examine;
import suike.suikerawore.monitor.dropmonitor.BreakingMonitor;
import suike.suikerawore.monitor.dropmonitor.drop.ThaumcraftDrop;//神秘模组掉落
import suike.suikerawore.expand.enderio.EnchantAutoSmelt;

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

import net.minecraftforge.event.world.BlockEvent;

//挖掘工具检查
public class HandHold {
    public static void examine(BlockEvent.HarvestDropsEvent event) {
        //获取实体手持物品
        ItemStack itemStack = event.getHarvester().getHeldItemMainhand();

        if (ItemBase.isValidItemStack(itemStack)) {
            //获取物品的NBT标签
            NBTTagCompound tag = itemStack.getTagCompound();

            /*检查时运*/examineFortune(event, tag, itemStack);

            if (Examine.smelt) {
                /*重置熔炼*/examineSmelt(event, tag, itemStack);
            }

            if (Examine.thaumcraftID) {
                /*检查炽心*/examineThaumcraft(event, tag);
            }
        }
    }

//时运附魔
    public static void examineFortune(BlockEvent.HarvestDropsEvent event, NBTTagCompound tag, ItemStack itemStack) {
        /*重置时运*/BreakingMonitor.fortuneLevel = 0;

        //原版时运
        BreakingMonitor.fortuneLevel = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, itemStack);

        //检查实体手持物品模组ID
        String itemId = itemStack.getItem().getRegistryName().toString();

        if (tag != null && itemId.startsWith("tetra")) {
        //物品ID为"tetra"

            //检查左/右头部是否有"时运"
            boolean hasLeftFortune = tag.hasKey("duplex/head_left:enchantment/fortune");
            boolean hasRightFortune = tag.hasKey("duplex/head_right:enchantment/fortune");

            //获取左/右头部的"时运"等级
            int leftFortuneLevel = hasLeftFortune ? tag.getInteger("duplex/head_left:enchantment/fortune") : 0;
            int rightFortuneLevel = hasRightFortune ? tag.getInteger("duplex/head_right:enchantment/fortune") : 0;

            //左/右头部"时运"相加
            BreakingMonitor.fortuneLevel = leftFortuneLevel + rightFortuneLevel;
        }
    }

//熔炼附魔
    public static void examineSmelt(BlockEvent.HarvestDropsEvent event, NBTTagCompound tag, ItemStack itemStack) {
        /*重置熔炼*/BreakingMonitor.smelt = false;

        //检查实体手持物品ID
        String itemId = itemStack.getItem().getRegistryName().toString();

        if (itemId.equals("twilightforest:fiery_pickaxe")) {
        //暮色森林熔炼镐
            BreakingMonitor.smelt = true;//打开自动熔炼

        } else if (itemId.equals("vulcanite:vulcanite_pickaxe")) {
        //软碲铜镐
            BreakingMonitor.smelt = true;//打开自动熔炼

        } else if (Examine.endercoreID && EnchantAutoSmelt.examineSmelt(itemStack)) {
        //末影核心熔炼附魔
            BreakingMonitor.smelt = true;//打开自动熔炼

        } else if (tag != null && tag.hasKey("Modifiers")) {
        //匠魂熔炼附魔
            NBTTagList modifiersTag = tag.getTagList("Modifiers", 10);

            //遍历"Material"
            for (int i = 0; i < modifiersTag.tagCount(); i++) {
                NBTTagCompound modifierTag = modifiersTag.getCompoundTagAt(i);
                if ("autosmelt".equals(modifierTag.getString("identifier"))) {
                //打开自动熔炼
                    BreakingMonitor.smelt = true;

                } else if ("enderpickup".equals(modifierTag.getString("identifier"))) {
                //找到存入升级取消掉落
                    BreakingMonitor.blockID = BlockBase.BLOCK_COPPER.getDefaultState();
                    break;
                }
            }
        } else if (Examine.cofhcoreID && tag != null && tag.hasKey("ench")) {
        //CoFH核心熔炼附魔
            NBTTagList infenchList = tag.getTagList("ench", 10);

            //遍历"infench"
            for (int i = 0; i < infenchList.tagCount(); i++) {
                NBTTagCompound enchantmentTag = infenchList.getCompoundTagAt(i);
                short enchantmentId = enchantmentTag.getShort("id");

                if (enchantmentId == 27) {
                    BreakingMonitor.smelt = true;//打开自动熔炼
                    break;
                }
            }
        }
    }

//炽心附魔
    public static void examineThaumcraft(BlockEvent.HarvestDropsEvent event, NBTTagCompound tag) {
        /*重置炽心*/ThaumcraftDrop.refiningLevel = 0;

        if (tag != null && tag.hasKey("infench")) {
        //物品有"infench"标签, 检查是否有炽心附魔
            NBTTagList infenchList = tag.getTagList("infench", 10);

            //遍历"infench"
            for (int i = 0; i < infenchList.tagCount(); i++) {
                NBTTagCompound enchantmentTag = infenchList.getCompoundTagAt(i);
                short enchantmentId = enchantmentTag.getShort("id");
                short enchantmentLevel = enchantmentTag.getShort("lvl");

                //检查附魔id是否为4(炽心)
                if (enchantmentId == 4 && enchantmentLevel > 0) {
                    //设置id为4(炽心)的附魔等级
                    ThaumcraftDrop.refiningLevel = enchantmentLevel;
                    break;
                }
            }
        }
    }

//检查手持物是否为锤
    public static boolean isHoldingHammertime(BlockPos pos, World world) {
        //获取破坏点附近的玩家
        AxisAlignedBB boundingBox = new AxisAlignedBB(pos).grow(6);//增加范围
        for (EntityPlayer player : world.getEntitiesWithinAABB(EntityPlayer.class, boundingBox)) {
            ItemStack heldItem = player.getHeldItem(EnumHand.MAIN_HAND);
            if (heldItem.getItem().getRegistryName() != null && 
                heldItem.getItem().getRegistryName().toString().startsWith("hammertime")
            ) {
                if (EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, heldItem) > 0) {
                    return false;//精准采集附魔
                }
                /*重置时运*/BreakingMonitor.fortuneLevel = 0;
                /*检查时运*/BreakingMonitor.fortuneLevel = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, heldItem);
                return true;//找到持有指定工具的玩家
            }
        }
        return false;//没有找到持有指定工具的玩家
    }
}
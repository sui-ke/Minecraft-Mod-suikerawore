package com.suike.suikerawore.monitor.dropmonitor.examine;

import com.suike.suikerawore.item.BlockBase;
import com.suike.suikerawore.expand.Examine;
import com.suike.suikerawore.monitor.dropmonitor.EntityMonitor;
import com.suike.suikerawore.monitor.dropmonitor.drop.ThaumcraftDrop;//神秘模组掉落

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.init.Enchantments;
import net.minecraft.enchantment.EnchantmentHelper;

import net.minecraftforge.event.world.BlockEvent;

//挖掘工具检查
public class HandHold {
    public static void examine(BlockEvent.HarvestDropsEvent event) {

        //获取实体手持物品
        ItemStack itemStack = event.getHarvester().getHeldItemMainhand();
        if (itemStack.isEmpty()) {return;}

        //获取物品的NBT标签
        NBTTagCompound tag = itemStack.getTagCompound();

        //检查时运
        /*重置时运*/EntityMonitor.fortuneLevel = 0;
        examineFortune(event, tag, itemStack);

        //检查熔炼
        if (Examine.smelt) {
            /*重置熔炼*/EntityMonitor.smelt = false;
            examineSmelt(event, tag);
        }

        //检查炽心
        if (Examine.thaumcraftID) {
            /*重置炽心*/ThaumcraftDrop.refiningLevel = 0;
            examineThaumcraft(event, tag);
        }
    }

    public static void examineFortune(BlockEvent.HarvestDropsEvent event, NBTTagCompound tag, ItemStack itemStack) {
    //时运附魔
        //原版时运
        EntityMonitor.fortuneLevel = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, event.getHarvester().getHeldItemMainhand());

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
            EntityMonitor.fortuneLevel = leftFortuneLevel + rightFortuneLevel;
        }
    }

    public static void examineSmelt(BlockEvent.HarvestDropsEvent event, NBTTagCompound tag) {
    //熔炼附魔
        if (tag != null && tag.hasKey("Modifiers")) {
        //匠魂熔炼附魔
            NBTTagList modifiersTag = tag.getTagList("Modifiers", 10);

            //遍历"Material"
            for (int i = 0; i < modifiersTag.tagCount(); i++) {
                NBTTagCompound modifierTag = modifiersTag.getCompoundTagAt(i);
                if ("autosmelt".equals(modifierTag.getString("identifier"))) {
                //打开自动熔炼
                    EntityMonitor.smelt = true;

                } else if ("enderpickup".equals(modifierTag.getString("identifier"))) {
                //取消存入升级掉落
                    EntityMonitor.blockID = BlockBase.BLOCK_COPPER.getDefaultState();
                    break;
                }
            }
        } else if (tag != null && tag.hasKey("ench")) {
        //CoFH核心熔炼附魔
            NBTTagList infenchList = tag.getTagList("ench", 10);

            //遍历"infench"
            for (int i = 0; i < infenchList.tagCount(); i++) {
                NBTTagCompound enchantmentTag = infenchList.getCompoundTagAt(i);
                short enchantmentId = enchantmentTag.getShort("id");

                if (enchantmentId == 27) {
                    EntityMonitor.smelt = true;//打开自动熔炼
                    break;
                }
            }
        }
    }

    public static void examineThaumcraft(BlockEvent.HarvestDropsEvent event, NBTTagCompound tag) {
    //炽心附魔
        if (tag != null && tag.hasKey("infench")) {
        //物品有"infench"标签, 检查是否有炽心附魔
            NBTTagList infenchList = tag.getTagList("infench", 10);

            //遍历"infench"
            for (int i = 0; i < infenchList.tagCount(); i++) {
                NBTTagCompound enchantmentTag = infenchList.getCompoundTagAt(i);
                short enchantmentId = enchantmentTag.getShort("id");
                short enchantmentLevel = enchantmentTag.getShort("lvl");

                //检查附魔id是否为4 (炽心)
                if (enchantmentId == 4) {
                    //修改挖掘工具
                    EntityMonitor.tool = "thaumcraft";

                    //设置id为4的附魔等级
                    ThaumcraftDrop.refiningLevel = enchantmentLevel;
                    break;//找到后退出循环
                }
            }
        }
    }
}
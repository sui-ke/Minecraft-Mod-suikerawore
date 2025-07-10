package suike.suikerawore.event.dropevent;

import suike.suikerawore.item.ItemBase;
import suike.suikerawore.item.BlockBase;
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

// 挖掘工具检查
public class HandHold {
    private static final String TETRA_PREFIX = "tetra";
    private static final String VULCANITE_PREFIX = "vulcanite";
    private static final String HAMMERTIME_PREFIX = "hammertime";
    private static final String FIERY_PICKAXE = "twilightforest:fiery_pickaxe";
    private static final String VULCANITE_PICKAXE = "vulcanite:vulcanite_pickaxe";

    public static void itemExamine(ItemStack itemStack) {
        if (itemStack.isEmpty() || itemStack.getItem() == null) {
            return;
        }

        NBTTagCompound tag = itemStack.getTagCompound();

        /*检查时运*/examineFortune(tag, itemStack);

        if (Examine.smelt) {
            /*检查熔炼*/examineSmelt(tag, itemStack);
        }

        if (Examine.thaumcraftID) {
            /*检查炽心*/examineThaumcraft(tag);
        }
    }

// 时运附魔
    public static void examineFortune(NBTTagCompound tag, ItemStack itemStack) {
        // 原版时运
        BreakingEvent.fortuneLevel = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, itemStack);

        if (BreakingEvent.fortuneLevel > 0 || tag == null) return;

        //检查实体手持物品模组ID
        String itemId = itemStack.getItem().getRegistryName().toString();

        if (itemId.startsWith(TETRA_PREFIX)) {
            checkTetraFortune(tag); // Tetra 工具检查
        } 
        else if (itemId.startsWith(VULCANITE_PREFIX)) {
            checkVulcaniteFortune(tag); // Vulcanite 工具检查
        }
    }

    // Tetra 工具检查
    private static void checkTetraFortune(NBTTagCompound tag) {
        int leftFortune = tag.hasKey("duplex/head_left:enchantment/fortune") ? 
                          tag.getInteger("duplex/head_left:enchantment/fortune") : 0;
        int rightFortune = tag.hasKey("duplex/head_right:enchantment/fortune") ? 
                           tag.getInteger("duplex/head_right:enchantment/fortune") : 0;
        BreakingEvent.fortuneLevel = leftFortune + rightFortune;
    }

    // Vulcanite 工具检查
    private static void checkVulcaniteFortune(NBTTagCompound tag) {
        if (tag.hasKey("ench")) {
            NBTTagList enchList = tag.getTagList("ench", 10);
            for (int i = 0; i < enchList.tagCount(); i++) {
                NBTTagCompound enchantment = enchList.getCompoundTagAt(i);
                if (enchantment.getInteger("id") == 35) { // 35是时运的ID
                    BreakingEvent.fortuneLevel = enchantment.getShort("lvl");
                    break;
                }
            }
        }
    }

// 熔炼附魔
    public static void examineSmelt(NBTTagCompound tag, ItemStack itemStack) {
        String itemId = itemStack.getItem().getRegistryName().toString();

        if (FIERY_PICKAXE.equals(itemId) || VULCANITE_PICKAXE.equals(itemId)) {
            BreakingEvent.smelt = true; // 暮色森林熔炼镐 || 软碲铜镐
        }
        else if (Examine.cofhcoreID && ModEnchantmentHelper.hasCoFHSmelt(itemStack)) {
            BreakingEvent.smelt = true; // CoFH核心 熔炼附魔
        }
        else if (Examine.endercoreID && ModEnchantmentHelper.hasEnderIOSmelt(itemStack)) {
            BreakingEvent.smelt = true; // 末影核心 熔炼附魔
        }
        else if (tag != null && tag.hasKey("Modifiers")) {
            checkTinkersSmelt(tag); // 匠魂熔炼附魔
        }
    }

    private static void checkTinkersSmelt(NBTTagCompound tag) {
        NBTTagList modifiersTag = tag.getTagList("Modifiers", 10);

        // 遍历"Material"
        for (int i = 0; i < modifiersTag.tagCount(); i++) {
            NBTTagCompound modifierTag = modifiersTag.getCompoundTagAt(i);
            if ("autosmelt".equals(modifierTag.getString("identifier"))) {
                // 找到熔炼附魔
                BreakingEvent.smelt = true;

            } else if ("enderpickup".equals(modifierTag.getString("identifier"))) {
                // 找到存入升级取消掉落
                BreakingEvent.way = "hasEnderpickupEnch";
                break;
            }
        }
    }

// 炽心附魔
    public static void examineThaumcraft(NBTTagCompound tag) {
        if (tag != null && tag.hasKey("infench")) {
            NBTTagList infenchList = tag.getTagList("infench", 10);
            for (int i = 0; i < infenchList.tagCount(); i++) {
                NBTTagCompound enchantmentTag = infenchList.getCompoundTagAt(i);
                if (enchantmentTag.getShort("id") == 4) { // 4是炽心附魔ID
                    BreakingEvent.refiningLevel = enchantmentTag.getShort("lvl");
                    break;
                }
            }
        }
    }

// 检查手持物是否为锤
    public static boolean isHoldingHammertime(BlockPos pos, World world) {
        AxisAlignedBB boundingBox = new AxisAlignedBB(pos).grow(6);
        return world.getEntitiesWithinAABB(EntityPlayer.class, boundingBox)
            .stream().anyMatch(player -> {
                ItemStack heldItem = player.getHeldItemMainhand();
                if (heldItem != null && 
                    heldItem.getItem().getRegistryName().toString().startsWith(HAMMERTIME_PREFIX) &&
                    EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, heldItem) <= 0) {
                    itemExamine(heldItem);
                    return true;
                }
                return false;
            }
        );
    }
}
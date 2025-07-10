package suike.suikerawore.expand;

import net.minecraft.item.ItemStack;
import net.minecraft.enchantment.EnchantmentHelper;

import net.minecraftforge.fml.common.Optional;

//附魔检查
public class ModEnchantmentHelper {
    /*@Optional.Method(modid = "")
    public static boolean ExamineSmelt(ItemStack itemStack) {
        return EnchantmentHelper.getEnchantmentLevel(, itemStack) > 0;
    }*/

    @Optional.Method(modid = "cofhcore")
    public static boolean hasCoFHSmelt(ItemStack itemStack) {
        return EnchantmentHelper.getEnchantmentLevel(cofh.core.init.CoreEnchantments.smelting, itemStack) > 0;
    }

    @Optional.Method(modid = "endercore")
    public static boolean hasEnderIOSmelt(ItemStack itemStack) {
        return EnchantmentHelper.getEnchantmentLevel(com.enderio.core.common.enchant.EnchantAutoSmelt.instance(), itemStack) > 0;
    }
}
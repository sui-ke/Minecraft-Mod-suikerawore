package suike.suikerawore.expand.enderio;

import net.minecraft.item.ItemStack;
import net.minecraft.enchantment.EnchantmentHelper;

//末影核心自动熔炼附魔
public class EnchantAutoSmelt {
    public static boolean examineSmelt(ItemStack itemStack) {
        return EnchantmentHelper.getEnchantmentLevel(com.enderio.core.common.enchant.EnchantAutoSmelt.instance(), itemStack) > 0;
    }
}
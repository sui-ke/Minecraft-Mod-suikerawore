package suike.suikerawore.expand;

import java.util.*;
import java.util.function.Supplier;

import net.minecraft.item.ItemStack;
import net.minecraft.init.Enchantments;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;

import net.minecraftforge.fml.common.Loader;

public class ModEnchantmentHelper {
// 检查
    private static final ModEnchantmentHelper NONE = new ModEnchantmentHelper("", false);
    private static final Map<String, List<ModEnchantmentHelper>> MAP = new HashMap<>();
    private static List<ModEnchantmentHelper> getHelper(String enchID) {
        return MAP.getOrDefault(enchID, Arrays.asList(NONE));
    }

    public static int getLevel(ItemStack itemStack, String enchID) {
        for (ModEnchantmentHelper helper : getHelper(enchID)) {
            int level = helper.getLevel(itemStack);
            if (level > 0) {
                return level;
            }
        }
        return 0;
    }

    public static boolean hasEnch(ItemStack itemStack, String enchID) {
        for (ModEnchantmentHelper helper : getHelper(enchID)) {
            if (helper.hasEnch(itemStack)) {
                return true;
            }
        }
        return false;
    }

// 实例
    protected Enchantment ench;

    public ModEnchantmentHelper(String enchID, boolean isValid) {
        this(enchID, isValid, () -> null);
    }
    public ModEnchantmentHelper(String enchID, boolean isValid, Supplier<Enchantment> ench) {
        if (isValid) {
            MAP.computeIfAbsent(enchID, k -> new ArrayList<>()).add(this);
            this.ench = ench.get();
        }
    }

    protected boolean hasEnch(ItemStack itemStack) {
        return this.getLevel(itemStack) > 0;
    }
    protected int getLevel(ItemStack itemStack) {
        return this.ench == null ? 0 : EnchantmentHelper.getEnchantmentLevel(this.ench, itemStack);
    }

    public static void initHelper() {
        new ModEnchantmentHelper("silkTouch", true, () -> Enchantments.SILK_TOUCH);
        new ModEnchantmentHelper("silkTouch", hasMod("tconstruct")) {
            @Override
            public boolean hasEnch(ItemStack itemStack) {
                if (itemStack.hasTagCompound()) {
                    NBTTagList nbtList = itemStack.getTagCompound().getTagList("Modifiers", 10);
                    for (int i = 0; i < nbtList.tagCount(); i++) {
                        if ("enderpickup".equals(nbtList.getCompoundTagAt(i).getString("identifier"))) {
                            return true; // 不兼容存入升级
                        }
                    }
                }
                return false;
            }
        };
        new ModEnchantmentHelper("silkTouch", hasMod("flexibletools")) {
            @Override
            public int getLevel(ItemStack itemStack) {
                return flexibletoolsCheck(itemStack, 3, false);
            }
        };
        new ModEnchantmentHelper("fortune", true, () -> Enchantments.FORTUNE);
        new ModEnchantmentHelper("fortune", hasMod("tetra")) {
            @Override
            public int getLevel(ItemStack itemStack) {
                if (itemStack.hasTagCompound()) {
                    NBTTagCompound nbt = itemStack.getTagCompound();
                    int leftFortune = nbt.hasKey("duplex/head_left:enchantment/fortune") ? nbt.getInteger("duplex/head_left:enchantment/fortune") : 0;
                    int rightFortune = nbt.hasKey("duplex/head_right:enchantment/fortune") ? nbt.getInteger("duplex/head_right:enchantment/fortune") : 0;
                    return leftFortune + rightFortune;
                }
                return 0;
            }
        };
        new ModEnchantmentHelper("fortune", hasMod("flexibletools")) {
            @Override
            public int getLevel(ItemStack itemStack) {
                return flexibletoolsCheck(itemStack, 2, true);
            }
        };
        new ModEnchantmentHelper("smelt", hasMod("twilightforest", "vulcanite")) {
            private final List<String> types = Arrays.asList("twilightforest:fiery_pickaxe", "vulcanite:vulcanite_pickaxe");
            @Override
            public boolean hasEnch(ItemStack itemStack) {
                return this.types.contains(itemStack.getItem().getRegistryName().toString());
            }
        };
        new ModEnchantmentHelper("smelt", hasMod("tconstruct")) {
            @Override
            public boolean hasEnch(ItemStack itemStack) {
                if (itemStack.hasTagCompound()) {
                    NBTTagList nbtList = itemStack.getTagCompound().getTagList("Modifiers", 10);
                    for (int i = 0; i < nbtList.tagCount(); i++) {
                        if ("autosmelt".equals(nbtList.getCompoundTagAt(i).getString("identifier"))) {
                            return true;
                        }
                    }
                }
                return false;
            }
        };
        new ModEnchantmentHelper("smelt", hasMod("cofhcore"), () -> Enchantment.getEnchantmentByLocation("cofhcore:smelting"));
        new ModEnchantmentHelper("smelt", hasMod("endercore"), () -> Enchantment.getEnchantmentByLocation("endercore:autosmelt"));
        /*new ModEnchantmentHelper("refining", hasMod("thaumcraft")) {
            @Override
            public int getLevel(ItemStack itemStack) {
                if (itemStack.hasTagCompound()) {
                    NBTTagList nbtList = itemStack.getTagCompound().getTagList("infench", 10);
                    for (int i = 0; i < nbtList.tagCount(); i++) {
                        NBTTagCompound enchantmentTag = nbtList.getCompoundTagAt(i);
                        if (enchantmentTag.getShort("id") == 4) {
                            return enchantmentTag.getShort("lvl");
                        }
                    }
                }
                return 0;
            }
        };//*/
    }

    private static int flexibletoolsCheck(ItemStack itemStack, int id, boolean needLevel) {
        int level = 0;
        if (itemStack.hasTagCompound() && "flexibletools:picki".equals(itemStack.getItem().getRegistryName().toString())) {
            NBTTagCompound tag = itemStack.getTagCompound();
            if (tag.hasKey("items")) {
                NBTTagCompound items = tag.getCompoundTag("items");
                for (int i = 0; i < 9; i++) {
                    String key = "__" + i;
                    if (items.hasKey(key)) {
                        NBTTagCompound slot = items.getCompoundTag(key);
                        if ("flexibletools:tool_upgrade_support".equals(slot.getString("id"))) {
                            if (slot.getShort("Damage") == id) {
                                if (!needLevel) {
                                    return 1;
                                }
                                level++;
                            }
                        }
                    }
                }
            }
        }
        return level;
    }

    private static boolean hasMod(String... mods) {
        for (String mod : mods) {
            if (Loader.isModLoaded(mod)) {
                return true;
            }
        }
        return false;
    }
}
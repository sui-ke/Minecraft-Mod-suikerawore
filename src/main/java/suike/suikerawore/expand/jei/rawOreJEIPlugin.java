package suike.suikerawore.expand.jei;

import suike.suikerawore.item.ItemBase;

import mezz.jei.api.JEIPlugin;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModRegistry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@JEIPlugin
public class rawOreJEIPlugin implements IModPlugin {
    @Override
    public void register(IModRegistry registry) {
        new Thread(() -> {
            int t = 0;
            // 等待 hideItem 方法填充 itemsToRemove 列表
            while (ItemBase.itemsToRemove.isEmpty()) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                t++;

                if (t >= 60) {
                    break;
                }
            }

            // 获取JEI帮助器
            IJeiHelpers jeiHelpers = registry.getJeiHelpers();

            if (jeiHelpers != null) {
                for (Item item : ItemBase.itemsToRemove) {
                    // 将物品添加到JEI黑名单
                    jeiHelpers.getItemBlacklist().addItemToBlacklist(new ItemStack(item));
                }
            }

        }).start();
    }
}
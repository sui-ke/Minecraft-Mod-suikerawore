package suike.suikerawore.proxy;

import suike.suikerawore.client.RawOreTabs;
import suike.suikerawore.client.ModelRegisterHelper;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

public class ClientProxy extends CommonProxy {
    @Override
    public void register() {
        RawOreTabs.creativeTabs();
    }

    @Override
    public void reloadAllModels() {
        ModelRegisterHelper.getHelper().reloadAllModels();
        ModelRegisterHelper.clearHelper();
    }

    @Override
    public void registerItemRenderer(Item item) {
        ModelRegisterHelper.getHelper().setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}
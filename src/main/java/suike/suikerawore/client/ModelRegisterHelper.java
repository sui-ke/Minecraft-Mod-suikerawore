package suike.suikerawore.client;

import java.util.*;

import net.minecraft.item.Item;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelManager;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.client.resource.VanillaResourceType;
import net.minecraftforge.registries.IRegistryDelegate;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.tuple.Pair;

@SideOnly(Side.CLIENT)
public class ModelRegisterHelper {

    private static ModelRegisterHelper helper = new ModelRegisterHelper();
    private final Map<Pair<IRegistryDelegate<Item>, Integer>, ModelResourceLocation> customModels = Maps.newHashMap();

    public static ModelRegisterHelper getHelper() {
        return helper;
    }
    public static void clearHelper() {
        helper = null;
    }

    public void setCustomModelResourceLocation(Item item, int metadata, ModelResourceLocation model) {
        this.customModels.put(Pair.of(item.delegate, metadata), model);
        ModelBakery.registerItemVariants(item, model);
    }

    private void onRegisterItems(ItemModelMesher mesher) {
        for (Map.Entry<Pair<IRegistryDelegate<Item>, Integer>, ModelResourceLocation> e : this.customModels.entrySet()) {
            mesher.register(e.getKey().getLeft().get(), e.getKey().getRight(), e.getValue());
        }
    }

    // 重新加载所有模型
    public void reloadAllModels() {
        this.onRegisterItems(Minecraft.getMinecraft().getRenderItem().getItemModelMesher());
        FMLClientHandler.instance().refreshResources(VanillaResourceType.MODELS, VanillaResourceType.TEXTURES);
    }
}

/*
    public void reloadAllModels() {
        if (modelManager == null || resourceManager == null) {
            throw new IllegalStateException("[RawOre]{ModelRegisterHelper} ModelManager or ResourceManager not initialized");
        }
        modelManager.onResourceManagerReload(resourceManager);
    }

    private ModelManager modelManager;
    private IResourceManager resourceManager;
    public static void setValue(Object object) {
        if (object instanceof ModelManager) {
            helper.modelManager = (ModelManager) object;
        }
        else if (object instanceof IResourceManager) {
            helper.resourceManager = (IResourceManager) object;
        }
    }
*/
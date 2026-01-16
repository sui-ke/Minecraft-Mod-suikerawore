package suike.suikerawore.event;

import net.minecraftforge.common.MinecraftForge;

import net.minecraftforge.fml.common.Loader;

public class Event {
    public static void register() {
        if (isValid(CastingRegisterEvent.value())) {
            MinecraftForge.EVENT_BUS.register(CastingRegisterEvent.class);
        }
    }

    public static void unregister() {
        MinecraftForge.EVENT_BUS.unregister(OreDictRegisterEvent.class);
        MinecraftForge.EVENT_BUS.unregister(CastingRegisterEvent.class);
    }

    private static boolean isValid(String modid) {
        return Loader.isModLoaded(modid);
    }
}
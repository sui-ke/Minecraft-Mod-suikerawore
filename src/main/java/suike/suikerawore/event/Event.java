package suike.suikerawore.event;

import net.minecraftforge.common.MinecraftForge;

import net.minecraftforge.fml.common.Loader;

public class Event {
    public static void register() {
        if (Loader.isModLoaded("tconstruct")) MinecraftForge.EVENT_BUS.register(CastingRegisterEvent.class);
    }

    public static void unregister() {
        if (Loader.isModLoaded("tconstruct")) MinecraftForge.EVENT_BUS.unregister(CastingRegisterEvent.class);
    }
}
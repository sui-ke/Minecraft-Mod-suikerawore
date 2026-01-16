package suike.suikerawore.asm;

import java.util.Map;
import java.util.HashMap;
import java.util.function.*;

import suike.suikerawore.asm.advice.*;
import suike.suikerawore.inter.IMethod;

import net.minecraftforge.fml.common.Loader;

import org.objectweb.asm.*;

public class ASMData {

    private static class Holder {
        static final Map<String, ASMData> ASM_DATA = initMap();
    }
    private static final Map<String, String> MODID_ASM = new HashMap<>();

    public final int classWriterType;
    public final int classReaderType;
    public final Function<AdviceAdapterData, IMethod> createMethod;

    public ASMData(int classWriterType, int classReaderType, Function<AdviceAdapterData, IMethod> createMethod) {
        this.classWriterType = classWriterType;
        this.classReaderType = classReaderType;
        this.createMethod = createMethod;
    }

    public static ASMData getDataByName(String transformedName) {
        synchronized (Holder.ASM_DATA) {
            return Holder.ASM_DATA.get(normalizeClassName(transformedName));
        }
    }
    public static String normalizeClassName(String transformedName) {
        // 从末尾反向查找 '@' 或 '.'
        for (int i = transformedName.length() - 1; i >= 0; i--) {
            char c = transformedName.charAt(i);
            if (c == '@') {
                return transformedName.substring(0, i); // 去除内存地址
            }
            if (c == '.') {
                return transformedName; // 无内存地址
            }
        }
        return transformedName;
    }

    private static void addMap(String transformed, ASMData data, boolean shouldAdd, Map<String, ASMData> map) {
        if (shouldAdd) {
            map.put(transformed, data);
        }
    }
    private static void addMap(String transformed, ASMData data, String modid, Map<String, ASMData> map) {
        MODID_ASM.put(modid, transformed);
        map.put(transformed, data);
    }

    private static Map<String, ASMData> initMap() {
        Map<String, ASMData> map = new HashMap<>();
        boolean isClient = isClient();

        injectOriginal(map, isClient);
        injectMod(map, isClient);

        return map;
    }

    // 原版注入
    private static void injectOriginal(Map<String, ASMData> map, boolean isClient) {}

    // 其他模组注入
    private static void injectMod(Map<String, ASMData> map, boolean isClient) {
        addMap(
            "wolforce.minergolems.entities.ai.MinerAI_7_FindAndBreakBlock",
            new ASMData(
                ClassWriter.COMPUTE_MAXS, 0,
                data -> new MinerAIDropMethod(data)
            ),
            "minergolems", map
        );
        addMap(
            "net.shadowmage.ancientwarfare.automation.tile.worksite.WorkSiteQuarry",
            new ASMData(
                ClassWriter.COMPUTE_MAXS, 0,
                data -> new WorkSiteQuarryMethod(data)
            ),
            "ancientwarfare", map
        );
    }

// 清理无效键
    public static void cleanup() {
        synchronized (Holder.ASM_DATA) {
            cleanupUnloadedMods();
        }
    }
    private static void cleanupUnloadedMods() {
        for (Map.Entry<String, String> entry : MODID_ASM.entrySet()) {
            if (!Loader.isModLoaded(entry.getKey())) {
                Holder.ASM_DATA.remove(entry.getValue());
            }
        }

        MODID_ASM.clear();
    }

// 客户端检查
    private static boolean isClient() {
        try {
            return Thread.currentThread().getContextClassLoader()
                .getResource("net/minecraft/client/main/Main.class") != null;
        } catch (Throwable e) {
            return true;
        }
    }
}
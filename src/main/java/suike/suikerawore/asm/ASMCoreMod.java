package suike.suikerawore.asm;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

@IFMLLoadingPlugin.SortingIndex(1)
@IFMLLoadingPlugin.MCVersion("1.12.2")
@IFMLLoadingPlugin.Name("suikeraworeasm")
public class ASMCoreMod implements IFMLLoadingPlugin {
    @Override
    public String[] getASMTransformerClass() {
        ASMData.getDataByName("");
        return new String[] { "suike.suikerawore.asm.ClassTransformer" };
    }

    @Override public String getSetupClass() { return null; }
    @Override public String getModContainerClass() { return null; }
    @Override public String getAccessTransformerClass() { return null; }
    @Override public void injectData(java.util.Map<String, Object> data) {}
}
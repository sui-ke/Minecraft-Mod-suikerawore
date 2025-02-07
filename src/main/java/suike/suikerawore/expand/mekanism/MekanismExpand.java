package suike.suikerawore.expand.mekanism;

//通用机械
public class MekanismExpand {
    public static void expand() {
        /*粉碎机配方*/CrusherRecipe.register();
        /*富集仓配方*/EnrichmentChamberRecipe.register();
        /*净化仓配方*/PurificationChamberRecipe.register();
        /*冶金灌注机配方*/MetallurgicInfuserRecipe.register();
        /*化学压射室配方*/ChemicalInjectionChamberRecipe.register();
        /*化学溶解室配方*/ChemicalDissolutionChamberRecipe.register();
    }
}
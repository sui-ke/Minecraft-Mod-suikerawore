package suike.suikerawore.expand.densemetals;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.config.Configuration;

//富集矿石
public class DenseMetals {

    public static int denseOreValue = 2;

    public static void expand() {
        /*添加各富集矿石矿词*/DenseOreAdd.Add();
        /*获取各富集矿石矿词*/DenseOresObtain.Obtain();
    }
}
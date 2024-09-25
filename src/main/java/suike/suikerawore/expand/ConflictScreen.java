package suike.suikerawore.expand;

import java.util.List;
import java.util.ArrayList;

import suike.suikerawore.SuiKe;
import suike.suikerawore.expand.Examine;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiButton;

import net.minecraftforge.fml.common.FMLCommonHandler;

public class ConflictScreen extends GuiScreen {

    //冲突模组列表
    public static List<String> ModID = new ArrayList<>();

    public static String BiaoTi;
    public static String ZhengWen;
    public static String Neglect;
    public static String Exit;

    public static void conflictModID(String modId) {
        //将检查到的模组加入到列表等待显示
        ModID.add(modId);
    }

    public static void conflict() {
        //检测当前语言环境
        if (SuiKe.isZhCn) {
            BiaoTi = "检测到冲突！";
            ZhengWen = "模组\"rawOre_on_1.12.2\"与模组\"" + ModID + "\"不兼容！";
            Neglect = "忽略";
            Exit = "退出";
        } else {
            BiaoTi = "Mod Conflict!";
            ZhengWen = "The mods \"rawOre_on_1.12.2\" and mods \"" + ModID + "\" are in incompatible!";
            Neglect = "Neglect";
            Exit = "Exit";
        }

        Minecraft.getMinecraft().addScheduledTask(() -> {
            Minecraft.getMinecraft().displayGuiScreen(
                new ConflictScreen(BiaoTi, ZhengWen, Neglect, Exit)
            );
        });
    }

    public ConflictScreen(String BiaoTi, String ZhengWen, String Neglect, String Exit) {
        this.BiaoTi = BiaoTi;
        this.ZhengWen = ZhengWen;
        this.Neglect = Neglect;
        this.Exit = Exit;
    }

    @Override
    public void initGui() {
        super.initGui();
        //添加按钮
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 2 + 20, 100, 20, Neglect));
        this.buttonList.add(new GuiButton(1, this.width / 2 - -1, this.height / 2 + 20, 100, 20, Exit));
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        //检查点击的按钮
        if (button.id == 0) {
            Minecraft.getMinecraft().displayGuiScreen(null);
        } else if (button.id == 1) {
            Minecraft.getMinecraft().shutdown();
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        //删除注册的监听器
        FMLCommonHandler.instance().bus().unregister(Examine.suikerawore_conflict);
        //渲染UI文字
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, BiaoTi, this.width / 2, this.height / 2 - 30, 0xFFFFFF);
        this.drawCenteredString(this.fontRenderer, ZhengWen, this.width / 2, this.height / 2 - 10, 0xFFFFFF);

        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}
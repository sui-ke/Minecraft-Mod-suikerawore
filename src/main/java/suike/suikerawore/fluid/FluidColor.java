package suike.suikerawore.fluid;

import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.IResource;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class FluidColor {

    public static int getColorFromTexture(String rawName) {
        // 创建资源定位器
        ResourceLocation resourceLocation = new ResourceLocation("suikerawore", "textures/items/rawore/" + rawName +".png");
        // 获取资源管理器
        IResourceManager resourceManager = Minecraft.getMinecraft().getResourceManager();

        try (IResource resource = resourceManager.getResource(resourceLocation)) {
            // 读取图片
            InputStream inputStream = resource.getInputStream();
            BufferedImage image = ImageIO.read(inputStream);

            if (image == null) {
                return 0xFF000000;
            }

            // 获取图片尺寸
            int width = image.getWidth();
            int height = image.getHeight();

            // 确定采样区域 (取前16x16像素, 如果图片更小则取全部)
            int sampleWidth = Math.min(16, width);
            int sampleHeight = Math.min(16, height);
 
            if ((sampleWidth * sampleHeight) == 0) {
                return 0xFF000000;
            }

            // 累计各通道的值
            long totalA = 0, totalR = 0, totalG = 0, totalB = 0, pixelCount = 0;

            for (int y = 0; y < sampleHeight; y++) {
                for (int x = 0; x < sampleWidth; x++) {
                    int pixel = image.getRGB(x, y);

                    if (((pixel >> 24) & 0xFF) == 0) continue;

                    // 分解RGB通道
                    int r = (pixel >> 16) & 0xFF;
                    int g = (pixel >> 8) & 0xFF;
                    int b = pixel & 0xFF;

                    totalR += r;
                    totalG += g;
                    totalB += b;
                    pixelCount++;
                }
            }

            // 计算平均值
            int avgR = (int) (totalR / pixelCount);
            int avgG = (int) (totalG / pixelCount);
            int avgB = (int) (totalB / pixelCount);
            // 组合为 ARGB 整数
            return 0xFF000000 | (avgR << 16) | (avgG << 8) | avgB;
        } catch (IOException e) {
            return 0xFF000000;
        }
    }
}
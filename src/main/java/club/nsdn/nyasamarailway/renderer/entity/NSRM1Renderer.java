package club.nsdn.nyasamarailway.renderer.entity;

import club.nsdn.nyasamarailway.api.cart.AbsTrainBase;
import club.nsdn.nyasamarailway.entity.train.NSRM1;
import cn.ac.nya.forgeobj.WavefrontObject;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

/**
 * Created by drzzm32 on 2019.2.27
 */
public class NSRM1Renderer extends AbsTrainRenderer {

    public static IRenderFactory<AbsTrainBase> FACTORY = NSRM1Renderer::new;

    private final String _name = "nsr_m1";

    private final WavefrontObject modelBase = new WavefrontObject(
            new ResourceLocation("nyasamarailway", "models/carts/" + _name + "_main.obj")
    );
    private final WavefrontObject modelPrint = new WavefrontObject(
            new ResourceLocation("nyasamarailway", "models/carts/" + _name + "_print.obj")
    );

    private final ResourceLocation textureBase = new ResourceLocation(
            "nyasamarailway", "textures/carts/" + _name + "_base.png"
    );
    private final ResourceLocation texturePrint = new ResourceLocation(
            "nyasamarailway", "textures/carts/" + _name + "_print.png"
    );

    public NSRM1Renderer(RenderManager manager) {
        super(manager);
    }

    @Override
    protected ResourceLocation getEntityTexture(AbsTrainBase train) {
        return textureBase;
    }

    @Override
    public void render(AbsTrainBase train, double x, double y, double z, float yaw) {
        GlStateManager.pushMatrix();
        GlStateManager.scale(0.0625, 0.0625, 0.0625);

        Minecraft.getMinecraft().getTextureManager().bindTexture(textureBase);
        modelBase.renderAllExcept("door1l", "door1r", "door2l", "door2r", "w0", "w1", "w2", "w3", "w4", "w5");

        if (train instanceof NSRM1) {
            NSRM1 metro = (NSRM1) train;

            GlStateManager.enableAlpha();
            GlStateManager.enableBlend();
            modelBase.renderOnly("w0", "w1", "w2", "w3", "w4", "w5");

            double prog = metro.doorProgressRight / 100.0 * 15;
            GlStateManager.pushMatrix();
            GlStateManager.translate(-prog, 0, 0);
            GlStateManager.enableAlpha();
            GlStateManager.enableBlend();
            modelBase.renderPart("door1l");
            GlStateManager.popMatrix();

            GlStateManager.pushMatrix();
            GlStateManager.translate(prog, 0, 0);
            GlStateManager.enableAlpha();
            GlStateManager.enableBlend();
            modelBase.renderPart("door1r");
            GlStateManager.popMatrix();

            prog = metro.doorProgressLeft / 100.0 * 15;
            GlStateManager.pushMatrix();
            GlStateManager.translate(prog, 0, 0);
            GlStateManager.enableAlpha();
            GlStateManager.enableBlend();
            modelBase.renderPart("door2l");
            GlStateManager.popMatrix();

            GlStateManager.pushMatrix();
            GlStateManager.translate(-prog, 0, 0);
            GlStateManager.enableAlpha();
            GlStateManager.enableBlend();
            modelBase.renderPart("door2r");
            GlStateManager.popMatrix();

            GlStateManager.disableAlpha();
            GlStateManager.disableBlend();
        }

        GlStateManager.enableAlpha();
        GlStateManager.enableBlend();
        Minecraft.getMinecraft().getTextureManager().bindTexture(texturePrint);
        modelPrint.renderAll();
        GlStateManager.disableAlpha();
        GlStateManager.disableBlend();

        GlStateManager.popMatrix();
    }

}

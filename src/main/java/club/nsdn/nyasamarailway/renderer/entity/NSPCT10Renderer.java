package club.nsdn.nyasamarailway.renderer.entity;

import club.nsdn.nyasamarailway.entity.cart.NSPCT10;
import club.nsdn.nyasamatelecom.api.render.RendererHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.util.ResourceLocation;
import cn.ac.nya.forgeobj.WavefrontObject;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import org.lwjgl.opengl.GL11;

/**
 * Created by drzzm32 on 2019.2.10
 */
public class NSPCT10Renderer extends AbsCartRenerer {

    public static IRenderFactory<EntityMinecart> FACTORY = NSPCT10Renderer::new;

    private final String _name = "nspc_10";

    private final WavefrontObject modelBase = new WavefrontObject(
            new ResourceLocation("nyasamarailway", "models/carts/" + _name + "_base.obj")
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

    public NSPCT10Renderer(RenderManager manager) {
        super(manager);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityMinecart cart) {
        return textureBase;
    }

    @Override
    public void render(EntityMinecart minecart, double x, double y, double z, float yaw) {
        ResourceLocation print = texturePrint;
        String str = "";

        if (minecart instanceof NSPCT10) {
            NSPCT10 cart = (NSPCT10) minecart;
            String info = cart.getExtendedInfo("side");
            if (!info.isEmpty())
                print = new ResourceLocation(
                        "nsr", "pics/" + info + ".png"
                );
            str = cart.getExtendedInfo("str");
        }

        RendererHelper.renderWithResource(modelBase, textureBase);
        RendererHelper.renderWithResource(modelPrint, print);

        if (!minecart.getPassengers().isEmpty())
            renderStr(str);
    }

    private void renderStr(String str) {
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, -0.25F, 0.0F);
        if (!str.isEmpty()) {
            RenderHelper.disableStandardItemLighting();
            doRenderStr(Minecraft.getMinecraft().fontRenderer, str);
            GL11.glPushMatrix();
            GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
            doRenderStr(Minecraft.getMinecraft().fontRenderer, str);
            GL11.glPopMatrix();
            RenderHelper.enableStandardItemLighting();
        }
        GL11.glPopMatrix();
    }

    private void doRenderStr(FontRenderer renderer, String str) {
        doRenderStr(renderer, str, 1.5F, 2.25F, 2.0F);
    }

}

package club.nsdn.nyasamarailway.Renderers.TileEntity;

import org.lwjgl.opengl.GL11;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.RenderHelper;
import club.nsdn.nyasamarailway.Renderers.RendererHelper;
import net.minecraftforge.client.model.obj.WavefrontObject;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import club.nsdn.nyasamarailway.TileEntities.Signals.TileEntitySignalLight;

/**
 * Created by drzzm32 on 2017.7.4.
 */
public class SignalLightRenderer extends TileEntitySpecialRenderer {

    private final WavefrontObject model;
    private final ResourceLocation[] textures = {
            new ResourceLocation("nyasamarailway", "textures/blocks/signal_light_none.png"),
            new ResourceLocation("nyasamarailway", "textures/blocks/signal_light_r.png"),
            new ResourceLocation("nyasamarailway", "textures/blocks/signal_light_y.png"),
            new ResourceLocation("nyasamarailway", "textures/blocks/signal_light_g.png"),
            new ResourceLocation("nyasamarailway", "textures/blocks/signal_light_w.png"),
            new ResourceLocation("nyasamarailway", "textures/blocks/signal_light_b.png"),
            new ResourceLocation("nyasamarailway", "textures/blocks/signal_light_p.png")
    };

    public SignalLightRenderer() {
        model = new WavefrontObject(
                new ResourceLocation("nyasamarailway", "models/blocks/signal_light.obj")
        );
    }

    public SignalLightRenderer(String modelPath) {
        model = new WavefrontObject(
                new ResourceLocation("nyasamarailway", modelPath)
        );
    }

    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y  + 0.5F, (float) z + 0.5F);

        RenderHelper.disableStandardItemLighting();
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_CULL_FACE);

        if (Minecraft.isAmbientOcclusionEnabled()) {
            GL11.glShadeModel(GL11.GL_SMOOTH);
        } else {
            GL11.glShadeModel(GL11.GL_FLAT);
        }

        Tessellator.instance.setColorOpaque_F(1.0F, 1.0F, 1.0F);

        int meta = te.getWorldObj().getBlockMetadata(te.xCoord, te.yCoord, te.zCoord);
        int angle = (meta & 0x3) * 90;

        int lightState = (meta >> 2) & 0x3;

        if (te instanceof TileEntitySignalLight) {
            if (((TileEntitySignalLight) te).lightType.equals("white&blue")) {
                if (lightState == 2) lightState = 4;
                else if (lightState == 3) lightState = 5;
                else lightState = 0;
            } else if (((TileEntitySignalLight) te).lightType.equals("yellow&purple")) {
                if (lightState == 2) lightState = 2;
                else if (lightState == 3) lightState = 6;
                else lightState = 0;
            }
        }

        RendererHelper.renderWithResourceAndRotation(model, angle, textures[lightState]);

        RenderHelper.enableStandardItemLighting();

        GL11.glPopMatrix();
    }

}
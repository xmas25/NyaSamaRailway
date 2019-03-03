package club.nsdn.nyasamarailway.renderer.entity;

import club.nsdn.nyasamatelecom.api.render.RendererHelper;
import cn.ac.nya.forgeobj.WavefrontObject;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

/**
 * Created by drzzm32 on 2019.3.3
 */
public class NSRA2Renderer extends AbsCartRenerer {

    public static IRenderFactory<EntityMinecart> FACTORY = NSRA2Renderer::new;

    private final String _name = "nsb_5m";

    private final WavefrontObject modelBase = new WavefrontObject(
            new ResourceLocation("nyasamarailway", "models/carts/" + _name + "_base.obj")
    );

    private final ResourceLocation textureBase = new ResourceLocation(
            "nyasamarailway", "textures/carts/" + _name + "_base.png"
    );

    private final WavefrontObject modelCtl = new WavefrontObject(
            new ResourceLocation("nyasamarailway", "models/carts/" + "nsr_auto_ctl.obj")
    );

    private final ResourceLocation textureCtl = new ResourceLocation(
            "nyasamarailway", "textures/carts/" + "nsr_auto_ctl.png"
    );

    public NSRA2Renderer(RenderManager manager) {
        super(manager);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityMinecart cart) {
        return textureBase;
    }

    @Override
    public void render(EntityMinecart cart, double x, double y, double z, float yaw) {
        RendererHelper.renderWithResource(modelBase, textureBase);
        RendererHelper.renderWithResource(modelCtl, textureCtl);
    }

}

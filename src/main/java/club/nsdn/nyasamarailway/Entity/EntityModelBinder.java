package club.nsdn.nyasamarailway.Entity;

/**
 * Created by drzzm32 on 2016.5.24.
 */

import club.nsdn.nyasamarailway.Renderers.Entity.*;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;

public class EntityModelBinder {

    public EntityModelBinder(FMLInitializationEvent event) {

        RenderingRegistry.registerEntityRenderingHandler(
                MinecartBase.class, new MinecartRenderer(new MinecartModel(), "textures/carts/nstc_1.png"));

        RenderingRegistry.registerEntityRenderingHandler(
                NSPCT1.class, new MinecartRenderer(new NSPCT1Model(), "textures/carts/nspc_1.png"));

        RenderingRegistry.registerEntityRenderingHandler(
                NSBT1.class, new MinecartRenderer(new NSBT1Model(), "textures/carts/nspc_1.png"));

        RenderingRegistry.registerEntityRenderingHandler(
                NSET1.class, new MinecartRenderer(new NSET1Model(), "textures/carts/nse_1.png"));

        RenderingRegistry.registerEntityRenderingHandler(
                TrainBase.class, new MinecartRenderer(new TrainModel(), "textures/blocks/BrushedAluminum.png"));

    }

}

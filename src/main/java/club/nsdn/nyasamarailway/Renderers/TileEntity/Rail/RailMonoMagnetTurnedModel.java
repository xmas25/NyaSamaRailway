package club.nsdn.nyasamarailway.Renderers.TileEntity.Rail;

/**
 * Created by drzzm32 on 2016.12.2.
 */

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class RailMonoMagnetTurnedModel extends ModelBase {

    ModelRenderer Body;

    public RailMonoMagnetTurnedModel() {
        textureWidth = 6;
        textureHeight = 17;

        Body = new ModelRenderer(this, -17, 0);
        Body.addBox(0F, 15.9F, 0F, 6, 0, 17);
        Body.setRotationPoint(-4F, 12F, -8F);
        Body.setTextureSize(6, 17);
        Body.mirror = true;
        setRotation(Body, 0F, 0.7853982F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(entity, f, f1, f2, f3, f4, f5);
        Body.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }


}

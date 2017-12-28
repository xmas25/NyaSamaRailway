package club.nsdn.nyasamarailway.renderer.tileentity.Rail;

/**
 * Created by drzzm32 on 2016.12.1.
 */

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class RailMonoSlopeSimpleModel extends ModelBase {

    ModelRenderer Body;

    public RailMonoSlopeSimpleModel() {
        textureWidth = 96;
        textureHeight = 48;

        Body = new ModelRenderer(this, 0, 0);
        Body.addBox(0F, 0F, 0F, 8, 9, 31);
        Body.setRotationPoint(-4F, 33.6F, -14.1F);
        Body.setTextureSize(64, 32);
        Body.mirror = true;
        setRotation(Body, 0.7853982F, 0F, 0F);
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

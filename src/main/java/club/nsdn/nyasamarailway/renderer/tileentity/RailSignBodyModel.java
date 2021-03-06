package club.nsdn.nyasamarailway.renderer.tileentity;

/**
 * Created by drzzm32 on 2016.5.22.
 */

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

public class RailSignBodyModel extends ModelBase {
    public ModelRenderer Shape1;

    public RailSignBodyModel() {
        textureWidth = 8;
        textureHeight = 18;

        Shape1 = new ModelRenderer(this, 0, 0);
        Shape1.addBox(0F, 0F, 0F, 2, 16, 2, 0F);
        Shape1.setRotationPoint(-1F, 8F, -1F);
        Shape1.rotateAngleX = 0F;
        Shape1.rotateAngleY = 0F;
        Shape1.rotateAngleZ = 0F;
        Shape1.mirror = false;
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(entity, f, f1, f2, f3, f4, f5);
        GL11.glPushMatrix();
        GL11.glScalef(0.7F, 1.0F, 0.7F);
        Shape1.render(f5);
        GL11.glPopMatrix();
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


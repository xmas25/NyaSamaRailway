package club.nsdn.nyasamarailway.renderer.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

/**
 * Created by drzzm32 on 2016.5.26.
 */

public class NSET1Model extends ModelBase {
    ModelRenderer r1p1;
    ModelRenderer r1p2;
    ModelRenderer r1p3;
    ModelRenderer r1p4;
    ModelRenderer r2p1;
    ModelRenderer r2p2on;
    ModelRenderer r2p2off;
    ModelRenderer s1p1;
    ModelRenderer s2p1;
    ModelRenderer s2p2;
    ModelRenderer s2p3;
    ModelRenderer s2p4;
    ModelRenderer Piece1;
    ModelRenderer Piece2;
    ModelRenderer Piece3;
    ModelRenderer Piece4;
    ModelRenderer Piece5;
    ModelRenderer Piece6;

    public NSET1Model() {
        textureWidth = 96;
        textureHeight = 48;
        setTextureOffset("Piece1.Shape1", 0, 24);
        setTextureOffset("Piece1.Shape2", 62, 0);
        setTextureOffset("Piece1.Shape3", 8, 24);
        setTextureOffset("Piece1.Shape4", 16, 24);
        setTextureOffset("Piece1.Shape5", 22, 24);
        setTextureOffset("Piece2.Shape1", 0, 24);
        setTextureOffset("Piece2.Shape2", 62, 0);
        setTextureOffset("Piece2.Shape3", 8, 24);
        setTextureOffset("Piece2.Shape4", 16, 24);
        setTextureOffset("Piece2.Shape5", 22, 24);
        setTextureOffset("Piece3.Shape1", 0, 24);
        setTextureOffset("Piece3.Shape2", 62, 0);
        setTextureOffset("Piece3.Shape3", 8, 24);
        setTextureOffset("Piece3.Shape4", 16, 24);
        setTextureOffset("Piece3.Shape5", 22, 24);
        setTextureOffset("Piece4.Shape1", 0, 30);
        setTextureOffset("Piece4.Shape2", 0, 30);
        setTextureOffset("Piece4.Shape3", 8, 30);
        setTextureOffset("Piece4.Shape4", 16, 30);
        setTextureOffset("Piece5.Shape1", 0, 30);
        setTextureOffset("Piece5.Shape2", 0, 30);
        setTextureOffset("Piece5.Shape3", 8, 30);
        setTextureOffset("Piece5.Shape4", 16, 30);
        setTextureOffset("Piece6.Shape1", 0, 24);
        setTextureOffset("Piece6.Shape2", 0, 29);
        setTextureOffset("Piece6.Shape3", 0, 29);
        setTextureOffset("Piece6.Shape4", 0, 42);
        setTextureOffset("Piece6.Shape5", 8, 42);
        setTextureOffset("Piece6.Shape6", 16, 42);
        setTextureOffset("Piece6.Shape7", 24, 42);
        setTextureOffset("Piece6.Shape8", 32, 42);
        setTextureOffset("Piece6.Shape9", 40, 42);
        setTextureOffset("Piece6.Shape10", 74, 0);
        setTextureOffset("Piece6.Shape11", 74, 0);
        setTextureOffset("Piece6.Shape12", 74, 0);
        setTextureOffset("Piece6.Shape13", 0, 29);

        r1p1 = new ModelRenderer(this, 78, 43);
        r1p1.addBox(0F, 0F, 0F, 8, 4, 1);
        r1p1.setRotationPoint(0F, 19F, -12F);
        r1p1.setTextureSize(96, 48);
        r1p1.mirror = true;
        setRotation(r1p1, -0.2792527F, -0.2792527F, 0F);
        r1p2 = new ModelRenderer(this, 78, 43);
        r1p2.addBox(-8F, 0F, 0F, 8, 4, 1);
        r1p2.setRotationPoint(0F, 19F, -12F);
        r1p2.setTextureSize(96, 48);
        r1p2.mirror = true;
        setRotation(r1p2, -0.2792527F, 0.2792527F, 0F);
        r1p3 = new ModelRenderer(this, 92, 43);
        r1p3.addBox(-0.5F, 0F, 0F, 1, 4, 1);
        r1p3.setRotationPoint(0F, 19F, -12F);
        r1p3.setTextureSize(96, 48);
        r1p3.mirror = true;
        setRotation(r1p3, -0.2792527F, 0F, 0F);
        r1p4 = new ModelRenderer(this, 0, 44);
        r1p4.addBox(0F, 0F, 0F, 4, 2, 2);
        r1p4.setRotationPoint(-2F, 18F, -11.5F);
        r1p4.setTextureSize(96, 48);
        r1p4.mirror = true;
        setRotation(r1p4, -0.2792527F, 0F, 0F);
        r2p1 = new ModelRenderer(this, 0, 36);
        r2p1.addBox(0F, 0F, 0F, 3, 3, 2);
        r2p1.setRotationPoint(-1.5F, 9F, -9F);
        r2p1.setTextureSize(96, 48);
        r2p1.mirror = true;
        setRotation(r2p1, 0F, 0F, 0F);
        r2p2on = new ModelRenderer(this, 90, 36);
        r2p2on.addBox(0F, 0F, 0F, 2, 2, 1);
        r2p2on.setRotationPoint(-1F, 9.5F, -10F);
        r2p2on.setTextureSize(96, 48);
        r2p2on.mirror = true;
        setRotation(r2p2on, 0F, 0F, 0F);
        r2p2off = new ModelRenderer(this, 90, 39);
        r2p2off.addBox(0F, 0F, 0F, 2, 2, 1);
        r2p2off.setRotationPoint(-1F, 9.5F, -10F);
        r2p2off.setTextureSize(96, 48);
        r2p2off.mirror = true;
        setRotation(r2p2off, 0F, 0F, 0F);
        s1p1 = new ModelRenderer(this, 48, 6);
        s1p1.addBox(0F, 0F, 0F, 10, 1, 14);
        s1p1.setRotationPoint(-5F, 7.7F, -7F);
        s1p1.setTextureSize(96, 48);
        s1p1.mirror = true;
        setRotation(s1p1, 0F, 0F, 0F);
        s2p1 = new ModelRenderer(this, 0, 0);
        s2p1.addBox(-1F, 0F, 0F, 2, 9, 14);
        s2p1.setRotationPoint(4F, 8F, -7F);
        s2p1.setTextureSize(96, 48);
        s2p1.mirror = true;
        setRotation(s2p1, 0F, 0F, -0.2792527F);
        s2p2 = new ModelRenderer(this, 0, 0);
        s2p2.addBox(-1F, 0F, 0F, 2, 9, 14);
        s2p2.setRotationPoint(-4F, 8F, -7F);
        s2p2.setTextureSize(96, 48);
        s2p2.mirror = true;
        setRotation(s2p2, 0F, 0F, 0.2792527F);
        s2p3 = new ModelRenderer(this, 74, 25);
        s2p3.addBox(0F, 0F, -1F, 10, 9, 1);
        s2p3.setRotationPoint(-5F, 8F, -6F);
        s2p3.setTextureSize(96, 48);
        s2p3.mirror = true;
        setRotation(s2p3, -0.2792527F, 0F, 0F);
        s2p4 = new ModelRenderer(this, 74, 25);
        s2p4.addBox(0F, 0F, 0F, 10, 9, 1);
        s2p4.setRotationPoint(-5F, 8F, 6F);
        s2p4.setTextureSize(96, 48);
        s2p4.mirror = true;
        setRotation(s2p4, 0.2792527F, 0F, 0F);
        Piece1 = new ModelRenderer(this, "Piece1");
        Piece1.setRotationPoint(0F, 22F, -6F);
        setRotation(Piece1, 0F, 0F, 0F);
        Piece1.mirror = true;
        Piece1.addBox("Shape1", -6F, -1F, -1F, 1, 3, 3);
        Piece1.addBox("Shape2", -8F, 0F, 0F, 16, 1, 1);
        Piece1.addBox("Shape3", 5F, -1F, -1F, 1, 3, 3);
        Piece1.addBox("Shape4", 3F, -0.5F, -0.5F, 1, 2, 2);
        Piece1.addBox("Shape5", -4F, -0.5F, -0.5F, 1, 2, 2);
        Piece2 = new ModelRenderer(this, "Piece2");
        Piece2.setRotationPoint(0F, 22F, -0.5F);
        setRotation(Piece2, 0F, 0F, 0F);
        Piece2.mirror = true;
        Piece2.addBox("Shape1", -6F, -1F, -1F, 1, 3, 3);
        Piece2.addBox("Shape2", -8F, 0F, 0F, 16, 1, 1);
        Piece2.addBox("Shape3", 5F, -1F, -1F, 1, 3, 3);
        Piece2.addBox("Shape4", 3F, -0.5F, -0.5F, 1, 2, 2);
        Piece2.addBox("Shape5", -4F, -0.5F, -0.5F, 1, 2, 2);
        Piece3 = new ModelRenderer(this, "Piece3");
        Piece3.setRotationPoint(0F, 22F, 5F);
        setRotation(Piece3, 0F, 0F, 0F);
        Piece3.mirror = true;
        Piece3.addBox("Shape1", -6F, -1F, -1F, 1, 3, 3);
        Piece3.addBox("Shape2", -8F, 0F, 0F, 16, 1, 1);
        Piece3.addBox("Shape3", 5F, -1F, -1F, 1, 3, 3);
        Piece3.addBox("Shape4", 3F, -0.5F, -0.5F, 1, 2, 2);
        Piece3.addBox("Shape5", -4F, -0.5F, -0.5F, 1, 2, 2);
        Piece4 = new ModelRenderer(this, "Piece4");
        Piece4.setRotationPoint(6.2F, 20F, 0F);
        setRotation(Piece4, 0F, 0F, 0F);
        Piece4.mirror = true;
        Piece4.addBox("Shape1", 0F, 0F, -8F, 2, 2, 16);
        Piece4.addBox("Shape2", 0.5F, 1.5F, -7F, 1, 1, 3);
        Piece4.addBox("Shape3", 0.5F, 1.5F, -1.5F, 1, 1, 3);
        Piece4.addBox("Shape4", 0.5F, 1.5F, 4F, 1, 1, 3);
        Piece5 = new ModelRenderer(this, "Piece5");
        Piece5.setRotationPoint(-8.2F, 20F, 0F);
        setRotation(Piece5, 0F, 0F, 0F);
        Piece5.mirror = true;
        Piece5.addBox("Shape1", 0F, 0F, -8F, 2, 2, 16);
        Piece5.addBox("Shape2", 0.5F, 1.5F, -7F, 1, 1, 3);
        Piece5.addBox("Shape3", 0.5F, 1.5F, -1.5F, 1, 1, 3);
        Piece5.addBox("Shape4", 0.5F, 1.5F, 4F, 1, 1, 3);
        Piece6 = new ModelRenderer(this, "Piece6");
        Piece6.setRotationPoint(0F, 8F, 0F);
        setRotation(Piece6, 0F, 0F, 0F);
        Piece6.mirror = true;
        Piece6.addBox("Shape1", -8F, 8F, -10F, 16, 4, 20);
        Piece6.addBox("Shape2", -6F, 4F, -8F, 12, 3, 16);
        Piece6.addBox("Shape3", -4F, 0F, -7F, 8, 4, 14);
        Piece6.addBox("Shape4", -4F, 10.5F, -7F, 1, 3, 3);
        Piece6.addBox("Shape5", 3F, 10.5F, -7F, 1, 3, 3);
        Piece6.addBox("Shape6", -4F, 10.5F, -1.5F, 1, 3, 3);
        Piece6.addBox("Shape7", 3F, 10.5F, -1.5F, 1, 3, 3);
        Piece6.addBox("Shape8", -4F, 10.5F, 4F, 1, 3, 3);
        Piece6.addBox("Shape9", 3F, 10.5F, 4F, 1, 3, 3);
        Piece6.addBox("Shape10", -5F, 11.5F, -6F, 10, 1, 1);
        Piece6.addBox("Shape11", -5F, 11.5F, -0.5F, 10, 1, 1);
        Piece6.addBox("Shape12", -5F, 11.5F, 5F, 10, 1, 1);
        Piece6.addBox("Shape13", -7F, 7F, -9F, 14, 1, 18);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        s1p1.render(f5);
        s2p1.render(f5);
        s2p2.render(f5);
        s2p3.render(f5);
        s2p4.render(f5);
        Piece1.render(f5);
        Piece2.render(f5);
        Piece3.render(f5);
        Piece4.render(f5);
        Piece5.render(f5);
        Piece6.render(f5);

        r1p1.render(f5);
        r1p2.render(f5);
        r1p3.render(f5);
        r1p4.render(f5);
        r2p1.render(f5);
        //r2p2on.render(f5);
        r2p2off.render(f5);

        GL11.glPushMatrix();
        GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
        r1p1.render(f5);
        r1p2.render(f5);
        r1p3.render(f5);
        r1p4.render(f5);
        r2p1.render(f5);
        //r2p2on.render(f5);
        r2p2off.render(f5);
        GL11.glPopMatrix();
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}

package club.nsdn.nyasamarailway.entity.nsc;

import club.nsdn.nyasamarailway.api.cart.nsc.AbsNSCxAM;
import club.nsdn.nyasamarailway.api.cart.nsc.IRotaCart;
import club.nsdn.nyasamarailway.network.TrainPacket;
import club.nsdn.nyasamarailway.util.TrainController;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

/**
 * Created by drzzm32 on 2019.2.10
 */
public class NSC1AM extends AbsNSCxAM implements IRotaCart {

    public float angle;

    @Override
    public float getAngle() {
        return angle;
    }

    @Override
    public void setAngle(float v) {
        angle = v % 360.0F;
    }

    public NSC1AM(World world) {
        super(world);
        ignoreFrustumCheck = true;
    }

    public NSC1AM(World world, double x, double y, double z) {
        super(world, x, y, z);
        ignoreFrustumCheck = true;
    }

    @Override
    public float getMaxCartSpeedOnRail() {
        return 8.0F;
    }

    @Override
    public double getMountedYOffset() {
        return -0.1;
    }

    @Nonnull
    @Override
    public ItemStack getCartItem() {
        return ItemStack.EMPTY;
    }

    @Override
    public void doMotion(TrainPacket packet, EntityMinecart cart) {
        TrainController.doMotionWithSlip(packet, cart, getMaxCartSpeedOnRail());
    }

}

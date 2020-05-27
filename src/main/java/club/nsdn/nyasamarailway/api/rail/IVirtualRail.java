package club.nsdn.nyasamarailway.api.rail;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

/**
 * Created by drzzm32 on 2020.2.15
 */
public interface IVirtualRail {
    Vec3d getTargetDirection(World world, BlockPos pos);
}

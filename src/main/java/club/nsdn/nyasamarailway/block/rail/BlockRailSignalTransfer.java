package club.nsdn.nyasamarailway.block.rail;

/**
 * Created by drzzm32 on 2016.7.26.
 */

import net.minecraft.world.World;
import net.minecraft.entity.item.EntityMinecart;

public class BlockRailSignalTransfer extends BlockRailPoweredBase implements IRailSpeedKeep {

    public BlockRailSignalTransfer() {
        super("BlockRailSignalTransfer");
        setTextureName("rail_signal_transfer");
    }

    @Override
    public void onMinecartPass(World world, EntityMinecart cart, int x, int y, int z) {
    }

}

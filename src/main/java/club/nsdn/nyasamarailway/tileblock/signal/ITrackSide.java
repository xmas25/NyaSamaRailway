package club.nsdn.nyasamarailway.tileblock.signal;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.List;

/**
 * Created by drzzm32 on 2019.1.4.
 */
public interface ITrackSide {

    boolean getSGNState();
    boolean getTXDState();
    boolean getRXDState();

    void setDir(ForgeDirection dir);

    static ForgeDirection defaultAxis() {
        return ForgeDirection.DOWN; // runs on the left
    }

    static EntityMinecart getMinecart(World world, int x, int y, int z) {
        float bBoxSize = 0.125F;
        List bBox = world.getEntitiesWithinAABB(
                EntityMinecart.class,
                AxisAlignedBB.getBoundingBox((double) ((float) x + bBoxSize),
                        (double) y,
                        (double) ((float) z + bBoxSize),
                        (double) ((float) (x + 1) - bBoxSize),
                        (double) ((float) (y + 1) - bBoxSize),
                        (double) ((float) (z + 1) - bBoxSize))
        );
        for (Object i : bBox.toArray()) {
            if (i instanceof EntityMinecart)
                return (EntityMinecart) i;
        }
        return null;
    }

    static EntityMinecart getMinecart(TileEntity tile, ForgeDirection dir) {
        if (tile instanceof ITrackSide) {
            ForgeDirection railPos = dir.getRotation(defaultAxis());
            EntityMinecart cart = getMinecart(
                    tile.getWorldObj(),
                    tile.xCoord + railPos.offsetX,
                    tile.yCoord + 1,
                    tile.zCoord + railPos.offsetZ
            );
            if (cart != null) return cart;
            cart = getMinecart(
                    tile.getWorldObj(),
                    tile.xCoord + railPos.offsetX,
                    tile.yCoord + railPos.offsetY,
                    tile.zCoord + railPos.offsetZ
            );
            return cart;
        }
        return null;
    }

    static boolean hasMinecart(TileEntity tile, ForgeDirection dir) {
        return getMinecart(tile, dir) != null;
    }

    static boolean hasPowered(World world, int x, int y, int z) {
        return (world.getBlockMetadata(x, y, z) & 8) != 0;
    }

    static boolean hasPowered(TileEntity tile) {
        return hasPowered(tile.getWorldObj(), tile.xCoord, tile.yCoord, tile.zCoord);
    }

    static boolean nearbyHasPowered(World world, int x, int y, int z) {
        return hasPowered(world, x + 1, y, z) || hasPowered(world, x - 1, y, z) ||
                hasPowered(world, x, y, z + 1) || hasPowered(world, x, y, z - 1);
    }

    static boolean nearbyHasPowered(TileEntity tile) {
        return nearbyHasPowered(tile.getWorldObj(), tile.xCoord, tile.yCoord, tile.zCoord);
    }

    static void setPowered(World world, int x, int y, int z, boolean state) {
        Block block = world.getBlock(x, y, z);
        int meta = world.getBlockMetadata(x, y, z);
        if (state) {
            if ((meta & 8) == 0) {
                world.setBlockMetadataWithNotify(x, y, z, meta | 8, 3);
                world.notifyBlocksOfNeighborChange(x, y, z, block);
                world.markBlockRangeForRenderUpdate(x, y, z, x, y, z);
            }
        } else {
            if ((meta & 8) != 0) {
                world.setBlockMetadataWithNotify(x, y, z, meta & 7, 3);
                world.notifyBlocksOfNeighborChange(x, y, z, block);
                world.markBlockRangeForRenderUpdate(x, y, z, x, y, z);
            }
        }
        world.func_147453_f(x, y, z, block);
    }

    static void setPowered(TileEntity tile, boolean state) {
        setPowered(tile.getWorldObj(), tile.xCoord, tile.yCoord, tile.zCoord, state);
    }
}
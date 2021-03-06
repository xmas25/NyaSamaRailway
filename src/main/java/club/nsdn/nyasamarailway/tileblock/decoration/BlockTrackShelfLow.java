package club.nsdn.nyasamarailway.tileblock.decoration;

/**
 * Created by drzzm32 on 2016.5.5.
 */

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import club.nsdn.nyasamarailway.tileblock.TileBlock;

public class BlockTrackShelfLow extends TileBlock {

    public static class TrackShelfLow extends TileEntity {
        @Override
        public boolean shouldRenderInPass(int pass) {
            return true;
        }
    }

    public BlockTrackShelfLow() {
        super("TrackShelfLow");
        setIconLocation("track_shelf_low");
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TrackShelfLow();
    }

    @Override
    public boolean isSideSolid(IBlockAccess world, int x, int y, int z, ForgeDirection side)
    {
        return true;
    }

}

package club.nsdn.nyasamarailway.Blocks;

import club.nsdn.nyasamarailway.Entity.LocoBase;
import club.nsdn.nyasamarailway.TileEntities.Signals.TileEntityRailPassiveReceiver;
import club.nsdn.nyasamarailway.TileEntities.Signals.TileEntityRailReceiver;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import org.thewdj.physics.Dynamics;

import java.util.Random;

/**
 * Created by drzzm32 on 2016.9.20.
 */
public class BlockRailNoSleeperRFID extends BlockRailPoweredBase implements ITileEntityProvider {

    public static class TileEntityRailRFID extends TileEntityRailPassiveReceiver {

        public int P = 0;
        public int R = 10;

        @Override
        public void fromNBT(NBTTagCompound tagCompound) {
            P = tagCompound.getInteger("P");
            R = tagCompound.getInteger("R");
            super.fromNBT(tagCompound);
        }

        @Override
        public NBTTagCompound toNBT(NBTTagCompound tagCompound) {
            tagCompound.setInteger("P", P);
            tagCompound.setInteger("R", R);
            return super.toNBT(tagCompound);
        }

    }

    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityRailRFID();
    }

    public BlockRailNoSleeperRFID() {
        super("BlockRailNoSleeperRFID");
        setTextureName("rail_ns_rfid");
    }

    @Override
    public void onBlockAdded(World world, int x, int y, int z) {
        super.onBlockAdded(world, x, y, z);
        world.scheduleBlockUpdate(x, y, z, this, 1);
    }

    @Override
    public void onBlockPreDestroy(World world, int x, int y, int z, int meta) {
        super.onBlockPreDestroy(world, x, y, z, meta);
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if (tileEntity != null) {
            if (tileEntity instanceof TileEntityRailReceiver) {
                ((TileEntityRailReceiver) tileEntity).onDestroy();
            }
        }
    }

    @Override
    public int tickRate(World world) {
        return 20;
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random random) {
        if (!world.isRemote) {
            if (world.getTileEntity(x, y, z) instanceof TileEntityRailRFID) {
                TileEntityRailRFID rfid = (TileEntityRailRFID) world.getTileEntity(x, y, z);
                int meta = rfid.getBlockMetadata();

                if (!isRailPowered(world, x, y, z) && rfid.senderIsPowered()) {
                    world.setBlockMetadataWithNotify(x, y, z, meta | 0x8, 3);
                    world.notifyBlocksOfNeighborChange(x, y, z, this);
                    world.markBlockRangeForRenderUpdate(x, y, z, x, y, z);
                } else if (!world.isBlockIndirectlyGettingPowered(x, y, z) && !rfid.senderIsPowered()) {
                    world.setBlockMetadataWithNotify(x, y, z, meta & 0x7, 3);
                    world.notifyBlocksOfNeighborChange(x, y, z, this);
                    world.markBlockRangeForRenderUpdate(x, y, z, x, y, z);
                }
            }

            world.scheduleBlockUpdate(x, y, z, this, 1);
        }
    }

    @Override
    public void onMinecartPass(World world, EntityMinecart cart, int x, int y, int z) {
        if (world.getTileEntity(x, y, z) instanceof TileEntityRailRFID) {
            TileEntityRailRFID rfid = (TileEntityRailRFID) world.getTileEntity(x, y, z);

            if (cart instanceof LocoBase) {
                LocoBase loco = (LocoBase) cart;

                if (isRailPowered(world, x, y, z) || rfid.senderIsPowered()) {
                    loco.P = rfid.P;
                    loco.R = rfid.R;
                }
            }

        }
    }

}

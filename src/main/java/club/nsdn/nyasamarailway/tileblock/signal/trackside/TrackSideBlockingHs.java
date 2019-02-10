package club.nsdn.nyasamarailway.tileblock.signal.trackside;

import club.nsdn.nyasamarailway.network.NetworkWrapper;
import club.nsdn.nyasamarailway.api.signal.ITrackSide;
import club.nsdn.nyasamarailway.api.signal.TileEntityTrackSideBlocking;
import club.nsdn.nyasamatelecom.api.util.NSASM;
import club.nsdn.nyasamatelecom.api.util.Util;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.LinkedHashMap;

/**
 * Created by drzzm32 on 2019.2.10
 */
public class TrackSideBlockingHs extends AbsTrackSide {

    public static class TileEntityTrackSideBlockingHs extends TileEntityTrackSideBlocking {

        public TileEntityTrackSideBlockingHs() {
            setInfo(13, 0.25, 0.3125, 1);
        }

        public static abstract class BlockingCore extends NSASM {

            public BlockingCore(String[][] code) {
                super(code);
            }

            @Override
            public SimpleNetworkWrapper getWrapper() {
                return NetworkWrapper.instance;
            }

            @Override
            public void loadFunc(LinkedHashMap<String, Operator> funcList) {
                funcList.put("inv", ((dst, src) -> {
                    if (src != null) return Result.ERR;
                    if (dst != null) return Result.ERR;

                    getBlocking().invert = !getBlocking().invert;

                    return Result.OK;
                }));
            }

            public abstract TileEntityTrackSideBlockingHs getBlocking();

        }

        protected boolean prevInv;

        @Override
        protected boolean hasChanged() {
            return super.hasChanged() || prevInv != isInvert();
        }

        @Override
        protected void updateChanged() {
            super.updateChanged();
            prevInv = isInvert();
        }

        @Override
        public boolean hasInvert() {
            return true;
        }

        @Override
        public boolean isInvert() {
            return invert;
        }

        @Override
        public void setInvert(boolean invert) {
            this.invert = invert;
        }

        public boolean invert = false;

        @Override
        public void fromNBT(NBTTagCompound tagCompound) {
            invert = tagCompound.getBoolean("invert");
            super.fromNBT(tagCompound);
        }

        @Override
        public NBTTagCompound toNBT(NBTTagCompound tagCompound) {
            tagCompound.setBoolean("invert", invert);
            return super.toNBT(tagCompound);
        }

        public static boolean configure(World world, BlockPos pos, EntityPlayer player) {
            TileEntity tileEntity = world.getTileEntity(pos);
            if (tileEntity == null) return false;
            if (tileEntity instanceof TileEntityTrackSideBlockingHs) {
                TileEntityTrackSideBlockingHs blocking = (TileEntityTrackSideBlockingHs) tileEntity;

                ItemStack stack = player.getHeldItemMainhand();
                if (!stack.isEmpty()) {
                    NBTTagList list = Util.getTagListFromNGT(stack);
                    if (list == null) return false;

                    if (!world.isRemote) {
                        String[][] code = NSASM.getCode(list);
                        new BlockingCore(code) {
                            @Override
                            public World getWorld() {
                                return world;
                            }

                            @Override
                            public double getX() {
                                return pos.getX();
                            }

                            @Override
                            public double getY() {
                                return pos.getY();
                            }

                            @Override
                            public double getZ() {
                                return pos.getZ();
                            }

                            @Override
                            public EntityPlayer getPlayer() {
                                return player;
                            }

                            @Override
                            public TileEntityTrackSideBlockingHs getBlocking() {
                                return blocking;
                            }
                        }.run();
                    }

                    return true;
                }
            }

            return false;
        }

        @Override
        public boolean nearbyHasMinecart() {
            boolean result = false;
            EnumFacing offset;

            TileEntityTrackSideBlocking blocking = getNearby(direction);
            if (blocking != null) {
                if (blocking.isInvert())
                    offset = blocking.direction.getOpposite();
                else
                    offset = blocking.direction;
                result = ITrackSide.hasMinecart(blocking, blocking.direction, offset);
            }
            blocking = getNearby(direction.getOpposite());
            if (blocking != null) {
                if (blocking.isInvert())
                    offset = blocking.direction.getOpposite();
                else
                    offset = blocking.direction;
                result |= ITrackSide.hasMinecart(blocking, blocking.direction, offset);
            }

            return result;
        }

        @Override
        public void tick(World world, BlockPos pos) {
            if (world.isRemote) return;
            TileEntity tileEntity = world.getTileEntity(pos);
            if (tileEntity == null) return;
            if (tileEntity instanceof TileEntityTrackSideBlockingHs) {
                TileEntityTrackSideBlockingHs blocking = (TileEntityTrackSideBlockingHs) tileEntity;

                EnumFacing offset = blocking.isInvert() ? blocking.direction.getOpposite() : blocking.direction;
                boolean hasCart = ITrackSide.hasMinecart(blocking, blocking.direction, offset);
                boolean hasPowered = ITrackSide.hasPowered(blocking);
                if (blocking.getTransceiver() != null) {
                    if (hasCart && !hasPowered) {
                        if (ITrackSide.nearbyHasPowered(blocking)) {
                            ITrackSide.setPowered(blocking, true);
                            ITrackSide.setPowered(blocking.getTransceiver(), true);
                        }
                    }
                } else {
                    if (hasCart && !hasPowered) {
                        ITrackSide.setPowered(blocking, true);
                    }

                    if (!hasCart && hasPowered) {
                        ITrackSide.setPowered(blocking, false);

                        if (!blocking.nearbyHasMinecart()) {
                            TileEntity[] tiles = blocking.getNearby();
                            for (TileEntity tile : tiles) {
                                if (tile instanceof TileEntityTrackSideBlocking) {
                                    TileEntityTrackSideBlocking tileBlocking = (TileEntityTrackSideBlocking) tile;
                                    ITrackSide.setPowered(tileBlocking, false);
                                    if (tileBlocking.getTransceiver() != null)
                                        ITrackSide.setPowered(tileBlocking.getTransceiver(), false);
                                }
                            }
                        }
                    }
                }

                if (blocking.hasChanged()) {
                    blocking.updateChanged();
                    blocking.refresh();
                }
            }
        }

    }

    public TrackSideBlockingHs() {
        super("TrackSideBlockingHs", "track_side_blocking_hs");
    }

    @Override
    public TileEntity createNewTileEntity() {
        return new TileEntityTrackSideBlockingHs();
    }

    @Override
    public boolean onConfigure(World world, BlockPos pos, EntityPlayer player) {
        return TileEntityTrackSideBlockingHs.configure(world, pos, player);
    }

}

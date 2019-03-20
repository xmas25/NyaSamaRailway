package club.nsdn.nyasamarailway.tileblock.func;

import club.nsdn.nyasamatelecom.api.tileentity.TileEntityActuator;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.thewdj.spline.Spline;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by drzzm32 on 2019.3.10.
 */
public class TileEntityBuildEndpoint extends TileEntityActuator {

    public static final int TYPE_TUBE = 0;
    public static final int TYPE_RECT = 1;
    public static final int TYPE_MONO = 2;
    public static final int TYPE_BRID = 3;

    public static class Task {

        public int tick = 20;

        public int type = 0;
        public int block = 0;
        public int radius = 0;
        public int height = 0;

        public LinkedList<BlockPos> blocks = new LinkedList<>();

        public Task setTick(int t) { tick = t; return this; }

        public Task setType(int t) { type = t; return this; }

        public Task setBlock(int id) { block = id; return this; }

        public Task setRadius(int r) { radius = Math.abs(r); return this; }

        public Task setHeight(int h) { height = Math.abs(h); return this; }

        public void place(World world, BlockPos pos) {
            IBlockState state = Block.getBlockById(block).getDefaultState();
            for (BlockPos offset : blocks) {
                if (world.getTileEntity(pos.add(offset)) instanceof TileEntityBuildEndpoint)
                    continue;
                world.setBlockState(pos.add(offset), state);
            }
        }

        public void make() {
            blocks.clear();
            switch (type) {
                case TYPE_TUBE:
                    if (radius == 0) break;
                    for (int x = -radius; x <= radius; x++)
                        for (int y = -radius; y <= radius; y++)
                            for (int z = -radius; z <= radius; z++) {
                                if (x * x + y * y + z * z <= radius * radius)
                                    blocks.add(new BlockPos(x, y, z));
                            }
                    break;
                case TYPE_RECT:
                    if (radius == 0) break;
                    if (height == 0) break;
                    for (int x = -radius; x <= radius; x++)
                        for (int y = 0; y <= height; y++)
                            for (int z = -radius; z <= radius; z++) {
                                if (x * x + z * z <= radius * radius)
                                    blocks.add(new BlockPos(x, y, z));
                            }
                    break;
                case TYPE_MONO:
                    blocks.add(BlockPos.ORIGIN);
                    break;
                case TYPE_BRID:
                    if (radius == 0) break;
                    if (height == 0) break;
                    int r = radius - 1, h = height - 1;
                    for (int x = -r; x <= r; x++)
                        for (int y = -h; y <= 0; y++)
                            for (int z = -r; z <= r; z++) {
                                if (x * x + y * y + z * z <= r * r)
                                    blocks.add(new BlockPos(x, y, z));
                            }
                    break;
            }
        }

    }

    public Task theTask = null;

    boolean inv = false;
    Spline hline = new Spline();
    Spline vline = new Spline();

    LinkedList<Vec3d> points = new LinkedList<>();

    static double len(double a, double b) {
        return Math.sqrt(a * a + b * b);
    }

    double counter = 0;
    public void reset() { counter = 0; }

    public boolean hasNext() {
        if (points.isEmpty()) return false;
        if (points.size() <= 2) return false;
        if (!inv)
            return counter <= Math.abs(points.peekLast().x - points.peekFirst().x);
        else
            return counter <= Math.abs(points.peekLast().z - points.peekFirst().z);
    }

    public Vec3d next() {
        double x, y, z;

        if (points.size() <= 2) return Vec3d.ZERO;

        if (!inv) {
            double sign = Math.signum(points.peekLast().x - points.peekFirst().x);
            x = points.peekFirst().x + counter * sign;
            z = hline.get(x);
        } else {
            double sign = Math.signum(points.peekLast().z - points.peekFirst().z);
            z = points.peekFirst().z + counter * sign;
            x = hline.get(z);
        }
        y = vline.get(len(x, z));

        if (hasNext())
            counter += 1.0;

        return new Vec3d(x, y, z);
    }

    void makeSplines() {
        if (points.size() <= 2) return;

        ArrayList<Double> x = new ArrayList<>();
        ArrayList<Double> y = new ArrayList<>();
        ArrayList<Double> z = new ArrayList<>();
        ArrayList<Double> h = new ArrayList<>();
        for (Vec3d vec : points) {
            x.add(vec.x); y.add(vec.y); z.add(vec.z);
            h.add(len(vec.x, vec.z));
        }

        if (!inv) {
            hline.set_points(x, z);
        } else {
            hline.set_points(z, x);
        }

        vline.set_points(h, y);
    }

    public void updateRoute() {
        points.clear();

        TileEntity te = this; double offset = 0.5;
        while (true) {
            if (te instanceof TileEntityActuator) {
                TileEntityActuator actuator = (TileEntityActuator) te;
                Vec3d vec = new Vec3d(actuator.getPos());
                vec = vec.addVector(offset, offset, offset);
                if (points.contains(vec)) break;
                points.add(vec);
                te = ((TileEntityActuator) te).getTarget();
            } else
                break;
        }

        if (points.size() <= 2) return;

        inv = Math.abs(points.peekLast().x - points.peekFirst().x) <= Math.abs(points.peekLast().z - points.peekFirst().z);

        /*Vec3d first = points.peekFirst(), fnext = points.get(points.indexOf(first) + 1);
        Vec3d last = points.peekLast(), lnext = points.get(points.indexOf(last) - 1);
        Vec3d vecf = fnext.subtract(first), vecl = last.subtract(lnext);
        points.addFirst(first.add(vecf.scale(-offset)));
        points.addLast(last.add(vecl.scale(offset)));*/

        makeSplines();
    }

    @Override
    public NBTTagCompound toNBT(NBTTagCompound tagCompound) {
        //hline.toNBT(tagCompound, "hLine_");
        //vline.toNBT(tagCompound, "vLine_");

        for (int i = 0; i < points.size(); i++) {
            tagCompound.setDouble("point_" + i + "_X", points.get(i).x);
            tagCompound.setDouble("point_" + i + "_Y", points.get(i).y);
            tagCompound.setDouble("point_" + i + "_Z", points.get(i).z);
        }

        tagCompound.setBoolean("inv", inv);

        return super.toNBT(tagCompound);
    }

    @Override
    public void fromNBT(NBTTagCompound tagCompound) {
        super.fromNBT(tagCompound);

        //hline.fromNBT(tagCompound, "hLine_");
        //vline.fromNBT(tagCompound, "vLine_");

        double x, y, z;
        for (int i = 0; tagCompound.hasKey("point_" + i + "_X"); i++) {
            x = tagCompound.getDouble("point_" + i + "_X");
            y = tagCompound.getDouble("point_" + i + "_Y");
            z = tagCompound.getDouble("point_" + i + "_Z");
            points.add(i, new Vec3d(x, y, z));
        }

        inv = tagCompound.getBoolean("inv");

        makeSplines();
    }

    @Override
    public boolean shouldRenderInPass(int pass) {
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    @Nonnull
    public AxisAlignedBB getRenderBoundingBox()
    {
        return INFINITE_EXTENT_AABB;
    }

    @Override
    public double getMaxRenderDistanceSquared() {
        return 65536.0;
    }

}
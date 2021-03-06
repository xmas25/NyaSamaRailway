package club.nsdn.nyasamarailway.item.loco;

import club.nsdn.nyasamarailway.creativetab.CreativeTabLoader;
import club.nsdn.nyasamarailway.entity.loco.NSPCT6C;
import net.minecraft.block.BlockRailBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemMinecart;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by drzzm32 on 2017.9.24.
 */
public class ItemNSPCT6C extends ItemMinecart {

    public ItemNSPCT6C() {
        super(-1);
        setUnlocalizedName("ItemNSPCT6C");
        setTexName("item_nspc_6c");
        setMaxStackSize(64);
        setCreativeTab(CreativeTabLoader.tabNyaSamaRailway);
    }

    protected void setTexName(String name) {
        setTextureName("nyasamarailway" + ":" + name);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float px, float py, float pz) {
        if (BlockRailBase.func_150051_a(world.getBlock(x, y, z))) {
            if (!world.isRemote) {
                String name = "";
                if (itemStack.hasDisplayName()) name = itemStack.getDisplayName();
                NSPCT6C.doSpawn(world, x, y, z, name);
            }

            --itemStack.stackSize;
            return true;
        } else {
            return false;
        }
    }
}

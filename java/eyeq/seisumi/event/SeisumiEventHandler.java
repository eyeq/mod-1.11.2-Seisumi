package eyeq.seisumi.event;

import eyeq.util.event.world.BlockFiredEvent;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class SeisumiEventHandler {
    @SubscribeEvent
    public void onBlockFired(BlockFiredEvent event) {
        IBlockState state = event.getState();
        Block block = state.getBlock();
        ItemStack itemStack = new ItemStack(block, 1, block.getMetaFromState(state));

        ItemStack output = FurnaceRecipes.instance().getSmeltingResult(itemStack);
        if(!isCharcoal(output)) {
            return;
        }
        World world = event.getWorld();
        BlockPos pos = event.getPos();
        Block.spawnAsEntity(world, pos, output.copy());
    }

    private boolean isCharcoal(ItemStack item) {
        return item.getItem() == Items.COAL && item.getItemDamage() == 1;
    }
}

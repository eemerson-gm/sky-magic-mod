package net.kupoapo.skymagic.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.kupoapo.skymagic.network.SkyMagicModVariables;

public class WaterydustRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		BlockState block_source = Blocks.AIR.defaultBlockState();
		BlockState block_converted = Blocks.AIR.defaultBlockState();
		block_source = (world.getBlockState(new BlockPos(x, y, z)));
		if (block_source.getBlock() == Blocks.STONE) {
			block_converted = Blocks.DRIPSTONE_BLOCK.defaultBlockState();
		} else if (block_source.getBlock() == Blocks.COBBLESTONE) {
			block_converted = Blocks.COBBLED_DEEPSLATE.defaultBlockState();
		}
		SkyMagicModVariables.convert_to = block_converted;
		DustRightclickedOnBlockProcedure.execute(world, x, y, z, entity, itemstack);
	}
}

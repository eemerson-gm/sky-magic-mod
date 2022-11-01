package net.kupoapo.skymagic.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

public class GetBlockIdProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		String block_id = "";
		return (("" + new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock())).replace("1", "")).strip();
	}
}

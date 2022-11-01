package net.kupoapo.skymagic.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.kupoapo.skymagic.SkyMagicMod;

public class WoodenMacheteBlockDestroyedWithToolProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		String command = "";
		if ((world.getBlockState(new BlockPos(x, y, z))).is(BlockTags.create(new ResourceLocation("minecraft:leaves")))) {
			command = "loot spawn ~ ~ ~ loot " + "minecraft:blocks/" + GetBlockIdProcedure.execute(world, x, y, z);
			SkyMagicMod.LOGGER.info(command);
			for (int index0 = 0; index0 < (int) (3); index0++) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level,
							4, "", new TextComponent(""), _level.getServer(), null).withSuppressedOutput(), command);
			}
		}
	}
}

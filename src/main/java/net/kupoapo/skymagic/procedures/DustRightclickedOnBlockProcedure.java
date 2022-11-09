package net.kupoapo.skymagic.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.kupoapo.skymagic.network.SkyMagicModVariables;
import net.kupoapo.skymagic.init.SkyMagicModItems;

public class DustRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double cx = 0;
		double cy = 0;
		double cz = 0;
		if (!(SkyMagicModVariables.convert_to.getBlock() == Blocks.AIR)) {
			cx = x + 0.5;
			cy = y + 0.5;
			cz = z + 0.5;
			if (itemstack.getItem() == SkyMagicModItems.NATURE_DUST.get()) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.GLOW, cx, cy, cz, 10, 0.5, 0.5, 0.5, 0.05);
			} else if (itemstack.getItem() == SkyMagicModItems.FIERY_DUST.get()) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.FLAME, cx, cy, cz, 10, 0.5, 0.5, 0.5, 0.05);
			} else if (itemstack.getItem() == SkyMagicModItems.WATERY_DUST.get()) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.SPLASH, cx, cy, cz, 10, 0.5, 0.5, 0.5, 0.05);
			}
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
			(itemstack).shrink(1);
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 5);
			if (!world.isClientSide()) {
				world.setBlock(new BlockPos(x, y, z), SkyMagicModVariables.convert_to, 3);
				world.levelEvent(2001, new BlockPos(x, y, z), Block.getId(SkyMagicModVariables.convert_to));
			}
		}
	}
}

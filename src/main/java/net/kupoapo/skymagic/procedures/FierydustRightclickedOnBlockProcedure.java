package net.kupoapo.skymagic.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import java.util.Random;

public class FierydustRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		String stone_type = "";
		BlockState stone_ore = Blocks.AIR.defaultBlockState();
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.STONE) {
			stone_type = "stone";
		} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.DEEPSLATE) {
			stone_type = "deepslate";
		} else if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == Blocks.NETHERRACK) {
			stone_type = "netherrack";
		}
		if (!(stone_type).isEmpty()) {
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
			(itemstack).setCount((int) ((itemstack).getCount() - 1));
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 5);
			if (!world.isClientSide()) {
				stone_ore = (ForgeRegistries.BLOCKS.tags()
						.getTag(BlockTags
								.create(new ResourceLocation((("forge:ores_in_ground/" + stone_type)).toLowerCase(java.util.Locale.ENGLISH))))
						.getRandomElement(new Random()).orElseGet(() -> Blocks.AIR)).defaultBlockState();
				world.setBlock(new BlockPos(x, y, z), stone_ore, 3);
				world.levelEvent(2001, new BlockPos(x, y, z), Block.getId(stone_ore));
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FLAME, x, y, z, 20, 0.75, 0.75, 0.75, 0.1);
		}
	}
}

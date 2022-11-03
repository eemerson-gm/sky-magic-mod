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

public class NaturedustRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		BlockState block_source = Blocks.AIR.defaultBlockState();
		BlockState block_converted = Blocks.AIR.defaultBlockState();
		block_source = (world.getBlockState(new BlockPos(x, y, z)));
		if (block_source.is(BlockTags.create(new ResourceLocation("minecraft:saplings")))) {
			block_source = (ForgeRegistries.BLOCKS.tags().getTag(BlockTags.create(new ResourceLocation("minecraft:saplings")))
					.getRandomElement(new Random()).orElseGet(() -> Blocks.AIR)).defaultBlockState();
		} else if (block_source.is(BlockTags.create(new ResourceLocation("minecraft:logs")))) {
			block_source = Blocks.SAND.defaultBlockState();
		} else if (block_source.getBlock() == Blocks.SANDSTONE) {
			block_source = Blocks.COBBLESTONE.defaultBlockState();
		} else if (block_source.getBlock() == Blocks.RED_SANDSTONE) {
			block_source = Blocks.DRIPSTONE_BLOCK.defaultBlockState();
		}
		if (!(block_converted.getBlock() == Blocks.AIR)) {
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
			(itemstack).shrink(1);
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 5);
			if (!world.isClientSide()) {
				world.setBlock(new BlockPos(x, y, z), block_converted, 3);
				world.levelEvent(2001, new BlockPos(x, y, z), Block.getId(block_converted));
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.COMPOSTER, x, y, z, 20, 0.75, 0.75, 0.75, 1);
		}
	}
}

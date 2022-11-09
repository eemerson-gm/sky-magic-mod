package net.kupoapo.skymagic.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.kupoapo.skymagic.network.SkyMagicModVariables;

import java.util.Random;

public class FierydustRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		BlockState block_source = Blocks.AIR.defaultBlockState();
		BlockState block_converted = Blocks.AIR.defaultBlockState();
		block_source = (world.getBlockState(new BlockPos(x, y, z)));
		if (block_source == Blocks.STONE.defaultBlockState()) {
			block_converted = (ForgeRegistries.BLOCKS.tags().getTag(BlockTags.create(new ResourceLocation("forge:ores_in_ground/stone")))
					.getRandomElement(new Random()).orElseGet(() -> Blocks.AIR)).defaultBlockState();
		} else if (block_source == Blocks.DEEPSLATE.defaultBlockState()) {
			block_converted = (ForgeRegistries.BLOCKS.tags().getTag(BlockTags.create(new ResourceLocation("forge:ores_in_ground/deepslate")))
					.getRandomElement(new Random()).orElseGet(() -> Blocks.AIR)).defaultBlockState();
		} else if (block_source == Blocks.NETHERRACK.defaultBlockState()) {
			block_converted = (ForgeRegistries.BLOCKS.tags().getTag(BlockTags.create(new ResourceLocation("forge:ores_in_ground/netherrack")))
					.getRandomElement(new Random()).orElseGet(() -> Blocks.AIR)).defaultBlockState();
		}
		SkyMagicModVariables.convert_to = block_converted;
		DustRightclickedOnBlockProcedure.execute(world, x, y, z, entity, itemstack);
	}
}

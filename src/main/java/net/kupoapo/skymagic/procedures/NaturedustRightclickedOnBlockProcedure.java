package net.kupoapo.skymagic.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.kupoapo.skymagic.network.SkyMagicModVariables;

import java.util.Random;
import java.util.Iterator;

public class NaturedustRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		BlockState block_source = Blocks.AIR.defaultBlockState();
		BlockState block_converted = Blocks.AIR.defaultBlockState();
		block_source = (world.getBlockState(new BlockPos(x, y, z)));
		if (block_source.is(BlockTags.create(new ResourceLocation("minecraft:saplings")))) {
			block_converted = (ForgeRegistries.BLOCKS.tags().getTag(BlockTags.create(new ResourceLocation("minecraft:saplings")))
					.getRandomElement(new Random()).orElseGet(() -> Blocks.AIR)).defaultBlockState();
		} else if (block_source.is(BlockTags.create(new ResourceLocation("minecraft:logs")))) {
			block_converted = Blocks.SAND.defaultBlockState();
			if (entity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("sky_magic:adv_sand"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemainingCriteria().iterator();
					while (_iterator.hasNext())
						_player.getAdvancements().award(_adv, (String) _iterator.next());
				}
			}
		} else if (block_source.getBlock() == Blocks.SANDSTONE) {
			block_converted = Blocks.COBBLESTONE.defaultBlockState();
			if (entity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("sky_magic:adv_cobblestone"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemainingCriteria().iterator();
					while (_iterator.hasNext())
						_player.getAdvancements().award(_adv, (String) _iterator.next());
				}
			}
		} else if (block_source.getBlock() == Blocks.LAPIS_BLOCK) {
			block_converted = Blocks.WATER.defaultBlockState();
			if (entity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("sky_magic:adv_water"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemainingCriteria().iterator();
					while (_iterator.hasNext())
						_player.getAdvancements().award(_adv, (String) _iterator.next());
				}
			}
		}
		SkyMagicModVariables.convert_to = block_converted;
		DustRightclickedOnBlockProcedure.execute(world, x, y, z, entity, itemstack);
	}
}

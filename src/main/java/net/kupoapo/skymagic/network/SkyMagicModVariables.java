package net.kupoapo.skymagic.network;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class SkyMagicModVariables {
	public static BlockState convert_to = Blocks.AIR.defaultBlockState();

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
	}
}

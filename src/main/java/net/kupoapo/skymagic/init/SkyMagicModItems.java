
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.kupoapo.skymagic.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.kupoapo.skymagic.item.WoodenMacheteItem;
import net.kupoapo.skymagic.item.WateryDustItem;
import net.kupoapo.skymagic.item.NaturedustItem;
import net.kupoapo.skymagic.item.MortarandpestleItem;
import net.kupoapo.skymagic.item.FierydustItem;
import net.kupoapo.skymagic.SkyMagicMod;

public class SkyMagicModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, SkyMagicMod.MODID);
	public static final RegistryObject<Item> MORTAR_AND_PESTLE = REGISTRY.register("mortar_and_pestle", () -> new MortarandpestleItem());
	public static final RegistryObject<Item> NATURE_DUST = REGISTRY.register("nature_dust", () -> new NaturedustItem());
	public static final RegistryObject<Item> FIERY_DUST = REGISTRY.register("fiery_dust", () -> new FierydustItem());
	public static final RegistryObject<Item> WOODEN_MACHETE = REGISTRY.register("wooden_machete", () -> new WoodenMacheteItem());
	public static final RegistryObject<Item> WATERY_DUST = REGISTRY.register("watery_dust", () -> new WateryDustItem());
}

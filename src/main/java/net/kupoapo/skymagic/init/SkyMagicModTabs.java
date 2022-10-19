
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.kupoapo.skymagic.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class SkyMagicModTabs {
	public static CreativeModeTab TAB_SKY_MAGICTAB;

	public static void load() {
		TAB_SKY_MAGICTAB = new CreativeModeTab("tabsky_magictab") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(SkyMagicModItems.NATUREDUST.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}

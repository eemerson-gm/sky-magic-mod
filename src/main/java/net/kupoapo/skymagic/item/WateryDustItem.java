
package net.kupoapo.skymagic.item;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;

import net.kupoapo.skymagic.procedures.WaterydustRightclickedOnBlockProcedure;
import net.kupoapo.skymagic.init.SkyMagicModTabs;

public class WateryDustItem extends Item {
	public WateryDustItem() {
		super(new Item.Properties().tab(SkyMagicModTabs.TAB_SKY_MAGICTAB).stacksTo(64).rarity(Rarity.UNCOMMON));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		WaterydustRightclickedOnBlockProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(),
				context.getClickedPos().getZ(), context.getPlayer(), context.getItemInHand());
		return InteractionResult.SUCCESS;
	}
}

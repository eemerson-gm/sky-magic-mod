
package net.kupoapo.skymagic.item;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;

import net.kupoapo.skymagic.procedures.FierydustRightclickedOnBlockProcedure;
import net.kupoapo.skymagic.init.SkyMagicModTabs;

public class FierydustItem extends Item {
	public FierydustItem() {
		super(new Item.Properties().tab(SkyMagicModTabs.TAB_SKY_MAGICTAB).stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		InteractionResult retval = super.useOn(context);
		FierydustRightclickedOnBlockProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(),
				context.getClickedPos().getZ(), context.getPlayer(), context.getItemInHand());
		return retval;
	}
}

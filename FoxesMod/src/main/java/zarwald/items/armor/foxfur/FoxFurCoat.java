package zarwald.items.armor.foxfur;

import necesse.gfx.gameTexture.GameTexture;
import necesse.inventory.item.Item;
import necesse.inventory.item.armorItem.ChestArmorItem;
import net.bytebuddy.asm.Advice.This;

public class FoxFurCoat extends ChestArmorItem {
	public FoxFurCoat() {
		super(4, 100, Item.Rarity.UNCOMMON, "foxfurcoatbody", "foxfurcoatarms");
	}
}

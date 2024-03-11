package zarwald.items.armor.foxfur;

import necesse.engine.modifiers.ModifierValue;
import necesse.entity.mobs.Mob;
import necesse.entity.mobs.buffs.BuffModifiers;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.Item;
import necesse.inventory.item.armorItem.ArmorModifiers;
import necesse.inventory.item.armorItem.BootsArmorItem;

public class FoxFurBoots extends BootsArmorItem {
	public FoxFurBoots() {
		super(2, 100, Item.Rarity.UNCOMMON, "foxfurboots");
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArmorModifiers getArmorModifiers(InventoryItem item, Mob mob) {
		return new ArmorModifiers(new ModifierValue[] {new ModifierValue(BuffModifiers.SPEED, 0.1f)});
	}
}

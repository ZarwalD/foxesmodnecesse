package zarwald.items.armor.foxfur;

import necesse.engine.modifiers.ModifierValue;
import necesse.engine.registries.DamageTypeRegistry;
import necesse.entity.mobs.Mob;
import necesse.entity.mobs.buffs.BuffModifiers;
import necesse.entity.mobs.gameDamageType.DamageType;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.Item;
import necesse.inventory.item.armorItem.ArmorModifiers;
import necesse.inventory.item.armorItem.SetHelmetArmorItem;

public class FoxHeadHat extends SetHelmetArmorItem {
	public FoxHeadHat() {
		super(3, DamageTypeRegistry.MELEE, 200, Item.Rarity.UNCOMMON, "foxheadhat", "foxfurcoat", "foxfurboots", "foxfursetbonus");
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public ArmorModifiers getArmorModifiers(InventoryItem item, Mob mob) {
		return new ArmorModifiers(new ModifierValue[] {new ModifierValue(BuffModifiers.SPEED, 0.1f)});
	}
}
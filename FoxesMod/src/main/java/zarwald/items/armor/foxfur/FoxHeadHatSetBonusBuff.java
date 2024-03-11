package zarwald.items.armor.foxfur;

import necesse.engine.localization.Localization;
import necesse.engine.modifiers.Modifier;
import necesse.entity.mobs.buffs.ActiveBuff;
import necesse.entity.mobs.buffs.BuffEventSubscriber;
import necesse.entity.mobs.buffs.BuffModifiers;
import necesse.entity.mobs.buffs.staticBuffs.armorBuffs.setBonusBuffs.SetBonusBuff;
import necesse.gfx.gameTooltips.ListGameTooltips;

public class FoxHeadHatSetBonusBuff extends SetBonusBuff {

	@Override
	public void init(ActiveBuff buff, BuffEventSubscriber eventSubscriber) {
		buff.setModifier(BuffModifiers.SPEED, 0.4f);
	}
	
	@Override
	public ListGameTooltips getTooltip(ActiveBuff ab) {
		ListGameTooltips tooltips = new ListGameTooltips();
		this.addAllModifierTips(tooltips, ab, false, new Modifier[0]);
		return tooltips;
	}
}
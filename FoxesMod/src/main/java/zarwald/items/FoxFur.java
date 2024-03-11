package zarwald.items;

import necesse.engine.localization.Localization;
import necesse.engine.util.GameBlackboard;
import necesse.entity.mobs.PlayerMob;
import necesse.gfx.gameTexture.GameTexture;
import necesse.gfx.gameTooltips.ListGameTooltips;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.matItem.MatItem;

public class FoxFur extends MatItem {
	public FoxFur() {
		super(100, Rarity.NORMAL);
		this.setItemCategory(new String[]{"materials", "mobdrops"});
	}
	
	@Override
	protected void loadItemTextures() {
		this.itemTexture = GameTexture.fromFile("items/foxfuritem");
	}
	
	@Override
	public ListGameTooltips getTooltips(InventoryItem item, PlayerMob perspective, GameBlackboard blackboard) {
	    ListGameTooltips tooltips = super.getTooltips(item, perspective, blackboard);
	    tooltips.add(Localization.translate("itemtooltip", "craftingmat"));
	    return tooltips;
	}
}
package zarwald;

import necesse.engine.modLoader.annotations.ModEntry;
import necesse.engine.registries.BuffRegistry;
import necesse.engine.registries.ItemRegistry;
import necesse.engine.registries.MobRegistry;
import necesse.engine.registries.RecipeTechRegistry;
import necesse.gfx.gameTexture.GameTexture;
import necesse.inventory.recipe.Ingredient;
import necesse.inventory.recipe.Recipe;
import necesse.inventory.recipe.Recipes;
import necesse.level.maps.biomes.forest.ForestBiome;
import zarwald.items.FoxFur;
import zarwald.items.armor.foxfur.FoxHeadHat;
import zarwald.items.armor.foxfur.FoxHeadHatSetBonusBuff;
import zarwald.items.armor.foxfur.FoxFurCoat;
import zarwald.items.armor.foxfur.FoxFurBoots;
import zarwald.mobs.FoxMob;

@ModEntry
public class FoxesMod {
	public void init() {
		MobRegistry.registerMob("foxmob", FoxMob.class, true);
		ItemRegistry.registerItem("foxfuritem", new FoxFur(), 5, true);
		ItemRegistry.registerItem("foxheadhat", new FoxHeadHat(), 25, true);
		ItemRegistry.registerItem("foxfurcoat", new FoxFurCoat(), 25, true);
		ItemRegistry.registerItem("foxfurboots", new FoxFurBoots(), 25, true);
		BuffRegistry.registerBuff("foxfursetbonus", new FoxHeadHatSetBonusBuff());
	}
	
	public void initResources() {
		FoxMob.texture = GameTexture.fromFile("mobs/foxmob");
	}
	
	public void postInit() {
		Recipes.registerModRecipe(new Recipe(
			"foxheadhat",
			1,
			RecipeTechRegistry.WORKSTATION,
			new Ingredient[] {
				new Ingredient("foxfuritem", 8)
			}
		).showAfter("clothboots"));
		Recipes.registerModRecipe(new Recipe(
				"foxfurcoat",
				1,
				RecipeTechRegistry.WORKSTATION,
				new Ingredient[] {
					new Ingredient("foxfuritem", 10)
				}
			).showAfter("foxheadhat"));
		Recipes.registerModRecipe(new Recipe(
				"foxfurboots",
				1,
				RecipeTechRegistry.WORKSTATION,
				new Ingredient[] {
					new Ingredient("foxfuritem", 6)
				}
			).showAfter("foxfurcoat"));
		ForestBiome.defaultSurfaceCritters.add(80, "foxmob");
	}
}

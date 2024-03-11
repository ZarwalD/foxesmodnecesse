package zarwald.mobs;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;

import necesse.engine.tickManager.TickManager;
import necesse.entity.mobs.MobDrawable;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.mobs.friendly.critters.CritterMob;
import necesse.entity.particle.FleshParticle;
import necesse.entity.particle.Particle;
import necesse.gfx.camera.GameCamera;
import necesse.gfx.drawOptions.DrawOptions;
import necesse.gfx.drawables.OrderableDrawables;
import necesse.gfx.gameTexture.GameTexture;
import necesse.inventory.lootTable.LootItemInterface;
import necesse.inventory.lootTable.LootTable;
import necesse.inventory.lootTable.lootItem.LootItem;
import necesse.level.maps.Level;
import necesse.level.maps.light.GameLight;

public class FoxMob extends CritterMob {
	public static GameTexture texture;
	public static LootTable lootTable = new LootTable(new LootItemInterface[] {new LootItem("foxfuritem")});

	public FoxMob() {
		super(40);
		this.setSpeed(40f);
		this.setFriction(3f);
		this.collision = new Rectangle(-9, -9, 15, 9); // purple
	    this.hitBox = new Rectangle(-14, -18, 25, 18); // blue
	    this.selectBox = new Rectangle(-16, -28, 32, 34); // select
	}
	
	@Override
	public LootTable  getLootTable() {
		return lootTable;
	}
	
	@Override
	public void init() {
		super.init();
	}
	
	@Override
	public void spawnDeathParticles(float knockbackX, float knockbackY) {
		for(int i = 0; i < 4; i++) {
			this.getLevel().entityManager.addParticle(new FleshParticle(this.getLevel(), texture, i, 8, 32, this.x, this.y, knockbackX, knockbackY), Particle.GType.IMPORTANT_COSMETIC);
		}
	}
	
	@Override
	public void addDrawables(List<MobDrawable> list, OrderableDrawables tileList, OrderableDrawables topList, Level level, int x, int y, TickManager tickManager, GameCamera camera, PlayerMob perspective) {
		super.addDrawables(list, tileList, topList, level, x, y, tickManager, camera, perspective);
		GameLight light = level.getLightLevel(x / 32, y / 32);
		int drawX = camera.getDrawX(x) - 32;
		int drawY = camera.getDrawY(y) - 46;
		Point sprite = this.getAnimSprite(x, y, this.dir);
		drawY += this.getBobbing(x, y);
		drawY += this.getLevel().getTile(x / 32, y / 32).getMobSinkingAmount(this);
		DrawOptions drawOptions = texture.initDraw().sprite(sprite.x, sprite.y, 64).light(light).pos(drawX, drawY);
		list.add(new MobDrawable() {
			public void draw(TickManager tickManager) {
				drawOptions.draw();
			}
		});
		this.addShadowDrawables(tileList, x, y, light, camera);
	}
	
	@Override
	public int getRockSpeed() {
		return 20;
	}
}

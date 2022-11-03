package engine;

import java.awt.Color;
import java.awt.Graphics2D;

import components.BoxBounds;
import components.Player;
import components.SpriteSheet;
import dataStructure.AssetPool;
import dataStructure.Transform;
import util.Constants;
import util.Vector2;

public class MapEditorScene extends Scene {

	GameObject player;

	public MapEditorScene(String name) {
		super(name);
	}

	@Override
	public void init() {
		this.player = new GameObject("Test object", new Transform(new Vector2(100.0f, 300.0f)));

		SpriteSheet layerOne = new SpriteSheet("assets/player/layerOne.png", 42, 42, 2, 13, 13 * 5);
		SpriteSheet layerTwo = new SpriteSheet("assets/player/layerTwo.png", 42, 42, 2, 13, 13 * 5);
		SpriteSheet layerThree = new SpriteSheet("assets/player/layerThree.png", 42, 42, 2, 13, 13 * 5);

		Player playerComp = new Player(layerOne.sprites.get(0), layerTwo.sprites.get(0), layerThree.sprites.get(0),
				Color.RED, Color.BLUE);
		this.player.addComponent(playerComp);
		this.player.transform.rotation = 45.0f;
		this.player.transform.scale.x = 2.0f;
		this.player.transform.scale.y = 2.0f;
	}

	@Override
	public void update(double delta) {
		this.player.update(delta);
		this.player.transform.rotation += delta * 1.0f;
	}

	@Override
	public void draw(Graphics2D g2d) {
		g2d.setColor(new Color(0.117f, 0.230f, 0.43f));
		g2d.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);

		this.player.draw(g2d);
	}
}

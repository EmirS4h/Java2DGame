package engine;

import java.awt.Color;
import java.awt.Graphics2D;

import components.BoxBounds;
import dataStructure.Transform;
import util.Constants;
import util.Vector2;

public class MapEditorScene extends Scene {

	GameObject testObj;
	
	public MapEditorScene(String name) {
		super(name);
	}

	@Override
	public void init() {
		this.testObj = new GameObject("Test object", new Transform(new Vector2(0.0f, 0.0f)));
		this.testObj.addComponents(new BoxBounds("New BoxBounds"));
	}

	@Override
	public void update(double delta) {
		System.out.println(testObj.getComponent(BoxBounds.class).name);
		testObj.update(delta);
	}

	@Override
	public void draw(Graphics2D g2d) {
		g2d.setColor(Color.BLUE);
		g2d.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
	}
}

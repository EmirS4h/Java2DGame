package engine;

import java.awt.Graphics2D;

public abstract class Scene {
	@SuppressWarnings("unused")
	private String name;

	public Scene(String name) {
		this.name = name;
		this.init();
	}

	public void init() {
		
	}

	public abstract void update(double delta);

	public abstract void draw(Graphics2D g2d);
}

package engine;

import java.awt.Graphics2D;

public abstract class Component<T> {
	public void update(double delta) {
		return;
	}
	
	public void draw(Graphics2D g2d) {
		return;
	}
}

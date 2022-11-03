package dataStructure;

import util.Vector2;

public class Transform {
	private Vector2 position;
	private Vector2 rotation;
	private Vector2 scale;

	public Transform(Vector2 position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Position (" + position.x + ", " + position.y + ")";
	}
}

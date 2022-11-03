package dataStructure;

import util.Vector2;

public class Transform {
	public Vector2 position;
	public float rotation;
	public Vector2 scale;

	public Transform(Vector2 position) {
		this.position = position;
		this.scale = new Vector2(1.0f, 1.0f);
		this.rotation = 0.0f;
	}

	@Override
	public String toString() {
		return "Position (" + position.x + ", " + position.y + ")";
	}
}

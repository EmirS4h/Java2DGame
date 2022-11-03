package components;

import java.util.ArrayList;
import java.util.List;

import dataStructure.AssetPool;

public class SpriteSheet {

	public List<Sprite> sprites;
	public int tileWidth;
	public int tileHeight;
	public int spacing;

	public SpriteSheet(String pictureFile, int tileWidth, int tileHeight, int spacing, int cols, int size) {
		this.tileWidth = tileWidth;
		this.tileHeight = tileHeight;
		this.spacing = spacing;

		Sprite parent = AssetPool.getSprite(pictureFile);

		sprites = new ArrayList<>();

		int row = 0;
		int count = 0;

		while (count < size) {
			for (int column = 0; column < cols; column++) {
				int imageX = (column * tileWidth) + (column * spacing);
				int imageY = (row * tileHeight) + (row * spacing);

				sprites.add(new Sprite(parent.image.getSubimage(imageX, imageY, tileWidth, tileHeight)));
				count++;

				if (count > size - 1) {
					break;
				}
			}
			row++;
		}
	}
}

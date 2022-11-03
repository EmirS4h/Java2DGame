package components;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import engine.Component;
import util.Constants;

public class Player extends Component {

	public Sprite layerOne, layerTwo, layerThree;
	public int width, height;
	private AffineTransform transform;

	public Player(Sprite layerOne, Sprite layerTwo, Sprite layerThree, Color layerOneColor, Color layerTwoColor) {

		this.layerOne = layerOne;
		this.layerTwo = layerTwo;
		this.layerThree = layerThree;

		int threshold = 200;
		this.width = Constants.PLAYER_WIDTH;
		this.height = Constants.PLAYER_HEIGHT;

		for (int y = 0; y < layerOne.image.getWidth(); y++) {
			for (int x = 0; x < layerOne.image.getHeight(); x++) {
				Color color = new Color(layerOne.image.getRGB(x, y));
				if (color.getRed() > threshold && color.getGreen() > threshold && color.getBlue() > threshold) {
					layerOne.image.setRGB(x, y, layerOneColor.getRGB());
				}
			}
		}

		for (int y = 0; y < layerTwo.image.getWidth(); y++) {
			for (int x = 0; x < layerTwo.image.getHeight(); x++) {
				Color color = new Color(layerTwo.image.getRGB(x, y));
				if (color.getRed() > threshold && color.getGreen() > threshold && color.getBlue() > threshold) {
					layerTwo.image.setRGB(x, y, layerTwoColor.getRGB());
				}
			}
		}
	}

	@Override
	public void draw(Graphics2D g2d) {

		transform = new AffineTransform();
		transform.setToIdentity();
		transform.translate(gameObject.transform.position.x, gameObject.transform.position.y);
		transform.rotate(gameObject.transform.rotation * Math.PI / 180.0f, width, height);
		transform.scale(gameObject.transform.scale.x, gameObject.transform.scale.y);

		g2d.drawImage(layerOne.image, transform, null);
		g2d.drawImage(layerTwo.image, transform, null);
		g2d.drawImage(layerThree.image, transform, null);
	}
}

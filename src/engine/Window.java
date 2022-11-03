package engine;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JFrame;

import util.Constants;

@SuppressWarnings("serial")
public class Window extends JFrame implements Runnable {

	private static Window window = null;
	private Scene currentScene = null;
	private Image doubleBufferImage = null;
	private Graphics doubleBufferGraphics;

	public MouseInputs mouseInputs;
	public KeyboardInputs keyboardInputs;

	private boolean isRunning = true;
	private long currentTime;

	public Window() {
		this.mouseInputs = new MouseInputs();
		this.keyboardInputs = new KeyboardInputs();

		this.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
		this.setTitle(Constants.SCREEN_TITLE);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.addMouseListener(this.mouseInputs);
		this.addMouseMotionListener(this.mouseInputs);
		this.addKeyListener(this.keyboardInputs);

		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public static Window getWindow() {
		if (Window.window == null) {
			Window.window = new Window();
		}
		return Window.window;
	}

	public void init() {
		changeScene(0);
	}

	public void changeScene(int scene) {
		switch (scene) {
		case 0:
			this.currentScene = new MapEditorScene("Map Editor");
			break;
		default:
			System.out.println("SCENE NOT FOUND");
			this.currentScene = null;
			break;
		}
	}

	public void update(double delta) {
		this.currentScene.update(delta);
		draw(getGraphics());
	}

	public void draw(Graphics g) {
		if (this.doubleBufferImage == null) {
			this.doubleBufferImage = createImage(getWidth(), getHeight());
			this.doubleBufferGraphics = this.doubleBufferImage.getGraphics();
		}
		renderOffScreen((Graphics2D) doubleBufferGraphics);
		g.drawImage(doubleBufferImage, 0, 0, getWidth(), getHeight(), null);
	}

	public void renderOffScreen(Graphics2D g2d) {
		currentScene.draw(g2d);
	}

	@Override
	public void run() {
		double timePerFrame = 1000000000.0 / 75.0;
		double timePerUpdate = 1000000000.0 / 75.0;

		long prevTime = System.nanoTime();

		int frames = 0;
		int updates = 0;

		long lastCheck = System.currentTimeMillis();

		double deltaU = 0;
		double deltaF = 0;

		while (isRunning) {
			currentTime = System.nanoTime();

			deltaU += (currentTime - prevTime) / timePerUpdate;
			deltaF += (currentTime - prevTime) / timePerFrame;
			prevTime = currentTime;

			if (deltaU >= 1) {
				update(deltaF);
				updates++;
				deltaU--;
			}

			if (deltaF >= 1) {
//				gamePanel.repaint();
				frames++;
				deltaF--;
			}

			if (System.currentTimeMillis() - lastCheck >= 1000) {
				lastCheck = System.currentTimeMillis();
				System.out.println("FPS : " + frames + " | UPS : " + updates);
				frames = 0;
				updates = 0;
			}
		}
	}

}

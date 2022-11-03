package engine;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInputs extends KeyAdapter implements KeyListener {
	private boolean keyPressed[] = new boolean[128];

	@Override
	public void keyPressed(KeyEvent e) {
		this.keyPressed[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		this.keyPressed[e.getKeyCode()] = false;
	}

	public boolean isKeyPressed(int keyCode) {
		return this.keyPressed[keyCode];
	}
}

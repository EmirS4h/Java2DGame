package engine;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInputs extends MouseAdapter {
	
	public boolean mousePressed;
	public boolean mouseDragged;
	
	public int mouseButton = -1;
	
	public float x = -1.0f;
	public float y = -1.0f;
	
	public float dx = -1.0f;
	public float dy = -1.0f;
	
	@Override
	public void mousePressed(MouseEvent e) {
		this.mousePressed = true;
		this.mouseButton = e.getButton();
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		this.mousePressed = false;
		this.mouseDragged = false;
		
		this.dx = 0;
		this.dy = 0;
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		this.x = e.getX();
		this.y = e.getY();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		this.mouseDragged = true;
		
		this.dx = e.getX() - this.x;
		this.dy = e.getY() - this.y;
	}
}

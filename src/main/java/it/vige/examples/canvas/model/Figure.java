package it.vige.examples.canvas.model;

import java.util.List;

/**
 * 
 * It represents a figure inside a canvas. It can be a line or a rectangle
 * 
 * @author lucastancapiano
 *
 */
public class Figure extends Point {

	private int x2;

	private int y2;

	public Figure(List<String> arguments, Canvas canvas) {
		super(arguments, canvas);
		x2 = new Integer(arguments.get(2)) - 1;
		y2 = new Integer(arguments.get(3)) - 1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}
}

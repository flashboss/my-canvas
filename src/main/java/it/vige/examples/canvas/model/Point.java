package it.vige.examples.canvas.model;

import java.util.List;

/**
 * 
 * A set of space coords
 * 
 * @author lucastancapiano
 *
 */
public class Point {

	protected int x;

	protected int y;

	/**
	 * If the point is inside a canvas, it must be used. A canvas should set
	 * this property to null.
	 */
	protected Canvas canvas;

	public Point(List<String> arguments, Canvas canvas) {
		x = new Integer(arguments.get(0)) - 1;
		y = new Integer(arguments.get(1)) - 1;
		this.canvas = canvas;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Canvas getCanvas() {
		return canvas;
	}
}

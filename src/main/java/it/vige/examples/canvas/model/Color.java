package it.vige.examples.canvas.model;

import java.util.List;

/**
 * 
 * It represents a single point to color inside the canvas
 * 
 * @author lucastancapiano
 *
 */
public class Color extends Point {

	/**
	 * The color represented as a character
	 */
	private char color;

	public Color(List<String> arguments, Canvas canvas) {
		super(arguments, canvas);
		color = arguments.get(2).charAt(0);
	}

	public char getColor() {
		return color;
	}

	public void setColor(char color) {
		this.color = color;
	}
}

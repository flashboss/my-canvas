package it.vige.examples.canvas.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * It's the windows containing rectangles and lines. It can be colored
 * 
 * @author lucastancapiano
 * 
 */
public class Canvas {

	private int width;
	private int height;
	private char[][] matrix;
	private List<Figure> lines = new ArrayList<Figure>();
	private List<Figure> rectangles = new ArrayList<Figure>();
	private List<Color> colors = new ArrayList<Color>();

	public Canvas(List<String> arguments) {
		width = new Integer(arguments.get(0));
		height = new Integer(arguments.get(1));
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public char[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(char[][] matrix) {
		this.matrix = matrix;
	}

	public List<Figure> getLines() {
		return lines;
	}

	public void setLines(List<Figure> lines) {
		this.lines = lines;
	}

	public List<Figure> getRectangles() {
		return rectangles;
	}

	public void setRectangles(List<Figure> rectangles) {
		this.rectangles = rectangles;
	}

	public List<Color> getColors() {
		return colors;
	}

	public void setColors(List<Color> colors) {
		this.colors = colors;
	}
}

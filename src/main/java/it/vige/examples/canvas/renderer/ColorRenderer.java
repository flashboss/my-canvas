package it.vige.examples.canvas.renderer;

import it.vige.examples.canvas.model.Color;

/**
 * 
 * The renderer to color the canvas
 * 
 * @author lucastancapiano
 * 
 */
public class ColorRenderer implements PointRenderer {

	private Color color;

	public ColorRenderer(Color color) {
		this.color = color;
	}

	@Override
	public Color getPoint() {
		return color;
	}

	@Override
	public void render() {
		aroundRectangle(color.getX(), color.getY());
	}

	/**
	 * It color recursively the canvas, avoiding the closed borders.
	 * 
	 * @param x
	 *            The current x coord to color
	 * @param y
	 *            The current y coord to color
	 */
	public void aroundRectangle(int x, int y) {
		// Base cases
		if (x < 0 || x >= color.getCanvas().getWidth() || y < 0 || y >= color.getCanvas().getHeight())
			return;
		char[][] matrix = color.getCanvas().getMatrix();
		char characterInMatrix = matrix[x][y];
		if (characterInMatrix != SPACE)
			return;

		// Replace the color at (x, y)
		matrix[x][y] = color.getColor();

		// Recur for north, east, south and west
		aroundRectangle(x + 1, y);
		aroundRectangle(x - 1, y);
		aroundRectangle(x, y + 1);
		aroundRectangle(x, y - 1);
	}
}

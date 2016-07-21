package it.vige.examples.canvas.renderer;

import it.vige.examples.canvas.model.Point;

/**
 * 
 * Point renderer
 * 
 * @author lucastancapiano
 *
 */
public interface PointRenderer extends Renderer {

	char DRAWING_POINT = 'x';

	/**
	 * It's the point (of figure) used by the renderer.
	 * 
	 * @return The point
	 */
	Point getPoint();

	/**
	 * It design a point according the size of the canvas using a default
	 * character as color.
	 * 
	 * @param x
	 *            The initial x position of the point
	 * @param y
	 *            The initial y position of the point
	 */

	default void drawPoint(int x, int y) {
		drawPoint(x, y, DRAWING_POINT);
	}

	/**
	 * It draws a point according the size of the canvas. It avoid to rewrite a
	 * drown point and it ensures that the point is not out of the border.
	 * 
	 * @param x
	 *            The initial x position of the point
	 * @param y
	 *            The initial y position of the point
	 * @param drawingPoint
	 *            The color of the point represented as a char
	 */

	default void drawPoint(int x, int y, char drawingPoint) {
		char[][] matrix = getPoint().getCanvas().getMatrix();
		if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] != DRAWING_POINT)
			matrix[x][y] = drawingPoint;
	}
}

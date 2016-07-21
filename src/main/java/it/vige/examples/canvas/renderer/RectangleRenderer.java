package it.vige.examples.canvas.renderer;

import it.vige.examples.canvas.model.Figure;

/**
 * 
 * The renderer to write the rectangles in the canvas
 * 
 * @author lucastancapiano
 *
 */
public class RectangleRenderer implements PointRenderer {

	private Figure rectangle;

	public RectangleRenderer(Figure rectangle) {
		this.rectangle = rectangle;
	}

	@Override
	public Figure getPoint() {
		return rectangle;
	}

	@Override
	public void render() {
		for (int x = rectangle.getX(); x < rectangle.getX2(); x++) {
			drawPoint(x, rectangle.getY());
			drawPoint(x, rectangle.getY2());
		}
		for (int y = rectangle.getY(); y <= rectangle.getY2(); y++) {
			drawPoint(rectangle.getX(), y);
			drawPoint(rectangle.getX2(), y);
		}
	}
}

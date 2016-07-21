package it.vige.examples.canvas.renderer;

import it.vige.examples.canvas.UnsupportedException;
import it.vige.examples.canvas.model.Figure;

/**
 * 
 * Renderer for the lines in the canvas. They can be only horizontal or vertical
 * 
 * @author lucastancapiano
 * 
 */
public class LineRenderer implements PointRenderer {

	private Figure line;

	public LineRenderer(Figure line) {
		this.line = line;
	}

	@Override
	public Figure getPoint() {
		return line;
	}

	@Override
	public void render() throws UnsupportedException {
		if (line.getX() == line.getX2()) {
			for (int i = line.getY(); i <= line.getY2(); i++)
				drawPoint(line.getX(), i);
		} else if (line.getY() == line.getY2()) {
			for (int i = line.getX(); i <= line.getX2(); i++)
				drawPoint(i, line.getY());
		} else
			throw new UnsupportedException();
	}
}

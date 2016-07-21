package it.vige.examples.canvas.renderer;

import java.io.PrintStream;
import java.util.List;

import it.vige.examples.canvas.UnsupportedException;
import it.vige.examples.canvas.model.Canvas;
import it.vige.examples.canvas.model.Color;
import it.vige.examples.canvas.model.Figure;

/**
 * 
 * Renderer for the canvas in the canvas. It starts the internal renderers too
 * as the lines, the colors, and the rectangles
 * 
 * @author lucastancapiano
 * 
 */
public class CanvasRenderer implements Renderer {

	public final static char HORIZONTAL_LINE = '-';
	public final static char VERTICAL_LINE = '|';

	private Canvas canvas;

	public CanvasRenderer(Canvas canvas) {
		this.canvas = canvas;
	}

	public Canvas getCanvas() {
		return canvas;
	}

	@Override
	public void render() throws UnsupportedException {
		List<Figure> lines = canvas.getLines();
		List<Figure> rectangles = canvas.getRectangles();
		List<Color> colors = canvas.getColors();
		initMatrix(canvas);
		for (Figure line : lines) {
			LineRenderer lineRenderer = new LineRenderer(line);
			lineRenderer.render();
		}
		for (Figure rectangle : rectangles) {
			RectangleRenderer rectangleRenderer = new RectangleRenderer(rectangle);
			rectangleRenderer.render();
		}
		for (Color color : colors) {
			ColorRenderer colorRenderer = new ColorRenderer(color);
			colorRenderer.render();
		}
	}

	/**
	 * Init the matrix and it sets inside the canvas
	 * 
	 * @param canvas
	 *            the canvas where insert the matrix
	 */
	private void initMatrix(Canvas canvas) {
		int height = canvas.getHeight();
		int width = canvas.getWidth();
		char[][] matrix = canvas.getMatrix();

		if (matrix == null) {
			matrix = new char[width][height];
			for (int i = 0; i < width; i++) {
				for (int j = 0; j < height; j++) {
					matrix[i][j] = SPACE;
				}
			}
			canvas.setMatrix(matrix);
		}
	}

	/**
	 * It prints the matrix in a stream
	 * 
	 * @param border
	 *            If true it prints the border of the matrix
	 * 
	 * @param printer
	 *            The stream where print
	 */
	public void print(boolean border, PrintStream printer) throws UnsupportedException {

		if (border) {
			for (int i = 0; i < canvas.getWidth() + 2; i++) {
				printer.print(HORIZONTAL_LINE);
			}
			printer.println();
		}

		char[][] matrix = canvas.getMatrix();
		for (int i = 0; i < canvas.getHeight(); i++) {
			if (border)
				printer.print(VERTICAL_LINE);
			for (int j = 0; j < canvas.getWidth(); j++) {
				printer.print(matrix[j][i]);
			}
			if (border)
				printer.print(VERTICAL_LINE + "\n");
		}

		if (border) {
			for (int i = 0; i < canvas.getWidth() + 2; i++) {
				printer.print(HORIZONTAL_LINE);
			}
			printer.println();
		}
	}
}

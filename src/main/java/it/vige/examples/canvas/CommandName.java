package it.vige.examples.canvas;

/**
 * 
 * The command names
 * 
 * @author lucastancapiano
 *
 */
public enum CommandName {
	// Creates the canvas. It need the width and height parameters
	C,
	// Creates a line. It need the x, y, x1 and x2 parameters
	L,
	// Creates a rectangle. It need the x, y, x1 and x2 parameters
	R,
	// Color the canvas. It need the x, y parameter of the initial point and the
	// color to use in the canvas
	B,
	// Quit
	Q
}

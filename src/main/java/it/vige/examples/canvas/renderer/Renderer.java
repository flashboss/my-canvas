package it.vige.examples.canvas.renderer;

import it.vige.examples.canvas.UnsupportedException;

/**
 * 
 * Generic renderer
 * 
 * @author lucastancapiano
 *
 */
public interface Renderer {

	char SPACE = ' ';
	
	void render() throws UnsupportedException;
	
}

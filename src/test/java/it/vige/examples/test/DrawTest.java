package it.vige.examples.test;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import it.vige.examples.canvas.Interpreter;
import it.vige.examples.canvas.UnsupportedException;

/**
 * 
 * Testing class with the main requested operations
 * 
 * @author lucastancapiano
 * 
 */
public class DrawTest {

	private Interpreter interpreter = new Interpreter();

	private String execute(String command) throws UnsupportedException {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		interpreter.setCommand(command.getBytes());
		interpreter.execute();
		interpreter.getCanvasRenderer().print(false, ps);
		String buffer = new String(baos.toByteArray(), UTF_8);
		assertNotNull(buffer);
		return buffer;
	}

	/**
	 * The main test inseting a canvas, two lines, a rectangle and in the end
	 * the canvas is colored with a 'o' charactes
	 * 
	 * @throws UnsupportedException
	 *             if the lines are not horizontal or vertical
	 */
	@Test
	public void testOk() throws UnsupportedException {
		String buffer = execute("C 20 4");
		assertEquals("                                                                                ", buffer);

		buffer = execute("L 1 2 6 2");
		assertEquals("                    xxxxxx                                                      ", buffer);
		buffer = execute("L 6 3 6 4");
		assertEquals("                    xxxxxx                   x                   x              ", buffer);

		buffer = execute("R 16 1 20 3");
		assertEquals("               xxxxxxxxxxx         x   x     x         xxxxx     x              ", buffer);

		buffer = execute("B 10 3 o");
		assertEquals("oooooooooooooooxxxxxxxxxxxooooooooox   x     xoooooooooxxxxx     xoooooooooooooo", buffer);
	}

	/**
	 * It tests the unsupported exception for the diagonal lines
	 * 
	 * @throws UnsupportedException
	 */
	@Test
	public void testUnsupported() throws UnsupportedException {
		String buffer = execute("C 20 4");
		assertEquals("                                                                                ", buffer);

		try {
			buffer = execute("L 1 3 6 2");
			fail();
		} catch (UnsupportedException ex) {
			assertEquals("                                                                                ", buffer);
		}
	}
}

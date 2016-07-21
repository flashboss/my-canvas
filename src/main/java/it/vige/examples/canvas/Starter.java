package it.vige.examples.canvas;

import static java.lang.System.err;
import static java.lang.System.in;
import static java.lang.System.out;

import java.io.IOException;

/**
 * 
 * It starts the application. The application runs inside a shell console and it
 * need to write the command line
 * 
 * @author lucastancapiano
 *
 */
public class Starter {

	/**
	 * It receives the args as commands as C, B, R and L. The command must be
	 * separated by spaces when you set the secundary attributes
	 * 
	 * @param args
	 *            the commands with syntax: [ command x...]
	 * @throws IOException
	 *             Used for errors inside the input stream
	 * @throws UnsupportedException
	 *             If the lines are not horizontals or verticals
	 */
	public static void main(String[] args) {
		Interpreter interpreter = new Interpreter();
		while (true) {
			try {
				byte[] input = new byte[200];
				in.read(input);
				interpreter.setCommand(input);
				interpreter.execute();
				interpreter.getCanvasRenderer().print(true, out);
			} catch (UnsupportedException e) {
				err.println("Diagonal lines are not supported");
			} catch (Exception e) {
				err.println("There is an error. Retry to write the command");
			}
		}
	}

}

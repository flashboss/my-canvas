package it.vige.examples.canvas;

import static it.vige.examples.canvas.CommandName.valueOf;

import it.vige.examples.canvas.model.Canvas;
import it.vige.examples.canvas.model.Color;
import it.vige.examples.canvas.model.Figure;
import it.vige.examples.canvas.renderer.CanvasRenderer;

/**
 * It receives the commands and build them. Then it delegate the renderers to
 * represent graphically the command
 * 
 * @author lucastancapiano
 *
 */
public class Interpreter {

	/**
	 * The command wrote with syntax: [command x...]
	 */
	private Command command;
	/**
	 * The renderer to draw the canvas and its children
	 */
	private CanvasRenderer canvasRenderer;

	public Command getCommand() {
		return command;
	}

	public void setCommand(Command command) {
		this.command = command;
	}

	public CanvasRenderer getCanvasRenderer() {
		return canvasRenderer;
	}

	/**
	 * It converts the bytes from the shell console in the Command object
	 * 
	 * @param input
	 */
	public void setCommand(byte[] input) {
		String[] splittedInput = new String(input).trim().split(" ");
		CommandName commandName = valueOf(splittedInput[0]);
		command = new Command();
		command.setName(commandName);
		for (int i = 1; i < splittedInput.length; i++)
			command.addArgument(splittedInput[i]);
	}

	/**
	 * It creates the figures and draw them.
	 * 
	 * @throws UnsupportedException
	 *             if the lines are diagonal
	 */
	public void execute() throws UnsupportedException {

		switch (command.getName()) {
		case C:
			Canvas canvas = new Canvas(command.getArguments());
			canvasRenderer = new CanvasRenderer(canvas);
			break;
		case L:
			canvas = canvasRenderer.getCanvas();
			Figure line = new Figure(command.getArguments(), canvas);
			canvas.getLines().add(line);
			break;
		case R:
			canvas = canvasRenderer.getCanvas();
			Figure rectangle = new Figure(command.getArguments(), canvas);
			canvas.getRectangles().add(rectangle);
			break;
		case B:
			canvas = canvasRenderer.getCanvas();
			Color color = new Color(command.getArguments(), canvas);
			canvas.getColors().add(color);
			break;
		case Q:
			System.exit(1);
		}
		canvasRenderer.render();
	}
}

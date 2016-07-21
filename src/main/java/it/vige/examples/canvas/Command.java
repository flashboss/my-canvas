package it.vige.examples.canvas;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * It represents the command to pass in the shell console
 * 
 * @author lucastancapiano
 *
 */
public class Command {

	private CommandName name;
	private List<String> arguments = new ArrayList<String>();

	public CommandName getName() {
		return name;
	}

	public void setName(CommandName name) {
		this.name = name;
	}

	public List<String> getArguments() {
		return arguments;
	}

	public void setArguments(List<String> arguments) {
		this.arguments = arguments;
	}

	public void addArgument(String argument) {
		this.arguments.add(argument);
	}
}

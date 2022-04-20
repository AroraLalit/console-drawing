package com.cs.consoledrawing.constants;

/**
 * @author Lalit Arora
 *
 */

public enum CommandType {
	CANVAS("C"), LINE("L"), RECTANGLE("R"), BUCKETFILL("B"), QUIT("Q");
	public final String command;

	private CommandType(String command) {
		this.command = command;
	}

	public static CommandType getCommand(String command) {
		for (CommandType type : CommandType.values()) {
			if (type.command.equals(command)) {
				return type;
			}
		}
		return null;
	}
}
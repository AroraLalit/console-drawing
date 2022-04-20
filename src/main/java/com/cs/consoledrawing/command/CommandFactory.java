package com.cs.consoledrawing.command;

import java.util.HashMap;
import java.util.Map;

import com.cs.consoledrawing.constants.CommandType;
import com.cs.consoledrawing.constants.Constants;
import com.cs.consoledrawing.exception.InvalidCommandException;

/**
 * @author Lalit Arora
 *
 */

public class CommandFactory {

	private static final Map<CommandType, Command> commands = new HashMap<>();

	public static void registerCommand(CommandType commandType,Command command) {
		commands.put(commandType, command);
	}

	public static Command getCommandInstance(String commandLabel) {
		CommandType commandType = CommandType.getCommand(commandLabel);
		if (commandType == null || commands.get(commandType) == null) {
			throw new InvalidCommandException(Constants.HELP_MESSAGE);
		}
		Command command = commands.get(commandType);
		return command;
	}

}

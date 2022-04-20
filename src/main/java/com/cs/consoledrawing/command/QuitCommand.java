package com.cs.consoledrawing.command;

import java.util.List;

import com.cs.consoledrawing.constants.Constants;
import com.cs.consoledrawing.context.ApplicationContext;

/**
 * @author Lalit Arora
 *
 */

public class QuitCommand implements Command {

	@Override
	public void execute(ApplicationContext context, List<String> commandParameters) {
		System.out.println(Constants.QUIT_COMMAND_MESSAGE);
		context.getScanner().close();
		System.exit(0);
	}

}

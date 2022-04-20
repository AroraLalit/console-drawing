package com.cs.consoledrawing.command;

import java.util.List;

import com.cs.consoledrawing.context.ApplicationContext;

/**
 * @author Lalit Arora
 *
 */

public interface Command {

	public void execute(ApplicationContext context, List<String> commandParameters);
	
}

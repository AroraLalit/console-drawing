package com.cs.consoledrawing.command;

import java.util.Arrays;
import java.util.List;

import com.cs.consoledrawing.constants.Constants;
import com.cs.consoledrawing.context.ApplicationContext;
import com.cs.consoledrawing.exception.InvalidCommandException;
import com.cs.consoledrawing.model.Canvas;
import com.cs.consoledrawing.util.Utils;

/**
 * @author Lalit Arora
 *
 */

public class CanvasCommand implements Command {

	@Override
	public void execute(ApplicationContext context, List<String> commandParameters) {
		if (commandParameters.size() != 2) {
			throw new InvalidCommandException(
					java.text.MessageFormat.format(Constants.CANVAS_COMMAND_HELP, commandParameters.size()));
		}
		int width = Utils.stringToInt(commandParameters.get(0));
		int height = Utils.stringToInt(commandParameters.get(1));
		Canvas canvas = new Canvas(height, width);
		char[][] canvasArray = new char[height + 2][width + 2];
		Arrays.stream(canvasArray).forEach(index -> Arrays.fill(index, ' '));
		context.setCanvas(canvasArray);
		canvas.draw(context.getCanvas());
		System.out.println(Utils.paint(context.getCanvas()));
	}

}

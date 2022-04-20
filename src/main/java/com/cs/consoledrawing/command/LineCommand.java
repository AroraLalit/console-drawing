package com.cs.consoledrawing.command;

import java.util.List;

import com.cs.consoledrawing.constants.CommandType;
import com.cs.consoledrawing.constants.Constants;
import com.cs.consoledrawing.context.ApplicationContext;
import com.cs.consoledrawing.exception.InvalidCommandException;
import com.cs.consoledrawing.model.Line;
import com.cs.consoledrawing.util.Utils;

/**
 * @author Lalit Arora
 *
 */

public class LineCommand implements Command {

	@Override
	public void execute(ApplicationContext context, List<String> commandParameters) {
		if (commandParameters.size() != 4) {
			throw new InvalidCommandException(
					java.text.MessageFormat.format(Constants.LINE_COMMAND_HELP, commandParameters.size()));
		}
		int col1 = Utils.stringToInt(commandParameters.get(0));
		int row1 = Utils.stringToInt(commandParameters.get(1));
		int col2 = Utils.stringToInt(commandParameters.get(2));
		int row2 = Utils.stringToInt(commandParameters.get(3));
		if (Utils.checkCanvasExists(context.getCanvas())
				&& Utils.checkIfValidCoordinates(context.getCanvas(), CommandType.LINE, row1, col1, row2, col2)) {
			Line line = null;
			if (row1 > row2 || col1 > col2) {
				line = new Line(row2, col2, row1, col1);
			} else {
				line = new Line(row1, col1, row2, col2);
			}
			line.draw(context.getCanvas());
			System.out.println(Utils.paint(context.getCanvas()));
		}
	}

}

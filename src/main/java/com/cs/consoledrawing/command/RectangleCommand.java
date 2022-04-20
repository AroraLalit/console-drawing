package com.cs.consoledrawing.command;

import java.util.List;

import com.cs.consoledrawing.constants.CommandType;
import com.cs.consoledrawing.constants.Constants;
import com.cs.consoledrawing.context.ApplicationContext;
import com.cs.consoledrawing.exception.InvalidCommandException;
import com.cs.consoledrawing.model.Rectangle;
import com.cs.consoledrawing.util.Utils;

/**
 * @author Lalit Arora
 *
 */

public class RectangleCommand implements Command {

	@Override
	public void execute(ApplicationContext context, List<String> commandParameters) {
		if (commandParameters.size() != 4) {
			throw new InvalidCommandException(
					java.text.MessageFormat.format(Constants.RECTANGLE_COMMAND_HELP, commandParameters.size()));
		}
		int col1 = Utils.stringToInt(commandParameters.get(0));
		int row1 = Utils.stringToInt(commandParameters.get(1));
		int col2 = Utils.stringToInt(commandParameters.get(2));
		int row2 = Utils.stringToInt(commandParameters.get(3));
		if (Utils.checkCanvasExists(context.getCanvas())
				&& Utils.checkIfValidCoordinates(context.getCanvas(), CommandType.RECTANGLE, row1, col1, row2, col2)) {
			Rectangle rectangle = null;
			if (col1 > col2 && row1 > row2) {
				rectangle = new Rectangle(row2, col2, row1, col1);
			} else if (row1 > row2) {
				rectangle = new Rectangle(row2, col1, row1, col2);
			} else if (col1 > col2) {
				rectangle = new Rectangle(row1, col2, row2, col1);
			} else {
				rectangle = new Rectangle(row1, col1, row2, col2);
			}
			rectangle.draw(context.getCanvas());
			System.out.println(Utils.paint(context.getCanvas()));
		}
	}

}

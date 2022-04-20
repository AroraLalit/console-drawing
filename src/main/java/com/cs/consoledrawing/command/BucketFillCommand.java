package com.cs.consoledrawing.command;

import java.util.List;

import com.cs.consoledrawing.constants.CommandType;
import com.cs.consoledrawing.constants.Constants;
import com.cs.consoledrawing.context.ApplicationContext;
import com.cs.consoledrawing.exception.InvalidCommandException;
import com.cs.consoledrawing.model.BucketFill;
import com.cs.consoledrawing.util.Utils;

/**
 * @author Lalit Arora
 *
 */

public class BucketFillCommand implements Command {

	public void execute(ApplicationContext context, List<String> commandParameters) {
		if (commandParameters.size() != 3) {
			throw new InvalidCommandException(
					java.text.MessageFormat.format(Constants.BUCKETFILL_COMMAND_HELP, commandParameters.size()));
		}
		int col = Utils.stringToInt(commandParameters.get(0));
		int row = Utils.stringToInt(commandParameters.get(1));
		char color = commandParameters.get(2).charAt(0);
		if (Utils.checkCanvasExists(context.getCanvas())
				&& Utils.checkIfValidCoordinates(context.getCanvas(), CommandType.BUCKETFILL, row, col, 0, 0)) {
			BucketFill fill = new BucketFill(row, col, color);
			fill.draw(context.getCanvas());
			System.out.println(Utils.paint(context.getCanvas()));
		}
	}

}

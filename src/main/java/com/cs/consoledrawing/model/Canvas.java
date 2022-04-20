package com.cs.consoledrawing.model;

import com.cs.consoledrawing.constants.Constants;
import com.cs.consoledrawing.util.Utils;

/**
 * @author Lalit Arora
 *
 */

public class Canvas implements DrawingTool {

	private int height;
	private int width;

	public Canvas(int height, int width) {
		super();
		this.height = height;
		this.width = width;
	}

	@Override
	public void draw(char[][] canvas) {
		Utils.drawHorizontalLine(canvas, 0, 0, width + 1, 0, Constants.HORIZONTAL_LINE_SYMBOL);
		Utils.drawVerticalLine(canvas, 0, 1, 0, height + 1, Constants.VERTICAL_LINE_SYMBOL);
		Utils.drawVerticalLine(canvas, width + 1, 1, width + 1, height + 1, Constants.VERTICAL_LINE_SYMBOL);
		Utils.drawHorizontalLine(canvas, 0, height + 1, width + 1, height + 1, Constants.HORIZONTAL_LINE_SYMBOL);
	}

}

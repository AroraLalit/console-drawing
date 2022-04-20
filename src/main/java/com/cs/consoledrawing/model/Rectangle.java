package com.cs.consoledrawing.model;

import com.cs.consoledrawing.constants.Constants;
import com.cs.consoledrawing.util.Utils;

/**
 * @author Lalit Arora
 *
 */

public class Rectangle implements DrawingTool {

	private int row1;
	private int col1;
	private int row2;
	private int col2;

	public Rectangle(int row1, int col1, int row2, int col2) {
		super();
		this.row1 = row1;
		this.col1 = col1;
		this.row2 = row2;
		this.col2 = col2;
	}

	@Override
	public void draw(char[][] canvas) {
		Utils.drawHorizontalLine(canvas, col1, row1, col2, row1, Constants.LINE_SYMBOL);
		Utils.drawHorizontalLine(canvas, col1, row2, col2, row2, Constants.LINE_SYMBOL);
		Utils.drawVerticalLine(canvas, col1, row1, col1, row2, Constants.LINE_SYMBOL);
		Utils.drawVerticalLine(canvas, col2, row1, col2, row2, Constants.LINE_SYMBOL);
	}

}

package com.cs.consoledrawing.model;

import com.cs.consoledrawing.util.Utils;

/**
 * @author Lalit Arora
 *
 */

public class BucketFill implements DrawingTool {

	private int row;
	private int col;
	private char color;

	public BucketFill(int row, int col, char color) {
		super();
		this.row = row;
		this.col = col;
		this.color = color;
	}

	@Override
	public void draw(char[][] canvas) {
		Utils.fillColor(canvas, row, col, color);
	}

}

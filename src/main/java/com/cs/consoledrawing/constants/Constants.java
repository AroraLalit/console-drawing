package com.cs.consoledrawing.constants;

/**
 * @author Lalit Arora
 *
 */

public class Constants {

	public static final String INFORMATION_MESSAGE = "This program works as follows:\n" + " 1. Create a new canvas\n"
			+ " 2. Start drawing on the canvas by issuing various commands\n" + " 3. Quit\n" + "\n"
			+ "Command \tDescription\n" + "\n" + "C w h           Should create a new canvas of width w and height h.\n"
			+ "L x1 y1 x2 y2   Should create a new line from (x1,y1) to (x2,y2). Currently only\n"
			+ "                horizontal or vertical lines are supported. Horizontal and vertical lines\n"
			+ "                will be drawn using the 'x' character.\n"
			+ "R x1 y1 x2 y2   Should create a new rectangle, whose upper left corner is (x1,y1) and\n"
			+ "                lower right corner is (x2,y2). Horizontal and vertical lines will be drawn\n"
			+ "                using the 'x' character.\n"
			+ "B x y c         Should fill the entire area connected to (x,y) with \"colour\" c. The\n"
			+ "                behavior of this is the same as that of the \"bucket fill\" tool in paint\n"
			+ "                programs.\n" + "Q               Should quit the program." + "\n" + "\n"
			+ "Enter command to draw canvas first:";

	public static final String HELP_MESSAGE = "Invalid command character provided. Supported ones are:" + "\n"
			+ "1. C for Canvas" + "\n" + "2. L for Line" + "\n" + "3. R for Rectangle" + "\n" + "4. B for BucketFill"
			+ "\n" + "5. Q for Quit";
	public static final String NEXT_COMMAND_MESSAGE = "Enter next command:";
	public static final String QUIT_COMMAND_MESSAGE = "Exiting the Application...";

	// Error Mapping
	public static final String NON_POSITIVE_COORDINATES = "Command coordinates should be positive integers";
	public static final String NO_CANVAS_EXISTS = "There no canvas created to draw any shape. Please create a canvas first";
	public static final String COORDINATES_OUTSIDE_CANVAS = "Coordinates are outside of the canvas";
	public static final String DIAGONAL_LINE_DETECTED = "We do not support diagonal lines at this moment. Try drawing a Straight line please.";
	public static final String BUCKETFILL_COMMAND_HELP = "BucketFill command requires 3 parameters. {0} params were provided."
			+ "\n" + " For eg. B x y c   should fill the entire area connected to (x,y) with 'colour' c. The "
			+ "behavior of this is the same as that of the 'bucket fill' tool in paint program";
	public static final String RECTANGLE_COMMAND_HELP = "Rectangle command requires 4 parameters. {0} params were provided."
			+ "\n" + "For eg. R x1 y1 x2 y2   should create a new rectangle, whose upper left corner is (x1,y1) and "
			+ "lower right corner is (x2,y2). Horizontal and vertical lines will be drawn "
			+ "using the 'x' character.";
	public static final String LINE_COMMAND_HELP = "Line command requires 4 parameters. {0} params were provided."
			+ "\n" + "For eg. L x1 y1 x2 y2  should create a new line from (x1,y1) to (x2,y2). Currently only "
			+ "horizontal or vertical lines are supported. Horizontal and vertical lines "
			+ "will be drawn using the 'x' character.";
	public static final String CANVAS_COMMAND_HELP = "Canvas command requires 2 parameters. {0} params were provided."
			+ "\n" + "For eg. C w h   should create a new canvas of width w and height h.";

	// Symbols used for drawing Objects
	public static final char HORIZONTAL_LINE_SYMBOL = '-';
	public static final char VERTICAL_LINE_SYMBOL = '|';
	public static final char LINE_SYMBOL = 'x';

}

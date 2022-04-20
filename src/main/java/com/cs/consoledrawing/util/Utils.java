package com.cs.consoledrawing.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.cs.consoledrawing.constants.CommandType;
import com.cs.consoledrawing.constants.Constants;
import com.cs.consoledrawing.exception.InvalidCommandException;
import com.cs.consoledrawing.model.Pixel;

/**
 * @author Lalit Arora
 */

public class Utils {

	public static boolean isvalidUserInput(String inputCommand) {
		if ((inputCommand != null && !inputCommand.trim().isEmpty())
				&& inputCommand.substring(0, 1).matches("^[a-zA-Z]*$")) {
			return true;
		} else {
			throw new InvalidCommandException(Constants.HELP_MESSAGE);
		}
	}

	public static List<String> extractCommandParameters(String inputCommand) {
		String[] params = inputCommand.split(" ");
		List<String> coordinates = new ArrayList<String>();
		for (int i = 1; i < params.length; i++) {
			coordinates.add(params[i]);
		}
		return coordinates;
	}

	public static int stringToInt(String number) {
		int num;
		try {
			num = Integer.parseInt(number);
		} catch (NumberFormatException e) {
			throw new InvalidCommandException(Constants.NON_POSITIVE_COORDINATES);
		}
		if (num <= 0) {
			throw new InvalidCommandException(Constants.NON_POSITIVE_COORDINATES);
		}
		return num;
	}

	public static boolean checkCanvasExists(char[][] canvas) {
		if (canvas != null)
			return true;
		throw new InvalidCommandException(Constants.NO_CANVAS_EXISTS);
	}

	// Decided not to overload this method with different coordinates
	public static boolean checkIfValidCoordinates(char canvas[][], CommandType commandType, int row1, int col1,
			int row2, int col2) {
		switch (commandType) {
		case LINE:
			if (row1 < 1 || row2 > canvas.length - 2 || col1 < 1 || col2 > canvas[0].length - 2 || row2 < 1
					|| row1 > canvas.length - 2 || col2 < 1 || col1 > canvas[0].length - 2) {
				throw new InvalidCommandException(Constants.COORDINATES_OUTSIDE_CANVAS);
			}
			if (row1 != row2 && col1 != col2) {
				throw new InvalidCommandException(Constants.DIAGONAL_LINE_DETECTED);
			}
			return true;
		case RECTANGLE:
			if (row1 < 1 || row2 > canvas.length - 2 || col1 < 1 || col2 > canvas[0].length - 2 || row2 < 1
					|| row1 > canvas.length - 2 || col2 < 1 || col1 > canvas[0].length - 2) {
				throw new InvalidCommandException(Constants.COORDINATES_OUTSIDE_CANVAS);
			}
			return true;
		case BUCKETFILL:
			if (col1 < 1 || col1 > canvas[0].length - 2 || row1 < 1 || row1 > canvas.length - 2) {
				throw new InvalidCommandException(Constants.COORDINATES_OUTSIDE_CANVAS);
			}
			return true;
		default:
			return false;
		}
	}

	public static void drawVerticalLine(char canvas[][], int col1, int row1, int col2, int row2, char symbol) {
		for (int i = row1; i <= row2; i++) {
			canvas[i][col1] = symbol;
		}
	}

	public static void fillColor(char canvas[][], int x, int y, char colorChar) {
		int height = canvas.length;
		int width = canvas[0].length;
		char originalChar = canvas[x][y];
		Stack<Pixel> stack = new Stack<>();
		stack.add(new Pixel(x, y));
		while (!stack.isEmpty()) {
			Pixel pop = stack.pop();
			if (canvas[pop.getX()][pop.getY()] == originalChar) {
				canvas[pop.getX()][pop.getY()] = colorChar;
			}
			if (pop.getX() - 1 > 0 && canvas[pop.getX() - 1][pop.getY()] == originalChar) {
				stack.add(new Pixel(pop.getX() - 1, pop.getY()));
			}
			if (pop.getX() + 1 <= height - 2 && canvas[pop.getX() + 1][pop.getY()] == originalChar) {
				stack.add(new Pixel(pop.getX() + 1, pop.getY()));
			}
			if (pop.getY() - 1 > 0 && canvas[pop.getX()][pop.getY() - 1] == originalChar) {
				stack.add(new Pixel(pop.getX(), pop.getY() - 1));
			}
			if (pop.getY() + 1 <= width - 2 && canvas[pop.getX()][pop.getY() + 1] == originalChar) {
				stack.add(new Pixel(pop.getX(), pop.getY() + 1));
			}
		}
	}

	public static void drawHorizontalLine(char[][] canvas, int col1, int row1, int col2, int row2, char symbol) {
		for (int i = col1; i <= col2; i++) {
			canvas[row1][i] = symbol;
		}
	}

	public static String paint(char[][] canvas) {
		StringBuilder canvasString = new StringBuilder();

		for (int row = 0; row < canvas.length; ++row) {
			for (int col = 0; col < canvas[row].length; col++) {
				canvasString.append(canvas[row][col]);
			}
			canvasString.append("\n");
		}
		return canvasString.toString();
	}

}

package com.cs.consoledrawing.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class TestUtils {

	public static char[][] readCanvasFromFile(String filepath) {
		Scanner sc = null;
		try {
			sc = new Scanner(new BufferedReader(new FileReader(filepath)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int rows = 6;
		int columns = 22;
		char[][] canvas = new char[rows][columns];
		while (sc.hasNextLine()) {
			for (int i = 0; i < canvas.length; i++) {
				char[] line = sc.nextLine().trim().toCharArray();
				for (int j = 0; j < line.length; j++) {
					canvas[i][j] = line[j];
				}
			}
		}
		return canvas;

	}

	public static char[][] readCanvasFromFile(int canvasHeight, int CanvasWidth, String filepath) {
		Scanner sc = null;
		try {
			sc = new Scanner(new BufferedReader(new FileReader(filepath)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int rows = canvasHeight;
		int columns = CanvasWidth;
		char[][] canvas = new char[rows][columns];
		while (sc.hasNextLine()) {
			for (int i = 0; i < canvas.length; i++) {
				char[] line = sc.nextLine().trim().toCharArray();
				for (int j = 0; j < line.length; j++) {
					canvas[i][j] = line[j];
				}
			}
		}
		return canvas;

	}

}

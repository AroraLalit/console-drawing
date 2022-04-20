package com.cs.consoledrawing.context;

import java.util.Scanner;

/**
 * @author Lalit Arora
 *
 */

public class ApplicationContext {

	private Scanner scanner;

	private char[][] canvas = null;

	public ApplicationContext() {
		super();
		this.scanner = new Scanner(System.in);
	}

	public Scanner getScanner() {
		return scanner;
	}

	public char[][] getCanvas() {
		return this.canvas;
	}

	public void setCanvas(char[][] canvas) {
		this.canvas = canvas;
	}

}

package com.cs.consoledrawing.constants;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * @author Lalit Arora
 *
 */

public class CommandTypeTest {

	@Test
	public void shouldReturnCanvasCommanndType() {
		assertEquals(CommandType.CANVAS, CommandType.getCommand("C"));
	}

	@Test
	public void shouldReturnLineCommanndType() {
		assertEquals(CommandType.LINE, CommandType.getCommand("L"));
	}

	@Test
	public void shouldReturnRectangleCommanndType() {
		assertEquals(CommandType.RECTANGLE, CommandType.getCommand("R"));
	}

	@Test
	public void shouldReturnBucketFillCommanndType() {
		assertEquals(CommandType.BUCKETFILL, CommandType.getCommand("B"));
	}

	@Test
	public void shouldReturnQuitCommanndType() {
		assertEquals(CommandType.QUIT, CommandType.getCommand("Q"));
	}

	@Test
	public void shouldReturnNull() {
		assertEquals(null, CommandType.getCommand("W"));
	}

}
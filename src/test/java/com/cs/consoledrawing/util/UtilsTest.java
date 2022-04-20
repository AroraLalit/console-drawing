package com.cs.consoledrawing.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cs.consoledrawing.constants.CommandType;
import com.cs.consoledrawing.exception.InvalidCommandException;

/**
 * @author Lalit Arora
 *
 */
public class UtilsTest {

    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldPassWithValidUserInput() {
        assertTrue(Utils.isvalidUserInput("C 20 4"));
    }

    @Test
    public void shouldThrowExceptionWithInvalidUserInput() {
        assertThrows(InvalidCommandException.class, () -> Utils.isvalidUserInput("20 4"));
    }

    @Test
    public void shouldThrowExceptionWithEmptyUserInput() {
        assertThrows(InvalidCommandException.class, () -> Utils.isvalidUserInput("      "));
    }

    @Test
    public void shouldExtractCorrectCommandParametersWithCorrectInput() {
        List<String> expectedParametrs = Arrays.asList(new String[]{"20", "5"});
        assertEquals(expectedParametrs, Utils.extractCommandParameters("C 20 5"));
    }

    @Test
    public void shouldNotExtractInCorrectCommandParametersWithIncorrectInput() {
        List<String> expectedParametrs = Arrays.asList(new String[]{"14", "2", "8", "3"});
        assertNotEquals(expectedParametrs, Utils.extractCommandParameters("R 14 1 18 3"));
    }

    @Test
    public void shouldPerformStringToIntCoversionWithCorrectInput() {
        int expected = 40;
        assertEquals(expected, Utils.stringToInt("40"));
    }

    @Test
    public void shouldThrowExceptionWhileStringToIntCoversionWithInCorrectInput() {
        assertThrows(InvalidCommandException.class, () -> Utils.stringToInt("20.4"));
    }

    @Test
    public void shouldThrowExceptionWhileStringToIntCoversionWithCorrectInput() {
        assertThrows(InvalidCommandException.class, () -> Utils.stringToInt("-2"));
    }

    @Test
    public void shouldThrowExceptionWhenCanvasDoesNotExists() {
        assertThrows(InvalidCommandException.class, () -> Utils.checkCanvasExists(null));
    }

    @Test
    public void shouldCheckIfCanvasExists() {
        char[][] canvas = new char[6][22];
        assertTrue(Utils.checkCanvasExists(canvas));
    }

    @Test
    public void ShouldBeValidCoordinatesForLineCommand() {
        char[][] canvas = new char[6][22];
        assertTrue(Utils.checkIfValidCoordinates(canvas, CommandType.LINE, 2, 4, 2, 12));
    }

    @Test
    public void ShouldBeValidCoordinatesForLineCommandWithReverseDirection() {
        char[][] canvas = new char[6][22];
        assertTrue(Utils.checkIfValidCoordinates(canvas, CommandType.LINE, 2, 12, 2, 4));
    }

    @Test
    public void ShouldBeInvalidCoordinatesForLineCommand() {
        char[][] canvas = new char[6][22];
        assertThrows(InvalidCommandException.class,
                () -> Utils.checkIfValidCoordinates(canvas, CommandType.LINE, 5, 4, 5, 14));
    }

    @Test
    public void ShouldBeInvalidCoordinatesForDiagonalLineCommand() {
        char[][] canvas = new char[6][22];
        assertThrows(InvalidCommandException.class,
                () -> Utils.checkIfValidCoordinates(canvas, CommandType.LINE, 1, 14, 3, 18));
    }

    @Test
    public void ShouldBeValidCoordinatesForRectangleCommand() {
        char[][] canvas = new char[6][22];
        assertTrue(Utils.checkIfValidCoordinates(canvas, CommandType.RECTANGLE, 1, 14, 3, 18));
    }

    @Test
    public void ShouldBeValidCoordinatesForRectangleCommandWithReverseDirection() {
        char[][] canvas = new char[6][22];
        assertTrue(Utils.checkIfValidCoordinates(canvas, CommandType.RECTANGLE, 3, 18, 1, 14));
    }

    @Test
    public void ShouldBeInvalidCoordinatesForRectangleCommand() {
        char[][] canvas = new char[6][22];
        assertThrows(InvalidCommandException.class,
                () -> Utils.checkIfValidCoordinates(canvas, CommandType.RECTANGLE, 1, 14, 5, 18));
    }

    @Test
    public void ShouldBeValidCoordinatesForBucketFillCommand() {
        char[][] canvas = new char[6][22];
        assertTrue(Utils.checkIfValidCoordinates(canvas, CommandType.BUCKETFILL, 1, 14, 0, 0));
    }

    @Test
    public void ShouldBeInvalidCoordinatesForBucketFillCommand() {
        char[][] canvas = new char[6][22];
        assertThrows(InvalidCommandException.class,
                () -> Utils.checkIfValidCoordinates(canvas, CommandType.BUCKETFILL, 1, 21, 0, 0));
    }

    @Test
    public void ShouldPaintTheCanvas() {
        
        char[][] canvas = TestUtils.readCanvasFromFile("src/test/resources/testInput/canvas.txt");

        String expected = "----------------------\n" +
                "|             xxxxx  |\n" +
                "|xxxxxx       x   x  |\n" +
                "|     x       xxxxx  |\n" +
                "|     x              |\n" +
                "----------------------\n";

        assertEquals(expected, Utils.paint(canvas));
    }
}

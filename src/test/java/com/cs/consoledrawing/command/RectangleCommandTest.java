package com.cs.consoledrawing.command;

import com.cs.consoledrawing.context.ApplicationContext;
import com.cs.consoledrawing.exception.InvalidCommandException;
import com.cs.consoledrawing.util.TestUtils;
import com.cs.consoledrawing.util.Utils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

/**
 * @author Lalit Arora
 */

@ExtendWith(MockitoExtension.class)
public class RectangleCommandTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void testWhenRectangleCommandExecuteIsCalledWithCorrectArguments() {
        RectangleCommand rectangleCommand = Mockito.mock(RectangleCommand.class);
        List<String> commandParameters = Arrays.asList(new String[]{"1", "1", "10", "3"});
        Mockito.doCallRealMethod().when(rectangleCommand).execute(Mockito.any(ApplicationContext.class),
                Mockito.anyList());
        char[][] canvas = TestUtils.readCanvasFromFile("src/test/resources/testInput/blankCanvas.txt");
        ApplicationContext context = new ApplicationContext();
        context.setCanvas(canvas);
        rectangleCommand.execute(context, commandParameters);
        Mockito.verify(rectangleCommand, Mockito.times(1)).execute(context, commandParameters);
        char expected[][] = TestUtils.readCanvasFromFile("src/test/resources/testOutput/testRectangleCmdCorrectArgs.txt");
        Assertions.assertEquals(Utils.paint(expected).trim(), outContent.toString().trim());
    }

    @Test
    public void testWhenRectangleCommandExecuteIsCalledWithDifferentArguments() {
        RectangleCommand rectangleCommand = Mockito.mock(RectangleCommand.class);
        List<String> commandParameters = Arrays.asList(new String[]{"18", "3", "14", "1"});
        Mockito.doCallRealMethod().when(rectangleCommand).execute(Mockito.any(ApplicationContext.class),
                Mockito.anyList());
        char[][] canvas = TestUtils.readCanvasFromFile("src/test/resources/testInput/blankCanvas.txt");
        ApplicationContext context = new ApplicationContext();
        context.setCanvas(canvas);
        rectangleCommand.execute(context, commandParameters);
        Mockito.verify(rectangleCommand, Mockito.times(1)).execute(context, commandParameters);
        char expected[][] = TestUtils.readCanvasFromFile("src/test/resources/testOutput/testRectangleCmdDifferentArgs.txt");
        Assertions.assertEquals(Utils.paint(expected).trim(), outContent.toString().trim());
    }

    @Test
    public void testWhenRectangleCommandExecuteIsCalledWithTopRightToBottomLeft() {
        RectangleCommand rectangleCommand = Mockito.mock(RectangleCommand.class);
        List<String> commandParameters = Arrays.asList(new String[]{"18", "1", "14", "3"});
        Mockito.doCallRealMethod().when(rectangleCommand).execute(Mockito.any(ApplicationContext.class),
                Mockito.anyList());
        char[][] canvas = TestUtils.readCanvasFromFile("src/test/resources/testInput/blankCanvas.txt");
        ApplicationContext context = new ApplicationContext();
        context.setCanvas(canvas);
        rectangleCommand.execute(context, commandParameters);
        Mockito.verify(rectangleCommand, Mockito.times(1)).execute(context, commandParameters);
        char expected[][] = TestUtils.readCanvasFromFile("src/test/resources/testOutput/testRectangleCmdTopRightToBottomLeft.txt");
        Assertions.assertEquals(Utils.paint(expected).trim(), outContent.toString().trim());
    }

    @Test
    public void testWhenRectangleCommandExecuteIsCalledWithBottomLeftToRightUpper() {
        RectangleCommand rectangleCommand = Mockito.mock(RectangleCommand.class);
        List<String> commandParameters = Arrays.asList(new String[]{"4", "3", "8", "1"});
        Mockito.doCallRealMethod().when(rectangleCommand).execute(Mockito.any(ApplicationContext.class),
                Mockito.anyList());
        char[][] canvas = TestUtils.readCanvasFromFile("src/test/resources/testInput/blankCanvas.txt");
        ApplicationContext context = new ApplicationContext();
        context.setCanvas(canvas);
        rectangleCommand.execute(context, commandParameters);
        Mockito.verify(rectangleCommand, Mockito.times(1)).execute(context, commandParameters);
        char expected[][] = TestUtils.readCanvasFromFile("src/test/resources/testOutput/testRectangleCmdBottomLeftToRightUpper.txt");
        Assertions.assertEquals(Utils.paint(expected).trim(), outContent.toString().trim());
    }

    @Test
    public void testWhenRectangleCommandExecuteIsCalledWithBottomRightToLeftUpper() {
        RectangleCommand rectangleCommand = Mockito.mock(RectangleCommand.class);
        List<String> commandParameters = Arrays.asList(new String[]{"9", "3", "3", "1"});
        Mockito.doCallRealMethod().when(rectangleCommand).execute(Mockito.any(ApplicationContext.class),
                Mockito.anyList());
        char[][] canvas = TestUtils.readCanvasFromFile("src/test/resources/testInput/blankCanvas.txt");
        ApplicationContext context = new ApplicationContext();
        context.setCanvas(canvas);
        rectangleCommand.execute(context, commandParameters);
        Mockito.verify(rectangleCommand, Mockito.times(1)).execute(context, commandParameters);
        char expected[][] = TestUtils.readCanvasFromFile("src/test/resources/testOutput/testRectangleCmdBottomRightToLeftUpper.txt");
        Assertions.assertEquals(Utils.paint(expected).trim(), outContent.toString().trim());
    }

    @Test
    public void testWhenRectangleCommandExecuteIsCalledWithIncorrectCommandParameters() {
        RectangleCommand rectangleCommand = Mockito.mock(RectangleCommand.class);
        List<String> commandParameters = Arrays.asList(new String[]{"9", "C", "3", "3"});
        char[][] canvas = TestUtils.readCanvasFromFile("src/test/resources/testInput/blankCanvas.txt");
        ApplicationContext context = new ApplicationContext();
        context.setCanvas(canvas);
        Mockito.doThrow(InvalidCommandException.class)
                .when(rectangleCommand)
                .execute(context, commandParameters);
        Assertions.assertThrows(InvalidCommandException.class, () -> rectangleCommand.execute(context, commandParameters));
    }

    @Test()
    public void testWhenRectangleCommandExecutedWithIncorrectCommandParameters() {
        RectangleCommand rectangleCommand = new RectangleCommand();
        ApplicationContext context = new ApplicationContext();
        char[][] canvas = TestUtils.readCanvasFromFile("src/test/resources/testInput/blankCanvas.txt");
        List<String> commandParameters = Arrays.asList(new String[]{"9", "3", "3"});
        context.setCanvas(canvas);
        Assertions.assertThrows(InvalidCommandException.class, () -> rectangleCommand.execute(context, commandParameters));
    }

}

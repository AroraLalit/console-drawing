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
public class LineCommandTest {

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
    public void testWhenLineCommandExecuteIsCalledWithCorrectArguments() {
        LineCommand lineCommand = Mockito.mock(LineCommand.class);
        List<String> commandParameters = Arrays.asList(new String[]{"6", "2", "18", "2"});
        Mockito.doCallRealMethod().when(lineCommand).execute(Mockito.any(ApplicationContext.class), Mockito.anyList());
        char[][] canvas = TestUtils.readCanvasFromFile("src/test/resources/testInput/blankCanvas.txt");
        ApplicationContext context = new ApplicationContext();
        context.setCanvas(canvas);
        lineCommand.execute(context, commandParameters);
        Mockito.verify(lineCommand, Mockito.times(1)).execute(context, commandParameters);
        char expected[][] = TestUtils.readCanvasFromFile("src/test/resources/testOutput/testLineCmdCorrectArgs.txt");
        Assertions.assertEquals(Utils.paint(expected).trim(), outContent.toString().trim());
    }

    @Test
    public void testWhenLineCommandExecuteIsCalledWithDifferentArguments() {
        LineCommand lineCommand = Mockito.mock(LineCommand.class);
        List<String> commandParameters = Arrays.asList(new String[]{"18", "2", "18", "4"});
        Mockito.doCallRealMethod().when(lineCommand).execute(Mockito.any(ApplicationContext.class), Mockito.anyList());
        char[][] canvas = TestUtils.readCanvasFromFile("src/test/resources/testInput/blankCanvas.txt");
        ApplicationContext context = new ApplicationContext();
        context.setCanvas(canvas);
        lineCommand.execute(context, commandParameters);
        Mockito.verify(lineCommand, Mockito.times(1)).execute(context, commandParameters);
        char expected[][] = TestUtils.readCanvasFromFile("src/test/resources/testOutput/testLineCmdDifferentArgs.txt");
        Assertions.assertEquals(Utils.paint(expected).trim(), outContent.toString().trim());
    }

    @Test
    public void testWhenLineCommandExecuteIsCalledWithReverseDirection() {
        LineCommand lineCommand = Mockito.mock(LineCommand.class);
        List<String> commandParameters = Arrays.asList(new String[]{"18", "3", "6", "3"});
        Mockito.doCallRealMethod().when(lineCommand).execute(Mockito.any(ApplicationContext.class), Mockito.anyList());
        char[][] canvas = TestUtils.readCanvasFromFile("src/test/resources/testInput/blankCanvas.txt");
        ApplicationContext context = new ApplicationContext();
        context.setCanvas(canvas);
        lineCommand.execute(context, commandParameters);
        Mockito.verify(lineCommand, Mockito.times(1)).execute(context, commandParameters);
        char expected[][] = TestUtils.readCanvasFromFile("src/test/resources/testOutput/testLineCmdReverseDirection.txt");
        Assertions.assertEquals(Utils.paint(expected).trim(), outContent.toString().trim());
    }

    @Test
    public void testWhenLineCommandExecuteIsCalledWithIncorrectCommandParameters() {
        LineCommand lineCommand = Mockito.mock(LineCommand.class);
        List<String> commandParameters = Arrays.asList(new String[]{"9", "3", "t", "5"});
        char[][] canvas = TestUtils.readCanvasFromFile("src/test/resources/testInput/blankCanvas.txt");
        ApplicationContext context = new ApplicationContext();
        context.setCanvas(canvas);
        Mockito.doThrow(InvalidCommandException.class)
                .when(lineCommand)
                .execute(context, commandParameters);
        Assertions.assertThrows(InvalidCommandException.class, () -> lineCommand.execute(context, commandParameters));
    }

    @Test()
    public void testWhenLineCommandExecutedWithIncorrectCommandParameters() {
        LineCommand lineCommand = new LineCommand();
        ApplicationContext context = new ApplicationContext();
        char[][] canvas = TestUtils.readCanvasFromFile("src/test/resources/testInput/blankCanvas.txt");
        List<String> commandParameters = Arrays.asList(new String[]{"9", "3", "5", "3", "5"});
        context.setCanvas(canvas);
        Assertions.assertThrows(InvalidCommandException.class, () -> lineCommand.execute(context, commandParameters));
    }

}

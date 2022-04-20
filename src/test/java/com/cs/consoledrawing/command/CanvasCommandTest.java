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
public class CanvasCommandTest {

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
    public void testWhenCanvasCommandExecuteIsCalledWithCorrectArguments() {
        CanvasCommand canvasCommand = Mockito.mock(CanvasCommand.class);
        List<String> commandParameters = Arrays.asList(new String[]{"20", "4"});
        Mockito.doCallRealMethod().when(canvasCommand).execute(Mockito.any(ApplicationContext.class),
                Mockito.anyList());
        ApplicationContext context = new ApplicationContext();
        canvasCommand.execute(context, commandParameters);
        Mockito.verify(canvasCommand, Mockito.times(1)).execute(context, commandParameters);
        char expected[][] = TestUtils.readCanvasFromFile("src/test/resources/testOutput/testCanvasCmdCorrectArgs.txt");
        Assertions.assertEquals(Utils.paint(expected).trim(), outContent.toString().trim());
    }

    @Test
    public void testWhenCanvasCommandExecuteIsCalledWithDifferentArguments() {
        CanvasCommand canvasCommand = Mockito.mock(CanvasCommand.class);
        List<String> commandParameters = Arrays.asList(new String[]{"50", "10"});
        Mockito.doCallRealMethod().when(canvasCommand).execute(Mockito.any(ApplicationContext.class),
                Mockito.anyList());
        ApplicationContext context = new ApplicationContext();
        canvasCommand.execute(context, commandParameters);
        Mockito.verify(canvasCommand, Mockito.times(1)).execute(context, commandParameters);
        char expected[][] = TestUtils.readCanvasFromFile(12, 52, "src/test/resources/testOutput/testCanvasCmdDifferentArgs.txt");
        Assertions.assertEquals(Utils.paint(expected).trim(), outContent.toString().trim());
    }

    @Test
    public void testWhenCanvasCommandExecuteIsCalledWithIncorrectCommandParameters() {
        CanvasCommand canvasCommand = Mockito.mock(CanvasCommand.class);
        List<String> commandParameters = Arrays.asList(new String[]{"20", "4", "5"});
        char[][] canvas = TestUtils.readCanvasFromFile("src/test/resources/testInput/blankCanvas.txt");
        ApplicationContext context = new ApplicationContext();
        context.setCanvas(canvas);
        Mockito.doThrow(InvalidCommandException.class)
                .when(canvasCommand)
                .execute(context, commandParameters);
        Assertions.assertThrows(InvalidCommandException.class, () -> canvasCommand.execute(context, commandParameters));
    }

    @Test()
    public void testWhenCanvasCommandExecutedWithIncorrectCommandParameters() {
        CanvasCommand canvasCommand = new CanvasCommand();
        ApplicationContext context = new ApplicationContext();
        char[][] canvas = TestUtils.readCanvasFromFile("src/test/resources/testInput/blankCanvas.txt");
        List<String> commandParameters = Arrays.asList(new String[]{"9", "C", "3", "3"});
        context.setCanvas(canvas);
        Assertions.assertThrows(InvalidCommandException.class, () -> canvasCommand.execute(context, commandParameters));
    }

}

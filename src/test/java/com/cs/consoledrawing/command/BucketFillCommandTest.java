package com.cs.consoledrawing.command;

import com.cs.consoledrawing.context.ApplicationContext;
import com.cs.consoledrawing.exception.InvalidCommandException;
import com.cs.consoledrawing.util.TestUtils;
import com.cs.consoledrawing.util.Utils;
import org.junit.jupiter.api.*;
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
public class BucketFillCommandTest {

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
    public void testWhenBucketFillExecuteIsCalledWithCorrectArguments() {
        BucketFillCommand bucketFillCommand = Mockito.mock(BucketFillCommand.class);
        List<String> commandParameters = Arrays.asList(new String[]{"1", "1", "o"});
        Mockito.doCallRealMethod().when(bucketFillCommand).execute(Mockito.any(ApplicationContext.class),
                Mockito.anyList());
        char[][] canvas = TestUtils.readCanvasFromFile("src/test/resources/testInput/canvas.txt");
        ApplicationContext context = new ApplicationContext();
        context.setCanvas(canvas);
        bucketFillCommand.execute(context, commandParameters);
        Mockito.verify(bucketFillCommand, Mockito.times(1)).execute(context, commandParameters);
        char expected[][] = TestUtils.readCanvasFromFile("src/test/resources/testOutput/testBucketFillCorrectArgs.txt");
        Assertions.assertEquals(Utils.paint(expected).trim(), outContent.toString().trim());
    }

    @Test
    public void testWhenBucketFillExecuteIsCalledWithDifferentArguments() {
        BucketFillCommand bucketFillCommand = Mockito.mock(BucketFillCommand.class);
        List<String> commandParameters = Arrays.asList(new String[]{"1", "3", "o"});
        Mockito.doCallRealMethod().when(bucketFillCommand).execute(Mockito.any(ApplicationContext.class),
                Mockito.anyList());
        char[][] canvas = TestUtils.readCanvasFromFile("src/test/resources/testInput/canvas.txt");
        ApplicationContext context = new ApplicationContext();
        context.setCanvas(canvas);
        bucketFillCommand.execute(context, commandParameters);
        Mockito.verify(bucketFillCommand, Mockito.times(1)).execute(context, commandParameters);
        char expected[][] = TestUtils.readCanvasFromFile("src/test/resources/testOutput/testBucketFillDifferentArgs.txt");
        Assertions.assertEquals(Utils.paint(expected).trim(), outContent.toString().trim());
    }

    @Test
    public void testWhenBucketFillCommandExecuteIsCalledWithIncorrectCommandParameters() {
        BucketFillCommand bucketFillCommand = Mockito.mock(BucketFillCommand.class);
        List<String> commandParameters = Arrays.asList(new String[]{"9", "3", "t", ""});
        char[][] canvas = TestUtils.readCanvasFromFile("src/test/resources/testInput/blankCanvas.txt");
        ApplicationContext context = new ApplicationContext();
        context.setCanvas(canvas);
        Mockito.doThrow(InvalidCommandException.class)
                .when(bucketFillCommand)
                .execute(context, commandParameters);
        Assertions.assertThrows(InvalidCommandException.class, () -> bucketFillCommand.execute(context, commandParameters));
    }

    @Test()
    public void testWhenBucketFillCommandExecutedWithIncorrectCommandParameters() {
        BucketFillCommand bucketFillCommand = new BucketFillCommand();
        ApplicationContext context = new ApplicationContext();
        char[][] canvas = TestUtils.readCanvasFromFile("src/test/resources/testInput/blankCanvas.txt");
        List<String> commandParameters = Arrays.asList(new String[]{"9", "C", "3", "3"});
        context.setCanvas(canvas);
        Assertions.assertThrows(InvalidCommandException.class, () -> bucketFillCommand.execute(context, commandParameters));
    }

}

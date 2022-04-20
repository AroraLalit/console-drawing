package com.cs.consoledrawing.command;

import com.cs.consoledrawing.constants.CommandType;
import com.cs.consoledrawing.exception.InvalidCommandException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author Lalit Arora
 */

public class CommandFactoryTest {

    @BeforeAll
    public static void setup() {
        CommandFactory.registerCommand(CommandType.CANVAS, new CanvasCommand());
        CommandFactory.registerCommand(CommandType.LINE, new LineCommand());
        CommandFactory.registerCommand(CommandType.RECTANGLE, new RectangleCommand());
        CommandFactory.registerCommand(CommandType.BUCKETFILL, new BucketFillCommand());
        CommandFactory.registerCommand(CommandType.QUIT, new QuitCommand());
    }

    @Test
    public void shouldReturnNewObjectOfCanvasCommand() {
        Command command = CommandFactory.getCommandInstance("C");
        Assertions.assertTrue(command instanceof CanvasCommand);
    }

    @Test
    public void shouldReturnNewObjectOfLineCommand() {
        Command command = CommandFactory.getCommandInstance("L");
        Assertions.assertTrue(command instanceof LineCommand);
    }

    @Test
    public void shouldReturnNewObjectOfRectangleCommand() {
        Command command = CommandFactory.getCommandInstance("R");
        Assertions.assertTrue(command instanceof RectangleCommand);
    }

    @Test
    public void shouldReturnNewObjectOfBucketFillCommand() {
        Command command = CommandFactory.getCommandInstance("B");
        Assertions.assertTrue(command instanceof BucketFillCommand);
    }

    @Test
    public void shouldReturnNewObjectOfQuitCommand() {
        Command command = CommandFactory.getCommandInstance("Q");
        Assertions.assertTrue(command instanceof QuitCommand);
    }

    @Test
    public void shouldThrowExceptionWithIncorrectCommandKey() {
        Assertions.assertThrows(InvalidCommandException.class, () -> CommandFactory.getCommandInstance("D"));
    }

    @Test
    public void shouldThrowExceptionWithIntegerCommandKey() {
        Assertions.assertThrows(InvalidCommandException.class, () -> CommandFactory.getCommandInstance("1"));
    }

}

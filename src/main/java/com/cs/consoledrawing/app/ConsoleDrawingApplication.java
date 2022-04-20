package com.cs.consoledrawing.app;

import java.util.List;

import com.cs.consoledrawing.command.BucketFillCommand;
import com.cs.consoledrawing.command.CanvasCommand;
import com.cs.consoledrawing.command.Command;
import com.cs.consoledrawing.command.CommandFactory;
import com.cs.consoledrawing.command.LineCommand;
import com.cs.consoledrawing.command.QuitCommand;
import com.cs.consoledrawing.command.RectangleCommand;
import com.cs.consoledrawing.constants.CommandType;
import com.cs.consoledrawing.constants.Constants;
import com.cs.consoledrawing.context.ApplicationContext;
import com.cs.consoledrawing.exception.InvalidCommandException;
import com.cs.consoledrawing.util.Utils;

/**
 * @author Lalit Arora
 */

public class ConsoleDrawingApplication {

    private ApplicationContext context;

    public ConsoleDrawingApplication(ApplicationContext context) {
        super();
        this.context = context;
    }

    public ApplicationContext getContext() {
        return context;
    }

    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    public static void main(String[] args) {

        /*
         * This should be called from init method of the particular command implementations to register themselves. once we use
         * framework like spring which calls init method to initialize bean
         */

        registerCommnads();

        /*
         * Injecting application context which holds char[][] canvas. This is
         * also needs to be done via autowiring of beans.
         */

        ConsoleDrawingApplication app = new ConsoleDrawingApplication(new ApplicationContext());

        System.out.println(Constants.INFORMATION_MESSAGE);

        while (true) {

            String userInput = app.getContext().getScanner().nextLine();
            try {
                userInput = userInput.trim();
                if (Utils.isvalidUserInput(userInput)) {
                    app.executeCommand(app.getContext(), userInput.substring(0, 1).toUpperCase(), Utils.extractCommandParameters(userInput));
                    System.out.println(Constants.NEXT_COMMAND_MESSAGE);
                }
            } catch (InvalidCommandException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    private void executeCommand(ApplicationContext context, String drawingCommand, List<String> commandParameters) {
        try {
            Command command = CommandFactory.getCommandInstance(drawingCommand);
            command.execute(context, commandParameters);
        } catch (InvalidCommandException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void registerCommnads() {
        CommandFactory.registerCommand(CommandType.CANVAS, new CanvasCommand());
        CommandFactory.registerCommand(CommandType.LINE, new LineCommand());
        CommandFactory.registerCommand(CommandType.RECTANGLE, new RectangleCommand());
        CommandFactory.registerCommand(CommandType.BUCKETFILL, new BucketFillCommand());
        CommandFactory.registerCommand(CommandType.QUIT, new QuitCommand());
    }

}

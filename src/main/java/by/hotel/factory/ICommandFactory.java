package by.hotel.factory;

import by.hotel.command.ICommand;

/**
 * ICommandFactory.java
 * Simple get command operation.
 * @author Igor Kozlov
 * @version 1.0
 */
public interface ICommandFactory {
    /**
     * Get a command by name.
     * @param commandName the operand to find an operation.
     * @return command that implements interface ICommand.
     */
    ICommand getCommand(String commandName);
}

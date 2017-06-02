package by.hotel.command;

import by.hotel.command.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

/**
 * ICommand.java
 * Interface class that has the following methods.
 * Execute - simple command operation.
 * @author Igor Kozlov
 * @version 1.0
 */
public interface ICommand {
    /**
     * Perform a command from request parameters.
     * @param request the operand to use for getting different values.
     * @return object which stores the result of the request
     * @throws CommandException if execute is failed
     */
    Object execute(HttpServletRequest request) throws CommandException;
}
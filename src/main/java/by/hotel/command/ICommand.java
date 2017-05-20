package by.hotel.command;

import by.hotel.command.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

/**
 * Simple command operation.
 * @author Igor Kozlov
 * @version 1.0
 */
public interface ICommand {
    /**
     * Perform a command from request parameters.
     * @param request the operand to use for getting difference values.
     * @return object which stores the result of the request
     * @throws CommandException
     */
    Object execute(HttpServletRequest request) throws CommandException;
}
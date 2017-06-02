package by.hotel.command.impl;

import by.hotel.bean.User;
import by.hotel.command.ICommand;
import by.hotel.command.exception.CommandException;
import by.hotel.security.MD5;
import by.hotel.service.IAuthService;
import by.hotel.service.exception.ServiceException;
import by.hotel.service.impl.AuthServiceImpl;

import javax.servlet.http.HttpServletRequest;

/**
 * Authorization.java
 * Class implements methods from interface ICommand.
 * Execute - simple command operation.
 * @author Igor Kozlov
 * @version 1.0
 */
public class Authorization implements ICommand {
    /**
     * Function for user authotization
     * @param request the operand to use for getting different values.
     * @return authorizationed user or null
     * @throws CommandException if authorization entity is failed
     */
    public Object execute(HttpServletRequest request) throws CommandException {
        try {
            User user;
            IAuthService service = new AuthServiceImpl();
            user = service.checkUser(request.getParameterMap().get("email")[0], MD5.crypt(request.getParameterMap().get("password")[0]));
            return user;
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}

package by.hotel.command.impl;

import by.hotel.bean.User;
import by.hotel.command.ICommand;
import by.hotel.command.exception.CommandException;
import by.hotel.security.MD5;
import by.hotel.service.IAuthService;
import by.hotel.service.exception.ServiceException;
import by.hotel.service.impl.AuthServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static by.hotel.command.impl.Registration.getRights;

/**
 * Authorization.java
 * Class implements methods from interface ICommand.
 * Execute - simple command operation.
 * @author Igor Kozlov
 * @version 1.0
 */
public class Authorization implements ICommand {
    /**
     * Function for user authorization
     * @param request the operand to use for getting values.
     * @return authorizated user
     * @throws CommandException if authorization user is failed
     */
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        try {
            User user;
            IAuthService service = new AuthServiceImpl();
            user = service.checkUser(request.getParameterMap().get("email")[0], MD5.crypt(request.getParameterMap().get("password")[0]));
            if (user != null){
                HttpSession session = request.getSession(true);
                Integer a = Integer.parseInt(getRights(user), 2);
                session.setAttribute("rights",a);
            }
            return user;
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }
}

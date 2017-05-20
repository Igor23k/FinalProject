package by.hotel.command.impl;

import by.hotel.bean.User;
import by.hotel.command.ICommand;
import by.hotel.command.exception.CommandException;
import by.hotel.service.ICrudService;
import by.hotel.service.IRegistrationService;
import by.hotel.service.exception.ServiceException;
import by.hotel.service.impl.RegistrationServiceImpl;
import by.hotel.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class Registration implements ICommand {
    public Object execute(HttpServletRequest request) throws CommandException {
        try {
            User user;
            IRegistrationService registrationService = new RegistrationServiceImpl();
            ICrudService userService = new UserServiceImpl();
            user = registrationService.registration((User)userService.buildEntity(request.getParameterMap()));
            return user;
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
    }

    public static String getRights(User user){
        StringBuilder rights = new StringBuilder();
        rights.append(user.getRole().getUpdate());
        rights.append(user.getRole().getDelete());
        rights.append(user.getRole().getInsert());
        rights.append(user.getRole().getCreate());
        rights.append(user.getRole().getSelect());
        rights.append(user.getRole().getDrop());
        rights.append(user.getRole().getGrant());
        return rights.toString();
    }
}

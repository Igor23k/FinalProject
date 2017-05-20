package by.hotel.command.impl;

import by.hotel.command.ICommand;
import by.hotel.command.exception.CommandException;
import by.hotel.service.ICrudService;
import by.hotel.service.CrudServiceMapper;
import by.hotel.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class AddEntity implements ICommand {
    public Object execute(HttpServletRequest request) throws CommandException {
        Object result;
        try {
            ICrudService service =  CrudServiceMapper.getService(request.getParameterMap().get("tableName")[0]);
            result = service.addEntity(service.buildEntity(request.getParameterMap()));
        }catch (ServiceException e){
            throw new CommandException(e);
        }
        return result;
    }
}

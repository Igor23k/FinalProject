package by.hotel.command.impl;

import by.hotel.command.ICommand;
import by.hotel.command.exception.CommandException;
import by.hotel.service.ICrudService;
import by.hotel.service.CrudServiceMapper;
import by.hotel.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class RemoveEntity implements ICommand {
    public Object execute(HttpServletRequest request) throws CommandException {
        String result = null;
        try {
            ICrudService service =  CrudServiceMapper.getService(request.getParameterMap().get("tableName")[0]);
            service.removeEntity(service.buildEntity(request.getParameterMap()));
        }catch (ServiceException e){
            throw new CommandException(e);
        }
        return result;
    }
}
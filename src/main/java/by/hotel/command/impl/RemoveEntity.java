package by.hotel.command.impl;

import by.hotel.command.ICommand;
import by.hotel.command.exception.CommandException;
import by.hotel.service.ICrudService;
import by.hotel.service.CrudServiceMapper;
import by.hotel.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * RemoveEntity.java
 * Class implements methods from interface ICommand.
 * Execute - simple command operation.
 * @author Igor Kozlov
 * @version 1.0
 */
public class RemoveEntity implements ICommand {
    /**
     * Function for remove entity
     * @param request the operand to use for getting values.
     * @return id removed entity
     * @throws CommandException if remove entity is failed
     */
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
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
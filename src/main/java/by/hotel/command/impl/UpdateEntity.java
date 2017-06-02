package by.hotel.command.impl;

import by.hotel.command.ICommand;
import by.hotel.command.exception.CommandException;
import by.hotel.service.ICrudService;
import by.hotel.service.CrudServiceMapper;
import by.hotel.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

/**
 * UpdateEntity.java
 * Class implements methods from interface ICommand.
 * Execute - simple command operation.
 * @author Igor Kozlov
 * @version 1.0
 */
public class UpdateEntity implements ICommand {
    /**
     * Function for update entity
     * @param request the operand to use for getting different values.
     * @return updated entity
     * @throws CommandException if update entity is failed
     */
    public Object execute(HttpServletRequest request) throws CommandException {
        try {
            ICrudService service =  CrudServiceMapper.getService(request.getParameterMap().get("tableName")[0]);
            service.updateEntity(service.buildEntity(request.getParameterMap()));
        }catch (ServiceException e){
            throw new CommandException(e);
        }
        return null;
    }
}

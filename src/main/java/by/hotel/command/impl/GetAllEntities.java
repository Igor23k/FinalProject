package by.hotel.command.impl;

import by.hotel.command.ICommand;
import by.hotel.command.exception.CommandException;
import by.hotel.service.ICrudService;
import by.hotel.service.CrudServiceMapper;
import by.hotel.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * GetAllEntities.java
 * Class implements methods from interface ICommand.
 * Execute - simple command operation.
 * @author Igor Kozlov
 * @version 1.0
 */
public class GetAllEntities implements ICommand {
    /**
     * Function for getting all entities
     * @param request the operand to use for getting different values.
     * @return all entities
     * @throws CommandException if get entities is failed
     */
    public Object execute(HttpServletRequest request) throws CommandException {
        List resultList;
        try {
            ICrudService service =  CrudServiceMapper.getService(request.getParameterMap().get("tableName")[0]);
            resultList = service.getAllEntities();
        }catch (ServiceException e){
            throw new CommandException(e);
        }
        return resultList;
    }
}

package by.hotel.command.impl;

import by.hotel.command.ICommand;
import by.hotel.command.exception.CommandException;
import by.hotel.service.ICrudService;
import by.hotel.service.ICrudServiceExtended;
import by.hotel.service.CrudServiceMapper;
import by.hotel.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * GetEntityHeaders.java
 * Class implements methods from interface ICommand.
 * Execute - simple command operation.
 * @author Igor Kozlov
 * @version 1.0
 */
public class GetEntityHeaders implements ICommand {
    /**
     * Function for getting entity headers
     * @param request the operand to use for getting different values.
     * @return entity headers
     * @throws CommandException  if get entity headers is failed
     */
    public Object execute(HttpServletRequest request) throws CommandException {
        Map<String,List<String>> resultMap = new LinkedHashMap<>();
        int tablesCount = request.getParameterMap().get("tableName").length;
        try {
            for (int i = 0; i < tablesCount; i++){
                ICrudService service =  CrudServiceMapper.getService(request.getParameterMap().get("tableName")[i]);
                resultMap.put(request.getParameterMap().get("tableName")[i], ((ICrudServiceExtended)service).getAllHeaders());
            }
        }catch (ServiceException e){
            throw new CommandException(e);
        }
        return resultMap;
    }
}

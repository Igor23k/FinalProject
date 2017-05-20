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

public class GetEntityHeaders implements ICommand {
    public Object execute(HttpServletRequest request) throws CommandException {
        Map<String,List<String>> resultMap = new LinkedHashMap<String, List<String>>();
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

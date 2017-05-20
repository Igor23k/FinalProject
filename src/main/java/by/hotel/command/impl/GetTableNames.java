package by.hotel.command.impl;

import by.hotel.command.ICommand;
import by.hotel.command.exception.CommandException;
import by.hotel.service.ITablesInfoService;
import by.hotel.service.exception.ServiceException;
import by.hotel.service.impl.TablesInfoServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GetTableNames implements ICommand {
    public Object execute(HttpServletRequest request) throws CommandException {
        List<String> resultList;
        try {
            ITablesInfoService service = new TablesInfoServiceImpl();
            resultList = service.getAllTablesNames();
        }catch (ServiceException e){
            throw new CommandException(e);
        }
        return resultList;
    }
}


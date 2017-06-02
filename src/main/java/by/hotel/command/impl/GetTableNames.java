package by.hotel.command.impl;

import by.hotel.command.ICommand;
import by.hotel.command.exception.CommandException;
import by.hotel.service.ITablesInfoService;
import by.hotel.service.exception.ServiceException;
import by.hotel.service.impl.TablesInfoServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * GetTableNames.java
 * Class implements methods from interface ICommand.
 * Execute - simple command operation.
 * @author Igor Kozlov
 * @version 1.0
 */
public class GetTableNames implements ICommand {
    /**
     * Function for getting table names
     * @param request the operand to use for getting different values.
     * @return table names
     * @throws CommandException if get table names is failed
     */
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


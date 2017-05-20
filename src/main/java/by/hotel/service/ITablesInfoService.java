package by.hotel.service;

import by.hotel.service.exception.ServiceException;

import java.util.List;

/**
 * Simple get information about tables.
 * @author Igor Kozlov
 * @version 1.0
 */
public interface ITablesInfoService {
    /**
     * Get all table names.
     * @return the list of table names.
     * @throws ServiceException
     */
    List<String> getAllTablesNames() throws ServiceException;
}

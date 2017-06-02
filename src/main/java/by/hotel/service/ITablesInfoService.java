package by.hotel.service;

import by.hotel.service.exception.ServiceException;

import java.util.List;

/**
 * ITablesInfoService.java
 * Simple get information about tables.
 * @author Igor Kozlov
 * @version 1.0
 */
public interface ITablesInfoService {
    /**
     * Get all table names.
     * @return the list of table names.
     * @throws ServiceException  if get info tables is failed
     */
    List<String> getAllTablesNames() throws ServiceException;
}

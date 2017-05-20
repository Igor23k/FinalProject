package by.hotel.service;

import by.hotel.service.exception.ServiceException;

import java.util.List;

/**
 * Simple get headers operation.
 * @author Igor Kozlov
 * @version 1.0
 */
public interface ICrudServiceExtended<T> extends ICrudService<T> {
    /**
     * Get all entity headers.
     * @return the list of entity headers.
     * @throws ServiceException
     */
    List<String> getAllHeaders() throws ServiceException;
}

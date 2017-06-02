package by.hotel.service;

import by.hotel.service.exception.ServiceException;

import java.util.List;

/**
 * ICrudServiceExtended.java
 * Simple get headers operation.
 * @author Igor Kozlov
 * @version 1.0
 */
public interface ICrudServiceExtended<T> extends ICrudService<T> {
    /**
     * Get all entity headers.
     * @return the list of entity headers.
     * @throws ServiceException if get entity headers is failed
     */
    List<String> getAllHeaders() throws ServiceException;
}

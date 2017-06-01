package by.hotel.service;

import by.hotel.service.exception.ServiceException;

import java.util.List;
import java.util.Map;

/**
 * Simple crud operations.
 * @author Igor Kozlov
 * @version 1.0
 */
public interface ICrudService<T> {
    /**
     * Get all entities.
     * @return the list of entities.
     * @throws ServiceException
     */
    List<T> getAllEntities() throws ServiceException;
    /**
     * Add entity.
     * @throws ServiceException
     */
    List<T> addEntity(T entity) throws ServiceException;
    /**
     * Remove entity.
     * @throws ServiceException
     */
    void removeEntity(T entity) throws ServiceException;
    /**
     * Update entity.
     * @throws ServiceException
     */
    void updateEntity(T entity) throws ServiceException;
    /**
     * Update entity.
     * @param params of entity for building.
     * @return the entity.
     * @throws ServiceException
     */
    T buildEntity(Map<String, String[]> params) throws ServiceException;
    /**
     * Get last inserted entity.
     * @return the entity.
     * @throws ServiceException
     */
    T getLastInsertedEntity() throws ServiceException;
}
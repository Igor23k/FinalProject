package by.hotel.service;

import by.hotel.service.exception.ServiceException;

import java.util.List;
import java.util.Map;

/**
 * ICrudService.java
 * Simple crud operations.
 * @author Igor Kozlov
 * @version 1.0
 */
public interface ICrudService<T> {
    /**
     * Get all entities.
     * @return the list of entities.
     * @throws ServiceException if get entities is failed
     */
    List<T> getAllEntities() throws ServiceException;
    /**
     * Add entity.
     * @param entity - the param to add.
     * @return the list of entities.
     * @throws ServiceException if add entity is failed
     */
    List<T> addEntity(T entity) throws ServiceException;
    /**
     * Remove entity.
     * @param entity - the param to remove.
     * @throws ServiceException if remove entity is failed
     */
    void removeEntity(T entity) throws ServiceException;
    /**
     * Update entity.
     * @param entity - the param to update.
     * @throws ServiceException if update entity is failed
     */
    void updateEntity(T entity) throws ServiceException;
    /**
     * Update entity.
     * @param params of entity for building.
     * @return the entity.
     * @throws ServiceException if build entity is failed
     */
    T buildEntity(Map<String, String[]> params) throws ServiceException;
    /**
     * Get last inserted entity.
     * @return the entity.
     * @throws ServiceException if get last inserted entity is failed
     */
    T getLastInsertedEntity() throws ServiceException;
}
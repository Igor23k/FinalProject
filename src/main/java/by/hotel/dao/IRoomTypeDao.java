package by.hotel.dao;

import by.hotel.bean.RoomType;
import by.hotel.dao.exception.DAOException;

import java.sql.Connection;
import java.util.List;

/**
 * IRoomTypeDao.java
 * Simple room type operation.
 * @author Igor Kozlov
 * @version 1.0
 */
public interface IRoomTypeDao {
    /**
     * Get room type headers.
     * @return the list of room type headers.
     * @throws DAOException if get room type headers is failed
     */
    List<String> getRoomTypeHeaders() throws DAOException;
    /**
     * Get room type.
     * @return the list of room types.
     * @throws DAOException if get room types is failed
     */
    List<RoomType> getRoomTypes() throws DAOException;
    /**
     * Add room type.
     * @param roomType the operand to have as a room type.
     * @throws DAOException if add room type is failed
     */
    void addRoomType(RoomType roomType) throws DAOException;
    /**
     * Remove  type.
     * @param roomType the operand to have as a room type.
     * @throws DAOException if remove room type is failed
     */
    void removeRoomType(RoomType roomType) throws DAOException;
    /**
     * Update room type.
     * @param roomType the operand to have as a room type.
     * @throws DAOException if update room type is failed
     */
    void updateRoomType(RoomType roomType) throws DAOException;
    /**
     * Get last inserted room type.
     * @return a last inserted room type.
     * @throws DAOException  if get last inserted room type is failed
     */
    RoomType getLastInsertedRoomType() throws DAOException;

}

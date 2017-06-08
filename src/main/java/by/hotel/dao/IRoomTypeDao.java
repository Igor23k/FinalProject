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
     * @param connection the operand to have a connection with DB.
     * @return the list of room type headers.
     * @throws DAOException if get room type headers is failed
     */
    List<String> getRoomTypeHeaders(Connection connection) throws DAOException;
    /**
     * Get room type.
     * @param connection the operand to have a connection with DB.
     * @return the list of room types.
     * @throws DAOException if get room types is failed
     */
    List<RoomType> getRoomTypes(Connection connection) throws DAOException;
    /**
     * Add room type.
     * @param connection the operand to have a connection with DB.
     * @param roomType the operand to have as a room type.
     * @throws DAOException if add room type is failed
     */
    void addRoomType(RoomType roomType, Connection connection) throws DAOException;
    /**
     * Remove  type.
     * @param connection the operand to have a connection with DB.
     * @param roomType the operand to have as a room type.
     * @throws DAOException if remove room type is failed
     */
    void removeRoomType(RoomType roomType, Connection connection) throws DAOException;
    /**
     * Update room type.
     * @param connection the operand to have a connection with DB.
     * @param roomType the operand to have as a room type.
     * @throws DAOException if update room type is failed
     */
    void updateRoomType(RoomType roomType, Connection connection) throws DAOException;
    /**
     * Get last inserted room type.
     * @param connection the operand to have a connection with DB.
     * @return a last inserted room type.
     * @throws DAOException  if get last inserted room type is failed
     */
    RoomType getLastInsertedRoomType(Connection connection) throws DAOException;

    /**
     * Get room type.
     * @param connection the operand to have a connection with DB.
     * @param idRoomType the operand to be as id of room type.
     * @return a room type.
     * @throws DAOException  if get room type is failed
     */
    RoomType getRoomType(Connection connection, int idRoomType) throws DAOException;

}

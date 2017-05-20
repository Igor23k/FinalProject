package by.hotel.dao;

import by.hotel.bean.RoomType;
import by.hotel.dao.exception.DAOException;

import java.sql.Connection;
import java.util.List;

/**
 * Simple room type operation.
 * @author Igor Kozlov
 * @version 1.0
 */
public interface IRoomTypeDao {
    /**
     * Get room type headers.
     * @param connection the operand to have a connection with DB.
     * @return the list of room type headers.
     * @throws DAOException
     */
    List<String> getRoomTypeHeaders(Connection connection) throws DAOException;
    /**
     * Get room type.
     * @param connection the operand to have a connection with DB.
     * @return the list of room types.
     * @throws DAOException
     */
    List<RoomType> getRoomTypes(Connection connection) throws DAOException;
    /**
     * Add room type.
     * @param roomType the operand to have as a room type.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException
     */
    void addRoomType(RoomType roomType, Connection connection) throws DAOException;
    /**
     * Remove  type.
     * @param roomType the operand to have as a room type.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException
     */
    void removeRoomType(RoomType roomType, Connection connection) throws DAOException;
    /**
     * Update room type.
     * @param roomType the operand to have as a room type.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException
     */
    void updateRoomType(RoomType roomType, Connection connection) throws DAOException;
    /**
     * Get last inserted room type.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException
     */
    RoomType getLastInsertedRoomType(Connection connection) throws DAOException;

}

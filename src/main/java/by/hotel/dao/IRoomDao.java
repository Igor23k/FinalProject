package by.hotel.dao;

import by.hotel.bean.Room;
import by.hotel.dao.exception.DAOException;

import java.sql.Connection;
import java.util.List;

/**
 * Simple room operation.
 * @author Igor Kozlov
 * @version 1.0
 */
public interface IRoomDao {
    /**
     * Get room headers.
     * @param connection the operand to have a connection with DB.
     * @return the list of room headers.
     * @throws DAOException
     */
    List<String> getRoomHeaders(Connection connection) throws DAOException;
    /**
     * Get room.
     * @param connection the operand to have a connection with DB.
     * @return the list of rooms.
     * @throws DAOException
     */
    List<Room> getRooms(Connection connection) throws DAOException;
    /**
     * Add room.
     * @param room the operand to have as a room.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException
     */
    void addRoom(Room room, Connection connection) throws DAOException;
    /**
     * Remove room.
     * @param room the operand to have as a room.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException
     */
    void removeRoom(Room room, Connection connection) throws DAOException;
    /**
     * Update room.
     * @param room the operand to have as a room.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException
     */
    void updateRoom(Room room, Connection connection) throws DAOException;
    /**
     * Get last inserted room.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException
     */
    Room getLastInsertedRoom(Connection connection) throws DAOException;

}

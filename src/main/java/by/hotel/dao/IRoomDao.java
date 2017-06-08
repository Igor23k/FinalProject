package by.hotel.dao;

import by.hotel.bean.Room;
import by.hotel.dao.exception.DAOException;

import java.sql.Connection;
import java.util.List;

/**
 * IRoomDao.java
 * Simple room operation.
 * @author Igor Kozlov
 * @version 1.0
 */
public interface IRoomDao {
    /**
     * Get room headers.
     * @param connection the operand to have a connection with DB.
     * @return the list of room headers.
     * @throws DAOException if get room headers is failed
     */
    List<String> getRoomHeaders(Connection connection) throws DAOException;
    /**
     * Get room.
     * @param connection the operand to have a connection with DB.
     * @return the list of rooms.
     * @throws DAOException if room rooms is failed
     */
    List<Room> getRooms(Connection connection) throws DAOException;
    /**
     * Add room.
     * @param connection the operand to have a connection with DB.
     * @param room the operand to have as a room.
     * @throws DAOException if add room is failed
     */
    void addRoom(Room room, Connection connection) throws DAOException;
    /**
     * Remove room.
     * @param connection the operand to have a connection with DB.
     * @param room the operand to have as a room.
     * @throws DAOException if remove room is failed
     */
    void removeRoom(Room room, Connection connection) throws DAOException;
    /**
     * Update room.
     * @param connection the operand to have a connection with DB.
     * @param room the operand to have as a room.
     * @throws DAOException if update room is failed
     */
    void updateRoom(Room room, Connection connection) throws DAOException;
    /**
     * Get last inserted room.
     * @param connection the operand to have a connection with DB.
     * @return a last inserted room.
     * @throws DAOException  if get last inserted room is failed
     */
    Room getLastInsertedRoom(Connection connection) throws DAOException;

    /**
     * Get room.
     * @param connection the operand to have a connection with DB.
     * @param idRoom the operand to be as id of room.
     * @return a room.
     * @throws DAOException  if get room is failed
     */
    Room getRoom(Connection connection, int idRoom) throws DAOException;

}

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
     * @return the list of room headers.
     * @throws DAOException if get room headers is failed
     */
    List<String> getRoomHeaders() throws DAOException;
    /**
     * Get room.
     * @return the list of rooms.
     * @throws DAOException if room rooms is failed
     */
    List<Room> getRooms() throws DAOException;
    /**
     * Add room.
     * @param room the operand to have as a room.
     * @throws DAOException if add room is failed
     */
    void addRoom(Room room) throws DAOException;
    /**
     * Remove room.
     * @param room the operand to have as a room.
     * @throws DAOException if remove room is failed
     */
    void removeRoom(Room room) throws DAOException;
    /**
     * Update room.
     * @param room the operand to have as a room.
     * @throws DAOException if update room is failed
     */
    void updateRoom(Room room) throws DAOException;
    /**
     * Get last inserted room.
     * @throws DAOException  if get last inserted room is failed
     */
    Room getLastInsertedRoom() throws DAOException;

}

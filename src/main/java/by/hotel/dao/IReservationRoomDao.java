package by.hotel.dao;

import by.hotel.bean.ReservationRoom;
import by.hotel.dao.exception.DAOException;

import java.sql.Connection;
import java.util.List;

/**
 * IReservationRoomDao.java
 * Simple reservation room operation.
 * @author Igor Kozlov
 * @version 1.0
 */
public interface IReservationRoomDao {
    /**
     * Get reservation room.
     * @return the list of reservation rooms.
     * @throws DAOException if get reservation rooms is failed
     */
    List<ReservationRoom> getReservationRooms() throws DAOException;
    /**
     * Add reservation room.
     * @param reservationRoom the operand to have as a reservation room.
     * @throws DAOException if add reservation room is failed
     */
    void addReservationRoom(ReservationRoom reservationRoom) throws DAOException;
    /**
     * Remove reservation room.
     * @param reservationRoom the operand to have as a reservation reservation room.
     * @throws DAOException if remove reservation room is failed
     */
    void removeReservationRoom(ReservationRoom reservationRoom) throws DAOException;
    /**
     * Update reservation room.
     * @param reservationRoom the operand to have as a reservation reservation room.
     * @throws DAOException if update reservation room is failed
     */
    void updateReservationRoom(ReservationRoom reservationRoom) throws DAOException;
    /**
     * Get last inserted reservation room.
     * @throws DAOException if get last inserted reservation room is failed
     */
    ReservationRoom getLastInsertedReservationRoom() throws DAOException;

    /**
     * Get reservation rooms by key.
     * @return the list of reservation rooms by key.
     * @throws DAOException if get reservation rooms is failed
     */
    List<ReservationRoom> getReservationRoomsByKey(Integer key) throws DAOException;
}


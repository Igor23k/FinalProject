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
     * Get reservation rooms.
     * @param connection the operand to have a connection with DB.
     * @return the list of reservation rooms.
     * @throws DAOException if get reservation rooms is failed
     */
    List<ReservationRoom> getReservationRooms(Connection connection) throws DAOException;

    /**
     * Get reservation rooms by user.
     * @param connection the operand to have a connection with DB.
     * @param userId the operand to be as id user.
     * @return the list of reservation rooms.
     * @throws DAOException if get reservation rooms is failed
     */
    List<ReservationRoom> getReservationRoomByUser(Connection connection, int userId) throws DAOException;

    /**
     * Get reservation room by reservation.
     * @param connection the operand to have a connection with DB.
     * @param reservationId the operand to be as id reservation.
     * @return the list of reservation rooms.
     * @throws DAOException if get reservation rooms is failed
     */
    List<ReservationRoom> getReservationRoomByReservation(Connection connection, int reservationId) throws DAOException;
    /**
     * Add reservation room.
     * @param connection the operand to have a connection with DB.
     * @param reservationRoom the operand to have as a reservation room.
     * @throws DAOException if add reservation room is failed
     */
    void addReservationRoom(ReservationRoom reservationRoom, Connection connection) throws DAOException;
    /**
     * Remove reservation room.
     * @param connection the operand to have a connection with DB.
     * @param reservationRoom the operand to have as a reservation reservation room.
     * @throws DAOException if remove reservation room is failed
     */
    void removeReservationRoom(ReservationRoom reservationRoom, Connection connection) throws DAOException;
    /**
     * Update reservation room.
     * @param connection the operand to have a connection with DB.
     * @param reservationRoom the operand to have as a reservation reservation room.
     * @throws DAOException if update reservation room is failed
     */
    void updateReservationRoom(ReservationRoom reservationRoom, Connection connection) throws DAOException;
    /**
     * Get last inserted reservation room.
     * @param connection the operand to have a connection with DB.
     * @return a last inserted reservation room.
     * @throws DAOException if get last inserted reservation room is failed
     */
    ReservationRoom getLastInsertedReservationRoom(Connection connection) throws DAOException;

    /**
     * Get reservation rooms by key.
     * @param connection the operand to have a connection with DB.
     * @param key the operand to get specific reservation room.
     * @return the list of reservation rooms by key.
     * @throws DAOException if get reservation rooms is failed
     */
    List<ReservationRoom> getReservationRoomsByKey(Integer key, Connection connection) throws DAOException;
}


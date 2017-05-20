package by.hotel.dao;

import by.hotel.bean.ReservationRoom;
import by.hotel.dao.exception.DAOException;

import java.sql.Connection;
import java.util.List;

/**
 * Simple reservation room operation.
 * @author Igor Kozlov
 * @version 1.0
 */
public interface IReservationRoomDao {
    /**
     * Get reservation room.
     * @param connection the operand to have a connection with DB.
     * @return the list of reservations parking spaces.
     * @throws DAOException
     */
    List<ReservationRoom> getReservationRooms(Connection connection) throws DAOException;
    /**
     * Add reservation room.
     * @param reservationRoom the operand to have as a reservation room.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException
     */
    void addReservationRoom(ReservationRoom reservationRoom, Connection connection) throws DAOException;
    /**
     * Remove reservation room.
     * @param reservationRoom the operand to have as a reservation reservation room.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException
     */
    void removeReservationRoom(ReservationRoom reservationRoom, Connection connection) throws DAOException;
    /**
     * Update reservation room.
     * @param reservationRoom the operand to have as a reservation reservation room.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException
     */
    void updateReservationRoom(ReservationRoom reservationRoom, Connection connection) throws DAOException;
    /**
     * Get last inserted reservation room.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException
     */
    ReservationRoom getLastInsertedReservationRoom(Connection connection) throws DAOException;

}

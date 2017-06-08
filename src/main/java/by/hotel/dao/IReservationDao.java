package by.hotel.dao;

import by.hotel.bean.Reservation;
import by.hotel.dao.exception.DAOException;

import java.sql.Connection;
import java.util.List;

/**
 * IReservationDao.java
 * Simple reservation operation.
 * @author Igor Kozlov
 * @version 1.0
 */
public interface IReservationDao {
    /**
     * Get reservation headers.
     * @param connection the operand to have a connection with DB.
     * @return the list of reservation headers.
     * @throws DAOException if get reservation headers is failed
     */
    List<String> getReservationHeaders(Connection connection) throws DAOException;

    /**
     * Get reservation .
     * @param connection the operand to have a connection with DB.
     * @param id the operand to be as id of reservation.
     * @return the list of reservation headers.
     * @throws DAOException if get reservation headers is failed
     */
    Reservation getReservation(Integer id, Connection connection) throws DAOException;
    /**
     * Get reservations.
     * @param connection the operand to have a connection with DB.
     * @return the list of reservations.
     * @throws DAOException if get reservations is failed
     */
    List<Reservation> getAllReservations(Connection connection) throws DAOException;
    /**
     * Add reservation.
     * @param connection the operand to have a connection with DB.
     * @param reservation the operand to have as a reservation.
     * @throws DAOException if add reservation is failed
     */
    void addReservation(Reservation reservation, Connection connection) throws DAOException;
    /**
     * Remove reservation.
     * @param connection the operand to have a connection with DB.
     * @param reservation the operand to have as a reservation.
     * @throws DAOException if remove reservation is failed
     */
    void removeReservation(Reservation reservation, Connection connection) throws DAOException;
    /**
     * Update reservation.
     * @param connection the operand to have a connection with DB.
     * @param reservation the operand to have as a reservation.
     * @throws DAOException if update reservation is failed
     */
    void updateReservation(Reservation reservation, Connection connection) throws DAOException;
    /**
     * Get last inserted reservation.
     * @param connection the operand to have a connection with DB.
     * @return a last inserted reservation.
     * @throws DAOException if get last inserted reservation is failed
     */
    Reservation getLastInsertedReservation(Connection connection) throws DAOException;

}

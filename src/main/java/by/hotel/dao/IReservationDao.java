package by.hotel.dao;

import by.hotel.bean.Reservation;
import by.hotel.dao.exception.DAOException;

import java.sql.Connection;
import java.util.List;

/**
 * Simple reservation operation.
 * @author Igor Kozlov
 * @version 1.0
 */
public interface IReservationDao {
    /**
     * Get headers of reservation.
     * @param connection the operand to have a connection with DB.
     * @return the list of reservation headers.
     * @throws DAOException
     */
    List<String> getReservationHeaders(Connection connection) throws DAOException;
    /**
     * Get parking spaces.
     * @param connection the operand to have a connection with DB.
     * @return the list of reservations.
     * @throws DAOException
     */
    List<Reservation> getAllReservations(Connection connection) throws DAOException;
    /**
     * Get parking spaces.
     * @param id the operand to use as id of reservation.
     * @param connection the operand to have a connection with DB.
     * @return the reservation.
     * @throws DAOException
     */
    Reservation getReservation(Integer id, Connection connection) throws DAOException;
    /**
     * Add parking space.
     * @param reservation the operand to have as a reservation.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException
     */
    void addReservation(Reservation reservation, Connection connection) throws DAOException;
    /**
     * Remove parking space.
     * @param reservation the operand to have as a reservation.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException
     */
    void removeReservation(Reservation reservation, Connection connection) throws DAOException;
    /**
     * Update parking space.
     * @param reservation the operand to have as a reservation.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException
     */
    void updateReservation(Reservation reservation, Connection connection) throws DAOException;
    /**
     * Get last inserted reservation.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException
     */
    Reservation getLastInsertedReservation(Connection connection) throws DAOException;

}

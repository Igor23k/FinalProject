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
     * @return the list of reservation headers.
     * @throws DAOException if get reservation headers is failed
     */
    List<String> getReservationHeaders() throws DAOException;
    /**
     * Get reservations.
     * @return the list of reservations.
     * @throws DAOException if get reservations is failed
     */
    List<Reservation> getAllReservations() throws DAOException;
    /**
     * Add reservation.
     * @param reservation the operand to have as a reservation.
     * @throws DAOException if add reservation is failed
     */
    void addReservation(Reservation reservation) throws DAOException;
    /**
     * Remove reservation.
     * @param reservation the operand to have as a reservation.
     * @throws DAOException if remove reservation is failed
     */
    void removeReservation(Reservation reservation) throws DAOException;
    /**
     * Update reservation.
     * @param reservation the operand to have as a reservation.
     * @throws DAOException if update reservation is failed
     */
    void updateReservation(Reservation reservation) throws DAOException;
    /**
     * Get last inserted reservation.
     * @throws DAOException if get last inserted reservation is failed
     */
    Reservation getLastInsertedReservation() throws DAOException;

}

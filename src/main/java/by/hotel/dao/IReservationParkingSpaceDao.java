package by.hotel.dao;

import by.hotel.bean.ReservationParkingSpace;
import by.hotel.dao.exception.DAOException;

import java.sql.Connection;
import java.util.List;

/**
 * Simple reservation parking space operation.
 * @author Igor Kozlov
 * @version 1.0
 */
public interface IReservationParkingSpaceDao {
    /**
     * Get reservation parking spaces.
     * @param connection the operand to have a connection with DB.
     * @return the list of reservations parking spaces.
     * @throws DAOException
     */
    List<ReservationParkingSpace> getReservationParkingSpaces(Connection connection) throws DAOException;
    /**
     * Add reservation parking space.
     * @param reservationParkingSpace the operand to have as a reservation parking space.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException
     */
    void addReservationParkingSpace(ReservationParkingSpace reservationParkingSpace, Connection connection) throws DAOException;
    /**
     * Remove reservation parking space.
     * @param reservationParkingSpace the operand to have as a reservation parking space.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException
     */
    void removeReservationParkingSpace(ReservationParkingSpace reservationParkingSpace, Connection connection) throws DAOException;
    /**
     * Update reservation parking space.
     * @param reservationParkingSpace the operand to have as a reservation parking space.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException
     */
    void updateReservationParkingSpace(ReservationParkingSpace reservationParkingSpace, Connection connection) throws DAOException;
    /**
     * Get last inserted reservation parking space.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException
     */
    ReservationParkingSpace getLastInsertedReservationParkingSpace(Connection connection) throws DAOException;

}

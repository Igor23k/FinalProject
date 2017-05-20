package by.hotel.dao;

import by.hotel.bean.ParkingSpace;
import by.hotel.dao.exception.DAOException;

import java.sql.Connection;
import java.util.List;

/**
 * Simple parking space operation.
 * @author Igor Kozlov
 * @version 1.0
 */
public interface IParkingSpaceDao {
    /**
     * Get headers of parking space.
     * @param connection the operand to have a connection with DB.
     * @return the list of parking space headers.
     * @throws DAOException
     */
    List<String> getParkingSpaceHeaders(Connection connection) throws DAOException;
    /**
     * Get parking spaces.
     * @param connection the operand to have a connection with DB.
     * @return the list of parking spaces.
     * @throws DAOException
     */
    List<ParkingSpace> getParkingSpaces(Connection connection) throws DAOException;
    /**
     * Add parking space.
     * @param reservation the operand to have as a reservation.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException
     */
    void addParkingSpace(ParkingSpace parkingSpace, Connection connection) throws DAOException;
    /**
     * Remove parking space.
     * @param parkingSpace the operand to have as a reservation.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException
     */
    void removeParkingSpace(ParkingSpace parkingSpace, Connection connection) throws DAOException;
    /**
     * Update parking space.
     * @param parkingSpace the operand to have as a reservation.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException
     */
    void updateParkingSpace(ParkingSpace parkingSpace, Connection connection) throws DAOException;
    /**
     * Get last inserted parking space.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException
     */
    ParkingSpace getLastInsertedParkingSpace(Connection connection) throws DAOException;
}

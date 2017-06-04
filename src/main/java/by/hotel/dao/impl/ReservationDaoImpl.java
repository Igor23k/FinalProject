package by.hotel.dao.impl;

import by.hotel.bean.Reservation;
import by.hotel.builder.DiscountBuilder;
import by.hotel.builder.ReservationBuilder;
import by.hotel.builder.UserBuilder;
import by.hotel.dao.AbstractDao;
import by.hotel.dao.IReservationDao;
import by.hotel.dao.connectionpool.ConnectionPool;
import by.hotel.dao.constants.Constants;
import by.hotel.dao.exception.ConnectionPoolException;
import by.hotel.dao.exception.DAOException;
import by.hotel.util.ErrorStringBuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static by.hotel.dao.constants.Constants.*;

/**
 * ReservationDaoImpl.java
 * Class implements methods from interface IReservationDao and extends from AbstractDao class.
 * getReservationHeaders - method for get reservation headers.
 * getReservations - method for get reservation.
 * updateReservation - method for update reservation.
 * addReservation - method for add reservation.
 * removeReservation - method for remove reservation.
 * getLastInsertedReservation - method for get last inserted reservation.
 * fillStatement - method for fill statement.
 * fillDiscount - method for fill reservation.
 * buildMessage - method for build error message.
 * @author Igor Kozlov
 * @version 1.0
 */
public class ReservationDaoImpl extends AbstractDao implements IReservationDao {

    private static ConnectionPool connectionPool = ConnectionPool.getInstance();

    /**
     * Get reservation headers.
     * @return the list of reservation headers.
     * @throws DAOException if get reservation headers is failed
     */
    public List<String> getReservationHeaders() throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<String> headers = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        Connection connection = null;
        try {
            connection = connectionPool.takeConnection();
            statement = connection.prepareStatement(GET_ALL_RESERVATIONS_HEADERS);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                stringBuilder.append(resultSet.getInt("id")+" ");
                stringBuilder.append(resultSet.getString("dateIn")+" ");
                stringBuilder.append(resultSet.getString("dateOut"));
                headers.add(stringBuilder.toString());
                stringBuilder.setLength(0);
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DAOException(e);
        } finally {
            connectionPool.closeConnection(connection, statement);
            closeStatement(statement, resultSet);
        }
        return headers;
    }

    /**
     * Get reservations.
     * @return the list of reservations.
     * @throws DAOException if get reservations is failed
     */
    public List<Reservation> getAllReservations() throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Reservation> reservations = new ArrayList<>();
        ReservationBuilder reservationBuilder = new ReservationBuilder();
        Connection connection = null;
        try {
            connection = connectionPool.takeConnection();
            statement = connection.prepareStatement(Constants.GET_ALL_RESERVATIONS);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                reservations.add(fillReservation(resultSet,reservationBuilder));
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DAOException(e);
        } finally {
            connectionPool.closeConnection(connection, statement);
            closeStatement(statement, resultSet);
        }
        return reservations;
    }

    /**
     * Add reservation.
     * @param reservation the operand to have as a reservation.
     * @throws DAOException if add reservation is failed
     */
    public void addReservation(Reservation reservation) throws DAOException {
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = connectionPool.takeConnection();
            statement = connection.prepareStatement(ADD_RESERVATION);
            statement = fillStatement(statement, reservation);
            statement.execute();
        } catch (SQLException | NullPointerException | ConnectionPoolException e) {
            throw new DAOException(e);
        } finally {
            connectionPool.closeConnection(connection, statement);
            closeStatement(statement, null);
        }
    }

    /**
     * Remove reservation.
     * @param reservation the operand to have as a reservation.
     * @throws DAOException if remove reservation is failed
     */
    public void removeReservation(Reservation reservation) throws DAOException {
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = connectionPool.takeConnection();
            statement = connection.prepareStatement(REMOVE_RESERVATION);
            statement.setInt(1, reservation.getId());
            statement.execute();
        }
        catch (SQLIntegrityConstraintViolationException e){
            throw new DAOException(buildMessage(reservation, e.getMessage()),e);
        } catch (SQLException | ConnectionPoolException e) {
            throw new DAOException(e);
        } finally {
            connectionPool.closeConnection(connection, statement);
            closeStatement(statement, null);
        }
    }

    /**
     * Update reservation.
     * @param reservation the operand to have as a reservation.
     * @throws DAOException if update reservation is failed
     */
    public void updateReservation(Reservation reservation) throws DAOException {
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = connectionPool.takeConnection();
            statement = connection.prepareStatement(UPDATE_RESERVATION);
            statement = fillStatement(statement, reservation);
            statement.setInt(6, reservation.getId());
            statement.execute();
        } catch (SQLException | ConnectionPoolException e) {
            throw new DAOException(e);
        } finally {
            connectionPool.closeConnection(connection, statement);
            closeStatement(statement, null);
        }
    }

    /**
     * Get last inserted reservation.
     * @throws DAOException if get last inserted reservation is failed
     */
    public Reservation getLastInsertedReservation() throws DAOException {
        PreparedStatement statement = null;
        Reservation reservation = null;
        ResultSet resultSet;
        ReservationBuilder reservationBuilder = new ReservationBuilder();
        DiscountBuilder discountBuilder = new DiscountBuilder();
        UserBuilder userBuilder = new UserBuilder();
        Connection connection = null;
        try {
            connection = connectionPool.takeConnection();
            statement = connection.prepareStatement(GET_LAST_INSERTED_RESERVATION);
            // statement.setString(1,"reservation");
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                reservation = reservationBuilder.id(resultSet.getInt("id"))
                        .dateIn(resultSet.getDate("dateIn"))
                        .dateOut(resultSet.getDate("dateOut"))
                        .accepted(resultSet.getInt("accepted"))
                        .user(userBuilder.id(resultSet.getInt("idUser")).build())
                        .discount(discountBuilder.id(resultSet.getInt("idDiscount")).build())
                        .build();
            }
        } catch (SQLException | NullPointerException | ConnectionPoolException e) {
            throw new DAOException(e);
        } finally {
            connectionPool.closeConnection(connection, statement);
            closeStatement(statement, null);
        }
        return reservation;
    }

    /**
     * Fill statement with data.
     * @param statement the operand to make a query.
     * @param reservation the operand to have as a reservation.
     * @return a PreparedStatement.
     * @throws SQLException if statement is null
     */
    private PreparedStatement fillStatement(PreparedStatement statement, Reservation reservation) throws SQLException {
        statement.setInt(1, reservation.getUser().getId());
        statement.setDate(2, reservation.getDateIn());
        statement.setDate(3, reservation.getDateOut());
        statement.setInt(4, reservation.getAccepted());
        statement.setInt(5,reservation.getDiscount().getId());
        return statement;
    }

    /**
     * Fill discount object with data.
     * @param resultSet the operand that contain data from BD.
     * @param reservationBuilder the operand to build a discount.
     * @return a Discount.
     * @throws SQLException
     */
    private Reservation fillReservation(ResultSet resultSet, ReservationBuilder reservationBuilder) throws SQLException {
        UserBuilder userBuilder = new UserBuilder();
        DiscountBuilder discountBuilder = new DiscountBuilder();
        return reservationBuilder.id(resultSet.getInt("id"))
                .dateIn(resultSet.getDate("dateIn"))
                .dateOut(resultSet.getDate("dateOut"))
                .user(userBuilder.id(resultSet.getInt("idUser"))
                        .passportNumber(resultSet.getString("passportNumber"))
                        .name(resultSet.getString("name"))
                        .surname(resultSet.getString("surname"))
                        .mobilePhone(resultSet.getString("mobilePhone"))
                        .build())
                .accepted(resultSet.getInt("accepted"))
                .discount(discountBuilder.id(resultSet.getInt("idDiscount"))
                        .name(resultSet.getString("discountName"))
                        .build())
                .build();
    }

    /**
     * Build error message.
     * @param reservation the operand to have as a discount.
     * @param errorMessage the operand that contain special error.
     * @return an error string.
     * @throws SQLException
     */
    private String buildMessage(Reservation reservation, String errorMessage){
        Map<String,String> idNames = new HashMap<String, String>();
        idNames.put("id",Integer.toString(reservation.getId()));
        return ErrorStringBuilder.buildDeleteErrorString(idNames,errorMessage);
    }
}

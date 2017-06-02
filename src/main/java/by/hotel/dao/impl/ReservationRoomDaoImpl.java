package by.hotel.dao.impl;

import by.hotel.bean.*;
import by.hotel.builder.*;
import by.hotel.dao.AbstractDao;
import by.hotel.dao.IReservationRoomDao;
import by.hotel.dao.exception.DAOException;
import by.hotel.util.ErrorStringBuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static by.hotel.dao.constants.Constants.*;

/**
 * ReservationRoomDaoImpl.java
 * Class implements methods from interface IReservationRoomDao and extends from AbstractDao class.
 * getReservationRoomHeaders - method for get reservation room headers.
 * getReservationRooms - method for get reservation room.
 * updateReservationRoom - method for update reservation room.
 * addReservationRoom - method for add reservation room.
 * removeReservationRoom - method for remove reservation room.
 * getLastInsertedReservationRoom - method for get last inserted reservation room.
 * fillStatement - method for fill statement.
 * fillReservationRoom - method for fill reservation room.
 * buildMessage - method for build error message.
 * @author Igor Kozlov
 * @version 1.0
 */
public class ReservationRoomDaoImpl extends AbstractDao implements IReservationRoomDao {
    /**
     * Get reservationRooms.
     * @param connection the operand to have a connection with DB.
     * @return the list of reservationRooms.
     * @throws DAOException if get reservation rooms is failed
     */
    public List<ReservationRoom> getReservationRooms(Connection connection) throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<ReservationRoom> reservationRooms = new ArrayList<>();
        ReservationRoomBuilder reservationRoomBuilder = new ReservationRoomBuilder();
        try {
            statement = connection.prepareStatement(GET_ALL_RESERVATION_ROOMS);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                reservationRooms.add(fillReservationRoom(resultSet,reservationRoomBuilder));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, resultSet);
        }
        return reservationRooms;
    }

    /**
     * Add reservationRoom.
     * @param reservationRoom the operand to have as a reservationRoom.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException if add reservation room is failed
     */
    public void addReservationRoom(ReservationRoom reservationRoom,Connection connection) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(ADD_RESERVATION_ROOM);
            statement = fillStatement(statement, reservationRoom);
            statement.execute();
        }catch (SQLIntegrityConstraintViolationException e){
            throw new DAOException(buildMessage(reservationRoom),e);
        } catch (SQLException | NullPointerException e) {
            throw new DAOException(buildMessage(reservationRoom),e);
        }finally {
            closeStatement(statement, null);
        }
    }

    /**
     * Remove reservationRoom.
     * @param reservationRoom the operand to have as a reservationRoom.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException if remove reservation room is failed
     */
    public void removeReservationRoom(ReservationRoom reservationRoom,Connection connection) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(REMOVE_RESERVATION_ROOM);
            statement = fillStatement(statement, reservationRoom);
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, null);
        }
    }

    /**
     * Update reservationRoom.
     * @param reservationRoom the operand to have as a reservationRoom.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException if update reservation room is failed
     */
    public void updateReservationRoom(ReservationRoom reservationRoom,Connection connection) throws DAOException {
        throw new UnsupportedOperationException("Unsupported operation!");
    }

    /**
     * Get last inserted reservationRoom.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException if get last inserted reservation room is failed
     */
    public ReservationRoom getLastInsertedReservationRoom(Connection connection) throws DAOException {
        PreparedStatement statement = null;
        ReservationRoom reservationRoom = null;
        ResultSet resultSet;
        ReservationRoomBuilder reservationRoomBuilder = new ReservationRoomBuilder();
        try {
            statement = connection.prepareStatement(GET_LAST_INSERTED_RESERVATION_ROOM);
            // statement.setString(1,"reservation_room");
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                reservationRoom = fillReservationRoom(resultSet, reservationRoomBuilder);
            }
        } catch (SQLException | NullPointerException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, null);
        }
        return reservationRoom;
    }

    /**
     * Fill discount object with data.
     * @param resultSet the operand that contain data from BD.
     * @param reservationRoomBuilder the operand to build a discount.
     * @return a Discount.
     * @throws SQLException if statement is null
     */
    private ReservationRoom fillReservationRoom(ResultSet resultSet, ReservationRoomBuilder reservationRoomBuilder) throws SQLException {
        RoomBuilder roomBuilder = new RoomBuilder();
        UserBuilder userBuilder = new UserBuilder();
        RoomTypeBuilder roomTypeBuilder  = new RoomTypeBuilder();
        DiscountBuilder discountBuilder = new DiscountBuilder();
        ReservationBuilder reservationBuilder = new ReservationBuilder();
        Reservation reservation = reservationBuilder.id(resultSet.getInt("idReservation"))
                .dateIn(resultSet.getDate("dateIn"))
                .dateOut(resultSet.getDate("dateOut"))
                .user(userBuilder.id(resultSet.getInt("idUser"))
                        .passportNumber(resultSet.getString("passportNumber"))
                        .name(resultSet.getString("name"))
                        .surname(resultSet.getString("surname"))
                        .mobilePhone(resultSet.getString("mobilePhone"))
                        .build())
                .costAdditionalServices(resultSet.getInt("costAdditionalServices"))
                .discount(discountBuilder.id(resultSet.getInt("idDiscount"))
                        .name(resultSet.getString("discountName"))
                        .build())
                .build();
        Room room = roomBuilder.id(resultSet.getInt("idRoom"))
                .roomType(roomTypeBuilder.id(resultSet.getInt("idRoomType"))
                        .roomsCount(resultSet.getInt("roomsCount"))
                        .bedsCount(resultSet.getInt("bedsCount"))
                        .costPerDay(resultSet.getInt("costPerDay"))
                        .additionalInfo(resultSet.getString("additionalInfo"))
                        .build())
                .floor(resultSet.getInt("floor"))
                .phone(resultSet.getString("phone"))
                .build();

        return reservationRoomBuilder.reservation(reservation)
                .room(room)
                .build();
    }

    /**
     * Fill statement with data.
     * @param statement the operand to make a query.
     * @param reservationRoom the operand to have as a reservationRoom.
     * @return a PreparedStatement.
     * @throws SQLException
     */
    private PreparedStatement fillStatement(PreparedStatement statement, ReservationRoom reservationRoom) throws SQLException {
        statement.setInt(1, reservationRoom.getRoom().getId());
        statement.setInt(2, reservationRoom.getReservation().getId());

        return statement;
    }

    /**
     * Build error message.
     * @param reservationRoom the operand to have as a discount.
     * @return an error string.
     * @throws SQLException
     */
    private String buildMessage(ReservationRoom reservationRoom){
        Map<String,String> idNames = new HashMap<>();
        idNames.put("reservation",Integer.toString(reservationRoom.getReservation().getId()));
        idNames.put("room",Integer.toString(reservationRoom.getRoom().getId()));
        return ErrorStringBuilder.buildAddErrorString(idNames);
    }

}

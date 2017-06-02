package by.hotel.dao.impl;

import by.hotel.bean.Room;
import by.hotel.builder.RoomBuilder;
import by.hotel.builder.RoomTypeBuilder;
import by.hotel.dao.AbstractDao;
import by.hotel.dao.IRoomDao;
import by.hotel.dao.exception.DAOException;
import by.hotel.util.ErrorStringBuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static by.hotel.dao.constants.Constants.*;

/**
 * RoomDaoImpl.java
 * Class implements methods from interface IRoomDao and extends from AbstractDao class.
 * getRoomHeaders - method for get room headers.
 * getRooms - method for get room.
 * updateRoom - method for update room.
 * addRoom - method for add room.
 * removeRoom - method for remove room.
 * getLastInsertedRoom - method for get last inserted room.
 * fillStatement - method for fill statement.
 * fillRoom - method for fill room.
 * buildMessage - method for build error message.
 * @author Igor Kozlov
 * @version 1.0
 */
public class RoomDaoImpl extends AbstractDao implements IRoomDao {
    /**
     * Get room headers.
     * @param connection the operand to have a connection with DB.
     * @return the list of room headers.
     * @throws DAOException if get room headers is failed
     */
    public List<String> getRoomHeaders(Connection connection) throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<String> headers = new ArrayList<String>();
        StringBuilder stringBuilder = new StringBuilder();
        try {
            statement = connection.prepareStatement(GET_ALL_ROOMS_HEADERS);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                stringBuilder.append(resultSet.getInt("id")+" ");
                stringBuilder.append(resultSet.getString("name"));
                headers.add(stringBuilder.toString());
                stringBuilder.setLength(0);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, resultSet);
        }
        return headers;
    }

    /**
     * Get rooms.
     * @param connection the operand to have a connection with DB.
     * @return the list of rooms.
     * @throws DAOException if room rooms is failed
     */
    public List<Room> getRooms(Connection connection) throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Room> rooms = new ArrayList<>();
        RoomBuilder roomBuilder = new RoomBuilder();
        try {
            statement = connection.prepareStatement(GET_ALL_ROOMS);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                rooms.add(fillRoom(resultSet,roomBuilder));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, resultSet);
        }
        return rooms;
    }

    /**
     * Add room.
     * @param room the operand to have as a room.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException if add room is failed
     */
    public void addRoom(Room room,Connection connection) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(ADD_ROOM);
            statement = fillStatement(statement, room);
            statement.execute();
        } catch (SQLException | NullPointerException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, null);
        }
    }

    /**
     * Remove room.
     * @param room the operand to have as a room.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException if remove room is failed
     */
    public void removeRoom(Room room,Connection connection) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(REMOVE_ROOM);
            statement.setInt(1, room.getId());
            statement.execute();
        }catch (SQLIntegrityConstraintViolationException e){
            throw new DAOException(buildMessage(room, e.getMessage()) ,e);
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, null);
        }
    }

    /**
     * Update room.
     * @param room the operand to have as a room.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException if update room is failed
     */
    public void updateRoom(Room room,Connection connection) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(UPDATE_ROOM);
            statement = fillStatement(statement, room);
            statement.setInt(6, room.getId());
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, null);
        }
    }

    /**
     * Get last inserted room.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException  if get last inserted room is failed
     */
    public Room getLastInsertedRoom(Connection connection) throws DAOException {
        PreparedStatement statement = null;
        Room room = null;
        ResultSet resultSet;
        RoomBuilder roomBuilder = new RoomBuilder();
        RoomTypeBuilder roomTypeBuilder  = new RoomTypeBuilder();
        try {
            statement = connection.prepareStatement(GET_LAST_INSERTED_ROOM);
            // statement.setString(1,room");
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                room = roomBuilder.id(resultSet.getInt("id"))
                        .roomType(roomTypeBuilder.id(resultSet.getInt("idRoomType"))
                                .additionalInfo(resultSet.getString("additionalInfo"))
                                .build())
                        .floor(resultSet.getInt("floor"))
                        .phone(resultSet.getString("phone"))
                        .name(resultSet.getString("name"))
                        .build();
            }
        } catch (SQLException | NullPointerException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, null);
        }
        return room;
    }

    /**
     * Fill discount object with data.
     * @param resultSet the operand that contain data from BD.
     * @param roomBuilder the operand to build a discount.
     * @return a Discount.
     * @throws SQLException if statement is null
     */
    private Room fillRoom(ResultSet resultSet, RoomBuilder roomBuilder) throws SQLException {
        RoomTypeBuilder roomTypeBuilder  = new RoomTypeBuilder();
        return roomBuilder.id(resultSet.getInt("id"))
                .roomType(roomTypeBuilder.id(resultSet.getInt("idRoomType"))
                        .roomsCount(resultSet.getInt("roomsCount"))
                        .bedsCount(resultSet.getInt("bedsCount"))
                        .costPerDay(resultSet.getInt("costPerDay"))
                        .additionalInfo(resultSet.getString("additionalInfo"))
                        .bathroomsCount(resultSet.getInt("bathroomsCount"))
                        .size(resultSet.getInt("size")).build())
                .floor(resultSet.getInt("floor"))
                .phone(resultSet.getString("phone"))
                .name(resultSet.getString("name"))
                .path(resultSet.getString("path"))
                .build();
    }

    /**
     * Fill statement with data.
     * @param statement the operand to make a query.
     * @param room the operand to have as a room.
     * @return a PreparedStatement.
     * @throws SQLException
     */
    private PreparedStatement fillStatement(PreparedStatement statement, Room room) throws SQLException {
        statement.setInt(1, room.getRoomType().getId());
        statement.setString(2, room.getName());
        statement.setInt(3, room.getFloor());
        statement.setString(4, room.getPhone());
        statement.setString(5, room.getPath());
        return statement;
    }


    private String buildMessage(Room room, String errorMessage){
        Map<String,String> idNames = new HashMap<String, String>();
        idNames.put("id",Integer.toString(room.getId()));
        return ErrorStringBuilder.buildDeleteErrorString(idNames,errorMessage);
    }
}
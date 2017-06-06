package by.hotel.dao.impl;

import by.hotel.bean.RoomType;
import by.hotel.builder.RoomTypeBuilder;
import by.hotel.dao.AbstractDao;
import by.hotel.dao.IRoomTypeDao;
import by.hotel.dao.connectionpool.ConnectionPool;
import by.hotel.dao.exception.ConnectionPoolException;
import by.hotel.dao.exception.DAOException;
import by.hotel.util.ErrorStringBuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static by.hotel.dao.constant.Constants.*;

/**
 * RoomTypeDaoImpl.java
 * Class implements methods from interface IRoomTypeDao and extends AbstractDao class.
 * getRoomTypeHeaders - method for get room type headers.
 * getRoomTypes - method for get room type.
 * updateRoomType - method for update room type.
 * addRoomType - method for add room type.
 * removeRoomType - method for remove room type.
 * getLastInsertedRoomType - method for get last inserted room type.
 * fillStatement - method for fill statement.
 * fillRoomType - method for fill room type.
 * buildMessage - method for build error message.
 * @author Igor Kozlov
 * @version 1.0
 */
public class RoomTypeDaoImpl extends AbstractDao implements IRoomTypeDao {

    private static ConnectionPool connectionPool = ConnectionPool.getInstance();

    /**
     * Get room type headers.
     * @return the list of roomType headers.
     * @throws DAOException if get room type headers is failed
     */
    public List<String> getRoomTypeHeaders() throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<String> headers = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        Connection connection = null;
        try {
            connection = connectionPool.takeConnection();
            statement = connection.prepareStatement(GET_ALL_ROOM_TYPES_HEADERS);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                stringBuilder.append(resultSet.getInt("id")+" rooms count: ");
                stringBuilder.append(resultSet.getString("roomsCount"));
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
     * Get roomTypes.
     * @return the list of roomTypes.
     * @throws DAOException if get room types is failed
     */
    public List<RoomType> getRoomTypes() throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<RoomType> roomTypes = new ArrayList<>();
        RoomTypeBuilder roomTypeBuilder  = new RoomTypeBuilder();
        Connection connection = null;
        try {
            connection = connectionPool.takeConnection();
            statement = connection.prepareStatement(GET_ALL_ROOM_TYPES);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                 roomTypes.add(fillRoomType(resultSet,roomTypeBuilder));
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DAOException(e);
        } finally {
            connectionPool.closeConnection(connection, statement);
            closeStatement(statement, resultSet);
        }
        return roomTypes;
    }

    /**
     * Add discount.
     * @param roomType the operand to have as a roomType.
     * @throws DAOException if add room type is failed
     */
    public void addRoomType(RoomType roomType) throws DAOException {
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = connectionPool.takeConnection();
            statement = connection.prepareStatement(ADD_ROOM_TYPE);
            statement = fillStatement(statement, roomType);
            statement.execute();
        } catch (SQLException | NullPointerException | ConnectionPoolException e) {
            throw new DAOException(e);
        } finally {
            connectionPool.closeConnection(connection, statement);
            closeStatement(statement, null);
        }
    }

    /**
     * Remove roomType.
     * @param roomType the operand to have as a roomType.
     * @throws DAOException if remove room type is failed
     */
    public void removeRoomType(RoomType roomType) throws DAOException {
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = connectionPool.takeConnection();
            statement = connection.prepareStatement(REMOVE_ROOM_TYPE);
            statement.setInt(1, roomType.getId());
            statement.execute();
        }catch (SQLIntegrityConstraintViolationException e){
            throw new DAOException(buildMessage(roomType, e.getMessage()) ,e);
        } catch (SQLException | ConnectionPoolException e) {
            throw new DAOException(e);
        } finally {
            connectionPool.closeConnection(connection, statement);
            closeStatement(statement, null);
        }
    }

    /**
     * Update roomType.
     * @param roomType the operand to have as a roomType.
     * @throws DAOException if update room type is failed
     */
    public void updateRoomType(RoomType roomType) throws DAOException {
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = connectionPool.takeConnection();
            statement = connection.prepareStatement(UPDATE_ROOM_TYPE);
            statement = fillStatement(statement, roomType);
            statement.setInt(7, roomType.getId());
            statement.execute();
        } catch (SQLException | ConnectionPoolException e) {
            throw new DAOException(e);
        } finally {
            connectionPool.closeConnection(connection, statement);
            closeStatement(statement, null);
        }
    }

    /**
     * Get last inserted room type.
     * @throws DAOException  if get last inserted room type is failed
     */
    public RoomType getLastInsertedRoomType() throws DAOException {
        PreparedStatement statement = null;
        RoomType roomType = null;
        ResultSet resultSet;
        RoomTypeBuilder roomTypeBuilder = new RoomTypeBuilder();
        Connection connection = null;
        try {
            connection = connectionPool.takeConnection();
            statement = connection.prepareStatement(GET_LAST_INSERTED_ROOM_TYPE);
            // statement.setString(1,room_type");
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                roomType = fillRoomType(resultSet, roomTypeBuilder);
            }
        } catch (SQLException | NullPointerException | ConnectionPoolException e) {
            throw new DAOException(e);
        } finally {
            connectionPool.closeConnection(connection, statement);
            closeStatement(statement, null);
        }
        return roomType;
    }

    /**
     * Fill discount object with data.
     * @param resultSet the operand that contain data from BD.
     * @param roomTypeBuilder the operand to build a discount.
     * @return a Discount.
     * @throws SQLException if statement is null
     */
    private RoomType fillRoomType(ResultSet resultSet, RoomTypeBuilder roomTypeBuilder) throws SQLException {
        return roomTypeBuilder.id(resultSet.getInt("id"))
                .roomsCount(resultSet.getInt("roomsCount"))
                .bedsCount(resultSet.getInt("bedsCount"))
                .costPerDay(resultSet.getInt("costPerDay"))
                .additionalInfo(resultSet.getString("additionalInfo"))
                .bathroomsCount(resultSet.getInt("bathroomsCount"))
                .size(resultSet.getInt("size"))
                .build();
    }

    /**
     * Fill statement with data.
     * @param statement the operand to make a query.
     * @param roomType the operand to have as a roomType.
     * @return a PreparedStatement.
     * @throws SQLException
     */
    private PreparedStatement fillStatement(PreparedStatement statement, RoomType roomType) throws SQLException {
        statement.setInt(1, roomType.getRoomsCount());
        statement.setInt(2, roomType.getBedsCount());
        statement.setFloat(3, roomType.getCostPerDay());
        statement.setString(4, roomType.getAdditionalInfo());
        statement.setInt(5, roomType.getBathroomsCount());
        statement.setInt(6, roomType.getSize());
        return statement;
    }

    /**
     * Build error message.
     * @param roomType the operand to have as a discount.
     * @param errorMessage the operand that contain special error.
     * @return an error string.
     * @throws SQLException
     */
    private String buildMessage(RoomType roomType, String errorMessage){
        Map<String,String> idNames = new HashMap<String, String>();
        idNames.put("id",Integer.toString(roomType.getId()));
        return ErrorStringBuilder.buildDeleteErrorString(idNames,errorMessage);
    }
}

package by.hotel.service.impl;

import by.hotel.bean.Room;
import by.hotel.builder.RoomBuilder;
import by.hotel.builder.RoomTypeBuilder;
import by.hotel.dao.IRoomDao;
import by.hotel.dao.exception.ConnectionPoolException;
import by.hotel.dao.exception.DAOException;
import by.hotel.dao.impl.RoomDaoImpl;
import by.hotel.service.AbstractService;
import by.hotel.service.ICrudServiceExtended;
import by.hotel.service.exception.IncorrectRoomNameException;
import by.hotel.service.exception.IncorrectRoomPhoneNumberException;
import by.hotel.service.exception.ServiceException;
import by.hotel.service.validator.ValidatorRoom;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * RoomDaoImpl.java
 * Class implements methods from interface ICrudServiceExtended and extends from AbstractService class.
 * getRoomHeaders - method to get room headers.
 * getRooms - method to get room.
 * updateRoom - method to update room.
 * addRoom - method to add room.
 * removeRoom - method to remove room.
 * getLastInsertedRoom - method to get last inserted room.
 * buildRoom - method to build room.
 * @author Igor Kozlov
 * @version 1.0
 */
public class RoomServiceImpl extends AbstractService implements ICrudServiceExtended<Room> {
    /**
     * Field - roomDao
     */
    private IRoomDao roomDao = new RoomDaoImpl();

    /**
     * Get room headers.
     * @return the list of room headers.
     * @throws ServiceException  if get room headers is failed
     */
    public List<String> getAllHeaders() throws ServiceException {
        try {
            connection = connectionPool.takeConnection();
            return roomDao.getRoomHeaders(connection);
        } catch (DAOException | ConnectionPoolException e) {
            throw new ServiceException(e);
        }finally {
            connectionPool.closeConnection(connection);
        }
    }

    /**
     * Get entity.
     * @param id the operand to get entity.
     * @return  room.
     * @throws ServiceException if get  room is failed
     */
    public Room getEntity(int id) throws ServiceException {
        Connection connection = null;
        Room room;
        try {
            connection = connectionPool.takeConnection();
            room = roomDao.getRoom(connection, id);
        } catch (DAOException | ConnectionPoolException e) {
            throw new ServiceException(e);
        } finally {
            connectionPool.closeConnection(connection);
        }
        return room;
    }

    /**
     * Get rooms.
     * @return the list of rooms.
     * @throws ServiceException if get rooms is failed
     */
    public List<Room> getAllEntities() throws ServiceException {
        try {
            connection = connectionPool.takeConnection();
            return roomDao.getRooms(connection);
        } catch (DAOException | ConnectionPoolException e) {
            throw new ServiceException(e);
        }finally {
            connectionPool.closeConnection(connection);
        }
    }

    /**
     * Add room.
     * @param room the operand to have as a room.
     * @throws ServiceException if add room is failed
     */
    public List<Room> addEntity(Room room) throws ServiceException {
        List<Room> rooms;
        try {
            connection = connectionPool.takeConnection();
            roomDao.addRoom(room, connection);
            rooms = roomDao.getRooms(connection);
        } catch (DAOException | ConnectionPoolException e) {
            throw new ServiceException(e);
        }finally {
            connectionPool.closeConnection(connection);
        }
        return rooms;
    }

    /**
     * Remove room.
     * @param room the operand to have as a room.
     * @throws ServiceException if remove room is failed
     */
    public void removeEntity(Room room) throws ServiceException {
        try {
            connection = connectionPool.takeConnection();
            roomDao.removeRoom(room, connection);
        } catch (DAOException | ConnectionPoolException e) {
            throw new ServiceException(e);
        }finally {
            connectionPool.closeConnection(connection);
        }
    }

    /**
     * Update room.
     * @param room the operand to have as a room.
     * @throws ServiceException if update room is failed
     */
    public void updateEntity(Room room) throws ServiceException {
        try {
            connection = connectionPool.takeConnection();
            roomDao.updateRoom(room, connection);
        } catch (DAOException | ConnectionPoolException e) {
            throw new ServiceException(e);
        }finally {
            connectionPool.closeConnection(connection);
        }
    }

    /**
     * This method build entity by received params.
     * @param params the operand that stored data to build room.
     * @return a room.
     * @throws ServiceException if build room is failed
     */
    public Room buildEntity(Map<String, String[]> params) throws ServiceException {
        ValidatorRoom validatorRoom = new ValidatorRoom();
        try {
            if (validatorRoom.validate(params)) {
                return new RoomBuilder().id(Integer.parseInt(params.get("id")[0]))
                        .roomType(new RoomTypeBuilder().id(Integer.parseInt(params.get("idRoomType")[0]))
                                .build())
                        .name(params.get("name")[0])
                        .floor(Integer.parseInt(params.get("floor")[0]))
                        .phone(params.get("phone")[0])
                        .path(params.get("path")[0])
                        .build();
            }
        }catch (IncorrectRoomPhoneNumberException | IncorrectRoomNameException e) {
            throw new ServiceException(e);
        }
        return null;
    }

    /**
     * Get last inserted room.
     * @throws ServiceException if get last inserted room is failed
     */
    public Room getLastInsertedEntity() throws ServiceException {
        try {
            connection = connectionPool.takeConnection();
            return roomDao.getLastInsertedRoom(connection);
        } catch (DAOException  | ConnectionPoolException e) {
            throw new ServiceException(e);
        }finally {
            connectionPool.closeConnection(connection);
        }
    }

    /**
     * Get all entities by key.
     * @param key the operand to get entities.
     * @return a list of rooms.
     * @throws ServiceException if get rooms is failed
     */
    @Override
    public List<Room> getAllEntitiesByKey(Integer key) throws ServiceException {
        throw new UnsupportedOperationException();
    }
}
package by.hotel.service.impl;

import by.hotel.bean.ReservationRoom;
import by.hotel.builder.ReservationBuilder;
import by.hotel.builder.ReservationRoomBuilder;
import by.hotel.builder.RoomBuilder;
import by.hotel.dao.IReservationRoomDao;
import by.hotel.dao.exception.ConnectionPoolException;
import by.hotel.dao.exception.DAOException;
import by.hotel.dao.impl.ReservationRoomDaoImpl;
import by.hotel.service.AbstractService;
import by.hotel.service.ICrudServiceExtended;
import by.hotel.service.exception.ServiceException;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * ReservationRoomDaoImpl.java
 * Class implements methods from interface IReservationRoomDao and extends from AbstractDao class.
 * getReservationRoomHeaders - method for get reservation room headers.
 * getReservationRooms - method for get reservation room.
 * updateReservationRoom - method for update reservation room.
 * addReservationRoom - method for add reservation room.
 * removeReservationRoom - method for remove reservation room.
 * getLastInsertedReservationRoom - method for get last inserted reservation room.
 * buildReservationRoom - method to build reservation room.
 * @author Igor Kozlov
 * @version 1.0
 */
public class ReservationRoomServiceImpl extends AbstractService implements ICrudServiceExtended<ReservationRoom> {
    /**
     * Field - reservationRoomDao
     */
    IReservationRoomDao reservationRoomDao = new ReservationRoomDaoImpl();

    /**
     * Get reservationRooms.
     * @return the list of reservationRooms.
     * @throws ServiceException  if get reservation room is failed
     */
    public List<ReservationRoom> getAllEntities() throws ServiceException {
        try {
            connection = connectionPool.takeConnection();
            return reservationRoomDao.getReservationRooms(connection);
        }catch (DAOException | ConnectionPoolException e){
            throw new ServiceException(e);
        }finally {
            connectionPool.closeConnection(connection);
        }
    }

    /**
     * Get reservationRooms.
     * @return the list of reservationRooms by user.
     * @throws ServiceException  if get room reservations  is failed
     */
    @Override
    public List<ReservationRoom> getAllEntitiesByKey(Integer key) throws ServiceException {
        try {
            connection = connectionPool.takeConnection();
            return reservationRoomDao.getReservationRoomsByKey(key, connection);
        }catch (DAOException | ConnectionPoolException e){
            throw new ServiceException(e);
        }finally {
            connectionPool.closeConnection(connection);
        }
    }

    /**
     * Add reservationRoom.
     * @param reservationRoom the operand to have as a reservationRoom.
     * @throws ServiceException if add reservation room is failed
     */
    public List<ReservationRoom> addEntity(ReservationRoom reservationRoom) throws ServiceException {
        List<ReservationRoom> reservationRooms;
        try {
            connection = connectionPool.takeConnection();
            reservationRoomDao.addReservationRoom(reservationRoom, connection);
            reservationRooms = reservationRoomDao.getReservationRooms(connection);
        }catch (DAOException | ConnectionPoolException e){
            throw new ServiceException(e);
        }finally {
            connectionPool.closeConnection(connection);
        }
        return reservationRooms;
    }

    /**
     * Remove reservationRoom.
     * @param reservationRoom the operand to have as a reservationRoom.
     * @throws ServiceException if remove reservation room is failed
     */
    public void removeEntity(ReservationRoom reservationRoom) throws ServiceException {
        try {
            connection = connectionPool.takeConnection();
            reservationRoomDao.removeReservationRoom(reservationRoom, connection);
        }catch (DAOException | ConnectionPoolException e){
            throw new ServiceException(e);
        }finally {
            connectionPool.closeConnection(connection);
        }
    }

    /**
     * Update reservationRoom.
     * @param reservationRoom the operand to have as a reservationRoom.
     * @throws ServiceException if update reservation room is failed
     */
    public void updateEntity(ReservationRoom reservationRoom) throws ServiceException {
        try {
            connection = connectionPool.takeConnection();
            reservationRoomDao.updateReservationRoom(reservationRoom, connection);
        }catch (DAOException | ConnectionPoolException e){
            throw new ServiceException(e);
        }finally {
            connectionPool.closeConnection(connection);
        }
    }

    /**
     * Get all entities by user.
     * @param idUser the operand to get entities.
     * @return a list of reservation rooms.
     * @throws ServiceException if get reservation rooms is failed
     */
    public List<ReservationRoom> getReservationRoomByUser(int idUser) throws ServiceException{
        List<ReservationRoom> reservationRooms;
        Connection connection = null;
        try {
            connection = connectionPool.takeConnection();
            reservationRooms = reservationRoomDao.getReservationRoomByUser(connection, idUser);
        }catch (DAOException | ConnectionPoolException e){
            throw new ServiceException(e);
        }finally {
            connectionPool.closeConnection(connection);        }
        return reservationRooms;
    }

    /**
     * Get all entities by reservation.
     * @param idReservation the operand to get entities.
     * @return a list of reservation rooms.
     * @throws ServiceException if get reservation rooms is failed
     */
    public List<ReservationRoom> getReservationRoomByReservation(int idReservation) throws ServiceException{
        List<ReservationRoom> reservationRooms;
        Connection connection = null;
        try {
            connection = connectionPool.takeConnection();
            reservationRooms = reservationRoomDao.getReservationRoomByReservation(connection, idReservation);
        }catch (DAOException | ConnectionPoolException e){
            throw new ServiceException(e);
        }finally {
            connectionPool.closeConnection(connection);
        }
        return reservationRooms;
    }

    /**
     * This method build entity by received params.
     * @param params the operand that stored data to build reservation room.
     * @return a reservation room.
     * @throws ServiceException if build reservation room is failed
     */
    public ReservationRoom buildEntity(Map<String, String[]> params) throws ServiceException {
        return new ReservationRoomBuilder()
                .reservation(new ReservationBuilder().id(Integer.parseInt(params.get("idReservation")[0])).build())
                .room(new RoomBuilder().id(Integer.parseInt(params.get("idRoom")[0])).build())
                .build();
    }

    /**
     * Get last inserted reservationRoom.
     * @throws ServiceException if get last inserted reservation room is failed
     */
    public ReservationRoom getLastInsertedEntity() throws ServiceException {
        try {
            connection = connectionPool.takeConnection();
            return reservationRoomDao.getLastInsertedReservationRoom(connection);
        }catch (DAOException | ConnectionPoolException e){
            throw new ServiceException(e);
        }finally {
            connectionPool.closeConnection(connection);
        }
    }

    @Override
    public List<String> getAllHeaders() throws ServiceException {
        return null;
    }
}

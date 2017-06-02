package by.hotel.service.impl;

import by.hotel.bean.ReservationRoom;
import by.hotel.builder.ReservationBuilder;
import by.hotel.builder.ReservationRoomBuilder;
import by.hotel.builder.RoomBuilder;
import by.hotel.dao.IReservationRoomDao;
import by.hotel.dao.impl.ReservationRoomDaoImpl;
import by.hotel.dao.exception.DAOException;
import by.hotel.service.AbstractService;
import by.hotel.service.ICrudService;
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
public class ReservationRoomServiceImpl extends AbstractService implements ICrudService<ReservationRoom> {
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
        Connection connection = null;
        try {
            connection = getConnection();
            return reservationRoomDao.getReservationRooms(connection);
        }catch (DAOException e){
            throw new ServiceException(e);
        }finally {
            closeConnection(connection);
        }
    }

    /**
     * Add reservationRoom.
     * @param reservationRoom the operand to have as a reservationRoom.
     * @throws ServiceException if add reservation room is failed
     */
    public List<ReservationRoom> addEntity(ReservationRoom reservationRoom) throws ServiceException {
        List<ReservationRoom> reservationRooms;
        Connection connection = null;
        try {
            connection = getConnection();
            reservationRoomDao.addReservationRoom(reservationRoom,connection);
            reservationRooms = reservationRoomDao.getReservationRooms(connection);
        }catch (DAOException e){
            throw new ServiceException(e);
        }finally {
            closeConnection(connection);
        }
        return reservationRooms;
    }

    /**
     * Remove reservationRoom.
     * @param reservationRoom the operand to have as a reservationRoom.
     * @throws ServiceException if remove reservation room is failed
     */
    public void removeEntity(ReservationRoom reservationRoom) throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            reservationRoomDao.removeReservationRoom(reservationRoom,connection);
        }catch (DAOException e){
            throw new ServiceException(e);
        }finally {
            closeConnection(connection);
        }
    }

    /**
     * Update reservationRoom.
     * @param reservationRoom the operand to have as a reservationRoom.
     * @throws ServiceException if update reservation room is failed
     */
    public void updateEntity(ReservationRoom reservationRoom) throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            reservationRoomDao.updateReservationRoom(reservationRoom,connection);
        }catch (DAOException e){
            throw new ServiceException(e);
        }finally {
            closeConnection(connection);
        }
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
        Connection connection = null;
        try {
            connection = getConnection();
            return reservationRoomDao.getLastInsertedReservationRoom(connection);
        }catch (DAOException e){
            throw new ServiceException(e);
        }finally {
            closeConnection(connection);
        }
    }

}

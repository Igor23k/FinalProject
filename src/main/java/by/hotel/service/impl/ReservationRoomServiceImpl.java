package by.hotel.service.impl;

import by.hotel.bean.ReservationRoom;
import by.hotel.builder.ReservationBuilder;
import by.hotel.builder.ReservationRoomBuilder;
import by.hotel.builder.RoomBuilder;
import by.hotel.dao.IReservationRoomDao;
import by.hotel.dao.exception.DAOException;
import by.hotel.dao.impl.ReservationRoomDaoImpl;
import by.hotel.service.AbstractService;
import by.hotel.service.ICrudServiceExtended;
import by.hotel.service.exception.ServiceException;

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
            return reservationRoomDao.getReservationRooms();
        }catch (DAOException e){
            throw new ServiceException(e);
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
            return reservationRoomDao.getReservationRoomsByKey(key);
        }catch (DAOException e){
            throw new ServiceException(e);
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
            reservationRoomDao.addReservationRoom(reservationRoom);
            reservationRooms = reservationRoomDao.getReservationRooms();
        }catch (DAOException e){
            throw new ServiceException(e);
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
            reservationRoomDao.removeReservationRoom(reservationRoom);
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    /**
     * Update reservationRoom.
     * @param reservationRoom the operand to have as a reservationRoom.
     * @throws ServiceException if update reservation room is failed
     */
    public void updateEntity(ReservationRoom reservationRoom) throws ServiceException {
        try {
            reservationRoomDao.updateReservationRoom(reservationRoom);
        }catch (DAOException e){
            throw new ServiceException(e);
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
        try {
            return reservationRoomDao.getLastInsertedReservationRoom();
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public List<String> getAllHeaders() throws ServiceException {
        return null;
    }
}

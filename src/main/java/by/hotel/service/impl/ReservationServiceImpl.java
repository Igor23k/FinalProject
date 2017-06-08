package by.hotel.service.impl;

import by.hotel.bean.Reservation;
import by.hotel.bean.ReservationRoom;
import by.hotel.builder.DiscountBuilder;
import by.hotel.builder.ReservationBuilder;
import by.hotel.builder.UserBuilder;
import by.hotel.dao.IReservationDao;
import by.hotel.dao.IReservationRoomDao;
import by.hotel.dao.connectionpool.ConnectionPool;
import by.hotel.dao.exception.ConnectionPoolException;
import by.hotel.dao.exception.DAOException;
import by.hotel.dao.impl.ReservationDaoImpl;
import by.hotel.dao.impl.ReservationRoomDaoImpl;
import by.hotel.service.AbstractService;
import by.hotel.service.ICrudServiceExtended;
import by.hotel.service.exception.IncorrectAcceptedException;
import by.hotel.service.exception.IncorrectDateException;
import by.hotel.service.exception.ServiceException;
import by.hotel.service.validator.ValidatorReservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ReservationServiceImpl.java
 * Class implements methods from interface ICrudServiceExtended and extends from AbstractService class.
 * getReservationHeaders - method to get reservation headers.
 * getReservations - method to get reservation.
 * updateReservation - method to update reservation.
 * addReservation - method to add reservation.
 * removeReservation - method to remove reservation.
 * buildReservation - method to build reservation.
 * @author Igor Kozlov
 * @version 1.0
 */
public class ReservationServiceImpl extends AbstractService implements ICrudServiceExtended<Reservation> {
    private static ConnectionPool connectionPool = ConnectionPool.getInstance();
    Connection connection;
    /**
     * Field - reservationDao
     */
    IReservationDao reservationDao = new ReservationDaoImpl();
    IReservationRoomDao reservationRoomDao = new ReservationRoomDaoImpl();
    Map<String, String[]> params = new HashMap<>();
    Integer idRoom;

    /**
     * Get reservation headers.
     * @return the list of reservation headers.
     * @throws ServiceException  if get reservation headers is failed
     */
    public List<String> getAllHeaders() throws ServiceException {
        try {
            connection = connectionPool.takeConnection();
            return reservationDao.getReservationHeaders(connection);
        } catch (DAOException | ConnectionPoolException e) {
            throw new ServiceException(e);
        }finally {
            connectionPool.closeConnection(connection);
        }
    }

    /**
     * Get reservations.
     * @return the list of reservations.
     * @throws ServiceException if get reservations is failed
     */
    public List<Reservation> getAllEntities() throws ServiceException {
        try {
            connection = connectionPool.takeConnection();
            return reservationDao.getAllReservations(connection);
        } catch (DAOException | ConnectionPoolException e) {
            throw new ServiceException(e);
        }finally {
            connectionPool.closeConnection(connection);
        }
    }

    /**
     * Add reservation.
     * @param reservation the operand to have as a reservation.
     * @throws ServiceException if add reservation is failed
     */
    public List<Reservation> addEntity(Reservation reservation) throws ServiceException {
        List<Reservation> reservations;
        ICrudServiceExtended reservationRoomService = new ReservationRoomServiceImpl();
        try {
            connection = connectionPool.takeConnection();
            reservationDao.addReservation(reservation,connection);
            String[] oneParamReservation = new String[1];
            String[] oneParamRoom = new String[1];
            oneParamReservation[0] = String.valueOf(reservationDao.getLastInsertedReservation(connection).getId());
            Map<String, String[]> params = new HashMap<>();
            params.put("idReservation",oneParamReservation);
            oneParamRoom[0] = String.valueOf(idRoom);
            params.put("idRoom", oneParamRoom);

            reservationRoomDao.addReservationRoom((ReservationRoom)reservationRoomService.buildEntity(params),connection);
            reservations = reservationDao.getAllReservations(connection);
        } catch (DAOException | ConnectionPoolException e) {
            throw new ServiceException(e);
        }finally {
            connectionPool.closeConnection(connection);
        }
        return reservations;
    }

    /**
     * Remove reservation.
     * @param reservation the operand to have as a reservation.
     * @throws ServiceException if remove reservation is failed
     */
    public void removeEntity(Reservation reservation) throws ServiceException {
        try {
            connection = connectionPool.takeConnection();
            reservationDao.removeReservation(reservation,connection);
        } catch (DAOException | ConnectionPoolException e) {
            throw new ServiceException(e);
        }finally {
            connectionPool.closeConnection(connection);
        }
    }

    public Reservation getEntity(Integer id) throws ServiceException {
        Connection connection = null;
        Reservation reservation;
        try {
            connection = connectionPool.takeConnection();
            reservation = reservationDao.getReservation(id, connection);
        } catch (DAOException | ConnectionPoolException e) {
            throw new ServiceException(e);
        } finally {
            connectionPool.closeConnection(connection);
        }
        return reservation;
    }

    /**
     * Update reservation.
     * @param reservation the operand to have as a reservation.
     * @throws ServiceException if update reservation is failed
     */
    public void updateEntity(Reservation reservation) throws ServiceException {
        try {
            connection = connectionPool.takeConnection();
            reservationDao.updateReservation(reservation,connection);
        } catch (DAOException | ConnectionPoolException e) {
            throw new ServiceException(e);
        }finally {
            connectionPool.closeConnection(connection);
        }
    }

    /**
     * This method build entity by received params.
     * @param params the operand that stored data to build reservation.
     * @return a reservation.
     * @throws ServiceException if build reservation is failed
     */
    public Reservation buildEntity(Map<String, String[]> params) throws ServiceException {
        ValidatorReservation validatorReservation = new ValidatorReservation();
        try {
            if (validatorReservation.validate(params)) {
                this.params = params;
                if (params.keySet().contains("idRoom")){
                    idRoom = Integer.parseInt(params.get("idRoom")[0]);
                }else{
                    idRoom = Integer.parseInt(String.valueOf(1));
                }
                return new ReservationBuilder().id(Integer.parseInt(params.get("id")[0]))
                        .dateIn(params.get("dateIn")[0])
                        .dateOut(params.get("dateOut")[0])
                        .accepted(Integer.parseInt(params.get("accepted")[0]))
                        .user(new UserBuilder().id(Integer.parseInt(params.get("idUser")[0])).build())
                        .discount(new DiscountBuilder().id(Integer.parseInt(params.get("idDiscount")[0])).build())
                        .build();
            }
        } catch (IncorrectDateException | IncorrectAcceptedException e) {
            throw new ServiceException(e);
        }
        return null;
    }

    /**
     * Get last inserted reservation.
     * @throws ServiceException if get last inserted reservation is failed
     */
    public Reservation getLastInsertedEntity() throws ServiceException {
        try {
            connection = connectionPool.takeConnection();
            return reservationDao.getLastInsertedReservation(connection);
        } catch (DAOException | ConnectionPoolException e) {
            throw new ServiceException(e);
        }finally {
            connectionPool.closeConnection(connection);
        }
    }

    /**
     * Get all entities by key.
     * @param key the operand to get entities.
     * @return a list of reservations.
     * @throws ServiceException if get reservations is failed
     */
    @Override
    public List<Reservation> getAllEntitiesByKey(Integer key) throws ServiceException {
        throw new UnsupportedOperationException();
    }

}
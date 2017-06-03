package by.hotel.service.impl;

import by.hotel.bean.RoomType;
import by.hotel.builder.RoomTypeBuilder;
import by.hotel.dao.IRoomTypeDao;
import by.hotel.dao.impl.RoomTypeDaoImpl;
import by.hotel.dao.exception.DAOException;
import by.hotel.service.AbstractService;
import by.hotel.service.ICrudServiceExtended;
import by.hotel.service.exception.*;
import by.hotel.service.validator.ValidatorRoomType;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * RoomTypeDaoImpl.java
 * Class implements methods from interface ICrudServiceExtended and extends AbstractService class.
 * getRoomTypeHeaders - method to get room type headers.
 * getRoomTypes - method to get room type.
 * updateRoomType - method to update room type.
 * addRoomType - method to add room type.
 * removeRoomType - method to remove room type.
 * getLastInsertedRoomType - method to get last inserted room type.
 * buildRoomType - method to build room type.
 * @author Igor Kozlov
 * @version 1.0
 */
public class RoomTypeServiceImpl extends AbstractService implements ICrudServiceExtended<RoomType> {
    /**
     * Field - roomTypeDao
     */
    private IRoomTypeDao roomTypeDao = new RoomTypeDaoImpl();

    /**
     * Get room type headers .
     * @return the list of roomType headers.
     * @throws ServiceException  if get room type headers is failed
     */
    public List<String> getAllHeaders() throws ServiceException {
        try {
            return roomTypeDao.getRoomTypeHeaders();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Get roomTypes.
     * @return the list of roomTypes.
     * @throws ServiceException if get room types is failed
     */
    public List<RoomType> getAllEntities() throws ServiceException {
        try {
            return roomTypeDao.getRoomTypes();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Add discount.
     * @param roomType the operand to have as a roomType.
     * @throws ServiceException if add room type is failed
     */
    public List<RoomType> addEntity(RoomType roomType) throws ServiceException {
        List<RoomType> roomTypes;
        try {
            roomTypeDao.addRoomType(roomType);
            roomTypes = roomTypeDao.getRoomTypes();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return roomTypes;
    }

    /**
     * Remove roomType.
     * @param roomType the operand to have as a roomType.
     * @throws ServiceException if remove room type is failed
     */
    public void removeEntity(RoomType roomType) throws ServiceException {
        try {
            roomTypeDao.removeRoomType(roomType);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * Update roomType.
     * @param roomType the operand to have as a roomType.
     * @throws ServiceException if update room type is failed
     */
    public void updateEntity(RoomType roomType) throws ServiceException {
        try {
            roomTypeDao.updateRoomType(roomType);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * This method build entity by received params.
     * @param params the operand that stored data to build room type.
     * @return a room type.
     * @throws ServiceException if build room type is failed
     */
    public RoomType buildEntity(Map<String, String[]> params) throws ServiceException {
        ValidatorRoomType validatorRoomType = new ValidatorRoomType();
        try {
            if (validatorRoomType.validate(params)) {
                return new RoomTypeBuilder().id(Integer.parseInt(params.get("id")[0]))
                        .roomsCount(Integer.parseInt(params.get("roomsCount")[0]))
                        .bedsCount(Integer.parseInt(params.get("bedsCount")[0]))
                        .costPerDay(Float.parseFloat(params.get("costPerDay")[0]))
                        .additionalInfo(params.get("additionalInfo")[0])
                        .bathroomsCount(Integer.parseInt(params.get("bathroomsCount")[0]))
                        .size(Integer.parseInt(params.get("size")[0]))
                        .build();
            }
        } catch (IncorrectRoomBedsException | IncorrectCostException
                | IncorrectRoomsCountException | IncorrectRoomBathroomsException
                | IncorrectRoomAdditionalInfoException | IncorrectRoomSizeException e) {
            throw new ServiceException(e);
        }
        return null;
    }

    /**
     * Get last inserted room type.
     * @throws ServiceException if get last inserted room type is failed
     */
    public RoomType getLastInsertedEntity() throws ServiceException {
        try {
            return roomTypeDao.getLastInsertedRoomType();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

}
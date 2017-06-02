package by.hotel.service.impl;

import by.hotel.bean.Discount;
import by.hotel.builder.DiscountBuilder;
import by.hotel.dao.IDiscountDao;
import by.hotel.dao.impl.DiscountDaoImpl;
import by.hotel.dao.exception.DAOException;
import by.hotel.service.AbstractService;
import by.hotel.service.ICrudServiceExtended;
import by.hotel.service.exception.IncorrectDiscountNameException;
import by.hotel.service.exception.ServiceException;
import by.hotel.service.validator.ValidatorDiscount;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * DiscountServiceImpl.java
 * Class implements methods from interface ICrudServiceExtended and extends from AbstractService class.
 * getDiscountHeaders - method to get discount headers.
 * getDiscounts - method to get discount.
 * updateDiscount - method to update discount.
 * addDiscount - method to add discount.
 * removeDiscount - method to remove discount.
 * getLastInsertedDiscount - method to get last inserted discount.
 * buildDiscount - method to build discount.
 * @author Igor Kozlov
 * @version 1.0
 */
public class DiscountServiceImpl extends AbstractService implements ICrudServiceExtended<Discount> {

    /**
     * Field - discountDao
     */
    private IDiscountDao discountDao = new DiscountDaoImpl();

    /**
     * Get discount headers.
     * @return the list of discount headers.
     * @throws ServiceException  if get discount headers is failed
     */
    public List<String> getAllHeaders() throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            return discountDao.getDiscountHeaders(connection);
        }catch (DAOException e){
            throw new ServiceException(e);
        }finally {
            closeConnection(connection);
        }
    }

    /**
     * Get discounts.
     * @return the list of discounts.
     * @throws ServiceException if get discounts is failed
     */
    public List<Discount> getAllEntities() throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            return discountDao.getDiscounts(connection);
        }catch (DAOException e){
            throw new ServiceException(e);
        }finally {
            closeConnection(connection);
        }
    }

    /**
     * Add discount.
     * @param discount the operand to have as a discount.
     * @throws ServiceException if add discount is failed
     */
    public List<Discount> addEntity(Discount discount) throws ServiceException {
        Connection connection = null;
        List<Discount> discounts;
        try {
            connection = getConnection();
            discountDao.addDiscount(discount,connection);
            discounts = discountDao.getDiscounts(connection);
        }catch (DAOException e){
            throw new ServiceException(e);
        }finally {
            closeConnection(connection);
        }
        return discounts;
    }

    /**
     * Remove discount.
     * @param discount the operand to have as a discount.
     * @throws ServiceException if remove discount is failed
     */
    public void removeEntity(Discount discount) throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            discountDao.removeDiscount(discount,connection);
        }catch (DAOException e){
            throw new ServiceException(e);
        }finally {
            closeConnection(connection);
        }
    }

    /**
     * Update discount.
     * @param discount the operand to have as a discount.
     * @throws ServiceException if update discount is failed
     */
    public void updateEntity(Discount discount) throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            discountDao.updateDiscount(discount,connection);
        }catch (DAOException e){
            throw new ServiceException(e);
        }finally {
            closeConnection(connection);
        }
    }

    /**
     * This method build entity by received params.
     * @param params the operand that stored data to build discount.
     * @return a discount.
     * @throws ServiceException if build discount is failed
     */
    public Discount buildEntity(Map<String, String[]> params) throws ServiceException {
        ValidatorDiscount validatorDiscount = new ValidatorDiscount();
        try {
            if(validatorDiscount.validate(params)) {
                return new DiscountBuilder().id(Integer.parseInt(params.get("id")[0]))
                        .name(params.get("name")[0])
                        .build();
            }
        } catch (IncorrectDiscountNameException e) {
            throw new ServiceException(e);
        }
        return null;
    }

    /**
     * Get last inserted discount.
     * @throws ServiceException if get last inserted discount is failed
     */
    public Discount getLastInsertedEntity() throws ServiceException {
        Connection connection = null;
        try {
            connection = getConnection();
            return discountDao.getLastInsertedDiscount(connection);
        }catch (DAOException e){
            throw new ServiceException(e);
        }finally {
            closeConnection(connection);
        }
    }

}
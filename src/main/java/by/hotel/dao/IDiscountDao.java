package by.hotel.dao;

import by.hotel.bean.Discount;
import by.hotel.dao.exception.DAOException;

import java.sql.Connection;
import java.util.List;

/**
 * IDiscountDao.java
 * Simple discount operation.
 * @author Igor Kozlov
 * @version 1.0
 */
public interface IDiscountDao {
    /**
     * Get discount headers.
     * @param connection the operand to have a connection with DB.
     * @return the list of discount headers.
     * @throws DAOException if get headers is failed
     */
    List<String> getDiscountHeaders(Connection connection) throws DAOException;
    /**
     * Get discounts.
     * @param connection the operand to have a connection with DB.
     * @return the list of discounts.
     * @throws DAOException if get discounts is failed
     */
    List<Discount> getDiscounts(Connection connection) throws DAOException;
    /**
     * Add discount.
     * @param discount the operand to have as a discount.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException if add discount is failed
     */
    void addDiscount(Discount discount, Connection connection) throws DAOException;
    /**
     * Remove discount.
     * @param discount the operand to have as a discount.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException if remove discount is failed
     */
    void removeDiscount(Discount discount, Connection connection) throws DAOException;
    /**
     * Update discount.
     * @param discount the operand to have as a discount.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException if update discount is failed
     */
    void updateDiscount(Discount discount, Connection connection) throws DAOException;
    /**
     * Get last inserted discount.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException if get last inserted discount is failed
     */
    Discount getLastInsertedDiscount(Connection connection) throws DAOException;
}

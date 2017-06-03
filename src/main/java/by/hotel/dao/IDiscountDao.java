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
     * @return the list of discount headers.
     * @throws DAOException if get headers is failed
     */
    List<String> getDiscountHeaders() throws DAOException;
    /**
     * Get discounts.
     * @return the list of discounts.
     * @throws DAOException if get discounts is failed
     */
    List<Discount> getDiscounts() throws DAOException;
    /**
     * Add discount.
     * @param discount the operand to have as a discount.
     * @throws DAOException if add discount is failed
     */
    void addDiscount(Discount discount) throws DAOException;
    /**
     * Remove discount.
     * @param discount the operand to have as a discount.
     * @throws DAOException if remove discount is failed
     */
    void removeDiscount(Discount discount) throws DAOException;
    /**
     * Update discount.
     * @param discount the operand to have as a discount.
     * @throws DAOException if update discount is failed
     */
    void updateDiscount(Discount discount) throws DAOException;
    /**
     * Get last inserted discount.
     * @throws DAOException if get last inserted discount is failed
     */
    Discount getLastInsertedDiscount() throws DAOException;
}

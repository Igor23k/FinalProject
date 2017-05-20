package by.hotel.dao;

import by.hotel.bean.Discount;
import by.hotel.dao.exception.DAOException;

import java.sql.Connection;
import java.util.List;

/**
 * Simple discount operation.
 * @author Igor Kozlov
 * @version 1.0
 */
public interface IDiscountDao {
    /**
     * Get headers of discounts.
     * @param connection the operand to have a connection with DB.
     * @return the list of discount headers.
     * @throws DAOException
     */
    List<String> getDiscountHeaders(Connection connection) throws DAOException;
    /**
     * Get discounts.
     * @param connection the operand to have a connection with DB.
     * @return the list of discounts.
     * @throws DAOException
     */
    List<Discount> getDiscounts(Connection connection) throws DAOException;
    /**
     * Add discount.
     * @param discount the operand to have as a discount.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException
     */
    void addDiscount(Discount discount, Connection connection) throws DAOException;
    /**
     * Remove discount.
     * @param discount the operand to have as a discount.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException
     */
    void removeDiscount(Discount discount, Connection connection) throws DAOException;
    /**
     * Update discount.
     * @param discount the operand to have as a discount.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException
     */
    void updateDiscount(Discount discount, Connection connection) throws DAOException;
    /**
     * Get last inserted discount.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException
     */
    Discount getLastInsertedDiscount(Connection connection) throws DAOException;
}

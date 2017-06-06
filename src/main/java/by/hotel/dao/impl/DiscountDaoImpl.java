package by.hotel.dao.impl;

import by.hotel.bean.Discount;
import by.hotel.builder.DiscountBuilder;
import by.hotel.dao.AbstractDao;
import by.hotel.dao.IDiscountDao;
import by.hotel.dao.connectionpool.ConnectionPool;
import by.hotel.dao.exception.ConnectionPoolException;
import by.hotel.dao.exception.DAOException;
import by.hotel.util.ErrorStringBuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static by.hotel.dao.constant.Constants.*;

/**
 * DiscountDaoImpl.java
 * Class implements methods from interface IDiscountDao and extends from AbstractDao class.
 * getDiscountHeaders - method for get discount headers.
 * getDiscounts - method for get discount.
 * updateDiscount - method for update discount.
 * addDiscount - method for add discount.
 * removeDiscount - method for remove discount.
 * getLastInsertedDiscount - method for get last inserted discount.
 * fillStatement - method for fill statement.
 * fillDiscount - method for fill discount.
 * buildMessage - method for build error message.
 * @author Igor Kozlov
 * @version 1.0
 */
public class DiscountDaoImpl extends AbstractDao implements IDiscountDao {

    private static ConnectionPool connectionPool = ConnectionPool.getInstance();

    /**
     * Get discount headers.
     * @return the list of discount headers.
     * @throws DAOException if get headers is failed
     */
    public List<String> getDiscountHeaders() throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<String> headers = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        Connection connection;
        try {
            connection = connectionPool.takeConnection();
            statement = connection.prepareStatement(GET_ALL_DISCOUNTS_HEADERS);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                stringBuilder.append(resultSet.getInt("id") + " ");
                stringBuilder.append(resultSet.getString("name") + " ");
                stringBuilder.append(resultSet.getString("countPercentages"));
                headers.add(stringBuilder.toString());
                stringBuilder.setLength(0);
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DAOException(e);
        }finally {
            closeStatement(statement, resultSet);
        }
        return headers;
    }

    /**
     * Get discounts.
     * @return the list of discounts.
     * @throws DAOException if get discounts is failed
     */
    public List<Discount> getDiscounts() throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Discount> discounts = new ArrayList<>();
        DiscountBuilder discountBuilder = new DiscountBuilder();
        Connection connection;
        try {
            connection = connectionPool.takeConnection();
            statement = connection.prepareStatement(GET_ALL_DISCOUNTS);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                discounts.add(fillDiscount(resultSet, discountBuilder));
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, resultSet);
        }
        return discounts;
    }

    /**
     * Add discount.
     * @param discount the operand to have as a discount.
     * @throws DAOException if add discount is failed
     */
    public void addDiscount(Discount discount) throws DAOException {
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = connectionPool.takeConnection();
            statement = connection.prepareStatement(ADD_DISCOUNT);
            statement = fillStatement(statement, discount);
            statement.execute();
        } catch (SQLException | NullPointerException | ConnectionPoolException e) {
            throw new DAOException(e);
        } finally {
            connectionPool.closeConnection(connection, statement);
            closeStatement(statement, null);
        }
    }

    /**
     * Remove discount.
     * @param discount the operand to have as a discount.
     * @throws DAOException if remove discount is failed
     */
    public void removeDiscount(Discount discount) throws DAOException {
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = connectionPool.takeConnection();
            statement = connection.prepareStatement(REMOVE_DISCOUNT);
            statement.setInt(1, discount.getId());
            statement.execute();
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new DAOException(buildMessage(discount, e.getMessage()), e);
        } catch (SQLException | NullPointerException | ConnectionPoolException e) {
            throw new DAOException(e);
        } finally {
            connectionPool.closeConnection(connection, statement);
            closeStatement(statement, null);
        }
    }

    /**
     * Update discount.
     * @param discount the operand to have as a discount.
     * @throws DAOException if update discount is failed
     */
    public void updateDiscount(Discount discount) throws DAOException {
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = connectionPool.takeConnection();
            statement = connection.prepareStatement(UPDATE_DISCOUNT);
            statement = fillStatement(statement, discount);
            statement.setInt(3, discount.getId());
            statement.execute();
        } catch (SQLException | NullPointerException | ConnectionPoolException e) {
            throw new DAOException(e);
        } finally {
            connectionPool.closeConnection(connection, statement);
            closeStatement(statement, null);
        }
    }

    /**
     * Get last inserted discount.
     * @throws DAOException if get last inserted discount is failed
     */
    public Discount getLastInsertedDiscount() throws DAOException {
        PreparedStatement statement = null;
        Discount discount = null;
        ResultSet resultSet;
        DiscountBuilder discountBuilder = new DiscountBuilder();
        Connection connection = null;
        try {
            connection = connectionPool.takeConnection();
            statement = connection.prepareStatement(GET_LAST_INSERTED_DISCOUNT);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                discount = fillDiscount(resultSet, discountBuilder);
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DAOException(e);
        } finally {
            connectionPool.closeConnection(connection, statement);
            closeStatement(statement, null);
        }
        return discount;
    }

    /**
     * Fill statement with data.
     * @param statement the operand to make a query.
     * @param discount the operand to have as a discount.
     * @return a PreparedStatement.
     * @throws SQLException if statement is null
     */
    private PreparedStatement fillStatement(PreparedStatement statement, Discount discount) throws SQLException {
        statement.setString(1, discount.getName());
        statement.setString(2, String.valueOf(discount.getCountPercentages()));
        return statement;
    }

    /**
     * Fill discount object with data.
     * @param resultSet the operand that contain data from BD.
     * @param discountBuilder the operand to build a discount.
     * @return a Discount.
     * @throws SQLException
     */
    private Discount fillDiscount(ResultSet resultSet, DiscountBuilder discountBuilder) throws SQLException {
        return discountBuilder.id(resultSet.getInt("id"))
                .name(resultSet.getString("name"))
                .countPercentages(Integer.valueOf(resultSet.getString("countPercentages")))
                .build();
    }

    /**
     * Build error message.
     * @param discount the operand to have as a discount.
     * @param errorMessage the operand that contain special error.
     * @return an error string.
     * @throws SQLException
     */
    private String buildMessage(Discount discount, String errorMessage) {
        Map<String, String> idNames = new HashMap<>();
        idNames.put("id", Integer.toString(discount.getId()));
        return ErrorStringBuilder.buildDeleteErrorString(idNames, errorMessage);
    }
}
package by.hotel.dao;

import by.hotel.bean.User;
import by.hotel.dao.exception.DAOException;

import java.sql.Connection;
import java.util.List;

/**
 * IUserDao.java
 * Simple user operation.
 * @author Igor Kozlov
 * @version 1.0
 */
public interface IUserDao {
    /**
     * Get user headers.
     * @param connection the operand to have a connection with DB.
     * @return the list of user headers.
     * @throws DAOException if get user headers is failed
     */
    List<String> getUserHeaders(Connection connection) throws DAOException;
    /**
     * Get user.
     * @param connection the operand to have a connection with DB.
     * @return the list of users.
     * @throws DAOException if get users is failed
     */
    List<User> getUsers(Connection connection) throws DAOException;
    /**
     * Add user.
     * @param user the operand to have as a user.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException if add user is failed
     */
    void addUser(User user, Connection connection) throws DAOException;
    /**
     * Remove user.
     * @param user the operand to have as a user.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException if remove user is failed
     */
    void removeUser(User user, Connection connection) throws DAOException;
    /**
     * Update user.
     * @param user the operand to have as a user.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException if update user is failed
     */
    void updateUser(User user, Connection connection) throws DAOException;
    /**
     * Get user.
     * @param id the operand to use as id of user.
     * @param connection the operand to have a connection with DB.
     * @return the user.
     * @throws DAOException if get user is failed
     */
    User getUser(Integer id, Connection connection) throws DAOException;
    /**
     * Get last inserted user.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException  if get last inserted user is failed
     */
    User getLastInsertedUser(Connection connection) throws DAOException;

}

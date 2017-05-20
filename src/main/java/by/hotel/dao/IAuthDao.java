package by.hotel.dao;

import by.hotel.bean.User;
import by.hotel.dao.exception.DAOException;

import java.sql.Connection;

/**
 * Simple authorisation operation.
 * @author Igor Kozlov
 * @version 1.0
 */
public interface IAuthDao {
    /**
     * Perform a authorisation.
     * @param email  the operand to use as email of user.
     * @param password the operand to use as password of user.
     * @param connection the operand to have a connection with DB.
     * @return the user.
     * @throws DAOException
     */
    User authorisation(String email, String password, Connection connection) throws DAOException;
}

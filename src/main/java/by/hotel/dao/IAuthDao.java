package by.hotel.dao;

import by.hotel.bean.User;
import by.hotel.dao.exception.DAOException;

import java.sql.Connection;

/**
 * IAuthDao.java
 * Simple authorisation operation.
 * @author Igor Kozlov
 * @version 1.0
 */
public interface IAuthDao {
    /**
     * Perform an authorisation.
     * @param email  the operand to use as email of user.
     * @param password the operand to use as password of user.
     * @return a user.
     * @throws DAOException  if authorisation is failed
     */
    User authorisation(String email, String password) throws DAOException;
}

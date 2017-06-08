package by.hotel.dao;

import by.hotel.bean.Role;
import by.hotel.dao.exception.DAOException;

import java.sql.Connection;
import java.util.List;

/**
 * IRoleDao.java
 * Simple role operation.
 * @author Igor Kozlov
 * @version 1.0
 */
public interface IRoleDao {
    /**
     * Get role headers.
     * @param connection the operand to have a connection with DB.
     * @return the list of role headers.
     * @throws DAOException if get role headers is failed
     */
    List<String> getRoleHeaders(Connection connection) throws DAOException;
    /**
     * Get role.
     * @param connection the operand to have a connection with DB.
     * @return the list of roles.
     * @throws DAOException if get roles is failed
     */
    List<Role> getRoles(Connection connection) throws DAOException;
    /**
     * Add role.
     * @param connection the operand to have a connection with DB.
     * @param role the operand to have as a user role.
     * @throws DAOException if add role is failed
     */
    void addRole(Role role,Connection connection) throws DAOException;
    /**
     * Remove role.
     * @param connection the operand to have a connection with DB.
     * @param role the operand to have as a user role.
     * @throws DAOException if remove role is failed
     */
    void removeRole(Role role,Connection connection) throws DAOException;
    /**
     * Update role
     * @param connection the operand to have a connection with DB.
     * @param role the operand to have as a user role.
     * @throws DAOException if update role is failed
     */
    void updateRole(Role role,Connection connection) throws DAOException;
    /**
     * Get last inserted role.
     * @param connection the operand to have a connection with DB.
     * @return a last inserted role.
     * @throws DAOException if get last inserted role is failed
     */
    Role getLastInsertedRole(Connection connection) throws DAOException;

}

package by.hotel.dao;

import by.hotel.bean.Role;
import by.hotel.dao.exception.DAOException;

import java.sql.Connection;
import java.util.List;

/**
 * Simple role operation.
 * @author Igor Kozlov
 * @version 1.0
 */
public interface IRoleDao {
    /**
     * Get reservation room headers.
     * @param connection the operand to have a connection with DB.
     * @return the list of role headers.
     * @throws DAOException
     */
    List<String> getRoleHeaders(Connection connection) throws DAOException;
    /**
     * Get reservation room.
     * @param connection the operand to have a connection with DB.
     * @return the list of roles.
     * @throws DAOException
     */
    List<Role> getRoles(Connection connection) throws DAOException;
    /**
     * Add reservation room.
     * @param role the operand to have as a user role.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException
     */
    void addRole(Role role, Connection connection) throws DAOException;
    /**
     * Remove reservation room.
     * @param role the operand to have as a user role.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException
     */
    void removeRole(Role role, Connection connection) throws DAOException;
    /**
     * Update role
     * @param role the operand to have as a user role.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException
     */
    void updateRole(Role role, Connection connection) throws DAOException;
    /**
     * Get last inserted role.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException
     */
    Role getLastInsertedRole(Connection connection) throws DAOException;

}

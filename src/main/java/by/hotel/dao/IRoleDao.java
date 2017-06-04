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
     * @return the list of role headers.
     * @throws DAOException if get role headers is failed
     */
    List<String> getRoleHeaders() throws DAOException;
    /**
     * Get role.
     * @return the list of roles.
     * @throws DAOException if get roles is failed
     */
    List<Role> getRoles() throws DAOException;
    /**
     * Add role.
     * @param role the operand to have as a user role.
     * @throws DAOException if add role is failed
     */
    void addRole(Role role) throws DAOException;
    /**
     * Remove role.
     * @param role the operand to have as a user role.
     * @throws DAOException if remove role is failed
     */
    void removeRole(Role role) throws DAOException;
    /**
     * Update role
     * @param role the operand to have as a user role.
     * @throws DAOException if update role is failed
     */
    void updateRole(Role role) throws DAOException;
    /**
     * Get last inserted role.
     * @return a last inserted role.
     * @throws DAOException if get last inserted role is failed
     */
    Role getLastInsertedRole() throws DAOException;

}

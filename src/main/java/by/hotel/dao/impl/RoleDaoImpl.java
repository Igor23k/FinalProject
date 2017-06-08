package by.hotel.dao.impl;

import by.hotel.bean.Role;
import by.hotel.builder.RoleBuilder;
import by.hotel.dao.AbstractDao;
import by.hotel.dao.IRoleDao;
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
 * RoleDaoImpl.java
 * Class implements methods from interface IRoleDao and extends from AbstractDao class.
 * getRoleHeaders - method for get role headers.
 * getRoles - method for get role.
 * updateRole - method for update role.
 * addRole - method for add role.
 * removeRole - method for remove role.
 * getLastInsertedRole - method for get last inserted role.
 * fillStatement - method for fill statement.
 * fillRole - method for fill role.
 * buildMessage - method for build error message.
 * @author Igor Kozlov
 * @version 1.0
 */
public class RoleDaoImpl extends AbstractDao implements IRoleDao {
    /**
     * Get role headers.
     * @param connection the operand to have a connection with DB.
     * @return the list of role headers.
     * @throws DAOException if get role headers is failed
     */
    public List<String> getRoleHeaders(Connection connection) throws DAOException {
        PreparedStatement statement = null;
        List<String> headers = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        try {
            statement = connection.prepareStatement(GET_ALL_ROLES_HEADERS);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                stringBuilder.append(resultSet.getInt("id")+" ");
                stringBuilder.append(resultSet.getString("nameRole"));
                headers.add(stringBuilder.toString());
                stringBuilder.setLength(0);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement);
            closeResultSet(resultSet);
        }
        return headers;
    }

    /**
     * Get roles.
     * @param connection the operand to have a connection with DB.
     * @return the list of roles.
     * @throws DAOException if get roles is failed
     */
    public List<Role> getRoles(Connection connection) throws DAOException {
        PreparedStatement statement = null;
        List<Role> roles = new ArrayList<>();
        RoleBuilder roleBuilder = new RoleBuilder();
        try {
            statement = connection.prepareStatement(GET_ALL_ROLES);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                roles.add(roleBuilder.id(resultSet.getInt("id"))
                        .nameRole(resultSet.getString("nameRole"))
                        .update(resultSet.getByte("update"))
                        .delete(resultSet.getByte("delete"))
                        .insert(resultSet.getByte("insert"))
                        .create(resultSet.getByte("create"))
                        .select(resultSet.getByte("select"))
                        .drop(resultSet.getByte("drop"))
                        .grant(resultSet.getByte("grant"))
                        .build());
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement);
            closeResultSet(resultSet);
        }
        return roles;
    }

    /**
     * Add role.
     * @param connection the operand to have a connection with DB.
     * @param role the operand to have as a role.
     * @throws DAOException if add role is failed
     */
    public void addRole(Role role, Connection connection) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(ADD_ROLE);
            statement = fillStatement(statement, role);
            statement.execute();
        } catch (SQLException | NullPointerException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement);
        }
    }

    /**
     * Remove role.
     * @param connection the operand to have a connection with DB.
     * @param role the operand to have as a role.
     * @throws DAOException if remove role is failed
     */
    public void removeRole(Role role, Connection connection) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(REMOVE_ROLE);
            statement.setInt(1, role.getId());
            statement.execute();
        }catch (SQLIntegrityConstraintViolationException e){
            throw new DAOException(buildMessage(role, e.getMessage()) ,e);
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement);
        }
    }

    /**
     * Update role.
     * @param connection the operand to have a connection with DB.
     * @param role the operand to have as a role.
     * @throws DAOException if update role is failed
     */
    public void updateRole(Role role, Connection connection) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(UPDATE_ROLE);
            statement = fillStatement(statement, role);
            statement.setInt(9, role.getId());
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement);
        }
    }

    /**
     * Get last inserted discount.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException if get last inserted role is failed
     */
    public Role getLastInsertedRole(Connection connection) throws DAOException {
        PreparedStatement statement = null;
        Role role = null;
        RoleBuilder roleBuilder = new RoleBuilder();
        try {
            statement = connection.prepareStatement(GET_LAST_INSERTED_ROLE);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                role = fillRole(resultSet, roleBuilder);
            }
        } catch (SQLException | NullPointerException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement);
            closeResultSet(resultSet);
        }
        return role;
    }

    /**
     * Fill discount object with data.
     * @param resultSet the operand that contain data from BD.
     * @param roleBuilder the operand to build a discount.
     * @return a Discount.
     * @throws SQLException if statement is null
     */
    private Role fillRole(ResultSet resultSet, RoleBuilder roleBuilder) throws SQLException {
        return roleBuilder.id(resultSet.getInt("id"))
                .nameRole(resultSet.getString("nameRole"))
                .update(resultSet.getByte("update"))
                .delete(resultSet.getByte("delete"))
                .insert(resultSet.getByte("insert"))
                .create(resultSet.getByte("create"))
                .select(resultSet.getByte("select"))
                .drop(resultSet.getByte("drop"))
                .grant(resultSet.getByte("grant"))
                .build();
    }

    /**
     * Fill statement with data.
     * @param statement the operand to make a query.
     * @param role the operand to have as a role.
     * @return a PreparedStatement.
     * @throws SQLException if fill statement is failed
     */
    private PreparedStatement fillStatement(PreparedStatement statement, Role role) throws SQLException {
        statement.setString(1, role.getNameRole());
        statement.setInt(2, role.getUpdate());
        statement.setInt(3, role.getDelete());
        statement.setInt(4, role.getInsert());
        statement.setInt(5, role.getCreate());
        statement.setInt(6, role.getSelect());
        statement.setInt(7, role.getDrop());
        statement.setInt(8, role.getGrant());
        return statement;
    }

    /**
     * Build error message.
     * @param role the operand to have as a discount.
     * @param errorMessage the operand that contain special error.
     * @return an error string.
     */
    private String buildMessage(Role role, String errorMessage){
        Map<String,String> idNames = new HashMap<>();
        idNames.put("id",Integer.toString(role.getId()));
        return ErrorStringBuilder.buildDeleteErrorString(idNames,errorMessage);
    }
}

package by.hotel.dao.impl;

import by.hotel.bean.User;
import by.hotel.builder.RoleBuilder;
import by.hotel.builder.UserBuilder;
import by.hotel.dao.AbstractDao;
import by.hotel.dao.IAuthDao;
import by.hotel.dao.IUserDao;
import by.hotel.dao.constants.Constants;
import by.hotel.dao.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.hotel.dao.constants.Constants.*;

/**
 * UserDaoImpl.java
 * Class implements methods from interfaces IUserDao,IAuthDao and extends from AbstractDao class.
 * getUserHeaders - method for get user headers.
 * getUsers - method for get user.
 * updateUser - method for update user.
 * addUser - method for add user.
 * removeUser - method for remove user.
 * getLastInsertedUser - method for get last inserted user.
 * fillStatement - method for fill user.
 * fillUser - method for fill user.
 * buildMessage - method for build error message.
 * @author Igor Kozlov
 * @version 1.0
 */
public class UserDaoImpl extends AbstractDao implements IUserDao,IAuthDao {
    /**
     * Get user headers.
     * @param connection the operand to have a connection with DB.
     * @return the list of user headers.
     * @throws DAOException if get user headers is failed
     */
    public List<String> getUserHeaders(Connection connection) throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<String> headers = new ArrayList<String>();
        StringBuilder stringBuilder = new StringBuilder();
        try {
            statement = connection.prepareStatement(GET_ALL_USERS_HEADERS);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                stringBuilder.append(resultSet.getInt("id")+" ");
                stringBuilder.append(resultSet.getString("surname")+" ");
                stringBuilder.append(resultSet.getString("name"));
                headers.add(stringBuilder.toString());
                stringBuilder.setLength(0);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, resultSet);
        }
        return headers;
    }

    /**
     * Get users.
     * @param connection the operand to have a connection with DB.
     * @return the list of users.
     * @throws DAOException if get users is failed
     */
    public List<User> getUsers(Connection connection) throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<User> users = new ArrayList<>();
        UserBuilder userBuilder = new UserBuilder();
        try {
            statement = connection.prepareStatement(GET_ALL_USERS);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                users.add(fillUser(resultSet, userBuilder));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, resultSet);
        }
        return users;
    }

    /**
     * Add user.
     * @param user the operand to have as a user.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException if add user is failed
     */
    public void addUser(User user,Connection connection) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(ADD_USER);
            statement = fillStatement(statement, user);
            statement.execute();
        } catch (SQLException | NullPointerException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, null);
        }
    }

    /**
     * Remove user.
     * @param user the operand to have as a user.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException if remove user is failed
     */
    public void removeUser(User user,Connection connection) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(REMOVE_USER);
            statement.setInt(1, user.getId());
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, null);
        }
    }

    /**
     * Update user.
     * @param user the operand to have as a user.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException if update user is failed
     */
    public void updateUser(User user,Connection connection) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(UPDATE_USER);
            statement = fillStatement(statement, user);
            statement.setInt(9, user.getId());
            statement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, null);
        }
    }
    /**
     * Get user.
     * @param id the operand to use as id of user.
     * @param connection the operand to have a connection with DB.
     * @return the user.
     * @throws DAOException if get user is failed
     */
    public User getUser(Integer id,Connection connection) throws DAOException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user;
        UserBuilder userBuilder = new UserBuilder();
        try {
            statement = connection.prepareStatement(GET_USER);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            user = fillUser(resultSet, userBuilder);
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, resultSet);
        }
        return user;
    }

    /**
     * Get last inserted user.
     * @param connection the operand to have a connection with DB.
     * @throws DAOException  if get last inserted user is failed
     */
    public User getLastInsertedUser(Connection connection) throws DAOException {
        PreparedStatement statement = null;
        User user = null;
        ResultSet resultSet;
        UserBuilder userBuilder = new UserBuilder();
        try {
            statement = connection.prepareStatement(GET_LAST_INSERTED_USER);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = fillUser(resultSet, userBuilder);
            }
        } catch (SQLException | NullPointerException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement, null);
        }
        return user;
    }

    /**
     * Perform an authorisation.
     * @param email  the operand to use as email of user.
     * @param password the operand to use as password of user.
     * @param connection the operand to have a connection with DB.
     * @return a user.
     * @throws DAOException if authorisation user is failed
     */
    public User authorisation(String email, String password, Connection connection) throws DAOException{
        UserBuilder userBuilder = new UserBuilder();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(Constants.AUTH_USER);
            statement = fillStatement(statement, email,password);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                return fillUser(resultSet, userBuilder);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        finally {
            closeStatement(statement, resultSet);
        }
        return null;
    }

    /**
     * Fill statement with data.
     * @param statement the operand to make a query.
     * @param email the operand to have a user's email.
     * @param password the operand to have as a user's password.
     * @return a PreparedStatement.
     * @throws SQLException if statement is null
     */
    private PreparedStatement fillStatement(PreparedStatement statement, String email, String password) throws SQLException {
        statement.setString(1, email);
        statement.setString(2, password);
        return statement;
    }

    /**
     * Fill statement with data.
     * @param statement the operand to make a query.
     * @param user the operand to have as a user.
     * @return a PreparedStatement.
     ** @throws SQLException if statement is null
     */
    private PreparedStatement fillStatement(PreparedStatement statement, User user) throws SQLException {
        statement.setString(1, user.getPassportNumber());
        statement.setString(2, user.getName());
        statement.setString(3, user.getSurname());
        statement.setString(4, user.getMobilePhone());
        statement.setString(5, user.getPassword());
        statement.setString(6, user.getLogin());
        statement.setInt(7, user.getRole().getId());
        statement.setString(8, user.getEmail());
        if (user.getId() != 0) {
            statement.setInt(9, user.getId());
        }
        return statement;
    }

    /**
     * Fill discount object with data.
     * @param resultSet the operand that contain data from BD.
     * @param userBuilder the operand to build a discount.
     * @return a Discount.
     * @throws SQLException
     */
    private User fillUser(ResultSet resultSet, UserBuilder userBuilder) throws SQLException {
        RoleBuilder roleBuilder = new RoleBuilder();
        return userBuilder.id(resultSet.getInt("id"))
                .passportNumber(resultSet.getString("passportNumber"))
                .name(resultSet.getString("name"))
                .surname(resultSet.getString("surname"))
                .email(resultSet.getString("email"))
                .mobilePhone(resultSet.getString("mobilePhone"))
                .password(resultSet.getString("password"))
                .login(resultSet.getString("login"))
                .role(roleBuilder.id(resultSet.getInt("idRole"))
                        .nameRole(resultSet.getString("nameRole"))
                        .update(resultSet.getByte("update"))
                        .delete(resultSet.getByte("delete"))
                        .insert(resultSet.getByte("insert"))
                        .create(resultSet.getByte("create"))
                        .select(resultSet.getByte("select"))
                        .drop(resultSet.getByte("drop"))
                        .grant(resultSet.getByte("grant")).build())
                .build();
    }
}
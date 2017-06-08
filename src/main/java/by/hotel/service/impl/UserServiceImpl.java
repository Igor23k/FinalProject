package by.hotel.service.impl;

import by.hotel.bean.User;
import by.hotel.builder.RoleBuilder;
import by.hotel.builder.UserBuilder;
import by.hotel.dao.IUserDao;
import by.hotel.dao.exception.ConnectionPoolException;
import by.hotel.dao.exception.DAOException;
import by.hotel.dao.impl.UserDaoImpl;
import by.hotel.security.MD5;
import by.hotel.service.AbstractService;
import by.hotel.service.ICrudServiceExtended;
import by.hotel.service.exception.*;
import by.hotel.service.validator.ValidatorUser;

import java.util.List;
import java.util.Map;

/**
 * UserDaoImpl.java
 * Class implements methods from interfaces IUserDao,IAuthDao and extends from AbstractDao class.
 * getUserHeaders - method to get user headers.
 * getUsers - method to get user.
 * updateUser - method to update user.
 * addUser - method to add user.
 * removeUser - method to remove user.
 * getLastInsertedUser - method to get last inserted user.
 * buildUser - method to build user.
 * @author Igor Kozlov
 * @version 1.0
 */
public class UserServiceImpl extends AbstractService implements ICrudServiceExtended<User> {
    /**
     * Field - userDao
     */
    private IUserDao userDao = new UserDaoImpl();

    /**
     * Get user headers.
     * @return the list of user headers.
     * @throws ServiceException  if get user headers is failed
     */
    public List<String> getAllHeaders() throws ServiceException {
        try {
            connection = connectionPool.takeConnection();
            return userDao.getUserHeaders(connection);
        } catch (DAOException | ConnectionPoolException e) {
            throw new ServiceException(e);
        }finally {
            connectionPool.closeConnection(connection);
        }
    }

    /**
     * Get users.
     * @return the list of users.
     * @throws ServiceException if get users is failed
     */
    public List<User> getAllEntities() throws ServiceException {
        try {
            connection = connectionPool.takeConnection();
            return userDao.getUsers(connection);
        } catch (DAOException | ConnectionPoolException e) {
            throw new ServiceException(e);
        }finally {
            connectionPool.closeConnection(connection);
        }
    }

    /**
     * Get user.
     * @param id the operand to use as id of user.
     * @return the user.
     * @throws ServiceException if get user is failed
     */
    public User getEntity(Integer id) throws ServiceException {
        User user;
        try {
            connection = connectionPool.takeConnection();
            user = userDao.getUser(id, connection);
        } catch (DAOException | ConnectionPoolException e) {
            throw new ServiceException(e);
        }finally {
            connectionPool.closeConnection(connection);
        }
        return user;
    }

    /**
     * Add user.
     * @param user the operand to have as a user.
     * @throws ServiceException if add user is failed
     */
    public List<User> addEntity(User user) throws ServiceException {
        List<User> users;
        try {
            connection = connectionPool.takeConnection();
            userDao.addUser(user, connection);
            users = userDao.getUsers(connection);
        } catch (DAOException | ConnectionPoolException e) {
            throw new ServiceException(e);
        }finally {
            connectionPool.closeConnection(connection);
        }
        return users;
    }

    /**
     * Remove user.
     * @param user the operand to have as a user.
     * @throws ServiceException if remove user is failed
     */
    public void removeEntity(User user) throws ServiceException {
        try {
            connection = connectionPool.takeConnection();
            userDao.removeUser(user, connection);
        } catch (DAOException | ConnectionPoolException e) {
            throw new ServiceException(e);
        }finally {
            connectionPool.closeConnection(connection);
        }
    }

    /**
     * Update user.
     * @param user the operand to have as a user.
     * @throws ServiceException if update user is failed
     */
    public void updateEntity(User user) throws ServiceException {
        try {
            connection = connectionPool.takeConnection();
            userDao.updateUser(user, connection);
        } catch (DAOException | ConnectionPoolException e) {
            throw new ServiceException(e);
        }
    }

    /**
     * This method build entity by received params.
     * @param params the operand that stored data to build user.
     * @return a user.
     * @throws ServiceException if build user is failed
     */
    public User buildEntity(Map<String, String[]> params) throws ServiceException {
        ValidatorUser validatorUser = new ValidatorUser();
        String password;
        if (Integer.parseInt(params.get("id")[0]) != 0){
            password = params.get("password")[0];
        }else {
            password = MD5.crypt(params.get("password")[0]);
        }
        try {
            if (validatorUser.validate(params)) {
                return new UserBuilder().id(Integer.parseInt(params.get("id")[0]))
                        .name(params.get("name")[0])
                        .surname(params.get("surname")[0])
                        .login(params.get("login")[0])
                        .email(params.get("email")[0])
                        .password(password)
                        .banned(Integer.valueOf(params.get("banned")[0]))
                        .passportNumber(params.get("passportNumber")[0])
                        .mobilePhone(params.get("mobilePhone")[0])
                        .role(new RoleBuilder().id(Integer.parseInt(params.get("idRole")[0])).build())
                        .build();
            }
        } catch (IncorrectPassportNumberException
                | IncorrectUserSurnameException | IncorrectPasswordException
                | IncorrectMobilePhoneException | IncorrectLoginException
                | IncorrectUserNameException | IncorrectUserEmailException e) {
            throw new ServiceException(e);
        }
        return null;
    }

    /**
     * Get last inserted user.
     * @throws ServiceException if get last inserted user is failed
     */
    public User getLastInsertedEntity() throws ServiceException {
        try {
            connection = connectionPool.takeConnection();
            return userDao.getLastInsertedUser(connection);
        } catch (DAOException | ConnectionPoolException e) {
            throw new ServiceException(e);
        }finally {
            connectionPool.closeConnection(connection);
        }
    }

    /**
     * Get all entities by key.
     * @param key the operand to get entities.
     * @return a list of user types.
     * @throws ServiceException if get users is failed
     */
    @Override
    public List<User> getAllEntitiesByKey(Integer key) throws ServiceException {
        throw new UnsupportedOperationException();
    }

}
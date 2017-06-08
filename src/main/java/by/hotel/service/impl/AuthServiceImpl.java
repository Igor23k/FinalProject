package by.hotel.service.impl;

import by.hotel.bean.User;
import by.hotel.command.exception.CommandException;
import by.hotel.dao.IAuthDao;
import by.hotel.dao.connectionpool.ConnectionPool;
import by.hotel.dao.exception.ConnectionPoolException;
import by.hotel.dao.exception.DAOException;
import by.hotel.dao.impl.UserDaoImpl;
import by.hotel.service.AbstractService;
import by.hotel.service.IAuthService;
import by.hotel.service.exception.ServiceException;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * AuthServiceImpl.java
 * Class implements methods from interface ICommand and extends AbstractService.
 * checkUser - method to check user in BD.
 * @author Igor Kozlov
 * @version 1.0
 */
public class AuthServiceImpl extends AbstractService implements IAuthService {

	private static ConnectionPool connectionPool = ConnectionPool.getInstance();
	Connection connection;
	/**
	 * Field - authDao
	 */
	private IAuthDao authDao = new UserDaoImpl();

	/**
	 * Perform an authorisation.
	 * @param email  the operand to use as email of user.
	 * @param password the operand to use as password of user.
	 * @return a user.
	 * @throws ServiceException if authorisation user is failed
	 */
	public User checkUser(String email, String password)  throws ServiceException{
		try {
			connection = connectionPool.takeConnection();
			return authDao.authorisation(email,password,connection);
		}catch (DAOException | ConnectionPoolException e){
			throw new ServiceException(e);
		}finally {
			connectionPool.closeConnection(connection);
		}
	}

}
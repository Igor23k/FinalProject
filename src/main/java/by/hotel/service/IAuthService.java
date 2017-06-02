package by.hotel.service;


import by.hotel.bean.User;
import by.hotel.service.exception.ServiceException;

/**
 * IAuthService.java
 * Simple check user in base.
 * @author Igor Kozlov
 * @version 1.0
 */
public interface IAuthService {
	/**
	 * Check existence of user.
	 * @param email  the operand to use as email of user.
	 * @param password the operand to use as password of user.
	 * @return the user.
	 * @throws ServiceException if authorisation is failed
	 */
	User checkUser(String email, String password)  throws ServiceException;
}
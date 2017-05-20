package by.hotel.service;

import by.hotel.bean.User;
import by.hotel.service.exception.ServiceException;

/**
 * Simple registration user.
 * @author Igor Kozlov
 * @version 1.0
 */
public interface IRegistrationService {
    /**
     * Registration user.
     * @return the user.
     * @throws ServiceException
     */
    User registration(User user)  throws ServiceException;
}

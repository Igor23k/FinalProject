package by.hotel.service;

import by.hotel.bean.User;
import by.hotel.service.exception.ServiceException;

/**
 * IRegistrationService.java
 * Simple registration user.
 * @author Igor Kozlov
 * @version 1.0
 */
public interface IRegistrationService {
    /**
     * Registration user.
     * @param user - the param to registration.
     * @return the user.
     * @throws ServiceException if user registration is failed
     */
    User registration(User user)  throws ServiceException;
}

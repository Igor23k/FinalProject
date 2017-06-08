package by.hotel.service.impl;

import by.hotel.bean.User;
import by.hotel.service.IAuthService;
import by.hotel.service.ICrudService;
import by.hotel.service.IRegistrationService;
import by.hotel.service.exception.ServiceException;

import java.util.List;


/**
 * RegistrationServiceImpl.java
 * Class implements methods from interface IRegistrationService.
 * registration - method to registration user.
 * @author Igor Kozlov
 * @version 2.0
 */
public class RegistrationServiceImpl implements IRegistrationService {
    /**
     * Field - authService
     */
    IAuthService authService = new AuthServiceImpl();
    /**
     * Field - discountDao
     */
    ICrudService crudService = new UserServiceImpl();

    /**
     * Perform a registration.
     * @param user  the operand to use as user.
     * @return a registered user.
     * @throws ServiceException if add user is failed
     */
    @Override
    public User registration(User user) throws ServiceException {
        if(authService.checkUser(user.getEmail(),user.getPassword()) == null){
            List<User> list = crudService.addEntity(user);
            return list.get(list.size()-1);
        }
        return null;
    }
}

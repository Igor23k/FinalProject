package by.hotel.service.impl;

import by.hotel.bean.User;
import by.hotel.service.IAuthService;
import by.hotel.service.ICrudService;
import by.hotel.service.IRegistrationService;
import by.hotel.service.exception.ServiceException;

import java.util.List;

public class RegistrationServiceImpl implements IRegistrationService {
    IAuthService authService = new AuthServiceImpl();
    ICrudService crudService = new UserServiceImpl();
    @Override
    public User registration(User user) throws ServiceException {
        if(authService.checkUser(user.getEmail(),user.getPassword()) == null){
            List<User> list = crudService.addEntity(user);
            return list.get(list.size()-1);
        }
        return null;
    }
}

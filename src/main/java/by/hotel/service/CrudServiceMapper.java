package by.hotel.service;

import by.hotel.service.impl.*;

import java.util.HashMap;
import java.util.Map;

/**
 * CrudServiceMapper.java
 * Class represents a storage of services
 * getService - method to get service  that implements ICrudService interface.
 * @version 2.0
 * @autor Igor Kozlov
 */
public class CrudServiceMapper {
    /**
     * Field -  field to store services.
     */
    final private static Map<String, ICrudService> services = new HashMap();

    static {
        services.put("DISCOUNT", new DiscountServiceImpl());
        services.put("RESERVATION", new ReservationServiceImpl());
        services.put("RESERVATION_ROOM", new ReservationRoomServiceImpl());
        services.put("ROOM", new RoomServiceImpl());
        services.put("ROOM_TYPE", new RoomTypeServiceImpl());
        services.put("USER", new UserServiceImpl());
        services.put("ROLE", new RoleServiceImpl());
    }

    /**
     * Get a command by name.
     * @param serviceName the operand to get an operation.
     * @return service that implements interface ICrudService.
     */
    public static ICrudService getService(String serviceName) {
        return services.get(serviceName.toUpperCase());
    }
}

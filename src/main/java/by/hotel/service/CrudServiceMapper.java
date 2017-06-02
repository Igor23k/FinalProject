package by.hotel.service;

import by.hotel.service.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CrudServiceMapper {
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

    public static ICrudService getService(String serviceName) {
        return services.get(serviceName.toUpperCase());
    }
}

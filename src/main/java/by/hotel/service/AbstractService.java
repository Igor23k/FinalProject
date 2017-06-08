package by.hotel.service;

import by.hotel.dao.connectionpool.ConnectionPool;

import java.sql.Connection;

/**
 * AbstractService.java
 * Class can contain common methods for services.
 * @version 2.0
 * @author Igor Kozlov
 */
public class AbstractService {
    protected static ConnectionPool connectionPool = ConnectionPool.getInstance();
    protected Connection connection;
}

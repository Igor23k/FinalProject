package by.hotel.dao;

import by.hotel.dao.connectionpool.ConnectionPool;
import by.hotel.dao.exception.ConnectionPoolException;
import by.hotel.dao.exception.DAOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * AbstractService.java
 * Class contain common methods for dao classes.

 * @version 2.0
 * @autor Igor Kozlov
 */
public abstract class AbstractDao {
    /**
     * It is a logger which print some messages to log file.
     */
    private static final Logger logger = LogManager.getLogger(AbstractDao.class.getName());

    /**
     * It is a connectionPool that contains connections
     */
    private static ConnectionPool connectionPool = ConnectionPool.getInstance();

    static {
        try {
            connectionPool.initPoolData();
        } catch (ConnectionPoolException e) {
            e.printStackTrace();
        }
    }

    /**
     * The method closes a statement.
     */
    public void closeStatement(Statement statement, ResultSet resultSet) throws DAOException {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            logger.error(e);
        }
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            logger.error(e);
        }
    }
}

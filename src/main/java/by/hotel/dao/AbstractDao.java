package by.hotel.dao;

import by.hotel.dao.connectionpool.ConnectionPool;
import by.hotel.dao.exception.ConnectionPoolException;
import by.hotel.dao.exception.DAOException;
import by.hotel.servlet.MainServlet;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * AbstractService.java
 * Class contain common methods for dao classes.

 * @version 2.0
 * @author Igor Kozlov
 */
public abstract class AbstractDao {
    protected ResultSet resultSet;
    /**
     * It is a logger which print some messages to log file.
     */
    private static final Logger logger = Logger.getLogger(AbstractDao.class);

    /**
     * It is a connectionPool that contains connections
     */
    private static ConnectionPool connectionPool = ConnectionPool.getInstance();

    static {
        try {
            connectionPool.initPoolData();
        } catch (ConnectionPoolException e) {
            logger.error(e);
        }
    }

    /**
     * The method closes a statement.
     * @param statement - the param that needed to close.
     * @throws DAOException if close the statement or resultSet is failed.
     */
    public void closeStatement(Statement statement) throws DAOException {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            logger.error(e);
        }
    }

    /**
     * The method closes a statement.
     * @param resultSet - the param that needed to close.
     * @throws DAOException if close the statement or resultSet is failed.
     */
    public void closeResultSet(ResultSet resultSet) throws DAOException {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            logger.error(e);
        }
    }
}

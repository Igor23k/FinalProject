package by.hotel.service;

import by.hotel.service.exception.ServiceException;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

/**
 * AbstractService.java
 * Class contain common methods for services.
 * initConnectionPool - method to initialization connection pool.
 * getConnection - method to get connection.
 * closeConnection - method to close connection.
 * @version 2.0
 * @autor Igor Kozlov
 */
public class AbstractService {
    /**
     * Field -  logger.
     */
    private static final Logger logger;

    /**
     * Field -  dataSource.
     */
    private static HikariDataSource dataSource;

    static {
        try{
            logger = LogManager.getLogger(AbstractService.class.getName());
            Class.forName(Driver.class.getName());
            initConnectionPool();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Initialization connection pool.
     */
    private static void initConnectionPool(){
        InputStream inputStream =null;
        Properties properties=new Properties();
        try {
            inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties");
            properties.load(inputStream);
            dataSource = new HikariDataSource( new HikariConfig(properties));
        }catch (IOException e){
            throw new RuntimeException(e);
        }finally {
            try {
                if(inputStream !=null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                logger.error(e);
            }
        }
    }

    /**
     * Get a connection.
     * @return service that implements interface ICrudService.
     * @throws ServiceException if connection is null
     */
    public final Connection getConnection() throws ServiceException{
        Connection connection;
        try{
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new ServiceException(e);
        }
        return connection;
    }

    /**
     * Close a connection.
     * @param  connection to make queries to BD
     * @throws ServiceException if connection close is incorrect
     */
    public void closeConnection(Connection connection) throws ServiceException {
        try {
            if(connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            logger.error(e);
        }
    }
}

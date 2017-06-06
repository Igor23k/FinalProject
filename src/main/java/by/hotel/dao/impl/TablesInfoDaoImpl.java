package by.hotel.dao.impl;

import by.hotel.dao.AbstractDao;
import by.hotel.dao.ITablesInfoDao;
import by.hotel.dao.connectionpool.ConnectionPool;
import by.hotel.dao.exception.ConnectionPoolException;
import by.hotel.dao.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.hotel.dao.constant.Constants.GET_ALL_NAMES_TABLES;

/**
 * TablesInfoDaoImpl.java
 * Class implements methods from interface ITablesInfoDao and extends from AbstractDao class.
 * getNamesTables - method for get name tables.
 * @author Igor Kozlov
 * @version 1.0
 */
public class TablesInfoDaoImpl extends AbstractDao implements ITablesInfoDao {

    private static ConnectionPool connectionPool = ConnectionPool.getInstance();

    /**
     * Get table names.
     * @return a list of table names.
     * @throws DAOException  if get info tables is failed
     */
    public List<String> getNamesTables() throws DAOException {
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        List<String> namesTables=new ArrayList<>();
        Connection connection = null;
        try {
            connection = connectionPool.takeConnection();
            statement=connection.prepareStatement(GET_ALL_NAMES_TABLES);
            resultSet=statement.executeQuery();
            while(resultSet.next()){
                namesTables.add(resultSet.getString("Tables_in_db_hotel"));
            }
        }catch (SQLException | ConnectionPoolException e){
            throw new DAOException(e);
        } finally {
            connectionPool.closeConnection(connection, statement);
            closeStatement(statement, resultSet);
        }
        return namesTables;
    }
}

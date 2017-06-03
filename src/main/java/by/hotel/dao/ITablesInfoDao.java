package by.hotel.dao;

import by.hotel.dao.exception.DAOException;

import java.sql.Connection;
import java.util.List;

/**
 * ITablesInfoDao.java
 * Simple table information operation.
 * @author Igor Kozlov
 * @version 1.0
 */
public interface ITablesInfoDao {
    /**
     * Get table names.
     * @return the list of table names.
     * @throws DAOException  if get info tables is failed
     */
    List<String> getNamesTables() throws DAOException;
}

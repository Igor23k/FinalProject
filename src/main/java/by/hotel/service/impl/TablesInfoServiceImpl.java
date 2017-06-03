package by.hotel.service.impl;

import by.hotel.dao.ITablesInfoDao;
import by.hotel.dao.impl.TablesInfoDaoImpl;
import by.hotel.dao.exception.DAOException;
import by.hotel.service.AbstractService;
import by.hotel.service.ITablesInfoService;
import by.hotel.service.exception.ServiceException;

import java.sql.Connection;
import java.util.List;

/**
 * TablesInfoDaoImpl.java
 * Class implements methods from interface ITablesInfoService and extends from AbstractService class.
 * getNamesTables - method for get name tables.
 * @author Igor Kozlov
 * @version 1.0
 */
public class TablesInfoServiceImpl extends AbstractService implements ITablesInfoService {
    /**
     * Field - tablesInfoDao
     */
    ITablesInfoDao tablesInfoDao = new TablesInfoDaoImpl();

    /**
     * Get table names.
     * @return a list of table names.
     * @throws ServiceException  if get table names is failed
     */
    public List<String> getAllTablesNames() throws ServiceException {
        try {
            return tablesInfoDao.getNamesTables();
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }
}

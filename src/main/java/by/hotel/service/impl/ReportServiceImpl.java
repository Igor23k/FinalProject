package by.hotel.service.impl;

import by.hotel.bean.Report;
import by.hotel.dao.IReportDao;
import by.hotel.dao.connectionpool.ConnectionPool;
import by.hotel.dao.exception.ConnectionPoolException;
import by.hotel.dao.exception.DAOException;
import by.hotel.dao.impl.ReportDaoImpl;
import by.hotel.service.AbstractService;
import by.hotel.service.exception.ServiceException;

import java.sql.Connection;

/**
 * ReportServiceImpl.java
 * Class contain methods to create report.
 * @author Igor Kozlov
 * @version 2.0
 */
public class ReportServiceImpl extends AbstractService {
    private static ConnectionPool connectionPool = ConnectionPool.getInstance();
    Connection connection;
	private IReportDao reportDao = new ReportDaoImpl();

    /**
     * Create a financial report by month.
     * @param report  the operand to use as report.
     * @return a report.
     * @throws ServiceException if creating is failed
     */
	public Report getFinancialReportInfoByMonth(Report report) throws ServiceException {
        Connection connection = null;
        try {
            connection = connectionPool.takeConnection();
            report = reportDao.getFinancialReportInfoByMonth(report, connection);
        }catch (DAOException | ConnectionPoolException e){
            new ServiceException(e);
        }finally {
            connectionPool.closeConnection(connection);
        }
        return report;
    }

    /**
     * Create a financial report by quarter.
     * @param report  the operand to use as report.
     * @return a report.
     * @throws ServiceException if creating is failed
     */
    public Report getFinancialReportInfoByQuarter(Report report) throws ServiceException {
        Connection connection = null;
        try {
            connection = connectionPool.takeConnection();
            report = reportDao.getFinancialReportInfoByQuarter(report, connection);
        }catch (DAOException | ConnectionPoolException e){
            new ServiceException(e);
        }finally {
            connectionPool.closeConnection(connection);
        }
        return report;
    }
    /**
     * Create a room report by month.
     * @param report  the operand to use as report.
     * @return a report.
     * @throws ServiceException if creating is failed
     */
    public Report getRoomReportInfoByMonth(Report report) throws ServiceException {
        Connection connection = null;
        try {
            connection = connectionPool.takeConnection();
            report = reportDao.getRoomReportInfoByMonth(report, connection);
        }catch (DAOException | ConnectionPoolException e){
            new ServiceException(e);
        }finally {
            connectionPool.closeConnection(connection);
        }
        return report;
    }

    /**
     * Create a room report by quarter.
     * @param report  the operand to use as report.
     * @return a report.
     * @throws ServiceException if creating is failed
     */
    public Report getRoomReportInfoByQuarter(Report report) throws ServiceException {
        Connection connection = null;
        try {
            connection = connectionPool.takeConnection();
            report = reportDao.getRoomReportInfoByQuarter(report, connection);
        }catch (DAOException | ConnectionPoolException e){
            new ServiceException(e);
        }finally {
            connectionPool.closeConnection(connection);
        }
        return report;
    }
}
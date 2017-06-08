package by.hotel.dao;

import by.hotel.bean.Report;
import by.hotel.dao.exception.DAOException;

import java.sql.Connection;

/**
 * IReportDao.java
 * Simple report operation.
 * @author Igor Kozlov
 * @version 1.0
 */
public interface IReportDao {
    /**
     * Get fin report by month.
     * @param connection the operand to have a connection with DB.
     * @param report the be as a report.
     * @return the report.
     * @throws DAOException if get report is failed
     */
    Report getFinancialReportInfoByMonth(Report report, Connection connection) throws DAOException;
    /**
     * Get fin report by quarter.
     * @param connection the operand to have a connection with DB.
     * @param report the be as a report.
     * @return the report.
     * @throws DAOException if get report is failed
     */
    Report getFinancialReportInfoByQuarter(Report report, Connection connection) throws DAOException;
    /**
     * Get room report by month.
     * @param connection the operand to have a connection with DB.
     * @param report the be as a report.
     * @return the report.
     * @throws DAOException if get report is failed
     */
    Report getRoomReportInfoByQuarter(Report report, Connection connection) throws DAOException;
    /**
     * Get room report by month.
     * @param connection the operand to have a connection with DB.
     * @param report the be as a report.
     * @return the report.
     * @throws DAOException if get report is failed
     */
    Report getRoomReportInfoByMonth(Report report, Connection connection) throws DAOException;
}

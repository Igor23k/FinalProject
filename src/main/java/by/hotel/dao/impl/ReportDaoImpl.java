package by.hotel.dao.impl;

import by.hotel.bean.FinancialReport;
import by.hotel.bean.Report;
import by.hotel.bean.RoomReport;
import by.hotel.dao.AbstractDao;
import by.hotel.dao.IReportDao;
import by.hotel.dao.exception.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static by.hotel.dao.constant.Constants.*;
/**
 * ReportDaoImpl.java
 * Simple report operation.
 * @author Igor Kozlov
 * @version 1.0
 */
public class ReportDaoImpl extends AbstractDao implements IReportDao {
    /**
     * Get fin report by month.
     * @param connection the operand to have a connection with DB.
     * @param report the be as a report.
     * @return the report.
     * @throws DAOException if get report is failed
     */
    @Override
    public Report getFinancialReportInfoByMonth(Report report, Connection connection) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(GET_FINANCIAL_REPORT_BY_MONTH_FOR_YEAR);
            statement.setString(1, report.getYear());
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                FinancialReport financialReport = new FinancialReport();
                financialReport.setPeriodNumber(resultSet.getInt("month"));
                financialReport.setTotal(resultSet.getInt("total"));
                report.addItem(financialReport);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement);
            closeResultSet(resultSet);
        }
        return report;
    }

    /**
     * Get fin report by quarter.
     * @param connection the operand to have a connection with DB.
     * @param report the be as a report.
     * @return the report.
     * @throws DAOException if get report is failed
     */
    @Override
    public Report getFinancialReportInfoByQuarter(Report report, Connection connection) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(GET_FINANCIAL_REPORT_BY_QUARTER_FOR_YEAR);
            statement.setString(1, report.getYear());
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                FinancialReport financialReport = new FinancialReport();
                financialReport.setPeriodNumber(resultSet.getInt("quarter"));
                financialReport.setTotal(resultSet.getInt("total"));
                report.addItem(financialReport);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement);
            closeResultSet(resultSet);
        }
        return report;
    }

    /**
     * Get room report by month.
     * @param connection the operand to have a connection with DB.
     * @param report the be as a report.
     * @return the report.
     * @throws DAOException if get report is failed
     */
    @Override
    public Report getRoomReportInfoByMonth(Report report, Connection connection) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(GET_ROOM_REPORT_BY_MONTH_FOR_YEAR);
            statement.setString(1, report.getYear());
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                RoomReport roomReport = new RoomReport();
                roomReport.setRoomName(resultSet.getString("name"));
                roomReport.setPeriodNumber(resultSet.getInt("month"));
                roomReport.setTotal(resultSet.getInt("total"));
                report.addItem(roomReport);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement);
            closeResultSet(resultSet);
        }
        return report;
    }

    /**
     * Get room report by month.
     * @param connection the operand to have a connection with DB.
     * @param report the be as a report.
     * @return the report.
     * @throws DAOException if get report is failed
     */
    @Override
    public Report getRoomReportInfoByQuarter(Report report, Connection connection) throws DAOException {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(GET_ROOM_REPORT_BY_QUARTER_FOR_YEAR);
            statement.setString(1, report.getYear());
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                RoomReport roomReport = new RoomReport();
                roomReport.setRoomName(resultSet.getString("name"));
                roomReport.setPeriodNumber(resultSet.getInt("quarter"));
                roomReport.setTotal(resultSet.getInt("total"));
                report.addItem(roomReport);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closeStatement(statement);
            closeResultSet(resultSet);
        }
        return report;
    }
}

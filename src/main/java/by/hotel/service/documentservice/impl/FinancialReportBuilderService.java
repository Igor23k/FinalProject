package by.hotel.service.documentservice.impl;

import by.hotel.bean.DocumentObject;
import by.hotel.bean.FinancialReport;
import by.hotel.bean.Report;
import by.hotel.builder.ReportBuilder;
import by.hotel.documentbuilder.DocumentBuilder;
import by.hotel.documentbuilder.impl.FinancialReportByMonthBuilder;
import by.hotel.documentbuilder.impl.FinancialReportByQuarterBuilder;
import by.hotel.service.documentservice.IDocumentBuilderService;
import by.hotel.service.exception.ServiceException;
import by.hotel.service.impl.ReportServiceImpl;

import java.util.Map;
/**
 * FinancialReportBuilderService.java
 * Simple build document operation.
 * @author Igor Kozlov
 * @version 1.0
 */
public class FinancialReportBuilderService implements IDocumentBuilderService {
    private enum ReportType{
        BY_MONTH{
            @Override
            DocumentObject build(Report report) throws ServiceException {
                DocumentBuilder documentBuilder = FinancialReportByMonthBuilder.getInstance();
                report = new ReportServiceImpl().getFinancialReportInfoByMonth(report);
                return documentBuilder.buildDocument(report);
            }
        },

        BY_QUARTER{
            @Override
            DocumentObject build(Report report) throws ServiceException {
                DocumentBuilder documentBuilder = FinancialReportByQuarterBuilder.getInstance();
                report = new ReportServiceImpl().getFinancialReportInfoByQuarter(report);
                return documentBuilder.buildDocument(report);
            }
        };

        abstract DocumentObject build(Report report) throws ServiceException;
    }

    /**
     * Build document.
     * @param documentParams the data to create document.
     * @return document.
     * @throws ServiceException if build document is failed
     */
    @Override
    public DocumentObject buildDocument(Map<String, String[]> documentParams) throws ServiceException {
        ReportType reportType = ReportType.valueOf(documentParams.get("type")[0].toUpperCase());
        return reportType.build(buildReport(documentParams));
    }
    /**
     * Build report.
     * @param documentParams the data to create document.
     * @return report.
     */
    private Report buildReport(Map<String, String[]> documentParams){
        return new ReportBuilder<FinancialReport>().year(documentParams.get("year")[0]).build();
    }
}

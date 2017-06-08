package by.hotel.service.documentservice.impl;

import by.hotel.bean.DocumentObject;
import by.hotel.bean.Report;
import by.hotel.bean.RoomReport;
import by.hotel.builder.ReportBuilder;
import by.hotel.documentbuilder.DocumentBuilder;
import by.hotel.documentbuilder.impl.RoomReportByMonthBuilder;
import by.hotel.documentbuilder.impl.RoomReportByQuarterBuilder;
import by.hotel.service.documentservice.IDocumentBuilderService;
import by.hotel.service.exception.ServiceException;
import by.hotel.service.impl.ReportServiceImpl;

import java.util.Map;
/**
 * RoomReportBuilderService.java
 * Simple build document operation.
 * @author Igor Kozlov
 * @version 1.0
 */
public class RoomReportBuilderService implements IDocumentBuilderService {
    private enum ReportType{
        BY_MONTH{
            @Override
            DocumentObject build(Report report) throws ServiceException {
                DocumentBuilder documentBuilder = RoomReportByMonthBuilder.getInstance();
                report = new ReportServiceImpl().getRoomReportInfoByMonth(report);
                return documentBuilder.buildDocument(report);
            }
        },

        BY_QUARTER{
            @Override
            DocumentObject build(Report report) throws ServiceException {
                DocumentBuilder documentBuilder = RoomReportByQuarterBuilder.getInstance();
                report = new ReportServiceImpl().getRoomReportInfoByQuarter(report);
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
        return new ReportBuilder<RoomReport>().year(documentParams.get("year")[0]).build();
    }
}

package by.hotel.documentbuilder.impl;

import by.hotel.bean.FinancialReport;
import by.hotel.bean.Report;
import by.hotel.documentbuilder.ExcelDocumentBuilder;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

/**
 * FinancialReportByMonthBuilder.java
 * This class is using to create xls documents.
 * @author Igor Kozlov
 * @version 1.0
 */
public class FinancialReportByMonthBuilder extends ExcelDocumentBuilder<Report> {
    public FinancialReportByMonthBuilder() {
        super("Financial report by month.xls");
    }

    /**
     * Holder.java
     * This internal class is a template Singleton.
     * @author Igor Kozlov
     * @version 1.0
     */
    private static class Holder{
        /**
         * Field - this field need to be singleton of FinancialReportByMonthBuilder class.
         */
        private final static FinancialReportByMonthBuilder INSTANCE = new FinancialReportByMonthBuilder();
    }

    /**
     * Get a singleton object.
     * @return singleton object.
     */
    public static FinancialReportByMonthBuilder getInstance(){
        return FinancialReportByMonthBuilder.Holder.INSTANCE;
    }
    /** Function for insert data in workbook.
     *@param workbook - the document to insert data
     *@param documentData - the data to be insert in workbook
     */
    @Override
    protected void fillDoc(HSSFWorkbook workbook, Report documentData) {
        HSSFSheet sheet = workbook.createSheet("Report");
        addHeader(sheet, "Год " + documentData.getYear());
        addMonth(sheet);
        fillSheet(sheet, documentData);
        sheet.autoSizeColumn(0);
        sheet.autoSizeColumn(1);
    }

    /**  Function for insert data in sheet.
     *@param sheet - the sheet to insert data
     *@param documentData - the data to be insert in sheet
     */
    private void fillSheet(HSSFSheet sheet, Report documentData) {
        List<FinancialReport> reports = documentData.getData();
        for (int i=0; i< reports.size()-1; i++){
            Row row  = sheet.getRow(sheet.getLastRowNum() - Month.values().length + reports.get(i).getPeriodNumber());
            row.getCell(1).setCellValue(reports.get(i).getTotal());
        }
        createRowWithCells(sheet, null);
        createRowWithCells(sheet, "Всего:");
        sheet.getRow(sheet.getLastRowNum()).getCell(1).setCellValue(reports.get(reports.size() - 1).getTotal());
    }

    /**  Function for insert header in sheet.
     *@param sheet - the sheet to insert data
     *@param header - the data to be insert in sheet
     */
    private void addHeader(HSSFSheet sheet, String header){
        createRowWithCells(sheet, header);
        CellRangeAddress region = new CellRangeAddress(0,0,0,1);
        sheet.addMergedRegion(region);
        Row columnTitles = createRowWithCells(sheet, "Месяц");
        columnTitles.getCell(1).setCellValue("Выручка, руб.");
    }

    /**  Function for insert data for month.
     *@param sheet - the sheet to insert data
     */
    private void addMonth(HSSFSheet sheet){
        Locale locale = Locale.forLanguageTag("ru");
        for (Month month: Month.values()){
            Row row = createRowWithCells(sheet, month.getDisplayName(TextStyle.FULL_STANDALONE, locale));
            row.getCell(1).setCellValue(0);
        }
    }

    /**  Function for set data in rows.
     *@param sheet - the sheet to insert data
     *@param cellValue - the sheet to insert data
     */
    private Row createRowWithCells(HSSFSheet sheet, String cellValue){
        Row row = sheet.createRow(sheet.getRow(0) == null ? sheet.getLastRowNum() : sheet.getLastRowNum() + 1);
        Cell cell = row.createCell(0);
        cell.setCellValue(cellValue);
        setCellStyle(cell);
        setCellStyle(row.createCell(1));
        return row;
    }

    /**  Function for set type of cell.
     *@param cell - the sheet to insert data
     @return cell
     */
    private Cell setCellStyle(Cell cell){
        CellStyle cellStyle = cell.getCellStyle();
        cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
        cellStyle.setVerticalAlignment(CellStyle.ALIGN_CENTER);
        return cell;
    }
}
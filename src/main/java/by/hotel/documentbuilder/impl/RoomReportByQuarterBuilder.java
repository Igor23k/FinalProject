package by.hotel.documentbuilder.impl;

import by.hotel.bean.Report;
import by.hotel.bean.RoomReport;
import by.hotel.documentbuilder.ExcelDocumentBuilder;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;

import java.util.List;

/**
 * RoomReportByQuarterBuilder.java
 * This class is using to create xls documents.
 * @author Igor Kozlov
 * @version 1.0
 */
public class RoomReportByQuarterBuilder extends ExcelDocumentBuilder<Report> {
    private static final int QUARTER_COUNT = 4;
    private static final int HEADER_ROWS_COUNT = 2;

    public RoomReportByQuarterBuilder(){
        super("Room report by quarter.xls");
    }

    /**
     * Holder.java
     * This internal class is a template Singleton.
     * @author Igor Kozlov
     * @version 1.0
     */
    private static class Holder{
        /**
         * Field - this field need to be singleton of RoomReportByQuarterBuilder class.
         */
        private final static RoomReportByQuarterBuilder INSTANCE = new RoomReportByQuarterBuilder();
    }

    /**
     * Get a singleton object.
     * @return singleton object.
     */
    public static RoomReportByQuarterBuilder getInstance(){
        return RoomReportByQuarterBuilder.Holder.INSTANCE;
    }

    /** Function for insert data in workbook.
     *@param workbook - the document to insert data
     *@param documentData - the data to be insert in workbook
     */
    @Override
    protected void fillDoc(HSSFWorkbook workbook, Report documentData) {
        int currentColumn = 0;
        List<RoomReport> reports = documentData.getData();
        HSSFSheet sheet = workbook.createSheet("Report " + documentData.getYear());
        while(reports.size() > 1){
            Row row = createOrGetRowWithCells(sheet, "Название комнаты:", 0,currentColumn);
            row.getCell(currentColumn + 1).setCellValue(reports.get(0).getRoomName());
            addHeader(sheet, currentColumn);
            addQuarter(sheet, currentColumn);
            fillSheet(sheet, reports, currentColumn);
            sheet.autoSizeColumn(currentColumn);
            sheet.autoSizeColumn(currentColumn + 1);
            currentColumn += 4;
        }
        sheet.createRow(sheet.getLastRowNum() + 1);
        sheet.createRow(sheet.getLastRowNum() + 1);
        setRowForTotal(sheet, reports.get(0).getTotal(), 0);
    }

    /**  Function for insert data in sheet.
     *@param sheet - the sheet to insert data
     *@param reports - the data to be insert in sheet
     *@param column - number of column
     */
    private void fillSheet(HSSFSheet sheet, List<RoomReport> reports, int column) {
        while(reports.get(0).getPeriodNumber() != 0){
            Row row  = sheet.getRow(HEADER_ROWS_COUNT - 1 + reports.get(0).getPeriodNumber());
            row.getCell(column + 1).setCellValue(reports.get(0).getTotal());
            reports.remove(0);
        }
        setRowForTotal(sheet, reports.get(0).getTotal(),column);
        reports.remove(0);
    }

    /**  Function for insert header in sheet.
     *@param sheet - the sheet to insert data
     *@param column - number of column
     */
    private void addHeader(HSSFSheet sheet, int column){
        Row columnTitles = createOrGetRowWithCells(sheet, "Квартал", 1, column);
        columnTitles.getCell(column + 1).setCellValue("Выручка, руб.");
    }

    /**  Function for insert data for quarter.
     *@param sheet - the sheet to insert data
     *@param column - number of column
     */
    private void addQuarter(HSSFSheet sheet, int column){
        for (int i=0; i< QUARTER_COUNT; i++){
            Row row = createOrGetRowWithCells(sheet, (i+1) + "-й квартал", i + HEADER_ROWS_COUNT, column);
            row.getCell(column + 1).setCellValue(0);
        }
        createOrGetRowWithCells(sheet, null, HEADER_ROWS_COUNT + QUARTER_COUNT, column);
        createOrGetRowWithCells(sheet, null, HEADER_ROWS_COUNT + 1 + QUARTER_COUNT, column);
    }

    /**  Function for set data in rows.
     *@param sheet - the sheet to insert data
     *@param cellValue - the sheet to insert data
     */
    private Row createOrGetRowWithCells(HSSFSheet sheet, String cellValue, int rowIndex, int column){
        Row row = sheet.getRow(rowIndex);
        if(row == null) {
            row = sheet.createRow(sheet.getRow(0) == null ? sheet.getLastRowNum() : sheet.getLastRowNum() + 1);
        }
        Cell cell = row.createCell(column);
        cell.setCellValue(cellValue);
        setCellStyle(cell);
        setCellStyle(row.createCell(column + 1));
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

    /**  Function for set type of cell.
     *@param sheet - the sheet to insert data
     *@param value - value of column
     *@param column - number of column
     */
    private void setRowForTotal(HSSFSheet sheet, int value, int column){
        Row row = createOrGetRowWithCells(sheet, "Всего:", sheet.getLastRowNum(),column);
        row.getCell(column + 1).setCellValue(value);
    }
}

package by.hotel.documentbuilder.impl;

import by.hotel.bean.Reservation;
import by.hotel.bean.ReservationRoom;
import by.hotel.documentbuilder.ExcelDocumentBuilder;
import by.hotel.service.exception.ServiceException;
import com.itextpdf.text.DocumentException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;

import java.lang.reflect.Field;
import java.util.List;
/**
 * ReservationRoomReportBuilder.java
 * This class is using to create xls documents.
 * @author Igor Kozlov
 * @version 1.0
 */
public class ReservationRoomReportBuilder extends ExcelDocumentBuilder<List<ReservationRoom>> {
    public ReservationRoomReportBuilder() {
        super("Reservation report for user.xls");
    }

    /**
     * Holder.java
     * This internal class is a template Singleton.
     * @author Igor Kozlov
     * @version 1.0
     */
    private static class Holder{
        /**
         * Field - this field need to be singleton of ReservationRoomReportBuilder class.
         */
        private final static ReservationRoomReportBuilder INSTANCE = new ReservationRoomReportBuilder();
    }

    /**
     * Get a singleton object.
     * @return singleton object.
     */
    public static ReservationRoomReportBuilder getInstance(){
        return ReservationRoomReportBuilder.Holder.INSTANCE;
    }

    /** Function for insert data in workbook.
     *@param workbook - the document to insert data
     *@param documentData - the data to be insert in workbook
     *@throws DocumentException if build document is failed
     */
    @Override
    protected void fillDoc(HSSFWorkbook workbook,List<ReservationRoom> documentData) throws DocumentException  {
        HSSFSheet sheet = workbook.createSheet("Report");
        int columnsCount = addHeader(sheet, documentData.get(0));
        for (ReservationRoom reservationRoom : documentData) {
            fillRow(sheet, reservationRoom.getReservation());
        }
        CellRangeAddress region = new CellRangeAddress(0,0,0,columnsCount);
        sheet.addMergedRegion(region);
        for (int i=0; i< columnsCount; i++){
            sheet.autoSizeColumn(i);
        }
    }
    /**  Function for insert data in sheet.
     *@param sheet - the sheet to insert data
     *@param reservation - the data to be insert in sheet
     *@throws DocumentException if fill row is failed
     */
    private void fillRow(HSSFSheet sheet, Reservation reservation) throws DocumentException {
        Row row = sheet.createRow(sheet.getLastRowNum() + 1);
        setCellStyle(row.createCell(0)).setCellValue(reservation.getId());
        setCellStyle(row.createCell(1)).setCellValue(reservation.getAccepted());
        setCellStyle(row.createCell(2)).setCellValue(reservation.getDateIn());
        setCellStyle(row.createCell(3)).setCellValue(reservation.getDateOut());
        setCellStyle(row.createCell(4)).setCellValue(reservation.getUser().getSurname() + " " + reservation.getUser().getName());
        setCellStyle(row.createCell(5)).setCellValue(reservation.getDiscount().getCountPercentages()+"%");
    }

    /**  Function for insert header in sheet.
     *@param sheet - the sheet to insert data
     *@param reservationRoom - the data to be insert in sheet
     */
    private int addHeader(HSSFSheet sheet, ReservationRoom reservationRoom){
        createRowWithCells(sheet, "Брони пользователя " + reservationRoom.getReservation().getUser().getUserFullname());
        Row row = createRowWithCells(sheet, null);
        Field[] fields = reservationRoom.getReservation().getClass().getDeclaredFields();
        for (int i=0; i< fields.length; i++){
            setCellStyle(row.createCell(i)).setCellValue(fields[i].getName());
        }
        return fields.length - 1;
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

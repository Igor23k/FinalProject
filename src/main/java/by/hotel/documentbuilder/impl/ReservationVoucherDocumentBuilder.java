package by.hotel.documentbuilder.impl;

import by.hotel.bean.ReservationRoom;
import by.hotel.documentbuilder.PdfDocumentBuilder;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * ReservationVoucherDocumentBuilder.java
 * This class is using to create pdf documents.
 * @author Igor Kozlov
 * @version 1.0
 */
public class ReservationVoucherDocumentBuilder extends PdfDocumentBuilder<List<ReservationRoom>>{
    private ReservationVoucherDocumentBuilder(){
        super("/documents/reservation_voucher_blank.pdf", "Reservation voucher.pdf");
    }

    /**
     * Holder.java
     * This internal class is a template Singleton.
     * @author Igor Kozlov
     * @version 1.0
     */
    private static class Holder{
        /**
         * Field - this field need to be singleton of ReservationVoucherDocumentBuilder class.
         */
        private final static ReservationVoucherDocumentBuilder INSTANCE = new ReservationVoucherDocumentBuilder();
    }
    /**
     * Get a singleton object.
     * @return singleton object.
     */
    public static ReservationVoucherDocumentBuilder getInstance(){
        return ReservationVoucherDocumentBuilder.Holder.INSTANCE;
    }

    /**
     * Set fields in form.
     * @param form - the form to insert data
     * @param documentData - value to insert in form
     * @throws DocumentException if insert data is failed
     */
    @Override
    protected void setFields(AcroFields form, List<ReservationRoom> documentData) throws DocumentException{
        try {
            int daysCount = getDaysCount(documentData.get(0).getReservation().getDateIn(),
                    documentData.get(0).getReservation().getDateOut());
            form.setField("reservation_id", Integer.toString(documentData.get(0).getReservation().getId()));
            form.setField("date-in", getTime(documentData.get(0).getReservation().getDateIn()));
            form.setField("date-out", getTime(documentData.get(0).getReservation().getDateOut()));
            form.setField("user_name", documentData.get(0).getReservation().getUser().getUserFullname());
            form.setField("reservation_info", getReservationInfo(documentData, daysCount));
            form.setField("total_cost", getTotalCost(documentData, daysCount));
        }catch (IOException | ParseException e){
            throw new DocumentException(e);
        }
    }

    /**
     * Get time.
     * @param date - the date to get time
     * @return string of date.
     * @throws ParseException if get time is failed
     */
    private String getTime(String date) throws ParseException{
        return new SimpleDateFormat("EEEE, dd MMM yyy").format(new Date(new SimpleDateFormat("yyyy-MM-dd").parse(date).getTime()));
    }

    /**
     * Get info about reservation.
     * @param documentData - array of reservation rooms
     * @param daysCount - count of days
     * @return string of reservation info.
     */
    private String getReservationInfo(List<ReservationRoom> documentData, int daysCount){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getNightTitle(daysCount));
        stringBuilder.append(", ");
        stringBuilder.append(documentData.size() + " номер");
        return stringBuilder.toString();
    }

    /**
     * Get days count.
     * @param dateInStr - date in
     * @param dateOutStr - date out
     * @return count of days.
     */
    private int getDaysCount(String dateInStr, String dateOutStr) throws ParseException{
        long dateInMilsec = new SimpleDateFormat("yyyy-MM-dd").parse(dateInStr).getTime();
        long dateOutMilsec = new SimpleDateFormat("yyyy-MM-dd").parse(dateOutStr).getTime();
        return (int) ((dateOutMilsec - dateInMilsec) / (24 * 60 * 60 * 1000));
    }

    /**
     * Get total cost.
     * @param documentInfo - array of reservation rooms
     * @param daysCount - count of days
     * @return total cost.
     */
    private String getTotalCost(List<ReservationRoom> documentInfo, int daysCount){
        int result = 0;
        for(ReservationRoom reservationRoom: documentInfo){
            result += reservationRoom.getReservation().getAccepted();
            result += reservationRoom.getRoom().getRoomType().getCostPerDay() * daysCount;
        }
        return Integer.toString(result);
    }

    /**
     * Get night title.
     * @param nightCount - count of nights
     * @return header string.
     */
    private String getNightTitle(int nightCount){
        final int mod = nightCount % 10;
        if(nightCount >= 11 && nightCount <= 14){
            return nightCount + " ночей";
        }
        switch (mod){
            case 1: return nightCount + " ночь";
            case 2:
            case 3:
            case 4: return nightCount + " ночи";
            default: return nightCount + " ночей";
        }
    }
}

package by.hotel.documentbuilder.impl;

import by.hotel.bean.Reservation;
import by.hotel.documentbuilder.PdfDocumentBuilder;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;

import java.io.IOException;

/**
 * ReservationConfirmDocumentBuilder.java
 * This class is using to create pdf documents.
 * @author Igor Kozlov
 * @version 1.0
 */
public class ReservationConfirmDocumentBuilder extends PdfDocumentBuilder<Reservation> {
    private ReservationConfirmDocumentBuilder(){
        super("/documents/reservation_confirm_blank.pdf", "Reservation Confirm.pdf");
    }

    /**
     * Holder.java
     * This internal class is a template Singleton.
     * @author Igor Kozlov
     * @version 1.0
     */
    private static class Holder{
        /**
         * Field - this field need to be singleton of FinancialReportByQuarterBuilder class.
         */
        private final static ReservationConfirmDocumentBuilder INSTANCE = new ReservationConfirmDocumentBuilder();
    }

    /**
     * Get a singleton object.
     * @return singleton object.
     */
    public static ReservationConfirmDocumentBuilder getInstance(){
        return Holder.INSTANCE;
    }

    /**
     * Set fields in form.
     * @param form - the form to insert data
     * @param reservation - value to insert in form
     * @throws DocumentException if insert data is failed
     */
    protected void setFields(AcroFields form, Reservation reservation) throws DocumentException{
        try {
            form.setField("addressee", reservation.getUser().getUserFullname());
            form.setField("date", reservation.getDateIn());
            form.setField("appeal", "Уважаемый гость " + reservation.getUser().getUserFullname());
            form.setField("date-in", reservation.getDateIn());
            form.setField("date-out", reservation.getDateOut());
        } catch (IOException e){
            throw new DocumentException(e);
        }

    }
}

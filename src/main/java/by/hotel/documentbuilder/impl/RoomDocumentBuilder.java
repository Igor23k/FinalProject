package by.hotel.documentbuilder.impl;

import by.hotel.bean.Room;
import by.hotel.documentbuilder.PdfDocumentBuilder;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;

import java.io.IOException;

/**
 * RoomDocumentBuilder.java
 * This class is using to create pdf documents.
 * @author Igor Kozlov
 * @version 1.0
 */
public class RoomDocumentBuilder extends PdfDocumentBuilder<Room> {
    private RoomDocumentBuilder(){
        super("/documents/room_blank.pdf", "Room.pdf");
    }

    /**
     * Holder.java
     * This internal class is a template Singleton.
     * @author Igor Kozlov
     * @version 1.0
     */
    private static class Holder{
        /**
         * Field - this field need to be singleton of RoomDocumentBuilder class.
         */
        private final static RoomDocumentBuilder INSTANCE = new RoomDocumentBuilder();
    }

    /**
     * Get a singleton object.
     * @return singleton object.
     */
    public static RoomDocumentBuilder getInstance(){
        return RoomDocumentBuilder.Holder.INSTANCE;
    }


    /**
     * Set fields in form.
     * @param form - the form to insert data
     * @param documentData - value to insert in form
     * @throws DocumentException if insert data is failed
     */
    @Override
    protected void setFields(AcroFields form, Room documentData) throws DocumentException{
        try {
            form.setField("name", documentData.getName());
            form.setField("floor", Integer.toString(documentData.getFloor()));
            form.setField("phone_number", documentData.getPhone());
        }catch (IOException e){
            throw new DocumentException(e);
        }
    }
}

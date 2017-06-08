package by.hotel.documentbuilder.impl;

import by.hotel.bean.RoomType;
import by.hotel.documentbuilder.PdfDocumentBuilder;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;

import java.io.IOException;

/**
 * RoomTypeDocumentBuilder.java
 * This class is using to create pdf documents.
 * @author Igor Kozlov
 * @version 1.0
 */
public class RoomTypeDocumentBuilder extends PdfDocumentBuilder<RoomType> {
    private RoomTypeDocumentBuilder(){
        super("/documents/room_type_blank.pdf", "Room type.pdf");
    }

    /**
     * Holder.java
     * This internal class is a template Singleton.
     * @author Igor Kozlov
     * @version 1.0
     */
    private static class Holder{
        /**
         * Field - this field need to be singleton of RoomTypeDocumentBuilder class.
         */
        private final static RoomTypeDocumentBuilder INSTANCE = new RoomTypeDocumentBuilder();
    }
    /**
     * Get a singleton object.
     * @return singleton object.
     */
    public static RoomTypeDocumentBuilder getInstance(){
        return RoomTypeDocumentBuilder.Holder.INSTANCE;
    }

    /**
     * Set fields in form.
     * @param form - the form to insert data
     * @param documentData - value to insert in form
     * @throws DocumentException if insert data is failed
     */
    @Override
    protected void setFields(AcroFields form, RoomType documentData) throws DocumentException{
        try {
            form.setField("rooms_count", Integer.toString(documentData.getRoomsCount()));
            form.setField("beds_count", Integer.toString(documentData.getBedsCount()));
            form.setField("cost", Float.toString(documentData.getCostPerDay()));
            form.setField("bathrooms_count", Integer.toString(documentData.getBathroomsCount()));
            form.setField("size", Integer.toString(documentData.getSize()));
        }catch (IOException e){
            throw new DocumentException(e);
        }
    }
}

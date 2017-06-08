package by.hotel.documentbuilder.impl;

import by.hotel.bean.User;
import by.hotel.documentbuilder.PdfDocumentBuilder;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;

import java.io.IOException;

/**
 * UserDocumentBuilder.java
 * This class is using to create pdf documents.
 * @author Igor Kozlov
 * @version 1.0
 */
public class UserDocumentBuilder extends PdfDocumentBuilder<User> {
    private UserDocumentBuilder(){
        super("/documents/user_blank.pdf", "User.pdf");
    }

    /**
     * Holder.java
     * This internal class is a template Singleton.
     * @author Igor Kozlov
     * @version 1.0
     */
    private static class Holder{
        /**
         * Field - this field need to be singleton of UserDocumentBuilder class.
         */
        private final static UserDocumentBuilder INSTANCE = new UserDocumentBuilder();
    }
    /**
     * Get a singleton object.
     * @return singleton object.
     */
    public static UserDocumentBuilder getInstance(){
        return UserDocumentBuilder.Holder.INSTANCE;
    }
    /**
     * Set fields in form.
     * @param form - the form to insert data
     * @param documentData - value to insert in form
     * @throws DocumentException if insert data is failed
     */
    @Override
    protected void setFields(AcroFields form, User documentData) throws DocumentException{
        try {
            form.setField("name", documentData.getName());
            form.setField("surname", documentData.getSurname());
            form.setField("email", documentData.getEmail());
            form.setField("mobile_phone", documentData.getMobilePhone());
            form.setField("login", documentData.getLogin());
        }catch (IOException e){
            throw new DocumentException(e);
        }
    }
}

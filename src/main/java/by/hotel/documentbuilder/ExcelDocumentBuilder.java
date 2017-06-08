package by.hotel.documentbuilder;

import by.hotel.bean.DocumentObject;
import by.hotel.service.exception.ServiceException;
import com.itextpdf.text.DocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * ExcelDocumentBuilder.java
 * This class is using to create excel documents.
 * @author Igor Kozlov
 * @version 1.0
 */
public abstract class ExcelDocumentBuilder<T> implements DocumentBuilder<T>{
    /**
     * Field -  field to store document name.
     */
    private final String DOCUMENT_NAME;
    /**
     * Field -  field to store type of document.
     */
    private final static String MIME_TYPE = "application/vnd.ms-excel";

    /** Create new object
     * @param filename - name of document
     */
    public ExcelDocumentBuilder(String filename){
        DOCUMENT_NAME = filename;
    }

    /**  Function for build excel document
     *@param documentData - the data to be set in document
     *@return excel document
     *@throws ServiceException if build document is failed
     */
    public final DocumentObject buildDocument(T documentData) throws ServiceException {
        DocumentObject documentObject;
        try(
            HSSFWorkbook workbook = new HSSFWorkbook();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()){
            fillDoc(workbook, documentData);
            workbook.write(byteArrayOutputStream);
            documentObject = fillDocumentObject(byteArrayOutputStream);
        }catch (IOException | DocumentException e){
            throw new ServiceException(e);
        }
        return documentObject;
    }

    /**  Function for insert data in document.
     *@param byteArrayOutputStream - the bytes to be insert in document
     *@return document object
     */
    private DocumentObject fillDocumentObject(ByteArrayOutputStream byteArrayOutputStream){
        DocumentObject documentObject = new DocumentObject();
        documentObject.setDocumentName(DOCUMENT_NAME);
        documentObject.setMimeType(MIME_TYPE);
        documentObject.setDocumentBytes(byteArrayOutputStream.toByteArray());
        return documentObject;
    }
    /**  Abstract function for insert data in workbook.
     *@param workbook - the document to insert data
     *@param documentData - the data to be insert in workbook
     *@throws DocumentException if build document is failed
     */
    protected abstract void fillDoc(HSSFWorkbook workbook, T documentData) throws DocumentException;
}

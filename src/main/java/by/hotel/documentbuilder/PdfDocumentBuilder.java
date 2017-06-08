package by.hotel.documentbuilder;

import by.hotel.bean.DocumentObject;
import by.hotel.service.exception.ServiceException;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import org.apache.log4j.Logger;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * PdfDocumentBuilder.java
 * This class is using to create pdf documents.
 * @author Igor Kozlov
 * @version 1.0
 */
public abstract class PdfDocumentBuilder<T> implements DocumentBuilder<T> {
    /**
     * Field -  field to store document name.
     */
    private final String TEMPLATE_PATH, DOCUMENT_NAME;
    /**
     * Field -  field to store type of document.
     */
    private final static String MIME_TYPE = "application/pdf";
    /**
     * It is a logger which print some messages to log file.
     */
    private static final Logger logger = Logger.getLogger(PdfDocumentBuilder.class);

    /** Create new object
     * @param templatePath - path to pdf template
     * @param documentName - name of document
     */
    public PdfDocumentBuilder(String templatePath, String documentName){
        TEMPLATE_PATH = templatePath;
        DOCUMENT_NAME = documentName;
    }

    /**  Function for build pdf document
     *@param documentData - the data to be set in document
     *@return csv document
     *@throws ServiceException if build document is failed
     */
    public final DocumentObject buildDocument(T documentData) throws ServiceException {
        DocumentObject documentObject = null;
        PdfReader pdfReader = null;
        PdfStamper pdfStamper = null;
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try{
            pdfReader = new PdfReader(classLoader.getResourceAsStream(TEMPLATE_PATH));
            pdfStamper = new PdfStamper(pdfReader, byteArrayOutputStream);
            pdfStamper.setFormFlattening(true);
            final BaseFont baseFont = BaseFont.createFont("c:\\Windows\\Fonts\\arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            final AcroFields form = pdfStamper.getAcroFields();
            form.addSubstitutionFont(baseFont);
            setFields(form, documentData);
        }catch (IOException | DocumentException e){
            throw new ServiceException(e);
        }finally {
            try {
                if(pdfStamper != null){
                    pdfStamper.close();
                    documentObject = fillDocumentObject(byteArrayOutputStream);
                    byteArrayOutputStream.close();
                }
            }catch (DocumentException | IOException e){
                logger.error(e);
            }finally {
                if (pdfReader != null){
                    pdfReader.close();
                }
            }
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

    /**  Abstract function for insert data in pdf document.
     *@param form - the for to insert data
     *@param documentData - the data to be insert in form
     *@throws DocumentException if fill document is failed
     */
    protected abstract void setFields(AcroFields form, T documentData) throws DocumentException;
}

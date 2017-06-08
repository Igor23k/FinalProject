package by.hotel.documentbuilder;

import by.hotel.bean.DocumentObject;
import by.hotel.service.exception.ServiceException;
import org.apache.log4j.Logger;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.constraint.Unique;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.List;

/**
 * CsvDocumentBuilder.java
 * This class is using to create csv documents.
 * @author Igor Kozlov
 * @version 1.0
 */
public class CsvDocumentBuilder<T extends List<?>> implements DocumentBuilder<T>{
    /**
     * Field -  field to store document name.
     */
    private final String DOCUMENT_NAME;
    /**
     * Field -  field to store type of document.
     */
    private final static String MIME_TYPE = "text/csv";
    /**
     * It is a logger which print some messages to log file.
     */
    private static final Logger logger = Logger.getLogger(CsvDocumentBuilder.class);

    /** Create new object
     * @param name - name of document
     */
    public CsvDocumentBuilder(String name){
        DOCUMENT_NAME = name;
    }

    /**  Function for build csv document
     *@param documentData - the data to be set in document
     *@return csv document
     *@throws ServiceException if build document is failed
     */
    public final DocumentObject buildDocument(T documentData) throws ServiceException {
        DocumentObject documentObject = null;
        StringWriter writer = new StringWriter();
        ICsvBeanWriter csvBeanWriter = new CsvBeanWriter(writer, CsvPreference.STANDARD_PREFERENCE);
        try {
            String[] headers = getHeaders(documentData.get(0));
            csvBeanWriter.writeHeader(headers);
            for(Object item: documentData){
                csvBeanWriter.write(item, headers, getProcessors(item));
            }
        }catch (IOException e){
            throw new ServiceException(e);
        }finally {
            try {
                if(csvBeanWriter != null){
                    csvBeanWriter.close();
                    documentObject = fillDocumentObject(writer.toString().getBytes());
                }
            }catch (IOException e){
                logger.error(e);
            }finally {
                try {
                    writer.close();
                }catch (IOException e){
                    logger.error(e);
                }
            }
        }
        return documentObject;
    }
    /**  Function for get headers from item
     *@param item - the item with headers
     *@return array of headers
     */
    private String[] getHeaders(Object item){
        Field[] fields = item.getClass().getDeclaredFields();
        String[] headers = new String[fields.length];
        for (int i=0; i < headers.length; i++){
            headers[i] = fields[i].getName();
        }
        return headers;
    }

    /**  Function for get processors to cells.
     *@param item - the item with headers
     *@return array cell processors
     */
    private CellProcessor[] getProcessors(Object item){
        Field[] fields = item.getClass().getDeclaredFields();
        CellProcessor[] cellProcessors = new CellProcessor[fields.length];
        cellProcessors[0] = new Unique();
        for (int i=1; i < cellProcessors.length; i++){
            cellProcessors[i] = new Optional();
        }
        return cellProcessors;
    }

    /**  Function for insert data in document.
     *@param bytes - the bytes to be insert in document
     *@return document object
     */
    private DocumentObject fillDocumentObject(byte[] bytes){
        DocumentObject documentObject = new DocumentObject();
        documentObject.setDocumentName(DOCUMENT_NAME);
        documentObject.setMimeType(MIME_TYPE);
        documentObject.setDocumentBytes(bytes);
        return documentObject;
    }
}

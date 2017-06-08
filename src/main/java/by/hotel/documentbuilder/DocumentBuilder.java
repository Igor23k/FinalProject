package by.hotel.documentbuilder;

import by.hotel.bean.DocumentObject;
import by.hotel.service.exception.ServiceException;

/**
 * DocumentBuilder.java
 * Simple build document operation.
 * @author Igor Kozlov
 * @version 1.0
 */
public interface DocumentBuilder<T> {
    /**
     * Build document.
     * @param documentData the operand to to set in document.
     * @return DocumentObject.
     * @throws ServiceException if build document is failed
     */
    DocumentObject buildDocument(T documentData) throws ServiceException;
}
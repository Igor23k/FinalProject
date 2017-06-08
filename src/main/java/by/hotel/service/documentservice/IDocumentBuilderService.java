package by.hotel.service.documentservice;

import by.hotel.bean.DocumentObject;
import by.hotel.service.exception.ServiceException;

import java.util.Map;

/**
 * IDocumentBuilderService.java
 * Simple build document operation.
 * @author Igor Kozlov
 * @version 1.0
 */
public interface IDocumentBuilderService {
    /**
     * Build document.
     * @param documentInfo  the data to create document.
     * @return document.
     * @throws ServiceException if build document is failed
     */
    DocumentObject buildDocument(Map<String, String[]> documentInfo) throws ServiceException;
}




















































































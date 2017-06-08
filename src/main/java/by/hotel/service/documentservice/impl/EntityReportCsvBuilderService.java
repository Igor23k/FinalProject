package by.hotel.service.documentservice.impl;

import by.hotel.bean.DocumentObject;
import by.hotel.documentbuilder.CsvDocumentBuilder;
import by.hotel.documentbuilder.DocumentBuilder;
import by.hotel.service.CrudServiceMapper;
import by.hotel.service.ICrudService;
import by.hotel.service.documentservice.IDocumentBuilderService;
import by.hotel.service.exception.ServiceException;

import java.util.List;
import java.util.Map;

/**
 * EntityReportCsvBuilderService.java
 * Simple build document operation.
 * @author Igor Kozlov
 * @version 1.0
 */
public class EntityReportCsvBuilderService implements IDocumentBuilderService {
    /**
     * Build document.
     * @param documentInfo  the data to create document.
     * @return document.
     * @throws ServiceException if build document is failed
     */
    @Override
    public DocumentObject buildDocument(Map<String, String[]> documentInfo) throws ServiceException {
        ICrudService service =  CrudServiceMapper.getService(documentInfo.get("entity")[0]);
        List<?> resultList = service.getAllEntities();
        DocumentBuilder<List<?>> documentBuilder = new CsvDocumentBuilder<>(documentInfo.get("entity")[0].concat(" report.csv"));
        return documentBuilder.buildDocument(resultList);
    }
}

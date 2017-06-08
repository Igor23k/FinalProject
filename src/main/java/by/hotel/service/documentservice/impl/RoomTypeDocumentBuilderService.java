package by.hotel.service.documentservice.impl;

import by.hotel.bean.DocumentObject;
import by.hotel.bean.RoomType;
import by.hotel.documentbuilder.DocumentBuilder;
import by.hotel.documentbuilder.impl.RoomTypeDocumentBuilder;
import by.hotel.service.documentservice.IDocumentBuilderService;
import by.hotel.service.exception.ServiceException;
import by.hotel.service.impl.RoomTypeServiceImpl;

import java.util.Map;
/**
 * RoomTypeDocumentBuilderService.java
 * Simple build document operation.
 * @author Igor Kozlov
 * @version 1.0
 */
public class RoomTypeDocumentBuilderService implements IDocumentBuilderService {
    /**
     * Build document.
     * @param documentInfo the data to create document.
     * @return document.
     * @throws ServiceException if build document is failed
     */
    @Override
    public DocumentObject buildDocument(Map<String, String[]> documentInfo) throws ServiceException {
        RoomType roomType = new RoomTypeServiceImpl().getEntity(Integer.parseInt(documentInfo.get("id")[0]));
        if(roomType != null) {
            DocumentBuilder roomTypeDocumentBuilder = RoomTypeDocumentBuilder.getInstance();
            return roomTypeDocumentBuilder.buildDocument(roomType);
        }
        return null;
    }
}

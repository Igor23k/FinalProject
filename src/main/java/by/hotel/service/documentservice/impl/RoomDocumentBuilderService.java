package by.hotel.service.documentservice.impl;

import by.hotel.bean.DocumentObject;
import by.hotel.bean.Room;
import by.hotel.documentbuilder.DocumentBuilder;
import by.hotel.documentbuilder.impl.RoomDocumentBuilder;
import by.hotel.service.documentservice.IDocumentBuilderService;
import by.hotel.service.exception.ServiceException;
import by.hotel.service.impl.RoomServiceImpl;

import java.util.Map;
/**
 * RoomDocumentBuilderService.java
 * Simple build document operation.
 * @author Igor Kozlov
 * @version 1.0
 */
public class RoomDocumentBuilderService implements IDocumentBuilderService {
    /**
     * Build document.
     * @param documentInfo the data to create document.
     * @return document.
     * @throws ServiceException if build document is failed
     */
    @Override
    public DocumentObject buildDocument(Map<String, String[]> documentInfo) throws ServiceException {
        Room room = new RoomServiceImpl().getEntity(Integer.parseInt(documentInfo.get("id")[0]));
        if(room != null) {
            DocumentBuilder roomDocumentBuilder = RoomDocumentBuilder.getInstance();
            return roomDocumentBuilder.buildDocument(room);
        }
        return null;
    }
}

package by.hotel.service.documentservice.impl;

import by.hotel.bean.DocumentObject;
import by.hotel.bean.ReservationRoom;
import by.hotel.documentbuilder.DocumentBuilder;
import by.hotel.documentbuilder.impl.ReservationRoomReportBuilder;
import by.hotel.service.documentservice.IDocumentBuilderService;
import by.hotel.service.exception.ServiceException;
import by.hotel.service.impl.ReservationRoomServiceImpl;

import java.util.List;
import java.util.Map;
/**
 * ReservationReportBuilderService.java
 * Simple build document operation.
 * @author Igor Kozlov
 * @version 1.0
 */
public class ReservationReportBuilderService implements IDocumentBuilderService {
    @Override
    public DocumentObject buildDocument(Map<String, String[]> documentInfo) throws ServiceException {
        List<ReservationRoom> reservationRoomList = new ReservationRoomServiceImpl().getReservationRoomByUser(Integer.parseInt(documentInfo.get("id")[0]));
        if(reservationRoomList != null){
            DocumentBuilder documentBuilder = ReservationRoomReportBuilder.getInstance();
            return documentBuilder.buildDocument(reservationRoomList);
        }
        return null;
    }
}

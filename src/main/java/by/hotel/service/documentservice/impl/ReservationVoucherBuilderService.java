package by.hotel.service.documentservice.impl;

import by.hotel.bean.DocumentObject;
import by.hotel.bean.ReservationRoom;
import by.hotel.documentbuilder.DocumentBuilder;
import by.hotel.documentbuilder.impl.ReservationVoucherDocumentBuilder;
import by.hotel.service.documentservice.IDocumentBuilderService;
import by.hotel.service.exception.ServiceException;
import by.hotel.service.impl.ReservationRoomServiceImpl;

import java.util.List;
import java.util.Map;
/**
 * ReservationVoucherBuilderService.java
 * Simple build document operation.
 * @author Igor Kozlov
 * @version 1.0
 */
public class ReservationVoucherBuilderService implements IDocumentBuilderService {
    /**
     * Build document.
     * @param documentInfo the data to create document.
     * @return document.
     * @throws ServiceException if build document is failed
     */
    @Override
    public DocumentObject buildDocument(Map<String, String[]> documentInfo) throws ServiceException {
        List<ReservationRoom> reservationRooms = new ReservationRoomServiceImpl()
                .getReservationRoomByReservation(Integer.parseInt(documentInfo.get("id")[0]));
        if(reservationRooms != null){
            DocumentBuilder documentBuilder = ReservationVoucherDocumentBuilder.getInstance();
            return documentBuilder.buildDocument(reservationRooms);
        }
        return null;
    }
}

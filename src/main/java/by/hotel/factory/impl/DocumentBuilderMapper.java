package by.hotel.factory.impl;

import by.hotel.factory.IDocumentBuilderServiceFactory;
import by.hotel.service.documentservice.IDocumentBuilderService;
import by.hotel.service.documentservice.impl.*;

import java.util.HashMap;
import java.util.Map;

/**
 * DocumentBuilderMapper.java
 * Class implements methods from interface IDocumentBuilderServiceFactory.
 * getInstance - method to get command  that implements IDocumentBuilderServiceFactory interface.
 * @author Igor Kozlov
 * @version 2.0
 */
public final class DocumentBuilderMapper implements IDocumentBuilderServiceFactory {

    /**
     * Field -  field to store builders.
     */
    final private static Map<String, IDocumentBuilderService> builderMap = new HashMap();

    static {
        builderMap.put("RESERVATION_CONFIRM", new ReservationConfirmDocumentBuilderService());
        builderMap.put("FINANCIAL_REPORT", new FinancialReportBuilderService());
        builderMap.put("ROOM_REPORT", new RoomReportBuilderService());
        builderMap.put("RESERVATION_REPORT", new ReservationReportBuilderService());
        builderMap.put("ENTITY_CSV_REPORT", new EntityReportCsvBuilderService());
        builderMap.put("RESERVATION_VOUCHER", new ReservationVoucherBuilderService());
        builderMap.put("ROOM_DOCUMENT", new RoomDocumentBuilderService());
        builderMap.put("USER_DOCUMENT", new UserDocumentBuilderService());
        builderMap.put("ROOM_TYPE_DOCUMENT", new RoomTypeDocumentBuilderService());
    }

    /**
     * Holder.java
     * This internal class is a template Singleton.
     * @author Igor Kozlov
     * @version 1.0
     */
    private static class Holder{
        /**
         * Field - this field need to be singleton of DocumentBuilderMapper class.
         */
        private final static DocumentBuilderMapper INSTANCE = new DocumentBuilderMapper();
    }

    /**
     * Get a singleton object.
     * @return singleton object.
     */
    public static DocumentBuilderMapper getInstance(){
        return Holder.INSTANCE;
    }

    /**
     * Get a document builder by name.
     * @param documentName the operand to get a builer.
     * @return builder that implements interface IDocumentBuilderService.
     */
    public IDocumentBuilderService getDocumentBuilderService(String documentName) {
        return builderMap.get(documentName.toUpperCase());
    }
}

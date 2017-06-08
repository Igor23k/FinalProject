package by.hotel.factory;

import by.hotel.service.documentservice.IDocumentBuilderService;

/**
 * IDocumentBuilderServiceFactory.java
 * Simple get document builder class.
 * @author Igor Kozlov
 * @version 1.0
 */
public interface IDocumentBuilderServiceFactory {
    /**
     * Get a document builder.
     * @param documentName the operand to find an document builder.
     * @return command that implements interface IDocumentBuilderServiceFactory.
     */
    IDocumentBuilderService getDocumentBuilderService(String documentName);
}

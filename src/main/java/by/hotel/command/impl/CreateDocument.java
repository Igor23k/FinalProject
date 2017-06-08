package by.hotel.command.impl;

import by.hotel.bean.DocumentObject;
import by.hotel.command.ICommand;
import by.hotel.command.exception.CommandException;
import by.hotel.factory.impl.DocumentBuilderMapper;
import by.hotel.service.documentservice.IDocumentBuilderService;
import by.hotel.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * CreateDocument.java
 * Class implements methods from interface ICommand.
 * Execute - simple command operation.
 * sendDocument - method to send document to user.
 * @author Igor Kozlov
 * @version 3.0
 */
public class CreateDocument implements ICommand {
    /**
     * Function for getting all entities
     * @param request the operand to use for getting values.
     * @param response the operand to use for sending values.
     * @return document
     * @throws CommandException if create document is failed
     */
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
        Map<String, String[]> requestParams = request.getParameterMap();
        DocumentObject documentObject;
        try {
            DocumentBuilderMapper documentBuilderMapper = DocumentBuilderMapper.getInstance();
            IDocumentBuilderService documentBuilderService = documentBuilderMapper.getDocumentBuilderService(requestParams.get("docname")[0]);
            documentObject = documentBuilderService.buildDocument(requestParams);
            sendDocument(response, documentObject);
        }catch (ServiceException | IOException  e){
            throw new CommandException(e);
        }
        return documentObject;
    }

    /**
     * Function for send document
     * @param documentObject the bean to be send
     * @param response the operand to use for sending document.
     * @throws IOException if sending document is failed
     */
    private void sendDocument(HttpServletResponse response, DocumentObject documentObject) throws IOException{
        if(documentObject != null){
            response.setContentType(documentObject.getMimeType());
            response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", documentObject.getDocumentName()));
            response.getOutputStream().write(documentObject.getDocumentBytes());
            response.getOutputStream().close();
        }
    }
}
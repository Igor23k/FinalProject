package by.hotel.service.exception;

/**
 * IncorrectUserSurnameException.java
 * Class extends Exception class and override his methods.
 * @author Igor Kozlov
 * @version 1.0
 */
public class ServiceException extends Exception {
    private static final long serialVersionUID = 1L;
    public ServiceException(){
    }

    public ServiceException(Exception e){
        super(e);
    }

    public ServiceException(String message){
        super(message);
    }

    public ServiceException(String message, Exception e){
        super(message, e);
    }
}

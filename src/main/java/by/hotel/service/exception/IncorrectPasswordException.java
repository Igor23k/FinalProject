package by.hotel.service.exception;

/**
 * IncorrectPasswordException.java
 * Class extends Exception class and override his methods.
 * @author Igor Kozlov
 * @version 1.0
 */
public class IncorrectPasswordException extends Exception{
    private static final long serialVersionUID = 1L;
    public IncorrectPasswordException(){
    }

    public IncorrectPasswordException(Exception e){
        super(e);
    }

    public IncorrectPasswordException(String message){
        super(message);
    }

    public IncorrectPasswordException(String message, Exception e){
        super(message, e);
    }
}

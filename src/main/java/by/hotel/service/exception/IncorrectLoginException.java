package by.hotel.service.exception;

/**
 * IncorrectLoginException.java
 * Class extends Exception class and override his methods.
 * @author Igor Kozlov
 * @version 1.0
 */
public class IncorrectLoginException extends Exception{
    private static final long serialVersionUID = 1L;
    public IncorrectLoginException(){
    }

    public IncorrectLoginException(Exception e){
        super(e);
    }

    public IncorrectLoginException(String message){
        super(message);
    }

    public IncorrectLoginException(String message, Exception e){
        super(message, e);
    }
}

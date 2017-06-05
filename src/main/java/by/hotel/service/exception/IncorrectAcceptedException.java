package by.hotel.service.exception;

/**
 * IncorrectAcceptedException.java
 * Class extends Exception class and override his methods.
 * @author Igor Kozlov
 * @version 1.0
 */
public class IncorrectAcceptedException extends Exception {
    private static final long serialVersionUID = 1L;
    public IncorrectAcceptedException(){
    }

    public IncorrectAcceptedException(Exception e){
        super(e);
    }

    public IncorrectAcceptedException(String message){
        super(message);
    }

    public IncorrectAcceptedException(String message, Exception e){
        super(message, e);
    }
}

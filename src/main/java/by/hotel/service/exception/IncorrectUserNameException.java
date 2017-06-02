package by.hotel.service.exception;

/**
 * IncorrectUserEmailException.java
 * Class extends Exception class and override his methods.
 * @author Igor Kozlov
 * @version 1.0
 */
public class IncorrectUserNameException extends Exception{
    private static final long serialVersionUID = 1L;
    public IncorrectUserNameException(){
    }

    public IncorrectUserNameException(Exception e){
        super(e);
    }

    public IncorrectUserNameException(String message){
        super(message);
    }

    public IncorrectUserNameException(String message, Exception e){
        super(message, e);
    }
}

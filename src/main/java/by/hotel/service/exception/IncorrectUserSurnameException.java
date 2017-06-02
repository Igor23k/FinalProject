package by.hotel.service.exception;

/**
 * IncorrectUserSurnameException.java
 * Class extends Exception class and override his methods.
 * @author Igor Kozlov
 * @version 1.0
 */
public class IncorrectUserSurnameException extends Exception{
    private static final long serialVersionUID = 1L;
    public IncorrectUserSurnameException(){
    }

    public IncorrectUserSurnameException(Exception e){
        super(e);
    }

    public IncorrectUserSurnameException(String message){
        super(message);
    }

    public IncorrectUserSurnameException(String message, Exception e){
        super(message, e);
    }
}

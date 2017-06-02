package by.hotel.service.exception;

/**
 * IncorrectPassportNumberException.java
 * Class extends Exception class and override his methods.
 * @author Igor Kozlov
 * @version 1.0
 */
public class IncorrectPassportNumberException extends Exception{
    private static final long serialVersionUID = 1L;
    public IncorrectPassportNumberException(){
    }

    public IncorrectPassportNumberException(Exception e){
        super(e);
    }

    public IncorrectPassportNumberException(String message){
        super(message);
    }

    public IncorrectPassportNumberException(String message, Exception e){
        super(message, e);
    }
}

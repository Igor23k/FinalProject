package by.hotel.service.exception;

/**
 * IncorrectMobilePhoneException.java
 * Class extends Exception class and override his methods.
 * @author Igor Kozlov
 * @version 1.0
 */
public class IncorrectMobilePhoneException extends Exception{
    private static final long serialVersionUID = 1L;
    public IncorrectMobilePhoneException(){
    }

    public IncorrectMobilePhoneException(Exception e){
        super(e);
    }

    public IncorrectMobilePhoneException(String message){
        super(message);
    }

    public IncorrectMobilePhoneException(String message, Exception e){
        super(message, e);
    }
}

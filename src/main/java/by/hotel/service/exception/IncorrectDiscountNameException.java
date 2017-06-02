package by.hotel.service.exception;

/**
 * IncorrectDiscountNameException.java
 * Class extends Exception class and override his methods.
 * @author Igor Kozlov
 * @version 1.0
 */
public class IncorrectDiscountNameException extends Exception {
    private static final long serialVersionUID = 1L;
    public IncorrectDiscountNameException(){
    }

    public IncorrectDiscountNameException(Exception e){
        super(e);
    }

    public IncorrectDiscountNameException(String message){
        super(message);
    }

    public IncorrectDiscountNameException(String message, Exception e){
        super(message, e);
    }
}

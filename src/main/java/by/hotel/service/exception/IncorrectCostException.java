package by.hotel.service.exception;

/**
 * IncorrectCostException.java
 * Class extends Exception class and override his methods.
 * @author Igor Kozlov
 * @version 1.0
 */
public class IncorrectCostException extends Exception {
    private static final long serialVersionUID = 1L;
    public IncorrectCostException(){
    }

    public IncorrectCostException(Exception e){
        super(e);
    }

    public IncorrectCostException(String message){
        super(message);
    }

    public IncorrectCostException(String message, Exception e){
        super(message, e);
    }
}

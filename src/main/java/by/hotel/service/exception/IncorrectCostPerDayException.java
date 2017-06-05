package by.hotel.service.exception;

/**
 * IncorrectCostPerDayException.java
 * Class extends Exception class and override his methods.
 * @author Igor Kozlov
 * @version 1.0
 */
public class IncorrectCostPerDayException extends Exception {
    private static final long serialVersionUID = 1L;
    public IncorrectCostPerDayException(){
    }

    public IncorrectCostPerDayException(Exception e){
        super(e);
    }

    public IncorrectCostPerDayException(String message){
        super(message);
    }

    public IncorrectCostPerDayException(String message, Exception e){
        super(message, e);
    }
}

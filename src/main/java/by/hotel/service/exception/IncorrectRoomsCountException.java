package by.hotel.service.exception;

/**
 * IncorrectRoomsCountException.java
 * Class extends Exception class and override his methods.
 * @author Igor Kozlov
 * @version 1.0
 */
public class IncorrectRoomsCountException extends Exception{
    private static final long serialVersionUID = 1L;
    public IncorrectRoomsCountException(){
    }

    public IncorrectRoomsCountException(Exception e){
        super(e);
    }

    public IncorrectRoomsCountException(String message){
        super(message);
    }

    public IncorrectRoomsCountException(String message, Exception e){
        super(message, e);
    }
}

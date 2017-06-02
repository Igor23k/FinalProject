package by.hotel.service.exception;

/**
 * IncorrectRoomSizeException.java
 * Class extends Exception class and override his methods.
 * @author Igor Kozlov
 * @version 1.0
 */
public class IncorrectRoomSizeException extends Exception{
    private static final long serialVersionUID = 1L;
    public IncorrectRoomSizeException(){
    }

    public IncorrectRoomSizeException(Exception e){
        super(e);
    }

    public IncorrectRoomSizeException(String message){
        super(message);
    }

    public IncorrectRoomSizeException(String message, Exception e){
        super(message, e);
    }
}

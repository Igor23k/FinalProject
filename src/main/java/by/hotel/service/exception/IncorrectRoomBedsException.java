package by.hotel.service.exception;

/**
 * IncorrectRoomBedsException.java
 * Class extends Exception class and override his methods.
 * @author Igor Kozlov
 * @version 1.0
 */
public class IncorrectRoomBedsException extends Exception{
    private static final long serialVersionUID = 1L;
    public IncorrectRoomBedsException(){
    }

    public IncorrectRoomBedsException(Exception e){
        super(e);
    }

    public IncorrectRoomBedsException(String message){
        super(message);
    }

    public IncorrectRoomBedsException(String message, Exception e){
        super(message, e);
    }
}

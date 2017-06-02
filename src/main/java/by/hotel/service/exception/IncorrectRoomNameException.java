package by.hotel.service.exception;

/**
 * IncorrectRoomNameException.java
 * Class extends Exception class and override his methods.
 * @author Igor Kozlov
 * @version 1.0
 */
public class IncorrectRoomNameException  extends Exception{
    private static final long serialVersionUID = 1L;
    public IncorrectRoomNameException(){
    }

    public IncorrectRoomNameException(Exception e){
        super(e);
    }

    public IncorrectRoomNameException(String message){
        super(message);
    }

    public IncorrectRoomNameException(String message, Exception e){
        super(message, e);
    }
}

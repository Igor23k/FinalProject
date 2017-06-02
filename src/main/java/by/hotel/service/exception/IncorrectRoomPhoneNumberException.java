package by.hotel.service.exception;

/**
 * IncorrectRoomPhoneNumberException.java
 * Class extends Exception class and override his methods.
 * @author Igor Kozlov
 * @version 1.0
 */
public class IncorrectRoomPhoneNumberException extends Exception{
    private static final long serialVersionUID = 1L;
    public IncorrectRoomPhoneNumberException(){
    }

    public IncorrectRoomPhoneNumberException(Exception e){
        super(e);
    }

    public IncorrectRoomPhoneNumberException(String message){
        super(message);
    }

    public IncorrectRoomPhoneNumberException(String message, Exception e){
        super(message, e);
    }
}

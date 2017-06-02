package by.hotel.service.exception;

/**
 * IncorrectRightRoleException.java
 * Class extends Exception class and override his methods.
 * @author Igor Kozlov
 * @version 1.0
 */
public class IncorrectRightRoleException extends Exception{
    private static final long serialVersionUID = 1L;
    public IncorrectRightRoleException(){
    }

    public IncorrectRightRoleException(Exception e){
        super(e);
    }

    public IncorrectRightRoleException(String message){
        super(message);
    }

    public IncorrectRightRoleException(String message, Exception e){
        super(message, e);
    }
}

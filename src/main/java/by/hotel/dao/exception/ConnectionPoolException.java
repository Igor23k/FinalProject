package by.hotel.dao.exception;

/**
 * ConnectionPoolException.java
 * This exception appears in ConnectionPool class
 *
 * @author Igor Kozlov
 */
public class ConnectionPoolException extends Exception {

    private static final long serialVersionUID = 8555125592745246274L;

    public ConnectionPoolException(String message) {
        super(message);

    }

    public ConnectionPoolException(String message, Throwable e) {
        super(message, e);
    }

    public ConnectionPoolException(Throwable e) {
        super(e);
    }
}

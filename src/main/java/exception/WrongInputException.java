package exception;

/**
 *
 * @author paveldvoryak
 * @version 1.0
 */

public class WrongInputException extends RuntimeException {
    public WrongInputException(String message) {
        super(message);
    }
}

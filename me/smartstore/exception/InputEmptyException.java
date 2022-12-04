package smartstore.exception;

public class InputEmptyException extends RuntimeException {
    public InputEmptyException() {
        super("Invalid Input. Please try again.");
    }

    public InputEmptyException(String message) {
        super(message);
    }
}


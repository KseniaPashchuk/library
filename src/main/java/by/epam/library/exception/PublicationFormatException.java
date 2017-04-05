package by.epam.library.exception;

/**
 * Created by Ксюша on 30.03.2017.
 */
public class PublicationFormatException extends Exception {
    public PublicationFormatException() {
        super();
    }

    public PublicationFormatException(String message) {
        super(message);
    }

    public PublicationFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public PublicationFormatException(Throwable cause) {
        super(cause);
    }
}

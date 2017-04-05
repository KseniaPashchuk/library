package by.epam.library.exception;


public class PublicationLogicException extends Exception{
    public PublicationLogicException() {
        super();
    }

    public PublicationLogicException(String message) {
        super(message);
    }

    public PublicationLogicException(String message, Throwable cause) {
        super(message, cause);
    }

    public PublicationLogicException(Throwable cause) {
        super(cause);
    }
}

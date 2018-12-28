package ua.nure.stepanenko.SummaryTask4.exception;

/**
 * Created by eugen on 03.01.2017.
 */
public class AppException extends Exception {
//commit1
    public AppException() {
        super();
    }

    public AppException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppException(String message) {
        super(message);
    }
}

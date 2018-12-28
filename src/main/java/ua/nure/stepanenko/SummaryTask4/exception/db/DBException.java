package ua.nure.stepanenko.SummaryTask4.exception.db;

import ua.nure.stepanenko.SummaryTask4.exception.AppException;

/**
 * Created by eugen on 21.05.2017.
 */
public class DBException extends AppException {

    public DBException(String message, Throwable cause) {
        super(message, cause);
    }
}

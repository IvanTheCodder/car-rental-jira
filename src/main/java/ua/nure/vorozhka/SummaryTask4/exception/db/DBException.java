package ua.nure.vorozhka.SummaryTask4.exception.db;

import ua.nure.vorozhka.SummaryTask4.exception.AppException;

/**
 * Created by Stanislav on 21.05.2017.
 */
public class DBException extends AppException {

    public DBException(String message, Throwable cause) {
        super(message, cause);
    }
}

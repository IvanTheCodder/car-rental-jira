package ua.nure.vorozhka.SummaryTask4.exception.validate.user;

import ua.nure.vorozhka.SummaryTask4.exception.validate.ValidateException;

/**
 * Created by Stanislav on 24.05.2017.
 */
public class IncorrectPassportValidateException extends ValidateException {

    public IncorrectPassportValidateException(String message) {
        super(message);
    }
}

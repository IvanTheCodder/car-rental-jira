package ua.nure.vorozhka.SummaryTask4.exception.validate.user;

import ua.nure.vorozhka.SummaryTask4.exception.validate.ValidateException;

/**
 * Created by Stanislav on 20.01.2017.
 */
public class IncorrectLoginValidateException extends ValidateException {

    public IncorrectLoginValidateException(String message) {
        super(message);
    }
}

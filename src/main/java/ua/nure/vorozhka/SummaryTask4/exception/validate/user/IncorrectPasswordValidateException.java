package ua.nure.vorozhka.SummaryTask4.exception.validate.user;

import ua.nure.vorozhka.SummaryTask4.exception.validate.ValidateException;

/**
 * Created by Stanislav on 20.01.2017.
 */
public class IncorrectPasswordValidateException extends ValidateException {

    public IncorrectPasswordValidateException(String message) {
        super(message);
    }
}

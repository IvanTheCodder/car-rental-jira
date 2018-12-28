package ua.nure.stepanenko.SummaryTask4.exception.validate.user;

import ua.nure.stepanenko.SummaryTask4.exception.validate.ValidateException;

/**
 * Created by eugen on 20.01.2017.
 */
public class IncorrectLoginValidateException extends ValidateException {

    public IncorrectLoginValidateException(String message) {
        super(message);
    }
}

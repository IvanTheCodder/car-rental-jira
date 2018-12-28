package ua.nure.stepanenko.SummaryTask4.exception.validate.user;

import ua.nure.stepanenko.SummaryTask4.exception.validate.ValidateException;

/**
 * Created by eugen on 24.05.2017.
 */
public class IncorrectPassportValidateException extends ValidateException {

    public IncorrectPassportValidateException(String message) {
        super(message);
    }
}

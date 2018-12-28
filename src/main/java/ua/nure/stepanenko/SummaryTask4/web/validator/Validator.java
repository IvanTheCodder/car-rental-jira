package ua.nure.stepanenko.SummaryTask4.web.validator;

import ua.nure.stepanenko.SummaryTask4.exception.validate.ValidateException;

/**
 * Created by eugen on 09.01.2017.
 */
public interface Validator<T> {

    void  validate(T field) throws ValidateException;
}

package ua.nure.vorozhka.SummaryTask4.web.validator.user;

import ua.nure.vorozhka.SummaryTask4.exception.validate.user.IncorrectLoginValidateException;
import ua.nure.vorozhka.SummaryTask4.exception.validate.ValidateException;
import ua.nure.vorozhka.SummaryTask4.web.validator.Validator;
import ua.nure.vorozhka.SummaryTask4.web.validator.util.ValidatorUtils;

import java.util.regex.Pattern;

/**
 * Created by Stanislav on 20.01.2017.
 */
public class LoginValidator implements Validator<String> {

    private static final String REGEX_FOR_LOGIN = "\\pL{5,16}";

    private static final Pattern PATTERN_FOR_LOGIN = Pattern.compile(REGEX_FOR_LOGIN);

    private static LoginValidator loginValidator = new LoginValidator();

    private LoginValidator() {
    }

    public static LoginValidator getInstance(){
        return loginValidator;
    }

    @Override
    public void validate(String login) throws ValidateException {
        if (login == null || !ValidatorUtils.suitPatter(PATTERN_FOR_LOGIN, login)) {
            throw new IncorrectLoginValidateException("Incorrect user login, " + System.lineSeparator() +
                    "user login consist only latter, and " + System.lineSeparator() +
                    "max length of login - 16, min length - 5");
        }
    }
}

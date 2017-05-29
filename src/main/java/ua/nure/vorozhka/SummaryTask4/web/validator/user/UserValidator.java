package ua.nure.vorozhka.SummaryTask4.web.validator.user;

import ua.nure.vorozhka.SummaryTask4.exception.validate.ValidateException;
import ua.nure.vorozhka.SummaryTask4.model.entyty.User;
import ua.nure.vorozhka.SummaryTask4.web.validator.Validator;

/**
 * Created by Stanislav on 24.05.2017.
 */
public class UserValidator implements Validator<User> {

    private static final Validator<String> FULL_NAME_VALIDATOR = FullNameValidator.getInstance();
    private static final Validator<String> LOGIN_VALIDATOR = LoginValidator.getInstance();
    private static final Validator<String> PASSWORD_VALIDATOR = PasswordValidator.getInstance();

    private static UserValidator userValidator = new UserValidator();

    private UserValidator() {
    }

    public static UserValidator getInstance(){
        return userValidator;
    }

    @Override
    public void validate(User user) throws ValidateException {
        FULL_NAME_VALIDATOR.validate(user.getFullName());
        LOGIN_VALIDATOR.validate(user.getLogin());
        PASSWORD_VALIDATOR.validate(user.getPassword());
    }
}

package ua.nure.stepanenko.SummaryTask4.web.validator.common;

import ua.nure.stepanenko.SummaryTask4.exception.validate.IncorrectLanguageValidateException;
import ua.nure.stepanenko.SummaryTask4.exception.validate.ValidateException;
import ua.nure.stepanenko.SummaryTask4.web.validator.Validator;
import ua.nure.stepanenko.SummaryTask4.web.validator.util.ValidatorUtils;

import java.util.regex.Pattern;

/**
 * Created by eugen on 26.05.2017.
 */
public class LanguageValidator implements Validator<String> {

    private static final String REGEX_FOR_LANGUAGE = "\\w{2}";

    private static final Pattern PATTERN_FOR_LANGUAGE = Pattern.compile(REGEX_FOR_LANGUAGE);

    private static LanguageValidator dateValidator = new LanguageValidator();

    private LanguageValidator() {
    }

    public static LanguageValidator getInstance() {
        return dateValidator;
    }

    @Override
    public void validate(String language) throws ValidateException {
        if (language == null || !ValidatorUtils.suitPatter(PATTERN_FOR_LANGUAGE, language)) {
            throw new IncorrectLanguageValidateException("Incorrect language");
        }
    }
}

package ua.nure.vorozhka.SummaryTask4.web.validator.common;

import ua.nure.vorozhka.SummaryTask4.exception.validate.common.IncorrectCostValidateException;
import ua.nure.vorozhka.SummaryTask4.exception.validate.ValidateException;
import ua.nure.vorozhka.SummaryTask4.web.validator.Validator;
import ua.nure.vorozhka.SummaryTask4.web.validator.util.ValidatorUtils;

import java.util.regex.Pattern;

/**
 * Created by Stanislav on 24.05.2017.
 */
public class CostValidator implements Validator<String> {

    private static final String REGEX_FOR_COST = "\\d{1,9}";

    private static final Pattern PATTERN_FOR_COST = Pattern.compile(REGEX_FOR_COST);

    private static CostValidator costValidator = new CostValidator();

    private CostValidator() {
    }

    public static CostValidator getInstance() {
        return costValidator;
    }

    @Override
    public void validate(String cost) throws ValidateException {
        if (cost == null || !ValidatorUtils.suitPatter(PATTERN_FOR_COST, cost)) {
            throw new IncorrectCostValidateException("Incorrect cost, " + System.lineSeparator() +
                    "cost consist only numbers and max length of cost - 9 and min length - 1");
        }
    }
}

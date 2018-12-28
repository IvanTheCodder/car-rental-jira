package ua.nure.stepanenko.SummaryTask4.web.validator.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by eugen on 20.01.2017.
 */
public final class ValidatorUtils {

    private ValidatorUtils() {

    }

    public static boolean suitPatter(Pattern pattern, String text) {
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }
}

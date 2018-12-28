package ua.nure.stepanenko.SummaryTask4.web.command;

import ua.nure.stepanenko.SummaryTask4.exception.AppException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by eugen on 03.01.2017.
 */
public abstract class Command {

    public abstract String execute(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, AppException;

    @Override
    public final String toString() {
        return getClass().getSimpleName();
    }
}

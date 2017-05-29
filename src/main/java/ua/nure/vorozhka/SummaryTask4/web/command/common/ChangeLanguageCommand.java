package ua.nure.vorozhka.SummaryTask4.web.command.common;

import org.apache.log4j.Logger;
import ua.nure.vorozhka.SummaryTask4.exception.AppException;
import ua.nure.vorozhka.SummaryTask4.web.Paths;
import ua.nure.vorozhka.SummaryTask4.web.command.Command;
import ua.nure.vorozhka.SummaryTask4.web.validator.Validator;
import ua.nure.vorozhka.SummaryTask4.web.validator.common.LanguageValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Stanislav on 26.05.2017.
 */
public class ChangeLanguageCommand extends Command {

    private static final Logger LOG = Logger.getLogger(ChangeLanguageCommand.class);

    private static final Validator<String> LANGUAGE_VALIDATOR = LanguageValidator.getInstance();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws AppException {
        LOG.debug("Command starts");

        String language = req.getParameter("language");
        LOG.trace(String.format("Request parameter: language --> %s", language));
        LANGUAGE_VALIDATOR.validate(language);
        req.getSession().setAttribute("language", language);

        LOG.debug("Command finished");
        return Paths.MAIN_PAGE;
    }
}

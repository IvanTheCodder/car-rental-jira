package ua.nure.stepanenko.SummaryTask4.web.command.user;

import org.apache.log4j.Logger;
import ua.nure.stepanenko.SummaryTask4.exception.AppException;
import ua.nure.stepanenko.SummaryTask4.web.Paths;
import ua.nure.stepanenko.SummaryTask4.web.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by eugen on 26.05.2017.
 */
public class ToEditUserCommand extends Command {

    private static final Logger LOG = Logger.getLogger(ToEditUserCommand.class);

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws AppException {
        LOG.debug("Command starts");
        // no op
        LOG.debug("Command finished");
        return Paths.EDIT_USER_PAGE;
    }
}

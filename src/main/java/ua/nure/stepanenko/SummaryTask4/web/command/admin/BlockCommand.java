package ua.nure.stepanenko.SummaryTask4.web.command.admin;

import org.apache.log4j.Logger;
import ua.nure.stepanenko.SummaryTask4.db.Facade;
import ua.nure.stepanenko.SummaryTask4.db.TransactionManagerFacade;
import ua.nure.stepanenko.SummaryTask4.db.connector.postgres.PostgresTransactionManagerFactory;
import ua.nure.stepanenko.SummaryTask4.exception.AppException;
import ua.nure.stepanenko.SummaryTask4.web.Paths;
import ua.nure.stepanenko.SummaryTask4.web.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by eugen on 28.05.2017.
 */
public class BlockCommand extends Command {

    private static final Logger LOG = Logger.getLogger(BlockCommand.class);

    private static final Facade FACADE =
            TransactionManagerFacade.getInstance(PostgresTransactionManagerFactory.getInstance());

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws AppException {
        LOG.debug("Command starts");

        String login = req.getParameter("login");
        LOG.trace(String.format("Request parameter: login --> %s", login));

        FACADE.setUserFieldBlockedByUserLogin(true, login);

        LOG.debug("Command finished");
        return Paths.PERMISSION_SERVLET;
    }
}

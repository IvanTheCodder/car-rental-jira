package ua.nure.stepanenko.SummaryTask4.web.command.manager;

import org.apache.log4j.Logger;
import ua.nure.stepanenko.SummaryTask4.db.Facade;
import ua.nure.stepanenko.SummaryTask4.db.TransactionManagerFacade;
import ua.nure.stepanenko.SummaryTask4.db.connector.postgres.PostgresTransactionManagerFactory;
import ua.nure.stepanenko.SummaryTask4.exception.AppException;
import ua.nure.stepanenko.SummaryTask4.model.constant.State;
import ua.nure.stepanenko.SummaryTask4.web.Paths;
import ua.nure.stepanenko.SummaryTask4.web.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by eugen on 27.05.2017.
 */
public class ConfirmOrderCommand extends Command {

    private static final Logger LOG = Logger.getLogger(ConfirmOrderCommand.class);

    private static final Facade FACADE =
            TransactionManagerFacade.getInstance(PostgresTransactionManagerFactory.getInstance());

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws AppException {
        LOG.debug("Command starts");

        int orderNumber = Integer.parseInt(req.getParameter("orderNumber"));
        LOG.trace(String.format("Request parameter: orderNumber --> %d", orderNumber));

        FACADE.setOrderFieldStateByOrderNumber(State.CONFIRMED, orderNumber);

        LOG.debug("Command finished");
        return Paths.MANAGER_ORDERS_SERVLET;
    }
}

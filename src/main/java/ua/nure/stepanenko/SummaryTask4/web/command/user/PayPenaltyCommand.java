package ua.nure.stepanenko.SummaryTask4.web.command.user;

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
 * Created by eugen on 26.05.2017.
 */
public class PayPenaltyCommand extends Command {

    private static final Logger LOG = Logger.getLogger(PayPenaltyCommand.class);

    private static final Facade FACADE =
            TransactionManagerFacade.getInstance(PostgresTransactionManagerFactory.getInstance());

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws AppException {
        LOG.debug("Command starts");

        int penaltyId = Integer.parseInt(req.getParameter("penaltyId"));
        LOG.trace(String.format("Request parameter: penaltyId --> %d", penaltyId));
        int orderNumber = Integer.parseInt(req.getParameter("orderNumber"));
        LOG.trace(String.format("Request parameter: orderNumber --> %d", orderNumber));

        FACADE.setNullToOrderFieldPenaltyIdByOrderNumber(orderNumber);

        LOG.debug("Command finished");
        return Paths.PERSONAL_SERVLET;
    }
}

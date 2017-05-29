package ua.nure.vorozhka.SummaryTask4.web.command.user;

import org.apache.log4j.Logger;
import ua.nure.vorozhka.SummaryTask4.db.Facade;
import ua.nure.vorozhka.SummaryTask4.db.TransactionManagerFacade;
import ua.nure.vorozhka.SummaryTask4.db.connector.postgres.PostgresTransactionManagerFactory;
import ua.nure.vorozhka.SummaryTask4.exception.AppException;
import ua.nure.vorozhka.SummaryTask4.model.constant.State;
import ua.nure.vorozhka.SummaryTask4.web.Paths;
import ua.nure.vorozhka.SummaryTask4.web.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Stanislav on 26.05.2017.
 */
public class PayOrderCommand extends Command {

    private static final Logger LOG = Logger.getLogger(PayOrderCommand.class);

    private static final Facade FACADE =
            TransactionManagerFacade.getInstance(PostgresTransactionManagerFactory.getInstance());

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws AppException {
        LOG.debug("Command starts");

        int orderNumber = Integer.parseInt(req.getParameter("orderNumber"));
        LOG.trace(String.format("Request parameter: orderNumber --> %d", orderNumber));
        int carId = Integer.parseInt(req.getParameter("carId"));
        LOG.trace(String.format("Request parameter: carId --> %d", carId));

        FACADE.changeCarFieldThereIsAndOrderFieldStateByIDs(false, carId, State.PAID, orderNumber);

        LOG.debug("Command finished");
        return Paths.PERSONAL_SERVLET;
    }
}

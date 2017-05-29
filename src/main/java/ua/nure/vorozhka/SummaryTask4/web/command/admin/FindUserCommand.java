package ua.nure.vorozhka.SummaryTask4.web.command.admin;

import org.apache.log4j.Logger;
import ua.nure.vorozhka.SummaryTask4.db.Facade;
import ua.nure.vorozhka.SummaryTask4.db.TransactionManagerFacade;
import ua.nure.vorozhka.SummaryTask4.db.connector.postgres.PostgresTransactionManagerFactory;
import ua.nure.vorozhka.SummaryTask4.exception.AppException;
import ua.nure.vorozhka.SummaryTask4.model.entyty.Order;
import ua.nure.vorozhka.SummaryTask4.web.Paths;
import ua.nure.vorozhka.SummaryTask4.web.command.Command;
import ua.nure.vorozhka.SummaryTask4.web.command.util.CommandUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Stanislav on 28.05.2017.
 */
public class FindUserCommand extends Command {

    private static final Logger LOG = Logger.getLogger(FindUserCommand.class);

    private static final Facade FACADE =
            TransactionManagerFacade.getInstance(PostgresTransactionManagerFactory.getInstance());

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws AppException {
        LOG.debug("Command starts");

        String looking = req.getParameter("looking");
        LOG.trace(String.format("Request parameter: looking --> %s", looking));

        CommandUtils.checkLookingCounter(req.getSession(), looking);

        List<Order> orders = FACADE.getOrdersByUserLogin(looking);
        LOG.trace(String.format("Orders --> %s", orders.toString()));
        req.setAttribute("orders", orders);

        LOG.debug("Command finished");
        return Paths.PERMISSION_PAGE;
    }
}

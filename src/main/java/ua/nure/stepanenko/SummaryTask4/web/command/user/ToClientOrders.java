package ua.nure.stepanenko.SummaryTask4.web.command.user;

import org.apache.log4j.Logger;
import ua.nure.stepanenko.SummaryTask4.db.Facade;
import ua.nure.stepanenko.SummaryTask4.db.TransactionManagerFacade;
import ua.nure.stepanenko.SummaryTask4.db.connector.postgres.PostgresTransactionManagerFactory;
import ua.nure.stepanenko.SummaryTask4.exception.AppException;
import ua.nure.stepanenko.SummaryTask4.model.entyty.Order;
import ua.nure.stepanenko.SummaryTask4.model.entyty.User;
import ua.nure.stepanenko.SummaryTask4.web.Paths;
import ua.nure.stepanenko.SummaryTask4.web.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by eugen on 26.05.2017.
 */
public class ToClientOrders extends Command {

    private static final Logger LOG = Logger.getLogger(ToClientOrders.class);

    private static final Facade FACADE =
            TransactionManagerFacade.getInstance(PostgresTransactionManagerFactory.getInstance());

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws AppException {
        LOG.debug("Command starts");

        User user = (User) req.getSession().getAttribute("user");
        LOG.trace(String.format("Session parameter: user --> %s", user.toString()));

        List<Order> orders = FACADE.getOrdersByUserLogin(user.getLogin());
        LOG.trace(String.format("Orders --> %s", orders));
        req.setAttribute("orders", orders);

        LOG.debug("Command finished");
        return Paths.ORDERS_CLIENT_PAGE;
    }
}

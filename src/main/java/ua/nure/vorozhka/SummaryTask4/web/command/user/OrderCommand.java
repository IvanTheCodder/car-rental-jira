package ua.nure.vorozhka.SummaryTask4.web.command.user;

import org.apache.log4j.Logger;
import ua.nure.vorozhka.SummaryTask4.db.Facade;
import ua.nure.vorozhka.SummaryTask4.db.TransactionManagerFacade;
import ua.nure.vorozhka.SummaryTask4.db.connector.postgres.PostgresTransactionManagerFactory;
import ua.nure.vorozhka.SummaryTask4.exception.AppException;
import ua.nure.vorozhka.SummaryTask4.exception.validate.ValidateException;
import ua.nure.vorozhka.SummaryTask4.model.constant.State;
import ua.nure.vorozhka.SummaryTask4.model.entyty.Car;
import ua.nure.vorozhka.SummaryTask4.model.entyty.Order;
import ua.nure.vorozhka.SummaryTask4.model.entyty.User;
import ua.nure.vorozhka.SummaryTask4.web.Paths;
import ua.nure.vorozhka.SummaryTask4.web.command.Command;
import ua.nure.vorozhka.SummaryTask4.web.command.util.CommandUtils;
import ua.nure.vorozhka.SummaryTask4.web.validator.Validator;
import ua.nure.vorozhka.SummaryTask4.web.validator.common.DateValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

/**
 * Created by Stanislav on 27.05.2017.
 */
public class OrderCommand extends Command {

    private static final Logger LOG = Logger.getLogger(OrderCommand.class);

    private static final Validator<String> DATE_VALIDATOR = DateValidator.getInstance();

    private static final Facade FACADE =
            TransactionManagerFacade.getInstance(PostgresTransactionManagerFactory.getInstance());

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws AppException {
        LOG.debug("Command starts");

        Order order = getOrder(req);

        FACADE.createOrder(order);

        LOG.debug("Command finished");
        return Paths.MAIN_SERVLET;
    }

    private Order getOrder(HttpServletRequest req) throws ValidateException {
        Car car = CommandUtils.getCarFromRequest(req);
        LOG.trace(String.format("Request parameter: car --> %s", car.toString()));
        User user = (User) req.getSession().getAttribute("user");
        LOG.trace(String.format("Session attribute: user --> %s", user.toString()));
        boolean driver = Boolean.parseBoolean(req.getParameter("driver"));
        LOG.trace(String.format("Request parameter: driver --> %b", driver));
        String strTerm = req.getParameter("term");
        DATE_VALIDATOR.validate(strTerm);
        Date term = Date.valueOf(strTerm);
        LOG.trace(String.format("Request parameter: term --> %s", term.toString()));

        Order order = new Order();
        order.setTerm(term);
        order.setDriver(driver);
        order.setUser(user);
        order.setCar(car);
        order.setState(State.EXPECTATION);
        return order;
    }
}

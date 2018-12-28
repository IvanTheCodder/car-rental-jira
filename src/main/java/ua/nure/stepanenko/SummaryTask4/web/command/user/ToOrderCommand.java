package ua.nure.stepanenko.SummaryTask4.web.command.user;

import org.apache.log4j.Logger;
import ua.nure.stepanenko.SummaryTask4.exception.AppException;
import ua.nure.stepanenko.SummaryTask4.model.entyty.Car;
import ua.nure.stepanenko.SummaryTask4.web.Paths;
import ua.nure.stepanenko.SummaryTask4.web.command.Command;
import ua.nure.stepanenko.SummaryTask4.web.command.util.CommandUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by eugen on 27.05.2017.
 */
public class ToOrderCommand extends Command {

    private static final Logger LOG = Logger.getLogger(ToOrderCommand.class);

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws AppException {
        LOG.debug("Command starts");

        Car car = CommandUtils.getCarFromRequest(req);
        LOG.trace(String.format("Request parameter: car --> %s", car.toString()));
        req.setAttribute("car", car);
        LOG.debug("Command finished");
        return Paths.ORDER_PAGE;
    }
}

package ua.nure.vorozhka.SummaryTask4.web.command.manager;

import org.apache.log4j.Logger;
import ua.nure.vorozhka.SummaryTask4.exception.AppException;
import ua.nure.vorozhka.SummaryTask4.web.Paths;
import ua.nure.vorozhka.SummaryTask4.web.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Stanislav on 27.05.2017.
 */
public class ToRejectOrderCommand extends Command {

    private static final Logger LOG = Logger.getLogger(ToRejectOrderCommand.class);

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws AppException {
        LOG.debug("Command starts");

        int orderNumber = Integer.parseInt(req.getParameter("orderNumber"));
        LOG.trace(String.format("Request parameter: orderNumber --> %d", orderNumber));
        req.setAttribute("orderNumber", orderNumber);

        LOG.debug("Command finished");
        return Paths.REJECT_PAGE;
    }
}

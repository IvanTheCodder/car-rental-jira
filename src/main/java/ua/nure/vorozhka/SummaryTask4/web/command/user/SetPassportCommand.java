package ua.nure.vorozhka.SummaryTask4.web.command.user;

import org.apache.log4j.Logger;
import ua.nure.vorozhka.SummaryTask4.db.Facade;
import ua.nure.vorozhka.SummaryTask4.db.TransactionManagerFacade;
import ua.nure.vorozhka.SummaryTask4.db.connector.postgres.PostgresTransactionManagerFactory;
import ua.nure.vorozhka.SummaryTask4.exception.AppException;
import ua.nure.vorozhka.SummaryTask4.model.entyty.User;
import ua.nure.vorozhka.SummaryTask4.web.Paths;
import ua.nure.vorozhka.SummaryTask4.web.command.Command;
import ua.nure.vorozhka.SummaryTask4.web.validator.Validator;
import ua.nure.vorozhka.SummaryTask4.web.validator.user.PassportValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Stanislav on 26.05.2017.
 */
public class SetPassportCommand extends Command {

    private static final Logger LOG = Logger.getLogger(SetPassportCommand.class);

    private static final Validator<String> PASSPORT_VALIDATOR = PassportValidator.getInstance();

    private static final Facade FACADE =
            TransactionManagerFacade.getInstance(PostgresTransactionManagerFactory.getInstance());

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws AppException {
        LOG.debug("Command starts");

        HttpSession session = req.getSession();

        String passport = req.getParameter("passport");
        LOG.trace(String.format("Request parameter: passport --> %s", passport));
        User user = (User) session.getAttribute("user");
        LOG.trace(String.format("Session attribute: user --> %s", user));

        PASSPORT_VALIDATOR.validate(passport);

        FACADE.setUserFieldPassportByUserLogin(passport, user.getLogin());

        user.setPassport(passport);
        session.setAttribute("user", user);

        LOG.debug("Command finished");
        return Paths.PERSONAL_SERVLET;
    }
}

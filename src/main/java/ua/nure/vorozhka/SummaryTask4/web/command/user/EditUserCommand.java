package ua.nure.vorozhka.SummaryTask4.web.command.user;

import org.apache.log4j.Logger;
import ua.nure.vorozhka.SummaryTask4.db.Facade;
import ua.nure.vorozhka.SummaryTask4.db.TransactionManagerFacade;
import ua.nure.vorozhka.SummaryTask4.db.connector.postgres.PostgresTransactionManagerFactory;
import ua.nure.vorozhka.SummaryTask4.exception.AppException;
import ua.nure.vorozhka.SummaryTask4.model.entyty.User;
import ua.nure.vorozhka.SummaryTask4.web.Paths;
import ua.nure.vorozhka.SummaryTask4.web.command.Command;
import ua.nure.vorozhka.SummaryTask4.web.command.util.CommandUtils;
import ua.nure.vorozhka.SummaryTask4.web.validator.Validator;
import ua.nure.vorozhka.SummaryTask4.web.validator.user.LoginValidator;
import ua.nure.vorozhka.SummaryTask4.web.validator.user.UserValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Stanislav on 26.05.2017.
 */
public class EditUserCommand extends Command {

    private static final Logger LOG = Logger.getLogger(EditUserCommand.class);

    private static final Validator<User> USER_VALIDATOR = UserValidator.getInstance();

    private static final Validator<String> LOGIN_VALIDATOR = LoginValidator.getInstance();

    private static final Facade FACADE =
            TransactionManagerFacade.getInstance(PostgresTransactionManagerFactory.getInstance());

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws AppException {
        LOG.debug("Command starts");

        User user = CommandUtils.getUserFromRequest(req);
        LOG.trace(String.format("Request parameter: user --> %s", user.toString()));

        String oldLogin = req.getParameter("oldLogin");
        LOG.trace(String.format("Request parameter: oldLogin --> %s", oldLogin));

        USER_VALIDATOR.validate(user);
        LOGIN_VALIDATOR.validate(oldLogin);

        FACADE.updateUserByLogin(user, oldLogin);

        HttpSession session = req.getSession();
        User oldUser = (User) session.getAttribute("user");
        user.setBlocked(oldUser.isBlocked());
        user.setRole(oldUser.getRole());
        session.setAttribute("user", user);

        LOG.debug("Command finished");
        return Paths.PERSONAL_SERVLET;
    }
}

package ua.nure.vorozhka.SummaryTask4.web.command.common;

import org.apache.log4j.Logger;
import ua.nure.vorozhka.SummaryTask4.db.Facade;
import ua.nure.vorozhka.SummaryTask4.db.TransactionManagerFacade;
import ua.nure.vorozhka.SummaryTask4.db.connector.postgres.PostgresTransactionManagerFactory;
import ua.nure.vorozhka.SummaryTask4.exception.AppException;
import ua.nure.vorozhka.SummaryTask4.exception.ExceptionMessages;
import ua.nure.vorozhka.SummaryTask4.model.entyty.User;
import ua.nure.vorozhka.SummaryTask4.web.Paths;
import ua.nure.vorozhka.SummaryTask4.web.command.Command;
import ua.nure.vorozhka.SummaryTask4.web.validator.Validator;
import ua.nure.vorozhka.SummaryTask4.web.validator.user.LoginValidator;
import ua.nure.vorozhka.SummaryTask4.web.validator.user.PasswordValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Stanislav on 03.01.2017.
 */
public class AuthenticateCommand extends Command {

    private static final Logger LOG = Logger.getLogger(AuthenticateCommand.class);

    private static final Validator<String> LOGIN_VALIDATOR = LoginValidator.getInstance();

    private static final Validator<String> PASSWORD_VALIDATOR = PasswordValidator.getInstance();

    private static final Facade FACADE =
            TransactionManagerFacade.getInstance(PostgresTransactionManagerFactory.getInstance());

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws AppException {
        LOG.debug("Command starts");

        String login = req.getParameter("login");
        LOG.trace(String.format("Request parameter: login --> %s", login));
        String password = req.getParameter("password");
        LOG.trace(String.format("Request parameter: password --> %s", password));

        LOGIN_VALIDATOR.validate(login);
        PASSWORD_VALIDATOR.validate(password);

        User user = FACADE.getUserByLoginAndPassword(login, password);
        checkUser(user);

        HttpSession session = req.getSession();
        session.setAttribute("user", user);

        LOG.debug("Command finished");
        return Paths.MAIN_SERVLET;
    }

    private void checkUser(User user) throws AppException {
        if (!user.isFilled()) {
            throw new AppException(ExceptionMessages.USER_NOT_EXIST_MESSAGE);
        }
    }
}

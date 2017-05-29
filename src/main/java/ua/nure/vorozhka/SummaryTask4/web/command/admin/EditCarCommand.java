package ua.nure.vorozhka.SummaryTask4.web.command.admin;

import org.apache.log4j.Logger;
import ua.nure.vorozhka.SummaryTask4.db.Facade;
import ua.nure.vorozhka.SummaryTask4.db.TransactionManagerFacade;
import ua.nure.vorozhka.SummaryTask4.db.connector.postgres.PostgresTransactionManagerFactory;
import ua.nure.vorozhka.SummaryTask4.exception.AppException;
import ua.nure.vorozhka.SummaryTask4.exception.validate.ValidateException;
import ua.nure.vorozhka.SummaryTask4.model.constant.Class;
import ua.nure.vorozhka.SummaryTask4.model.constant.Mark;
import ua.nure.vorozhka.SummaryTask4.model.entyty.Car;
import ua.nure.vorozhka.SummaryTask4.web.Paths;
import ua.nure.vorozhka.SummaryTask4.web.command.Command;
import ua.nure.vorozhka.SummaryTask4.web.validator.Validator;
import ua.nure.vorozhka.SummaryTask4.web.validator.car.NameValidator;
import ua.nure.vorozhka.SummaryTask4.web.validator.common.CostValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Stanislav on 28.05.2017.
 */
public class EditCarCommand extends Command {

    private static final Logger LOG = Logger.getLogger(EditCarCommand.class);

    private static final Validator<String> NAME_VALIDATOR = NameValidator.getInstance();

    private static final Validator<String> COST_VALIDATOR = CostValidator.getInstance();

    private static final Facade FACADE =
            TransactionManagerFacade.getInstance(PostgresTransactionManagerFactory.getInstance());

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws AppException {
        LOG.debug("Command starts");

        Car car = getCarFromRequest(req);

        FACADE.updateCar(car);

        LOG.debug("Command finished");
        return Paths.CARS_SERVLET;
    }

    private Car getCarFromRequest(HttpServletRequest req) throws ValidateException {
        Car car = new Car();

        int carId = Integer.parseInt(req.getParameter("carId"));
        LOG.trace(String.format("Request parameter: carId --> %d", carId));
        Class clazz = Class.valueOf(req.getParameter("class"));
        LOG.trace(String.format("Request parameter: class --> %s", clazz));
        Mark mark = Mark.valueOf(req.getParameter("mark"));
        LOG.trace(String.format("Request parameter: mark --> %s", mark));
        String name = req.getParameter("name");
        NAME_VALIDATOR.validate(name);
        LOG.trace(String.format("Request parameter: name --> %s", name));
        String costStr = req.getParameter("cost");
        COST_VALIDATOR.validate(costStr);
        int cost = Integer.parseInt(costStr);
        LOG.trace(String.format("Request parameter: cost --> %s", cost));

        car.setId(carId);
        car.setClazz(clazz);
        car.setMark(mark);
        car.setName(name);
        car.setCost(cost);

        return car;
    }
}

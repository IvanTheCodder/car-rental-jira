package ua.nure.vorozhka.SummaryTask4.db.connector;

import ua.nure.vorozhka.SummaryTask4.db.dao.CarDAO;
import ua.nure.vorozhka.SummaryTask4.db.dao.OrderDAO;
import ua.nure.vorozhka.SummaryTask4.db.dao.PenaltyDAO;
import ua.nure.vorozhka.SummaryTask4.db.dao.UserDAO;
import ua.nure.vorozhka.SummaryTask4.exception.db.DBException;

import java.sql.Connection;

/**
 * Created by Stanislav on 21.05.2017.
 */
public interface DAOFactory {

    Connection getConnection() throws DBException;

    UserDAO getUserDAO();

    PenaltyDAO getPenaltyDAO();

    OrderDAO getOrderDAO();

    CarDAO getCarDAO();

    void close(Connection connection) throws DBException;

    void commit(Connection connection) throws DBException;

    void rollBack(Connection connection) throws DBException;
}

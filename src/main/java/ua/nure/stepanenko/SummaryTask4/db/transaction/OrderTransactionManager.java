package ua.nure.stepanenko.SummaryTask4.db.transaction;

import ua.nure.stepanenko.SummaryTask4.exception.db.DBException;
import ua.nure.stepanenko.SummaryTask4.model.constant.State;
import ua.nure.stepanenko.SummaryTask4.model.entyty.Order;

import java.util.List;

/**
 * Created by eugen on 22.05.2017.
 */
public interface OrderTransactionManager {

    boolean createOrder(Order order) throws DBException;

    Order getOrderByNumber(int number) throws DBException;

    List<Order> getOrders() throws DBException;

    List<Order> getOrdersByLogin(String login) throws DBException;

    boolean setOrderFieldPenaltyIdByOrderNumber(int penaltyId, int orderNumber) throws DBException;

    boolean setNullToOrderFieldPenaltyIdByOrderNumber(int orderNumber) throws DBException;

    boolean setOrderFieldStateByOrderNumber(State state, int orderNumber) throws DBException;
}

package ua.nure.stepanenko.SummaryTask4.db.transaction;

import ua.nure.stepanenko.SummaryTask4.exception.db.DBException;
import ua.nure.stepanenko.SummaryTask4.model.been.Penalty;
import ua.nure.stepanenko.SummaryTask4.model.constant.State;

/**
 * Created by eugen on 27.05.2017.
 */
public interface OrderPenaltyTransactionManager {

    boolean createAndSetOrderFieldPenaltyIdByOrderNumber(
            Penalty penalty, int orderNumber) throws DBException;

    boolean createAndSetOrderFieldPenaltyIdByOrderNumberAndChangeState(
            Penalty penalty, int orderNumber, State state) throws DBException;
}

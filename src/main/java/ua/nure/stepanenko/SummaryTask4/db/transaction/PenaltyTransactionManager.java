package ua.nure.stepanenko.SummaryTask4.db.transaction;

import ua.nure.stepanenko.SummaryTask4.exception.db.DBException;
import ua.nure.stepanenko.SummaryTask4.model.been.Penalty;

/**
 * Created by eugen on 22.05.2017.
 */
public interface PenaltyTransactionManager {

    boolean createPenalty(Penalty penalty) throws DBException;

    Penalty getPenaltyById(int id) throws DBException;

    boolean deletePenaltyById(int id) throws DBException;
}

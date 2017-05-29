package ua.nure.vorozhka.SummaryTask4.db.transaction;

import ua.nure.vorozhka.SummaryTask4.exception.db.DBException;
import ua.nure.vorozhka.SummaryTask4.model.constant.State;

/**
 * Created by Stanislav on 26.05.2017.
 */
public interface CarOrderTransactionManager {

    boolean changeCarFieldThereIsAndOrderFieldStateByIDs(
            boolean thereIs, int carId, State state, int orderNumber) throws DBException;
}

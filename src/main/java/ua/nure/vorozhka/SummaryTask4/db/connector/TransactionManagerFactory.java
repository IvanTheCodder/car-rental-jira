package ua.nure.vorozhka.SummaryTask4.db.connector;

import ua.nure.vorozhka.SummaryTask4.db.transaction.*;

/**
 * Created by Stanislav on 21.05.2017.
 */
public interface TransactionManagerFactory {

    UserTransactionManager getUserTransactionManager();

    PenaltyTransactionManager getPenaltyTransactionManager();

    OrderTransactionManager getOrderTransactionManager();

    CarTransactionManager getCarTransactionManager();

    CarOrderTransactionManager getCarOrderTransactionManager();

    OrderPenaltyTransactionManager getOrderPenaltyTransactionManager();
}

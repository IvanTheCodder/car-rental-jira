package ua.nure.stepanenko.SummaryTask4.db.connector;

import ua.nure.stepanenko.SummaryTask4.db.transaction.*;

/**
 * Created by eugen on 21.05.2017.
 */
public interface TransactionManagerFactory {

    UserTransactionManager getUserTransactionManager();

    PenaltyTransactionManager getPenaltyTransactionManager();

    OrderTransactionManager getOrderTransactionManager();

    CarTransactionManager getCarTransactionManager();

    CarOrderTransactionManager getCarOrderTransactionManager();

    OrderPenaltyTransactionManager getOrderPenaltyTransactionManager();
}

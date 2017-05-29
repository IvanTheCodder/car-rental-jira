package ua.nure.vorozhka.SummaryTask4.db.connector.postgres.utli;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Stanislav on 23.05.2017.
 */
public final class DAOUtils {

    private DAOUtils() {
    }

    public static void fillPreparedStatement(PreparedStatement preparedStatement, Object... args)
            throws SQLException {

        int counter = 1;

        for (Object arg : args) {
            preparedStatement.setObject(counter++, arg);
        }
    }
}

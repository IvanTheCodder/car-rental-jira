package ua.nure.vorozhka.SummaryTask4.db.dao;

import ua.nure.vorozhka.SummaryTask4.model.been.Penalty;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Stanislav on 21.05.2017.
 */
public abstract class PenaltyDAO {

    public abstract boolean createPenalty(Connection connection, Penalty penalty) throws SQLException;

    public abstract Penalty getPenaltyById(Connection connection, int id) throws SQLException;

    public abstract boolean deletePenaltyById(Connection connection, int id) throws SQLException;

    protected Penalty getPenalty(ResultSet resultSet) throws SQLException {
        Penalty penalty = new Penalty();
        penalty.setId(resultSet.getInt("id"));
        penalty.setCause(resultSet.getString("cause"));
        penalty.setCost(resultSet.getInt("cost"));
        return penalty;
    }
}

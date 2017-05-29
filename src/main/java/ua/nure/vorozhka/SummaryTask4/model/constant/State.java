package ua.nure.vorozhka.SummaryTask4.model.constant;

import java.io.Serializable;

/**
 * Created by Stanislav on 19.05.2017.
 */
public enum State implements Serializable {

    EXPECTATION, REJECTED, CONFIRMED, PAID, COMPLETED;

    public static State getStateById(int roleId) {
        return State.values()[--roleId];
    }

    public String getName() { return name().toLowerCase(); }

    public int getId() {
        return ordinal() + 1;
    }
}

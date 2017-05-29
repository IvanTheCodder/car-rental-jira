package ua.nure.vorozhka.SummaryTask4.model.constant;

import java.io.Serializable;

/**
 * Created by Stanislav on 19.05.2017.
 */
public enum Class implements Serializable {

    BUSINESS, SPORT, ECONOMY, MEDIUM;

    public static Class getClassById(int roleId) {
        return Class.values()[--roleId];
    }

    public String getName() { return name().toLowerCase(); }

    public int getId() {
        return ordinal() + 1;
    }
}

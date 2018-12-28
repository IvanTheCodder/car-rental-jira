package ua.nure.stepanenko.SummaryTask4.model.constant;

import java.io.Serializable;

/**
 * Created by eugen on 19.05.2017.
 */
public enum Mark implements Serializable {

    AUDI, BMW, PEUGEOT, HYUNDAI, KIA, LEXUS, MAZDA, NISAN, OPEL, RENAULT, PORSCHE, MERCEDES, MITSUBISHI;

    public static Mark getMarkById(int roleId) {
        return Mark.values()[--roleId];
    }

    public String getName() { return name().toLowerCase(); }

    public int getId() {
        return ordinal() + 1;
    }
}

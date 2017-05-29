package ua.nure.vorozhka.SummaryTask4.model.constant;

import java.io.Serializable;

/**
 * Created by Stanislav on 19.05.2017.
 */
public enum Role implements Serializable {

    CLIENT, MANAGER, ADMIN;

    public static Role getRoleById(int roleId) {
        return Role.values()[--roleId];
    }

    public String getName() { return name().toLowerCase(); }

    public int getId() {
        return ordinal() + 1;
    }
}

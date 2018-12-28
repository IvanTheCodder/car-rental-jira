package ua.nure.stepanenko.SummaryTask4.model.been;

import java.io.Serializable;

/**
 * Created by eugen on 19.05.2017.
 */
public class Penalty implements Serializable {

    private int id;
    private int cost;
    private String cause;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    @Override
    public String toString() {
        return "id - " + id +
                ", cost - " + cost +
                ", cause - " + cause;
    }
}

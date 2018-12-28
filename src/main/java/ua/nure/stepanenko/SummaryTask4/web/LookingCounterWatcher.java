package ua.nure.stepanenko.SummaryTask4.web;

import ua.nure.stepanenko.SummaryTask4.model.been.LookingCounter;

/**
 * Created by eugen on 28.05.2017.
 */
public class LookingCounterWatcher implements Runnable {

    private LookingCounter lookingCounter;

    public LookingCounterWatcher(LookingCounter lookingCounter) {
        this.lookingCounter = lookingCounter;
    }

    @Override
    public void run() {
        lookingCounter.setCount(1);
    }
}

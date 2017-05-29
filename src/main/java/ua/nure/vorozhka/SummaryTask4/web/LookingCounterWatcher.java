package ua.nure.vorozhka.SummaryTask4.web;

import ua.nure.vorozhka.SummaryTask4.model.been.LookingCounter;

/**
 * Created by Stanislav on 28.05.2017.
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

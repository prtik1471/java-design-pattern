package org.goldMineFacade;

import java.util.Collection;
import java.util.List;

public class GoldMineFacade {
    private final List<MineWorker> workers;

    public GoldMineFacade() {
        workers = List.of(new TunnelDigger(), new GoldDIgger(), new CartOperator());
    }

    public void startNewDay() {
        makeActions(workers, MineWorker.Action.WAKE_UP, MineWorker.Action.GO_TO_MINE);
    }

    public void digGold() {
        makeActions(workers, MineWorker.Action.WORK);
    }

    public void endDay() {
        makeActions(workers, MineWorker.Action.GO_HOME, MineWorker.Action.SLEEP);
    }

    public static void makeActions(List<MineWorker> workers, MineWorker.Action... actions) {
        workers.forEach(worker -> worker.action(actions));
    }
}

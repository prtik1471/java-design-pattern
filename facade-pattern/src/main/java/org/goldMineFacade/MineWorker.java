package org.goldMineFacade;

import java.util.Arrays;

public abstract class MineWorker {
    public void sleep() {
        System.out.println("go to sleep: " + name());
    }

    public void wakeUp() {
        System.out.println("wake up: " + name());
    }

    public void goHome() {
        System.out.println("go home: " + name());
    }

    public void goMine() {
        System.out.println("go to mine: " + name());
    }

    private void action(Action action) {
        switch (action) {
            case SLEEP -> sleep();
            case WAKE_UP -> wakeUp();
            case GO_HOME -> goHome();
            case GO_TO_MINE -> goMine();
            case WORK -> work();
        }
    }

    public void action(Action... actions) {
        Arrays.stream(actions).forEach(this::action);
    }

    public abstract void work();
    public abstract String name();

    enum Action {
        SLEEP,
        WAKE_UP,
        GO_HOME,
        GO_TO_MINE,
        WORK
    }
}

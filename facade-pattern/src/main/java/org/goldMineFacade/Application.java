package org.goldMineFacade;

public class Application {
    public static void main(String[] args) {
        GoldMineFacade facade = new GoldMineFacade();
        facade.startNewDay();
        facade.digGold();
        facade.endDay();
    }
}
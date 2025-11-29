package org.goldMineFacade;

public class GoldDIgger extends MineWorker{

    @Override
    public void work() {
        System.out.println("digging the gold");
    }

    @Override
    public String name() {
        return "name : gold digger";
    }
}

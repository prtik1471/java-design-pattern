package org.goldMineFacade;

public class TunnelDigger extends MineWorker{
    @Override
    public void work() {
        System.out.println("digging the tunnel");
    }

    @Override
    public String name() {
        return "name : tunnel digger";
    }
}

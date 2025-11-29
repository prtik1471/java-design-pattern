package org.goldMineFacade;

public class CartOperator extends MineWorker{
    @Override
    public void work() {
        System.out.println("driving the cart");
    }

    @Override
    public String name() {
        return "name : cart operator";
    }
}

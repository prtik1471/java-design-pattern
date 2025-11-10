package org.coffeeDecorator;

public class HouseBlend implements Beverage{
    @Override
    public String getDescription() {
        return "Base HouseBlend ";
    }

    @Override
    public int cost() {
        return 20;
    }
}

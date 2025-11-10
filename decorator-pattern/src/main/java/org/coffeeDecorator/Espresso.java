package org.coffeeDecorator;

public class Espresso implements Beverage{
    @Override
    public String getDescription() {
        return "Base Espresso ";
    }

    @Override
    public int cost() {
        return 10;
    }
}

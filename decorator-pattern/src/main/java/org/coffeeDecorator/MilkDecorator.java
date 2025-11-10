package org.coffeeDecorator;

public class MilkDecorator extends AddOnDecorator{
    private final Beverage wrapped;
    public MilkDecorator(Beverage beverage) {
        super(beverage);
        this.wrapped = beverage;
    }

    @Override
    public String getDescription() {
        return wrapped.getDescription() + " +milk ";
    }

    @Override
    public int cost() {
        return wrapped.cost() + 2;
    }
}

package org.coffeeDecorator;

public class SugarDecorator extends AddOnDecorator{
    private final Beverage wrapped;
    public SugarDecorator(Beverage beverage) {
        super(beverage);
        this.wrapped = beverage;
    }

    @Override
    public String getDescription() {
        return wrapped.getDescription() + " +sugar";
    }

    @Override
    public int cost() {
        return wrapped.cost() + 3;
    }

}

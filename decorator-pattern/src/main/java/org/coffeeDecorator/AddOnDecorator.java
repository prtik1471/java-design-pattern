package org.coffeeDecorator;

public abstract class AddOnDecorator implements Beverage{
    public Beverage wrapped;

    public AddOnDecorator(Beverage beverage) {
        this.wrapped = beverage;
    }

    public abstract String getDescription();
}

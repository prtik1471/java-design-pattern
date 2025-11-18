package org.coffeeDecorator;

public class Application {
    public static void main(String[] args) {
        Beverage order = new Espresso();
        order = new MilkDecorator(order);
        order = new SugarDecorator(order);

        System.out.println("description: " + order.getDescription());
        System.out.println("cost: " + order.cost());
        
    }
}

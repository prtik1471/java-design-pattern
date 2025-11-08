package org.paymentStrategy.strategies;

public class PaymentByCard implements PaymentStrategy{
    @Override
    public String getStrategy() {
        return "card strategy";
    }

    @Override
    public boolean validatePaymentDetails() {
        System.out.println("card details validated");
        return true;
    }

    @Override
    public boolean pay(int amount) {
        System.out.println("paid amount: " + amount + " using card");
        return true;
    }
}

package org.paymentStrategy.strategies;

public class PaymentByUPI implements PaymentStrategy {
    @Override
    public String getStrategy() {
        return "UPI strategy";
    }

    @Override
    public boolean validatePaymentDetails() {
        System.out.println("validated UPI");
        return true;
    }

    @Override
    public boolean pay(int amount) {
        System.out.println("paid amount: " + amount + " using UPI");
        return true;
    }
}

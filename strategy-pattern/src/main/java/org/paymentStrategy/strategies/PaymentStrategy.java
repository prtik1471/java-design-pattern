package org.paymentStrategy.strategies;

public interface PaymentStrategy {
    String getStrategy();
    boolean validatePaymentDetails();
    boolean pay(int amount);
}

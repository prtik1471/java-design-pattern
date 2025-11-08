package org.paymentStrategy;

import org.paymentStrategy.strategies.PaymentStrategy;

public class PaymentService {
    public PaymentStrategy paymentStrategy;

    public PaymentService(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    public void changeStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
        System.out.println("strategy set to " + this.paymentStrategy.getStrategy());
    }

    public void isValidPayment() {
        this.paymentStrategy.validatePaymentDetails();
        return;
    }

    public void payAmount(int amount) {
        this.paymentStrategy.pay(amount);
    }
}

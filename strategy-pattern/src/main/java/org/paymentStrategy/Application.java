package org.paymentStrategy;

import org.paymentStrategy.strategies.PaymentByCard;
import org.paymentStrategy.strategies.PaymentByUPI;
import org.paymentStrategy.strategies.PaymentStrategy;

public class Application {
    public static void main(String args[]) {
        PaymentService paymentService = new PaymentService(new PaymentByCard());
        paymentService.paymentStrategy.getStrategy();
        paymentService.isValidPayment();
        paymentService.payAmount(100);

        System.out.println("changing strategy");

        paymentService.changeStrategy(new PaymentByUPI());
        paymentService.paymentStrategy.getStrategy();
        paymentService.isValidPayment();
        paymentService.payAmount(500);

    }
}

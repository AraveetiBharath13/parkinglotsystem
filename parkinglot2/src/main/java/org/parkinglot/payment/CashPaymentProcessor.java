package org.parkinglot.payment;

public class CashPaymentProcessor implements PaymentProcessor {
    public void processPayment(double amount) {
        System.out.println("Processed cash payment of ₹" + amount);
    }
}
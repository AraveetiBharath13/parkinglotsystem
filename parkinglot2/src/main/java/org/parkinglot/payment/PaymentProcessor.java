package org.parkinglot.payment;

public interface PaymentProcessor {
    void processPayment(double amount);
}
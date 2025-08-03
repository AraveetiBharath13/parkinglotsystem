package org.parkinglot.panels;

import org.parkinglot.displayPanel.ExitDisplayPanel;
import org.parkinglot.entity.ParkingTicket;
import org.parkinglot.payment.PaymentProcessor;


public class ExitPanel {
    private final ExitDisplayPanel displayPanel;
    private final PaymentProcessor paymentProcessor;

    public ExitPanel(PaymentProcessor paymentProcessor) {
        this.displayPanel = new ExitDisplayPanel();
        this.paymentProcessor = paymentProcessor;
    }

    public void unparkVehicle(ParkingTicket ticket) {
        if (ticket == null || ticket.getSpot() == null) return;

        long duration = (System.currentTimeMillis() - ticket.getEntryTime()) / 1000; // seconds
        double cost = 50.0 + duration * 0.1; // base rate
        ticket.getSpot().removeVehicle();

        paymentProcessor.processPayment(cost);
        displayPanel.displayCost(ticket.getVehicle(), cost);
    }
}
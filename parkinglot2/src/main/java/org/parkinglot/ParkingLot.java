package org.parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.parkinglot.entity.ParkingFloor;
import org.parkinglot.entity.ParkingTicket;
import org.parkinglot.panels.EntryPanel;
import org.parkinglot.panels.ExitPanel;
import org.parkinglot.parkingStrategy.ParkingStrategy;
import org.parkinglot.payment.CardPaymentProcessor;
import org.parkinglot.payment.PaymentProcessor;


public class ParkingLot {
    private final List<ParkingFloor> floors;
    private final EntryPanel entryPanel;
    private ExitPanel exitPanel;
    private final Map<String, ParkingTicket> activeTickets = new HashMap<>();

    public ParkingLot(ParkingStrategy strategy) {
        this.floors = new ArrayList<>();
        this.entryPanel = new EntryPanel(strategy);
        this.exitPanel = new ExitPanel(new CardPaymentProcessor());
    }

    public void addFloor(ParkingFloor floor) {
        floors.add(floor);
    }

    public List<ParkingFloor> getFloors() {
        return floors;
    }

    public EntryPanel getEntryPanel() {
        return entryPanel;
    }

    public ExitPanel getExitPanel() {
        return exitPanel;
    }

    public void changeStrategy(ParkingStrategy strategy) {
        entryPanel.changeStrategy(strategy);
    }

    public void issueTicket(ParkingTicket ticket) {
        activeTickets.put(ticket.getTicketId(), ticket);
    }

    public ParkingTicket getTicket(String ticketId) {
        return activeTickets.get(ticketId);
    }

    public void setExitPanel(ExitPanel exitPanel) {
        this.exitPanel = exitPanel;
    }


    public void isParkingLotFull() {
        for (ParkingFloor floor : floors) {
            if (!floor.isFull()) {
                System.out.println("Parking lot is not full.");
                return;
            }
        }
        System.out.println("Parking lot is full.");
    }

}

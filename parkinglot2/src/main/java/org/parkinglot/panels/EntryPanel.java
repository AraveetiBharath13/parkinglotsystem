package org.parkinglot.panels;

import org.parkinglot.ParkingLot;
import org.parkinglot.displayPanel.EntryDisplayPanel;
import org.parkinglot.entity.ParkingSpot;
import org.parkinglot.entity.ParkingTicket;
import org.parkinglot.entity.Vehicle;
import org.parkinglot.exception.SpotNotFoundException;
import org.parkinglot.parkingStrategy.ParkingStrategy;


public class EntryPanel {
    private ParkingStrategy strategy;
    private final EntryDisplayPanel displayPanel;
    private int ticketCounter = 0;

    public EntryPanel(ParkingStrategy strategy) {
        this.strategy = strategy;
        this.displayPanel = new EntryDisplayPanel();
    }

    public void changeStrategy(ParkingStrategy strategy) {
        this.strategy = strategy;
    }

    public ParkingTicket parkVehicle(Vehicle vehicle, ParkingLot parkingLot) throws SpotNotFoundException {
        ParkingSpot spot = strategy.findSpot(vehicle, parkingLot);
        ParkingTicket ticket = null;
        if (spot != null) {
            spot.parkVehicle(vehicle);
            ticket = new ParkingTicket("TICKET-" + (++ticketCounter), vehicle, spot);
            parkingLot.issueTicket(ticket);
        }else {
        	throw new SpotNotFoundException("ParkingLot is full for Vehicle: "+vehicle.getLicenseNumber());
        }
        displayPanel.displayTicketIssued(ticket);
        return ticket;
    }
}
package org.parkinglot.displayPanel;

import org.parkinglot.entity.ParkingSpot;
import org.parkinglot.entity.ParkingTicket;
import org.parkinglot.entity.Vehicle;


public class EntryDisplayPanel extends DisplayPanel {
    public void displaySpotAssigned(Vehicle vehicle, ParkingSpot spot) {
        if (spot != null) {
            System.out.println("Display @Entry: Assigned Spot " + spot.getId() + " to vehicle " + vehicle.getLicenseNumber());
        } else {
            System.out.println("Display @Entry: No spot available for vehicle " + vehicle.getLicenseNumber());
        }
    }

    @Override
    public void display() {
        // Optional - default display
        System.out.println("Display @Entry: Welcome to the Parking Lot");
    }

  public void displayTicketIssued(ParkingTicket ticket) {
        if (ticket != null) {
            System.out.println("Display @Entry: Ticket issued with ID " + ticket.getTicketId() + " for vehicle " + ticket.getVehicle().getLicenseNumber());
        } else {
            System.out.println("Display @Entry: Ticket could not be issued.");
        }
  }
}

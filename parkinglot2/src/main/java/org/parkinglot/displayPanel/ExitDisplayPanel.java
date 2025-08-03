package org.parkinglot.displayPanel;

import org.parkinglot.entity.Vehicle;


public class ExitDisplayPanel extends DisplayPanel {
    public void displayCost(Vehicle vehicle, double cost) {
        System.out.println("Display @Exit: Vehicle " + vehicle.getLicenseNumber() + " - Total cost: ₹" + cost);
    }

    @Override
    public void display() {
        System.out.println("Display @Exit: Thank you! Drive safe.");
    }
}

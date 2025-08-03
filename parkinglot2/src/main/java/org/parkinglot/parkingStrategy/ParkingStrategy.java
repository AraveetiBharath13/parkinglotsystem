package org.parkinglot.parkingStrategy;

import org.parkinglot.ParkingLot;
import org.parkinglot.entity.ParkingSpot;
import org.parkinglot.entity.Vehicle;


public interface ParkingStrategy {
    ParkingSpot findSpot(Vehicle vehicle, ParkingLot parkingLot);
}
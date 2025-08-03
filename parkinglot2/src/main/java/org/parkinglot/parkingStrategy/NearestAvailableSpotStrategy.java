package org.parkinglot.parkingStrategy;

import java.util.List;

import org.parkinglot.ParkingLot;
import org.parkinglot.entity.ParkingFloor;
import org.parkinglot.entity.ParkingSpot;
import org.parkinglot.entity.Vehicle;


public class NearestAvailableSpotStrategy implements ParkingStrategy {
  @Override
  public ParkingSpot findSpot(Vehicle vehicle, ParkingLot parkingLot) {
    for (ParkingFloor floor : parkingLot.getFloors()) {
      if (floor.isUnderMaintenance()) continue;
      ParkingSpot spot = floor.getAvailableSpot(vehicle);
      if (spot != null) return spot;
    }
    return null;
  }
}

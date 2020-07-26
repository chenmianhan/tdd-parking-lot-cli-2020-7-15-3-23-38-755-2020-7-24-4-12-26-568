package com.oocl.cultivation;

import java.util.List;

public class SuperSmartParkingBoy extends MultiplyParkingLotParkingBoy {

    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    protected Ticket parkingStrategy(Car car) {
        double higherAvailablePositionRate = 0;
        ParkingLot higherAvailablePositionRateParkingLot = parkingLots.get(0);
        for (ParkingLot parkLot : parkingLots) {
            if (parkLot.getAvailablePositionRate() > higherAvailablePositionRate) {
                higherAvailablePositionRateParkingLot = parkLot;
                higherAvailablePositionRate = parkLot.getAvailablePositionRate();
            }
        }

        Ticket ticket = higherAvailablePositionRateParkingLot.park(car);
        ticketParkingLotMap.put(ticket, higherAvailablePositionRateParkingLot);
        return ticket;
    }
}

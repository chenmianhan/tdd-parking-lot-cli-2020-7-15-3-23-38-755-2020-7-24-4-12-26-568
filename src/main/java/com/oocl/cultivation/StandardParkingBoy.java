package com.oocl.cultivation;

import java.util.List;

public class StandardParkingBoy extends MultiplyParkingLotParkingBoy {

    public StandardParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    protected Ticket parkingStrategy(Car car) {
        for (ParkingLot parkLot : parkingLots) {
            if (!parkLot.isFull()) {
                Ticket ticket= parkLot.park(car);
                ticketParkingLotMap.put(ticket,parkLot);
                return ticket;
            }
        }
        return null;
    }
}
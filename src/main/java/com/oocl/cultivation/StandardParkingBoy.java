package com.oocl.cultivation;

import java.util.List;

public class StandardParkingBoy {

    private final List<ParkingLot> parkingLots;

    public StandardParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) {
        Ticket ticket = null;
        for (ParkingLot parkLot : parkingLots) {
            if (!parkLot.isFull()) {
                ticket = parkLot.park(car);
                break;
            }

        }
        return ticket;
    }

    public Car fetch(Ticket carTicket) {
        return null;
    }
}
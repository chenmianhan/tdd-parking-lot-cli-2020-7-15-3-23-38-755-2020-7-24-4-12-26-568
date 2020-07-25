package com.oocl.cultivation;

import java.util.List;

public class StandardParkingBoy {

    private final List<ParkingLot> parkingLots;
    public StandardParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots=parkingLots;
    }

    public Ticket park(Car car) {
       Ticket ticket= parkingLots.get(0).park(car);
        return ticket;
    }

}
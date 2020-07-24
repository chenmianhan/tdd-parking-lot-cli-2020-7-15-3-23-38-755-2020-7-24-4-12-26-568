package com.oocl.cultivation;


import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final Map<Ticket, Car> parkingMap = new HashMap<>();
    private final int capacity;

    public ParkingLot(int i) {
        capacity = i;
    }

    public ParkingLot() {
        capacity = 10;
    }

    public Ticket park(Car car) {
        if (capacity <= parkingMap.size()) return null;
        Ticket carTicket = new Ticket();
        parkingMap.put(carTicket, car);
        return carTicket;
    }

    public Car fetch(Ticket carTicket) {
        return parkingMap.remove(carTicket);
    }
}

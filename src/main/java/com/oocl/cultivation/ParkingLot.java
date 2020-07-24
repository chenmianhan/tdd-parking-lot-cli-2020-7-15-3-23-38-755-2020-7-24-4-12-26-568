package com.oocl.cultivation;


import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private final Map<Ticket,Car> parkingMap=new HashMap<>();
    public Ticket park(Car car) {
        Ticket carTicket=new Ticket();
        parkingMap.put(carTicket,car);
        return carTicket;
    }

    public Car fetch(Ticket carTicket) {
        return parkingMap.get(carTicket);
    }
}

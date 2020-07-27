package com.oocl.cultivation;


import java.util.HashMap;
import java.util.Map;

public class ParkingLot implements Parkable {
    private final Map<Ticket, Car> parkingMap;
    private final int capacity;

    public ParkingLot(int i) {
        capacity = i;
        parkingMap = new HashMap<>();
    }

    public ParkingLot() {
        capacity = 10;
        parkingMap = new HashMap<>();
    }

    @Override
    public Ticket park(Car car) {
        Ticket carTicket = new Ticket();
        parkingMap.put(carTicket, car);
        return carTicket;
    }

    public Car fetch(Ticket carTicket) {
        return parkingMap.remove(carTicket);
    }


    public boolean isNotFull() {
        return capacity > parkingMap.size();
    }

    public int getCurStock() {
        return parkingMap.size();
    }

    public int getEmptyPosition() {
        return capacity-parkingMap.size();
    }

    public double getAvailablePositionRate() {
        return (capacity - parkingMap.size()) / (double) capacity;
    }
}

package com.oocl.cultivation;


import java.util.LinkedList;
import java.util.List;

public class Manager extends ParkingBoy {
    private List<ParkingBoy> parkingBoys = new LinkedList<>();

    public Manager(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    public void addParkingBoy(ParkingBoy parkingBoy) {
        parkingBoys.add(parkingBoy);
    }

    public List<ParkingBoy> getParkingBotList() {
        return parkingBoys;
    }

    public Ticket park(ParkingBoy parkingBoy, Car car) {
        return parkingBoy.park(car);
    }

    public Car fetch(ParkingBoy parkingBoy, Ticket ticket) throws FetchException {
        return parkingBoy.fetch(ticket);
    }
}

package com.oocl.cultivation;


import java.util.LinkedList;
import java.util.List;

public class Manager extends ParkingBoy {
    private List<ParkingBoy> parkingBoys = new LinkedList<>();

    public Manager(Parkable... parkables) {
        super(parkables);
    }

    public void addParkingBoy(ParkingBoy parkingBoy) {
        parkingBoys.add(parkingBoy);
    }



    public Car fetch(ParkingBoy parkingBoy, Ticket ticket) throws FetchException {
        return parkingBoy.fetch(ticket);
    }
}

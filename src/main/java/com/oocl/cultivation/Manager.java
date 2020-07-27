package com.oocl.cultivation;


import java.util.LinkedList;
import java.util.List;

public class Manager extends ParkingBoy {

    public Manager(Parkable... parkables) {
        super(parkables);
        List<Parkable> newParkables = new LinkedList<>();
        for (Parkable parkable : parkables) newParkables.add(parkable);
        this.parkables = newParkables;
    }

    public void addParkingBoy(ParkingBoy parkingBoy) {
        parkables.add(parkingBoy);
    }

    @Override
    protected Ticket parkingStrategy(Car car) throws ParkingException {
        for (Parkable parkable : parkables) {
            if (parkable.isNotFull())
                return parkable.park(car);
        }
        return null;
    }

    public Car fetch(ParkingBoy parkingBoy, Ticket ticket) throws FetchException {
        return parkingBoy.fetch(ticket);
    }
}

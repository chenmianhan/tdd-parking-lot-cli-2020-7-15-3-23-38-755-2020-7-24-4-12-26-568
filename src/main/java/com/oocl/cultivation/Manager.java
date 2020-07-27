package com.oocl.cultivation;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Manager extends ParkingBoy {

    public Manager(Parkable... parkables) {
        super(parkables);
        List<Parkable> newParkables = new LinkedList<>(Arrays.asList(parkables));
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

    @Override
    public Car fetch(Ticket ticket) throws FetchException {
        for (Parkable parkable : parkables) {
            if (parkable.isTicketRight(ticket)) {
                return parkable.fetch(ticket);
            }
        }
        return null;
    }
}

package com.oocl.cultivation;


public class Manager extends ParkingBoy {

    public Manager(Parkable... parkables) {
        super(parkables);
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
